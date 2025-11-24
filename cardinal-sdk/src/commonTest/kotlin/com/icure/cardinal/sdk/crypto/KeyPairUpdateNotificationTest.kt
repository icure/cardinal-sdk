package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.impl.exportSpkiHex
import com.icure.cardinal.sdk.filters.MaintenanceTaskFilters
import com.icure.cardinal.sdk.model.DecryptedMaintenanceTask
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.sdk.KeyPairUpdateNotification
import com.icure.cardinal.sdk.test.DataOwnerDetails
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.createPatientUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.currentEpochMs
import com.icure.cardinal.sdk.utils.pagination.forEach
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

@OptIn(InternalIcureApi::class)
class KeyPairUpdateNotificationTest : StringSpec({
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	val note = "Some secret note"
	val testStart = currentEpochMs()

	suspend fun CardinalSdk.createDataAndShareWith(
		owner: DataOwnerDetails
	): String =
		patient.createPatient(
			patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					note = note,
					firstName = "John",
					lastName = "Doe",
				),
				delegates = mapOf(owner.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull().id

	suspend fun CardinalSdk.verifyDataAccessible(
		dataId: String
	) =
		patient.getPatient(dataId).shouldNotBeNull().note shouldBe note

	suspend fun CardinalSdk.getMaintenanceTasks(): List<DecryptedMaintenanceTask> {
		val iterator = maintenanceTask.filterMaintenanceTasksBy(MaintenanceTaskFilters.afterDateForSelf(date = testStart - 1000L))
		val tasks = mutableListOf<DecryptedMaintenanceTask>()
		iterator.forEach {
			tasks.add(it)
		}
		return tasks
	}

	suspend fun DataOwnerDetails.checkReceivedMaintenanceTaskAndGiveAccessBack(
		expectedNotification: KeyPairUpdateNotification
	) {
		val api = api(specJob)
		val tasks = api.getMaintenanceTasks()
		tasks shouldHaveSize 1
		val request = KeyPairUpdateNotification.parseFromMaintenanceTask(tasks.first())
		request shouldBe expectedNotification
		api.cardinalMaintenanceTask.applyKeyPairUpdate(expectedNotification)
	}

	suspend fun DataOwnerDetails.checkNoReceivedMaintenanceTask() {
		api(specJob).getMaintenanceTasks().shouldBeEmpty()
	}

	"The api should allow to create any necessary keypair update notifications and to use them to give access back to data".config(enabled = DEFAULT_ENABLED) {
		val user = createHcpUser()
		val toNotifyAsDelegator = createHcpUser()
		val toNotifyAsDelegate = createHcpUser()
		val noNotifyBecauseAlreadyGaveAccessBack = createHcpUser()
		val noNotifyBecauseNoExchangeData = createHcpUser()
		val noNotifyBecausePatient = createPatientUser()
		val initialUserApi = user.api(specJob)
		val accessibleAfterGiveAccessBack = listOf(
			initialUserApi.createDataAndShareWith(toNotifyAsDelegator),
			toNotifyAsDelegate.api(specJob).createDataAndShareWith(user),
			initialUserApi.createDataAndShareWith(noNotifyBecauseAlreadyGaveAccessBack)
		)
		initialUserApi.createDataAndShareWith(noNotifyBecausePatient)
		val (apiWithLostKey, newKey) = user.apiWithLostKeys(specJob)
		val newKeySpki = defaultCryptoService.rsa.exportSpkiHex(newKey.public)
		val expectedNotification = KeyPairUpdateNotification(
			newPublicKey = newKeySpki,
			concernedDataOwnerId = user.dataOwnerId
		)
		noNotifyBecauseAlreadyGaveAccessBack.api(specJob).cardinalMaintenanceTask.applyKeyPairUpdate(expectedNotification)
		apiWithLostKey.cardinalMaintenanceTask.createKeyPairUpdateNotificationsToAllDelegationCounterparts(newKeySpki)
		toNotifyAsDelegate.checkReceivedMaintenanceTaskAndGiveAccessBack(expectedNotification)
		toNotifyAsDelegator.checkReceivedMaintenanceTaskAndGiveAccessBack(expectedNotification)
		noNotifyBecauseNoExchangeData.checkNoReceivedMaintenanceTask()
		noNotifyBecausePatient.checkNoReceivedMaintenanceTask()
		val apiAfterGiveAccessBack = user.apiWithKeys(specJob, newKey)
		accessibleAfterGiveAccessBack.forEach { apiAfterGiveAccessBack.verifyDataAccessible(it) }
	}
})
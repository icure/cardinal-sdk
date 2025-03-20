package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.entities.ShamirUpdateRequest
import com.icure.cardinal.sdk.crypto.impl.exportSpkiHex
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.sdk.KeyPairUpdateNotification
import com.icure.cardinal.sdk.test.DataOwnerDetails
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.CoroutineScope

@OptIn(InternalIcureApi::class)
class ShamirKeyRecovery : StringSpec({
	beforeAny { initializeTestEnvironment() }

	suspend fun CoroutineScope.doTest(
		userDetails: DataOwnerDetails,
		shareWith: Set<DataOwnerDetails>,
		askAccessBackTo: Set<DataOwnerDetails>
	) {
		val api = userDetails.api(this)
		val note = "Secret note"
		val createdPatient = api.patient.createPatient(
			api.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = defaultCryptoService.strongRandom.randomUUID(),
					firstName = "John",
					lastName = "Doe",
					note = note
				)
			)
		)
		api.crypto.shamirKeysManager.updateSelfSplits(
			mapOf(userDetails.publicKeySpki.fingerprintV1() to ShamirUpdateRequest(
				notariesIds = shareWith.mapTo(mutableSetOf()) { it.dataOwnerId },
				minShares = askAccessBackTo.size
			)
			),
			emptySet()
		)
		val (lostKeyApi, newKey) = userDetails.apiWithLostKeys(this)
		shouldThrow<EntityEncryptionException> { lostKeyApi.patient.getPatient(createdPatient.id) }
		askAccessBackTo.forEach { giveAccessBackDataOwner ->
			giveAccessBackDataOwner.api(this).cardinalMaintenanceTask.applyKeyPairUpdate(
				KeyPairUpdateNotification(
					concernedDataOwnerId = userDetails.dataOwnerId,
					newPublicKey = defaultCryptoService.rsa.exportSpkiHex(newKey.public)
				)
			)
		}
		val recoveredThroughShamirApi = userDetails.apiWithKeys(this, newKey)
		recoveredThroughShamirApi.patient.getPatient(createdPatient.id).shouldNotBeNull().note shouldBe note
	}

	"Api should automatically load keys recoverable through shamir split on startup (true secret share)" {
		val hcpLosingKey = createHcpUser(useLegacyKey = true)
		val friend1 = createHcpUser(useLegacyKey = true)
		val friend2 = createHcpUser(useLegacyKey = true)
		val friend3 = createHcpUser(useLegacyKey = false)
		val friend4 = createHcpUser(useLegacyKey = false)
		doTest(hcpLosingKey, setOf(friend1, friend2, friend3, friend4), setOf(friend2, friend3))
	}

	"Api should automatically load keys recoverable through shamir split on startup (share with single user)" {
		val hcpLosingKey = createHcpUser(useLegacyKey = true)
		val friend = createHcpUser()
		doTest(hcpLosingKey, setOf(friend), setOf(friend))
	}
})
package com.icure.cardinal.sdk.usecases

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.crypto.CryptoStrategies
import com.icure.cardinal.sdk.crypto.entities.ExchangeDataInjectionDetails
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.CalendarItemFilters
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.createPatientUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.utils.RequestStatusException
import com.icure.kryptom.crypto.CryptoService
import com.icure.kryptom.crypto.defaultCryptoService
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.maps.shouldBeEmpty
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class OnlineAgendaAsKeylessPatient : StringSpec({
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	suspend fun createCalendarItemWithApi(api: CardinalSdk, patientId: String, id: String, startTime: Long): DecryptedCalendarItem {
		val patient = api.patient.encrypted.getPatient(patientId).shouldNotBeNull()
		val secretIds = api.patient.getSecretIdsOf(patient)
		return api.calendarItem.createCalendarItem(
			api.calendarItem.withEncryptionMetadata(
				DecryptedCalendarItem(
					id = defaultCryptoService.strongRandom.randomUUID(),
					startTime = startTime,
				),
				patient,
				secretId = SecretIdUseOption.Use(setOfNotNull(secretIds.keys.firstOrNull())),
				alternateRootDelegateId = id,
			)
		)
	}

	"A keyless patient should be able to create calendar items for an online agenda, with or without secret foreign keys, and an hcp should be able to complete the link when needed" {
		val keylessCryptoStrategies = object : CryptoStrategies {
			override suspend fun generateNewKeyForDataOwner(
				self: DataOwnerWithType,
				cryptoPrimitives: CryptoService
			): CryptoStrategies.KeyGenerationRequestResult {
				return CryptoStrategies.KeyGenerationRequestResult.Keyless
			}
		}
		val patientInfo = createPatientUser(initializeKey = false)
		val patientApi = patientInfo.api(specJob, keylessCryptoStrategies)
		val hcpInfo = createHcpUser()
		val hcpApi = hcpInfo.api(specJob)
		// New patient has no secret id, must initialize first
		patientApi.patient.getSecretIdsOf(patientApi.patient.tryAndRecover.getPatient(patientInfo.dataOwnerId).shouldNotBeNull()).shouldBeEmpty()
		shouldThrow<RequestStatusException> {
			hcpApi.patient.tryAndRecover.getPatient(patientInfo.dataOwnerId)
		}.statusCode shouldBe 403
		val keylessExchangeData1 = patientApi.crypto.keylessCreateExchangeDataTo(hcpInfo.dataOwnerId)
		val firstInitPatient = patientApi.patient.ensureEncryptionMetadataForSelfIsInitialized(
			// Keyless, must provide an alternate root delegate
			alternateRootDelegateId = hcpInfo.dataOwnerId,
			// If this is not a new patient and is already initialized, but we can't access the secret id we don't want to create a new one, we prefer to only do half link
			ignoreIfEncryptionMetadataExists = true
		)
		patientApi.patient.ensureEncryptionMetadataForSelfIsInitialized(
			alternateRootDelegateId = hcpInfo.dataOwnerId,
			ignoreIfEncryptionMetadataExists = true
		) shouldBe firstInitPatient // There should have been no change, the patient was already initialized
		val foundSecretIds = patientApi.patient.getSecretIdsOf(patientApi.patient.getPatient(patientInfo.dataOwnerId).shouldNotBeNull()).shouldHaveSize(1)
		hcpApi.patient.getSecretIdsOf(hcpApi.patient.getPatient(patientInfo.dataOwnerId).shouldNotBeNull()) shouldBe foundSecretIds
		// We can create a doubly-linked calendar item since we have access to the secret id in this api
		val fullyLinkedCalendarItem = createCalendarItemWithApi(patientApi, patientInfo.dataOwnerId, hcpInfo.dataOwnerId, 2025_01_02_12_00_00)
		fullyLinkedCalendarItem.secretForeignKeys shouldBe setOf(foundSecretIds.keys.first())
		patientApi.calendarItem.decryptPatientIdOf(fullyLinkedCalendarItem) shouldBe setOf(EntityReferenceInGroup(patientInfo.dataOwnerId, null))
		hcpApi.calendarItem.decryptPatientIdOf(fullyLinkedCalendarItem) shouldBe setOf(EntityReferenceInGroup(patientInfo.dataOwnerId, null))
		// patient can find by for self, hcp can find by for patient
		patientApi.calendarItem.matchCalendarItemsBy(CalendarItemFilters.byPeriodForSelf(2025_01_01_00_00_00, 2025_01_04_00_00_00)) shouldBe listOf(fullyLinkedCalendarItem.id)
		hcpApi.calendarItem.matchCalendarItemsBy(CalendarItemFilters.byPatientsStartTimeForSelf(listOf(firstInitPatient))) shouldBe listOf(fullyLinkedCalendarItem.id)
		
		val resettedApi = patientInfo.api(specJob, keylessCryptoStrategies)
		resettedApi.patient.ensureEncryptionMetadataForSelfIsInitialized(
			alternateRootDelegateId = hcpInfo.dataOwnerId,
			ignoreIfEncryptionMetadataExists = true
		) shouldBe firstInitPatient // There should have been no change, the patient was already initialized
		// We won't find back the secret id since we miss the exchange data used to create it originally
		resettedApi.patient.getSecretIdsOf(patientApi.patient.getPatient(patientInfo.dataOwnerId).shouldNotBeNull()).shouldBeEmpty()
		val keylessExchangeData2 = resettedApi.crypto.keylessCreateExchangeDataTo(hcpInfo.dataOwnerId)
		val halfLinkedCalendarItem = createCalendarItemWithApi(resettedApi, patientInfo.dataOwnerId, hcpInfo.dataOwnerId, 2025_01_03_12_00_00)
		// No link from patient to calendar item
		halfLinkedCalendarItem.secretForeignKeys shouldBe emptySet()
		// Has link to patient from calendar item
		resettedApi.calendarItem.decryptPatientIdOf(halfLinkedCalendarItem) shouldBe setOf(EntityReferenceInGroup(patientInfo.dataOwnerId, null))
		hcpApi.calendarItem.decryptPatientIdOf(halfLinkedCalendarItem) shouldBe setOf(EntityReferenceInGroup(patientInfo.dataOwnerId, null))

		// Without injecting exchange data from other instances each instance can only see calendar items it created itself
		patientApi.calendarItem.matchCalendarItemsBy(CalendarItemFilters.byPeriodForSelf(2025_01_01_00_00_00, 2025_01_04_00_00_00)) shouldBe listOf(fullyLinkedCalendarItem.id)
		resettedApi.calendarItem.matchCalendarItemsBy(CalendarItemFilters.byPeriodForSelf(2025_01_01_00_00_00, 2025_01_04_00_00_00)) shouldBe listOf(halfLinkedCalendarItem.id)
		patientApi.crypto.injectExchangeData(null, listOf(ExchangeDataInjectionDetails(
			exchangeDataId = keylessExchangeData2.exchangeDataId,
			accessControlSecret = keylessExchangeData2.accessControlSecret,
			exchangeKey = keylessExchangeData2.exchangeKey,
			sharedSignatureKey = keylessExchangeData2.sharedSignatureKey,
			verified = true,
		)), false)
		resettedApi.crypto.injectExchangeData(null, listOf(ExchangeDataInjectionDetails(
			exchangeDataId = keylessExchangeData1.exchangeDataId,
			accessControlSecret = keylessExchangeData1.accessControlSecret,
			exchangeKey = keylessExchangeData1.exchangeKey,
			sharedSignatureKey = keylessExchangeData1.sharedSignatureKey,
			verified = true,
		)), false)
		patientApi.calendarItem.matchCalendarItemsBy(CalendarItemFilters.byPeriodForSelf(2025_01_01_00_00_00, 2025_01_04_00_00_00)) shouldContainExactlyInAnyOrder listOf(fullyLinkedCalendarItem.id, halfLinkedCalendarItem.id)
		resettedApi.calendarItem.matchCalendarItemsBy(CalendarItemFilters.byPeriodForSelf(2025_01_01_00_00_00, 2025_01_04_00_00_00)) shouldContainExactlyInAnyOrder listOf(fullyLinkedCalendarItem.id, halfLinkedCalendarItem.id)

		// Without double-link the hcp can't find the calendar item for the patient
		hcpApi.calendarItem.matchCalendarItemsBy(CalendarItemFilters.byPatientsStartTimeForSelf(listOf(firstInitPatient))) shouldBe listOf(fullyLinkedCalendarItem.id)
		hcpApi.calendarItem.modifyCalendarItem(halfLinkedCalendarItem.copy(secretForeignKeys = foundSecretIds.keys)).secretForeignKeys shouldBe foundSecretIds.keys
		hcpApi.calendarItem.matchCalendarItemsBy(CalendarItemFilters.byPatientsStartTimeForSelf(listOf(firstInitPatient))) shouldContainExactlyInAnyOrder listOf(fullyLinkedCalendarItem.id, halfLinkedCalendarItem.id)
	}
})

package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.api.raw.impl.RawHealthcarePartyApiImpl
import com.icure.cardinal.sdk.filters.HealthElementFilters
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.test.DefaultRawApiConfig
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.baseUrl
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.createPatientUser
import com.icure.cardinal.sdk.test.createUserFromExistingPatient
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.superadminAuth
import com.icure.cardinal.sdk.test.testGroupId
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.collections.shouldNotContainAnyOf
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldContain
import io.kotest.matchers.types.shouldBeInstanceOf

@OptIn(InternalIcureApi::class)
class PatientUserTest : StringSpec({
	val specJob = autoCancelJob()
	beforeSpec {
		initializeTestEnvironment()
	}

	"A new user created from an existing patient should be able to create data for himself after initializing the encryption metadata" {
		val hcp1 = createHcpUser()
		val hcp1Api = hcp1.api(specJob)
		val hcp2 = createHcpUser()
		val hcp2Api = hcp2.api(specJob)
		val patientDetails = createUserFromExistingPatient(
			hcp1Api.patient.createPatient(
				hcp1Api.patient.withEncryptionMetadata(
					DecryptedPatient(
						id = defaultCryptoService.strongRandom.randomUUID(),
						firstName = "John",
						lastName = "Doe",
						note = "This note will not be visible to the patient"
					),
					delegates = mapOf(hcp2.dataOwnerId to AccessLevel.Write)
				)
			).shouldNotBeNull()
		)
		val patientApi = patientDetails.api(specJob)

		// Data owner api does not decrypt, so we can use that since the current patient can't decrypt his own info
		val uninitializedPatient = patientApi.dataOwner.getCurrentDataOwner().shouldBeInstanceOf<DataOwnerWithType.PatientDataOwner>().dataOwner
		shouldThrow<IllegalArgumentException> {
			patientApi.healthElement.withEncryptionMetadata(
				DecryptedHealthElement(
					id = defaultCryptoService.strongRandom.randomUUID(),
					note = "Some note"
				),
				uninitializedPatient,
				patientApi.user.getCurrentUser(),
			)
		}
		val initializedPatient = patientApi.patient.ensureEncryptionMetadataForSelfIsInitialized(
			mapOf(hcp2.dataOwnerId to AccessLevel.Read)
		)
		patientApi.patient.encrypted.getPatient(patientDetails.dataOwnerId) shouldBe initializedPatient
		// Patient shouldn't be able to access his encryption key, it was created by someone else
		patientApi.patient.tryDecrypt(listOf(initializedPatient)).single().shouldBeInstanceOf<EncryptedPatient>()
		val createdData = patientApi.healthElement.createHealthElement(
			patientApi.healthElement.withEncryptionMetadata(
				DecryptedHealthElement(
					id = defaultCryptoService.strongRandom.randomUUID(),
					note = "Some note"
				),
				initializedPatient,
				patientApi.user.getCurrentUser(),
			)
		).shouldNotBeNull()
		// The patient should be able to find back his data
		patientApi.healthElement.filterHealthElementsBy(
			HealthElementFilters.byPatientsForSelf(listOf(initializedPatient))
		).next(5).shouldHaveSize(1).first().note.shouldNotBeNull() shouldBe createdData.note
		// Hcp 2 should find the secret ids created both by hcp1 and the patient
		hcp2Api.patient.getSecretIdsOf(initializedPatient).keys.shouldHaveSize(2).shouldContainAll(createdData.secretForeignKeys)
		// Hcp 1 shouldn't find the secret id created by patient
		hcp1Api.patient.getSecretIdsOf(initializedPatient).keys.shouldHaveSize(1).shouldNotContainAnyOf(createdData.secretForeignKeys)
	}

	"A new patient user should be able to initialize his encryption metadata" {
		val patientDetails = createPatientUser()
		val patientApi = patientDetails.api(specJob)
		patientApi.patient.tryAndRecover.getPatient(patientDetails.dataOwnerId).shouldBeInstanceOf<EncryptedPatient>()
		val initializedEncryptedPatient = patientApi.patient.ensureEncryptionMetadataForSelfIsInitialized()
		patientApi.patient.encrypted.getPatient(patientDetails.dataOwnerId) shouldBe initializedEncryptedPatient
		val initializedPatient = patientApi.patient.decrypt(listOf(initializedEncryptedPatient)).single()
		val updatedPatient = patientApi.patient.modifyPatient(initializedPatient.copy(note = "My secret note"))
		updatedPatient.rev shouldNotBe initializedPatient.rev
		patientApi.patient.getPatient(updatedPatient.id).shouldNotBeNull().note shouldBe "My secret note"
		val createdData = patientApi.healthElement.createHealthElement(
			patientApi.healthElement.withEncryptionMetadata(
				DecryptedHealthElement(
					id = defaultCryptoService.strongRandom.randomUUID(),
					note = "Some note"
				),
				initializedPatient,
				patientApi.user.getCurrentUser(),
			)
		).shouldNotBeNull()
		// The patient should be able to find back his data
		patientApi.healthElement.filterHealthElementsBy(
			HealthElementFilters.byPatientsForSelf(listOf(initializedPatient))
		).next(5).shouldHaveSize(1).first().note.shouldNotBeNull() shouldBe createdData.note
	}

	"A new patient user should be able to initialize his encryption metadata and share with another user" {
		val patientDetails = createPatientUser()
		val hcpDetails = createHcpUser()
		val hcpApi = hcpDetails.api(specJob)
		val patientApi = patientDetails.api(specJob)
		patientApi.patient.tryAndRecover.getPatient(patientDetails.dataOwnerId).shouldBeInstanceOf<EncryptedPatient>()
		val initializedEncryptedPatient = patientApi.patient.ensureEncryptionMetadataForSelfIsInitialized(mapOf(hcpDetails.dataOwnerId to AccessLevel.Write))
		patientApi.patient.encrypted.getPatient(patientDetails.dataOwnerId) shouldBe initializedEncryptedPatient
		val initializedPatient = patientApi.patient.decrypt(listOf(initializedEncryptedPatient)).single()
		val updatedPatient = patientApi.patient.modifyPatient(initializedPatient.copy(note = "My secret note"))
		updatedPatient.rev shouldNotBe initializedPatient.rev
		patientApi.patient.getPatient(updatedPatient.id).shouldNotBeNull().note shouldBe "My secret note"
		hcpApi.patient.getPatient(updatedPatient.id) shouldBe updatedPatient
		val createdData = patientApi.healthElement.createHealthElement(
			patientApi.healthElement.withEncryptionMetadata(
				DecryptedHealthElement(
					id = defaultCryptoService.strongRandom.randomUUID(),
					note = "Some note"
				),
				initializedPatient,
				patientApi.user.getCurrentUser(),
				mapOf(hcpDetails.dataOwnerId to AccessLevel.Write)
			)
		).shouldNotBeNull()
		// The patient should be able to find back his data
		patientApi.healthElement.filterHealthElementsBy(
			HealthElementFilters.byPatientsForSelf(listOf(initializedPatient))
		).next(5).shouldHaveSize(1).first().note.shouldNotBeNull() shouldBe createdData.note
		hcpApi.healthElement.filterHealthElementsBy(
			HealthElementFilters.byPatientsForSelf(listOf(initializedPatient))
		).next(5).shouldHaveSize(1).first().note.shouldNotBeNull() shouldBe createdData.note
	}

	"Initializing the encryption metadata for a new patient user should fail with appropriate exception if attempting to share with hcp that has no key" {
		val hcpRawApi = RawHealthcarePartyApiImpl(baseUrl, superadminAuth, DefaultRawApiConfig)
		val hcpId = defaultCryptoService.strongRandom.randomUUID()
		hcpRawApi.createHealthcarePartyInGroup(
			testGroupId,
			HealthcareParty(
				hcpId,
				firstName = "Hcp-$hcpId",
				lastName = "Hcp-$hcpId",
			)
		).successBody()
		val patientDetails = createPatientUser()
		val patientApi = patientDetails.api(specJob)
		shouldThrow<IllegalArgumentException> {
			patientApi.patient.ensureEncryptionMetadataForSelfIsInitialized(
				mapOf(hcpId to AccessLevel.Write)
			)
		}.message.shouldNotBeNull().lowercase().also {
			it shouldContain "delegate"
			it shouldContain "keys"
			it shouldContain hcpId
		}
	}
})

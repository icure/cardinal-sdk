package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.filters.HealthElementFilters
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.createPatientUser
import com.icure.cardinal.sdk.test.createUserFromExistingPatient
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.kryptom.crypto.defaultCryptoService
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.collections.shouldNotContainAnyOf
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldBeInstanceOf

class PatientUserTest : StringSpec({
	beforeAny {
		initializeTestEnvironment()
	}

	"A new user created from an existing patient should be able to create data for himself after initializing the encryption metadata" {
		val hcp1 = createHcpUser()
		val hcp1Api = hcp1.api()
		val hcp2 = createHcpUser()
		val hcp2Api = hcp2.api()
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
		val patientApi = patientDetails.api()
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
		// Patient shouldn't be able to access his encryption key, it was created by someone else
		patientApi.patient.tryDecrypt(initializedPatient).shouldBeInstanceOf<EncryptedPatient>()
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
		hcp2Api.patient.getSecretIdsOf(initializedPatient).shouldHaveSize(2).shouldContainAll(createdData.secretForeignKeys)
		// Hcp 1 shouldn't find the secret id created by patient
		hcp1Api.patient.getSecretIdsOf(initializedPatient).shouldHaveSize(1).shouldNotContainAnyOf(createdData.secretForeignKeys)
	}

	"A new patient user should be able to initialize his encryption metadata" {
		val patientDetails = createPatientUser()
		val patientApi = patientDetails.api()
		patientApi.patient.tryAndRecover.getPatient(patientDetails.dataOwnerId).shouldBeInstanceOf<EncryptedPatient>()
		val initializedEncryptedPatient = patientApi.patient.ensureEncryptionMetadataForSelfIsInitialized()
		val initializedPatient = patientApi.patient.decrypt(initializedEncryptedPatient)
		val updatedPatient = patientApi.patient.modifyPatient(initializedPatient.copy(note = "My secret note"))
		updatedPatient.rev shouldNotBe initializedPatient.rev
		patientApi.patient.getPatient(updatedPatient.id).note shouldBe "My secret note"
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
})
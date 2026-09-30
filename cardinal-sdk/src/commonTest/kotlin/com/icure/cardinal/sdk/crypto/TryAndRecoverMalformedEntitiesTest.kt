package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.filters.PatientFilters
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.embed.DecryptedInsurability
import com.icure.cardinal.sdk.model.embed.EncryptedInsurability
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.options.SdkOptions
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.base64Encode
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.ktor.utils.io.core.toByteArray
import kotlinx.serialization.SerializationException

class TryAndRecoverMalformedEntitiesTest : StringSpec({
	val specJob = autoCancelJob()
	lateinit var sdk: CardinalSdk

	beforeSpec {
		initializeTestEnvironment()
		val hcp = createHcpUser()
		println("Testing in group: " + hcp.groupId)
		sdk = hcp.api(specJob, options = SdkOptions())
	}

	suspend fun createValidPatient(): DecryptedPatient =
		sdk.patient.createPatient(
			sdk.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = uuid(),
					firstName = "John",
					lastName = "Doe",
					insurabilities = listOf(
						DecryptedInsurability(parameters = mapOf("medicalHouse.periodStart" to "20260101")),
					),
				),
			),
		)

	// The insurability decrypts to a json that doesn't match the model: `parameters` is a Map<String, String>, but the
	// value is null (as written by a client that doesn't use the sdk models). The encrypted patient itself is valid.
	suspend fun createMalformedPatient(): EncryptedPatient {
		val patient = createValidPatient()
		val encryptionKey = defaultCryptoService.aes.loadKey(
			AesAlgorithm.CbcWithPkcs7Padding,
			sdk.patient.getEncryptionKeysOf(patient).shouldHaveSize(1).single().decodedBytes(),
		)
		val encryptedPatient = sdk.patient.encrypted.getPatient(patient.id).shouldNotBeNull()
		return sdk.patient.encrypted.modifyPatient(
			encryptedPatient.copy(
				insurabilities = listOf(
					EncryptedInsurability(
						encryptedSelf = Base64String(
							base64Encode(
								defaultCryptoService.aes.encrypt(
									// language=JSON
									"""{"parameters":{"medicalHouse.periodStart":null}}""".toByteArray(),
									encryptionKey,
								),
							),
						),
					),
				),
			),
		)
	}

	"Decrypting a patient with a malformed decrypted content should fail on the default flavour" {
		val validPatient = createValidPatient()
		val malformedPatient = createMalformedPatient()
		shouldThrow<SerializationException> { sdk.patient.getPatient(malformedPatient.id) }
		shouldThrow<SerializationException> { sdk.patient.decrypt(listOf(malformedPatient)) }
		// A single malformed patient makes the whole request fail
		shouldThrow<SerializationException> { sdk.patient.getPatients(listOf(validPatient.id, malformedPatient.id)) }
		shouldThrow<SerializationException> {
			sdk.patient.filterPatientsBy(PatientFilters.byIds(listOf(validPatient.id, malformedPatient.id))).next(10)
		}
	}

	"The tryAndRecover flavour should return a patient with a malformed decrypted content as encrypted" {
		val malformedPatient = createMalformedPatient()
		sdk.patient.tryAndRecover.getPatient(malformedPatient.id).shouldBeInstanceOf<EncryptedPatient>() shouldBe malformedPatient
		sdk.patient.tryDecrypt(listOf(malformedPatient)).single().shouldBeInstanceOf<EncryptedPatient>() shouldBe malformedPatient
	}

	"The tryAndRecover flavour should still decrypt the valid patients retrieved together with a malformed one" {
		val validPatient1 = createValidPatient()
		val malformedPatient = createMalformedPatient()
		val validPatient2 = createValidPatient()
		val ids = listOf(validPatient1.id, malformedPatient.id, validPatient2.id)

		val retrievedById = sdk.patient.tryAndRecover.getPatients(ids).shouldHaveSize(3).associateBy { it.id }
		retrievedById.getValue(validPatient1.id).shouldBeInstanceOf<DecryptedPatient>() shouldBe validPatient1
		retrievedById.getValue(malformedPatient.id).shouldBeInstanceOf<EncryptedPatient>() shouldBe malformedPatient
		retrievedById.getValue(validPatient2.id).shouldBeInstanceOf<DecryptedPatient>() shouldBe validPatient2

		val filteredById = sdk.patient.tryAndRecover.filterPatientsBy(PatientFilters.byIds(ids)).next(10).shouldHaveSize(3).associateBy { it.id }
		filteredById.getValue(validPatient1.id).shouldBeInstanceOf<DecryptedPatient>() shouldBe validPatient1
		filteredById.getValue(malformedPatient.id).shouldBeInstanceOf<EncryptedPatient>() shouldBe malformedPatient
		filteredById.getValue(validPatient2.id).shouldBeInstanceOf<DecryptedPatient>() shouldBe validPatient2
	}
})

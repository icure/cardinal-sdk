package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedAnnotation
import com.icure.cardinal.sdk.model.embed.EncryptedContent
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.options.SdkOptions
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.base64Encode
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.maps.shouldBeEmpty
import io.kotest.matchers.maps.shouldHaveSize
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.ktor.utils.io.core.toByteArray

class IgnoreDecryptedUnknownFields : StringSpec({
	val specJob = autoCancelJob()
	lateinit var strictSdk: CardinalSdk
	lateinit var ignoringSdk: CardinalSdk
	lateinit var patient: DecryptedPatient

	beforeSpec {
		initializeTestEnvironment()
		val hcp = createHcpUser()
		println("Testing in group: " + hcp.groupId)
		strictSdk = hcp.api(specJob, options = SdkOptions())
		ignoringSdk = hcp.api(specJob, options = SdkOptions(ignoreUnknownFields = true))
		patient = strictSdk.patient.createPatient(
			strictSdk.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = uuid(),
					firstName = "John",
					lastName = "Doe"
				)
			)
		)
	}

	suspend fun initializeTestPatient() : TestInfo {
		val patient = strictSdk.patient.createPatient(
			strictSdk.patient.withEncryptionMetadata(
				DecryptedPatient(
					id = uuid(),
					firstName = "John",
					lastName = "Doe"
				)
			)
		)
		val encryptionKey = defaultCryptoService.aes.loadKey(
			AesAlgorithm.CbcWithPkcs7Padding,
			strictSdk.patient.getEncryptionKeysOf(patient).shouldHaveSize(1).single().decodedBytes()
		)
		return TestInfo(
			id = patient.id,
			encryptionKey = encryptionKey
		)
	}

	"An encryptable entity with an invalid decrypted field on root should throw an exception on decryption if ignoreUnknownFields is set to the default, and decrypt without issues if set" {
		val patientInfo = initializeTestPatient()
		val encryptedPatient = strictSdk.patient.encrypted.getPatient(patientInfo.id).shouldNotBeNull()
		strictSdk.patient.encrypted.modifyPatient(
			encryptedPatient.copy(
				encryptedSelf = patientInfo.encryptData(
					// language=JSON
					"""{"note":"Some encrypted note","unknown":"ignored or throws"}"""
				)
			)
		)
		shouldThrow<EntityEncryptionException> { strictSdk.patient.getPatient(encryptedPatient.id) }
		ignoringSdk.patient.getPatient(encryptedPatient.id).shouldNotBeNull().note shouldBe "Some encrypted note"
	}

	"An encryptable entity with an invalid decrypted field on embedded entity should throw an exception on decryption if ignoreUnknownFields is set to the default, and decrypt without issues if set" {
		val patientInfo = initializeTestPatient()
		val encryptedPatient = strictSdk.patient.encrypted.getPatient(patientInfo.id).shouldNotBeNull()
		strictSdk.patient.encrypted.modifyPatient(
			encryptedPatient.copy(
				notes = listOf(
					EncryptedAnnotation(
						id = "1",
						encryptedSelf = patientInfo.encryptData(
							// language=JSON
							"""{"markdown":{"en":"Some encrypted note"},"unknown":"ignored or throws"}"""
						)
					)
				)
			)
		)
		shouldThrow<EntityEncryptionException> { strictSdk.patient.getPatient(encryptedPatient.id) }
		ignoringSdk.patient.getPatient(encryptedPatient.id).shouldNotBeNull().notes.shouldHaveSize(1).single().markdown.shouldHaveSize(1).getValue("en") shouldBe "Some encrypted note"
	}

	suspend fun initializeTestContact(withService: Boolean = false): TestInfo {
		val contact = strictSdk.contact.createContact(
			strictSdk.contact.withEncryptionMetadata(
				DecryptedContact(
					id = uuid(),
					services = if (withService) setOf(DecryptedService(id = uuid())) else emptySet()
				),
				patient
			)
		)
		val encryptionKey = defaultCryptoService.aes.loadKey(
			AesAlgorithm.CbcWithPkcs7Padding,
			strictSdk.contact.getEncryptionKeysOf(contact).shouldHaveSize(1).single().decodedBytes()
		)
		return TestInfo(
			id = contact.id,
			encryptionKey = encryptionKey
		)
	}

	// Contact behaves like any other encryptable entity for its own root fields, but unlike Patient's
	// Annotation its embedded Services are each individually Encryptable, with their own encryptedSelf
	// decrypted separately from the root - this is the part of the internal implementation worth
	// covering specifically for Contact.
	"A contact with an invalid decrypted field on root should throw an exception on decryption if ignoreUnknownFields is set to the default, and decrypt without issues if set" {
		val contactInfo = initializeTestContact()
		val encryptedContact = strictSdk.contact.encrypted.getContact(contactInfo.id).shouldNotBeNull()
		strictSdk.contact.encrypted.modifyContact(
			encryptedContact.copy(
				encryptedSelf = contactInfo.encryptData(
					// language=JSON
					"""{"descr":"Some encrypted description","unknown":"ignored or throws"}"""
				)
			)
		)
		shouldThrow<EntityEncryptionException> { strictSdk.contact.getContact(encryptedContact.id) }
		ignoringSdk.contact.getContact(encryptedContact.id).shouldNotBeNull().descr shouldBe "Some encrypted description"
	}

	"A contact with an invalid decrypted field on embedded non-service should throw an exception on decryption if ignoreUnknownFields is set to the default, and decrypt without issues if set" {
		val contactInfo = initializeTestContact()
		val encryptedContact = strictSdk.contact.encrypted.getContact(contactInfo.id).shouldNotBeNull()
		strictSdk.contact.encrypted.modifyContact(
			encryptedContact.copy(
				notes = listOf(
					EncryptedAnnotation(
						id = "1",
						encryptedSelf = contactInfo.encryptData(
							// language=JSON
							"""{"markdown":{"en":"Some encrypted note"},"unknown":"ignored or throws"}"""
						)
					)
				)
			)
		)
		shouldThrow<EntityEncryptionException> { strictSdk.contact.getContact(encryptedContact.id) }
		ignoringSdk.contact.getContact(encryptedContact.id).shouldNotBeNull().notes.shouldHaveSize(1).single().markdown.shouldHaveSize(1).getValue("en") shouldBe "Some encrypted note"
	}

	"A service with an invalid decrypted field should throw an exception on decryption if ignoreUnknownFields is set to the default, and decrypt without issues if set" {
		val contactInfo = initializeTestContact(withService = true)
		val encryptedContact = strictSdk.contact.encrypted.getContact(contactInfo.id).shouldNotBeNull()
		val encryptedService = encryptedContact.services.shouldHaveSize(1).single()
		strictSdk.contact.encrypted.modifyContact(
			encryptedContact.copy(
				services = setOf(
					encryptedService.copy(
						encryptedSelf = contactInfo.encryptData(
							// language=JSON
							"""{"comment":"Some encrypted comment","unknown":"ignored or throws"}"""
						)
					)
				)
			)
		)
		shouldThrow<EntityEncryptionException> { strictSdk.contact.getContact(encryptedContact.id) }
		ignoringSdk.contact.getContact(encryptedContact.id).shouldNotBeNull().services.shouldHaveSize(1).single().comment shouldBe "Some encrypted comment"
	}

	"A service with an invalid content field should throw an exception on decryption if ignoreUnknownFields is set to the default, and decrypt without issues if set" {
		val contactInfo = initializeTestContact(withService = true)
		val encryptedContact = strictSdk.contact.encrypted.getContact(contactInfo.id).shouldNotBeNull()
		val encryptedService = encryptedContact.services.shouldHaveSize(1).single()
		strictSdk.contact.encrypted.modifyContact(
			encryptedContact.copy(
				services = setOf(
					encryptedService.copy(
						encryptedSelf = contactInfo.encryptData(
							// language=JSON
							"""{"content":{"en":{"pen":"pineapple","stringValue":"applepen"}}}"""
						)
					)
				)
			)
		)
		shouldThrow<EntityEncryptionException> { strictSdk.contact.getContact(encryptedContact.id) }
		ignoringSdk.contact.getContact(encryptedContact.id).shouldNotBeNull().services.shouldHaveSize(1).single().content.shouldHaveSize(1).getValue("en") shouldBe
			com.icure.cardinal.sdk.model.embed.DecryptedContent(stringValue = "applepen")
	}


	"A compound service with an invalid content field should throw an exception on decryption if ignoreUnknownFields is set to the default, and decrypt without issues if set" {
		val contactInfo = initializeTestContact(withService = true)
		val encryptedContact = strictSdk.contact.encrypted.getContact(contactInfo.id).shouldNotBeNull()
		val encryptedService = encryptedContact.services.shouldHaveSize(1).single()
		strictSdk.contact.encrypted.modifyContact(
			encryptedContact.copy(
				services = setOf(
					encryptedService.copy(
						content = mapOf(
							"*" to EncryptedContent(
								compoundValue = listOf(
									EncryptedService(
										id = "compound1",
										encryptedSelf = contactInfo.encryptData(
											// language=JSON
											"""{"content":{"en":{"pen":"pineapple","stringValue":"applepen"}}}"""
										)
									)
								)
							)
						)
					)
				)
			)
		).also {
			val compoundService = it.services
				.shouldHaveSize(1).single()
				.content.shouldHaveSize(1).getValue("*")
				.compoundValue.shouldNotBeNull().shouldHaveSize(1).single()
			compoundService.content.shouldBeEmpty()
			compoundService.id shouldBe "compound1"
		}
		shouldThrow<EntityEncryptionException> { strictSdk.contact.getContact(encryptedContact.id) }
		ignoringSdk.contact.getContact(encryptedContact.id).shouldNotBeNull()
			.services.shouldHaveSize(1).single()
			.content.shouldHaveSize(1).getValue("*")
			.compoundValue.shouldNotBeNull().shouldHaveSize(1).single()
			.content.shouldHaveSize(1).getValue("en") shouldBe
			com.icure.cardinal.sdk.model.embed.DecryptedContent(stringValue = "applepen")
	}
})

private data class TestInfo(
	val id: String,
	val encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>
) {
	suspend fun encryptData(data: String) = Base64String(
		base64Encode(
			defaultCryptoService.aes.encrypt(
				data.toByteArray(),
				encryptionKey
			)
		)
	)
}
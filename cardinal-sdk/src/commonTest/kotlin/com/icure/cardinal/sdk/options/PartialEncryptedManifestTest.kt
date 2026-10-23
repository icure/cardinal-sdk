package com.icure.cardinal.sdk.options

import com.icure.cardinal.sdk.crypto.encryptor.BuiltinEntityEncryptionManifest
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class PartialEncryptedManifestTest : StringSpec({
	"Configurable root entities that are not configured should not be supported, other roots should use the base manifests" {
		// Typed as EncryptedFieldsOptions to use the manifests extension rather than the Custom.manifests property
		val options: EncryptedFieldsOptions = EncryptedFieldsOptions.Custom(
			PartialEncryptedManifest(
				manifestsByName = mapOf(
					"CustomPatient" to BuiltinEntityEncryptionManifest(
						fieldsToEncrypt = setOf("note"),
						recursiveEncryption = emptyMap(),
						extensionsManifestsByModelVersion = emptyMap(),
						currentExtensionsManifest = null,
					),
				),
				customEntitiesManifestByEntityTypeId = emptyMap(),
				extensionsManifestsByName = emptyMap(),
				patient = "CustomPatient",
			)
		)
		val manifests = options.manifests
		val defaultManifests = EncryptedFieldsOptions.Default.manifests
		manifests.patient shouldBe "CustomPatient"
		manifests.accessLog.shouldBeNull()
		manifests.calendarItem.shouldBeNull()
		manifests.contact.shouldBeNull()
		manifests.healthElement.shouldBeNull()
		manifests.message.shouldBeNull()
		manifests.topic.shouldBeNull()
		manifests.document.shouldBeNull()
		manifests.relatedPerson.shouldBeNull()
		manifests.form shouldBe defaultManifests.form
		manifests.receipt shouldBe defaultManifests.receipt
		manifests.classification shouldBe defaultManifests.classification
		manifests.invoice shouldBe defaultManifests.invoice
	}

	"Base manifests should support all root entities" {
		listOf(EncryptedFieldsOptions.Default, EncryptedFieldsOptions.Legacy).forEach { options ->
			val manifests = options.manifests
			listOf(
				manifests.accessLog,
				manifests.calendarItem,
				manifests.contact,
				manifests.healthElement,
				manifests.patient,
				manifests.message,
				manifests.topic,
				manifests.document,
				manifests.relatedPerson,
			).forEach { it.shouldNotBeNull() }
		}
	}
})

package com.icure.cardinal.sdk.options

import com.icure.cardinal.sdk.crypto.encryptor.BuiltinRootEntityEncryptionManifest
import com.icure.cardinal.sdk.crypto.encryptor.EncryptorOptions
import com.icure.cardinal.sdk.crypto.encryptor.EntitiesEncryptionManifests
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class EncryptedFieldsOptionsTest : StringSpec({
	"Custom options should use exactly the given manifests and options" {
		val customManifests = EntitiesEncryptionManifests(
			patient = BuiltinRootEntityEncryptionManifest(fieldsToEncrypt = setOf("note"), recursiveEncryption = emptyMap()),
		)
		// Typed as EncryptedFieldsOptions to use the manifests extension rather than the Custom.manifests property
		val options: EncryptedFieldsOptions = EncryptedFieldsOptions.Custom(
			manifests = customManifests,
			useLegacyServiceContentEncryption = true,
		)
		options.manifests shouldBe customManifests
		options.manifests.contact.shouldBeNull()
		options.manifests.form.shouldBeNull()
		options.encryptorOptions shouldBe EncryptorOptions(
			useLegacyServiceContentEncryption = true,
			serializeEncryptedSelfUsingLegacyNames = false,
		)
	}

	"Base manifests should support all root entities, only without a customised model version" {
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
				manifests.form,
				manifests.invoice,
				manifests.relatedPerson,
			).forEach {
				it.shouldNotBeNull()
				it.currentVersion.shouldBeNull()
				it.extensionsManifestsByModelVersion shouldBe emptyMap()
			}
		}
	}
})

package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain

private const val EMBEDDED = "Embedded"

private fun rootManifest(
	recursiveEncryption: Map<String, String> = emptyMap(),
	extensionsManifestsByModelVersion: Map<Int, String> = emptyMap(),
	currentVersion: Int? = null,
) = BuiltinRootEntityEncryptionManifest(
	fieldsToEncrypt = emptySet(),
	recursiveEncryption = recursiveEncryption,
	extensionsManifestsByModelVersion = extensionsManifestsByModelVersion,
	currentVersion = currentVersion,
)

private fun embeddedManifest(
	recursiveEncryption: Map<String, String> = emptyMap(),
	extensionsManifestsByModelVersion: Map<EntityWithEncryptionMetadataTypeName.Builtin, Map<Int, String>> = emptyMap(),
	currentExtensionsManifest: String? = null,
) = BuiltinEmbeddedEntityEncryptionManifest(
	fieldsToEncrypt = emptySet(),
	recursiveEncryption = recursiveEncryption,
	extensionsManifestsByModelVersion = extensionsManifestsByModelVersion,
	currentExtensionsManifest = currentExtensionsManifest,
)

private fun customEntityManifest(
	extensionsManifestsByModelVersion: Map<Int, String> = mapOf(1 to "Ext"),
	currentVersion: Int = 1,
	fieldsToEncrypt: Set<String> = emptySet(),
	recursiveEncryption: Map<String, String> = emptyMap(),
) = CustomEntityEncryptionManifest(
	fieldsToEncrypt = fieldsToEncrypt,
	recursiveEncryption = recursiveEncryption,
	extensionsManifestsByModelVersion = extensionsManifestsByModelVersion,
	currentVersion = currentVersion,
)

private fun extensionsManifest(
	recursiveEncryptionFields: Map<String, ExtensionsEncryptionManifest.Recursive> = emptyMap(),
) = ExtensionsEncryptionManifest(
	fullEncryptionFields = emptySet(),
	recursiveEncryptionFields = recursiveEncryptionFields,
)

private fun manifests(
	// Manifest used only for patients, all other roots use an empty manifest
	patientManifest: BuiltinRootEntityEncryptionManifest = rootManifest(),
	embeddedManifestsByName: Map<String, BuiltinEmbeddedEntityEncryptionManifest> = emptyMap(),
	extensionsManifestsByName: Map<String, ExtensionsEncryptionManifest> = emptyMap(),
	customEntitiesManifestByEntityTypeId: Map<String, CustomEntityEncryptionManifest> = emptyMap(),
) = EntitiesEncryptionManifests(
	embeddedManifestsByName = embeddedManifestsByName,
	customEntitiesManifestByEntityTypeId = customEntitiesManifestByEntityTypeId,
	extensionsManifestsByName = extensionsManifestsByName,
	accessLog = rootManifest(),
	calendarItem = rootManifest(),
	contact = rootManifest(),
	healthElement = rootManifest(),
	patient = patientManifest,
	message = rootManifest(),
	topic = rootManifest(),
	document = rootManifest(),
	form = rootManifest(),
	invoice = rootManifest(),
	relatedPerson = rootManifest(),
)

class EntitiesEncryptionManifestsValidationTest : StringSpec({
	"Manifests with valid references should be accepted" {
		shouldNotThrowAny {
			manifests(
				patientManifest = rootManifest(
					recursiveEncryption = mapOf("addresses" to EMBEDDED),
					extensionsManifestsByModelVersion = mapOf(1 to "ExtV1", 2 to "ExtV2"),
					currentVersion = 2,
				),
				embeddedManifestsByName = mapOf(
					EMBEDDED to embeddedManifest(
						extensionsManifestsByModelVersion = mapOf(
							EntityWithEncryptionMetadataTypeName.Builtin.Patient to mapOf(1 to "ExtV1", 2 to "Nested"),
						),
						currentExtensionsManifest = "Nested",
					),
				),
				extensionsManifestsByName = mapOf(
					"ExtV1" to extensionsManifest(),
					"ExtV2" to extensionsManifest(
						recursiveEncryptionFields = mapOf(
							"nested" to ExtensionsEncryptionManifest.Recursive.Map(
								ExtensionsEncryptionManifest.Recursive.Collection(
									ExtensionsEncryptionManifest.Recursive.Object("Nested"),
								),
							),
						),
					),
					"Nested" to extensionsManifest(),
				),
			)
		}
	}

	"Root manifest current extensions manifest should be the extensions manifest of the current version" {
		rootManifest(
			extensionsManifestsByModelVersion = mapOf(1 to "ExtV1", 2 to "ExtV2"),
			currentVersion = 1,
		).currentExtensionsManifest shouldBe "ExtV1"
		rootManifest().currentExtensionsManifest shouldBe null
	}

	"Root manifest with a current version missing from extensionsManifestsByModelVersion should be rejected" {
		shouldThrow<IllegalArgumentException> {
			rootManifest(extensionsManifestsByModelVersion = mapOf(1 to "ExtV1"), currentVersion = 2)
		}
	}

	"Undefined extensions manifest in extensionsManifestsByModelVersion of root manifest should be rejected" {
		shouldThrow<IllegalArgumentException> {
			manifests(
				patientManifest = rootManifest(extensionsManifestsByModelVersion = mapOf(1 to "ExtV1", 2 to "Missing"), currentVersion = 1),
				extensionsManifestsByName = mapOf("ExtV1" to extensionsManifest()),
			)
		}.message.let {
			it shouldContain "`Missing`"
			it shouldContain "`patient`"
		}
	}

	"Undefined embedded manifest in recursive encryption of root manifest should be rejected" {
		shouldThrow<IllegalArgumentException> {
			manifests(patientManifest = rootManifest(recursiveEncryption = mapOf("addresses" to "Missing")))
		}.message.let {
			it shouldContain "`Missing`"
			it shouldContain "`patient`"
		}
	}

	"Undefined embedded manifest in recursive encryption of embedded manifest should be rejected" {
		shouldThrow<IllegalArgumentException> {
			manifests(embeddedManifestsByName = mapOf(EMBEDDED to embeddedManifest(recursiveEncryption = mapOf("notes" to "Missing"))))
		}.message shouldContain "`Missing`"
	}

	"Undefined current extensions manifest of embedded manifest should be rejected" {
		shouldThrow<IllegalArgumentException> {
			manifests(embeddedManifestsByName = mapOf(EMBEDDED to embeddedManifest(currentExtensionsManifest = "Missing")))
		}.message shouldContain "`Missing`"
	}

	"Undefined extensions manifest in extensionsManifestsByModelVersion of embedded manifest should be rejected" {
		shouldThrow<IllegalArgumentException> {
			manifests(
				embeddedManifestsByName = mapOf(
					EMBEDDED to embeddedManifest(
						extensionsManifestsByModelVersion = mapOf(
							EntityWithEncryptionMetadataTypeName.Builtin.Patient to mapOf(1 to "ExtV1", 2 to "Missing"),
						),
					),
				),
				extensionsManifestsByName = mapOf("ExtV1" to extensionsManifest()),
			)
		}.message shouldContain "`Missing`"
	}

	"Undefined extensions manifest referenced directly by recursive extensions encryption should be rejected" {
		shouldThrow<IllegalArgumentException> {
			manifests(
				extensionsManifestsByName = mapOf(
					"Ext" to extensionsManifest(
						recursiveEncryptionFields = mapOf("nested" to ExtensionsEncryptionManifest.Recursive.Object("Missing")),
					),
				),
			)
		}.message shouldContain "`Missing`"
	}

	"Undefined extensions manifest referenced through collections and maps by recursive extensions encryption should be rejected" {
		shouldThrow<IllegalArgumentException> {
			manifests(
				extensionsManifestsByName = mapOf(
					"Ext" to extensionsManifest(
						recursiveEncryptionFields = mapOf(
							"nested" to ExtensionsEncryptionManifest.Recursive.Collection(
								ExtensionsEncryptionManifest.Recursive.Map(
									ExtensionsEncryptionManifest.Recursive.Object("Missing"),
								),
							),
						),
					),
				),
			)
		}.message shouldContain "`Missing`"
	}

	"Custom entity manifests with valid extensions manifest references should be accepted" {
		shouldNotThrowAny {
			manifests(
				customEntitiesManifestByEntityTypeId = mapOf(
					"CustomType" to customEntityManifest(
						extensionsManifestsByModelVersion = mapOf(1 to "ExtV1", 2 to "ExtV2", 3 to "ExtV2"),
						currentVersion = 3,
					),
				),
				extensionsManifestsByName = mapOf(
					"ExtV1" to extensionsManifest(),
					"ExtV2" to extensionsManifest(),
				),
			)
		}
	}

	"Undefined extensions manifest in extensionsManifestsByModelVersion of custom entity should be rejected" {
		shouldThrow<IllegalArgumentException> {
			manifests(
				customEntitiesManifestByEntityTypeId = mapOf(
					"CustomType" to customEntityManifest(
						extensionsManifestsByModelVersion = mapOf(1 to "Missing", 2 to "ExtV2"),
						currentVersion = 2,
					),
				),
				extensionsManifestsByName = mapOf("ExtV2" to extensionsManifest()),
			)
		}.message.let {
			it shouldContain "`Missing`"
			it shouldContain "`CustomType`"
		}
	}

	"Custom entity manifest with a current version missing from extensionsManifestsByModelVersion should be rejected" {
		shouldThrow<IllegalArgumentException> {
			customEntityManifest(extensionsManifestsByModelVersion = mapOf(1 to "ExtV1"), currentVersion = 2)
		}
	}

	"Custom entity manifest encrypting base fields should be rejected" {
		shouldThrow<IllegalArgumentException> {
			customEntityManifest(fieldsToEncrypt = setOf("created"))
		}
		shouldThrow<IllegalArgumentException> {
			customEntityManifest(recursiveEncryption = mapOf("created" to EMBEDDED))
		}
	}
})

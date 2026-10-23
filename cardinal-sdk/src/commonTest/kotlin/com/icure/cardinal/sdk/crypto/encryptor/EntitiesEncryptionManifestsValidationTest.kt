package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.string.shouldContain

private const val ROOT = "Root"

private fun entityManifest(
	extensionsManifestsByModelVersion: Map<EntityWithEncryptionMetadataTypeName.Builtin, Map<Int, String>> = emptyMap(),
	currentExtensionsManifest: String? = null,
) = BuiltinEntityEncryptionManifest(
	fieldsToEncrypt = emptySet(),
	recursiveEncryption = emptyMap(),
	extensionsManifestsByModelVersion = extensionsManifestsByModelVersion,
	currentExtensionsManifest = currentExtensionsManifest,
)

private fun customEntityManifest(
	extensionsManifestsByModelVersion: Map<Int, String> = emptyMap(),
	currentExtensionsManifest: String? = null,
	fieldsToEncrypt: Set<String> = emptySet(),
	recursiveEncryption: Map<String, String> = emptyMap(),
) = CustomEntityEncryptionManifest(
	fieldsToEncrypt = fieldsToEncrypt,
	recursiveEncryption = recursiveEncryption,
	extensionsManifestsByModelVersion = extensionsManifestsByModelVersion,
	currentExtensionsManifest = currentExtensionsManifest,
)

private fun extensionsManifest(
	recursiveEncryptionFields: Map<String, ExtensionsEncryptionManifest.Recursive> = emptyMap(),
) = ExtensionsEncryptionManifest(
	fullEncryptionFields = emptySet(),
	recursiveEncryptionFields = recursiveEncryptionFields,
)

private fun manifests(
	rootManifest: BuiltinEntityEncryptionManifest = entityManifest(),
	extensionsManifestsByName: Map<String, ExtensionsEncryptionManifest> = emptyMap(),
	customEntitiesManifestByEntityTypeId: Map<String, CustomEntityEncryptionManifest> = emptyMap(),
) = EntitiesEncryptionManifests(
	manifestsByName = mapOf(ROOT to rootManifest),
	customEntitiesManifestByEntityTypeId = customEntitiesManifestByEntityTypeId,
	extensionsManifestsByName = extensionsManifestsByName,
	accessLog = ROOT,
	calendarItem = ROOT,
	contact = ROOT,
	healthElement = ROOT,
	patient = ROOT,
	message = ROOT,
	topic = ROOT,
	document = ROOT,
	form = ROOT,
	receipt = ROOT,
	classification = ROOT,
	invoice = ROOT,
	relatedPerson = ROOT,
)

class EntitiesEncryptionManifestsValidationTest : StringSpec({
	"Manifests with valid extensions manifest references should be accepted" {
		shouldNotThrowAny {
			manifests(
				rootManifest = entityManifest(
					extensionsManifestsByModelVersion = mapOf(
						EntityWithEncryptionMetadataTypeName.Builtin.Patient to mapOf(1 to "ExtV1", 2 to "ExtV2"),
					),
					currentExtensionsManifest = "ExtV2",
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

	"Undefined current extensions manifest should be rejected" {
		shouldThrow<IllegalArgumentException> {
			manifests(
				rootManifest = entityManifest(currentExtensionsManifest = "Missing"),
			)
		}.message shouldContain "`Missing`"
	}

	"Undefined extensions manifest in extensionsManifestsByModelVersion should be rejected" {
		shouldThrow<IllegalArgumentException> {
			manifests(
				rootManifest = entityManifest(
					extensionsManifestsByModelVersion = mapOf(
						EntityWithEncryptionMetadataTypeName.Builtin.Patient to mapOf(1 to "ExtV1", 2 to "Missing"),
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
						currentExtensionsManifest = "ExtV2",
					),
				),
				extensionsManifestsByName = mapOf(
					"ExtV1" to extensionsManifest(),
					"ExtV2" to extensionsManifest(),
				),
			)
		}
	}

	"Undefined current extensions manifest of custom entity should be rejected" {
		shouldThrow<IllegalArgumentException> {
			manifests(
				customEntitiesManifestByEntityTypeId = mapOf(
					"CustomType" to customEntityManifest(
						extensionsManifestsByModelVersion = mapOf(1 to "Missing"),
						currentExtensionsManifest = "Missing",
					),
				),
			)
		}.message.let {
			it shouldContain "`Missing`"
			it shouldContain "`CustomType`"
		}
	}

	"Undefined extensions manifest in extensionsManifestsByModelVersion of custom entity should be rejected" {
		shouldThrow<IllegalArgumentException> {
			manifests(
				customEntitiesManifestByEntityTypeId = mapOf(
					"CustomType" to customEntityManifest(
						extensionsManifestsByModelVersion = mapOf(1 to "Missing", 2 to "ExtV2"),
						currentExtensionsManifest = "ExtV2",
					),
				),
				extensionsManifestsByName = mapOf("ExtV2" to extensionsManifest()),
			)
		}.message.let {
			it shouldContain "`Missing`"
			it shouldContain "`CustomType`"
		}
	}

	"Current extensions manifest of custom entity not used by any version should be rejected" {
		shouldThrow<IllegalArgumentException> {
			manifests(
				customEntitiesManifestByEntityTypeId = mapOf(
					"CustomType" to customEntityManifest(
						extensionsManifestsByModelVersion = mapOf(1 to "ExtV1"),
						currentExtensionsManifest = "ExtV2",
					),
				),
				extensionsManifestsByName = mapOf(
					"ExtV1" to extensionsManifest(),
					"ExtV2" to extensionsManifest(),
				),
			)
		}.message.let {
			it shouldContain "`ExtV2`"
			it shouldContain "`CustomType`"
		}
	}

	"Custom entity manifest encrypting base fields should be rejected" {
		shouldThrow<IllegalArgumentException> {
			customEntityManifest(fieldsToEncrypt = setOf("created"))
		}
		shouldThrow<IllegalArgumentException> {
			customEntityManifest(recursiveEncryption = mapOf("created" to ROOT))
		}
	}
})

package com.icure.cardinal.sdk.crypto.encryptor

import kotlinx.serialization.Serializable

/**
 * Specifies how entities should be encrypted.
 *
 * Root entities without a manifest are not supported by the SDK. The encryption of some legacy root entities
 * ([com.icure.cardinal.sdk.model.Receipt], [com.icure.cardinal.sdk.model.Classification]) and of system root entities
 * (e.g. [com.icure.cardinal.sdk.model.MaintenanceTask]) is not configurable: the SDK always uses a fixed configuration.
 */
@Serializable
data class EntitiesEncryptionManifests(
	/**
	 * Manifests of the embedded entities that should be partially encrypted, which are referenced by the
	 * [EntityEncryptionManifest.recursiveEncryption] of other manifests.
	 *
	 * Each manifest must only be used to handle one type of entity, but it is possible to have multiple manifests
	 * per type of entity.
	 * For example, you can have an [com.icure.cardinal.sdk.model.embed.Annotation] inside a
	 * [com.icure.cardinal.sdk.model.Patient] be encrypted differently from the annotation inside a
	 * [com.icure.cardinal.sdk.model.Contact]).
	 */
	val embeddedManifestsByName: Map<String, BuiltinEmbeddedEntityEncryptionManifest> = emptyMap(),
	/**
	 * Manifests for fully custom entities, indexed by the custom entity type identifier.
	 */
	val customEntitiesManifestByEntityTypeId: Map<String, CustomEntityEncryptionManifest> = emptyMap(),
	/**
	 * Manifests for extensions encryption.
	 */
	val extensionsManifestsByName: Map<String, ExtensionsEncryptionManifest> = emptyMap(),
	/**
	 * Manifest for the encryption of [com.icure.cardinal.sdk.model.AccessLog] entities, or null if the SDK does not support
	 * this type of entity (the configuration of a customised SDK does not include it): any attempt to encrypt or decrypt
	 * entities of this type will fail.
	 */
	val accessLog: BuiltinRootEntityEncryptionManifest? = null,
	/**
	 * Manifest for the encryption of [com.icure.cardinal.sdk.model.CalendarItem] entities, or null if the SDK does not support
	 * this type of entity (the configuration of a customised SDK does not include it): any attempt to encrypt or decrypt
	 * entities of this type will fail.
	 */
	val calendarItem: BuiltinRootEntityEncryptionManifest? = null,
	/**
	 * Manifest for the encryption of [com.icure.cardinal.sdk.model.Contact] entities, or null if the SDK does not support
	 * this type of entity (the configuration of a customised SDK does not include it): any attempt to encrypt or decrypt
	 * entities of this type will fail.
	 */
	val contact: BuiltinRootEntityEncryptionManifest? = null,
	/**
	 * Manifest for the encryption of [com.icure.cardinal.sdk.model.HealthElement] entities, or null if the SDK does not support
	 * this type of entity (the configuration of a customised SDK does not include it): any attempt to encrypt or decrypt
	 * entities of this type will fail.
	 */
	val healthElement: BuiltinRootEntityEncryptionManifest? = null,
	/**
	 * Manifest for the encryption of [com.icure.cardinal.sdk.model.Patient] entities, or null if the SDK does not support
	 * this type of entity (the configuration of a customised SDK does not include it): any attempt to encrypt or decrypt
	 * entities of this type will fail.
	 */
	val patient: BuiltinRootEntityEncryptionManifest? = null,
	/**
	 * Manifest for the encryption of [com.icure.cardinal.sdk.model.Message] entities, or null if the SDK does not support
	 * this type of entity (the configuration of a customised SDK does not include it): any attempt to encrypt or decrypt
	 * entities of this type will fail.
	 */
	val message: BuiltinRootEntityEncryptionManifest? = null,
	/**
	 * Manifest for the encryption of [com.icure.cardinal.sdk.model.Topic] entities, or null if the SDK does not support
	 * this type of entity (the configuration of a customised SDK does not include it): any attempt to encrypt or decrypt
	 * entities of this type will fail.
	 */
	val topic: BuiltinRootEntityEncryptionManifest? = null,
	/**
	 * Manifest for the encryption of [com.icure.cardinal.sdk.model.Document] entities, or null if the SDK does not support
	 * this type of entity (the configuration of a customised SDK does not include it): any attempt to encrypt or decrypt
	 * entities of this type will fail.
	 */
	val document: BuiltinRootEntityEncryptionManifest? = null,
	/**
	 * Manifest for the encryption of [com.icure.cardinal.sdk.model.Form] entities, or null if the SDK does not support
	 * this type of entity (the configuration of a customised SDK does not include it): any attempt to encrypt or decrypt
	 * entities of this type will fail.
	 */
	val form: BuiltinRootEntityEncryptionManifest? = null,
	/**
	 * Manifest for the encryption of [com.icure.cardinal.sdk.model.Invoice] entities, or null if the SDK does not support
	 * this type of entity (the configuration of a customised SDK does not include it): any attempt to encrypt or decrypt
	 * entities of this type will fail.
	 */
	val invoice: BuiltinRootEntityEncryptionManifest? = null,
	/**
	 * Manifest for the encryption of [com.icure.cardinal.sdk.model.RelatedPerson] entities, or null if the SDK does not support
	 * this type of entity (the configuration of a customised SDK does not include it): any attempt to encrypt or decrypt
	 * entities of this type will fail.
	 */
	val relatedPerson: BuiltinRootEntityEncryptionManifest? = null,
) {
	init {
		val rootManifests = mapOf(
			"accessLog" to accessLog,
			"calendarItem" to calendarItem,
			"contact" to contact,
			"healthElement" to healthElement,
			"patient" to patient,
			"message" to message,
			"topic" to topic,
			"document" to document,
			"form" to form,
			"invoice" to invoice,
			"relatedPerson" to relatedPerson,
		)
		for ((entityName, manifest) in rootManifests) {
			if (manifest == null) continue
			for (recursiveManifestName in manifest.recursiveEncryption.values) {
				require(recursiveManifestName in embeddedManifestsByName) {
					"Manifest `$recursiveManifestName` referenced by recursive encryption of the manifest of `$entityName` is not defined in embeddedManifestsByName"
				}
			}
			// The current version is always in extensionsManifestsByModelVersion (validated by the manifest itself)
			for ((version, extensionsManifestName) in manifest.extensionsManifestsByModelVersion) {
				require(extensionsManifestName in extensionsManifestsByName) {
					"Extensions manifest `$extensionsManifestName` referenced by the manifest of `$entityName` for v$version is not defined in extensionsManifestsByName"
				}
			}
		}
		for ((manifestName, manifest) in embeddedManifestsByName) {
			for (recursiveManifestName in manifest.recursiveEncryption.values) {
				require(recursiveManifestName in embeddedManifestsByName) {
					"Manifest `$recursiveManifestName` referenced by recursive encryption of manifest `$manifestName` is not defined in embeddedManifestsByName"
				}
			}
			manifest.currentExtensionsManifest?.let { currentExtensionsManifestName ->
				require(currentExtensionsManifestName in extensionsManifestsByName) {
					"Extensions manifest `$currentExtensionsManifestName` referenced as current extensions manifest of manifest `$manifestName` is not defined in extensionsManifestsByName"
				}
			}
			for ((modelType, manifestsByVersion) in manifest.extensionsManifestsByModelVersion) {
				for ((version, extensionsManifestName) in manifestsByVersion) {
					require(extensionsManifestName in extensionsManifestsByName) {
						"Extensions manifest `$extensionsManifestName` referenced by manifest `$manifestName` for ${modelType.id} v$version is not defined in extensionsManifestsByName"
					}
				}
			}
		}
		for ((entityTypeId, manifest) in customEntitiesManifestByEntityTypeId) {
			// The current version is always in extensionsManifestsByModelVersion (validated by the manifest itself)
			for ((version, extensionsManifestName) in manifest.extensionsManifestsByModelVersion) {
				require(extensionsManifestName in extensionsManifestsByName) {
					"Extensions manifest `$extensionsManifestName` referenced by custom entity `$entityTypeId` for v$version is not defined in extensionsManifestsByName"
				}
			}
		}
		for ((extensionsManifestName, extensionsManifest) in extensionsManifestsByName) {
			for ((fieldName, recursive) in extensionsManifest.recursiveEncryptionFields) {
				val recursiveManifestName = recursive.objectManifestName()
				require(recursiveManifestName in extensionsManifestsByName) {
					"Extensions manifest `$recursiveManifestName` referenced by field `$fieldName` of extensions manifest `$extensionsManifestName` is not defined in extensionsManifestsByName"
				}
			}
		}
	}
}

private tailrec fun ExtensionsEncryptionManifest.Recursive.objectManifestName(): String = when (this) {
	is ExtensionsEncryptionManifest.Recursive.Object -> manifestName
	is ExtensionsEncryptionManifest.Recursive.Collection -> recursive.objectManifestName()
	is ExtensionsEncryptionManifest.Recursive.Map -> recursive.objectManifestName()
}

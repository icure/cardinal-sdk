package com.icure.cardinal.sdk.crypto.encryptor

import kotlinx.serialization.Serializable

/**
 * Specifies how entities should be encrypted.
 */
@Serializable
data class EntitiesEncryptionManifests(
	/**
	 * Manifests of all the entities that should be partially encrypted, both root entities (which are referenced by
	 * [accessLog], [calendarItem], ...) and embedded entities which are referenced by other manifests
	 * [BuiltinEntityEncryptionManifest].
	 *
	 * Each manifest must only be used to handle one type of entity, but it is possible to have multiple manifests
	 * per type of entity.
	 * For example, you can have an [com.icure.cardinal.sdk.model.embed.Annotation] inside a
	 * [com.icure.cardinal.sdk.model.Patient] be encrypted differently from the annotation inside a
	 * [com.icure.cardinal.sdk.model.Contact]).
	 */
	val manifestsByName: Map<String, BuiltinEntityEncryptionManifest>,
	/**
	 * Manifests for fully custom entities, indexed by the custom entity type identifier.
	 */
	val customEntitiesManifestByEntityTypeId: Map<String, CustomEntityEncryptionManifest>,
	/**
	 * Manifests for extensions encryption.
	 */
	val extensionsManifestsByName: Map<String, ExtensionsEncryptionManifest>,
	/**
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.AccessLog] entities
	 */
	val accessLog: String,
	/**
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.CalendarItem] entities
	 */
	val calendarItem: String,
	/**
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.Contact] entities.
	 */
	val contact: String,
	/**
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.HealthElement] entities
	 */
	val healthElement: String,
	/**
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.Patient] entities
	 */
	val patient: String,
	/**
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.Message] entities
	 */
	val message: String,
	/**
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.Topic] entities
	 */
	val topic: String,
	/**
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.Document] entities
	 */
	val document: String,
	/**
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.Form] entities
	 */
	val form: String,
	/**
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.Receipt] entities
	 */
	val receipt: String,
	/**
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.Classification] entities
	 */
	val classification: String,
	/**
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.Invoice] entities
	 */
	val invoice: String,
	/**
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.RelatedPerson] entities
	 */
	val relatedPerson: String,
) {
	init {
		val entityManifestNames = mapOf(
			"accessLog" to accessLog,
			"calendarItem" to calendarItem,
			"contact" to contact,
			"healthElement" to healthElement,
			"patient" to patient,
			"message" to message,
			"topic" to topic,
			"document" to document,
			"form" to form,
			"receipt" to receipt,
			"classification" to classification,
			"invoice" to invoice,
			"relatedPerson" to relatedPerson,
		)
		for ((entityName, manifestName) in entityManifestNames) {
			require(manifestName in manifestsByName) {
				"Manifest `$manifestName` referenced by `$entityName` is not defined in manifestsByName"
			}
		}
		for ((manifestName, manifest) in manifestsByName) {
			for (recursiveManifestName in manifest.recursiveEncryption.values) {
				require(recursiveManifestName in manifestsByName) {
					"Manifest `$recursiveManifestName` referenced by recursive encryption of manifest `$manifestName` is not defined in manifestsByName"
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
			manifest.currentExtensionsManifest?.let { currentExtensionsManifestName ->
				require(currentExtensionsManifestName in extensionsManifestsByName) {
					"Extensions manifest `$currentExtensionsManifestName` referenced as current extensions manifest of custom entity `$entityTypeId` is not defined in extensionsManifestsByName"
				}
				// Custom entities can only be encrypted at a version using the current extensions manifest
				require(currentExtensionsManifestName in manifest.extensionsManifestsByModelVersion.values) {
					"Extensions manifest `$currentExtensionsManifestName` referenced as current extensions manifest of custom entity `$entityTypeId` is not used by any of its versions in extensionsManifestsByModelVersion"
				}
			}
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

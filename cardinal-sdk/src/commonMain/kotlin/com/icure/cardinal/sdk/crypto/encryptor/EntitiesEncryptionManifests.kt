package com.icure.cardinal.sdk.crypto.encryptor

/**
 * Specifies how entities should be encrypted.
 */
data class EntitiesEncryptionManifests(
	/**
	 * Manifests of all the entities that should be partially encrypted, both root entities (which are referenced by
	 * [accessLog], [calendarItem], ... + the [service] special case) and embedded entities which are referenced by other manifests
	 * [EntityEncryptionManifest].
	 *
	 * Each manifest must only be used to handle one type of entity, but it is possible to have multiple manifests
	 * per type of entity.
	 * For example, you can have an [com.icure.cardinal.sdk.model.embed.Annotation] inside a
	 * [com.icure.cardinal.sdk.model.Patient] be encrypted differently from the annotation inside a
	 * [com.icure.cardinal.sdk.model.Contact]).
	 */
	val manifestsByName: Map<String, EntityEncryptionManifest>,
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
	 *
	 * Note that the encryption configuration of [com.icure.cardinal.sdk.model.Contact.services] is done specially through the
	 * manifest defined in [service] and should not be done through the contact's manifest.
	 */
	val contact: String,
	/**
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.embed.Service] entities.
	 *
	 * Note that the encryption configuration of [com.icure.cardinal.sdk.model.embed.Service.content] is not configurable, and instead is always
	 * done according to the following rules:
	 * - If all the values of the service content have non-null and non-empty values only for [com.icure.cardinal.sdk.model.embed.Content.compoundValue]
	 *   then only the content itself is not encrypted, and instead the contained compound Services are encrypted using this same manifest.
	 *   This also means that the content's map keys will be unencrypted.
	 * - In all other cases the content map is included in its entirety: the map keys and any compound service will be completely hidden within the
	 *   encrypted content.
	 */
	val service: String,
	/**
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.HealthElement] entities
	 */
	val healthElement: String,
	/**
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.MaintenanceTask] entities
	 */
	val maintenanceTask: String,
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
) {
	init {
		val entityManifestNames = mapOf(
			"accessLog" to accessLog,
			"calendarItem" to calendarItem,
			"contact" to contact,
			"service" to service,
			"healthElement" to healthElement,
			"maintenanceTask" to maintenanceTask,
			"patient" to patient,
			"message" to message,
			"topic" to topic,
			"document" to document,
			"form" to form,
			"receipt" to receipt,
			"classification" to classification,
			"invoice" to invoice,
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
		}
	}
}

package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.utils.intersects
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey

/**
 * A strategy for encryption and decryption of an entity of a known type.
 *
 * Encryption is based on an encryption manifest, which specifies which fields of the entity need to be encrypted.
 *
 * Decryption instead is independent of the manifest, any encrypted field in the entity is automatically decrypted,
 * (independently of what the manifest specifies for that field), potentially overriding the non-encrypted value for
 * that field if any.
 */
interface EntityEncryptor<ENCRYPTED : Any, DECRYPTED : Any> {
	fun encrypt(
		encryptionKeys: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		encryptedEntity: ENCRYPTED,
	): DECRYPTED

	/**
	 * Decrypts the given [encryptedEntity] using the given [decryptionKeys] which must be non-empty.
	 *
	 * If multiple [decryptionKeys] are provided this method tries all of them in order on each encrypted field
	 * encountered, until one of them succeeds.
	 *
	 * This is required in the unlikely scenario that a single entity is encrypted using different keys for different
	 * parts (may happen if separate entities have been merged without access to the encrypted content).
	 */
	fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: ENCRYPTED,
	): DECRYPTED
}

interface EntityEncryptorFactory<ENCRYPTED : Any, DECRYPTED : Any> {
	fun create(manifest: EntityEncryptionManifest): EntityEncryptor<ENCRYPTED, DECRYPTED>
}

data class EntitiesEncryptionManifest(
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
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.TimeTable] entities
	 */
	val timeTable: String,
	/**
	 * Name of the manifest in [manifestsByName] that should be used for the encryption of [com.icure.cardinal.sdk.model.Invoice] entities
	 */
	val invoice: String,
)

data class EntityEncryptionManifest(
	/**
	 * Fields to encrypt directly in the entity.
	 * When a field is encrypted the value in the encrypted entity is replaced by the default value for that field,
	 * and the real value is kept in the encryptedSelf content.
	 */
	val fieldsToEncrypt: Set<String>,
	/**
	 * Fields to encrypt recursively using another manifest, the key is the field name, the value is the name of the
	 * manifest, which must be in the [EntitiesEncryptionManifest.manifestsByName] map.
	 *
	 * If the field is a map or collection the manifest will be applied to the corresponding values or elements;
	 * multiple levels are also supported.
	 */
	val recursiveEncryption: Map<String, String>
) {
	init {
		require (!recursiveEncryption.keys.intersects(fieldsToEncrypt)) {
			"Recursive encryption and direct encryption cannot be used on the same field"
		}
	}
}

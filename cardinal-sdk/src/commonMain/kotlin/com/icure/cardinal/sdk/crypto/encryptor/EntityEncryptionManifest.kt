package com.icure.cardinal.sdk.crypto.encryptor;

import com.icure.cardinal.sdk.utils.intersects

data class EntityEncryptionManifest(
	/**
	 * Fields to encrypt directly in the entity.
	 * When a field is encrypted the value in the encrypted entity is replaced by the default value for that field,
	 * and the real value is kept in the encryptedSelf content.
	 */
	val fieldsToEncrypt: Set<String>,
	/**
	 * Fields to encrypt recursively using another manifest, the key is the field name, the value is the name of the
	 * manifest, which must be in the [EntitiesEncryptionManifests.manifestsByName] map.
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

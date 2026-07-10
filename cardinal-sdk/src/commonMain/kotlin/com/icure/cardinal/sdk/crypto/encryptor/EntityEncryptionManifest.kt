package com.icure.cardinal.sdk.crypto.encryptor;

import com.icure.cardinal.sdk.utils.intersects
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.JsonObject

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
	val recursiveEncryption: Map<String, String>,
//TODO
//	/**
//	 * Only applicable to extendable entities, if not null on the manifest of a non-extendable entity throws exception
//	 * on creation of the encryptor.
//	 *
//	 * Takes in input the extensions, encryption key, and crypto service to use for actually performing the encryption.
//	 */
//	val extensionsEncryptor: (
//		(
//			extensions: JsonObject,
//			encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
//			cryptoService: CryptoService,
//		) -> JsonObject
//	)?,
) {
	init {
		require (!recursiveEncryption.keys.intersects(fieldsToEncrypt)) {
			"Recursive encryption and direct encryption cannot be used on the same field"
		}
	}
}

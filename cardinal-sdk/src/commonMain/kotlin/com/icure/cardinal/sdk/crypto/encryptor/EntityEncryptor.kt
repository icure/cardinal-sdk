package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json

/**
 * A strategy for encryption of an entity of a known type.
 *
 * Encryption is based on an encryption manifest provided to the [EntityEncryptorFactory.create], which specifies which
 * fields of the entity need to be encrypted.
 *
 * The same type of entity may be encrypted in different ways also within the same instance of the CardinalSdk,
 * depending on the context of where the entity is used.
 */
@InternalIcureApi
interface EntityEncryptor<ENCRYPTED : Encryptable, DECRYPTED : Encryptable> {
	/**
	 * Encrypts the given [clearEntity] using the configuration of this encryptor.
	 */
	suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DECRYPTED,
		encodingJson: Json,
		cryptoService: CryptoService,
	): ENCRYPTED
}

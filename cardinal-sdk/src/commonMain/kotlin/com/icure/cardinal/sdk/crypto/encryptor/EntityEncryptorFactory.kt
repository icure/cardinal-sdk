package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json

@InternalIcureApi
internal interface EntityEncryptorFactory<ENCRYPTED : Encryptable, DECRYPTED : Encryptable> {
	/**
	 * Initialize this entity encryptor using a manifest.
	 *
	 * Should never be called directly, the creation of encryptors should be delegated to the
	 * [EntitiesEncryptorsInitializer].
	 */
	fun create(
		entityManifestName: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<ENCRYPTED, DECRYPTED>

	/**
	 * Get an entity encryptor that does not encrypt any field (equivalent to providing an empty manifest).
	 */
	val empty: EntityEncryptor<ENCRYPTED, DECRYPTED>
}

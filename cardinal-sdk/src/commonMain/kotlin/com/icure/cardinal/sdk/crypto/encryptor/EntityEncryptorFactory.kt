package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal interface EntityEncryptorFactory<ENCRYPTED : Encryptable, DECRYPTED : Encryptable> {
	/**
	 * Initialize this entity encryptor using a manifest.
	 */
	fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext
	): EntityEncryptor<ENCRYPTED, DECRYPTED>

	/**
	 * Get an entity encryptor that does not encrypt any field (equivalent to providing an empty manifest).
	 */
	val empty: EntityEncryptor<ENCRYPTED, DECRYPTED>
}

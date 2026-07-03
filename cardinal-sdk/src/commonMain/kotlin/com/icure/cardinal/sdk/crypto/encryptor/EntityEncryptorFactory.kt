package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.model.embed.Encryptable

internal interface EntityEncryptorFactory<ENCRYPTED : Encryptable, DECRYPTED : Encryptable> {
	/**
	 * Initialize this entity encryptor using a manifest.
	 */
	fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext
	): EntityEncryptor<ENCRYPTED, DECRYPTED>

	/**
	 * Initialize an entity encryptor that does not encrypt any field (equivalent to providing an empty manifest),
	 * but can still decrypt.
	 */
	fun createEmptyEncryptor(): EntityEncryptor<ENCRYPTED, DECRYPTED>
}

package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json

/**
 * Factory for encryptors of builtin root entities, using a [BuiltinRootEntityEncryptionManifest].
 */
@InternalIcureApi
internal interface RootEntityEncryptorFactory<ENCRYPTED : Encryptable, DECRYPTED : Encryptable> {
	/**
	 * Initialize this entity encryptor using a manifest.
	 *
	 * Should never be called directly, the creation of encryptors should be delegated to the
	 * [EntitiesEncryptorsInitializer].
	 */
	fun create(
		manifest: BuiltinRootEntityEncryptionManifest,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<ENCRYPTED, DECRYPTED>
}

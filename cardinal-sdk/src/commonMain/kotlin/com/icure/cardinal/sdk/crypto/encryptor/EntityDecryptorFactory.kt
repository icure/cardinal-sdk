package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.options.DecryptedJsonStrictness
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json

@InternalIcureApi
internal interface EntityDecryptorFactory<ENCRYPTED : Encryptable, DECRYPTED : Encryptable> {
	/**
	 * Initialize this entity decryptor.
	 *
	 * Should never be called directly, the creation of decryptors should be delegated to the
	 * [EntitiesEncryptorsInitializer].
	 *
	 * @param encryptorsFactoryContext the context for the factory.
	 * @param cryptoService the crypto service to use to decrypt the content.
	 * @param unversionedEntitiesDecryptedJsonStrictness how strictly the json in the decrypted self should be
	 * interpreted when decrypting an entity that does not have a data model version.
	 * @param encryptedContentDecoder the json decoder to use to decode the values of the encrypted content.
	 */
	fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness
	): EntityDecryptor<ENCRYPTED, DECRYPTED>
}

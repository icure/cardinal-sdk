package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.utils.InternalIcureApi

/*TODO
 * Currently the entire concept of json patcher has been removed:
 * - The previous patcher was not suitable for patching of recursively encrypted entities (patching an encrypted
 *   annotation from inside a patient: we have to patch the decrypted encryptedSelf of the annotation, not of the
 *   patient)
 * - With introduction of proper migration system patching should not be needed anymore
 * - Only entities coming from legacy typescript may need json patching, typesafety of cardinal should have prevented
 *   bad entities being accidentally created. For current use cases ignoring unknown decrypted fields shoudl be
 *   sufficient.
 */
/**
 * A strategy for decryption of an entity of a known type.
 *
 * Unlike encryption the decryption strategy does not use a manifest: any encrypted field in the entity is automatically
 * decrypted, potentially overriding the non-encrypted value for that field if any.
 *
 * All instances of a CardinalSDK use the same decryptor for a given entity, for this reason there is no
 * [EntityEncryptorFactory] equivalent.
 */
@InternalIcureApi
interface EntityDecryptor<ENCRYPTED : Encryptable, DECRYPTED: Encryptable> {
	/**
	 * Decrypts the given [encryptedEntity] using the given [decryptionKeys] which must be non-empty.
	 *
	 * # Decryption keys
	 *
	 * If multiple [decryptionKeys] are provided this method tries all of them in order on each encrypted field
	 * encountered, until one of them succeeds.
	 *
	 * This is required in the unlikely scenario that a single entity is encrypted using different keys for different
	 * parts (may happen if separate entities have been merged without access to the encrypted content).
	 *
	 * @param decryptionKeys the keys to use for decryption.
	 * @param encryptedEntity the entity to decrypt.
	 * @return the decrypted entity.
	 * @throws com.icure.cardinal.sdk.utils.EntityEncryptionException if the entity can't be fully decrypted using the
	 * provided keys, or if the decrypted content is not valid.
	 */
	suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: ENCRYPTED,
		customisedModelVersion: CustomisedModelVersion?,
	): DECRYPTED
}
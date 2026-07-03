package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

/**
 * A strategy for decryption of an entity of a known type.
 *
 * Unlike encryption the decryption strategy does not use a manifest: any encrypted field in the entity is automatically
 * decrypted, potentially overriding the non-encrypted value for that field if any.
 *
 * All instances of a CardinalSDK use the same decryptor for a given entity, for this reason there is no
 * [EntityEncryptorFactory] equivalent.
 */
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
	 * # Handling bad json in encrypted self
	 *
	 * The [patchDecryptedSelfJson] function can be used to modify the json decrypted from the entity before continuing
	 * interpretation of it. This is useful to handle migration of data predating the introduction of the customised
	 * SDK migration framework which may be using some deprecated fields.
	 *
	 * You can also use [ignoreUnknownDecryptedFields] to ignore all entries in the decrypted json that do not correspond to a
	 * field known by the SDK. If a [patchDecryptedSelfJson] function is provided, the json will be patched before
	 * ignoring unknown keys.
	 *
	 * Note that [ignoreUnknownDecryptedFields] is not automatically applied to the decoding of the nested entities, which is
	 * instead handled by the provided [encryptedContentDecoder].
	 * For example, if a [com.icure.cardinal.sdk.model.EncryptedPatient]'s encrypted self contains:
	 * ```json
	 * {
	 *   "unknownInRoot": "this field does not exist in Patient",
	 *   "notes": [{ "id": "x", "unknownInEmbedded": "this field does not exist in Annotation" }]
	 * }
	 * ```
	 * then the `unknownInRoot` field will be ignored automatically by [ignoreUnknownDecryptedFields], but the way the
	 * `unknownInEmbedded` field will be treated depends solely on how the provided [encryptedContentDecoder] is
	 * configured.
	 *
	 * If the decrypted content of the entity is not valid json then decryption will fail without using
	 * [patchDecryptedSelfJson].
	 *
	 * @param decryptionKeys the keys to use for decryption.
	 * @param encryptedEntity the entity to decrypt.
	 * @param patchDecryptedSelfJson a function that can be used to patch the content of the entity.
	 * @param ignoreUnknownDecryptedFields if unknown fields found in the decrypted json should be ignored.
	 * @param encryptedContentDecoder the json decoder to use to decode the values of the encrypted content.
	 * @return the decrypted entity.
	 * @throws com.icure.cardinal.sdk.utils.EntityEncryptionException if the entity can't be fully decrypted using the
	 * provided keys, or if the decrypted content is not valid.
	 */
	fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: ENCRYPTED,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
	): DECRYPTED
}
package com.icure.cardinal.sdk.options

import com.icure.cardinal.sdk.utils.UndecryptableContentException
import com.icure.cardinal.sdk.utils.UnexpectedEncryptedContentException

enum class DecryptedJsonStrictness {
	/**
	 * If the decrypted json is not fully respecting what is expected (there are unknown fields or invalid values for
	 * known fields) then decryption will fail with a [UnexpectedEncryptedContentException].
	 */
	Strict,

	/**
	 * Unknown fields in the decrypted json will be ignored.
	 * This means:
	 * - Unknown keys directly in the decrypted content (that is keys that do not match a field of the entity holding
	 *   the encryptedSelf) are ignored
	 * - Unknown fields encountered during the decoding of the encrypted content values will be ignored recursively
	 *
	 * Decryption may still fail if the SDK can't decode a decrypted content field value, for example if the type of a
	 * known field does not match the expected type.
	 */
	IgnoreUnknownFields,

	/**
	 * Completely ignore unexpected values in the decrypted content: firstly ignore unknown fields (see
	 * [IgnoreUnknownFields]), but then if the value of a decrypted content field can't be encoded ignore it and use
	 * the corresponding default value for that field.
	 *
	 * Note that if the content of the encrypted self is not a valid json object at all (or at least it can't be
	 * decrypted with available keys) then decryption will still fail, with a [UndecryptableContentException].
	 */
	IgnoreBadValues
}
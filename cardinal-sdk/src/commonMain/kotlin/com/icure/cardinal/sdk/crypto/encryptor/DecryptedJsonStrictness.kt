package com.icure.cardinal.sdk.crypto.encryptor

enum class DecryptedJsonStrictness {
	/**
	 * If the decrypted json is not fully respecting what is expected then decryption will fail.
	 */
	Strict,

	/**
	 * Unknown fields in the decrypted json will be ignored.
	 * This option does NOT affect the decoding of contained entities, it only affects unknown keys directly in the
	 * decoded encrypted self object, and not the decoding of these values, as that is handeld by the
	 * [kotlinx.serialization.json.Json] passed to [EntityDecryptor.decrypt].
	 */
	IgnoreUnknownFields,

	/**
	 * Completely ignore unexpected values in the decrypted self. This includes:
	 * - There are unknown fields in the decrypted json object
	 * - The values of a field in the decrypted json can't be decoded.
	 *
	 * If the content of the encrypted self is not a valid json object at all (or at least it can't be decrypted with
	 * available keys) then decryption will still fail.
	 */
	IgnoreBadValues
}
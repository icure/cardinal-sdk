package com.icure.cardinal.sdk.crypto.impl

import com.icure.kryptom.crypto.CryptoService

internal object HashingUtils {
	/**
	 * The digits of the base 62 representation used by [sha256Alphanumeric], from the lowest to the highest value.
	 */
	private const val BASE_62_DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"

	private const val BASE_62 = 62

	/**
	 * The number of base 62 digits used to represent a sha-256 digest: 43 digits are always enough and never more than
	 * necessary, because `62^42 < 2^256 < 62^43`.
	 */
	private const val SHA_256_BASE_62_LENGTH = 43

	/**
	 * The number of 32 bits limbs of a sha-256 digest.
	 */
	private const val SHA_256_LIMBS = 8

	/**
	 * Hashes [data] with sha-256 and returns the digest encoded as a fixed length, purely alphanumeric string.
	 *
	 * The digest is interpreted as a single big-endian unsigned integer and written in base 62, using the digits
	 * `0-9A-Za-z`, left padded with `0` to a constant length of 43 characters. Since `2^256 < 62^43` every digest fits
	 * in that many digits, and since the length is constant the encoding stays injective: distinct digests always give
	 * distinct strings, and the length of the result never depends on the value of the digest.
	 *
	 * Unlike standard base 64 the result is safe to use as a couchdb document id and in a url: it is made only of
	 * unreserved characters, so it never needs escaping, and it can never start with `_`, which couchdb reserves for
	 * its own documents. It is also not any longer than Base64 would be, since a 32 bytes digest takes 43 characters
	 * in both encodings.
	 */
	suspend fun sha256Alphanumeric(data: String, cryptoService: CryptoService): String {
		val digest = cryptoService.digest.sha256(data.encodeToByteArray()) // Encoded string as utf 8 matches java digest utils
		// The digest as 32 bits limbs, from the most to the least significant, divided in place by 62 on every
		// iteration of the loop below.
		val limbs = LongArray(SHA_256_LIMBS) { limb ->
			val firstByte = limb * 4
			((digest[firstByte].toLong() and 0xFF) shl 24) or
				((digest[firstByte + 1].toLong() and 0xFF) shl 16) or
				((digest[firstByte + 2].toLong() and 0xFF) shl 8) or
				(digest[firstByte + 3].toLong() and 0xFF)
		}
		// The digits of the result, written from the end backwards; the ones left over at the front are the padding.
		val digits = CharArray(SHA_256_BASE_62_LENGTH) { BASE_62_DIGITS[0] }
		var nextDigit = SHA_256_BASE_62_LENGTH
		var mostSignificantLimb = 0
		while (mostSignificantLimb < SHA_256_LIMBS) {
			var remainder = 0L
			for (i in mostSignificantLimb until SHA_256_LIMBS) {
				// The remainder is less than 62, so this cannot overflow: 61 * 2^32 + (2^32 - 1) < Long.MAX_VALUE.
				val current = (remainder shl 32) or limbs[i]
				limbs[i] = current / BASE_62
				remainder = current % BASE_62
			}
			digits[--nextDigit] = BASE_62_DIGITS[remainder.toInt()]
			// The most significant limbs become 0 as the division progresses, skip them.
			if (limbs[mostSignificantLimb] == 0L) {
				mostSignificantLimb++
			}
		}
		return digits.concatToString()
	}
}

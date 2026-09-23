package com.icure.cardinal.sdk.crypto.pairing

import com.icure.kryptom.crypto.DigestService
import com.icure.pairing.ec.Secp160r1Service

/**
 * Outcome of parsing a typed pairing code. The checksum is verified here, before any curve work, so a typo costs
 * no scalar multiplication and is reported as "check what you typed" rather than as a rejected key. Whether the
 * key is actually on the curve is **not** checked here; the caller must validate it with
 * [Secp160r1Service.isValidPublicKeyX] before using it.
 */
sealed interface PairingCodeParseResult {
	/** Structurally valid code with a matching checksum. [publicKeyX] is not yet validated against the curve. */
	class Parsed(val version: Int, val publicKeyX: ByteArray) : PairingCodeParseResult

	/** Not a code at all: wrong length, or a character outside the alphabet. */
	data class Malformed(val reason: String) : PairingCodeParseResult

	/** Well-formed, right length, version 1, but the checksum does not match: almost certainly a typo. */
	data object ChecksumFailed : PairingCodeParseResult

	/** The version symbol is not one this implementation understands. Reported before the checksum is looked at. */
	data class UnknownVersion(val version: Int) : PairingCodeParseResult
}

/**
 * The 36-symbol pairing code.
 *
 * ```
 * VYD5-EFGR-54DN-YVWP-HGJ7-M4J9-H14G-0H2A-TQ4A
 * ```
 *
 * 36 Crockford base32 symbols, displayed as 9 dash-separated groups of 4:
 *
 * | Symbols | Bits | Content |
 * |---|---|---|
 * | 0 | 5 | version, big-endian; v1 = `1` |
 * | 1..32 | 160 | x-coordinate of the initiator's public key, big-endian |
 * | 33..35 | 15 | checksum, big-endian |
 *
 * Every field is a whole number of symbols and 160 bits is exactly 32 symbols, so there is no padding anywhere:
 * the x-coordinate is encoded as 4 blocks of 5 bytes, each block becoming 8 symbols most-significant-first.
 *
 * The checksum is the top 15 bits of `SHA-256(LP("com.icure.pairing.v1.code", versionByte, xBytes))`, with `LP`
 * the length-prefixed concatenation of [lengthPrefixed]. It detects a random error with probability 1 - 2^-15;
 * a single mistyped symbol is caught about 96.9% of the time. It is an error detector for typos, not a MAC.
 *
 * Parsing is case-insensitive, folds `O`→`0` and `I`/`L`→`1`, rejects `U`, ignores dashes, spaces and
 * underscores, and requires exactly 36 symbols after normalisation.
 */
object PairingCode {
	/** Version symbol of the format specified here. */
	const val VERSION_1 = 1

	const val SYMBOL_COUNT = 36
	private const val VERSION_SYMBOLS = 1
	private const val KEY_SYMBOLS = 32
	private const val CHECKSUM_SYMBOLS = 3
	private const val CHECKSUM_BITS = 15
	private const val GROUP_SIZE = 4

	private val CHECKSUM_LABEL = "com.icure.pairing.v1.code".encodeToByteArray()

	/**
	 * Encodes a public key into a displayable code.
	 * @param digest used for the checksum.
	 * @param publicKeyX the x-only public key, [Secp160r1Service.PUBLIC_KEY_BYTES] bytes.
	 * @param version the format version, [VERSION_1] unless testing the version escape hatch.
	 * @return the code as 9 dash-separated groups of 4 uppercase symbols.
	 */
	suspend fun encode(digest: DigestService, publicKeyX: ByteArray, version: Int = VERSION_1): String {
		require(publicKeyX.size == Secp160r1Service.PUBLIC_KEY_BYTES) {
			"Public key must be ${Secp160r1Service.PUBLIC_KEY_BYTES} bytes, got ${publicKeyX.size}"
		}
		require(version in 0..31) { "Version must fit in 5 bits, got $version" }
		val symbols = IntArray(SYMBOL_COUNT)
		symbols[0] = version
		keyToSymbols(publicKeyX, symbols, VERSION_SYMBOLS)
		val checksum = checksum(digest, version, publicKeyX)
		for (i in 0 until CHECKSUM_SYMBOLS) {
			symbols[VERSION_SYMBOLS + KEY_SYMBOLS + i] = (checksum ushr (5 * (CHECKSUM_SYMBOLS - 1 - i))) and 0x1F
		}
		val flat = buildString(SYMBOL_COUNT) { symbols.forEach { append(CrockfordBase32.symbolChar(it)) } }
		return flat.chunked(GROUP_SIZE).joinToString("-")
	}

	/**
	 * Parses a code as typed by a person. See the class documentation for the accepted variations.
	 * @param digest used for the checksum.
	 * @param typed the code as typed, grouping and case optional.
	 */
	suspend fun decode(digest: DigestService, typed: String): PairingCodeParseResult {
		// Surrounding whitespace of any kind (a trailing newline from a paste, say) is not part of the code.
		val normalised = CrockfordBase32.normalise(typed.trim())
			?: return PairingCodeParseResult.Malformed("Contains a character that is not a valid code symbol")
		if (normalised.length != SYMBOL_COUNT) {
			return PairingCodeParseResult.Malformed("Expected $SYMBOL_COUNT symbols, got ${normalised.length}")
		}
		val symbols = IntArray(SYMBOL_COUNT) { CrockfordBase32.symbolValue(normalised[it]) }
		val version = symbols[0]
		if (version != VERSION_1) return PairingCodeParseResult.UnknownVersion(version)
		val publicKeyX = symbolsToKey(symbols, VERSION_SYMBOLS)
		var typedChecksum = 0
		for (i in 0 until CHECKSUM_SYMBOLS) {
			typedChecksum = (typedChecksum shl 5) or symbols[VERSION_SYMBOLS + KEY_SYMBOLS + i]
		}
		if (typedChecksum != checksum(digest, version, publicKeyX)) return PairingCodeParseResult.ChecksumFailed
		return PairingCodeParseResult.Parsed(version, publicKeyX)
	}

	/** The 15-bit checksum for a version and key. Exposed for tests that need to forge a code deliberately. */
	internal suspend fun checksum(digest: DigestService, version: Int, publicKeyX: ByteArray): Int {
		val hash = digest.sha256(lengthPrefixed(CHECKSUM_LABEL, byteArrayOf(version.toByte()), publicKeyX))
		val top16 = ((hash[0].toInt() and 0xFF) shl 8) or (hash[1].toInt() and 0xFF)
		return top16 ushr (16 - CHECKSUM_BITS)
	}

	/** 20 bytes -> 32 symbols: 4 blocks of 5 bytes, each block 8 symbols most-significant-first. */
	private fun keyToSymbols(key: ByteArray, out: IntArray, offset: Int) {
		for (block in 0 until 4) {
			var chunk = 0L
			for (b in 0 until 5) chunk = (chunk shl 8) or (key[block * 5 + b].toLong() and 0xFF)
			for (i in 0 until 8) {
				out[offset + block * 8 + i] = ((chunk ushr (5 * (7 - i))) and 0x1F).toInt()
			}
		}
	}

	private fun symbolsToKey(symbols: IntArray, offset: Int): ByteArray {
		val key = ByteArray(Secp160r1Service.PUBLIC_KEY_BYTES)
		for (block in 0 until 4) {
			var chunk = 0L
			for (i in 0 until 8) chunk = (chunk shl 5) or symbols[offset + block * 8 + i].toLong()
			for (b in 0 until 5) key[block * 5 + b] = (chunk ushr (8 * (4 - b))).toByte()
		}
		return key
	}
}

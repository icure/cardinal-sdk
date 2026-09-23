package com.icure.cardinal.sdk.crypto.pairing

/**
 * Crockford base32 symbol handling, tuned for codes that a human types.
 *
 * This is deliberately *not* [com.icure.kryptom.utils.base32Encode], which implements RFC 4648
 * table 3. RFC 4648 keeps `I`, `L`, `O` and `U` in the alphabet, which is exactly what you do not
 * want when a person is reading a code off one screen and typing it into another:
 * `I`/`1`/`l`, `O`/`0` and `U` (which can turn a random code into an obscenity) are the classic
 * transcription failures.
 *
 * The Crockford alphabet drops all four and, on input, folds the ambiguous glyphs onto the digit
 * the user almost certainly meant.
 *
 * Note that this codec works on *symbols*, not on packed bytes. Short codes here are generated as
 * a sequence of uniform 5-bit symbols rather than by packing a byte array, which avoids the
 * "95 bits does not divide into 8" problem entirely and removes a whole class of bit-padding bugs.
 */
internal object CrockfordBase32 {

    /** 32 symbols: digits plus uppercase letters, excluding `I`, `L`, `O` and `U`. */
    const val ALPHABET: String = "0123456789ABCDEFGHJKMNPQRSTVWXYZ"

    /** Characters silently ignored when parsing, so users may type or omit the grouping dashes. */
    private const val IGNORED: String = "- \t –—_"

    /**
     * Maps a typed character to its symbol value, or -1 if it is not a valid symbol.
     *
     * Case insensitive. `O`/`o` fold to `0`; `I`/`i`/`L`/`l` fold to `1`. `U`/`u` is rejected
     * rather than folded, matching Crockford: it is not in the alphabet and folding it would
     * silently accept a code that was never issued.
     */
    fun symbolValue(c: Char): Int {
        val upper = c.uppercaseChar()
        return when (upper) {
            'O' -> 0
            'I', 'L' -> 1
            else -> ALPHABET.indexOf(upper)
        }
    }

    fun isIgnored(c: Char): Boolean = IGNORED.indexOf(c) >= 0

    fun symbolChar(value: Int): Char {
        require(value in 0..31) { "Symbol value out of range: $value" }
        return ALPHABET[value]
    }

    /**
     * Normalises a typed string to its canonical symbol sequence.
     *
     * @return the canonical uppercase symbol string, or null if any character is neither an
     *   ignorable separator nor a valid symbol.
     */
    fun normalise(typed: String): String? {
        val out = StringBuilder(typed.length)
        for (c in typed) {
            if (isIgnored(c)) continue
            val v = symbolValue(c)
            if (v < 0) return null
            out.append(ALPHABET[v])
        }
        return out.toString()
    }
}

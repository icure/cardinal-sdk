package com.icure.cardinal.sdk.crypto.pairing

/**
 * Length-prefixed concatenation: every field is preceded by its length as 4 bytes big-endian.
 *
 * This is what makes domain separation actually separate. Plain concatenation hashes `("ab", "c")` and
 * `("a", "bc")` identically, so a label would no longer bind the fields that follow it. Every digest input in the
 * pairing scheme goes through this function; there is a test for the ambiguity and it must stay.
 */
internal fun lengthPrefixed(vararg fields: ByteArray): ByteArray {
	val out = ByteArray(fields.sumOf { it.size + 4 })
	var offset = 0
	for (field in fields) {
		val n = field.size
		out[offset] = (n ushr 24).toByte()
		out[offset + 1] = (n ushr 16).toByte()
		out[offset + 2] = (n ushr 8).toByte()
		out[offset + 3] = n.toByte()
		field.copyInto(out, offset + 4)
		offset += 4 + n
	}
	return out
}

package com.icure.cardinal.sdk.test

import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.kryptom.utils.toHexString
import io.kotest.assertions.fail
import io.kotest.matchers.shouldBe
import kotlin.random.Random

infix fun String?.shouldBeNextRevOf(otherRev: String?) {
	if (this == null) fail("null rev is not next rev of any valid rev")
	require("^\\d+-[a-fA-F0-9]{32}\$".toRegex().matches(this)) {
		"$this is not a valid rev"
	}
	val thisVersion = split("-", limit = 2).first().toInt()
	val otherVersion = otherRev?.let {
		require("^\\d+-[a-fA-F0-9]{32}\$".toRegex().matches(it)) {
			"$it is not a valid rev"
		}
		it.split("-", limit = 2).first().toInt()
	} ?: 0
	thisVersion shouldBe (otherVersion + 1)
}

/**
 * Unsafe random uuid generation
 */
@OptIn(ExperimentalUnsignedTypes::class)
fun Random.nextUuid(): String {
	val bytes = nextBytes(16).toUByteArray()
	// Set version 4
	bytes[6] = (bytes[6] and 0x0fu) or 0x40u
	// Set IETF variant
	bytes[8] = (bytes[8] and 0x3fu) or 0x80u
	val s = bytes.toHexString()
	return "${s.substring(0, 8)}-${s.substring(8, 12)}-${s.substring(12, 16)}-${s.substring(16, 20)}-${
		s.substring(
			20
		)
	}"
}

suspend fun <T : Any> PaginatedListIterator<T>.toList(): List<T> = buildList {
	while (hasNext()) addAll(next(100))
}
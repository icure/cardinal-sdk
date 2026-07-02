package com.icure.cardinal.sdk.utils

/**
 * Given to [Collection] of [T], returns a [List] of [Pair]s of all the possible combination
 * between the elements of the two collections.
 *
 * @receiver a [Collection] of [T].
 * @param other a [Collection] of [T].
 * @return a [List] of the [Pair]s containing all the possible combinations between the elements of the receiver and [other]-
 */
internal infix fun <T> Collection<T>.vectorProduct(other: Collection<T>): List<Pair<T, T>> = flatMap { a -> other.map { b -> a to b } }

internal fun <T> List<T>.requireUniqueElements(collectionName: String = "Collection") {
	require (this.size == this.toSet().size) {
		"$collectionName contains duplicate elements: ${this.groupingBy { it }.eachCount().filter { it.value > 1 }.keys}"
	}
}

/**
 * Returns true if this set and [other] share at least one element.
 */
fun <T> Set<T>.intersects(other: Set<T>): Boolean {
	val (smaller, larger) = if (this.size <= other.size) this to other else other to this
	for (element in smaller) {
		if (element in larger) return true
	}
	return false
}

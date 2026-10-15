package com.icure.cardinal.sdk.customsdk.commons.model

import com.icure.cardinal.sdk.model.dao.KeyComponent

/**
 * Compares [KeyComponent]s of the same concrete type by their value, with `null` values coming first.
 *
 * @throws IllegalArgumentException if the two components are not of the same concrete type.
 */
object KeyComponentComparator : Comparator<KeyComponent> {
	override fun compare(a: KeyComponent, b: KeyComponent): Int = when (a) {
		is KeyComponent.IntKeyComponent -> compareValues(a.value, b.requireSameType(a).value)
		is KeyComponent.LongKeyComponent -> compareValues(a.value, b.requireSameType(a).value)
		is KeyComponent.DoubleKeyComponent -> compareValues(a.value, b.requireSameType(a).value)
		is KeyComponent.BooleanKeyComponent -> compareValues(a.value, b.requireSameType(a).value)
		is KeyComponent.StringKeyComponent -> compareValues(a.value, b.requireSameType(a).value)
	}

	private inline fun <reified T : KeyComponent> KeyComponent.requireSameType(other: T): T {
		require(this is T) { "Cannot compare key components of different types: $other and $this" }
		return this
	}
}

/**
 * Compares lists of [KeyComponent]s (complex view keys) element by element using [KeyComponentComparator].
 * If one list is a prefix of the other, the shorter list comes first.
 */
object KeyComponentListComparator : Comparator<List<KeyComponent>> {
	override fun compare(a: List<KeyComponent>, b: List<KeyComponent>): Int {
		for (i in 0 until minOf(a.size, b.size)) {
			val comparison = KeyComponentComparator.compare(a[i], b[i])
			if (comparison != 0) return comparison
		}
		return a.size.compareTo(b.size)
	}
}

package com.icure.cardinal.sdk.utils.pagination

import com.icure.cardinal.sdk.customsdk.commons.model.KeyComponentComparator
import com.icure.cardinal.sdk.customsdk.commons.model.ViewManifest
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.dao.IdWithValue
import com.icure.cardinal.sdk.model.filter.CustomFilter

internal class CollectingSortingCustomViewPageIterator(
	initialFilter: CustomFilter,
	manifest: ViewManifest,
	doFilter: suspend (filter: CustomFilter) -> PaginatedList<IdWithValue>,
) : AbstractCustomViewPageIterator(
	initialFilter = initialFilter,
	manifest = manifest,
	doFilter = doFilter
) {

	private val valueComparator = require(manifest.keyFieldsComparatorOrder.isNotEmpty()) {
		"Manifest fields cannot be empty in a frontend-sorted view"
	}.let {
		Comparator<IdWithParsedValue> { a, b ->
			manifest.keyFieldsComparatorOrder.firstNotNullOfOrNull { field ->
				KeyComponentComparator.compare(
					a.value.getValue(field),
					b.value.getValue(field)
				).takeIf { it != 0 }
			} ?: 0
		}
	}

	private suspend fun exhaustRequestAndSortBuffer() {
		tailrec suspend fun recursively() {
			if (canRetrieveMore) {
				retrieveBatch()
				recursively()
			}
		}
		recursively()
		buffer = buffer.sortedWith(valueComparator)
	}

	override suspend fun hasNext(): Boolean {
		if (canRetrieveMore) {
			exhaustRequestAndSortBuffer()
		}
		return buffer.isNotEmpty()
	}

	override suspend fun next(limit: Int): List<String> =
		if (hasNext()) {
			consumeBuffer(limit).map { it.id }
		} else {
			emptyList()
		}
}

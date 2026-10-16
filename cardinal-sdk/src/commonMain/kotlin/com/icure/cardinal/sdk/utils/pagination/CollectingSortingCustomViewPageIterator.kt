package com.icure.cardinal.sdk.utils.pagination

import com.icure.cardinal.sdk.customsdk.commons.model.KeyComponentComparator
import com.icure.cardinal.sdk.customsdk.commons.model.ViewManifest
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.PaginationError
import com.icure.cardinal.sdk.model.dao.IdWithValue
import com.icure.cardinal.sdk.model.filter.CustomFilter

/**
 * Iterates over the ids of all the entities matching a [CustomFilter], sorted by the value fields listed in
 * [ViewManifest.keyFieldsComparatorOrder].
 *
 * Since the sorting is done in the frontend, the whole view is retrieved on the first call to [hasNext] or [next].
 * If the backend aborts a page (non-null [PaginatedList.error]) no row is returned, since the sorted result would be incomplete,
 * and [hasNext] and [next] throw an [IllegalStateException].
 */
internal class CollectingSortingCustomViewPageIterator(
	initialFilter: CustomFilter,
	private val manifest: ViewManifest,
	doFilter: suspend (filter: CustomFilter) -> PaginatedList<IdWithValue>,
) : PaginatedListIterator<String> {
	private val fetcher = CustomViewRowFetcher(initialFilter, manifest, doFilter)
	private var sortedIds: List<String>? = null
	private var nextIndex = 0
	private var abortError: PaginationError? = null

	init {
		require(manifest.keyFieldsComparatorOrder.isNotEmpty()) {
			"Manifest fields cannot be empty in a frontend-sorted view"
		}
	}

	private val rowComparator = Comparator<CustomViewRow> { a, b ->
		manifest.keyFieldsComparatorOrder.firstNotNullOfOrNull { field ->
			KeyComponentComparator.compare(a.value.getValue(field), b.value.getValue(field)).takeIf { it != 0 }
		} ?: 0
	}

	override suspend fun hasNext(): Boolean = nextIndex < getSortedIds().size

	override suspend fun next(limit: Int): List<String> {
		val ids = getSortedIds()
		val endIndex = minOf(nextIndex + limit, ids.size)
		return ids.subList(nextIndex, endIndex).toList().also { nextIndex = endIndex }
	}

	private suspend fun getSortedIds(): List<String> {
		abortError?.let { throw it.toAbortedPageException() }
		return sortedIds ?: collectAllRows()
			.sortedWith(rowComparator)
			.map { it.id }
			.also { sortedIds = it }
	}

	private suspend fun collectAllRows(): List<CustomViewRow> {
		val rows = mutableListOf<CustomViewRow>()
		while (fetcher.canFetchMore) {
			val batch = fetcher.fetchBatch()
			batch.error?.let {
				abortError = it
				throw it.toAbortedPageException()
			}
			rows.addAll(batch.rows)
		}
		return rows
	}
}

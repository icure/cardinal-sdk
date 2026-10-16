package com.icure.cardinal.sdk.utils.pagination

import com.icure.cardinal.sdk.customsdk.commons.model.ViewManifest
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.PaginationError
import com.icure.cardinal.sdk.model.dao.IdWithValue
import com.icure.cardinal.sdk.model.filter.CustomFilter

/**
 * Iterates over the ids of all the entities matching a [CustomFilter], in the order returned by the backend, following the
 * pagination cursor until the view is exhausted.
 *
 * If the backend aborts a page (non-null [PaginatedList.error]) the rows returned before the error are still provided,
 * then [hasNext] and [next] throw an [IllegalStateException].
 */
internal class CustomViewPageIterator(
	initialFilter: CustomFilter,
	manifest: ViewManifest,
	doFilter: suspend (filter: CustomFilter) -> PaginatedList<IdWithValue>,
) : PaginatedListIterator<String> {
	private val fetcher = CustomViewRowFetcher(initialFilter, manifest, doFilter)
	private val buffer = ArrayDeque<String>()
	private var pendingError: PaginationError? = null

	override suspend fun hasNext(): Boolean {
		fillBuffer(1)
		return buffer.isNotEmpty()
	}

	override suspend fun next(limit: Int): List<String> {
		// A page may contain fewer rows than requested, keep fetching until we have enough rows or the view is exhausted.
		fillBuffer(limit)
		return List(minOf(limit, buffer.size)) { buffer.removeFirst() }
	}

	private suspend fun fillBuffer(minSize: Int) {
		throwIfErrorAndBufferEmpty()
		while (buffer.size < minSize && fetcher.canFetchMore && pendingError == null) {
			val batch = fetcher.fetchBatch()
			batch.rows.mapTo(buffer) { it.id }
			pendingError = batch.error
		}
		throwIfErrorAndBufferEmpty()
	}

	private fun throwIfErrorAndBufferEmpty() {
		val error = pendingError
		if (error != null && buffer.isEmpty()) throw error.toAbortedPageException()
	}
}

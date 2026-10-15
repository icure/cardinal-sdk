package com.icure.cardinal.sdk.utils.pagination

import com.icure.cardinal.sdk.customsdk.commons.model.ViewManifest
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.dao.IdWithValue
import com.icure.cardinal.sdk.model.filter.CustomFilter

/**
 * Iterates over the ids of all the entities matching a [CustomFilter], following the pagination cursor returned by the
 * backend until the view is exhausted.
 *
 * If the backend aborts a page (non-null [PaginatedList.error]) the rows returned before the error are still provided,
 * then [hasNext] and [next] throw an [IllegalStateException].
 */
internal class CustomViewPageIterator(
	initialFilter: CustomFilter,
	manifest: ViewManifest,
	doFilter: suspend (filter: CustomFilter) -> PaginatedList<IdWithValue>,
) : AbstractCustomViewPageIterator(
	initialFilter = initialFilter,
	manifest = manifest,
	doFilter = doFilter
) {
	override tailrec suspend fun hasNext(): Boolean {
		throwIfErrorAndBufferEmpty()
		return when {
			buffer.isNotEmpty() -> true
			canRetrieveMore -> {
				retrieveBatch()
				hasNext()
			}
			else -> false
		}
	}

	override suspend fun next(limit: Int): List<String> {
		throwIfErrorAndBufferEmpty()
		// A page may contain fewer rows than requested (e.g. some rows excluded by the value filter), keep fetching
		// until we have enough rows or the view is exhausted.
		while (buffer.size < limit && canRetrieveMore && pendingError == null) {
			retrieveBatch()
		}
		return consumeBuffer(limit).map { it.id }
	}
}

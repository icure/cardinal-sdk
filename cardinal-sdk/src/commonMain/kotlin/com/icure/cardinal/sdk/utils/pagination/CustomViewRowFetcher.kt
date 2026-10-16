package com.icure.cardinal.sdk.utils.pagination

import com.icure.cardinal.sdk.customsdk.commons.model.ViewManifest
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.PaginationError
import com.icure.cardinal.sdk.model.dao.IdWithValue
import com.icure.cardinal.sdk.model.dao.KeyComponent
import com.icure.cardinal.sdk.model.filter.CustomFilter
import com.icure.cardinal.sdk.model.filter.GenericByKeysCustomFilter
import com.icure.cardinal.sdk.model.filter.GenericByRangeCustomFilter

/**
 * Retrieves the rows matching a [CustomFilter] one batch at a time, following the pagination cursor returned by the backend
 * and parsing the value of each row according to the [ViewManifest].
 */
internal class CustomViewRowFetcher(
	private val initialFilter: CustomFilter,
	private val manifest: ViewManifest,
	private val doFilter: suspend (filter: CustomFilter) -> PaginatedList<IdWithValue>,
) {
	private var startedFetching: Boolean = false
	private var cursor: PaginationCursor? = null

	/**
	 * False once the view is exhausted or after the backend aborted a batch.
	 */
	val canFetchMore: Boolean get() = !startedFetching || cursor != null

	/**
	 * Retrieves the next batch of rows. If the backend aborts the batch, the error is returned in [Batch.error] together with the
	 * rows returned before the error, and no further batch can be fetched.
	 */
	suspend fun fetchBatch(): Batch {
		check(canFetchMore) { "No more rows to fetch" }
		startedFetching = true
		val result = doFilter(cursor?.let { initialFilter.withCursor(it) } ?: initialFilter)
		cursor = result.nextKeyPair?.takeIf { result.error == null }?.let {
			PaginationCursor(
				startKey = manifest.parseKey(checkNotNull(it.startKey) { "Next key pair is missing the start key" }),
				startDocumentId = checkNotNull(it.startKeyDocId) { "Next key pair is missing the start document id" },
			)
		}
		return Batch(
			rows = result.rows.map { CustomViewRow(id = it.id, value = manifest.valueConverter.convert(it.value)) },
			error = result.error,
		)
	}

	private fun CustomFilter.withCursor(cursor: PaginationCursor): CustomFilter = when (this) {
		is GenericByKeysCustomFilter -> copy(
			startKey = cursor.startKey,
			startDocumentId = cursor.startDocumentId,
			limit = DEFAULT_BATCH_SIZE,
		)
		is GenericByRangeCustomFilter -> copy(
			startKey = cursor.startKey,
			startDocumentId = cursor.startDocumentId,
			limit = DEFAULT_BATCH_SIZE,
		)
	}

	data class Batch(
		val rows: List<CustomViewRow>,
		val error: PaginationError?,
	)

	private data class PaginationCursor(
		val startKey: List<KeyComponent>,
		val startDocumentId: String,
	)

	private companion object {
		const val DEFAULT_BATCH_SIZE = 10_000
	}
}

internal data class CustomViewRow(
	val id: String,
	val value: Map<String, KeyComponent>,
)

internal fun PaginationError.toAbortedPageException(): IllegalStateException = IllegalStateException(
	"Custom filter page was aborted by the backend ($statusCode): $message" + (exceptionDetail?.let { "\n$it" } ?: ""),
)

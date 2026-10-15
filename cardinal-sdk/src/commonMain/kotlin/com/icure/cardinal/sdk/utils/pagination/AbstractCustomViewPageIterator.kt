package com.icure.cardinal.sdk.utils.pagination

import com.icure.cardinal.sdk.customsdk.commons.model.ViewManifest
import com.icure.cardinal.sdk.customsdk.commons.model.ViewManifest.Companion.SINGLE_VALUE_KEY
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.PaginationError
import com.icure.cardinal.sdk.model.dao.IdWithValue
import com.icure.cardinal.sdk.model.dao.KeyComponent
import com.icure.cardinal.sdk.model.filter.CustomFilter
import com.icure.cardinal.sdk.model.filter.GenericByKeysCustomFilter
import com.icure.cardinal.sdk.model.filter.GenericByRangeCustomFilter
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject

internal abstract class AbstractCustomViewPageIterator(
	protected val initialFilter: CustomFilter,
	protected val manifest: ViewManifest,
	protected val doFilter: suspend (filter: CustomFilter) -> PaginatedList<IdWithValue>,
) : PaginatedListIterator<String> {
	private var startedConsuming: Boolean = false
	private var cursor: PaginationCursor? = null
	protected var pendingError: PaginationError? = null
	protected var buffer = listOf<IdWithParsedValue>()
	private val defaultBatchSize = 10_000

	protected val canRetrieveMore: Boolean get() = !startedConsuming || cursor != null

	protected suspend fun retrieveBatch() {
		startedConsuming = true
		val filterToUse = cursor?.let {
			initialFilter.withCursor(it)
		} ?: initialFilter
		val result = doFilter(filterToUse)
		cursor = result.nextKeyPair?.takeIf { result.error == null }?.let {
			PaginationCursor(
				startKey = parseStartKey(checkNotNull(it.startKey) { "Next key pair is missing the start key" }),
				startDocumentId = checkNotNull(it.startKeyDocId) { "Next key pair is missing the start document id" },
			)
		}
		pendingError = result.error
		buffer = buffer + result.rows.map {
			val parsedValue = when (manifest.valueConverter) {
				ViewManifest.ValueConverter.Null -> emptyMap()
				is ViewManifest.ValueConverter.Scalar -> mapOf(
					SINGLE_VALUE_KEY to manifest.valueConverter.converter.convert(it.value)
				)
				is ViewManifest.ValueConverter.Object -> {
					require(it.value is JsonObject) { "Value for this view must be an object" }
					manifest.valueConverter.converters.mapValues { (key, converter) ->
						converter.convert(it.value.getValue(key))
					}
				}
			}
			IdWithParsedValue(
				id = it.id,
				value = parsedValue
			)
		}
	}

	protected fun consumeBuffer(maxAmount: Int): List<IdWithParsedValue> = buffer.take(maxAmount).also {
		buffer = buffer.drop(maxAmount)
	}

	protected fun throwIfErrorAndBufferEmpty() {
		val error = pendingError
		if (error != null && buffer.isEmpty()) {
			throw IllegalStateException(
				"Custom filter page was aborted by the backend (${error.statusCode}): ${error.message}" +
					(error.exceptionDetail?.let { "\n$it" } ?: ""),
			)
		}
	}

	protected fun CustomFilter.withCursor(cursor: PaginationCursor): CustomFilter = when (this) {
		is GenericByKeysCustomFilter -> copy(
			startKey = cursor.startKey,
			startDocumentId = cursor.startDocumentId,
			limit = defaultBatchSize,
		)
		is GenericByRangeCustomFilter -> copy(
			startKey = cursor.startKey,
			startDocumentId = cursor.startDocumentId,
			limit = defaultBatchSize,
		)
	}

	protected fun parseStartKey(startKey: JsonElement): List<KeyComponent> {
		require(startKey is JsonArray) { "Start key must be an array." }
		require(startKey.size == manifest.keyConverter.size) { "Invalid key size: ${startKey.size}" }
		return startKey.mapIndexed { index, element ->
			manifest.keyConverter[index].convert(element)
		}
	}

	protected data class PaginationCursor(
		val startKey: List<KeyComponent>,
		val startDocumentId: String,
	)

	protected data class IdWithParsedValue(
		val id: String,
		val value: Map<String, KeyComponent>
	)

}

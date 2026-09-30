package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.options.MalformedEntity
import com.icure.cardinal.sdk.options.MalformedEntityHandler
import com.icure.utils.InternalIcureApi
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject

private const val PAGINATED_LIST_ROWS = "rows"

/**
 * Decodes a json array of entities one element at a time, dropping the elements that can't be deserialized and
 * notifying [handler] for each of them.
 */
@InternalIcureApi
class DiscardingListBodyProvider<T : Any>(
	private val elementSerializer: KSerializer<T>,
	private val json: Json,
	private val handler: MalformedEntityHandler,
) : BodyProvider<List<T>> {
	override suspend fun body(response: io.ktor.client.statement.HttpResponse): List<T> =
		json.decodeDiscardingMalformed(
			elements = json.parseToJsonElement(response.bodyAsText()).jsonArray,
			elementSerializer = elementSerializer,
			handler = handler,
			requestUrl = response.call.request.url.toString(),
		)
}

/**
 * Decodes a [PaginatedList] of entities, dropping the rows that can't be deserialized and notifying [handler] for each
 * of them. All the other properties of the page are kept.
 */
@InternalIcureApi
class DiscardingPaginatedListBodyProvider<T : Any>(
	private val elementSerializer: KSerializer<T>,
	private val json: Json,
	private val handler: MalformedEntityHandler,
) : BodyProvider<PaginatedList<T>> {
	override suspend fun body(response: io.ktor.client.statement.HttpResponse): PaginatedList<T> {
		val page = json.parseToJsonElement(response.bodyAsText()).jsonObject
		val pageWithoutRows = json.decodeFromJsonElement(
			PaginatedList.serializer(elementSerializer),
			JsonObject(page - PAGINATED_LIST_ROWS),
		)
		return pageWithoutRows.copy(
			rows = json.decodeDiscardingMalformed(
				elements = page[PAGINATED_LIST_ROWS]?.jsonArray ?: JsonArray(emptyList()),
				elementSerializer = elementSerializer,
				handler = handler,
				requestUrl = response.call.request.url.toString(),
			),
		)
	}
}

private fun <T : Any> Json.decodeDiscardingMalformed(
	elements: JsonArray,
	elementSerializer: KSerializer<T>,
	handler: MalformedEntityHandler,
	requestUrl: String,
): List<T> = elements.mapNotNull { element ->
	try {
		decodeFromJsonElement(elementSerializer, element)
	} catch (e: IllegalArgumentException) {
		// SerializationException extends IllegalArgumentException, which is also thrown by `require` in model init blocks
		handler.onMalformedEntity(
			MalformedEntity(
				entityType = elementSerializer.descriptor.serialName,
				entityId = ((element as? JsonObject)?.get("id") as? JsonPrimitive)?.takeIf { it.isString }?.content,
				json = element,
				error = e,
				requestUrl = requestUrl,
			),
		)
		null
	}
}

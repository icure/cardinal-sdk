package com.icure.cardinal.sdk.options

import kotlinx.serialization.json.JsonElement

/**
 * Strategy used to decode the lists of entities returned by the read endpoints of the backend (get by ids, filter,
 * find, list, ...).
 */
sealed interface EntityListDecodingStrategy {
	/**
	 * If an element of the list can't be deserialized the whole request fails. This is the default behaviour.
	 */
	data object Strict : EntityListDecodingStrategy

	/**
	 * The elements of the list that can't be deserialized are dropped from the result, and [handler] is notified for
	 * each dropped element. Methods returning lists of entities may therefore return fewer entities than requested, and
	 * pages may contain fewer rows than their limit.
	 *
	 * Only applies to list reads of stored entities: single entity reads, write operations and the entities used
	 * internally by the crypto layer (exchange data, exchange data maps, secure delegation key maps, recovery data) are
	 * always decoded strictly. Only type mismatches inside a valid json are recoverable: a response that is not valid
	 * json still fails.
	 *
	 * If [handler] throws the exception is propagated and the request fails.
	 */
	class DiscardMalformed(val handler: MalformedEntityHandler) : EntityListDecodingStrategy
}

/**
 * Receives the entities discarded by [EntityListDecodingStrategy.DiscardMalformed].
 */
fun interface MalformedEntityHandler {
	fun onMalformedEntity(entity: MalformedEntity)
}

/**
 * An element of a list returned by the backend that could not be deserialized and was discarded.
 */
data class MalformedEntity(
	/**
	 * Serial name of the expected type of the element, e.g. "com.icure.cardinal.sdk.model.EncryptedPatient".
	 */
	val entityType: String,
	/**
	 * Value of the `id` property of the raw element, if the element is an object and its id is a string.
	 */
	val entityId: String?,
	/**
	 * The raw element as returned by the backend.
	 * This contains all the non-encrypted data of the entity, including personal data: avoid logging it as is.
	 */
	val json: JsonElement,
	/**
	 * The deserialization failure.
	 */
	val error: IllegalArgumentException,
	/**
	 * Url of the request that returned the element.
	 */
	val requestUrl: String,
)

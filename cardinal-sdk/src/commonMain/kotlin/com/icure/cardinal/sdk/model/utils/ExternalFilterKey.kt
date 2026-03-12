package com.icure.cardinal.sdk.model.utils

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlin.Any
import kotlin.Long
import kotlin.String

/**
 * Sealed interface representing a typed filter key used when constructing external filter queries.
 * Implementations cover string, long, and complex (JSON node) key types.
 * /
 */
@Serializable
public sealed interface ExternalFilterKey {
	public val key: Any

	/**
	 *
	 *  A filter key backed by a string value.
	 */
	@Serializable
	@SerialName("string")
	public data class ExternalFilterStringKey(
		/**
		 * The string key value.
		 */
		override val key: String,
	) : ExternalFilterKey

	/**
	 *
	 *  A filter key backed by a long integer value.
	 */
	@Serializable
	@SerialName("long")
	public data class ExternalFilterLongKey(
		/**
		 * The long key value.
		 */
		override val key: Long,
	) : ExternalFilterKey

	/**
	 *
	 *  A filter key backed by an arbitrary JSON node, suitable for composite or structured keys.
	 */
	@Serializable
	@SerialName("complexKey")
	public data class ExternalFilterComplexKey(
		/**
		 * The JSON node representing the complex key value.
		 */
		override val key: JsonElement,
	) : ExternalFilterKey
}

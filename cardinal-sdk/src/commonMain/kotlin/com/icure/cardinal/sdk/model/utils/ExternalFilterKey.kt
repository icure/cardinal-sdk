package com.icure.cardinal.sdk.model.utils

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlin.Any
import kotlin.Long
import kotlin.String

@Serializable
public sealed interface ExternalFilterKey {
	public val key: Any

	@Serializable
	@SerialName("string")
	public data class ExternalFilterStringKey(
		override val key: String,
	) : ExternalFilterKey

	@Serializable
	@SerialName("long")
	public data class ExternalFilterLongKey(
		override val key: Long,
	) : ExternalFilterKey

	@Serializable
	@SerialName("complexKey")
	public data class ExternalFilterComplexKey(
		override val key: JsonElement,
	) : ExternalFilterKey
}

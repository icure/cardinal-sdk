package com.icure.cardinal.sdk.model.couchdb

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class SortDirection(
	internal val dtoSerialName: String,
) {
	@SerialName("asc")
	Asc("asc"),

	@SerialName("desc")
	Desc("desc"),
}

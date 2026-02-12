package com.icure.cardinal.sdk.model.filter

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class VersionFiltering(
	internal val dtoSerialName: String,
) {
	@SerialName("LATEST")
	Latest("LATEST"),

	@SerialName("ANY")
	Any("ANY"),
}

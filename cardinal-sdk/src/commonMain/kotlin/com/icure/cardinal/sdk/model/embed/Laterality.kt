package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class Laterality(
	internal val dtoSerialName: String,
) {
	@SerialName("left")
	Left("left"),

	@SerialName("right")
	Right("right"),
}

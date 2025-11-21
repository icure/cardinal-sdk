package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class UserAccessLevel(
	internal val dtoSerialName: String,
) {
	@SerialName("Admin")
	Admin("Admin"),

	@SerialName("Read")
	Read("Read"),

	@SerialName("Write")
	Write("Write"),
}

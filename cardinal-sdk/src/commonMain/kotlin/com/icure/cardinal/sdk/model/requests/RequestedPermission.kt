package com.icure.cardinal.sdk.model.requests

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class RequestedPermission(
	internal val dtoSerialName: String,
) {
	@SerialName("MAX_READ")
	MaxRead("MAX_READ"),

	@SerialName("FULL_READ")
	FullRead("FULL_READ"),

	@SerialName("MAX_WRITE")
	MaxWrite("MAX_WRITE"),

	@SerialName("FULL_WRITE")
	FullWrite("FULL_WRITE"),

	@SerialName("ROOT")
	Root("ROOT"),
}

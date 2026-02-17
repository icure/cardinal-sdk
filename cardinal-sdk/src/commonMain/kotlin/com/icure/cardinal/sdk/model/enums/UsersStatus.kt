package com.icure.cardinal.sdk.model.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class UsersStatus(
	internal val dtoSerialName: String,
) {
	@SerialName("ACTIVE")
	Active("ACTIVE"),

	@SerialName("DISABLED")
	Disabled("DISABLED"),

	@SerialName("REGISTERING")
	Registering("REGISTERING"),
}

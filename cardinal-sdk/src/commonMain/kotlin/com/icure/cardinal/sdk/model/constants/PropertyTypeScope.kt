package com.icure.cardinal.sdk.model.constants

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class PropertyTypeScope(
	internal val dtoSerialName: String,
) {
	@SerialName("SYSTEM")
	System("SYSTEM"),

	@SerialName("NODE")
	Node("NODE"),

	@SerialName("ROLE")
	Role("ROLE"),

	@SerialName("USER")
	User("USER"),

	@SerialName("EVENT")
	Event("EVENT"),
}

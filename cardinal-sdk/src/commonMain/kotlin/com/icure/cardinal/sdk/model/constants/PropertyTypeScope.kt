package com.icure.cardinal.sdk.model.constants

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Defines the scope at which a property type applies within the iCure system.
 *  Scopes range from system-wide settings to per-user or per-event configurations.
 */
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

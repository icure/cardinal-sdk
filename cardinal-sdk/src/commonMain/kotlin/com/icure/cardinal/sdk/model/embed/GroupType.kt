package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class GroupType(
	internal val dtoSerialName: String,
) {
	@SerialName("root")
	Root("root"),

	@SerialName("app")
	App("app"),

	@SerialName("database")
	Database("database"),
}

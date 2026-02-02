package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class CareTeamMemberType(
	internal val dtoSerialName: String,
) {
	@SerialName("physician")
	Physician("physician"),

	@SerialName("specialist")
	Specialist("specialist"),

	@SerialName("other")
	Other("other"),
}

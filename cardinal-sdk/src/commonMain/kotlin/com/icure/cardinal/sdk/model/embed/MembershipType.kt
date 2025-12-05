package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class MembershipType(
	internal val dtoSerialName: String,
) {
	@SerialName("doctor")
	Doctor("doctor"),

	@SerialName("mutuality")
	Mutuality("mutuality"),

	@SerialName("patient")
	Patient("patient"),

	@SerialName("specialist")
	Specialist("specialist"),

	@SerialName("other")
	Other("other"),
}

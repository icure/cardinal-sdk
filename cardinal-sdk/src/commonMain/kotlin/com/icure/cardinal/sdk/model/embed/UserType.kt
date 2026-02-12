package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class UserType(
	internal val dtoSerialName: String,
) {
	@SerialName("HCP")
	Hcp("HCP"),

	@SerialName("PATIENT")
	Patient("PATIENT"),

	@SerialName("DEVICE")
	Device("DEVICE"),

	@SerialName("USER")
	User("USER"),
}

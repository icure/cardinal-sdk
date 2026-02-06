package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class TaskStatus(
	internal val dtoSerialName: String,
) {
	@SerialName("pending")
	Pending("pending"),

	@SerialName("ongoing")
	Ongoing("ongoing"),

	@SerialName("cancelled")
	Cancelled("cancelled"),

	@SerialName("completed")
	Completed("completed"),
}

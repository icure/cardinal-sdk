package com.icure.cardinal.sdk.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class TopicRole(
	internal val dtoSerialName: String,
) {
	@SerialName("PARTICIPANT")
	Participant("PARTICIPANT"),

	@SerialName("ADMIN")
	Admin("ADMIN"),

	@SerialName("OWNER")
	Owner("OWNER"),
}

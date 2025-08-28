package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class NotificationEvent(
	@Serializable(with = InstantSerializer::class)
	public val date: Instant? = null,
	public val status: Status? = null,
) {
	@Serializable
	public enum class Status(
		internal val dtoSerialName: String,
	) {
		@SerialName("SENT")
		Sent("SENT"),

		@SerialName("RECEIVED")
		Received("RECEIVED"),

		@SerialName("ERROR")
		Error("ERROR"),
	}
}

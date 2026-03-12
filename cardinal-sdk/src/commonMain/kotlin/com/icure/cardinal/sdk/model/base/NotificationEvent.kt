package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.time.Instant

/**
 * Data transfer object representing a notification event with a timestamp and delivery status.
 * /
 */
@Serializable
public data class NotificationEvent(
	/**
	 * The instant when the notification event occurred.
	 */
	@Serializable(with = InstantSerializer::class)
	public val date: Instant? = null,
	/**
	 * The delivery status of the notification (SENT, RECEIVED, or ERROR).
	 */
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

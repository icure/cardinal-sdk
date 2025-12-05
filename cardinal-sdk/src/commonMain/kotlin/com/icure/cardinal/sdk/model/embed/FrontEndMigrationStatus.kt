package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class FrontEndMigrationStatus(
	internal val dtoSerialName: String,
) {
	@SerialName("STARTED")
	Started("STARTED"),

	@SerialName("PAUSED")
	Paused("PAUSED"),

	@SerialName("ERROR")
	Error("ERROR"),

	@SerialName("SUCCESS")
	Success("SUCCESS"),
}

package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class Trigger(
	internal val dtoSerialName: String,
) {
	@SerialName("INIT")
	Init("INIT"),

	@SerialName("CHANGE")
	Change("CHANGE"),

	@SerialName("CLICK")
	Click("CLICK"),

	@SerialName("VISIBLE")
	Visible("VISIBLE"),

	@SerialName("ERROR")
	Error("ERROR"),

	@SerialName("VALID")
	Valid("VALID"),

	@SerialName("EVENT")
	Event("EVENT"),
}

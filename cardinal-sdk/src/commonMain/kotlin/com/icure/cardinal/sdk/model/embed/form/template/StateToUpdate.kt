package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class StateToUpdate(
	internal val dtoSerialName: String,
) {
	@SerialName("VALUE")
	Value("VALUE"),

	@SerialName("VISIBLE")
	Visible("VISIBLE"),

	@SerialName("READONLY")
	Readonly("READONLY"),

	@SerialName("CLAZZ")
	Clazz("CLAZZ"),

	@SerialName("REQUIRED")
	Required("REQUIRED"),
}

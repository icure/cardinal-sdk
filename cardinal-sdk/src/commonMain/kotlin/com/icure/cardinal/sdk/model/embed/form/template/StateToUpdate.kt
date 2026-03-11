package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the aspects of a form field state that can be updated by an action.
 */
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

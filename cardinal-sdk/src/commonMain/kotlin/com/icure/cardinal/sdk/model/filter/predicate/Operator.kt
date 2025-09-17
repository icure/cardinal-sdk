package com.icure.cardinal.sdk.model.filter.predicate

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class Operator(
	public val code: String,
	internal val dtoSerialName: String,
) {
	@SerialName("EQUAL")
	Equal("==", "EQUAL"),

	@SerialName("NOTEQUAL")
	Notequal("!=", "NOTEQUAL"),

	@SerialName("GREATERTHAN")
	Greaterthan(">", "GREATERTHAN"),

	@SerialName("SMALLERTHAN")
	Smallerthan("<", "SMALLERTHAN"),

	@SerialName("GREATERTHANOREQUAL")
	Greaterthanorequal(">=", "GREATERTHANOREQUAL"),

	@SerialName("SMALLERTHANOREQUAL")
	Smallerthanorequal("<=", "SMALLERTHANOREQUAL"),

	@SerialName("LIKE")
	Like("%=", "LIKE"),

	@SerialName("ILIKE")
	Ilike("%%=", "ILIKE"),
}

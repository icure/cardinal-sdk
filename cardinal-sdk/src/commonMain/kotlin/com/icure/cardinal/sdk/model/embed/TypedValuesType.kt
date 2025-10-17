package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class TypedValuesType(
	internal val dtoSerialName: kotlin.String,
) {
	@SerialName("BOOLEAN")
	Boolean("BOOLEAN"),

	@SerialName("INTEGER")
	Integer("INTEGER"),

	@SerialName("DOUBLE")
	Double("DOUBLE"),

	@SerialName("STRING")
	String("STRING"),

	@SerialName("DATE")
	Date("DATE"),

	@SerialName("CLOB")
	Clob("CLOB"),

	@SerialName("JSON")
	Json("JSON"),
}

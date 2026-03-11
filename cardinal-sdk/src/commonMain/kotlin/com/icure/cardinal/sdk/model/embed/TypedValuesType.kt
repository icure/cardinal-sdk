// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 *  Enumerates the possible types for a typed value.
 */
@Serializable
enum class TypedValuesType(
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

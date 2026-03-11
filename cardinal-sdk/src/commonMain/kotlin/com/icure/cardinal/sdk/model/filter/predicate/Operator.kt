// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.predicate

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Comparison operators for use in key-value predicates.
 */
@Serializable
enum class Operator(
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

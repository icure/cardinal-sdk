package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class Gender(
	public val code: String,
	internal val dtoSerialName: String,
) {
	@SerialName("male")
	Male("M", "male"),

	@SerialName("female")
	Female("F", "female"),

	@SerialName("indeterminate")
	Indeterminate("I", "indeterminate"),

	@SerialName("changed")
	Changed("C", "changed"),

	@SerialName("changedToMale")
	ChangedToMale("Y", "changedToMale"),

	@SerialName("changedToFemale")
	ChangedToFemale("X", "changedToFemale"),

	@SerialName("unknown")
	Unknown("U", "unknown"),
}

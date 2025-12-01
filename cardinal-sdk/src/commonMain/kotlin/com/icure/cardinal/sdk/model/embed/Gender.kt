package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class Gender(
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

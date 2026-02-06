package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class InsuranceStatus(
	internal val dtoSerialName: String,
) {
	@SerialName("titular")
	Titular("titular"),

	@SerialName("child")
	Child("child"),

	@SerialName("spouse")
	Spouse("spouse"),
}

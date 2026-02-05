package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class FlatRateType(
	internal val dtoSerialName: String,
) {
	@SerialName("physician")
	Physician("physician"),

	@SerialName("physiotherapist")
	Physiotherapist("physiotherapist"),

	@SerialName("nurse")
	Nurse("nurse"),

	@SerialName("ptd")
	Ptd("ptd"),
}

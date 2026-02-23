package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class ReportVersion(
	internal val dtoSerialName: String,
) {
	@SerialName("V1_0_0")
	V1_0_0("V1_0_0"),
}

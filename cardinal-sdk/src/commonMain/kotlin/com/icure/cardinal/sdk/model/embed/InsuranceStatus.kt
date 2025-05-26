package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class InsuranceStatus(
	internal val dtoSerialName: String,
) {
	@SerialName("titular")
	Titular("titular"),

	@SerialName("child")
	Child("child"),

	@SerialName("spouse")
	Spouse("spouse"),
}

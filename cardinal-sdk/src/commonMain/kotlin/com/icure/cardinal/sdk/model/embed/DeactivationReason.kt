package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class DeactivationReason(
	internal val dtoSerialName: String,
) {
	@SerialName("deceased")
	Deceased("deceased"),

	@SerialName("moved")
	Moved("moved"),

	@SerialName("other_doctor")
	OtherDoctor("other_doctor"),

	@SerialName("retired")
	Retired("retired"),

	@SerialName("no_contact")
	NoContact("no_contact"),

	@SerialName("unknown")
	Unknown("unknown"),

	@SerialName("none")
	None("none"),
}

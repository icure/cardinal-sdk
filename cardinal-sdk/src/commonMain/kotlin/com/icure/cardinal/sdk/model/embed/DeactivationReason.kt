package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class DeactivationReason(
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

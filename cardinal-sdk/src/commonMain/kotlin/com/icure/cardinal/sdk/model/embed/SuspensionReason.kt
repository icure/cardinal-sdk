package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class SuspensionReason(
	internal val dtoSerialName: String,
) {
	@SerialName("notInsured")
	NotInsured("notInsured"),

	@SerialName("noReasonGiven")
	NoReasonGiven("noReasonGiven"),

	@SerialName("isHospitalized")
	IsHospitalized("isHospitalized"),

	@SerialName("outsideOfCountry")
	OutsideOfCountry("outsideOfCountry"),

	@SerialName("changeOfMutuality")
	ChangeOfMutuality("changeOfMutuality"),
}

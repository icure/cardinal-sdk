package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the possible reasons for suspending a medical house contract.
 */
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

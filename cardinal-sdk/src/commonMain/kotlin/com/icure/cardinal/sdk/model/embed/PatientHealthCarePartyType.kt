package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class PatientHealthCarePartyType(
	internal val dtoSerialName: String,
) {
	@SerialName("doctor")
	Doctor("doctor"),

	@SerialName("referral")
	Referral("referral"),

	@SerialName("medicalhouse")
	Medicalhouse("medicalhouse"),

	@SerialName("retirementhome")
	Retirementhome("retirementhome"),

	@SerialName("hospital")
	Hospital("hospital"),

	@SerialName("other")
	Other("other"),

	@SerialName("referringphysician")
	Referringphysician("referringphysician"),

	@SerialName("managingorganization")
	Managingorganization("managingorganization"),
}

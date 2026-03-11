// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the types of relationships between a patient and a healthcare party.
 */
@Serializable
enum class PatientHealthCarePartyType(
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

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enum class representing the participant types for an encounter/contact
 *
 *  Mostly based on HL7 FHIR R4
 */
@Serializable
enum class ParticipantType(
	internal val dtoSerialName: String,
) {
	@SerialName("admitter")
	Admitter("admitter"),

	@SerialName("attender")
	Attender("attender"),

	@SerialName("callback")
	CallbackContact("callback"),

	@SerialName("consultant")
	Consultant("consultant"),

	@SerialName("discharger")
	Discharger("discharger"),

	@SerialName("escort")
	Escort("escort"),

	@SerialName("referrer")
	Referrer("referrer"),

	@SerialName("secondaryPerformer")
	SecondaryPerformer("secondaryPerformer"),

	@SerialName("primaryPerformer")
	PrimaryPerformer("primaryPerformer"),

	@SerialName("participation")
	Participation("participation"),

	@SerialName("translator")
	Translator("translator"),

	@SerialName("emergency")
	Emergency("emergency"),

	@SerialName("location")
	Location("location"),

	@SerialName("recorder")
	Recorder("recorder"),
}

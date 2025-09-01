package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class ParticipantType(
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
}

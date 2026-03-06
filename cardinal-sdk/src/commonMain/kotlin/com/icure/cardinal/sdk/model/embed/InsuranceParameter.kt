package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class InsuranceParameter(
	internal val dtoSerialName: String,
) {
	@SerialName("status")
	Status("status"),

	@SerialName("tc1")
	Tc1("tc1"),

	@SerialName("tc2")
	Tc2("tc2"),

	@SerialName("preferentialstatus")
	Preferentialstatus("preferentialstatus"),

	@SerialName("chronicaldisease")
	Chronicaldisease("chronicaldisease"),

	@SerialName("paymentapproval")
	Paymentapproval("paymentapproval"),

	@SerialName("mdaInputReference")
	MdaInputReference("mdaInputReference"),
}

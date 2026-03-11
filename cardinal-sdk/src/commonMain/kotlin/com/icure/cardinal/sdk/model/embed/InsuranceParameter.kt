// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the parameters that can be associated with an insurance record, such as status codes
 * and approval information.
 */
@Serializable
enum class InsuranceParameter(
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

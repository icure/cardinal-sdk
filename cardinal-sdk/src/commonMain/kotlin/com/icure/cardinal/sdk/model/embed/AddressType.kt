package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class AddressType() {
	@SerialName("home")
	Home("home"),

	@SerialName("work")
	Work("work"),

	@SerialName("vacation")
	Vacation("vacation"),

	@SerialName("hospital")
	Hospital("hospital"),

	@SerialName("clinic")
	Clinic("clinic"),

	@SerialName("hq")
	Hq("hq"),

	@SerialName("other")
	Other("other"),

	@SerialName("temporary")
	Temporary("temporary"),

	@SerialName("postal")
	Postal("postal"),

	@SerialName("diplomatic")
	Diplomatic("diplomatic"),

	@SerialName("reference")
	Reference("reference"),

	@SerialName("careaddress")
	Careaddress("careaddress"),
	;

	public val dtoSerialName: String
}

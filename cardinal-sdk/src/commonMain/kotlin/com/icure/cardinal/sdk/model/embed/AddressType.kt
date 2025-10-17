package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class AddressType(
	internal val dtoSerialName: String,
) {
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
}

package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class TelecomType(
	internal val dtoSerialName: String,
) {
	@SerialName("mobile")
	Mobile("mobile"),

	@SerialName("phone")
	Phone("phone"),

	@SerialName("email")
	Email("email"),

	@SerialName("fax")
	Fax("fax"),

	@SerialName("skype")
	Skype("skype"),

	@SerialName("im")
	Im("im"),

	@SerialName("medibridge")
	Medibridge("medibridge"),

	@SerialName("ehealthbox")
	Ehealthbox("ehealthbox"),

	@SerialName("apicrypt")
	Apicrypt("apicrypt"),

	@SerialName("web")
	Web("web"),

	@SerialName("print")
	Print("print"),

	@SerialName("disk")
	Disk("disk"),

	@SerialName("other")
	Other("other"),

	@SerialName("pager")
	Pager("pager"),
}

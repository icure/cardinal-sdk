// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the types of telecommunication channels available for contacting a person or
 * organization.
 */
@Serializable
enum class TelecomType(
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

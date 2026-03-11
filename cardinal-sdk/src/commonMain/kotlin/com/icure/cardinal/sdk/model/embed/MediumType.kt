// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the medium types through which invoices or documents can be transmitted.
 */
@Serializable
enum class MediumType(
	internal val dtoSerialName: String,
) {
	@SerialName("cdrom")
	Cdrom("cdrom"),

	@SerialName("eattest")
	Eattest("eattest"),

	@SerialName("efact")
	Efact("efact"),

	@SerialName("email")
	Email("email"),

	@SerialName("mediprima")
	Mediprima("mediprima"),

	@SerialName("paper")
	Paper("paper"),

	@SerialName("stat")
	Stat("stat"),
}

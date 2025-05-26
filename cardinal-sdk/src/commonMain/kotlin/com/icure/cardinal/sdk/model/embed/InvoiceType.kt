package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class InvoiceType() {
	@SerialName("patient")
	Patient("patient"),

	@SerialName("mutualfund")
	Mutualfund("mutualfund"),

	@SerialName("payingagency")
	Payingagency("payingagency"),

	@SerialName("insurance")
	Insurance("insurance"),

	@SerialName("efact")
	Efact("efact"),

	@SerialName("other")
	Other("other"),
	;

	public val dtoSerialName: String
}

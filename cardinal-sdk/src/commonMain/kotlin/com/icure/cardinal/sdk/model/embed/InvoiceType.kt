package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class InvoiceType(
	internal val dtoSerialName: String,
) {
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
}

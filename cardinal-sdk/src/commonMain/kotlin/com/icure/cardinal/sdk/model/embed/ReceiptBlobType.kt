package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class ReceiptBlobType(
	internal val dtoSerialName: String,
) {
	@SerialName("xades")
	Xades("xades"),

	@SerialName("kmehrRequest")
	KmehrRequest("kmehrRequest"),

	@SerialName("kmehrResponse")
	KmehrResponse("kmehrResponse"),

	@SerialName("soapRequest")
	SoapRequest("soapRequest"),

	@SerialName("soapResponse")
	SoapResponse("soapResponse"),

	@SerialName("soapConversation")
	SoapConversation("soapConversation"),

	@SerialName("tack")
	Tack("tack"),
}

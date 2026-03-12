package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the types of blobs that can be stored in a receipt, such as XML signatures, KMEHR
 * messages, and SOAP exchanges.
 */
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

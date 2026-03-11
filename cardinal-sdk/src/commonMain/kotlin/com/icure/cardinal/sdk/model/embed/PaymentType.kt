package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the possible payment methods.
 */
@Serializable
public enum class PaymentType(
	internal val dtoSerialName: String,
) {
	@SerialName("cash")
	Cash("cash"),

	@SerialName("wired")
	Wired("wired"),

	@SerialName("insurance")
	Insurance("insurance"),

	@SerialName("creditcard")
	Creditcard("creditcard"),

	@SerialName("debitcard")
	Debitcard("debitcard"),

	@SerialName("paypal")
	Paypal("paypal"),

	@SerialName("bitcoin")
	Bitcoin("bitcoin"),

	@SerialName("other")
	Other("other"),
}

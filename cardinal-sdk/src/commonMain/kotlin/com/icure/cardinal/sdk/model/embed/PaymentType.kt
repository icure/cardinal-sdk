// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  Enumerates the possible payment methods.
 */
@Serializable
enum class PaymentType(
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

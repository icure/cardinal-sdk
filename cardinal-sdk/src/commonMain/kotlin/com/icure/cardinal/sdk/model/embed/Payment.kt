// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.Long

/**
 * Represents a payment record with date, type, and amount.
 * /
 */
@Serializable
data class Payment(
	/**
	 * The date of the payment (unix epoch in ms).
	 */
	@param:DefaultValue("0")
	public val paymentDate: Long = 0,
	/**
	 * The type of payment method used.
	 */
	public val paymentType: PaymentType? = null,
	/**
	 * The amount paid.
	 */
	public val paid: Double? = null,
) {
	// region Payment-Payment

	// endregion
}

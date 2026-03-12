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
public data class Payment(
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
)

package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.Long

@Serializable
public data class Payment(
	@DefaultValue("0")
	public val paymentDate: Long = 0,
	public val paymentType: PaymentType? = null,
	public val paid: Double? = null,
)

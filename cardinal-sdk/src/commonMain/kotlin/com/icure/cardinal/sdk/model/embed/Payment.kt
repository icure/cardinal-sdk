package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.Long

@Serializable
public data class Payment(
	public val paymentDate: Long,
	public val paymentType: PaymentType? = null,
	public val paid: Double? = null,
)

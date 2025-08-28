package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.Long
import com.icure.cardinal.sdk.utils.DefaultValue

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Payment(
	public val paymentDate: Long,
	public val paymentType: PaymentType? = null,
	public val paid: Double? = null,
) {
	// region Payment-Payment

	// endregion
}

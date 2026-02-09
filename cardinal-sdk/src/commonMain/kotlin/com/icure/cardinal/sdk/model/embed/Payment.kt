package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.Long

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Payment(
	@param:DefaultValue("0")
	public val paymentDate: Long = 0,
	public val paymentType: PaymentType? = null,
	public val paid: Double? = null,
) {
	// region Payment-Payment

	// endregion
}

package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Partnership(
	public val type: PartnershipType? = null,
	public val status: PartnershipStatus? = null,
	public val partnerId: String? = null,
) {
	// region Partnership-Partnership

	// endregion
}

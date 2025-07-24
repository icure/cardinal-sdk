package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlin.time.Instant
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ReferralPeriod(
	@Serializable(with = InstantSerializer::class)
	public val startDate: Instant? = null,
	@Serializable(with = InstantSerializer::class)
	public val endDate: Instant? = null,
	public val comment: String? = null,
) {
	// region ReferralPeriod-ReferralPeriod

	// endregion
}

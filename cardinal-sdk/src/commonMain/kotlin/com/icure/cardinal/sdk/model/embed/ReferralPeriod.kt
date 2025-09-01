package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.time.Instant

@Serializable
public data class ReferralPeriod(
	@Serializable(with = InstantSerializer::class)
	public val startDate: Instant? = null,
	@Serializable(with = InstantSerializer::class)
	public val endDate: Instant? = null,
	public val comment: String? = null,
)

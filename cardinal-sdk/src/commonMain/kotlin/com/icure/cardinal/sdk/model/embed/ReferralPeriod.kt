package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.serialization.InstantSerializer
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.time.Instant

/**
 * Represents a time-bounded referral period between a patient and a healthcare party.
 * /
 */
@Serializable
public data class ReferralPeriod(
	/**
	 * The date when the referral period started.
	 */
	@Serializable(with = InstantSerializer::class)
	public val startDate: Instant? = null,
	/**
	 * The date when the referral period ended.
	 */
	@Serializable(with = InstantSerializer::class)
	public val endDate: Instant? = null,
	/**
	 * Comments made during the referral.
	 */
	public val comment: String? = null,
)

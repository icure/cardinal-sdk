// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
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
data class ReferralPeriod(
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
) {
	// region ReferralPeriod-ReferralPeriod

	// endregion
}

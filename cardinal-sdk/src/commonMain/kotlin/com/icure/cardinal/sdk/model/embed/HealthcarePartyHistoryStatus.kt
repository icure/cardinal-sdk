package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

/**
 * Represents a historical status record for a healthcare party, tracking changes in status over
 * time for a given specialisation.
 * /
 */
@Serializable
public data class HealthcarePartyHistoryStatus(
	/**
	 * The healthcare party status at this point in time.
	 */
	public val status: HealthcarePartyStatus,
	/**
	 * The code of the specialisation this status applies to.
	 */
	public val specialisationCode: String,
	/**
	 * The start date (unix epoch in ms) of this status period.
	 */
	public val startDate: Long,
	/**
	 * Whether this status record is currently active.
	 */
	public val active: Boolean,
)

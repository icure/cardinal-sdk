package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Represents a suspension period for a medication, including start and end moments, reason, and
 * lifecycle state.
 * /
 */
@Serializable
public data class Suspension(
	/**
	 * The start moment of the suspension (fuzzy date).
	 */
	public val beginMoment: Long? = null,
	/**
	 * The end moment of the suspension (fuzzy date).
	 */
	public val endMoment: Long? = null,
	/**
	 * The reason for the suspension.
	 */
	public val suspensionReason: String? = null,
	/**
	 * The lifecycle state of the suspension.
	 */
	public val lifecycle: String? = null,
)

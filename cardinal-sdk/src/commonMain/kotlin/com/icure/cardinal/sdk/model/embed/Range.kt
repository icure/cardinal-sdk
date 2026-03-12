package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Double

/**
 *
 *  Represents a numeric range defined by a low and high bound.
 */
@Serializable
public data class Range(
	/**
	 * The lower bound of the range.
	 */
	public val low: Double? = null,
	/**
	 * The upper bound of the range.
	 */
	public val high: Double? = null,
)

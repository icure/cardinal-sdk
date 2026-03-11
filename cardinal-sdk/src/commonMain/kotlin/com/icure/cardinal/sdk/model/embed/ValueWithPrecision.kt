package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Int

/**
 * Represents a numeric value paired with its precision (number of significant digits).
 * /
 */
@Serializable
public data class ValueWithPrecision(
	/**
	 * The numeric value.
	 */
	public val `value`: Int,
	/**
	 * The number of significant digits.
	 */
	public val precision: Int,
)

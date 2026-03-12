package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.model.embed.Measure
import kotlinx.serialization.Serializable

/**
 * Data transfer object representing a pair of measures, typically used for range values or
 * comparative measurements.
 * /
 */
@Serializable
public data class MeasurePair(
	/**
	 * The first measure in the pair.
	 */
	public val first: Measure? = null,
	/**
	 * The second measure in the pair.
	 */
	public val second: Measure? = null,
)

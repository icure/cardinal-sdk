// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.model.embed.Measure
import kotlinx.serialization.Serializable

/**
 * Data transfer object representing a pair of measures, typically used for range values or
 * comparative measurements.
 * /
 */
@Serializable
data class MeasurePair(
	/**
	 * The first measure in the pair.
	 */
	public val first: Measure? = null,
	/**
	 * The second measure in the pair.
	 */
	public val second: Measure? = null,
) {
	// region MeasurePair-MeasurePair

	// endregion
}

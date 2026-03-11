// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
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
data class Suspension(
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
) {
	// region Suspension-Suspension

	// endregion
}

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable
import kotlin.Int

/**
 * Represents a weekday reference used in medication regimens, optionally specifying a week number.
 * /
 */
@Serializable
data class Weekday(
	/**
	 * The coded weekday (CD-WEEKDAY).
	 */
	public val weekday: CodeStub? = null,
	/**
	 * The week number within a cycle, or null if not applicable.
	 */
	public val weekNumber: Int? = null,
) {
	// region Weekday-Weekday

	// endregion
}

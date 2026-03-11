// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Long

/**
 * Represents a time range within a time table, defined by start and end hours.
 * /
 */
@Serializable
data class TimeTableHour(
	/**
	 * The start hour encoded as a long (hh:mm:ss).
	 */
	public val startHour: Long? = null,
	/**
	 * The end hour encoded as a long (hh:mm:ss).
	 */
	public val endHour: Long? = null,
) {
	// region TimeTableHour-TimeTableHour

	// endregion
}

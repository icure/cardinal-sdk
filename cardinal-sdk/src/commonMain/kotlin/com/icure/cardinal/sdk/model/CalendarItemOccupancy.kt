// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.Long

/**
 * One point of a concurrent-occupancy step function for a period of calendar items.
 *
 * The occupancy of a period is emitted as a sequence of these points, ordered by [timestamp]: each
 * point
 * indicates that, starting from [timestamp], the number of overlapping (busy) calendar items
 * becomes [occupancy].
 * /
 */
@Serializable
data class CalendarItemOccupancy(
	/**
	 * A fuzzy date-time at which the occupancy changes.
	 */
	public val timestamp: Long,
	/**
	 * The number of calendar items that are concurrently busy starting from [timestamp].
	 */
	public val occupancy: Long,
) {
	// region CalendarItemOccupancy-CalendarItemOccupancy
	// endregion
}

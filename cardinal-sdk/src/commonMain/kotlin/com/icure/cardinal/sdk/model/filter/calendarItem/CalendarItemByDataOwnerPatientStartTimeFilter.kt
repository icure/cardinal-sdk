// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.calendarItem

import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

/**
 * Filter that matches calendar items by data owner, patient, and start time range.
 * /
 */
@SerialName("CalendarItemByDataOwnerPatientStartTimeFilter")
@Serializable
data class CalendarItemByDataOwnerPatientStartTimeFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The start of the date range (inclusive).
	 */
	public val startDate: Long?,
	/**
	 * The end of the date range (inclusive).
	 */
	public val endDate: Long?,
	/**
	 * The set of secret patient identifiers used for secure delegation matching.
	 */
	public val secretPatientIds: Set<String>,
	/**
	 * Whether to return results in descending order.
	 */
	public val descending: Boolean?,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<CalendarItem> {
	// region CalendarItemByDataOwnerPatientStartTimeFilter-CalendarItemByDataOwnerPatientStartTimeFilter

	// endregion
}

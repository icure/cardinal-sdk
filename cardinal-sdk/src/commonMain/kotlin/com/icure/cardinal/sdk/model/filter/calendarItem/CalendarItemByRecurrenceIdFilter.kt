// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.calendarItem

import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches calendar items by their recurrence identifier.
 * /
 */
@SerialName("CalendarItemByRecurrenceIdFilter")
@Serializable
data class CalendarItemByRecurrenceIdFilter(
	/**
	 * The recurrence identifier to match.
	 */
	public val recurrenceId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<CalendarItem> {
	// region CalendarItemByRecurrenceIdFilter-CalendarItemByRecurrenceIdFilter

	// endregion
}

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
public data class CalendarItemByRecurrenceIdFilter(
	/**
	 * The recurrence identifier to match.
	 */
	public val recurrenceId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<CalendarItem>

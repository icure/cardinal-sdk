package com.icure.cardinal.sdk.model.filter.calendarItem

import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("CalendarItemByRecurrenceIdFilter")
@Serializable
public data class CalendarItemByRecurrenceIdFilter(
	public val recurrenceId: String,
	override val desc: String? = null,
) : AbstractFilter<CalendarItem>

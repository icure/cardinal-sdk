package com.icure.cardinal.sdk.model.filter.calendarItem

import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

@SerialName("CalendarItemByPeriodAndDataOwnerIdFilter")
@Serializable
public data class CalendarItemByPeriodAndDataOwnerIdFilter(
	public val dataOwnerId: String,
	public val startTime: Long,
	public val endTime: Long,
	override val desc: String? = null,
) : AbstractFilter<CalendarItem>

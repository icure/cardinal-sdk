package com.icure.cardinal.sdk.model.filter.calendarItem

import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

@SerialName("CalendarItemByPeriodAndAgendaIdFilter")
@Serializable
public data class CalendarItemByPeriodAndAgendaIdFilter(
	public val agendaId: String,
	public val startTime: Long,
	public val endTime: Long,
	public val descending: Boolean? = null,
	override val desc: String? = null,
) : AbstractFilter<CalendarItem>

package com.icure.cardinal.sdk.model.filter.timetable

import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

@SerialName("TimeTableByPeriodAndAgendaIdFilter")
@Serializable
public data class TimeTableByPeriodAndAgendaIdFilter(
	public val agendaId: String,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
	override val desc: String? = null,
) : AbstractFilter<TimeTable>

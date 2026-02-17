package com.icure.cardinal.sdk.model.filter.timetable

import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("TimeTableByAgendaIdFilter")
@Serializable
public data class TimeTableByAgendaIdFilter(
	public val agendaId: String,
	override val desc: String? = null,
) : AbstractFilter<TimeTable>

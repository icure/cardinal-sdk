package com.icure.cardinal.sdk.model.filter.timetable

import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * Filter that matches timetables by their associated agenda identifier.
 * /
 */
@SerialName("TimeTableByAgendaIdFilter")
@Serializable
public data class TimeTableByAgendaIdFilter(
	/**
	 * The identifier of the agenda.
	 */
	public val agendaId: String,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<TimeTable>

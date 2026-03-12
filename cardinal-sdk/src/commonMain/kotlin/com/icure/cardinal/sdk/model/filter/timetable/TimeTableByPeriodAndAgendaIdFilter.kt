// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.timetable

import com.icure.cardinal.sdk.model.TimeTable
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

/**
 * Filter that matches timetables within a date range for a specific agenda.
 * /
 */
@SerialName("TimeTableByPeriodAndAgendaIdFilter")
@Serializable
data class TimeTableByPeriodAndAgendaIdFilter(
	/**
	 * The identifier of the agenda.
	 */
	public val agendaId: String,
	/**
	 * The start of the date range (inclusive).
	 */
	public val startDate: Long? = null,
	/**
	 * The end of the date range (inclusive).
	 */
	public val endDate: Long? = null,
	/**
	 * Whether to return results in descending order.
	 */
	public val descending: Boolean? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<TimeTable> {
	// region TimeTableByPeriodAndAgendaIdFilter-TimeTableByPeriodAndAgendaIdFilter

	// endregion
}

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

/**
 * Filter that matches calendar items within a time period for a specific agenda.
 * /
 */
@SerialName("CalendarItemByPeriodAndAgendaIdFilter")
@Serializable
data class CalendarItemByPeriodAndAgendaIdFilter(
	/**
	 * The identifier of the agenda.
	 */
	public val agendaId: String,
	/**
	 * The start of the time period.
	 */
	public val startTime: Long,
	/**
	 * The end of the time period.
	 */
	public val endTime: Long,
	/**
	 * Whether to return results in descending order.
	 */
	public val descending: Boolean? = null,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<CalendarItem> {
	// region CalendarItemByPeriodAndAgendaIdFilter-CalendarItemByPeriodAndAgendaIdFilter

	// endregion
}

package com.icure.cardinal.sdk.model.filter.calendarItem

import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

/**
 * Filter that matches calendar items within a time period for a specific data owner.
 * /
 */
@SerialName("CalendarItemByPeriodAndDataOwnerIdFilter")
@Serializable
public data class CalendarItemByPeriodAndDataOwnerIdFilter(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The start of the time period.
	 */
	public val startTime: Long,
	/**
	 * The end of the time period.
	 */
	public val endTime: Long,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<CalendarItem>

package com.icure.cardinal.sdk.model.filter.calendarItem

import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

@SerialName("CalendarItemByDataOwnerPatientStartTimeFilter")
@Serializable
public data class CalendarItemByDataOwnerPatientStartTimeFilter(
	public val dataOwnerId: String,
	public val startDate: Long?,
	public val endDate: Long?,
	public val secretPatientIds: Set<String>,
	public val descending: Boolean?,
	override val desc: String? = null,
) : AbstractFilter<CalendarItem>

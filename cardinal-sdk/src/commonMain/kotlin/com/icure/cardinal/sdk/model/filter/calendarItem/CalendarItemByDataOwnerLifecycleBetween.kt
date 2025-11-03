package com.icure.cardinal.sdk.model.filter.calendarItem

import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

@SerialName("CalendarItemByDataOwnerLifecycleBetween")
@Serializable
public data class CalendarItemByDataOwnerLifecycleBetween(
	public val dataOwnerId: String,
	public val startTimestamp: Long? = null,
	public val endTimestamp: Long? = null,
	@DefaultValue("false")
	public val descending: Boolean = false,
	override val desc: String? = null,
) : AbstractFilter<CalendarItem>

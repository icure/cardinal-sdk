package com.icure.cardinal.sdk.model.filter.calendarItem

import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import com.icure.cardinal.sdk.utils.DefaultValue

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("CalendarItemByDataOwnerLifecycleBetween")
@Serializable
data class CalendarItemByDataOwnerLifecycleBetween(
	dataOwnerId: String,
	startTimestamp: Long? = null,
	endTimestamp: Long? = null,
	descending: Boolean = false,
	desc: String? = null,
) : AbstractFilter<CalendarItem> {
	// region CalendarItemByDataOwnerLifecycleBetween-CalendarItemByDataOwnerLifecycleBetween

	// endregion
}

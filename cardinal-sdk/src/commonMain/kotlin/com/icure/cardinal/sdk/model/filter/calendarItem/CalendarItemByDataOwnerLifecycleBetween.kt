package com.icure.cardinal.sdk.model.filter.calendarItem

import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("CalendarItemByDataOwnerLifecycleBetween")
@Serializable
data class CalendarItemByDataOwnerLifecycleBetween(
	public val dataOwnerId: String,
	public val startTimestamp: Long? = null,
	public val endTimestamp: Long? = null,
	@DefaultValue("false")
	public val descending: Boolean = false,
	override val desc: String? = null,
) : AbstractFilter<CalendarItem> {
	public val dtoSerialName: String
	// region CalendarItemByDataOwnerLifecycleBetween-CalendarItemByDataOwnerLifecycleBetween

	// endregion
}

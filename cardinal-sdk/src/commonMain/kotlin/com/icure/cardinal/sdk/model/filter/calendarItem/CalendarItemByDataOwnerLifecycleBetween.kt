// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.calendarItem

import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Long
import kotlin.String

/**
 * Filter that matches calendar items by data owner and lifecycle timestamp range.
 * /
 */
@SerialName("CalendarItemByDataOwnerLifecycleBetween")
@Serializable
data class CalendarItemByDataOwnerLifecycleBetween(
	/**
	 * The identifier of the data owner.
	 */
	public val dataOwnerId: String,
	/**
	 * The start of the lifecycle timestamp range (inclusive).
	 */
	public val startTimestamp: Long? = null,
	/**
	 * The end of the lifecycle timestamp range (inclusive).
	 */
	public val endTimestamp: Long? = null,
	/**
	 * Whether to return results in descending order.
	 */
	@param:DefaultValue("false")
	public val descending: Boolean = false,
	/**
	 * Optional description of this filter.
	 */
	override val desc: String? = null,
) : AbstractFilter<CalendarItem> {
	// region CalendarItemByDataOwnerLifecycleBetween-CalendarItemByDataOwnerLifecycleBetween

	// endregion
}

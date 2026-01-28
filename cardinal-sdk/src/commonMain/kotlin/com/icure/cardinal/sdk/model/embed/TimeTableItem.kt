package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.Deprecated

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class TimeTableItem(
	public val rruleStartDate: Long? = null,
	public val rrule: String? = null,
	public val notBeforeInMinutes: Int? = null,
	public val notAfterInMinutes: Int? = null,
	public val zoneId: String? = null,
	@DefaultValue("emptyList()")
	public val hours: List<TimeTableHour> = emptyList(),
	public val calendarItemTypeId: String? = null,
	@DefaultValue("false")
	public val homeVisit: Boolean = false,
	public val placeId: String? = null,
	@DefaultValue("false")
	public val publicTimeTableItem: Boolean = false,
	@DefaultValue("true")
	public val acceptsNewPatient: Boolean = true,
	@DefaultValue("false")
	public val unavailable: Boolean = false,
	@DefaultValue("emptySet()")
	public val reservingRights: Set<String> = emptySet(),
) {
	// region TimeTableItem-TimeTableItem

	// endregion
}

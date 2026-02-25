package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

@Serializable
public data class TimeTableItem(
	public val rruleStartDate: Long? = null,
	public val rrule: String? = null,
	public val notBeforeInMinutes: Int? = null,
	public val notAfterInMinutes: Int? = null,
	public val zoneId: String? = null,
	@param:DefaultValue("emptyList()")
	public val hours: List<TimeTableHour> = emptyList(),
	public val calendarItemTypeId: String? = null,
	@param:DefaultValue("false")
	public val homeVisit: Boolean = false,
	public val placeId: String? = null,
	@param:DefaultValue("false")
	public val publicTimeTableItem: Boolean = false,
	@param:DefaultValue("true")
	public val acceptsNewPatient: Boolean = true,
	@param:DefaultValue("false")
	public val unavailable: Boolean = false,
	@param:DefaultValue("emptySet()")
	public val reservingRights: Set<String> = emptySet(),
)

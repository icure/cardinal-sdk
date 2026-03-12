package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

/**
 *
 *  Note: The RFC-5545 rrule is used only to manage the days of the occurrences. The hours and
 * durations of the appointments are specified in the property .hours.
 */
@Serializable
public data class TimeTableItem(
	public val rruleStartDate: Long? = null,
	/**
	 * a RFC-5545 recurrence rule specifying the days and recurrence type of the timetable item.
	 * ("RRULE:FREQ=WEEKLY;UNTIL=20220930T150400Z;COUNT=30;INTERVAL=2;WKST=MO;BYDAY=TH" = every 2 weeks on
	 * Thursday until 30 September 2022.)
	 */
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

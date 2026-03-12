package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

/**
 * Represents a recurring time table item with scheduling rules, availability slots, and access
 * control.
 * /
 */
@Serializable
public data class EmbeddedTimeTableItem(
	/**
	 * The recurrence rule (RFC 5545 RRULE format) defining the schedule pattern.
	 */
	public val rrule: String,
	/**
	 * The start date of the recurrence rule as an integer (YYYYMMDD).
	 */
	public val rruleStartDate: Int? = null,
	/**
	 * Minimum number of minutes before the slot that booking is allowed.
	 */
	public val notBeforeInMinutes: Int? = null,
	/**
	 * Maximum number of minutes after the slot start that booking is allowed.
	 */
	public val notAfterInMinutes: Int? = null,
	/**
	 * The list of hour ranges within this time table item.
	 */
	public val hours: List<EmbeddedTimeTableHour>,
	/**
	 * The set of calendar item type identifiers associated with this item.
	 */
	public val calendarItemTypesIds: Set<String>,
	/**
	 * The number of available slots for this time table item.
	 */
	@param:DefaultValue("1")
	public val availabilities: Int = 1,
	/**
	 * The set of identifiers for parties allowed to reserve slots.
	 */
	@param:DefaultValue("emptySet()")
	public val reservingRights: Set<String> = emptySet(),
	/**
	 * Whether this time table item is publicly visible.
	 */
	@param:DefaultValue("false")
	public val `public`: Boolean = false,
)

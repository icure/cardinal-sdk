package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

@Serializable
public data class EmbeddedTimeTableItem(
	public val rrule: String,
	public val rruleStartDate: Int? = null,
	public val notBeforeInMinutes: Int? = null,
	public val notAfterInMinutes: Int? = null,
	public val hours: List<EmbeddedTimeTableHour>,
	public val calendarItemTypesIds: Set<String>,
	@param:DefaultValue("1")
	public val availabilities: Int = 1,
	@param:DefaultValue("emptySet()")
	public val reservingRights: Set<String> = emptySet(),
	@param:DefaultValue("false")
	public val `public`: Boolean = false,
)

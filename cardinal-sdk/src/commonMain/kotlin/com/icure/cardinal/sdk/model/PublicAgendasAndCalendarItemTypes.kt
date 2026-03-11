package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.List

/**
 *
 *  DTO containing publicly accessible agendas and their associated calendar item types,
 *  used for public appointment booking.
 */
@Serializable
public data class PublicAgendasAndCalendarItemTypes(
	/**
	 * The list of publicly available agendas.
	 */
	@param:DefaultValue("emptyList()")
	public val agendas: List<Agenda> = emptyList(),
	/**
	 * The list of calendar item types associated with the public agendas.
	 */
	@param:DefaultValue("emptyList()")
	public val calendarItemTypes: List<CalendarItemType> = emptyList(),
)

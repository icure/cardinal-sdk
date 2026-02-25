package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.collections.List

@Serializable
public data class PublicAgendasAndCalendarItemTypes(
	public val agendas: List<Agenda>,
	public val calendarItemTypes: List<CalendarItemType>,
)

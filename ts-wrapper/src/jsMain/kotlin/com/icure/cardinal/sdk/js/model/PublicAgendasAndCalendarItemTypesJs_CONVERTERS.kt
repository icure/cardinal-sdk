// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.CalendarItemType
import com.icure.cardinal.sdk.model.PublicAgendasAndCalendarItemTypes
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun publicAgendasAndCalendarItemTypes_toJs(obj: PublicAgendasAndCalendarItemTypes): PublicAgendasAndCalendarItemTypesJs {
	val agendas = listToArray(
		obj.agendas,
		{ x1: Agenda ->
			agenda_toJs(x1)
		},
	)
	val calendarItemTypes = listToArray(
		obj.calendarItemTypes,
		{ x1: CalendarItemType ->
			calendarItemType_toJs(x1)
		},
	)
	return PublicAgendasAndCalendarItemTypesJs(js("{" +
		"agendas:agendas," +
		"calendarItemTypes:calendarItemTypes" +
	"}"))
}

public fun publicAgendasAndCalendarItemTypes_fromJs(obj: PublicAgendasAndCalendarItemTypesJs): PublicAgendasAndCalendarItemTypes {
	val agendas = arrayToList(
		obj.agendas,
		"obj.agendas",
		{ x1: AgendaJs ->
			agenda_fromJs(x1)
		},
	)
	val calendarItemTypes = arrayToList(
		obj.calendarItemTypes,
		"obj.calendarItemTypes",
		{ x1: CalendarItemTypeJs ->
			calendarItemType_fromJs(x1)
		},
	)
	return PublicAgendasAndCalendarItemTypes(
		agendas = agendas,
		calendarItemTypes = calendarItemTypes,
	)
}

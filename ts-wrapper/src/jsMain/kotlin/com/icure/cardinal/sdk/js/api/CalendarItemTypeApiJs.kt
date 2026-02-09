// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.CalendarItemTypeJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CalendarItemTypeApi")
public external interface CalendarItemTypeApiJs {
	public val inGroup: CalendarItemTypeInGroupApiJs

	public fun createCalendarItemType(calendarItemType: CalendarItemTypeJs):
			Promise<CalendarItemTypeJs>

	public fun createCalendarItemTypes(calendarItemTypes: Array<CalendarItemTypeJs>):
			Promise<Array<CalendarItemTypeJs>>

	public fun getCalendarItemType(calendarItemTypeId: String): Promise<CalendarItemTypeJs?>

	public fun getCalendarItemTypes(calendarItemTypesIds: Array<String>):
			Promise<Array<CalendarItemTypeJs>>

	public fun modifyCalendarItemType(calendarItemType: CalendarItemTypeJs):
			Promise<CalendarItemTypeJs>

	public fun modifyCalendarItemTypes(calendarItemTypes: Array<CalendarItemTypeJs>):
			Promise<Array<CalendarItemTypeJs>>

	public fun deleteCalendarItemTypeById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs>

	public fun deleteCalendarItemTypeByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deleteCalendarItemType(calendarItemType: CalendarItemTypeJs):
			Promise<StoredDocumentIdentifierJs>

	public fun deleteCalendarItemTypes(calendarItemTypes: Array<CalendarItemTypeJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun undeleteCalendarItemTypeById(entityId: String, rev: String): Promise<CalendarItemTypeJs>

	public fun undeleteCalendarItemTypeByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<CalendarItemTypeJs>>

	public fun undeleteCalendarItemType(calendarItemType: CalendarItemTypeJs):
			Promise<CalendarItemTypeJs>

	public fun undeleteCalendarItemTypes(calendarItemTypes: Array<CalendarItemTypeJs>):
			Promise<Array<CalendarItemTypeJs>>

	public fun purgeCalendarItemTypeById(entityId: String, rev: String): Promise<Unit>

	public fun purgeCalendarItemTypeByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeCalendarItemType(calendarItemType: CalendarItemTypeJs): Promise<Unit>

	public fun purgeCalendarItemTypes(calendarItemTypes: Array<CalendarItemTypeJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun listCalendarItemTypesByAgendaId(agendaId: String): Promise<Array<CalendarItemTypeJs>>
}

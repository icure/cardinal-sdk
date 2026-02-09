// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.CalendarItemTypeJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CalendarItemTypeInGroupApi")
public external interface CalendarItemTypeInGroupApiJs {
	public fun createCalendarItemType(calendarItemType: GroupScopedJs<CalendarItemTypeJs>):
			Promise<GroupScopedJs<CalendarItemTypeJs>>

	public fun createCalendarItemTypes(calendarItemTypes: Array<GroupScopedJs<CalendarItemTypeJs>>):
			Promise<Array<GroupScopedJs<CalendarItemTypeJs>>>

	public fun getCalendarItemType(groupId: String, calendarItemTypeId: String):
			Promise<GroupScopedJs<CalendarItemTypeJs>?>

	public fun getCalendarItemTypes(groupId: String, calendarItemTypesIds: Array<String>):
			Promise<Array<GroupScopedJs<CalendarItemTypeJs>>>

	public fun modifyCalendarItemType(calendarItemType: GroupScopedJs<CalendarItemTypeJs>):
			Promise<GroupScopedJs<CalendarItemTypeJs>>

	public fun modifyCalendarItemTypes(calendarItemTypes: Array<GroupScopedJs<CalendarItemTypeJs>>):
			Promise<Array<GroupScopedJs<CalendarItemTypeJs>>>

	public fun deleteCalendarItemTypeById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public
			fun deleteCalendarItemTypeByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteCalendarItemType(calendarItemType: GroupScopedJs<CalendarItemTypeJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteCalendarItemTypes(calendarItemTypes: Array<GroupScopedJs<CalendarItemTypeJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun undeleteCalendarItemTypeById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<CalendarItemTypeJs>>

	public
			fun undeleteCalendarItemTypeByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<CalendarItemTypeJs>>>

	public fun undeleteCalendarItemType(calendarItemType: GroupScopedJs<CalendarItemTypeJs>):
			Promise<GroupScopedJs<CalendarItemTypeJs>>

	public fun undeleteCalendarItemTypes(calendarItemTypes: Array<GroupScopedJs<CalendarItemTypeJs>>):
			Promise<Array<GroupScopedJs<CalendarItemTypeJs>>>

	public fun purgeCalendarItemTypeById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<Unit>

	public fun purgeCalendarItemTypeByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeCalendarItemType(calendarItemType: GroupScopedJs<CalendarItemTypeJs>):
			Promise<Unit>

	public fun purgeCalendarItemTypes(calendarItemTypes: Array<GroupScopedJs<CalendarItemTypeJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>
}

// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.CalendarItemShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.CalendarItemJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CalendarItemFlavouredApi")
public external interface CalendarItemFlavouredApiJs<E : CalendarItemJs> {
	public fun shareWith(
		delegateId: String,
		calendarItem: E,
		options: dynamic,
	): Promise<E>

	public fun shareWithMany(calendarItem: E, delegates: Record<String, CalendarItemShareOptionsJs>):
			Promise<E>

	public fun linkToPatient(
		calendarItem: CalendarItemJs,
		patient: PatientJs,
		shareLinkWithDelegates: Array<String>,
	): Promise<E>

	public fun filterCalendarItemsBy(filter: FilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun filterCalendarItemsBySorted(filter: SortableFilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun createCalendarItem(entity: E): Promise<E>

	public fun createCalendarItems(entities: Array<E>): Promise<Array<E>>

	public fun bookCalendarItemCheckingAvailability(entity: E): Promise<E>

	public fun undeleteCalendarItemById(id: String, rev: String): Promise<E>

	public fun undeleteCalendarItemsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<E>>

	public fun undeleteCalendarItem(calendarItem: CalendarItemJs): Promise<E>

	public fun undeleteCalendarItems(calendarItems: Array<CalendarItemJs>): Promise<Array<E>>

	public fun modifyCalendarItem(entity: E): Promise<E>

	public fun modifyCalendarItems(entities: Array<E>): Promise<Array<E>>

	public fun getCalendarItem(entityId: String): Promise<E?>

	public fun getCalendarItems(entityIds: Array<String>): Promise<Array<E>>
}

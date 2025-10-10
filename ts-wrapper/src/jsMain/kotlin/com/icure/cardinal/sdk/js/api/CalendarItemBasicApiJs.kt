// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.model.CalendarItemJs
import com.icure.cardinal.sdk.js.model.EncryptedCalendarItemJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CalendarItemBasicApi")
public external interface CalendarItemBasicApiJs {
	public val inGroup: CalendarItemBasicInGroupApiJs

	public fun matchCalendarItemsBy(filter: BaseFilterOptionsJs<CalendarItemJs>):
			Promise<Array<String>>

	public fun matchCalendarItemsBySorted(filter: BaseSortableFilterOptionsJs<CalendarItemJs>):
			Promise<Array<String>>

	public fun filterCalendarItemsBy(filter: BaseFilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<EncryptedCalendarItemJs>>

	public fun filterCalendarItemsBySorted(filter: BaseSortableFilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<EncryptedCalendarItemJs>>

	public fun deleteCalendarItemUnsafe(entityId: String): Promise<StoredDocumentIdentifierJs>

	public fun deleteCalendarItemsUnsafe(entityIds: Array<String>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deleteCalendarItemById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs>

	public fun deleteCalendarItemsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeCalendarItemById(id: String, rev: String): Promise<Unit>

	public fun deleteCalendarItem(calendarItem: CalendarItemJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteCalendarItems(calendarItems: Array<CalendarItemJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeCalendarItem(calendarItem: CalendarItemJs): Promise<Unit>

	public fun createCalendarItem(entity: EncryptedCalendarItemJs): Promise<EncryptedCalendarItemJs>

	public fun bookCalendarItemCheckingAvailability(entity: EncryptedCalendarItemJs):
			Promise<EncryptedCalendarItemJs>

	public fun undeleteCalendarItemById(id: String, rev: String): Promise<EncryptedCalendarItemJs>

	public fun undeleteCalendarItem(calendarItem: CalendarItemJs): Promise<EncryptedCalendarItemJs>

	public fun modifyCalendarItem(entity: EncryptedCalendarItemJs): Promise<EncryptedCalendarItemJs>

	public fun getCalendarItem(entityId: String): Promise<EncryptedCalendarItemJs?>

	public fun getCalendarItems(entityIds: Array<String>): Promise<Array<EncryptedCalendarItemJs>>

	public fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Double,
		endDate: Double,
		hcPartyId: String,
	): Promise<Array<EncryptedCalendarItemJs>>

	public fun getCalendarsByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<EncryptedCalendarItemJs>>

	public fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double,
	): Promise<PaginatedListJs<EncryptedCalendarItemJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<CalendarItemJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedCalendarItemJs>>
}

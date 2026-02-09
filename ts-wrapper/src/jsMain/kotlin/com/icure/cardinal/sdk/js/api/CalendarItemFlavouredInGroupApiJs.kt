// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.CalendarItemJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToCalendarItemShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CalendarItemFlavouredInGroupApi")
public external interface CalendarItemFlavouredInGroupApiJs<E : CalendarItemJs> {
	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		calendarItem: GroupScopedJs<E>,
		options: dynamic,
	): Promise<GroupScopedJs<E>>

	public fun shareWithMany(calendarItem: GroupScopedJs<E>,
			delegates: Array<EntityReferenceInGroupToCalendarItemShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<E>>

	public fun filterCalendarItemsBy(groupId: String, filter: FilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun filterCalendarItemsBySorted(groupId: String,
			filter: SortableFilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun createCalendarItem(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun createCalendarItems(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun undeleteCalendarItemById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<E>>

	public fun undeleteCalendarItemsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun undeleteCalendarItem(calendarItem: GroupScopedJs<CalendarItemJs>):
			Promise<GroupScopedJs<E>>

	public fun undeleteCalendarItems(calendarItems: Array<GroupScopedJs<E>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun modifyCalendarItem(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun modifyCalendarItems(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun getCalendarItem(groupId: String, entityId: String): Promise<GroupScopedJs<E>?>

	public fun getCalendarItems(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<E>>>
}

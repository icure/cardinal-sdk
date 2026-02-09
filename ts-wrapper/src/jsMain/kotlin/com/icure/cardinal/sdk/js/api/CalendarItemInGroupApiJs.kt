// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.CalendarItemJs
import com.icure.cardinal.sdk.js.model.DecryptedCalendarItemJs
import com.icure.cardinal.sdk.js.model.EncryptedCalendarItemJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToCalendarItemShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CalendarItemInGroupApi")
public external interface CalendarItemInGroupApiJs {
	public val encrypted: CalendarItemFlavouredInGroupApiJs<EncryptedCalendarItemJs>

	public val tryAndRecover: CalendarItemFlavouredInGroupApiJs<CalendarItemJs>

	public fun withEncryptionMetadata(
		entityGroupId: String,
		base: DecryptedCalendarItemJs?,
		patient: GroupScopedJs<PatientJs>?,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedCalendarItemJs>>

	public fun getEncryptionKeysOf(calendarItem: GroupScopedJs<CalendarItemJs>): Promise<Array<String>>

	public fun hasWriteAccess(calendarItem: GroupScopedJs<CalendarItemJs>): Promise<Boolean>

	public fun decryptPatientIdOf(calendarItem: GroupScopedJs<CalendarItemJs>):
			Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<CalendarItemJs>,
			delegates: Array<EntityReferenceInGroupJs>): Promise<Unit>

	public fun decrypt(calendarItems: Array<GroupScopedJs<EncryptedCalendarItemJs>>):
			Promise<Array<GroupScopedJs<DecryptedCalendarItemJs>>>

	public fun tryDecrypt(calendarItems: Array<GroupScopedJs<EncryptedCalendarItemJs>>):
			Promise<Array<GroupScopedJs<CalendarItemJs>>>

	public fun encryptOrValidate(calendarItems: Array<GroupScopedJs<CalendarItemJs>>):
			Promise<Array<GroupScopedJs<EncryptedCalendarItemJs>>>

	public fun matchCalendarItemsBy(groupId: String, filter: FilterOptionsJs<CalendarItemJs>):
			Promise<Array<String>>

	public fun matchCalendarItemsBySorted(groupId: String,
			filter: SortableFilterOptionsJs<CalendarItemJs>): Promise<Array<String>>

	public fun deleteCalendarItemById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteCalendarItemsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeCalendarItemById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<Unit>

	public fun purgeCalendarItemsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteCalendarItem(calendarItem: GroupScopedJs<CalendarItemJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteCalendarItems(calendarItems: Array<GroupScopedJs<CalendarItemJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeCalendarItem(calendarItem: GroupScopedJs<CalendarItemJs>): Promise<Unit>

	public fun purgeCalendarItems(calendarItems: Array<GroupScopedJs<CalendarItemJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		calendarItem: GroupScopedJs<DecryptedCalendarItemJs>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedCalendarItemJs>>

	public fun shareWithMany(calendarItem: GroupScopedJs<DecryptedCalendarItemJs>,
			delegates: Array<EntityReferenceInGroupToCalendarItemShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<DecryptedCalendarItemJs>>

	public fun filterCalendarItemsBy(groupId: String, filter: FilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedCalendarItemJs>>>

	public fun filterCalendarItemsBySorted(groupId: String,
			filter: SortableFilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedCalendarItemJs>>>

	public fun createCalendarItem(entity: GroupScopedJs<DecryptedCalendarItemJs>):
			Promise<GroupScopedJs<DecryptedCalendarItemJs>>

	public fun createCalendarItems(entities: Array<GroupScopedJs<DecryptedCalendarItemJs>>):
			Promise<Array<GroupScopedJs<DecryptedCalendarItemJs>>>

	public fun undeleteCalendarItemById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<DecryptedCalendarItemJs>>

	public fun undeleteCalendarItemsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<DecryptedCalendarItemJs>>>

	public fun undeleteCalendarItem(calendarItem: GroupScopedJs<CalendarItemJs>):
			Promise<GroupScopedJs<DecryptedCalendarItemJs>>

	public fun undeleteCalendarItems(calendarItems: Array<GroupScopedJs<DecryptedCalendarItemJs>>):
			Promise<Array<GroupScopedJs<DecryptedCalendarItemJs>>>

	public fun modifyCalendarItem(entity: GroupScopedJs<DecryptedCalendarItemJs>):
			Promise<GroupScopedJs<DecryptedCalendarItemJs>>

	public fun modifyCalendarItems(entities: Array<GroupScopedJs<DecryptedCalendarItemJs>>):
			Promise<Array<GroupScopedJs<DecryptedCalendarItemJs>>>

	public fun getCalendarItem(groupId: String, entityId: String):
			Promise<GroupScopedJs<DecryptedCalendarItemJs>?>

	public fun getCalendarItems(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<DecryptedCalendarItemJs>>>
}

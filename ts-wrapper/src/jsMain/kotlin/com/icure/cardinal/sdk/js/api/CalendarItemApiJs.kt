// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.CalendarItemShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.CalendarItemJs
import com.icure.cardinal.sdk.js.model.DecryptedCalendarItemJs
import com.icure.cardinal.sdk.js.model.EncryptedCalendarItemJs
import com.icure.cardinal.sdk.js.model.IdWithMandatoryRevJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("CalendarItemApi")
public external interface CalendarItemApiJs {
	public val encrypted: CalendarItemFlavouredApiJs<EncryptedCalendarItemJs>

	public val tryAndRecover: CalendarItemFlavouredApiJs<CalendarItemJs>

	public fun createCalendarItem(entity: DecryptedCalendarItemJs): Promise<DecryptedCalendarItemJs>

	public fun withEncryptionMetadata(
		base: DecryptedCalendarItemJs?,
		patient: PatientJs?,
		options: dynamic,
	): Promise<DecryptedCalendarItemJs>

	public fun getEncryptionKeysOf(calendarItem: CalendarItemJs): Promise<Array<String>>

	public fun hasWriteAccess(calendarItem: CalendarItemJs): Promise<Boolean>

	public fun decryptPatientIdOf(calendarItem: CalendarItemJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: CalendarItemJs,
			delegates: Array<String>): Promise<Unit>

	public fun decrypt(calendarItem: EncryptedCalendarItemJs): Promise<DecryptedCalendarItemJs>

	public fun tryDecrypt(calendarItem: EncryptedCalendarItemJs): Promise<CalendarItemJs>

	public fun matchCalendarItemsBy(filter: FilterOptionsJs<CalendarItemJs>): Promise<Array<String>>

	public fun matchCalendarItemsBySorted(filter: SortableFilterOptionsJs<CalendarItemJs>):
			Promise<Array<String>>

	public fun deleteCalendarItemUnsafe(entityId: String): Promise<DocIdentifierJs>

	public fun deleteCalendarItemsUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun deleteCalendarItemById(entityId: String, rev: String): Promise<DocIdentifierJs>

	public fun deleteCalendarItemsByIds(entityIds: Array<IdWithMandatoryRevJs>):
			Promise<Array<DocIdentifierJs>>

	public fun purgeCalendarItemById(id: String, rev: String): Promise<Unit>

	public fun deleteCalendarItem(calendarItem: CalendarItemJs): Promise<DocIdentifierJs>

	public fun deleteCalendarItems(calendarItems: Array<CalendarItemJs>):
			Promise<Array<DocIdentifierJs>>

	public fun purgeCalendarItem(calendarItem: CalendarItemJs): Promise<Unit>

	public fun shareWith(
		delegateId: String,
		calendarItem: DecryptedCalendarItemJs,
		options: dynamic,
	): Promise<DecryptedCalendarItemJs>

	public fun shareWithMany(calendarItem: DecryptedCalendarItemJs,
			delegates: Record<String, CalendarItemShareOptionsJs>): Promise<DecryptedCalendarItemJs>

	public fun findCalendarItemsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<DecryptedCalendarItemJs>>

	public fun linkToPatient(
		calendarItem: CalendarItemJs,
		patient: PatientJs,
		shareLinkWithDelegates: Array<String>,
	): Promise<DecryptedCalendarItemJs>

	public fun filterCalendarItemsBy(filter: FilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<DecryptedCalendarItemJs>>

	public fun filterCalendarItemsBySorted(filter: SortableFilterOptionsJs<CalendarItemJs>):
			Promise<PaginatedListIteratorJs<DecryptedCalendarItemJs>>

	public fun undeleteCalendarItemById(id: String, rev: String): Promise<DecryptedCalendarItemJs>

	public fun undeleteCalendarItem(calendarItem: CalendarItemJs): Promise<DecryptedCalendarItemJs>

	public fun modifyCalendarItem(entity: DecryptedCalendarItemJs): Promise<DecryptedCalendarItemJs>

	public fun getCalendarItem(entityId: String): Promise<DecryptedCalendarItemJs>

	public fun getCalendarItems(entityIds: Array<String>): Promise<Array<DecryptedCalendarItemJs>>

	public fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Double,
		endDate: Double,
		hcPartyId: String,
	): Promise<Array<DecryptedCalendarItemJs>>

	public fun getCalendarsByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<DecryptedCalendarItemJs>>

	public fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double,
	): Promise<PaginatedListJs<DecryptedCalendarItemJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<CalendarItemJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedCalendarItemJs>>
}

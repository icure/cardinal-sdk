package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.CalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawCalendarItemApi {
	// region common endpoints

	suspend fun getCalendarItems(
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedCalendarItem>>

	suspend fun createCalendarItem(calendarItemDto: EncryptedCalendarItem): HttpResponse<EncryptedCalendarItem>

	suspend fun createCalendarItems(calendarItemDtos: List<EncryptedCalendarItem>): HttpResponse<List<EncryptedCalendarItem>>

	suspend fun deleteCalendarItems(calendarItemIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteCalendarItemsWithRev(calendarItemIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteCalendarItem(
		calendarItemId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteCalendarItem(
		calendarItemId: String,
		rev: String,
	): HttpResponse<EncryptedCalendarItem>

	suspend fun undeleteCalendarItems(calendarItemIds: ListOfIdsAndRev): HttpResponse<List<EncryptedCalendarItem>>

	suspend fun purgeCalendarItem(
		calendarItemId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeCalendarItems(calendarItemIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun getCalendarItem(calendarItemId: String): HttpResponse<EncryptedCalendarItem>

	suspend fun modifyCalendarItem(calendarItemDto: EncryptedCalendarItem): HttpResponse<EncryptedCalendarItem>

	suspend fun modifyCalendarItems(calendarItemDtos: List<EncryptedCalendarItem>): HttpResponse<List<EncryptedCalendarItem>>

	suspend fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
	): HttpResponse<List<EncryptedCalendarItem>>

	suspend fun getCalendarsByPeriodAndAgendaId(
		startDate: Long,
		endDate: Long,
		agendaId: String,
	): HttpResponse<List<EncryptedCalendarItem>>

	suspend fun getCalendarItemsWithIds(calendarItemIds: ListOfIds): HttpResponse<List<EncryptedCalendarItem>>

	suspend fun listCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<EncryptedCalendarItem>>

	suspend fun listCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<EncryptedCalendarItem>>

	suspend fun findCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int,
	): HttpResponse<PaginatedList<EncryptedCalendarItem>>

	suspend fun findCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int,
	): HttpResponse<PaginatedList<EncryptedCalendarItem>>

	suspend fun findCalendarItemIdsByDataOwnerPatientStartTime(
		dataOwnerId: String,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>>

	suspend fun findCalendarItemsDelegationsStubsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<IcureStub>>

	suspend fun findCalendarItemsDelegationsStubsByIds(calendarItemIds: ListOfIds): HttpResponse<List<IcureStub>>

	suspend fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedCalendarItem>>

	suspend fun matchCalendarItemsBy(filter: AbstractFilter<CalendarItem>): HttpResponse<List<String>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedCalendarItem>>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>>
	// endregion

	// region cloud endpoints

	suspend fun createCalendarItemInGroup(
		groupId: String,
		calendarItemDto: EncryptedCalendarItem,
	): HttpResponse<EncryptedCalendarItem>

	suspend fun createCalendarItemsInGroup(
		groupId: String,
		calendarItemDtos: List<EncryptedCalendarItem>,
	): HttpResponse<List<EncryptedCalendarItem>>

	suspend fun modifyCalendarItemInGroup(
		groupId: String,
		calendarItemDto: EncryptedCalendarItem,
	): HttpResponse<EncryptedCalendarItem>

	suspend fun modifyCalendarItemsInGroup(
		groupId: String,
		calendarItemDtos: List<EncryptedCalendarItem>,
	): HttpResponse<List<EncryptedCalendarItem>>

	suspend fun getCalendarItemInGroup(
		groupId: String,
		calendarItemId: String,
	): HttpResponse<EncryptedCalendarItem>

	suspend fun getCalendarItemsInGroup(
		groupId: String,
		calendarItemIds: ListOfIds,
	): HttpResponse<List<EncryptedCalendarItem>>

	suspend fun deleteCalendarItemsInGroup(
		groupId: String,
		calendarItemIdsAndRevs: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun deleteCalendarItemInGroup(
		groupId: String,
		calendarItemId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteCalendarItemsInGroup(
		groupId: String,
		calendarItemIdsAndRevs: ListOfIdsAndRev,
	): HttpResponse<List<EncryptedCalendarItem>>

	suspend fun undeleteCalendarItemInGroup(
		groupId: String,
		calendarItemId: String,
		rev: String,
	): HttpResponse<EncryptedCalendarItem>

	suspend fun purgeCalendarItemsInGroup(
		groupId: String,
		calendarItemIdsAndRevs: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun purgeCalendarItemInGroup(
		groupId: String,
		calendarItemId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun matchCalendarItemsInGroupBy(
		filter: AbstractFilter<CalendarItem>,
		groupId: String,
	): HttpResponse<List<String>>

	suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedCalendarItem>>>

	suspend fun safeBook(calendarItemDto: EncryptedCalendarItem): HttpResponse<EncryptedCalendarItem>

	suspend fun safeBookBulk(calendarItemDtos: List<EncryptedCalendarItem>): HttpResponse<List<EncryptedCalendarItem>>
	// endregion
}

package com.icure.sdk.api.raw

import com.icure.sdk.model.EncryptedCalendarItem
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.sdk.model.requests.EntityBulkShareResult
import com.icure.sdk.utils.InternalIcureApi
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

	suspend fun deleteCalendarItems(calendarItemIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteCalendarItem(calendarItemId: String): HttpResponse<DocIdentifier>

	suspend fun deleteCalendarItemsWithPost(calendarItemIds: String): HttpResponse<List<DocIdentifier>>

	suspend fun getCalendarItem(calendarItemId: String): HttpResponse<EncryptedCalendarItem>

	suspend fun modifyCalendarItem(calendarItemDto: EncryptedCalendarItem): HttpResponse<EncryptedCalendarItem>

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

	suspend fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedCalendarItem>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedCalendarItem>>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>>
	// endregion
}

package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawCalendarItemApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
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
import com.icure.cardinal.sdk.serialization.CalendarItemAbstractFilterSerializer
import com.icure.utils.InternalIcureApi
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawCalendarItemApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawCalendarItemApi {
	override suspend fun getAccessControlKeysHeaderValues(groupId: String?): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(
			groupId,
			EntityWithEncryptionMetadataTypeName.CalendarItem,
		)

	// region common endpoints

	override suspend fun getCalendarItems(
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedCalendarItem>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createCalendarItem(calendarItemDto: EncryptedCalendarItem): HttpResponse<EncryptedCalendarItem> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemDto)
		}.wrap()

	override suspend fun deleteCalendarItems(calendarItemIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemIds)
		}.wrap()

	override suspend fun deleteCalendarItemsWithRev(calendarItemIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemIds)
		}.wrap()

	override suspend fun deleteCalendarItem(
		calendarItemId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", calendarItemId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteCalendarItem(
		calendarItemId: String,
		rev: String,
	): HttpResponse<EncryptedCalendarItem> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "undelete", calendarItemId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeCalendarItem(
		calendarItemId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "purge", calendarItemId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getCalendarItem(calendarItemId: String): HttpResponse<EncryptedCalendarItem> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", calendarItemId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyCalendarItem(calendarItemDto: EncryptedCalendarItem): HttpResponse<EncryptedCalendarItem> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemDto)
		}.wrap()

	override suspend fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Long,
		endDate: Long,
		hcPartyId: String,
	): HttpResponse<List<EncryptedCalendarItem>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byPeriodAndHcPartyId")
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("hcPartyId", hcPartyId)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun getCalendarsByPeriodAndAgendaId(
		startDate: Long,
		endDate: Long,
		agendaId: String,
	): HttpResponse<List<EncryptedCalendarItem>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byPeriodAndAgendaId")
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("agendaId", agendaId)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun getCalendarItemsWithIds(calendarItemIds: ListOfIds): HttpResponse<List<EncryptedCalendarItem>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemIds)
		}.wrap()

	override suspend fun listCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
	): HttpResponse<List<EncryptedCalendarItem>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<EncryptedCalendarItem>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byHcPartySecretForeignKeys")
				parameter("hcPartyId", hcPartyId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int,
	): HttpResponse<PaginatedList<EncryptedCalendarItem>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byHcPartySecretForeignKeys", "page", "$limit")
				parameter("hcPartyId", hcPartyId)
				parameter("secretFKeys", secretFKeys)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findCalendarItemsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
		startKey: String?,
		startDocumentId: String?,
		limit: Int,
	): HttpResponse<PaginatedList<EncryptedCalendarItem>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byHcPartySecretForeignKeys", "page", "$limit")
				parameter("hcPartyId", hcPartyId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findCalendarItemIdsByDataOwnerPatientStartTime(
		dataOwnerId: String,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byDataOwnerPatientStartTime")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("descending", descending)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findCalendarItemsDelegationsStubsByHCPartyPatientForeignKeys(
		hcPartyId: String,
		secretPatientKeys: List<String>,
	): HttpResponse<List<IcureStub>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byHcPartySecretForeignKeys", "delegations")
				parameter("hcPartyId", hcPartyId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun findCalendarItemsDelegationsStubsByIds(calendarItemIds: ListOfIds): HttpResponse<List<IcureStub>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "delegations")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemIds)
		}.wrap()

	override suspend fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedCalendarItem>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "byRecurrenceId")
				parameter("recurrenceId", recurrenceId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun matchCalendarItemsBy(filter: AbstractFilter<CalendarItem>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(CalendarItemAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
	): HttpResponse<List<EntityBulkShareResult<EncryptedCalendarItem>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "bulkSharedMetadataUpdateMinimal")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun createCalendarItemInGroup(
		groupId: String,
		calendarItemDto: EncryptedCalendarItem,
	): HttpResponse<EncryptedCalendarItem> =
		post(
			authProvider,
			groupId,
		) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemDto)
		}.wrap()

	override suspend fun modifyCalendarItemInGroup(
		groupId: String,
		calendarItemDto: EncryptedCalendarItem,
	): HttpResponse<EncryptedCalendarItem> =
		put(
			authProvider,
			groupId,
		) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemDto)
		}.wrap()

	override suspend fun getCalendarItemInGroup(
		groupId: String,
		calendarItemId: String,
	): HttpResponse<EncryptedCalendarItem> =
		get(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "inGroup", groupId, calendarItemId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getCalendarItemsInGroup(
		groupId: String,
		calendarItemIds: ListOfIds,
	): HttpResponse<List<EncryptedCalendarItem>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemIds)
		}.wrap()

	override suspend fun deleteCalendarItemsInGroup(
		groupId: String,
		calendarItemIdsAndRevs: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(
			authProvider,
			groupId,
		) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "inGroup", groupId, "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemIdsAndRevs)
		}.wrap()

	override suspend fun deleteCalendarItemInGroup(
		groupId: String,
		calendarItemId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "inGroup", groupId, calendarItemId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun matchCalendarItemsInGroupBy(
		filter: AbstractFilter<CalendarItem>,
		groupId: String,
	): HttpResponse<List<String>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "inGroup", groupId, "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(CalendarItemAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedCalendarItem>>> =
		put(
			authProvider,
			groupId,
		) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "inGroup", groupId, "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun safeBook(calendarItemDto: EncryptedCalendarItem): HttpResponse<EncryptedCalendarItem> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "safeBook")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemDto)
		}.wrap()

	override suspend fun safeBookBulk(calendarItemDtos: List<EncryptedCalendarItem>): HttpResponse<List<EncryptedCalendarItem>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItem", "safeBook", "bulk")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemDtos)
		}.wrap()

	// endregion
}

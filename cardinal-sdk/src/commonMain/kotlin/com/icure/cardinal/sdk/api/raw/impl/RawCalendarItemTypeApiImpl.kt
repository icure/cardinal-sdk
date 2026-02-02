package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawCalendarItemTypeApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.CalendarItemType
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.utils.InternalIcureApi
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawCalendarItemTypeApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawCalendarItemTypeApi {
	// region common endpoints

	override suspend fun getCalendarItemTypes(
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<CalendarItemType>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getCalendarItemTypesByIds(calendarItemTypeIds: ListOfIds): HttpResponse<List<CalendarItemType>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemTypeIds)
		}.wrap()

	override suspend fun listCalendarItemTypesByAgendaId(agendaId: String): HttpResponse<List<CalendarItemType>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "byAgenda", agendaId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getCalendarItemTypesIncludingDeleted(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<CalendarItemType>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "includeDeleted")
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createCalendarItemType(calendarItemTypeDto: CalendarItemType): HttpResponse<CalendarItemType> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemTypeDto)
		}.wrap()

	override suspend fun createCalendarItemTypes(calendarItemTypeDtos: List<CalendarItemType>): HttpResponse<List<CalendarItemType>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemTypeDtos)
		}.wrap()

	override suspend fun deleteCalendarItemTypes(calendarItemTypeIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemTypeIds)
		}.wrap()

	override suspend fun deleteCalendarItemTypesWithRev(calendarItemTypeIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemTypeIds)
		}.wrap()

	override suspend fun deleteCalendarItemType(
		calendarItemTypeId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", calendarItemTypeId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteCalendarItemType(
		calendarItemTypeId: String,
		rev: String,
	): HttpResponse<CalendarItemType> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "undelete", calendarItemTypeId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteCalendarItemTypes(calendarItemTypeIds: ListOfIdsAndRev): HttpResponse<List<CalendarItemType>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemTypeIds)
		}.wrap()

	override suspend fun purgeCalendarItemType(
		calendarItemTypeId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "purge", calendarItemTypeId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeCalendarItemTypesWithRev(calendarItemTypeIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemTypeIds)
		}.wrap()

	override suspend fun getCalendarItemType(calendarItemTypeId: String): HttpResponse<CalendarItemType> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", calendarItemTypeId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyCalendarItemType(calendarItemTypeDto: CalendarItemType): HttpResponse<CalendarItemType> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemTypeDto)
		}.wrap()

	override suspend fun modifyCalendarItemTypes(calendarItemTypeDtos: List<CalendarItemType>): HttpResponse<List<CalendarItemType>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemTypeDtos)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun createCalendarItemTypeInGroup(
		groupId: String,
		calendarItemTypeDto: CalendarItemType,
	): HttpResponse<CalendarItemType> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemTypeDto)
		}.wrap()

	override suspend fun createCalendarItemTypesInGroup(
		groupId: String,
		calendarItemTypeDtos: List<CalendarItemType>,
	): HttpResponse<List<CalendarItemType>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemTypeDtos)
		}.wrap()

	override suspend fun modifyCalendarItemTypeInGroup(
		groupId: String,
		calendarItemTypeDto: CalendarItemType,
	): HttpResponse<CalendarItemType> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemTypeDto)
		}.wrap()

	override suspend fun modifyCalendarItemTypesInGroup(
		groupId: String,
		calendarItemTypeDtos: List<CalendarItemType>,
	): HttpResponse<List<CalendarItemType>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "inGroup", groupId, "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemTypeDtos)
		}.wrap()

	override suspend fun getCalendarItemTypeInGroup(
		groupId: String,
		calendarItemTypeId: String,
	): HttpResponse<CalendarItemType> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "inGroup", groupId, calendarItemTypeId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getCalendarItemTypesInGroup(
		groupId: String,
		calendarItemTypeIds: ListOfIds,
	): HttpResponse<List<CalendarItemType>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemTypeIds)
		}.wrap()

	override suspend fun deleteCalendarItemTypesInGroup(
		groupId: String,
		calendarItemIdsAndRevs: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "inGroup", groupId, "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemIdsAndRevs)
		}.wrap()

	override suspend fun deleteCalendarItemTypeInGroup(
		groupId: String,
		calendarItemTypeId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "inGroup", groupId, calendarItemTypeId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteCalendarItemTypesInGroup(
		groupId: String,
		calendarItemIdsAndRevs: ListOfIdsAndRev,
	): HttpResponse<List<CalendarItemType>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "inGroup", groupId, "undelete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemIdsAndRevs)
		}.wrap()

	override suspend fun undeleteCalendarItemTypeInGroup(
		groupId: String,
		calendarItemTypeId: String,
		rev: String,
	): HttpResponse<CalendarItemType> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "inGroup", groupId, "undelete", calendarItemTypeId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeCalendarItemTypesInGroup(
		groupId: String,
		calendarItemIdsAndRevs: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "inGroup", groupId, "purge", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(calendarItemIdsAndRevs)
		}.wrap()

	override suspend fun purgeCalendarItemTypeInGroup(
		groupId: String,
		calendarItemTypeId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "calendarItemType", "inGroup", groupId, "purge", calendarItemTypeId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	// endregion
}

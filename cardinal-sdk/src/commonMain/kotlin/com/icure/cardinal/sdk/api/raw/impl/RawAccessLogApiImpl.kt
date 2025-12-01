package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawAccessLogApi
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.crypto.AccessControlKeysHeadersProvider
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.EncryptedAccessLog
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.cardinal.sdk.serialization.AccessLogAbstractFilterSerializer
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
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawAccessLogApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	private val accessControlKeysHeadersProvider: AccessControlKeysHeadersProvider?,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawAccessLogApi {
	override suspend fun getAccessControlKeysHeaderValues(groupId: String?): List<String>? =
		accessControlKeysHeadersProvider?.getAccessControlKeysHeadersFor(
			groupId,
			EntityWithEncryptionMetadataTypeName.AccessLog,
		)

	// region common endpoints

	override suspend fun createAccessLog(accessLogDto: EncryptedAccessLog): HttpResponse<EncryptedAccessLog> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(accessLogDto)
		}.wrap()

	override suspend fun deleteAccessLogs(accessLogIds: ListOfIds): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(accessLogIds)
		}.wrap()

	override suspend fun deleteAccessLogsWithRev(accessLogIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "delete", "batch", "withrev")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(accessLogIds)
		}.wrap()

	override suspend fun deleteAccessLog(
		accessLogId: String,
		rev: String?,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", accessLogId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun undeleteAccessLog(
		accessLogId: String,
		rev: String,
	): HttpResponse<EncryptedAccessLog> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "undelete", accessLogId)
				parameter("rev", rev)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeAccessLog(
		accessLogId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "purge", accessLogId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getAccessLog(accessLogId: String): HttpResponse<EncryptedAccessLog> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", accessLogId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findAccessLogsBy(
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
		descending: Boolean?,
	): HttpResponse<PaginatedList<EncryptedAccessLog>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog")
				parameter("fromEpoch", fromEpoch)
				parameter("toEpoch", toEpoch)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("descending", descending)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findAccessLogsByUserAfterDate(
		userId: String,
		accessType: String?,
		startDate: Long?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		descending: Boolean?,
	): HttpResponse<PaginatedList<EncryptedAccessLog>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "byUser")
				parameter("userId", userId)
				parameter("accessType", accessType)
				parameter("startDate", startDate)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("descending", descending)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listAccessLogIdsByDataOwnerPatientDate(
		dataOwnerId: String,
		startDate: Long?,
		endDate: Long?,
		descending: Boolean?,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "byDataOwnerPatientDate")
				parameter("dataOwnerId", dataOwnerId)
				parameter("startDate", startDate)
				parameter("endDate", endDate)
				parameter("descending", descending)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(secretPatientKeys)
		}.wrap()

	override suspend fun getAccessLogByIds(accessLogIds: ListOfIds): HttpResponse<List<EncryptedAccessLog>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(accessLogIds)
		}.wrap()

	override suspend fun modifyAccessLog(accessLogDto: EncryptedAccessLog): HttpResponse<EncryptedAccessLog> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(accessLogDto)
		}.wrap()

	override suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedAccessLog>>> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun matchAccessLogsBy(filter: AbstractFilter<AccessLog>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(AccessLogAbstractFilterSerializer, filter)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun findAccessLogsInGroup(
		groupId: String,
		fromEpoch: Long?,
		toEpoch: Long?,
		startKey: Long?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<EncryptedAccessLog>> =
		get(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "inGroup", groupId)
				parameter("fromEpoch", fromEpoch)
				parameter("toEpoch", toEpoch)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun matchAccessLogsInGroupBy(
		filter: AbstractFilter<AccessLog>,
		groupId: String,
	): HttpResponse<List<String>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "inGroup", groupId, "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(AccessLogAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun createAccessLogInGroup(
		groupId: String,
		accessLogDto: EncryptedAccessLog,
	): HttpResponse<EncryptedAccessLog> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(accessLogDto)
		}.wrap()

	override suspend fun modifyAccessLogInGroup(
		groupId: String,
		accessLogDto: EncryptedAccessLog,
	): HttpResponse<EncryptedAccessLog> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(accessLogDto)
		}.wrap()

	override suspend fun getAccessLogInGroup(
		groupId: String,
		accessLogId: String,
	): HttpResponse<EncryptedAccessLog> =
		get(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "inGroup", groupId, accessLogId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getAccessLogsInGroup(
		groupId: String,
		accessLogIds: ListOfIds,
	): HttpResponse<List<EncryptedAccessLog>> =
		post(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "inGroup", groupId, "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(accessLogIds)
		}.wrap()

	override suspend fun deleteAccessLogsInGroup(
		groupId: String,
		accessLogIdsAndRevs: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>> =
		post(
			authProvider,
			groupId,
		) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "inGroup", groupId, "delete", "batch")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(accessLogIdsAndRevs)
		}.wrap()

	override suspend fun deleteAccessLogInGroup(
		groupId: String,
		accessLogId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "inGroup", groupId, accessLogId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedAccessLog>>> =
		put(authProvider, groupId) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "accesslog", "inGroup", groupId, "bulkSharedMetadataUpdate")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	// endregion
}

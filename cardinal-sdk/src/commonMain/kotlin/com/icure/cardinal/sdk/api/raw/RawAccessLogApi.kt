package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.EncryptedAccessLog
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
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawAccessLogApi {
	// region common endpoints

	suspend fun createAccessLog(accessLogDto: EncryptedAccessLog): HttpResponse<EncryptedAccessLog>

	suspend fun deleteAccessLogs(accessLogIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteAccessLogsWithRev(accessLogIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteAccessLog(
		accessLogId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteAccessLog(
		accessLogId: String,
		rev: String,
	): HttpResponse<EncryptedAccessLog>

	suspend fun purgeAccessLog(
		accessLogId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun getAccessLog(accessLogId: String): HttpResponse<EncryptedAccessLog>

	suspend fun findAccessLogsBy(
		fromEpoch: Long? = null,
		toEpoch: Long? = null,
		startKey: Long? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		descending: Boolean? = null,
	): HttpResponse<PaginatedList<EncryptedAccessLog>>

	suspend fun findAccessLogsByUserAfterDate(
		userId: String,
		accessType: String? = null,
		startDate: Long? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		descending: Boolean? = null,
	): HttpResponse<PaginatedList<EncryptedAccessLog>>

	suspend fun listAccessLogIdsByDataOwnerPatientDate(
		dataOwnerId: String,
		startDate: Long? = null,
		endDate: Long? = null,
		descending: Boolean? = null,
		secretPatientKeys: ListOfIds,
	): HttpResponse<List<String>>

	suspend fun getAccessLogByIds(accessLogIds: ListOfIds): HttpResponse<List<EncryptedAccessLog>>

	suspend fun modifyAccessLog(accessLogDto: EncryptedAccessLog): HttpResponse<EncryptedAccessLog>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedAccessLog>>>

	suspend fun matchAccessLogsBy(filter: AbstractFilter<AccessLog>): HttpResponse<List<String>>
	// endregion

	// region cloud endpoints

	suspend fun findAccessLogsInGroup(
		groupId: String,
		fromEpoch: Long? = null,
		toEpoch: Long? = null,
		startKey: Long? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<EncryptedAccessLog>>

	suspend fun matchAccessLogsInGroupBy(
		filter: AbstractFilter<AccessLog>,
		groupId: String,
	): HttpResponse<List<String>>

	suspend fun createAccessLogInGroup(
		groupId: String,
		accessLogDto: EncryptedAccessLog,
	): HttpResponse<EncryptedAccessLog>

	suspend fun modifyAccessLogInGroup(
		groupId: String,
		accessLogDto: EncryptedAccessLog,
	): HttpResponse<EncryptedAccessLog>

	suspend fun getAccessLogInGroup(
		groupId: String,
		accessLogId: String,
	): HttpResponse<EncryptedAccessLog>

	suspend fun getAccessLogsInGroup(
		groupId: String,
		accessLogIds: ListOfIds,
	): HttpResponse<List<EncryptedAccessLog>>

	suspend fun deleteAccessLogsInGroup(
		groupId: String,
		accessLogIdsAndRevs: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun deleteAccessLogInGroup(
		groupId: String,
		accessLogId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun bulkShare(
		request: BulkShareOrUpdateMetadataParams,
		groupId: String,
	): HttpResponse<List<EntityBulkShareResult<EncryptedAccessLog>>>
	// endregion
}

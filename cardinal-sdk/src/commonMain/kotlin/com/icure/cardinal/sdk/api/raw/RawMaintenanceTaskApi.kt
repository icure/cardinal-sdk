package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.EncryptedMaintenanceTask
import com.icure.cardinal.sdk.model.IcureStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.MaintenanceTask
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.requests.BulkShareOrUpdateMetadataParams
import com.icure.cardinal.sdk.model.requests.EntityBulkShareResult
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawMaintenanceTaskApi {
	// region common endpoints

	suspend fun createMaintenanceTask(maintenanceTaskDto: EncryptedMaintenanceTask): HttpResponse<EncryptedMaintenanceTask>

	suspend fun deleteMaintenanceTasks(maintenanceTaskIds: ListOfIds): HttpResponse<List<DocIdentifier>>

	suspend fun deleteMaintenanceTasksWithRev(maintenanceTaskIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun deleteMaintenanceTask(
		maintenanceTaskId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun undeleteMaintenanceTask(
		maintenanceTaskId: String,
		rev: String,
	): HttpResponse<EncryptedMaintenanceTask>

	suspend fun purgeMaintenanceTask(
		maintenanceTaskId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun getMaintenanceTask(maintenanceTaskId: String): HttpResponse<EncryptedMaintenanceTask>

	suspend fun getMaintenanceTasks(ids: ListOfIds): HttpResponse<List<EncryptedMaintenanceTask>>

	suspend fun findMaintenanceTasksDelegationsStubsByIds(maintenanceTaskIds: ListOfIds): HttpResponse<List<IcureStub>>

	suspend fun modifyMaintenanceTask(maintenanceTaskDto: EncryptedMaintenanceTask): HttpResponse<EncryptedMaintenanceTask>

	suspend fun filterMaintenanceTasksBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<MaintenanceTask>,
	): HttpResponse<PaginatedList<EncryptedMaintenanceTask>>

	suspend fun matchMaintenanceTasksBy(filter: AbstractFilter<MaintenanceTask>): HttpResponse<List<String>>

	suspend fun bulkShare(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<EncryptedMaintenanceTask>>>

	suspend fun bulkShareMinimal(request: BulkShareOrUpdateMetadataParams): HttpResponse<List<EntityBulkShareResult<Nothing>>>
	// endregion
}

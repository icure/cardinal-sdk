package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.IndexingInfo
import com.icure.cardinal.sdk.model.ReplicationInfo
import com.icure.cardinal.sdk.model.couchdb.ReplicatorDocument
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawICureApi {
	// region common endpoints

	suspend fun getVersion(): HttpResponse<String>

	suspend fun isReady(): HttpResponse<String>

	suspend fun getProcessInfo(): HttpResponse<String>

	suspend fun getIndexingInfo(): HttpResponse<IndexingInfo>

	suspend fun getReplicationInfo(): HttpResponse<ReplicationInfo>

	suspend fun updateDesignDoc(
		entityName: String,
		warmup: Boolean? = null,
	): HttpResponse<Boolean>

	suspend fun resolvePatientsConflicts(limit: Int? = null): HttpResponse<List<IdWithRev>>

	suspend fun resolveContactsConflicts(limit: Int? = null): HttpResponse<List<IdWithRev>>

	suspend fun resolveFormsConflicts(limit: Int? = null): HttpResponse<List<IdWithRev>>

	suspend fun resolveHealthElementsConflicts(limit: Int? = null): HttpResponse<List<IdWithRev>>

	suspend fun resolveInvoicesConflicts(limit: Int? = null): HttpResponse<List<IdWithRev>>

	suspend fun resolveMessagesConflicts(limit: Int? = null): HttpResponse<List<IdWithRev>>

	suspend fun resolveDocumentsConflicts(
		ids: String? = null,
		limit: Int? = null,
	): HttpResponse<List<IdWithRev>>

	suspend fun resolveCodesConflicts(
		ids: String? = null,
		limit: Int? = null,
	): HttpResponse<List<IdWithRev>>
	// endregion

	// region cloud endpoints

	suspend fun getIndexingInfoByGroup(groupId: String): HttpResponse<IndexingInfo>

	suspend fun getReplicatorInfo(id: String): HttpResponse<ReplicatorDocument>

	suspend fun evictAllFromMap(mapName: String): HttpResponse<String>

	suspend fun loglevel(
		loglevel: String,
		loggerName: String,
	): HttpResponse<String>

	suspend fun updateSharedEntitiesDesignDocuments(
		cluster: String,
		databasePartition: String,
		entityType: String,
		viewPartition: String,
		dryRun: Boolean? = null,
		warmup: Boolean? = null,
	): HttpResponse<Map<String, Map<String, Map<Int, Set<String>>>>>
	// endregion
}

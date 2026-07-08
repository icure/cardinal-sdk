package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.SystemApi
import com.icure.cardinal.sdk.api.raw.RawICureApi
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class SystemApiImpl(
	private val rawApi: RawICureApi,
) : SystemApi {
	override suspend fun getVersion() = rawApi.getVersion().successBody()
	override suspend fun isReady() = rawApi.isReady().successBody()
	override suspend fun getProcessInfo() = rawApi.getProcessInfo().successBody()
	override suspend fun getIndexingInfo() = rawApi.getIndexingInfo().successBody()
	override suspend fun getReplicationInfo() = rawApi.getReplicationInfo().successBody()
	override suspend fun updateDesignDoc(
		entityName: String,
		warmup: Boolean?,
	) = rawApi.updateDesignDoc(entityName = entityName, warmup = warmup).successBody()

	override suspend fun resolvePatientsConflicts(limit: Int?) = rawApi.resolvePatientsConflicts(limit = limit).successBody()
	override suspend fun resolveContactsConflicts(limit: Int?) = rawApi.resolveContactsConflicts(limit = limit).successBody()
	override suspend fun resolveFormsConflicts(limit: Int?) = rawApi.resolveFormsConflicts(limit = limit).successBody()
	override suspend fun resolveHealthElementsConflicts(limit: Int?) = rawApi.resolveHealthElementsConflicts(limit = limit).successBody()
	override suspend fun resolveInvoicesConflicts(limit: Int?) = rawApi.resolveInvoicesConflicts(limit = limit).successBody()
	override suspend fun resolveMessagesConflicts(limit: Int?) = rawApi.resolveMessagesConflicts(limit = limit).successBody()
	override suspend fun resolveDocumentsConflicts(
		ids: String?,
		limit: Int?,
	) = rawApi.resolveDocumentsConflicts(ids = ids, limit = limit).successBody()

	override suspend fun getIndexingInfoByGroup(groupId: String) = rawApi.getIndexingInfoByGroup(groupId = groupId).successBody()
	override suspend fun getReplicatorInfo(id: String) = rawApi.getReplicatorInfo(id = id).successBody()
	override suspend fun evictAllFromMap(mapName: String) = rawApi.evictAllFromMap(mapName = mapName).successBody()
}
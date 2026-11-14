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

	@Deprecated(
		"Use sdk.patient.getConflictingEntitiesIds and sdk.patient.autoSolveConflicts " +
			"(or sdk.patient.inGroup for other groups) instead",
	)
	override suspend fun resolvePatientsConflicts(limit: Int?) = rawApi.resolvePatientsConflicts(limit = limit).successBody()
	@Deprecated(
		"Use sdk.contact.getConflictingEntitiesIds and sdk.contact.autoSolveConflicts " +
			"(or sdk.contact.inGroup for other groups) instead",
	)
	override suspend fun resolveContactsConflicts(limit: Int?) = rawApi.resolveContactsConflicts(limit = limit).successBody()
	@Deprecated("Use sdk.form.getConflictingEntitiesIds and sdk.form.autoSolveConflicts (or sdk.form.inGroup for other groups) instead")
	override suspend fun resolveFormsConflicts(limit: Int?) = rawApi.resolveFormsConflicts(limit = limit).successBody()
	@Deprecated(
		"Use sdk.healthElement.getConflictingEntitiesIds and sdk.healthElement.autoSolveConflicts " +
			"(or sdk.healthElement.inGroup for other groups) instead",
	)
	override suspend fun resolveHealthElementsConflicts(limit: Int?) = rawApi.resolveHealthElementsConflicts(limit = limit).successBody()
	@Deprecated(
		"Use sdk.invoice.getConflictingEntitiesIds and sdk.invoice.autoSolveConflicts " +
			"(or sdk.invoice.inGroup for other groups) instead",
	)
	override suspend fun resolveInvoicesConflicts(limit: Int?) = rawApi.resolveInvoicesConflicts(limit = limit).successBody()
	@Deprecated(
		"Use sdk.message.getConflictingEntitiesIds and sdk.message.autoSolveConflicts " +
			"(or sdk.message.inGroup for other groups) instead",
	)
	override suspend fun resolveMessagesConflicts(limit: Int?) = rawApi.resolveMessagesConflicts(limit = limit).successBody()
	@Deprecated(
		"Use sdk.document.getConflictingEntitiesIds and sdk.document.autoSolveConflicts " +
			"(or sdk.document.inGroup for other groups) instead",
	)
	override suspend fun resolveDocumentsConflicts(
		ids: String?,
		limit: Int?,
	) = rawApi.resolveDocumentsConflicts(ids = ids, limit = limit).successBody()

	override suspend fun getIndexingInfoByGroup(groupId: String) = rawApi.getIndexingInfoByGroup(groupId = groupId).successBody()
	override suspend fun getReplicatorInfo(id: String) = rawApi.getReplicatorInfo(id = id).successBody()
	override suspend fun evictAllFromMap(mapName: String) = rawApi.evictAllFromMap(mapName = mapName).successBody()
}

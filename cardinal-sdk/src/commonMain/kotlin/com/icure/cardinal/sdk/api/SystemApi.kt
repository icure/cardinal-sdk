package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.IndexingInfo
import com.icure.cardinal.sdk.model.ReplicationInfo
import com.icure.cardinal.sdk.model.couchdb.ReplicatorDocument
import com.icure.cardinal.sdk.utils.DefaultValue

interface SystemApi {
	suspend fun getVersion(): String
	suspend fun isReady(): String
	suspend fun getProcessInfo(): String
	suspend fun getIndexingInfo(): IndexingInfo
	suspend fun getReplicationInfo(): ReplicationInfo
	suspend fun updateDesignDoc(
		entityName: String,
		@DefaultValue("null")
		warmup: Boolean? = null,
	): Boolean

	@Deprecated(
		"Use sdk.patient.getConflictingEntitiesIds and sdk.patient.autoSolveConflicts " +
			"(or sdk.patient.inGroup for other groups) instead",
	)
	suspend fun resolvePatientsConflicts(
		@DefaultValue("null")
		limit: Int? = null
	): List<IdWithRev>
	@Deprecated(
		"Use sdk.contact.getConflictingEntitiesIds and sdk.contact.autoSolveConflicts " +
			"(or sdk.contact.inGroup for other groups) instead",
	)
	suspend fun resolveContactsConflicts(
		@DefaultValue("null")
		limit: Int? = null
	): List<IdWithRev>
	@Deprecated("Use sdk.form.getConflictingEntitiesIds and sdk.form.autoSolveConflicts (or sdk.form.inGroup for other groups) instead")
	suspend fun resolveFormsConflicts(
		@DefaultValue("null")
		limit: Int? = null
	): List<IdWithRev>
	@Deprecated(
		"Use sdk.healthElement.getConflictingEntitiesIds and sdk.healthElement.autoSolveConflicts " +
			"(or sdk.healthElement.inGroup for other groups) instead",
	)
	suspend fun resolveHealthElementsConflicts(
		@DefaultValue("null")
		limit: Int? = null
	): List<IdWithRev>
	@Deprecated(
		"Use sdk.invoice.getConflictingEntitiesIds and sdk.invoice.autoSolveConflicts " +
			"(or sdk.invoice.inGroup for other groups) instead",
	)
	suspend fun resolveInvoicesConflicts(
		@DefaultValue("null")
		limit: Int? = null
	): List<IdWithRev>
	@Deprecated(
		"Use sdk.message.getConflictingEntitiesIds and sdk.message.autoSolveConflicts " +
			"(or sdk.message.inGroup for other groups) instead",
	)
	suspend fun resolveMessagesConflicts(
		@DefaultValue("null")
		limit: Int? = null
	): List<IdWithRev>
	@Deprecated(
		"Use sdk.document.getConflictingEntitiesIds and sdk.document.autoSolveConflicts " +
			"(or sdk.document.inGroup for other groups) instead",
	)
	suspend fun resolveDocumentsConflicts(
		@DefaultValue("null")
		ids: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): List<IdWithRev>

	suspend fun getIndexingInfoByGroup(groupId: String): IndexingInfo
	suspend fun getReplicatorInfo(id: String): ReplicatorDocument
	suspend fun evictAllFromMap(mapName: String): String
}


package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.GroupApi
import com.icure.cardinal.sdk.utils.pagination.encodeStartKey
import com.icure.cardinal.sdk.api.raw.RawGroupApi
import com.icure.cardinal.sdk.model.DatabaseInitialisation
import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.model.GroupDeletionReport
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfProperties
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.RegistrationInformation
import com.icure.cardinal.sdk.model.RegistrationSuccess
import com.icure.cardinal.sdk.model.ReplicationInfo
import com.icure.cardinal.sdk.model.couchdb.DesignDocument
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.couchdb.GroupDatabasesInfo
import com.icure.cardinal.sdk.model.embed.GroupType
import com.icure.cardinal.sdk.model.embed.RoleConfiguration
import com.icure.cardinal.sdk.model.embed.UserType
import com.icure.cardinal.sdk.model.security.ExternalJwtConfig
import com.icure.cardinal.sdk.model.security.Operation
import com.icure.cardinal.sdk.model.security.PermissionType
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.JsonElement

@InternalIcureApi
internal class GroupApiImpl(
	private val rawApi: RawGroupApi,
) : GroupApi {
    override suspend fun listGroups(): List<Group> = rawApi.listGroups().successBody()
    override suspend fun getGroup(id: String): Group = rawApi.getGroup(id).successBody()
    override suspend fun createGroup(
		id: String,
		name: String,
		type: GroupType?,
		password: String,
		server: String?,
		q: Int?,
		n: Int?,
		superGroup: String?,
		projectId: String?,
		initialisationData: DatabaseInitialisation,
    ): Group = rawApi.createGroup(
	    id = id,
	    name = name,
	    type = type,
	    password = password,
	    server = server,
	    q = q,
	    n = n,
	    superGroup = superGroup,
	    applicationId = projectId,
	    initialisationData = initialisationData,
    ).successBody()

    override suspend fun registerNewGroupAdministrator(
	    type: GroupType?,
	    role: PermissionType?,
	    registrationInformation: RegistrationInformation,
    ): RegistrationSuccess = rawApi.registerNewGroupAdministrator(type, role, registrationInformation).successBody()

    override suspend fun listApps(): List<Group> = rawApi.listApps().successBody()

    @Deprecated("Will be replaced by filters")
    override suspend fun findGroups(
		id: String,
		startDocumentId: String?,
		limit: Int?,
    ): PaginatedList<Group> = rawApi.findGroups(id, startDocumentId, limit).successBody()

    @Deprecated("Will be replaced by filters")
    override suspend fun findGroupsWithContent(
	    id: String,
	    searchString: String,
	    startKey: JsonElement?,
	    startDocumentId: String?,
	    limit: Int?,
    ): PaginatedList<Group> =
        rawApi.findGroupsWithContent(id, searchString, startKey.encodeStartKey(), startDocumentId, limit).successBody()

    override suspend fun getNameOfGroupParent(id: String): String = rawApi.getNameOfGroupParent(id).successBody()

    override suspend fun modifyGroupName(id: String, name: String): Group = rawApi.modifyGroupName(id, name).successBody()

    override suspend fun getOperationToken(
	    operation: Operation,
	    duration: Long?,
	    description: String?,
    ): String = rawApi.getOperationToken(operation, duration, description).successBody()

    override suspend fun deleteOperationToken(tokenId: String): Unit = rawApi.deleteOperationToken(tokenId).successBody()

    override suspend fun setDefaultRoles(
        groupId: String,
        userType: String,
        roleIds: List<String>,
    ): Group = rawApi.setDefaultRoles(groupId, userType, ListOfIds(roleIds)).successBody()

    override suspend fun getDefaultRoles(groupId: String): Map<UserType, List<RoleConfiguration>> =
        rawApi.getDefaultRoles(groupId).successBody()

    override suspend fun deleteGroup(id: String): Group = rawApi.deleteGroup(id).successBody()
    override suspend fun changeSuperGroup(childGroupId: String, operationToken: String): Group =
        rawApi.changeSuperGroup(childGroupId, operationToken).successBody()

    override suspend fun hardDeleteGroup(id: String): List<GroupDeletionReport> = rawApi.hardDeleteGroup(id).successBody()
    override suspend fun modifyGroupProperties(id: String, properties: ListOfProperties): Group =
        rawApi.modifyGroupProperties(id, properties).successBody()

    override suspend fun setGroupPassword(id: String, password: String): Group =
        rawApi.setGroupPassword(id, password).successBody()

    override suspend fun initDesignDocs(
		id: String,
		clazz: String?,
		warmup: Boolean?,
		dryRun: Boolean?
    ): List<DesignDocument> = rawApi.initDesignDocs(id, clazz, warmup, dryRun).successBody()

    override suspend fun solveConflicts(id: String, limit: Int?, warmup: Boolean?): List<IdWithRev> =
        rawApi.solveConflicts(id, limit, warmup).successBody()

    override suspend fun resetStorage(id: String, q: Int?, n: Int?, databases: List<String>): Unit =
        rawApi.resetStorage(id, q, n, ListOfIds(databases)).successBody()

    override suspend fun getGroupsStorageInfos(groups: List<String>): List<GroupDatabasesInfo> =
        rawApi.getGroupsStorageInfos(ListOfIds(groups)).successBody()

	override suspend fun modifyGroupApplicationId(
		id: String,
		applicationId: String,
	): Group = rawApi.modifyGroupApplicationId(id, applicationId).successBody()

	override suspend fun addTagToGroup(
		id: String,
		rev: String,
		tag: CodeStub,
	): Group = rawApi.addTagToGroup(id, rev, tag).successBody()

	override suspend fun removeTagFromGroup(
		id: String,
		rev: String,
		tagId: String,
	): Group = rawApi.removeTagFromGroup(id, rev, tagId).successBody()
	
	override suspend fun getReplicationInfo(id: String): ReplicationInfo = rawApi.getReplicationInfo(id).successBody()
    override suspend fun getHierarchy(id: String): List<String> = rawApi.getHierarchy(id).successBody()
    override suspend fun listAllGroupsIds(): List<DocIdentifier> = rawApi.listAllGroupsIds().successBody()
	override suspend fun createOrUpdateExternalJwtConfig(groupId: String, key: String, config: ExternalJwtConfig): Group =
		rawApi.createOrUpdateExternalJwtConfig(groupId, key, config).successBody()
	override suspend fun removeExternalJwtConfig(groupId: String, key: String): Group =
		rawApi.removeExternalJwtConfig(groupId, key).successBody()
	override suspend fun getOperationTokenForGroup(groupId: String, operation: Operation, duration: Long?, description: String?): String =
		rawApi.getOperationTokenForGroup(groupId, operation, duration, description).successBody()

	override suspend fun setGroupProjectId(
		groupId: String,
		projectId: String?,
		applyToSubgroups: Boolean
	) {
		if (projectId == null)
			rawApi.deleteGroupApplicationId(groupId, applyToSubgroups).successBody()
		else
			rawApi.modifyGroupApplicationId(groupId, projectId, applyToSubgroups).successBody()
	}
}

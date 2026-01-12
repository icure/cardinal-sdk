package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.DatabaseInitialisation
import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.model.GroupDeletionReport
import com.icure.cardinal.sdk.model.IdWithRev
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
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.json.JsonElement

interface GroupApi {
	suspend fun listGroups(): List<Group>
	suspend fun getGroup(id: String): Group
	suspend fun createGroup(
		id: String,
		name: String,
		@DefaultValue("null")
		type: GroupType? = null,
		password: String,
		@DefaultValue("null")
		server: String? = null,
		@DefaultValue("null")
		q: Int? = null,
		@DefaultValue("null")
		n: Int? = null,
		@DefaultValue("null")
		superGroup: String? = null,
		@DefaultValue("null")
		projectId: String? = null,
		initialisationData: DatabaseInitialisation,
	): Group

	suspend fun registerNewGroupAdministrator(
		@DefaultValue("null")
		type: GroupType? = null,
		@DefaultValue("null")
		role: PermissionType? = null,
		registrationInformation: RegistrationInformation,
	): RegistrationSuccess

	suspend fun listApps(): List<Group>
	@Deprecated("Will be replaced by filters")
	suspend fun findGroups(
		id: String,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<Group>
	@Deprecated("Will be replaced by filters")
	suspend fun findGroupsWithContent(
		id: String,
		searchString: String,
		@DefaultValue("null")
		startKey: JsonElement? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<Group>

	suspend fun getNameOfGroupParent(id: String): String
	suspend fun modifyGroupName(id: String, name: String): Group
	suspend fun getOperationToken(
		operation: Operation,
		duration: Long?,
		@DefaultValue("null")
		description: String? = null,
	): String

	suspend fun deleteOperationToken(tokenId: String)
	suspend fun setDefaultRoles(
		groupId: String,
		userType: String,
		roleIds: List<String>,
	): Group

	suspend fun getDefaultRoles(groupId: String): Map<UserType, List<RoleConfiguration>>
	suspend fun deleteGroup(id: String): Group
	suspend fun changeSuperGroup(childGroupId: String, operationToken: String): Group
	suspend fun hardDeleteGroup(id: String): List<GroupDeletionReport>
	suspend fun modifyGroupProperties(id: String, properties: ListOfProperties): Group
	suspend fun setGroupPassword(id: String, password: String): Group
	suspend fun initDesignDocs(
		id: String,
		@DefaultValue("null")
		clazz: String? = null,
		warmup: Boolean?,
		dryRun: Boolean?
	): List<DesignDocument>

	suspend fun solveConflicts(id: String, limit: Int?, warmup: Boolean?): List<IdWithRev>
	suspend fun resetStorage(
		id: String,
		@DefaultValue("null")
		q: Int? = null,
		@DefaultValue("null")
		n: Int? = null,
		databases: List<String>
	)
	suspend fun getGroupsStorageInfos(groups: List<String>): List<GroupDatabasesInfo>
	suspend fun getReplicationInfo(id: String): ReplicationInfo
	suspend fun getHierarchy(id: String): List<String>
	suspend fun listAllGroupsIds(): List<DocIdentifier>
	suspend fun createOrUpdateExternalJwtConfig(groupId: String, key: String, config: ExternalJwtConfig): Group
	suspend fun removeExternalJwtConfig(groupId: String, key: String): Group
	suspend fun getOperationTokenForGroup(groupId: String, operation: Operation, duration: Long?, description: String? = null) : String

	/**
	 * Sets the projectId of a group and optionally applies the change to all its subgroups (direct and indirect child groups).
	 * @param groupId the id of the group to update.
	 * @param projectId the new projectId to set. If null, any existing projectId will be removed.
	 * @param applyToSubgroups if true, the change will be applied
	 */
	suspend fun setGroupProjectId(groupId: String, projectId: String?, applyToSubgroups: Boolean)
}

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
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.couchdb.DesignDocument
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.couchdb.GroupDatabasesInfo
import com.icure.cardinal.sdk.model.embed.GroupType
import com.icure.cardinal.sdk.model.embed.RoleConfiguration
import com.icure.cardinal.sdk.model.embed.UserType
import com.icure.cardinal.sdk.model.security.ExternalJwtConfig
import com.icure.cardinal.sdk.model.security.Operation
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
	suspend fun modifyGroupApplicationId(id: String, applicationId: String): Group
	suspend fun addTagToGroup(id: String, rev: String, tag: CodeStub): Group
	suspend fun removeTagFromGroup(id: String, rev: String, tagId: String): Group
	suspend fun createApplicationGroup(
		id: String,
		name: String,
		@DefaultValue("null")
		server: String? = null,
		@DefaultValue("null")
		q: Int? = null,
		@DefaultValue("null")
		n: Int?= null,
		@DefaultValue("null")
		superGroup: String? = null,
		@DefaultValue("null")
		projectId: String? = null,
	): Group

	suspend fun createTenantGroup(
		id: String,
		name: String,
		@DefaultValue("null")
		server: String? = null,
		@DefaultValue("null")
		q: Int? = null,
		@DefaultValue("null")
		n: Int?= null,
		@DefaultValue("null")
		superGroup: String? = null,
		@DefaultValue("null")
		projectId: String? = null,
	): Group

	/**
	 * Sets a design doc schema version as available on or more groups. This operation will fail if the schema version [schemaVersion]
	 * does not exist for the application or if there is at least one group among [groupIds] where the indexation task were not run.
	 *
	 * @param applicationGroupId the id of the application group. All the groups specified in [groupIds] must be children of this group.
	 * @param schemaVersion the version of the schema to enable.
	 * @param groupIds the ids of the groups to update.
	 */
	suspend fun addSchemaVersionOnGroups(applicationGroupId: String, schemaVersion: Int, groupIds: List<String>): List<Group>

	/**
	 * Removes a design doc schema version as available on or more groups. This operation will fail if that schema version is the only one
	 * to be enabled on at least one group, unless [failIfSingleSchema] is set to false.
	 *
	 * @param applicationGroupId the id of the application group. All the groups specified in [groupIds] must be children of this group.
	 * @param schemaVersion the version of the schema to enable.
	 * @param groupIds the ids of the groups to update.
	 * @param failIfSingleSchema if false, the operation will not fail if the specified version is the only one enabled on one or more of the
	 * groups.
	 */
	suspend fun removeSchemaVersionFromGroups(
		applicationGroupId: String,
		schemaVersion: Int,
		groupIds: List<String>,
		@DefaultValue("true")
		failIfSingleSchema: Boolean = true
	): List<Group>
}

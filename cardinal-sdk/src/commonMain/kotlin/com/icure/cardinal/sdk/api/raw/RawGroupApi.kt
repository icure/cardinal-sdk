package com.icure.cardinal.sdk.api.raw

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
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.couchdb.DesignDocument
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.couchdb.GroupDatabasesInfo
import com.icure.cardinal.sdk.model.embed.GroupType
import com.icure.cardinal.sdk.model.embed.RoleConfiguration
import com.icure.cardinal.sdk.model.embed.UserType
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.security.ExternalJwtConfig
import com.icure.cardinal.sdk.model.security.Operation
import com.icure.cardinal.sdk.model.security.PermissionType
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawGroupApi {
	// region cloud endpoints

	suspend fun createGroup(
		id: String,
		name: String,
		type: GroupType? = null,
		password: String,
		server: String? = null,
		q: Int? = null,
		n: Int? = null,
		superGroup: String? = null,
		applicationId: String? = null,
		initialisationData: DatabaseInitialisation,
	): HttpResponse<Group>

	suspend fun registerNewGroupAdministrator(
		type: GroupType? = null,
		role: PermissionType? = null,
		registrationInformation: RegistrationInformation,
	): HttpResponse<RegistrationSuccess>

	suspend fun listGroups(): HttpResponse<List<Group>>

	suspend fun listApps(): HttpResponse<List<Group>>

	suspend fun findGroups(
		id: String,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Group>>

	suspend fun findGroupsWithContent(
		id: String,
		searchString: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Group>>

	suspend fun getGroup(id: String): HttpResponse<Group>

	suspend fun getGroups(groupIds: ListOfIds): HttpResponse<List<Group>>

	suspend fun getNameOfGroupParent(id: String): HttpResponse<String>

	suspend fun modifyGroupName(
		id: String,
		name: String,
	): HttpResponse<Group>

	suspend fun modifyGroupApplicationId(
		id: String,
		applicationId: String,
		applyToSubGroups: Boolean? = null,
	): HttpResponse<Group>

	suspend fun deleteGroupApplicationId(
		id: String,
		applyToSubGroups: Boolean? = null,
	): HttpResponse<Group>

	suspend fun getOperationToken(
		operation: Operation,
		duration: Long?,
		description: String? = null,
	): HttpResponse<String>

	suspend fun getOperationTokenForGroup(
		groupId: String,
		operation: Operation,
		duration: Long?,
		description: String? = null,
	): HttpResponse<String>

	suspend fun deleteOperationToken(tokenId: String): HttpResponse<Unit>

	suspend fun setDefaultRoles(
		groupId: String,
		userType: String,
		roleIds: ListOfIds,
	): HttpResponse<Group>

	suspend fun getDefaultRoles(groupId: String): HttpResponse<Map<UserType, List<RoleConfiguration>>>

	suspend fun changeSuperGroup(
		childGroupId: String,
		operationToken: String,
	): HttpResponse<Group>

	suspend fun deleteGroup(id: String): HttpResponse<Group>

	suspend fun hardDeleteGroup(id: String): HttpResponse<List<GroupDeletionReport>>

	suspend fun modifyGroupProperties(
		id: String,
		properties: ListOfProperties,
	): HttpResponse<Group>

	suspend fun addTagToGroup(
		id: String,
		rev: String,
		tag: CodeStub,
	): HttpResponse<Group>

	suspend fun removeTagFromGroup(
		id: String,
		rev: String,
		tagId: String,
	): HttpResponse<Group>

	suspend fun setGroupPassword(
		id: String,
		password: String,
	): HttpResponse<Group>

	suspend fun initDesignDocs(
		id: String,
		clazz: String? = null,
		warmup: Boolean?,
		dryRun: Boolean?,
	): HttpResponse<List<DesignDocument>>

	suspend fun solveConflicts(
		groupId: String,
		limit: Int?,
		warmup: Boolean?,
	): HttpResponse<List<IdWithRev>>

	suspend fun resetStorage(
		id: String,
		q: Int? = null,
		n: Int? = null,
		databases: ListOfIds,
	): HttpResponse<Unit>

	suspend fun getGroupsStorageInfos(groups: ListOfIds): HttpResponse<List<GroupDatabasesInfo>>

	suspend fun getReplicationInfo(id: String): HttpResponse<ReplicationInfo>

	suspend fun getHierarchy(id: String): HttpResponse<List<String>>

	suspend fun createOrUpdateExternalJwtConfig(
		groupId: String,
		key: String,
		config: ExternalJwtConfig,
	): HttpResponse<Group>

	suspend fun removeExternalJwtConfig(
		groupId: String,
		key: String,
	): HttpResponse<Group>

	suspend fun listAllGroupsIds(): HttpResponse<List<DocIdentifier>>

	suspend fun matchGroupsBy(filter: AbstractFilter<Group>): HttpResponse<List<String>>
	// endregion
}

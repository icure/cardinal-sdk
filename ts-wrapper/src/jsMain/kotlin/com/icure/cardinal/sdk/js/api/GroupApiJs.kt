// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.DatabaseInitialisationJs
import com.icure.cardinal.sdk.js.model.GroupDeletionReportJs
import com.icure.cardinal.sdk.js.model.GroupJs
import com.icure.cardinal.sdk.js.model.IdWithRevJs
import com.icure.cardinal.sdk.js.model.ListOfPropertiesJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.RegistrationInformationJs
import com.icure.cardinal.sdk.js.model.RegistrationSuccessJs
import com.icure.cardinal.sdk.js.model.ReplicationInfoJs
import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.couchdb.DesignDocumentJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.GroupDatabasesInfoJs
import com.icure.cardinal.sdk.js.model.embed.RoleConfigurationJs
import com.icure.cardinal.sdk.js.model.security.ExternalJwtConfigJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("GroupApi")
public external interface GroupApiJs {
	public fun listGroups(): Promise<Array<GroupJs>>

	public fun getGroup(id: String): Promise<GroupJs>

	public fun createGroup(
		id: String,
		name: String,
		password: String,
		initialisationData: DatabaseInitialisationJs,
		options: dynamic,
	): Promise<GroupJs>

	public fun registerNewGroupAdministrator(registrationInformation: RegistrationInformationJs,
			options: dynamic): Promise<RegistrationSuccessJs>

	public fun listApps(): Promise<Array<GroupJs>>

	public fun findGroups(id: String, options: dynamic): Promise<PaginatedListJs<GroupJs>>

	public fun findGroupsWithContent(
		id: String,
		searchString: String,
		options: dynamic,
	): Promise<PaginatedListJs<GroupJs>>

	public fun getNameOfGroupParent(id: String): Promise<String>

	public fun modifyGroupName(id: String, name: String): Promise<GroupJs>

	public fun getOperationToken(
		operation: String,
		duration: Double?,
		options: dynamic,
	): Promise<String>

	public fun deleteOperationToken(tokenId: String): Promise<Unit>

	public fun setDefaultRoles(
		groupId: String,
		userType: String,
		roleIds: Array<String>,
	): Promise<GroupJs>

	public fun getDefaultRoles(groupId: String): Promise<Record<String, Array<RoleConfigurationJs>>>

	public fun deleteGroup(id: String): Promise<GroupJs>

	public fun changeSuperGroup(childGroupId: String, operationToken: String): Promise<GroupJs>

	public fun hardDeleteGroup(id: String): Promise<Array<GroupDeletionReportJs>>

	public fun modifyGroupProperties(id: String, properties: ListOfPropertiesJs): Promise<GroupJs>

	public fun setGroupPassword(id: String, password: String): Promise<GroupJs>

	public fun initDesignDocs(
		id: String,
		warmup: Boolean?,
		dryRun: Boolean?,
		options: dynamic,
	): Promise<Array<DesignDocumentJs>>

	public fun solveConflicts(
		id: String,
		limit: Double?,
		warmup: Boolean?,
	): Promise<Array<IdWithRevJs>>

	public fun resetStorage(
		id: String,
		databases: Array<String>,
		options: dynamic,
	): Promise<Unit>

	public fun getGroupsStorageInfos(groups: Array<String>): Promise<Array<GroupDatabasesInfoJs>>

	public fun getReplicationInfo(id: String): Promise<ReplicationInfoJs>

	public fun getHierarchy(id: String): Promise<Array<String>>

	public fun listAllGroupsIds(): Promise<Array<DocIdentifierJs>>

	public fun createOrUpdateExternalJwtConfig(
		groupId: String,
		key: String,
		config: ExternalJwtConfigJs,
	): Promise<GroupJs>

	public fun removeExternalJwtConfig(groupId: String, key: String): Promise<GroupJs>

	public fun getOperationTokenForGroup(
		groupId: String,
		operation: String,
		duration: Double?,
		description: String?,
	): Promise<String>

	public fun setGroupProjectId(
		groupId: String,
		projectId: String?,
		applyToSubgroups: Boolean,
	): Promise<Unit>

	public fun modifyGroupApplicationId(id: String, applicationId: String): Promise<GroupJs>

	public fun addTagToGroup(
		id: String,
		rev: String,
		tag: CodeStubJs,
	): Promise<GroupJs>

	public fun removeTagFromGroup(
		id: String,
		rev: String,
		tagId: String,
	): Promise<GroupJs>
}

// auto-generated file
package com.icure.cardinal.sdk.py.api.GroupApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
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
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonElement

public fun listGroupsBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.group.listGroups()
	}
}.toPyString(ListSerializer(Group.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listGroupsAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.listGroups()
		}.toPyStringAsyncCallback(ListSerializer(Group.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetGroupParams(
	public val id: String,
)

@OptIn(InternalIcureApi::class)
public fun getGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetGroupParams>(params)
	runBlocking {
		sdk.group.getGroup(
			decodedParams.id,
		)
	}
}.toPyString(Group.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.getGroup(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateGroupParams(
	public val id: String,
	public val name: String,
	public val type: GroupType? = null,
	public val password: String,
	public val server: String? = null,
	public val q: Int? = null,
	public val n: Int? = null,
	public val superGroup: String? = null,
	public val projectId: String? = null,
	public val initialisationData: DatabaseInitialisation,
)

@OptIn(InternalIcureApi::class)
public fun createGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateGroupParams>(params)
	runBlocking {
		sdk.group.createGroup(
			decodedParams.id,
			decodedParams.name,
			decodedParams.type,
			decodedParams.password,
			decodedParams.server,
			decodedParams.q,
			decodedParams.n,
			decodedParams.superGroup,
			decodedParams.projectId,
			decodedParams.initialisationData,
		)
	}
}.toPyString(Group.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.createGroup(
				decodedParams.id,
				decodedParams.name,
				decodedParams.type,
				decodedParams.password,
				decodedParams.server,
				decodedParams.q,
				decodedParams.n,
				decodedParams.superGroup,
				decodedParams.projectId,
				decodedParams.initialisationData,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class RegisterNewGroupAdministratorParams(
	public val type: GroupType? = null,
	public val registrationInformation: RegistrationInformation,
)

@OptIn(InternalIcureApi::class)
public fun registerNewGroupAdministratorBlocking(sdk: CardinalNonCryptoApis, params: String): String
		= kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<RegisterNewGroupAdministratorParams>(params)
	runBlocking {
		sdk.group.registerNewGroupAdministrator(
			decodedParams.type,
			decodedParams.registrationInformation,
		)
	}
}.toPyString(RegistrationSuccess.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun registerNewGroupAdministratorAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<RegisterNewGroupAdministratorParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.registerNewGroupAdministrator(
				decodedParams.type,
				decodedParams.registrationInformation,
			)
		}.toPyStringAsyncCallback(RegistrationSuccess.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun listAppsBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.group.listApps()
	}
}.toPyString(ListSerializer(Group.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listAppsAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.listApps()
		}.toPyStringAsyncCallback(ListSerializer(Group.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindGroupsParams(
	public val id: String,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun findGroupsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindGroupsParams>(params)
	runBlocking {
		sdk.group.findGroups(
			decodedParams.id,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(Group.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findGroupsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindGroupsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.findGroups(
				decodedParams.id,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(Group.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindGroupsWithContentParams(
	public val id: String,
	public val searchString: String,
	public val startKey: JsonElement? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun findGroupsWithContentBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindGroupsWithContentParams>(params)
	runBlocking {
		sdk.group.findGroupsWithContent(
			decodedParams.id,
			decodedParams.searchString,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(Group.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findGroupsWithContentAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindGroupsWithContentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.findGroupsWithContent(
				decodedParams.id,
				decodedParams.searchString,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(Group.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetNameOfGroupParentParams(
	public val id: String,
)

@OptIn(InternalIcureApi::class)
public fun getNameOfGroupParentBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetNameOfGroupParentParams>(params)
	runBlocking {
		sdk.group.getNameOfGroupParent(
			decodedParams.id,
		)
	}
}.toPyString(String.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getNameOfGroupParentAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetNameOfGroupParentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.getNameOfGroupParent(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyGroupNameParams(
	public val id: String,
	public val name: String,
)

@OptIn(InternalIcureApi::class)
public fun modifyGroupNameBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyGroupNameParams>(params)
	runBlocking {
		sdk.group.modifyGroupName(
			decodedParams.id,
			decodedParams.name,
		)
	}
}.toPyString(Group.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyGroupNameAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyGroupNameParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.modifyGroupName(
				decodedParams.id,
				decodedParams.name,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetOperationTokenParams(
	public val operation: Operation,
	public val duration: Long?,
	public val description: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun getOperationTokenBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetOperationTokenParams>(params)
	runBlocking {
		sdk.group.getOperationToken(
			decodedParams.operation,
			decodedParams.duration,
			decodedParams.description,
		)
	}
}.toPyString(String.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getOperationTokenAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetOperationTokenParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.getOperationToken(
				decodedParams.operation,
				decodedParams.duration,
				decodedParams.description,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteOperationTokenParams(
	public val tokenId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteOperationTokenBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteOperationTokenParams>(params)
	runBlocking {
		sdk.group.deleteOperationToken(
			decodedParams.tokenId,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteOperationTokenAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteOperationTokenParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.deleteOperationToken(
				decodedParams.tokenId,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetDefaultRolesParams(
	public val groupId: String,
	public val userType: String,
	public val roleIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun setDefaultRolesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetDefaultRolesParams>(params)
	runBlocking {
		sdk.group.setDefaultRoles(
			decodedParams.groupId,
			decodedParams.userType,
			decodedParams.roleIds,
		)
	}
}.toPyString(Group.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setDefaultRolesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetDefaultRolesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.setDefaultRoles(
				decodedParams.groupId,
				decodedParams.userType,
				decodedParams.roleIds,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDefaultRolesParams(
	public val groupId: String,
)

@OptIn(InternalIcureApi::class)
public fun getDefaultRolesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetDefaultRolesParams>(params)
	runBlocking {
		sdk.group.getDefaultRoles(
			decodedParams.groupId,
		)
	}
}.toPyString(MapSerializer(UserType.serializer(), ListSerializer(RoleConfiguration.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getDefaultRolesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetDefaultRolesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.getDefaultRoles(
				decodedParams.groupId,
			)
		}.toPyStringAsyncCallback(MapSerializer(UserType.serializer(),
				ListSerializer(RoleConfiguration.serializer())), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteGroupParams(
	public val id: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteGroupParams>(params)
	runBlocking {
		sdk.group.deleteGroup(
			decodedParams.id,
		)
	}
}.toPyString(Group.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.deleteGroup(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ChangeSuperGroupParams(
	public val childGroupId: String,
	public val operationToken: String,
)

@OptIn(InternalIcureApi::class)
public fun changeSuperGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ChangeSuperGroupParams>(params)
	runBlocking {
		sdk.group.changeSuperGroup(
			decodedParams.childGroupId,
			decodedParams.operationToken,
		)
	}
}.toPyString(Group.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun changeSuperGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ChangeSuperGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.changeSuperGroup(
				decodedParams.childGroupId,
				decodedParams.operationToken,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HardDeleteGroupParams(
	public val id: String,
)

@OptIn(InternalIcureApi::class)
public fun hardDeleteGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HardDeleteGroupParams>(params)
	runBlocking {
		sdk.group.hardDeleteGroup(
			decodedParams.id,
		)
	}
}.toPyString(ListSerializer(GroupDeletionReport.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun hardDeleteGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HardDeleteGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.hardDeleteGroup(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupDeletionReport.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyGroupPropertiesParams(
	public val id: String,
	public val properties: ListOfProperties,
)

@OptIn(InternalIcureApi::class)
public fun modifyGroupPropertiesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyGroupPropertiesParams>(params)
	runBlocking {
		sdk.group.modifyGroupProperties(
			decodedParams.id,
			decodedParams.properties,
		)
	}
}.toPyString(Group.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyGroupPropertiesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyGroupPropertiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.modifyGroupProperties(
				decodedParams.id,
				decodedParams.properties,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetGroupPasswordParams(
	public val id: String,
	public val password: String,
)

@OptIn(InternalIcureApi::class)
public fun setGroupPasswordBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetGroupPasswordParams>(params)
	runBlocking {
		sdk.group.setGroupPassword(
			decodedParams.id,
			decodedParams.password,
		)
	}
}.toPyString(Group.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setGroupPasswordAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetGroupPasswordParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.setGroupPassword(
				decodedParams.id,
				decodedParams.password,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class InitDesignDocsParams(
	public val id: String,
	public val clazz: String? = null,
	public val warmup: Boolean?,
	public val dryRun: Boolean?,
)

@OptIn(InternalIcureApi::class)
public fun initDesignDocsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<InitDesignDocsParams>(params)
	runBlocking {
		sdk.group.initDesignDocs(
			decodedParams.id,
			decodedParams.clazz,
			decodedParams.warmup,
			decodedParams.dryRun,
		)
	}
}.toPyString(ListSerializer(DesignDocument.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun initDesignDocsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<InitDesignDocsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.initDesignDocs(
				decodedParams.id,
				decodedParams.clazz,
				decodedParams.warmup,
				decodedParams.dryRun,
			)
		}.toPyStringAsyncCallback(ListSerializer(DesignDocument.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SolveConflictsParams(
	public val id: String,
	public val limit: Int?,
	public val warmup: Boolean?,
)

@OptIn(InternalIcureApi::class)
public fun solveConflictsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SolveConflictsParams>(params)
	runBlocking {
		sdk.group.solveConflicts(
			decodedParams.id,
			decodedParams.limit,
			decodedParams.warmup,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun solveConflictsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SolveConflictsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.solveConflicts(
				decodedParams.id,
				decodedParams.limit,
				decodedParams.warmup,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResetStorageParams(
	public val id: String,
	public val q: Int? = null,
	public val n: Int? = null,
	public val databases: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun resetStorageBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ResetStorageParams>(params)
	runBlocking {
		sdk.group.resetStorage(
			decodedParams.id,
			decodedParams.q,
			decodedParams.n,
			decodedParams.databases,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun resetStorageAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ResetStorageParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.resetStorage(
				decodedParams.id,
				decodedParams.q,
				decodedParams.n,
				decodedParams.databases,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetGroupsStorageInfosParams(
	public val groups: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getGroupsStorageInfosBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetGroupsStorageInfosParams>(params)
	runBlocking {
		sdk.group.getGroupsStorageInfos(
			decodedParams.groups,
		)
	}
}.toPyString(ListSerializer(GroupDatabasesInfo.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getGroupsStorageInfosAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetGroupsStorageInfosParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.getGroupsStorageInfos(
				decodedParams.groups,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupDatabasesInfo.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetReplicationInfoParams(
	public val id: String,
)

@OptIn(InternalIcureApi::class)
public fun getReplicationInfoBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetReplicationInfoParams>(params)
	runBlocking {
		sdk.group.getReplicationInfo(
			decodedParams.id,
		)
	}
}.toPyString(ReplicationInfo.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getReplicationInfoAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetReplicationInfoParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.getReplicationInfo(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(ReplicationInfo.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetHierarchyParams(
	public val id: String,
)

@OptIn(InternalIcureApi::class)
public fun getHierarchyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetHierarchyParams>(params)
	runBlocking {
		sdk.group.getHierarchy(
			decodedParams.id,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getHierarchyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetHierarchyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.getHierarchy(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun listAllGroupsIdsBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.group.listAllGroupsIds()
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listAllGroupsIdsAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.listAllGroupsIds()
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateOrUpdateExternalJwtConfigParams(
	public val groupId: String,
	public val key: String,
	public val config: ExternalJwtConfig,
)

@OptIn(InternalIcureApi::class)
public fun createOrUpdateExternalJwtConfigBlocking(sdk: CardinalNonCryptoApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateOrUpdateExternalJwtConfigParams>(params)
	runBlocking {
		sdk.group.createOrUpdateExternalJwtConfig(
			decodedParams.groupId,
			decodedParams.key,
			decodedParams.config,
		)
	}
}.toPyString(Group.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createOrUpdateExternalJwtConfigAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateOrUpdateExternalJwtConfigParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.createOrUpdateExternalJwtConfig(
				decodedParams.groupId,
				decodedParams.key,
				decodedParams.config,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class RemoveExternalJwtConfigParams(
	public val groupId: String,
	public val key: String,
)

@OptIn(InternalIcureApi::class)
public fun removeExternalJwtConfigBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<RemoveExternalJwtConfigParams>(params)
	runBlocking {
		sdk.group.removeExternalJwtConfig(
			decodedParams.groupId,
			decodedParams.key,
		)
	}
}.toPyString(Group.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun removeExternalJwtConfigAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<RemoveExternalJwtConfigParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.removeExternalJwtConfig(
				decodedParams.groupId,
				decodedParams.key,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetOperationTokenForGroupParams(
	public val groupId: String,
	public val operation: Operation,
	public val duration: Long?,
	public val description: String?,
)

@OptIn(InternalIcureApi::class)
public fun getOperationTokenForGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetOperationTokenForGroupParams>(params)
	runBlocking {
		sdk.group.getOperationTokenForGroup(
			decodedParams.groupId,
			decodedParams.operation,
			decodedParams.duration,
			decodedParams.description,
		)
	}
}.toPyString(String.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getOperationTokenForGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetOperationTokenForGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.getOperationTokenForGroup(
				decodedParams.groupId,
				decodedParams.operation,
				decodedParams.duration,
				decodedParams.description,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetGroupProjectIdParams(
	public val groupId: String,
	public val projectId: String?,
	public val applyToSubgroups: Boolean,
)

@OptIn(InternalIcureApi::class)
public fun setGroupProjectIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetGroupProjectIdParams>(params)
	runBlocking {
		sdk.group.setGroupProjectId(
			decodedParams.groupId,
			decodedParams.projectId,
			decodedParams.applyToSubgroups,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setGroupProjectIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetGroupProjectIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.setGroupProjectId(
				decodedParams.groupId,
				decodedParams.projectId,
				decodedParams.applyToSubgroups,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyGroupApplicationIdParams(
	public val id: String,
	public val applicationId: String,
)

@OptIn(InternalIcureApi::class)
public fun modifyGroupApplicationIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ModifyGroupApplicationIdParams>(params)
	runBlocking {
		sdk.group.modifyGroupApplicationId(
			decodedParams.id,
			decodedParams.applicationId,
		)
	}
}.toPyString(Group.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyGroupApplicationIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ModifyGroupApplicationIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.modifyGroupApplicationId(
				decodedParams.id,
				decodedParams.applicationId,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class AddTagToGroupParams(
	public val id: String,
	public val rev: String,
	public val tag: CodeStub,
)

@OptIn(InternalIcureApi::class)
public fun addTagToGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<AddTagToGroupParams>(params)
	runBlocking {
		sdk.group.addTagToGroup(
			decodedParams.id,
			decodedParams.rev,
			decodedParams.tag,
		)
	}
}.toPyString(Group.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun addTagToGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<AddTagToGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.addTagToGroup(
				decodedParams.id,
				decodedParams.rev,
				decodedParams.tag,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class RemoveTagFromGroupParams(
	public val id: String,
	public val rev: String,
	public val tagId: String,
)

@OptIn(InternalIcureApi::class)
public fun removeTagFromGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<RemoveTagFromGroupParams>(params)
	runBlocking {
		sdk.group.removeTagFromGroup(
			decodedParams.id,
			decodedParams.rev,
			decodedParams.tagId,
		)
	}
}.toPyString(Group.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun removeTagFromGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<RemoveTagFromGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.group.removeTagFromGroup(
				decodedParams.id,
				decodedParams.rev,
				decodedParams.tagId,
			)
		}.toPyStringAsyncCallback(Group.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

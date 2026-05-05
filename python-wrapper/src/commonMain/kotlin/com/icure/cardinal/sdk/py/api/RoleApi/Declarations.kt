// auto-generated file
package com.icure.cardinal.sdk.py.api.RoleApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.Role
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Byte
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Set
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
import kotlinx.serialization.builtins.serializer

public fun getPermissionsBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.role.getPermissions()
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getPermissionsAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.role.getPermissions()
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getAllRolesBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.role.getAllRoles()
	}
}.toPyString(ListSerializer(Role.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getAllRolesAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.role.getAllRoles()
		}.toPyStringAsyncCallback(ListSerializer(Role.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAllRolesInGroupParams(
	public val groupId: String,
)

@OptIn(InternalIcureApi::class)
public fun getAllRolesInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAllRolesInGroupParams>(params)
	runBlocking {
		sdk.role.getAllRolesInGroup(
			decodedParams.groupId,
		)
	}
}.toPyString(ListSerializer(Role.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAllRolesInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAllRolesInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.role.getAllRolesInGroup(
				decodedParams.groupId,
			)
		}.toPyStringAsyncCallback(ListSerializer(Role.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetRoleParams(
	public val roleId: String,
)

@OptIn(InternalIcureApi::class)
public fun getRoleBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRoleParams>(params)
	runBlocking {
		sdk.role.getRole(
			decodedParams.roleId,
		)
	}
}.toPyString(Role.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getRoleAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRoleParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.role.getRole(
				decodedParams.roleId,
			)
		}.toPyStringAsyncCallback(Role.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetRolesParams(
	public val rolesIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getRolesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRolesParams>(params)
	runBlocking {
		sdk.role.getRoles(
			decodedParams.rolesIds,
		)
	}
}.toPyString(ListSerializer(Role.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getRolesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRolesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.role.getRoles(
				decodedParams.rolesIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(Role.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateRoleParams(
	public val name: String,
	public val permissions: Set<String>,
	public val inheritsUpTo: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun createRoleBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRoleParams>(params)
	runBlocking {
		sdk.role.createRole(
			decodedParams.name,
			decodedParams.permissions,
			decodedParams.inheritsUpTo,
		)
	}
}.toPyString(Role.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createRoleAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRoleParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.role.createRole(
				decodedParams.name,
				decodedParams.permissions,
				decodedParams.inheritsUpTo,
			)
		}.toPyStringAsyncCallback(Role.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateRoleInGroupParams(
	public val groupId: String,
	public val name: String,
	public val permissions: Set<String>,
	public val inheritsUpTo: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun createRoleInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRoleInGroupParams>(params)
	runBlocking {
		sdk.role.createRoleInGroup(
			decodedParams.groupId,
			decodedParams.name,
			decodedParams.permissions,
			decodedParams.inheritsUpTo,
		)
	}
}.toPyString(Role.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createRoleInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateRoleInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.role.createRoleInGroup(
				decodedParams.groupId,
				decodedParams.name,
				decodedParams.permissions,
				decodedParams.inheritsUpTo,
			)
		}.toPyStringAsyncCallback(Role.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyRolePermissionsParams(
	public val roleId: String,
	public val permissions: Set<String>,
)

@OptIn(InternalIcureApi::class)
public fun modifyRolePermissionsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRolePermissionsParams>(params)
	runBlocking {
		sdk.role.modifyRolePermissions(
			decodedParams.roleId,
			decodedParams.permissions,
		)
	}
}.toPyString(Role.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyRolePermissionsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyRolePermissionsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.role.modifyRolePermissions(
				decodedParams.roleId,
				decodedParams.permissions,
			)
		}.toPyStringAsyncCallback(Role.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeRoleParams(
	public val roleId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun purgeRoleBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRoleParams>(params)
	runBlocking {
		sdk.role.purgeRole(
			decodedParams.roleId,
			decodedParams.rev,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeRoleAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeRoleParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.role.purgeRole(
				decodedParams.roleId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

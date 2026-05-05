// auto-generated file
package com.icure.cardinal.sdk.py.api.UserApi.inGroup

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.security.Enable2faRequest
import com.icure.cardinal.sdk.model.security.LoginIdentifier
import com.icure.cardinal.sdk.model.security.TokenWithGroup
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Byte
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
import kotlinx.serialization.builtins.serializer

@Serializable
private class CreateUserParams(
	public val user: GroupScoped<User>,
)

@OptIn(InternalIcureApi::class)
public fun createUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateUserParams>(params)
	runBlocking {
		sdk.user.inGroup.createUser(
			decodedParams.user,
		)
	}
}.toPyString(GroupScoped.serializer(User.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.createUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateUsersParams(
	public val users: List<GroupScoped<User>>,
)

@OptIn(InternalIcureApi::class)
public fun createUsersBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateUsersParams>(params)
	runBlocking {
		sdk.user.inGroup.createUsers(
			decodedParams.users,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(User.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createUsersAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateUsersParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.createUsers(
				decodedParams.users,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(User.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetUserParams(
	public val groupId: String,
	public val userId: String,
)

@OptIn(InternalIcureApi::class)
public fun getUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUserParams>(params)
	runBlocking {
		sdk.user.inGroup.getUser(
			decodedParams.groupId,
			decodedParams.userId,
		)
	}
}.toPyString(GroupScoped.serializer(User.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.getUser(
				decodedParams.groupId,
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetUsersParams(
	public val groupId: String,
	public val userIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getUsersBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUsersParams>(params)
	runBlocking {
		sdk.user.inGroup.getUsers(
			decodedParams.groupId,
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(User.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getUsersAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUsersParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.getUsers(
				decodedParams.groupId,
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(User.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyUserParams(
	public val user: GroupScoped<User>,
)

@OptIn(InternalIcureApi::class)
public fun modifyUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserParams>(params)
	runBlocking {
		sdk.user.inGroup.modifyUser(
			decodedParams.user,
		)
	}
}.toPyString(GroupScoped.serializer(User.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.modifyUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyUsersParams(
	public val users: List<GroupScoped<User>>,
)

@OptIn(InternalIcureApi::class)
public fun modifyUsersBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUsersParams>(params)
	runBlocking {
		sdk.user.inGroup.modifyUsers(
			decodedParams.users,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(User.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyUsersAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUsersParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.modifyUsers(
				decodedParams.users,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(User.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteUserByIdParams(
	public val userId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteUserByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUserByIdParams>(params)
	runBlocking {
		sdk.user.inGroup.deleteUserById(
			decodedParams.userId,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteUserByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUserByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.deleteUserById(
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteUsersByIdsParams(
	public val userIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteUsersByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUsersByIdsParams>(params)
	runBlocking {
		sdk.user.inGroup.deleteUsersByIds(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteUsersByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUsersByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.deleteUsersByIds(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteUserParams(
	public val user: GroupScoped<User>,
)

@OptIn(InternalIcureApi::class)
public fun deleteUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUserParams>(params)
	runBlocking {
		sdk.user.inGroup.deleteUser(
			decodedParams.user,
		)
	}
}.toPyString(GroupScoped.serializer(StoredDocumentIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.deleteUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(StoredDocumentIdentifier.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteUsersParams(
	public val users: List<GroupScoped<User>>,
)

@OptIn(InternalIcureApi::class)
public fun deleteUsersBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUsersParams>(params)
	runBlocking {
		sdk.user.inGroup.deleteUsers(
			decodedParams.users,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteUsersAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUsersParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.deleteUsers(
				decodedParams.users,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeUserByIdParams(
	public val userId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun purgeUserByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeUserByIdParams>(params)
	runBlocking {
		sdk.user.inGroup.purgeUserById(
			decodedParams.userId,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeUserByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeUserByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.purgeUserById(
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeUsersByIdsParams(
	public val userIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun purgeUsersByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeUsersByIdsParams>(params)
	runBlocking {
		sdk.user.inGroup.purgeUsersByIds(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeUsersByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeUsersByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.purgeUsersByIds(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeUserParams(
	public val user: GroupScoped<User>,
)

@OptIn(InternalIcureApi::class)
public fun purgeUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeUserParams>(params)
	runBlocking {
		sdk.user.inGroup.purgeUser(
			decodedParams.user,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.purgeUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeUsersParams(
	public val userIds: List<GroupScoped<User>>,
)

@OptIn(InternalIcureApi::class)
public fun purgeUsersBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeUsersParams>(params)
	runBlocking {
		sdk.user.inGroup.purgeUsers(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgeUsersAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeUsersParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.purgeUsers(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(StoredDocumentIdentifier.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteUserByIdParams(
	public val userId: GroupScoped<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteUserByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteUserByIdParams>(params)
	runBlocking {
		sdk.user.inGroup.undeleteUserById(
			decodedParams.userId,
		)
	}
}.toPyString(GroupScoped.serializer(User.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteUserByIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteUserByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.undeleteUserById(
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteUsersByIdsParams(
	public val userIds: List<GroupScoped<StoredDocumentIdentifier>>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteUsersByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteUsersByIdsParams>(params)
	runBlocking {
		sdk.user.inGroup.undeleteUsersByIds(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(User.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteUsersByIdsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteUsersByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.undeleteUsersByIds(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(User.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteUserParams(
	public val user: GroupScoped<User>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteUserParams>(params)
	runBlocking {
		sdk.user.inGroup.undeleteUser(
			decodedParams.user,
		)
	}
}.toPyString(GroupScoped.serializer(User.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.undeleteUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteUsersParams(
	public val users: List<GroupScoped<User>>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteUsersBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteUsersParams>(params)
	runBlocking {
		sdk.user.inGroup.undeleteUsers(
			decodedParams.users,
		)
	}
}.toPyString(ListSerializer(GroupScoped.serializer(User.serializer())))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteUsersAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteUsersParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.undeleteUsers(
				decodedParams.users,
			)
		}.toPyStringAsyncCallback(ListSerializer(GroupScoped.serializer(User.serializer())),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterUsersByParams(
	public val groupId: String,
	public val filter: BaseFilterOptions<User>,
)

@OptIn(InternalIcureApi::class)
public fun filterUsersByBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterUsersByParams>(params)
	runBlocking {
		sdk.user.inGroup.filterUsersBy(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, GroupScoped.serializer(User.serializer()))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterUsersByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterUsersByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.filterUsersBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, GroupScoped.serializer(User.serializer()))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class MatchUsersByParams(
	public val groupId: String,
	public val filter: BaseFilterOptions<User>,
)

@OptIn(InternalIcureApi::class)
public fun matchUsersByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchUsersByParams>(params)
	runBlocking {
		sdk.user.inGroup.matchUsersBy(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchUsersByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchUsersByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.matchUsersBy(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterUsersBySortedParams(
	public val groupId: String,
	public val filter: BaseSortableFilterOptions<User>,
)

@OptIn(InternalIcureApi::class)
public fun filterUsersBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterUsersBySortedParams>(params)
	runBlocking {
		sdk.user.inGroup.filterUsersBySorted(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, GroupScoped.serializer(User.serializer()))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterUsersBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterUsersBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.filterUsersBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, GroupScoped.serializer(User.serializer()))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class MatchUsersBySortedParams(
	public val groupId: String,
	public val filter: BaseSortableFilterOptions<User>,
)

@OptIn(InternalIcureApi::class)
public fun matchUsersBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchUsersBySortedParams>(params)
	runBlocking {
		sdk.user.inGroup.matchUsersBySorted(
			decodedParams.groupId,
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchUsersBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchUsersBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.matchUsersBySorted(
				decodedParams.groupId,
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetUserRolesParams(
	public val user: GroupScoped<User>,
	public val rolesIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun setUserRolesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetUserRolesParams>(params)
	runBlocking {
		sdk.user.inGroup.setUserRoles(
			decodedParams.user,
			decodedParams.rolesIds,
		)
	}
}.toPyString(GroupScoped.serializer(User.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setUserRolesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetUserRolesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.setUserRoles(
				decodedParams.user,
				decodedParams.rolesIds,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResetUserRolesParams(
	public val user: GroupScoped<User>,
)

@OptIn(InternalIcureApi::class)
public fun resetUserRolesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ResetUserRolesParams>(params)
	runBlocking {
		sdk.user.inGroup.resetUserRoles(
			decodedParams.user,
		)
	}
}.toPyString(GroupScoped.serializer(User.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun resetUserRolesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ResetUserRolesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.resetUserRoles(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTokenParams(
	public val userIdentifier: String,
	public val groupId: String,
	public val key: String,
	public val token: String? = null,
	public val tokenValidity: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun getTokenBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTokenParams>(params)
	runBlocking {
		sdk.user.inGroup.getToken(
			decodedParams.userIdentifier,
			decodedParams.groupId,
			decodedParams.key,
			decodedParams.token,
			decodedParams.tokenValidity,
		)
	}
}.toPyString(String.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getTokenAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTokenParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.getToken(
				decodedParams.userIdentifier,
				decodedParams.groupId,
				decodedParams.key,
				decodedParams.token,
				decodedParams.tokenValidity,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTokenInAllGroupsParams(
	public val userIdentifier: String,
	public val key: String,
	public val token: String? = null,
	public val tokenValidity: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun getTokenInAllGroupsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTokenInAllGroupsParams>(params)
	runBlocking {
		sdk.user.inGroup.getTokenInAllGroups(
			decodedParams.userIdentifier,
			decodedParams.key,
			decodedParams.token,
			decodedParams.tokenValidity,
		)
	}
}.toPyString(ListSerializer(TokenWithGroup.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getTokenInAllGroupsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTokenInAllGroupsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.getTokenInAllGroups(
				decodedParams.userIdentifier,
				decodedParams.key,
				decodedParams.token,
				decodedParams.tokenValidity,
			)
		}.toPyStringAsyncCallback(ListSerializer(TokenWithGroup.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class Enable2faForUserParams(
	public val user: GroupScoped<User>,
	public val request: Enable2faRequest,
)

@OptIn(InternalIcureApi::class)
public fun enable2faForUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<Enable2faForUserParams>(params)
	runBlocking {
		sdk.user.inGroup.enable2faForUser(
			decodedParams.user,
			decodedParams.request,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun enable2faForUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<Enable2faForUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.enable2faForUser(
				decodedParams.user,
				decodedParams.request,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class Disable2faForUserParams(
	public val user: GroupScoped<User>,
)

@OptIn(InternalIcureApi::class)
public fun disable2faForUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<Disable2faForUserParams>(params)
	runBlocking {
		sdk.user.inGroup.disable2faForUser(
			decodedParams.user,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun disable2faForUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<Disable2faForUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.disable2faForUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateAdminUserParams(
	public val user: GroupScoped<User>,
)

@OptIn(InternalIcureApi::class)
public fun createAdminUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateAdminUserParams>(params)
	runBlocking {
		sdk.user.inGroup.createAdminUser(
			decodedParams.user,
		)
	}
}.toPyString(GroupScoped.serializer(User.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createAdminUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateAdminUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.createAdminUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyUserPasswordParams(
	public val groupId: String,
	public val userId: String,
	public val newPassword: String,
)

@OptIn(InternalIcureApi::class)
public fun modifyUserPasswordBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserPasswordParams>(params)
	runBlocking {
		sdk.user.inGroup.modifyUserPassword(
			decodedParams.groupId,
			decodedParams.userId,
			decodedParams.newPassword,
		)
	}
}.toPyString(GroupScoped.serializer(User.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyUserPasswordAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserPasswordParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.modifyUserPassword(
				decodedParams.groupId,
				decodedParams.userId,
				decodedParams.newPassword,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyUserEmailParams(
	public val groupId: String,
	public val userId: String,
	public val newEmail: String,
	public val previousEmail: String?,
)

@OptIn(InternalIcureApi::class)
public fun modifyUserEmailBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserEmailParams>(params)
	runBlocking {
		sdk.user.inGroup.modifyUserEmail(
			decodedParams.groupId,
			decodedParams.userId,
			decodedParams.newEmail,
			decodedParams.previousEmail,
		)
	}
}.toPyString(GroupScoped.serializer(User.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyUserEmailAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserEmailParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.modifyUserEmail(
				decodedParams.groupId,
				decodedParams.userId,
				decodedParams.newEmail,
				decodedParams.previousEmail,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyUserMobilePhoneParams(
	public val groupId: String,
	public val userId: String,
	public val newMobilePhone: String,
	public val previousMobilePhone: String?,
)

@OptIn(InternalIcureApi::class)
public fun modifyUserMobilePhoneBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserMobilePhoneParams>(params)
	runBlocking {
		sdk.user.inGroup.modifyUserMobilePhone(
			decodedParams.groupId,
			decodedParams.userId,
			decodedParams.newMobilePhone,
			decodedParams.previousMobilePhone,
		)
	}
}.toPyString(GroupScoped.serializer(User.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyUserMobilePhoneAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserMobilePhoneParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.modifyUserMobilePhone(
				decodedParams.groupId,
				decodedParams.userId,
				decodedParams.newMobilePhone,
				decodedParams.previousMobilePhone,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetUserInheritsPermissionsParams(
	public val user: GroupScoped<User>,
	public val `value`: Boolean,
)

@OptIn(InternalIcureApi::class)
public fun setUserInheritsPermissionsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<SetUserInheritsPermissionsParams>(params)
	runBlocking {
		sdk.user.inGroup.setUserInheritsPermissions(
			decodedParams.user,
			decodedParams.value,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setUserInheritsPermissionsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<SetUserInheritsPermissionsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.setUserInheritsPermissions(
				decodedParams.user,
				decodedParams.value,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetLoginIdentifiersParams(
	public val user: GroupScoped<User>,
	public val identifier: LoginIdentifier,
	public val replaceExisting: Boolean,
)

@OptIn(InternalIcureApi::class)
public fun setLoginIdentifiersBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetLoginIdentifiersParams>(params)
	runBlocking {
		sdk.user.inGroup.setLoginIdentifiers(
			decodedParams.user,
			decodedParams.identifier,
			decodedParams.replaceExisting,
		)
	}
}.toPyString(Boolean.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setLoginIdentifiersAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetLoginIdentifiersParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.inGroup.setLoginIdentifiers(
				decodedParams.user,
				decodedParams.identifier,
				decodedParams.replaceExisting,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

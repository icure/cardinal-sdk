// auto-generated file
package com.icure.cardinal.sdk.py.api.UserApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.UserGroup
import com.icure.cardinal.sdk.model.security.Enable2faRequest
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.EntitySubscriptionWithSerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Byte
import kotlin.Long
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

public fun getCurrentUserBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.user.getCurrentUser()
	}
}.toPyString(User.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getCurrentUserAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.getCurrentUser()
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateUserParams(
	public val user: User,
)

@OptIn(InternalIcureApi::class)
public fun createUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateUserParams>(params)
	runBlocking {
		sdk.user.createUser(
			decodedParams.user,
		)
	}
}.toPyString(User.serializer())

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
			sdk.user.createUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateUsersParams(
	public val users: List<User>,
)

@OptIn(InternalIcureApi::class)
public fun createUsersBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateUsersParams>(params)
	runBlocking {
		sdk.user.createUsers(
			decodedParams.users,
		)
	}
}.toPyString(ListSerializer(User.serializer()))

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
			sdk.user.createUsers(
				decodedParams.users,
			)
		}.toPyStringAsyncCallback(ListSerializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetUserParams(
	public val userId: String,
)

@OptIn(InternalIcureApi::class)
public fun getUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUserParams>(params)
	runBlocking {
		sdk.user.getUser(
			decodedParams.userId,
		)
	}
}.toPyString(User.serializer())

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
			sdk.user.getUser(
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetUsersParams(
	public val userIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getUsersBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUsersParams>(params)
	runBlocking {
		sdk.user.getUsers(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(User.serializer()))

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
			sdk.user.getUsers(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyUserParams(
	public val user: User,
)

@OptIn(InternalIcureApi::class)
public fun modifyUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserParams>(params)
	runBlocking {
		sdk.user.modifyUser(
			decodedParams.user,
		)
	}
}.toPyString(User.serializer())

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
			sdk.user.modifyUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyUsersParams(
	public val users: List<User>,
)

@OptIn(InternalIcureApi::class)
public fun modifyUsersBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUsersParams>(params)
	runBlocking {
		sdk.user.modifyUsers(
			decodedParams.users,
		)
	}
}.toPyString(ListSerializer(User.serializer()))

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
			sdk.user.modifyUsers(
				decodedParams.users,
			)
		}.toPyStringAsyncCallback(ListSerializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetUserByEmailParams(
	public val email: String,
)

@OptIn(InternalIcureApi::class)
public fun getUserByEmailBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUserByEmailParams>(params)
	runBlocking {
		sdk.user.getUserByEmail(
			decodedParams.email,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getUserByEmailAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUserByEmailParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.getUserByEmail(
				decodedParams.email,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetUserByPhoneNumberParams(
	public val phoneNumber: String,
)

@OptIn(InternalIcureApi::class)
public fun getUserByPhoneNumberBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUserByPhoneNumberParams>(params)
	runBlocking {
		sdk.user.getUserByPhoneNumber(
			decodedParams.phoneNumber,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getUserByPhoneNumberAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetUserByPhoneNumberParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.getUserByPhoneNumber(
				decodedParams.phoneNumber,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindByHcpartyIdParams(
	public val id: String,
)

@OptIn(InternalIcureApi::class)
public fun findByHcpartyIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindByHcpartyIdParams>(params)
	runBlocking {
		sdk.user.findByHcpartyId(
			decodedParams.id,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findByHcpartyIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindByHcpartyIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.findByHcpartyId(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindByPatientIdParams(
	public val id: String,
)

@OptIn(InternalIcureApi::class)
public fun findByPatientIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindByPatientIdParams>(params)
	runBlocking {
		sdk.user.findByPatientId(
			decodedParams.id,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findByPatientIdAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindByPatientIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.findByPatientId(
				decodedParams.id,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class AssignHealthcarePartyParams(
	public val healthcarePartyId: String,
)

@OptIn(InternalIcureApi::class)
public fun assignHealthcarePartyBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<AssignHealthcarePartyParams>(params)
	runBlocking {
		sdk.user.assignHealthcareParty(
			decodedParams.healthcarePartyId,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun assignHealthcarePartyAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<AssignHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.assignHealthcareParty(
				decodedParams.healthcarePartyId,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyPropertiesParams(
	public val userId: String,
	public val properties: List<EncryptedPropertyStub>?,
)

@OptIn(InternalIcureApi::class)
public fun modifyPropertiesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPropertiesParams>(params)
	runBlocking {
		sdk.user.modifyProperties(
			decodedParams.userId,
			decodedParams.properties,
		)
	}
}.toPyString(User.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyPropertiesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPropertiesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.modifyProperties(
				decodedParams.userId,
				decodedParams.properties,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetTokenParams(
	public val userId: String,
	public val key: String,
	public val tokenValidity: Long? = null,
	public val token: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun getTokenBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetTokenParams>(params)
	runBlocking {
		sdk.user.getToken(
			decodedParams.userId,
			decodedParams.key,
			decodedParams.tokenValidity,
			decodedParams.token,
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
			sdk.user.getToken(
				decodedParams.userId,
				decodedParams.key,
				decodedParams.tokenValidity,
				decodedParams.token,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterUsersByParams(
	public val filter: BaseFilterOptions<User>,
)

@OptIn(InternalIcureApi::class)
public fun filterUsersByBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterUsersByParams>(params)
	runBlocking {
		sdk.user.filterUsersBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, User.serializer())}

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
			sdk.user.filterUsersBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, User.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class MatchUsersByParams(
	public val filter: BaseFilterOptions<User>,
)

@OptIn(InternalIcureApi::class)
public fun matchUsersByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchUsersByParams>(params)
	runBlocking {
		sdk.user.matchUsersBy(
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
			sdk.user.matchUsersBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterUsersBySortedParams(
	public val filter: BaseSortableFilterOptions<User>,
)

@OptIn(InternalIcureApi::class)
public fun filterUsersBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterUsersBySortedParams>(params)
	runBlocking {
		sdk.user.filterUsersBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, User.serializer())}

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
			sdk.user.filterUsersBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, User.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class MatchUsersBySortedParams(
	public val filter: BaseSortableFilterOptions<User>,
)

@OptIn(InternalIcureApi::class)
public fun matchUsersBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchUsersBySortedParams>(params)
	runBlocking {
		sdk.user.matchUsersBySorted(
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
			sdk.user.matchUsersBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getMatchingUsersBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.user.getMatchingUsers()
	}
}.toPyString(ListSerializer(UserGroup.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getMatchingUsersAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.getMatchingUsers()
		}.toPyStringAsyncCallback(ListSerializer(UserGroup.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetUserRolesParams(
	public val userId: String,
	public val rolesIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun setUserRolesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetUserRolesParams>(params)
	runBlocking {
		sdk.user.setUserRoles(
			decodedParams.userId,
			decodedParams.rolesIds,
		)
	}
}.toPyString(User.serializer())

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
			sdk.user.setUserRoles(
				decodedParams.userId,
				decodedParams.rolesIds,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ResetUserRolesParams(
	public val userId: String,
)

@OptIn(InternalIcureApi::class)
public fun resetUserRolesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ResetUserRolesParams>(params)
	runBlocking {
		sdk.user.resetUserRoles(
			decodedParams.userId,
		)
	}
}.toPyString(User.serializer())

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
			sdk.user.resetUserRoles(
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class Enable2faForUserParams(
	public val userId: String,
	public val request: Enable2faRequest,
)

@OptIn(InternalIcureApi::class)
public fun enable2faForUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<Enable2faForUserParams>(params)
	runBlocking {
		sdk.user.enable2faForUser(
			decodedParams.userId,
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
			sdk.user.enable2faForUser(
				decodedParams.userId,
				decodedParams.request,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class Disable2faForUserParams(
	public val userId: String,
)

@OptIn(InternalIcureApi::class)
public fun disable2faForUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<Disable2faForUserParams>(params)
	runBlocking {
		sdk.user.disable2faForUser(
			decodedParams.userId,
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
			sdk.user.disable2faForUser(
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateAdminUserParams(
	public val user: User,
)

@OptIn(InternalIcureApi::class)
public fun createAdminUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateAdminUserParams>(params)
	runBlocking {
		sdk.user.createAdminUser(
			decodedParams.user,
		)
	}
}.toPyString(User.serializer())

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
			sdk.user.createAdminUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyUserPasswordParams(
	public val userId: String,
	public val newPassword: String,
)

@OptIn(InternalIcureApi::class)
public fun modifyUserPasswordBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserPasswordParams>(params)
	runBlocking {
		sdk.user.modifyUserPassword(
			decodedParams.userId,
			decodedParams.newPassword,
		)
	}
}.toPyString(User.serializer())

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
			sdk.user.modifyUserPassword(
				decodedParams.userId,
				decodedParams.newPassword,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyUserEmailParams(
	public val userId: String,
	public val newEmail: String,
	public val previousEmail: String?,
)

@OptIn(InternalIcureApi::class)
public fun modifyUserEmailBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserEmailParams>(params)
	runBlocking {
		sdk.user.modifyUserEmail(
			decodedParams.userId,
			decodedParams.newEmail,
			decodedParams.previousEmail,
		)
	}
}.toPyString(User.serializer())

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
			sdk.user.modifyUserEmail(
				decodedParams.userId,
				decodedParams.newEmail,
				decodedParams.previousEmail,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyUserMobilePhoneParams(
	public val userId: String,
	public val newMobilePhone: String,
	public val previousMobilePhone: String?,
)

@OptIn(InternalIcureApi::class)
public fun modifyUserMobilePhoneBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyUserMobilePhoneParams>(params)
	runBlocking {
		sdk.user.modifyUserMobilePhone(
			decodedParams.userId,
			decodedParams.newMobilePhone,
			decodedParams.previousMobilePhone,
		)
	}
}.toPyString(User.serializer())

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
			sdk.user.modifyUserMobilePhone(
				decodedParams.userId,
				decodedParams.newMobilePhone,
				decodedParams.previousMobilePhone,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteUserByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteUserByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUserByIdParams>(params)
	runBlocking {
		sdk.user.deleteUserById(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(StoredDocumentIdentifier.serializer())

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
			sdk.user.deleteUserById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(StoredDocumentIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteUsersByIdsParams(
	public val userIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun deleteUsersByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUsersByIdsParams>(params)
	runBlocking {
		sdk.user.deleteUsersByIds(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

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
			sdk.user.deleteUsersByIds(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeUserByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun purgeUserByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeUserByIdParams>(params)
	runBlocking {
		sdk.user.purgeUserById(
			decodedParams.id,
			decodedParams.rev,
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
			sdk.user.purgeUserById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeUsersByIdsParams(
	public val userIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun purgeUsersByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeUsersByIdsParams>(params)
	runBlocking {
		sdk.user.purgeUsersByIds(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

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
			sdk.user.purgeUsersByIds(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteUserByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteUserByIdBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteUserByIdParams>(params)
	runBlocking {
		sdk.user.undeleteUserById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(User.serializer())

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
			sdk.user.undeleteUserById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteUsersByIdsParams(
	public val userIds: List<StoredDocumentIdentifier>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteUsersByIdsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteUsersByIdsParams>(params)
	runBlocking {
		sdk.user.undeleteUsersByIds(
			decodedParams.userIds,
		)
	}
}.toPyString(ListSerializer(User.serializer()))

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
			sdk.user.undeleteUsersByIds(
				decodedParams.userIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteUserParams(
	public val user: User,
)

@OptIn(InternalIcureApi::class)
public fun deleteUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUserParams>(params)
	runBlocking {
		sdk.user.deleteUser(
			decodedParams.user,
		)
	}
}.toPyString(StoredDocumentIdentifier.serializer())

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
			sdk.user.deleteUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(StoredDocumentIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteUsersParams(
	public val users: List<User>,
)

@OptIn(InternalIcureApi::class)
public fun deleteUsersBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteUsersParams>(params)
	runBlocking {
		sdk.user.deleteUsers(
			decodedParams.users,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

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
			sdk.user.deleteUsers(
				decodedParams.users,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeUserParams(
	public val user: User,
)

@OptIn(InternalIcureApi::class)
public fun purgeUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeUserParams>(params)
	runBlocking {
		sdk.user.purgeUser(
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
			sdk.user.purgeUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgeUsersParams(
	public val users: List<User>,
)

@OptIn(InternalIcureApi::class)
public fun purgeUsersBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgeUsersParams>(params)
	runBlocking {
		sdk.user.purgeUsers(
			decodedParams.users,
		)
	}
}.toPyString(ListSerializer(StoredDocumentIdentifier.serializer()))

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
			sdk.user.purgeUsers(
				decodedParams.users,
			)
		}.toPyStringAsyncCallback(ListSerializer(StoredDocumentIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteUserParams(
	public val user: User,
)

@OptIn(InternalIcureApi::class)
public fun undeleteUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteUserParams>(params)
	runBlocking {
		sdk.user.undeleteUser(
			decodedParams.user,
		)
	}
}.toPyString(User.serializer())

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
			sdk.user.undeleteUser(
				decodedParams.user,
			)
		}.toPyStringAsyncCallback(User.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteUsersParams(
	public val users: List<User>,
)

@OptIn(InternalIcureApi::class)
public fun undeleteUsersBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteUsersParams>(params)
	runBlocking {
		sdk.user.undeleteUsers(
			decodedParams.users,
		)
	}
}.toPyString(ListSerializer(User.serializer()))

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
			sdk.user.undeleteUsers(
				decodedParams.users,
			)
		}.toPyStringAsyncCallback(ListSerializer(User.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetExternalJwtAuthByIdentifiersForCurrentUserParams(
	public val externalJwtConfigId: String,
	public val externalAuthenticationToken: String,
)

@OptIn(InternalIcureApi::class)
public fun setExternalJwtAuthByIdentifiersForCurrentUserBlocking(sdk: CardinalNonCryptoApis,
		params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<SetExternalJwtAuthByIdentifiersForCurrentUserParams>(params)
	runBlocking {
		sdk.user.setExternalJwtAuthByIdentifiersForCurrentUser(
			decodedParams.externalJwtConfigId,
			decodedParams.externalAuthenticationToken,
		)
	}
}.toPyString(Boolean.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setExternalJwtAuthByIdentifiersForCurrentUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<SetExternalJwtAuthByIdentifiersForCurrentUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.setExternalJwtAuthByIdentifiersForCurrentUser(
				decodedParams.externalJwtConfigId,
				decodedParams.externalAuthenticationToken,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	public val filter: FilterOptions<User>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

@OptIn(InternalIcureApi::class)
public fun subscribeToEventsBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SubscribeToEventsParams>(params)
	runBlocking {
		sdk.user.subscribeToEvents(
			decodedParams.events,
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, User.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun subscribeToEventsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SubscribeToEventsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.user.subscribeToEvents(
				decodedParams.events,
				decodedParams.filter,
				decodedParams.subscriptionConfig,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			EntitySubscriptionWithSerializer(it, User.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

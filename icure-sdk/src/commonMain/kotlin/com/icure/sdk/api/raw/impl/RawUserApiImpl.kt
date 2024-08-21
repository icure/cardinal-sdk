package com.icure.sdk.api.raw.`impl`

import com.icure.sdk.api.raw.BaseRawApi
import com.icure.sdk.api.raw.HttpResponse
import com.icure.sdk.api.raw.RawUserApi
import com.icure.sdk.api.raw.wrap
import com.icure.sdk.auth.services.AuthProvider
import com.icure.sdk.model.EncryptedPropertyStub
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.User
import com.icure.sdk.model.UserGroup
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.security.Enable2faRequest
import com.icure.sdk.model.security.TokenWithGroup
import com.icure.sdk.serialization.FilterChainSerializer
import com.icure.sdk.serialization.UserAbstractFilterSerializer
import com.icure.sdk.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.`header`
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlinx.serialization.json.Json
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.time.Duration

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawUserApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	httpClient: HttpClient,
	additionalHeaders: Map<String, String> = emptyMap(),
	timeout: Duration? = null,
	json: Json,
) : BaseRawApi(httpClient, additionalHeaders, timeout, json), RawUserApi {
	// region common endpoints

	override suspend fun getCurrentUser(): HttpResponse<User> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "current")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listUsersBy(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		skipPatients: Boolean?,
	): HttpResponse<PaginatedList<User>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user")
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("skipPatients", skipPatients)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createUser(userDto: User): HttpResponse<User> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(userDto)
		}.wrap()

	override suspend fun getUser(userId: String): HttpResponse<User> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getUsers(userIds: ListOfIds): HttpResponse<List<User>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "byIds")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getUserByEmail(email: String): HttpResponse<User> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "byEmail", email)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getUserByPhoneNumber(phoneNumber: String): HttpResponse<User> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "byPhoneNumber", phoneNumber)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findByHcpartyId(id: String): HttpResponse<List<String>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "byHealthcarePartyId", id)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun findByPatientId(id: String): HttpResponse<List<String>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "byPatientId", id)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun deleteUser(userId: String): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyUser(userDto: User): HttpResponse<User> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(userDto)
		}.wrap()

	override suspend fun assignHealthcareParty(healthcarePartyId: String): HttpResponse<User> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "current", "hcparty", healthcarePartyId)
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun modifyProperties(
		userId: String,
		properties: List<EncryptedPropertyStub>?,
	): HttpResponse<User> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "properties")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(properties)
		}.wrap()

	override suspend fun getToken(
		userId: String,
		key: String,
		tokenValidity: Long?,
		token: String?,
	): HttpResponse<String> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "token", userId, key)
				parameter("tokenValidity", tokenValidity)
			}
			contentType(Application.Json)
			accept(Application.Json)
			`header`("token", token)
		}.wrap()

	override suspend fun filterUsersBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<User>,
	): HttpResponse<PaginatedList<User>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "filter")
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(FilterChainSerializer(UserAbstractFilterSerializer), filterChain)
		}.wrap()

	override suspend fun matchUsersBy(filter: AbstractFilter<User>): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(UserAbstractFilterSerializer, filter)
		}.wrap()

	// endregion

	// region cloud endpoints

	override suspend fun getMatchingUsers(): HttpResponse<List<UserGroup>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "matches")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listUsersInGroup(
		groupId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	): HttpResponse<PaginatedList<User>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "inGroup", groupId)
				parameter("startKey", startKey)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun listUsersInAllGroups(
		username: String?,
		email: String?,
		phone: String?,
	): HttpResponse<List<User>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "inAllGroups")
				parameter("username", username)
				parameter("email", email)
				parameter("phone", phone)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createUserInGroup(
		groupId: String,
		userDto: User,
	): HttpResponse<User> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(userDto)
		}.wrap()

	override suspend fun modifyUserInGroup(
		groupId: String,
		userDto: User,
	): HttpResponse<User> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(userDto)
		}.wrap()

	override suspend fun deleteUserInGroup(
		groupId: String,
		userId: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "inGroup", groupId, userId)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun addRolesToUser(
		userId: String,
		rolesId: ListOfIds,
	): HttpResponse<User> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "roles", "set")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(rolesId)
		}.wrap()

	override suspend fun addRolesToUserInGroup(
		userId: String,
		groupId: String,
		rolesId: ListOfIds,
	): HttpResponse<User> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "inGroup", groupId, "roles", "set")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(rolesId)
		}.wrap()

	override suspend fun removeRolesFromUser(userId: String): HttpResponse<User> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "roles", "reset")
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun removeRolesFromUserInGroup(
		userId: String,
		groupId: String,
	): HttpResponse<User> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "inGroup", groupId, "roles", "reset")
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun getTokenInGroup(
		groupId: String,
		userId: String,
		key: String,
		token: String?,
		tokenValidity: Long?,
	): HttpResponse<String> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "inGroup", groupId, "token", userId, key)
				parameter("tokenValidity", tokenValidity)
			}
			contentType(Application.Json)
			accept(Application.Json)
			`header`("token", token)
		}.wrap()

	override suspend fun getTokenInAllGroups(
		userIdentifier: String,
		key: String,
		token: String?,
		tokenValidity: Long?,
	): HttpResponse<List<TokenWithGroup>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "inAllGroups", "token", userIdentifier, key)
				parameter("tokenValidity", tokenValidity)
			}
			contentType(Application.Json)
			accept(Application.Json)
			`header`("token", token)
		}.wrap()

	override suspend fun filterUsersInGroupBy(
		groupId: String,
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<User>,
	): HttpResponse<PaginatedList<User>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "filter", "inGroup", groupId)
				parameter("startDocumentId", startDocumentId)
				parameter("limit", limit)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(FilterChainSerializer(UserAbstractFilterSerializer), filterChain)
		}.wrap()

	override suspend fun getUsersInGroup(
		groupId: String,
		userIds: ListOfIds,
	): HttpResponse<List<User>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "inGroup", groupId, "byIds")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun matchUsersInGroupBy(
		groupId: String,
		filter: AbstractFilter<User>,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "match", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(UserAbstractFilterSerializer, filter)
		}.wrap()

	override suspend fun enable2faForUser(
		userId: String,
		groupId: String,
		request: Enable2faRequest,
	): HttpResponse<Unit> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "inGroup", groupId, "2fa")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun disable2faForUser(
		userId: String,
		groupId: String,
	): HttpResponse<Unit> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "inGroup", groupId, "2fa")
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun enable2faForUser(
		userId: String,
		request: Enable2faRequest,
	): HttpResponse<Unit> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "2fa")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(request)
		}.wrap()

	override suspend fun disable2faForUser(userId: String): HttpResponse<Unit> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", userId, "2fa")
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun createAdminUser(userDto: User): HttpResponse<User> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "admin")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(userDto)
		}.wrap()

	override suspend fun createAdminUserInGroup(
		groupId: String,
		userDto: User,
	): HttpResponse<User> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "admin", "inGroup", groupId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(userDto)
		}.wrap()

	override suspend fun matchUsersBy(
		groupId: String,
		filter: AbstractFilter<User>,
	): HttpResponse<List<String>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "user", "inGroup", groupId, "match")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBodyWithSerializer(UserAbstractFilterSerializer, filter)
		}.wrap()

	// endregion
}

package com.icure.cardinal.sdk.api.raw.`impl`

import com.icure.cardinal.sdk.api.raw.BaseRawApi
import com.icure.cardinal.sdk.api.raw.HttpResponse
import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.RawRoleApi
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.Role
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.utils.InternalIcureApi
import io.ktor.client.request.accept
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import io.ktor.http.ContentType.Application
import io.ktor.http.appendPathSegments
import io.ktor.http.contentType
import io.ktor.http.takeFrom
import io.ktor.util.date.GMTDate
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
class RawRoleApiImpl(
	internal val apiUrl: String,
	private val authProvider: AuthProvider,
	rawApiConfig: RawApiConfig,
) : BaseRawApi(rawApiConfig), RawRoleApi {
	// region cloud endpoints

	override suspend fun getRoles(): HttpResponse<List<Role>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "role")
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getRolesInGroup(groupId: String): HttpResponse<List<Role>> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "role", "inGroup", groupId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getRole(roleId: String): HttpResponse<Role> =
		get(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "role", roleId)
				parameter("ts", GMTDate().timestamp)
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun getRolesByIds(roleIds: ListOfIds): HttpResponse<List<Role>> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "role", "byIds")
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(roleIds)
		}.wrap()

	override suspend fun createRole(
		name: String,
		inheritsUpTo: Int?,
		permissions: Set<String>,
	): HttpResponse<Role> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "role", name)
				parameter("inheritsUpTo", inheritsUpTo)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(permissions)
		}.wrap()

	override suspend fun createRoleInGroup(
		name: String,
		groupId: String,
		inheritsUpTo: Int?,
		permissions: Set<String>,
	): HttpResponse<Role> =
		post(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "role", name, "inGroup", groupId)
				parameter("inheritsUpTo", inheritsUpTo)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(permissions)
		}.wrap()

	override suspend fun modifyRolePermissions(
		roleId: String,
		permissions: Set<String>,
	): HttpResponse<Role> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "role", roleId)
			}
			contentType(Application.Json)
			accept(Application.Json)
			setBody(permissions)
		}.wrap()

	override suspend fun modifyRoleVisibility(
		roleId: String,
		inheritsUpTo: Int,
	): HttpResponse<Role> =
		put(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "role", roleId, "inheritsUpTo", "$inheritsUpTo")
			}
			contentType(Application.Json)
			accept(Application.Json)
		}.wrap()

	override suspend fun resetRoleVisibility(roleId: String): HttpResponse<Role> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "role", roleId, "inheritsUpTo")
			}
			accept(Application.Json)
		}.wrap()

	override suspend fun purgeRole(
		roleId: String,
		rev: String,
	): HttpResponse<DocIdentifier> =
		delete(authProvider) {
			url {
				takeFrom(apiUrl)
				appendPathSegments("rest", "v2", "role", roleId)
				parameter("rev", rev)
			}
			accept(Application.Json)
		}.wrap()

	// endregion
}

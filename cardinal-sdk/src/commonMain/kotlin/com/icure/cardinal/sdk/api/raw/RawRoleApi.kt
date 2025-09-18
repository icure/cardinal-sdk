package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.Role
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawRoleApi {
	// region cloud endpoints

	suspend fun getRoles(): HttpResponse<List<Role>>

	suspend fun getRolesInGroup(groupId: String): HttpResponse<List<Role>>

	suspend fun getRole(roleId: String): HttpResponse<Role>

	suspend fun getRolesByIds(roleIds: ListOfIds): HttpResponse<List<Role>>

	suspend fun createRole(
		name: String,
		inheritsUpTo: Int? = null,
		permissions: Set<String>,
	): HttpResponse<Role>

	suspend fun createRoleInGroup(
		name: String,
		groupId: String,
		inheritsUpTo: Int? = null,
		permissions: Set<String>,
	): HttpResponse<Role>

	suspend fun modifyRolePermissions(
		roleId: String,
		permissions: Set<String>,
	): HttpResponse<Role>

	suspend fun modifyRoleVisibility(
		roleId: String,
		inheritsUpTo: Int,
	): HttpResponse<Role>

	suspend fun resetRoleVisibility(roleId: String): HttpResponse<Role>

	suspend fun purgeRole(
		roleId: String,
		rev: String,
	): HttpResponse<DocIdentifier>
	// endregion
}

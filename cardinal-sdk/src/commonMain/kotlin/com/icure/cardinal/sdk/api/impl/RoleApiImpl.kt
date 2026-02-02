package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.RoleApi
import com.icure.cardinal.sdk.api.raw.RawRoleApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.Role
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class RoleApiImpl(
	private val rawApi: RawRoleApi,
) : RoleApi {
	override suspend fun getAllRoles() = rawApi.getRoles().successBody()

	override suspend fun getAllRolesInGroup(groupId: String): List<Role> = rawApi.getRolesInGroup(groupId).successBody()

	override suspend fun getRole(roleId: String): Role? = rawApi.getRole(roleId).successBodyOrNull404()

	override suspend fun getRoles(rolesIds: List<String>): List<Role> = rawApi.getRolesByIds(ListOfIds(rolesIds)).successBody()

	override suspend fun createRole(
		name: String,
		permissions: Set<String>,
		inheritsUpTo: Int?,
	): Role = rawApi.createRole(name, inheritsUpTo, permissions).successBody()

	override suspend fun createRoleInGroup(
		groupId: String,
		name: String,
		permissions: Set<String>,
		inheritsUpTo: Int?,
	): Role = rawApi.createRoleInGroup(name, groupId, inheritsUpTo, permissions).successBody()

	override suspend fun modifyRolePermissions(
		roleId: String,
		permissions: Set<String>,
	): Role = rawApi.modifyRolePermissions(roleId, permissions).successBodyOrThrowRevisionConflict()

	override suspend fun purgeRole(roleId: String, rev: String) {
		rawApi.purgeRole(roleId, rev).successBodyOrThrowRevisionConflict()
	}
}

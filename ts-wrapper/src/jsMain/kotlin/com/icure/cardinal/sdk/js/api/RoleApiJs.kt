// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.RoleJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("RoleApi")
public external interface RoleApiJs {
	public fun getAllRoles(): Promise<Array<RoleJs>>

	public fun getAllRolesInGroup(groupId: String): Promise<Array<RoleJs>>

	public fun getRole(roleId: String): Promise<RoleJs?>

	public fun getRoles(rolesIds: Array<String>): Promise<Array<RoleJs>>

	public fun createRole(
		name: String,
		permissions: Array<String>,
		options: dynamic,
	): Promise<RoleJs>

	public fun createRoleInGroup(
		groupId: String,
		name: String,
		permissions: Array<String>,
		options: dynamic,
	): Promise<RoleJs>

	public fun modifyRolePermissions(roleId: String, permissions: Array<String>): Promise<RoleJs>

	public fun purgeRole(roleId: String, rev: String): Promise<Unit>
}

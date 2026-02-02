package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.Role
import com.icure.cardinal.sdk.utils.DefaultValue

interface RoleApi {
	/**
	 * Retrieves all roles accessible in the current group, including the one that can be inherited from the parent groups.ù
	 * @return the available roles.
	 */
	suspend fun getAllRoles(): List<Role>

	/**
	 * Retrieves all roles accessible in a specific group, including the one that can be inherited from its parent groups.
	 * @param groupId the id of the group.
	 * @return the accessible roles.
	 */
	suspend fun getAllRolesInGroup(groupId: String): List<Role>

	/**
	 * Retrieve a role by its [Role.id].
	 * @param roleId the id of the role.
	 * @return the role or null if no such role exists.
	 */
	suspend fun getRole(roleId: String): Role?

	/**
	 * Retrieves a batch of roles by their [Role.id]. If an id does not correspond to any role or the role is not accessible to the user
	 * making the request, then it will be ignored.
	 * @param rolesIds the ids of the roles to retrieve.
	 * @return the retrieved roles.
	 */
	suspend fun getRoles(rolesIds: List<String>): List<Role>

	/**
	 * Creates a new role.
	 * @param name the [Role.name].
	 * @param permissions the set of permissions that this role will grant.
	 * @param inheritsUpTo the maximum level in the downward group hierarchy where this role can be accessed (null = any child group at
	 * any level, 0 = only the current group can access this role, 1 = only this group and children groups can access this role, etc...)
	 * @return the created role.
	 */
	suspend fun createRole(
		name: String,
		permissions: Set<String>,
		@DefaultValue("null")
		inheritsUpTo: Int? = null
	): Role

	/**
	 * Creates a new role in a specific group.
	 * @param groupId the id of the group.
	 * @param name the [Role.name].
	 * @param permissions the set of permissions that this role will grant.
	 * @param inheritsUpTo the maximum level in the downward group hierarchy where this role can be accessed (null = any child group at
	 * any level, 0 = only the current group can access this role, 1 = only this group and children groups can access this role, etc...)
	 * @return the created role.
	 */
	suspend fun createRoleInGroup(
		groupId: String,
		name: String,
		permissions: Set<String>,
		@DefaultValue("null")
		inheritsUpTo: Int? = null
	): Role

	/**
	 * Sets new permission for an existing role.
	 * @param roleId the [Role.id].
	 * @param permissions the new permissions to set.
	 * @return the updated role.
	 */
	suspend fun modifyRolePermissions(roleId: String, permissions: Set<String>): Role

	/**
	 * Permanently deletes a role.
	 * @param roleId the [Role.id].
	 * @param rev the most updated revision for the role.
	 */
	suspend fun purgeRole(roleId: String, rev: String)
}

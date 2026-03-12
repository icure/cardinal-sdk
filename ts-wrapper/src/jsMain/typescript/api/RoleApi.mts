// auto-generated file
import {Role} from '../model/Role.mjs';


export interface RoleApi {

	/**
	 *
	 *  @return a list containing all the permissions that can be used in roles.
	 */
	getPermissions(): Promise<Array<string>>;

	/**
	 *
	 *  Retrieves all roles accessible in the current group, including the one that can be inherited from the parent groups.ù
	 *  @return the available roles.
	 */
	getAllRoles(): Promise<Array<Role>>;

	/**
	 *
	 *  Retrieves all roles accessible in a specific group, including the one that can be inherited from its parent groups.
	 *  @param groupId the id of the group.
	 *  @return the accessible roles.
	 */
	getAllRolesInGroup(groupId: string): Promise<Array<Role>>;

	/**
	 *
	 *  Retrieve a role by its [Role.id].
	 *  @param roleId the id of the role.
	 *  @return the role or null if no such role exists.
	 */
	getRole(roleId: string): Promise<Role | undefined>;

	/**
	 *
	 *  Retrieves a batch of roles by their [Role.id]. If an id does not correspond to any role or the role is not accessible to the user
	 *  making the request, then it will be ignored.
	 *  @param rolesIds the ids of the roles to retrieve.
	 *  @return the retrieved roles.
	 */
	getRoles(rolesIds: Array<string>): Promise<Array<Role>>;

	/**
	 *
	 *  Creates a new role.
	 *  @param name the [Role.name].
	 *  @param permissions the set of permissions that this role will grant.
	 *  @param inheritsUpTo the maximum level in the downward group hierarchy where this role can be accessed (null = any child group at
	 *  any level, 0 = only the current group can access this role, 1 = only this group and children groups can access this role, etc...)
	 *  @return the created role.
	 */
	createRole(name: string, permissions: Array<string>,
			options?: { inheritsUpTo?: number | undefined }): Promise<Role>;

	/**
	 *
	 *  Creates a new role in a specific group.
	 *  @param groupId the id of the group.
	 *  @param name the [Role.name].
	 *  @param permissions the set of permissions that this role will grant.
	 *  @param inheritsUpTo the maximum level in the downward group hierarchy where this role can be accessed (null = any child group at
	 *  any level, 0 = only the current group can access this role, 1 = only this group and children groups can access this role, etc...)
	 *  @return the created role.
	 */
	createRoleInGroup(groupId: string, name: string, permissions: Array<string>,
			options?: { inheritsUpTo?: number | undefined }): Promise<Role>;

	/**
	 *
	 *  Sets new permission for an existing role.
	 *  @param roleId the [Role.id].
	 *  @param permissions the new permissions to set.
	 *  @return the updated role.
	 */
	modifyRolePermissions(roleId: string, permissions: Array<string>): Promise<Role>;

	/**
	 *
	 *  Permanently deletes a role.
	 *  @param roleId the [Role.id].
	 *  @param rev the most updated revision for the role.
	 */
	purgeRole(roleId: string, rev: string): Promise<void>;

}

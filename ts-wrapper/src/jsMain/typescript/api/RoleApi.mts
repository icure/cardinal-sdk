// auto-generated file
import {Role} from '../model/Role.mjs';


export interface RoleApi {

	getAllRoles(): Promise<Array<Role>>;

	getAllRolesInGroup(groupId: string): Promise<Array<Role>>;

	getRole(roleId: string): Promise<Role | undefined>;

	getRoles(rolesIds: Array<string>): Promise<Array<Role>>;

	createRole(name: string, permissions: Array<string>,
			options?: { inheritsUpTo?: number | undefined }): Promise<Role>;

	createRoleInGroup(groupId: string, name: string, permissions: Array<string>,
			options?: { inheritsUpTo?: number | undefined }): Promise<Role>;

	modifyRolePermissions(roleId: string, permissions: Array<string>): Promise<Role>;

	purgeRole(roleId: string, rev: string): Promise<void>;

}

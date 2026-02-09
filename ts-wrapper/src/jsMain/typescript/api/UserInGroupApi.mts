// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {Enable2faRequest} from '../model/security/Enable2faRequest.mjs';
import {LoginIdentifier} from '../model/security/LoginIdentifier.mjs';
import {TokenWithGroup} from '../model/security/TokenWithGroup.mjs';


export interface UserInGroupApi {

	createUser(user: GroupScoped<User>): Promise<GroupScoped<User>>;

	createUsers(users: Array<GroupScoped<User>>): Promise<Array<GroupScoped<User>>>;

	getUser(groupId: string, userId: string): Promise<GroupScoped<User> | undefined>;

	getUsers(groupId: string, userIds: Array<string>): Promise<Array<GroupScoped<User>>>;

	modifyUser(user: GroupScoped<User>): Promise<GroupScoped<User>>;

	modifyUsers(users: Array<GroupScoped<User>>): Promise<Array<GroupScoped<User>>>;

	deleteUserById(userId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteUsersByIds(userIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteUser(user: GroupScoped<User>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteUsers(users: Array<GroupScoped<User>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeUserById(userId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeUsersByIds(userIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeUser(user: GroupScoped<User>): Promise<void>;

	purgeUsers(userIds: Array<GroupScoped<User>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	undeleteUserById(userId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<User>>;

	undeleteUsersByIds(userIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<User>>>;

	undeleteUser(user: GroupScoped<User>): Promise<GroupScoped<User>>;

	undeleteUsers(users: Array<GroupScoped<User>>): Promise<Array<GroupScoped<User>>>;

	filterUsersBy(groupId: string,
			filter: BaseFilterOptions<User>): Promise<PaginatedListIterator<GroupScoped<User>>>;

	matchUsersBy(groupId: string, filter: BaseFilterOptions<User>): Promise<Array<string>>;

	filterUsersBySorted(groupId: string,
			filter: BaseSortableFilterOptions<User>): Promise<PaginatedListIterator<GroupScoped<User>>>;

	matchUsersBySorted(groupId: string,
			filter: BaseSortableFilterOptions<User>): Promise<Array<string>>;

	setUserRoles(user: GroupScoped<User>, rolesIds: Array<string>): Promise<GroupScoped<User>>;

	resetUserRoles(user: GroupScoped<User>): Promise<GroupScoped<User>>;

	getToken(userIdentifier: string, groupId: string, key: string,
			options?: { token?: string | undefined, tokenValidity?: number | undefined }): Promise<string>;

	getTokenInAllGroups(userIdentifier: string, key: string,
			options?: { token?: string | undefined, tokenValidity?: number | undefined }): Promise<Array<TokenWithGroup>>;

	enable2faForUser(user: GroupScoped<User>, request: Enable2faRequest): Promise<void>;

	disable2faForUser(user: GroupScoped<User>): Promise<void>;

	createAdminUser(user: GroupScoped<User>): Promise<GroupScoped<User>>;

	setUserInheritsPermissions(user: GroupScoped<User>, value: boolean): Promise<void>;

	setLoginIdentifiers(user: GroupScoped<User>, identifier: LoginIdentifier,
			replaceExisting: boolean): Promise<boolean>;

}

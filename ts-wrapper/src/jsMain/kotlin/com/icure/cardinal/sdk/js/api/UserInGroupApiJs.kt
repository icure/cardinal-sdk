// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.security.Enable2faRequestJs
import com.icure.cardinal.sdk.js.model.security.LoginIdentifierJs
import com.icure.cardinal.sdk.js.model.security.TokenWithGroupJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("UserInGroupApi")
public external interface UserInGroupApiJs {
	public fun createUser(user: GroupScopedJs<UserJs>): Promise<GroupScopedJs<UserJs>>

	public fun createUsers(users: Array<GroupScopedJs<UserJs>>): Promise<Array<GroupScopedJs<UserJs>>>

	public fun getUser(groupId: String, userId: String): Promise<GroupScopedJs<UserJs>?>

	public fun getUsers(groupId: String, userIds: Array<String>): Promise<Array<GroupScopedJs<UserJs>>>

	public fun modifyUser(user: GroupScopedJs<UserJs>): Promise<GroupScopedJs<UserJs>>

	public fun modifyUsers(users: Array<GroupScopedJs<UserJs>>): Promise<Array<GroupScopedJs<UserJs>>>

	public fun deleteUserById(userId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteUsersByIds(userIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteUser(user: GroupScopedJs<UserJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteUsers(users: Array<GroupScopedJs<UserJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeUserById(userId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgeUsersByIds(userIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeUser(user: GroupScopedJs<UserJs>): Promise<Unit>

	public fun purgeUsers(userIds: Array<GroupScopedJs<UserJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun undeleteUserById(userId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<UserJs>>

	public fun undeleteUsersByIds(userIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<UserJs>>>

	public fun undeleteUser(user: GroupScopedJs<UserJs>): Promise<GroupScopedJs<UserJs>>

	public fun undeleteUsers(users: Array<GroupScopedJs<UserJs>>):
			Promise<Array<GroupScopedJs<UserJs>>>

	public fun filterUsersBy(groupId: String, filter: BaseFilterOptionsJs<UserJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<UserJs>>>

	public fun matchUsersBy(groupId: String, filter: BaseFilterOptionsJs<UserJs>):
			Promise<Array<String>>

	public fun filterUsersBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<UserJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<UserJs>>>

	public fun matchUsersBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<UserJs>):
			Promise<Array<String>>

	public fun setUserRoles(user: GroupScopedJs<UserJs>, rolesIds: Array<String>):
			Promise<GroupScopedJs<UserJs>>

	public fun resetUserRoles(user: GroupScopedJs<UserJs>): Promise<GroupScopedJs<UserJs>>

	public fun getToken(
		userIdentifier: String,
		groupId: String,
		key: String,
		options: dynamic,
	): Promise<String>

	public fun getTokenInAllGroups(
		userIdentifier: String,
		key: String,
		options: dynamic,
	): Promise<Array<TokenWithGroupJs>>

	public fun enable2faForUser(user: GroupScopedJs<UserJs>, request: Enable2faRequestJs):
			Promise<Unit>

	public fun disable2faForUser(user: GroupScopedJs<UserJs>): Promise<Unit>

	public fun createAdminUser(user: GroupScopedJs<UserJs>): Promise<GroupScopedJs<UserJs>>

	public fun setUserInheritsPermissions(user: GroupScopedJs<UserJs>, `value`: Boolean): Promise<Unit>

	public fun setLoginIdentifiers(
		user: GroupScopedJs<UserJs>,
		identifier: LoginIdentifierJs,
		replaceExisting: Boolean,
	): Promise<Boolean>
}

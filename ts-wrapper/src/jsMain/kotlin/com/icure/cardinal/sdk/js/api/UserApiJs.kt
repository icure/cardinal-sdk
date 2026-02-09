// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.model.EncryptedPropertyStubJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserGroupJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.security.Enable2faRequestJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("UserApi")
public external interface UserApiJs {
	public val inGroup: UserInGroupApiJs

	public fun getCurrentUser(): Promise<UserJs>

	public fun createUser(user: UserJs): Promise<UserJs>

	public fun createUsers(users: Array<UserJs>): Promise<Array<UserJs>>

	public fun getUser(userId: String): Promise<UserJs?>

	public fun getUsers(userIds: Array<String>): Promise<Array<UserJs>>

	public fun modifyUser(user: UserJs): Promise<UserJs>

	public fun modifyUsers(users: Array<UserJs>): Promise<Array<UserJs>>

	public fun getUserByEmail(email: String): Promise<UserJs?>

	public fun getUserByPhoneNumber(phoneNumber: String): Promise<UserJs?>

	public fun findByHcpartyId(id: String): Promise<Array<String>>

	public fun findByPatientId(id: String): Promise<Array<String>>

	public fun assignHealthcareParty(healthcarePartyId: String): Promise<UserJs>

	public fun modifyProperties(userId: String, properties: Array<EncryptedPropertyStubJs>?):
			Promise<UserJs>

	public fun getToken(
		userId: String,
		key: String,
		options: dynamic,
	): Promise<String>

	public fun filterUsersBy(filter: BaseFilterOptionsJs<UserJs>):
			Promise<PaginatedListIteratorJs<UserJs>>

	public fun matchUsersBy(filter: BaseFilterOptionsJs<UserJs>): Promise<Array<String>>

	public fun filterUsersBySorted(filter: BaseSortableFilterOptionsJs<UserJs>):
			Promise<PaginatedListIteratorJs<UserJs>>

	public fun matchUsersBySorted(filter: BaseSortableFilterOptionsJs<UserJs>): Promise<Array<String>>

	public fun getMatchingUsers(): Promise<Array<UserGroupJs>>

	public fun setUserRoles(userId: String, rolesIds: Array<String>): Promise<UserJs>

	public fun resetUserRoles(userId: String): Promise<UserJs>

	public fun enable2faForUser(userId: String, request: Enable2faRequestJs): Promise<Unit>

	public fun disable2faForUser(userId: String): Promise<Unit>

	public fun createAdminUser(user: UserJs): Promise<UserJs>

	public fun deleteUserById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>

	public fun deleteUsersByIds(userIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeUserById(id: String, rev: String): Promise<Unit>

	public fun purgeUsersByIds(userIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun undeleteUserById(id: String, rev: String): Promise<UserJs>

	public fun undeleteUsersByIds(userIds: Array<StoredDocumentIdentifierJs>): Promise<Array<UserJs>>

	public fun deleteUser(user: UserJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteUsers(users: Array<UserJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeUser(user: UserJs): Promise<Unit>

	public fun purgeUsers(users: Array<UserJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun undeleteUser(user: UserJs): Promise<UserJs>

	public fun undeleteUsers(users: Array<UserJs>): Promise<Array<UserJs>>

	public fun setExternalJwtAuthByIdentifiersForCurrentUser(externalJwtConfigId: String,
			externalAuthenticationToken: String): Promise<Boolean>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<UserJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<UserJs>>
}

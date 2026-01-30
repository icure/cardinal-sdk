package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.UserGroup
import com.icure.cardinal.sdk.model.security.Enable2faRequest
import com.icure.cardinal.sdk.model.security.LoginIdentifier
import com.icure.cardinal.sdk.model.security.TokenWithGroup
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.subscription.Subscribable
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

interface UserApi: Subscribable<User, User, FilterOptions<User>> {

	val inGroup: UserInGroupApi

	suspend fun getCurrentUser(): User

	suspend fun createUser(user: User): User
	suspend fun createUsers(users: List<User>): List<User>

	suspend fun getUser(userId: String): User?
	suspend fun getUsers(userIds: List<String>): List<User>

	suspend fun modifyUser(user: User): User
	suspend fun modifyUsers(users: List<User>): List<User>

	suspend fun getUserByEmail(email: String): User?
	suspend fun getUserByPhoneNumber(phoneNumber: String): User?
	suspend fun findByHcpartyId(id: String): List<String>
	suspend fun findByPatientId(id: String): List<String>
	suspend fun assignHealthcareParty(healthcarePartyId: String): User
	suspend fun modifyProperties(
		userId: String,
		properties: List<EncryptedPropertyStub>?,
	): User

	suspend fun getToken(
		userId: String,
		key: String,
		@DefaultValue("null")
		tokenValidity: Long? = null,
		@DefaultValue("null")
		token: String? = null,
	): String

	suspend fun filterUsersBy(filter: BaseFilterOptions<User>): PaginatedListIterator<User>
	suspend fun matchUsersBy(filter: BaseFilterOptions<User>): List<String>
	suspend fun filterUsersBySorted(filter: BaseSortableFilterOptions<User>): PaginatedListIterator<User>
	suspend fun matchUsersBySorted(filter: BaseSortableFilterOptions<User>): List<String>

	suspend fun getMatchingUsers(): List<UserGroup>

	suspend fun setUserRoles(userId: String, rolesIds: List<String>): User

	suspend fun resetUserRoles(userId: String): User

	suspend fun enable2faForUser(userId: String, request: Enable2faRequest)

	suspend fun disable2faForUser(userId: String)

	suspend fun createAdminUser(user: User): User

	/**
	 * Deletes a user. If you don't have write access to the user the method will fail.
	 * @param entityId id of the user.
	 * @param rev the latest known rev of the user to delete
	 * @return the id and revision of the deleted user.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteUserById(entityId: String, rev: String): StoredDocumentIdentifier
	suspend fun deleteUsersByIds(userIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Permanently deletes a user.
	 * @param id id of the user to purge
	 * @param rev latest revision of the user
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeUserById(id: String, rev: String)
	suspend fun purgeUsersByIds(userIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier>

	/**
	 * Restores a user that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteUserById(id: String, rev: String): User
	suspend fun undeleteUsersByIds(userIds: List<StoredDocumentIdentifier>): List<User>

	/**
	 * Deletes a user. If you don't have write access to the user the method will fail.
	 * @param user the user to delete
	 * @return the id and revision of the deleted user.
	 * @throws RevisionConflictException if the provided user doesn't match the latest known revision
	 */
	suspend fun deleteUser(user: User): StoredDocumentIdentifier =
		deleteUserById(user.id, requireNotNull(user.rev) { "Can't delete a user that has no rev" })
	suspend fun deleteUsers(users: List<User>): List<StoredDocumentIdentifier> =
		deleteUsersByIds(users.map { it.toStoredDocumentIdentifier() })

	/**
	 * Permanently deletes a user.
	 * @param user the user to purge.
	 * @throws RevisionConflictException if the provided user doesn't match the latest known revision
	 */
	suspend fun purgeUser(user: User) {
		purgeUserById(user.id, requireNotNull(user.rev) { "Can't delete a user that has no rev" })
	}
	suspend fun purgeUsers(users: List<User>): List<StoredDocumentIdentifier> =
		purgeUsersByIds(users.map { it.toStoredDocumentIdentifier() })

	/**
	 * Restores a user that was marked as deleted.
	 * @param user the user to undelete
	 * @return the restored user.
	 * @throws RevisionConflictException if the provided user doesn't match the latest known revision
	 */
	suspend fun undeleteUser(user: User): User =
		undeleteUserById(user.id, requireNotNull(user.rev) { "Can't delete a user that has no rev" })
	suspend fun undeleteUsers(users: List<User>): List<User> =
		undeleteUsersByIds(users.map { it.toStoredDocumentIdentifier() })

	suspend fun setExternalJwtAuthByIdentifiersForCurrentUser(
		externalJwtConfigId: String,
		externalAuthenticationToken: String,
	): Boolean
}


interface UserInGroupApi {

	suspend fun createUser(user: GroupScoped<User>): GroupScoped<User>
	suspend fun createUsers(users: List<GroupScoped<User>>): List<GroupScoped<User>>

	suspend fun getUser(groupId: String, userId: String): GroupScoped<User>?
	suspend fun getUsers(groupId: String, userIds: List<String>): List<GroupScoped<User>>

	suspend fun modifyUser(user: GroupScoped<User>): GroupScoped<User>
	suspend fun modifyUsers(users: List<GroupScoped<User>>): List<GroupScoped<User>>

	suspend fun deleteUserById(userId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier>
	suspend fun deleteUsersByIds(userIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>
	suspend fun deleteUser(user: GroupScoped<User>): GroupScoped<StoredDocumentIdentifier> =
		deleteUserById(user.toStoredDocumentIdentifier())
	suspend fun deleteUsers(users: List<GroupScoped<User>>): List<GroupScoped<StoredDocumentIdentifier>> =
		deleteUsersByIds(users.map { it.toStoredDocumentIdentifier() })

	suspend fun purgeUserById(userId: GroupScoped<StoredDocumentIdentifier>)
	suspend fun purgeUsersByIds(userIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>>
	suspend fun purgeUser(user: GroupScoped<User>) {
		purgeUserById(user.toStoredDocumentIdentifier())
	}
	suspend fun purgeUsersByIds(userIds: List<GroupScoped<User>>): List<GroupScoped<StoredDocumentIdentifier>> =
		purgeUsersByIds(userIds.map { it.toStoredDocumentIdentifier() })

	suspend fun undeleteUserById(userId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<User>
	suspend fun undeleteUsersByIds(userIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<User>>
	suspend fun undeleteUser(user: GroupScoped<User>): GroupScoped<User> =
		undeleteUserById(user.toStoredDocumentIdentifier())
	suspend fun undeleteUsers(users: List<GroupScoped<User>>): List<GroupScoped<User>> =
		undeleteUsersByIds(users.map { it.toStoredDocumentIdentifier() })

	suspend fun filterUsersBy(
		groupId: String,
		filter: BaseFilterOptions<User>,
	): PaginatedListIterator< GroupScoped<User>>

	suspend fun matchUsersBy(groupId: String, filter: BaseFilterOptions<User>): List<String>

	suspend fun filterUsersBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<User>,
	): PaginatedListIterator< GroupScoped<User>>

	suspend fun matchUsersBySorted(groupId: String, filter: BaseSortableFilterOptions<User>): List<String>

	suspend fun setUserRoles(user: GroupScoped<User>, rolesIds: List<String>):  GroupScoped<User>
	suspend fun resetUserRoles(user: GroupScoped<User>): GroupScoped<User>

	suspend fun getToken(
		userIdentifier: String,
		groupId: String,
		key: String,
		@DefaultValue("null")
		token: String? = null,
		@DefaultValue("null")
		tokenValidity: Long? = null,
	): String

	suspend fun getTokenInAllGroups(
		userIdentifier: String,
		key: String,
		@DefaultValue("null")
		token: String? = null,
		@DefaultValue("null")
		tokenValidity: Long? = null,
	): List<TokenWithGroup>

	suspend fun enable2faForUser(user: GroupScoped<User>, request: Enable2faRequest)
	suspend fun disable2faForUser(user:GroupScoped<User>)

	suspend fun createAdminUser(user: GroupScoped<User>): GroupScoped<User>

	/**
	 * Defines if a user inherits the permission they have in their group in all the groups that are children of their group.
	 *
	 * @param user the user to update
	 */
	suspend fun setUserInheritsPermissions(user: GroupScoped<User>, value: Boolean)

	suspend fun setLoginIdentifiers(
		user: GroupScoped<User>,
		identifier: LoginIdentifier,
		replaceExisting: Boolean,
	): Boolean
}

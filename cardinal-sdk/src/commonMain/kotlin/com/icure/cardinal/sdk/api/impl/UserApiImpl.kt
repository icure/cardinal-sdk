package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.UserApi
import com.icure.cardinal.sdk.api.UserInGroupApi import com.icure.cardinal.sdk.api.raw.RawUserApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.mapUserFilterOptions
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.security.ChangeUserPasswordRequest
import com.icure.cardinal.sdk.model.security.Enable2faRequest
import com.icure.cardinal.sdk.model.security.LoginIdentifier
import com.icure.cardinal.sdk.model.toStoredDocumentIdentifier
import com.icure.cardinal.sdk.options.BasicApiConfiguration
import com.icure.cardinal.sdk.serialization.SubscriptionSerializer
import com.icure.cardinal.sdk.serialization.UserAbstractFilterSerializer
import com.icure.cardinal.sdk.subscription.EntitySubscription
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import com.icure.cardinal.sdk.subscription.WebSocketSubscription
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.cardinal.sdk.utils.pagination.IdsPageIterator
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
internal abstract class AbstractUserApi(
	protected val rawApi: RawUserApi,
) {

	protected suspend fun doCreateUser(groupId: String?, entity: User): User {
		requireIsValidForCreation(entity)
		return if (groupId == null) {
			rawApi.createUser(userDto = entity)
		} else {
			rawApi.createUserInGroup(groupId = groupId, userDto = entity)
		}.successBody()
	}

	protected suspend fun doCreateUsers(groupId: String?, entities: List<User>): List<User> =
		skipRequestOnEmptyList(entities) { calendarItemTypes ->
			if (groupId == null) {
				rawApi.createUsers(userDtos = calendarItemTypes)
			} else {
				rawApi.createUsersInGroup(groupId = groupId, userDtos = calendarItemTypes)
			}.successBody()
		}

	protected suspend fun doGetUser(groupId: String?, entityId: String): User? =
		if (groupId == null) {
			rawApi.getUser(userId = entityId)
		} else {
			rawApi.getUserInGroup(groupId = groupId, userId = entityId)
		}.successBodyOrNull404()

	protected suspend fun doGetUsers(groupId: String?, entityIds: List<String>): List<User> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.getUsers(userIds = ListOfIds(ids))
			} else {
				rawApi.getUsersInGroup(groupId = groupId, userIds = ListOfIds(ids))
			}.successBody()
		}

	protected suspend fun doModifyUser(groupId: String?, entity: User): User {
		requireIsValidForModification(entity)
		return if (groupId == null) {
			rawApi.modifyUser(userDto = entity)
		} else {
			rawApi.modifyUserInGroup(groupId = groupId, userDto = entity)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doModifyUsers(groupId: String?, entities: List<User>): List<User> =
		skipRequestOnEmptyList(entities) { calendarItemTypes ->
			if (groupId == null) {
				rawApi.modifyUsers(userDtos = calendarItemTypes)
			} else {
				rawApi.modifyUsersInGroup(groupId = groupId, userDtos = calendarItemTypes)
			}.successBody()
		}

	protected suspend fun doDeleteUser(groupId: String?, entityId: String, rev: String): StoredDocumentIdentifier =
		if (groupId == null) {
			rawApi.deleteUser(userId = entityId, rev = rev)
		} else {
			rawApi.deleteUserInGroup(groupId = groupId, userId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict().toStoredDocumentIdentifier()

	protected suspend fun doDeleteUsers(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.deleteUsers(userIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.deleteUsersInGroup(groupId = groupId, userIds = ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doUndeleteUser(groupId: String?, entityId: String, rev: String): User =
		if (groupId == null) {
			rawApi.undeleteUser(userId = entityId, rev = rev)
		} else {
			rawApi.undeleteUserInGroup(groupId = groupId, userId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict()

	protected suspend fun doUndeleteUsers(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<User> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.undeleteUsers(userIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.undeleteUsersInGroup(groupId = groupId, userIds = ListOfIdsAndRev(ids))
			}.successBody()
		}

	protected suspend fun doPurgeUser(groupId: String?, entityId: String, rev: String) {
		if (groupId == null) {
			rawApi.purgeUser(userId = entityId, rev = rev)
		} else {
			rawApi.purgeUserInGroup(groupId = groupId, userId = entityId, rev = rev)
		}.successBodyOrThrowRevisionConflict()
	}

	protected suspend fun doPurgeUsers(groupId: String?, entityIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		skipRequestOnEmptyList(entityIds) { ids ->
			if (groupId == null) {
				rawApi.purgeUsers(userIds = ListOfIdsAndRev(ids))
			} else {
				rawApi.purgeUsersInGroup(groupId = groupId, userIds = ListOfIdsAndRev(ids))
			}.successBody().map { it.toStoredDocumentIdentifier() }
		}

	protected suspend fun doMatchUsersBy(groupId: String?, filter: BaseFilterOptions<User>): List<String> =
		if (groupId == null) {
			rawApi.matchUsersBy(filter = mapUserFilterOptions(filter))
		} else {
			rawApi.matchUsersInGroupBy(groupId = groupId, filter = mapUserFilterOptions(filter))
		}.successBody()

	protected suspend fun doMatchUsersBySorted(groupId: String?, filter: BaseSortableFilterOptions<User>): List<String> =
		doMatchUsersBy(groupId, filter = filter)
}

@InternalIcureApi
internal class UserApiImpl(
	rawApi: RawUserApi,
	private val config: BasicApiConfiguration,
) : UserApi, AbstractUserApi(rawApi) {

	override val inGroup: UserInGroupApi = UserInGroupApiImpl(rawApi)

	override suspend fun getCurrentUser(): User =
		rawApi.getCurrentUser().successBody()

	override suspend fun createUser(user: User) = doCreateUser(groupId = null, entity = user)

	override suspend fun createUsers(users: List<User>): List<User> {
		requireIsValidForCreation(users)
		return doCreateUsers(groupId = null, entities = users)
	}

	override suspend fun getUser(userId: String) = doGetUser(groupId = null, entityId = userId)

	override suspend fun getUsers(userIds: List<String>) = doGetUsers(groupId = null, entityIds = userIds)

	override suspend fun getUserByEmail(email: String) = rawApi.getUserByEmail(email = email).successBodyOrNull404()

	override suspend fun getUserByPhoneNumber(phoneNumber: String) = rawApi.getUserByPhoneNumber(phoneNumber = phoneNumber).successBodyOrNull404()

	override suspend fun findByHcpartyId(id: String) = rawApi.findByHcpartyId(id = id).successBody()

	override suspend fun findByPatientId(id: String) = rawApi.findByPatientId(id = id).successBody()

	override suspend fun modifyUser(user: User) = doModifyUser(groupId = null, entity = user)

	override suspend fun modifyUsers(users: List<User>): List<User> {
		requireIsValidForModification(users)
		return doModifyUsers(groupId = null, entities = users)
	}

	override suspend fun assignHealthcareParty(healthcarePartyId: String) = rawApi.assignHealthcareParty(healthcarePartyId = healthcarePartyId).successBody()

	override suspend fun modifyProperties(
		userId: String,
		properties: List<EncryptedPropertyStub>?,
	) = rawApi.modifyProperties(userId = userId, properties = properties).successBody()

	override suspend fun getToken(
		userId: String,
		key: String,
		tokenValidity: Long?,
		token: String?,
	) = rawApi.getToken(userId = userId, key = key, tokenValidity = tokenValidity, token = token).successBody()

	override suspend fun matchUsersBy(filter: BaseFilterOptions<User>) =
		doMatchUsersBy(groupId = null, filter = filter)

	override suspend fun filterUsersBy(filter: BaseFilterOptions<User>): PaginatedListIterator<User> =
		IdsPageIterator(matchUsersBy(filter), this::getUsers)

	override suspend fun matchUsersBySorted(filter: BaseSortableFilterOptions<User>) =
		doMatchUsersBySorted(groupId = null, filter = filter)

	override suspend fun filterUsersBySorted(filter: BaseSortableFilterOptions<User>): PaginatedListIterator<User> =
		IdsPageIterator(matchUsersBySorted(filter), this::getUsers)

	override suspend fun getMatchingUsers() = rawApi.getMatchingUsers().successBody()

	override suspend fun deleteUserById(entityId: String, rev: String): StoredDocumentIdentifier =
		doDeleteUser(groupId = null, entityId = entityId, rev = rev)

	override suspend fun deleteUsersByIds(userIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doDeleteUsers(groupId = null, entityIds = userIds)

	override suspend fun purgeUserById(id: String, rev: String) {
		doPurgeUser(groupId = null, entityId = id, rev = rev)
	}

	override suspend fun purgeUsersByIds(userIds: List<StoredDocumentIdentifier>): List<StoredDocumentIdentifier> =
		doPurgeUsers(groupId = null, entityIds = userIds)

	override suspend fun undeleteUserById(id: String, rev: String): User = doUndeleteUser(groupId = id, entityId = id, rev = rev)

	override suspend fun undeleteUsersByIds(userIds: List<StoredDocumentIdentifier>): List<User> =
		doUndeleteUsers(groupId = null, entityIds = userIds)

	override suspend fun setExternalJwtAuthByIdentifiersForCurrentUser(
		externalJwtConfigId: String,
		externalAuthenticationToken: String
	): Boolean = rawApi.setExternalJwtAuthByIdentifiersForCurrentUser(
		externalJwtConfigId = externalJwtConfigId,
		externalAuthenticationToken = externalAuthenticationToken
	).successBodyOrThrowRevisionConflict()

	override suspend fun setUserRoles(userId: String, rolesIds: List<String>) =
		rawApi.setRolesForUser(userId = userId, rolesId = ListOfIds(rolesIds)).successBodyOrThrowRevisionConflict()

	override suspend fun resetUserRoles(userId: String) = rawApi.resetUserRoles(userId = userId).successBodyOrThrowRevisionConflict()

	override suspend fun enable2faForUser(
		userId: String,
		request: Enable2faRequest,
	) {
		rawApi.enable2faForUser(userId = userId, request = request).successBody()
	}

	override suspend fun disable2faForUser(userId: String) {
		rawApi.disable2faForUser(userId = userId).successBody()
	}

	override suspend fun createAdminUser(user: User) = rawApi.createAdminUser(userDto = user).successBody()

	override suspend fun modifyUserPassword(
		userId: String,
		newPassword: String,
	): User =
		rawApi.changeUserPassword(userId = userId, request = ChangeUserPasswordRequest(newPassword)).successBody()

	override suspend fun modifyUserEmail(
		userId: String,
		newEmail: String,
		previousEmail: String?,
	): User =
		rawApi.changeUserEmail(userId = userId, newEmail = newEmail, previousEmail = previousEmail).successBody()

	override suspend fun modifyUserMobilePhone(
		userId: String,
		newMobilePhone: String,
		previousMobilePhone: String?,
	): User =
		rawApi.changeUserMobilePhone(userId = userId, newMobilePhone = newMobilePhone, previousMobilePhone = previousMobilePhone).successBody()

	override suspend fun removeUserMobilePhone(
		userId: String,
		previousMobilePhone: String?
	): User = rawApi.removeUserMobilePhone(
		userId = userId,
		previousMobilePhone = previousMobilePhone
	).successBody()

	override suspend fun subscribeToEvents(
		events: Set<SubscriptionEventType>,
		filter: FilterOptions<User>,
		subscriptionConfig: EntitySubscriptionConfiguration?,
	): EntitySubscription<User> {
		return WebSocketSubscription.initialize(
			client = config.rawApiConfig.httpClient,
			hostname = config.apiUrl,
			path = "/ws/v2/notification/subscribe",
			clientJson = config.rawApiConfig.json,
			entitySerializer = User.serializer(),
			events = events,
			filter = mapUserFilterOptions(filter),
			qualifiedName = User.KRAKEN_QUALIFIED_NAME,
			subscriptionRequestSerializer = {
				Serialization.json.encodeToString(SubscriptionSerializer(UserAbstractFilterSerializer), it)
			},
			webSocketAuthProvider = config.requireWebSocketAuthProvider(),
			config = subscriptionConfig
		)
	}
}

@OptIn(InternalIcureApi::class)
internal class UserInGroupApiImpl(
	rawApi: RawUserApi
): UserInGroupApi, AbstractUserApi(rawApi) {

	override suspend fun createUser(user: GroupScoped<User>): GroupScoped<User> = groupScopedWith(user) { groupId, entity ->
		doCreateUser(groupId = groupId, entity = entity)
	}

	override suspend fun createUsers(users: List<GroupScoped<User>>): List<GroupScoped<User>> {
		requireIsValidForCreationInGroup(users)
		return users.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doCreateUsers(groupId = groupId, entities = chunk)
		}
	}

	override suspend fun getUser(groupId: String, userId: String): GroupScoped<User>? = groupScopedIn(groupId) {
		doGetUser(groupId = groupId, entityId = userId)
	}

	override suspend fun getUsers(
		groupId: String,
		userIds: List<String>,
	): List<GroupScoped<User>> = groupScopedListIn(groupId) {
		doGetUsers(groupId = groupId, entityIds = userIds)
	}

	override suspend fun modifyUser(user: GroupScoped<User>): GroupScoped<User> = groupScopedWith(user) { groupId, entity ->
		doModifyUser(groupId = groupId, entity = entity)
	}

	override suspend fun modifyUsers(users: List<GroupScoped<User>>): List<GroupScoped<User>> {
		requireIsValidForModificationInGroup(users)
		return users.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doModifyUsers(groupId = groupId, entities = chunk)
		}
	}

	override suspend fun deleteUserById(userId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<StoredDocumentIdentifier> =
		groupScopedWith(userId) { groupId, entity ->
			doDeleteUser(groupId = groupId, entityId = entity.id, rev = entity.rev)
		}

	override suspend fun deleteUsersByIds(userIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		userIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doDeleteUsers(groupId = groupId, entityIds = chunk)
		}

	override suspend fun purgeUserById(userId: GroupScoped<StoredDocumentIdentifier>) {
		doPurgeUser(groupId = userId.groupId, entityId = userId.entity.id, rev = userId.entity.rev)
	}

	override suspend fun purgeUsersByIds(userIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<StoredDocumentIdentifier>> =
		userIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doPurgeUsers(groupId = groupId, entityIds = chunk)
		}

	override suspend fun undeleteUserById(userId: GroupScoped<StoredDocumentIdentifier>): GroupScoped<User> =
		groupScopedWith(userId) { groupId, entity ->
			doUndeleteUser(groupId = groupId, entityId = entity.id, rev = entity.rev)
		}

	override suspend fun undeleteUsersByIds(userIds: List<GroupScoped<StoredDocumentIdentifier>>): List<GroupScoped<User>> =
		userIds.mapUniqueIdentifiablesChunkedByGroup { groupId, chunk ->
			doUndeleteUsers(groupId = groupId, entityIds = chunk)
		}

	override suspend fun matchUsersBy(
		groupId: String,
		filter: BaseFilterOptions<User>,
	): List<String> = doMatchUsersBy(groupId = groupId, filter = filter)

	override suspend fun filterUsersBy(
		groupId: String,
		filter: BaseFilterOptions<User>,
	): PaginatedListIterator<GroupScoped<User>> = IdsPageIterator(matchUsersBy(groupId = groupId, filter = filter)) { ids ->
		doGetUsers(groupId, ids).map { GroupScoped(groupId = groupId, entity = it) }
	}

	override suspend fun matchUsersBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<User>,
	): List<String> = doMatchUsersBySorted(groupId = groupId, filter = filter)

	override suspend fun filterUsersBySorted(
		groupId: String,
		filter: BaseSortableFilterOptions<User>,
	): PaginatedListIterator<GroupScoped<User>> = IdsPageIterator(matchUsersBySorted(groupId = groupId, filter = filter)) { ids ->
		doGetUsers(groupId, ids).map { GroupScoped(groupId = groupId, entity = it) }
	}

	override suspend fun setUserInheritsPermissions(user: GroupScoped<User>, value: Boolean) {
		rawApi.setUserInheritsPermissions(
			userId = user.entity.id,
			groupId = user.groupId,
			value = value
		).successBodyOrThrowRevisionConflict()
	}

	override suspend fun setLoginIdentifiers(
		user: GroupScoped<User>,
		identifier: LoginIdentifier,
		replaceExisting: Boolean
	): Boolean = rawApi.setLoginIdentifiers(
		userId = user.entity.id,
		groupId = user.groupId,
		replaceExisting = replaceExisting,
		identifier = identifier
	).successBodyOrThrowRevisionConflict()

	override suspend fun setUserRoles(
		user: GroupScoped<User>,
		rolesIds: List<String>,
	): GroupScoped<User> = groupScopedWith(user) { groupId, entity ->
		rawApi.setRolesForUserInGroup(
			userId = entity.id,
			groupId = groupId,
			rolesId = ListOfIds(rolesIds)
		).successBodyOrThrowRevisionConflict()
	}

	override suspend fun resetUserRoles(
		user: GroupScoped<User>,
	) = groupScopedWith(user) { groupId, entity ->
		rawApi.resetUserRolesInGroup(userId = entity.id, groupId = groupId).successBody()
	}

	override suspend fun getToken(
		userIdentifier: String,
		groupId: String,
		key: String,
		token: String?,
		tokenValidity: Long?,
	) = rawApi.getTokenInGroup(
		groupId = groupId,
		userId = userIdentifier,
		key = key,
		token = token,
		tokenValidity = tokenValidity
	).successBody()

	override suspend fun getTokenInAllGroups(
		userIdentifier: String,
		key: String,
		token: String?,
		tokenValidity: Long?,
	) = rawApi.getTokenInAllGroups(userIdentifier = userIdentifier, key = key, token = token, tokenValidity = tokenValidity).successBody()

	override suspend fun enable2faForUser(
		user: GroupScoped<User>,
		request: Enable2faRequest,
	) {
		rawApi.enable2faForUser(
			userId = user.entity.id,
			groupId = user.groupId,
			request = request
		).successBody()
	}

	override suspend fun disable2faForUser(user: GroupScoped<User>) {
		rawApi.disable2faForUser(
			userId = user.entity.id,
			groupId = user.groupId
		).successBody()
	}

	override suspend fun createAdminUser(
		user: GroupScoped<User>,
	) = groupScopedWith(user) { groupId, entity ->
		rawApi.createAdminUserInGroup(groupId, entity).successBody()
	}

	override suspend fun modifyUserPassword(
		groupId: String,
		userId: String,
		newPassword: String
	): GroupScoped<User> =
		GroupScoped(
			entity = rawApi.changeUserPasswordInGroup(
				userId = userId,
				groupId = groupId,
				request = ChangeUserPasswordRequest(newPassword)
			).successBody(),
			groupId = groupId,
		)

	override suspend fun modifyUserEmail(
		groupId: String,
		userId: String,
		newEmail: String,
		previousEmail: String?
	): GroupScoped<User> =
		GroupScoped(
			entity = rawApi.changeUserEmailInGroup(
				userId = userId,
				groupId = groupId,
				newEmail = newEmail,
				previousEmail = previousEmail
			).successBody(),
			groupId = groupId,
		)

	override suspend fun modifyUserMobilePhone(
		groupId: String,
		userId: String,
		newMobilePhone: String,
		previousMobilePhone: String?
	): GroupScoped<User> =
		GroupScoped(
			entity = rawApi.changeUserMobilePhoneInGroup(
				userId = userId,
				groupId = groupId,
				newMobilePhone = newMobilePhone,
				previousMobilePhone = previousMobilePhone
			).successBody(),
			groupId = groupId,
		)
}

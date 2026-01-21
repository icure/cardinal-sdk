package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.UserGroup
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.chain.FilterChain
import com.icure.cardinal.sdk.model.security.Enable2faRequest
import com.icure.cardinal.sdk.model.security.LoginIdentifier
import com.icure.cardinal.sdk.model.security.TokenWithGroup
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawUserApi {
	// region common endpoints

	suspend fun getCurrentUser(includeMetadataFromGlobalUser: Boolean = false): HttpResponse<User>

	suspend fun listUsersBy(
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		skipPatients: Boolean? = null,
	): HttpResponse<PaginatedList<User>>

	suspend fun createUser(userDto: User): HttpResponse<User>

	suspend fun createUsers(userDtos: List<User>): HttpResponse<List<User>>

	suspend fun getUser(
		userId: String,
		includeMetadataFromGlobalUser: Boolean = false,
	): HttpResponse<User>

	suspend fun getUsers(userIds: ListOfIds): HttpResponse<List<User>>

	suspend fun getUserByEmail(email: String): HttpResponse<User>

	suspend fun getUserByPhoneNumber(phoneNumber: String): HttpResponse<User>

	suspend fun findByHcpartyId(id: String): HttpResponse<List<String>>

	suspend fun findByPatientId(id: String): HttpResponse<List<String>>

	suspend fun deleteUser(
		userId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun deleteUsers(userIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun undeleteUser(
		userId: String,
		rev: String,
	): HttpResponse<User>

	suspend fun undeleteUsers(userIds: ListOfIdsAndRev): HttpResponse<List<User>>

	suspend fun purgeUser(
		userId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeUsers(userIds: ListOfIdsAndRev): HttpResponse<List<DocIdentifier>>

	suspend fun modifyUser(userDto: User): HttpResponse<User>

	suspend fun modifyUsers(userDtos: List<User>): HttpResponse<List<User>>

	suspend fun assignHealthcareParty(
		healthcarePartyId: String,
		includeMetadataFromGlobalUser: Boolean = false,
	): HttpResponse<User>

	suspend fun modifyProperties(
		userId: String,
		properties: List<EncryptedPropertyStub>?,
	): HttpResponse<User>

	suspend fun getToken(
		userId: String,
		key: String,
		tokenValidity: Long? = null,
		token: String? = null,
	): HttpResponse<String>

	suspend fun filterUsersBy(
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<User>,
	): HttpResponse<PaginatedList<User>>

	suspend fun matchUsersBy(filter: AbstractFilter<User>): HttpResponse<List<String>>
	// endregion

	// region cloud endpoints

	suspend fun getMatchingUsers(): HttpResponse<List<UserGroup>>

	suspend fun listUsersInGroup(
		groupId: String,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
		includeMetadataFromGlobalUser: Boolean = false,
	): HttpResponse<PaginatedList<User>>

	suspend fun listUsersInAllGroups(
		username: String? = null,
		email: String? = null,
		phone: String? = null,
	): HttpResponse<List<User>>

	suspend fun createUserInGroup(
		groupId: String,
		userDto: User,
	): HttpResponse<User>

	suspend fun createUsersInGroup(
		groupId: String,
		userDtos: List<User>,
	): HttpResponse<List<User>>

	suspend fun modifyUserInGroup(
		groupId: String,
		userDto: User,
	): HttpResponse<User>

	suspend fun modifyUsersInGroup(
		groupId: String,
		userDtos: List<User>,
	): HttpResponse<List<User>>

	suspend fun deleteUserInGroup(
		groupId: String,
		userId: String,
		rev: String? = null,
	): HttpResponse<DocIdentifier>

	suspend fun deleteUsersInGroup(
		groupId: String,
		userIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun undeleteUserInGroup(
		groupId: String,
		userId: String,
		rev: String,
	): HttpResponse<User>

	suspend fun undeleteUsersInGroup(
		groupId: String,
		userIds: ListOfIdsAndRev,
	): HttpResponse<List<User>>

	suspend fun purgeUserInGroup(
		groupId: String,
		userId: String,
		rev: String,
	): HttpResponse<DocIdentifier>

	suspend fun purgeUsersInGroup(
		groupId: String,
		userIds: ListOfIdsAndRev,
	): HttpResponse<List<DocIdentifier>>

	suspend fun setRolesForUser(
		userId: String,
		rolesId: ListOfIds,
	): HttpResponse<User>

	suspend fun setRolesForUserInGroup(
		userId: String,
		groupId: String,
		rolesId: ListOfIds,
	): HttpResponse<User>

	suspend fun resetUserRoles(userId: String): HttpResponse<User>

	suspend fun resetUserRolesInGroup(
		userId: String,
		groupId: String,
	): HttpResponse<User>

	suspend fun getTokenInGroup(
		groupId: String,
		userId: String,
		key: String,
		token: String? = null,
		tokenValidity: Long? = null,
	): HttpResponse<String>

	suspend fun getTokenInAllGroups(
		userIdentifier: String,
		key: String,
		token: String? = null,
		tokenValidity: Long? = null,
	): HttpResponse<List<TokenWithGroup>>

	suspend fun filterUsersInGroupBy(
		groupId: String,
		startDocumentId: String? = null,
		limit: Int? = null,
		filterChain: FilterChain<User>,
		includeMetadataFromGlobalUser: Boolean = false,
	): HttpResponse<PaginatedList<User>>

	suspend fun getUsersInGroup(
		groupId: String,
		userIds: ListOfIds,
	): HttpResponse<List<User>>

	suspend fun getUserInGroup(
		groupId: String,
		userId: String,
	): HttpResponse<User>

	suspend fun matchUsersInGroupBy(
		groupId: String,
		filter: AbstractFilter<User>,
	): HttpResponse<List<String>>

	suspend fun enable2faForUser(
		userId: String,
		groupId: String,
		request: Enable2faRequest,
	): HttpResponse<Unit>

	suspend fun enable2faForUser(
		userId: String,
		request: Enable2faRequest,
	): HttpResponse<Unit>

	suspend fun disable2faForUser(
		userId: String,
		groupId: String,
	): HttpResponse<Unit>

	suspend fun disable2faForUser(userId: String): HttpResponse<Unit>

	suspend fun enableFasAuthenticationForUser(fasJwtToken: String): HttpResponse<Boolean>

	suspend fun revokeFasAuthenticationForUser(fasJwtToken: String): HttpResponse<Boolean>

	suspend fun setExternalJwtAuthByIdentifiersForCurrentUser(
		externalJwtConfigId: String,
		externalAuthenticationToken: String,
	): HttpResponse<Boolean>

	suspend fun unsetExternalJwtAuthByIdentifiersForCurrentUser(
		externalJwtConfigId: String,
		externalAuthenticationToken: String,
	): HttpResponse<Boolean>

	suspend fun setLoginIdentifiers(
		userId: String,
		groupId: String,
		replaceExisting: Boolean,
		identifier: LoginIdentifier,
	): HttpResponse<Boolean>

	suspend fun unsetLoginIdentifiers(
		userId: String,
		groupId: String,
		identifier: LoginIdentifier,
	): HttpResponse<Boolean>

	suspend fun createAdminUser(userDto: User): HttpResponse<User>

	suspend fun createAdminUserInGroup(
		groupId: String,
		userDto: User,
	): HttpResponse<User>

	suspend fun matchUsersBy(
		groupId: String,
		filter: AbstractFilter<User>,
	): HttpResponse<List<String>>

	suspend fun setUserInheritsPermissions(
		userId: String,
		groupId: String,
		`value`: Boolean,
	): HttpResponse<String>
	// endregion
}

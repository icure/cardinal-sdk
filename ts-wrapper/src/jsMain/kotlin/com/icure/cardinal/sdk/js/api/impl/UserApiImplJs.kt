// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.UserApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.UserApiJs
import com.icure.cardinal.sdk.js.api.UserInGroupApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.EncryptedPropertyStubJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserGroupJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.groupScoped_fromJs
import com.icure.cardinal.sdk.js.model.groupScoped_toJs
import com.icure.cardinal.sdk.js.model.propertyStub_fromJs
import com.icure.cardinal.sdk.js.model.security.Enable2faRequestJs
import com.icure.cardinal.sdk.js.model.security.LoginIdentifierJs
import com.icure.cardinal.sdk.js.model.security.TokenWithGroupJs
import com.icure.cardinal.sdk.js.model.security.enable2faRequest_fromJs
import com.icure.cardinal.sdk.js.model.security.loginIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.security.tokenWithGroup_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_toJs
import com.icure.cardinal.sdk.js.model.userGroup_toJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.model.user_toJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.UserGroup
import com.icure.cardinal.sdk.model.security.Enable2faRequest
import com.icure.cardinal.sdk.model.security.LoginIdentifier
import com.icure.cardinal.sdk.model.security.TokenWithGroup
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class UserApiImplJs(
	private val userApi: UserApi,
) : UserApiJs {
	override val inGroup: UserInGroupApiJs = object : UserInGroupApiJs {
		override fun createUser(user: GroupScopedJs<UserJs>): Promise<GroupScopedJs<UserJs>> =
				GlobalScope.promise {
			val userConverted: GroupScoped<User> = groupScoped_fromJs(
				user,
				{ x1: UserJs ->
					user_fromJs(x1)
				},
			)
			val result = userApi.inGroup.createUser(
				userConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: User ->
					user_toJs(x1)
				},
			)
		}

		override fun createUsers(users: Array<GroupScopedJs<UserJs>>):
				Promise<Array<GroupScopedJs<UserJs>>> = GlobalScope.promise {
			val usersConverted: List<GroupScoped<User>> = arrayToList(
				users,
				"users",
				{ x1: GroupScopedJs<UserJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: UserJs ->
							user_fromJs(x2)
						},
					)
				},
			)
			val result = userApi.inGroup.createUsers(
				usersConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<User> ->
					groupScoped_toJs(
						x1,
						{ x2: User ->
							user_toJs(x2)
						},
					)
				},
			)
		}

		override fun getUser(groupId: String, userId: String): Promise<GroupScopedJs<UserJs>?> =
				GlobalScope.promise {
			val groupIdConverted: String = groupId
			val userIdConverted: String = userId
			val result = userApi.inGroup.getUser(
				groupIdConverted,
				userIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					groupScoped_toJs(
						nonNull1,
						{ x1: User ->
							user_toJs(x1)
						},
					)
				}
			)
		}

		override fun getUsers(groupId: String, userIds: Array<String>):
				Promise<Array<GroupScopedJs<UserJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val userIdsConverted: List<String> = arrayToList(
				userIds,
				"userIds",
				{ x1: String ->
					x1
				},
			)
			val result = userApi.inGroup.getUsers(
				groupIdConverted,
				userIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<User> ->
					groupScoped_toJs(
						x1,
						{ x2: User ->
							user_toJs(x2)
						},
					)
				},
			)
		}

		override fun modifyUser(user: GroupScopedJs<UserJs>): Promise<GroupScopedJs<UserJs>> =
				GlobalScope.promise {
			val userConverted: GroupScoped<User> = groupScoped_fromJs(
				user,
				{ x1: UserJs ->
					user_fromJs(x1)
				},
			)
			val result = userApi.inGroup.modifyUser(
				userConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: User ->
					user_toJs(x1)
				},
			)
		}

		override fun modifyUsers(users: Array<GroupScopedJs<UserJs>>):
				Promise<Array<GroupScopedJs<UserJs>>> = GlobalScope.promise {
			val usersConverted: List<GroupScoped<User>> = arrayToList(
				users,
				"users",
				{ x1: GroupScopedJs<UserJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: UserJs ->
							user_fromJs(x2)
						},
					)
				},
			)
			val result = userApi.inGroup.modifyUsers(
				usersConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<User> ->
					groupScoped_toJs(
						x1,
						{ x2: User ->
							user_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteUserById(userId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val userIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				userId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = userApi.inGroup.deleteUserById(
				userIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteUsersByIds(userIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val userIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				userIds,
				"userIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = userApi.inGroup.deleteUsersByIds(
				userIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun deleteUser(user: GroupScopedJs<UserJs>):
				Promise<GroupScopedJs<StoredDocumentIdentifierJs>> = GlobalScope.promise {
			val userConverted: GroupScoped<User> = groupScoped_fromJs(
				user,
				{ x1: UserJs ->
					user_fromJs(x1)
				},
			)
			val result = userApi.inGroup.deleteUser(
				userConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: StoredDocumentIdentifier ->
					storedDocumentIdentifier_toJs(x1)
				},
			)
		}

		override fun deleteUsers(users: Array<GroupScopedJs<UserJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val usersConverted: List<GroupScoped<User>> = arrayToList(
				users,
				"users",
				{ x1: GroupScopedJs<UserJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: UserJs ->
							user_fromJs(x2)
						},
					)
				},
			)
			val result = userApi.inGroup.deleteUsers(
				usersConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgeUserById(userId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit> =
				GlobalScope.promise {
			val userIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				userId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			userApi.inGroup.purgeUserById(
				userIdConverted,
			)

		}

		override fun purgeUsersByIds(userIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val userIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				userIds,
				"userIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = userApi.inGroup.purgeUsersByIds(
				userIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun purgeUser(user: GroupScopedJs<UserJs>): Promise<Unit> = GlobalScope.promise {
			val userConverted: GroupScoped<User> = groupScoped_fromJs(
				user,
				{ x1: UserJs ->
					user_fromJs(x1)
				},
			)
			userApi.inGroup.purgeUser(
				userConverted,
			)

		}

		override fun purgeUsers(userIds: Array<GroupScopedJs<UserJs>>):
				Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>> = GlobalScope.promise {
			val userIdsConverted: List<GroupScoped<User>> = arrayToList(
				userIds,
				"userIds",
				{ x1: GroupScopedJs<UserJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: UserJs ->
							user_fromJs(x2)
						},
					)
				},
			)
			val result = userApi.inGroup.purgeUsers(
				userIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<StoredDocumentIdentifier> ->
					groupScoped_toJs(
						x1,
						{ x2: StoredDocumentIdentifier ->
							storedDocumentIdentifier_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteUserById(userId: GroupScopedJs<StoredDocumentIdentifierJs>):
				Promise<GroupScopedJs<UserJs>> = GlobalScope.promise {
			val userIdConverted: GroupScoped<StoredDocumentIdentifier> = groupScoped_fromJs(
				userId,
				{ x1: StoredDocumentIdentifierJs ->
					storedDocumentIdentifier_fromJs(x1)
				},
			)
			val result = userApi.inGroup.undeleteUserById(
				userIdConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: User ->
					user_toJs(x1)
				},
			)
		}

		override fun undeleteUsersByIds(userIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
				Promise<Array<GroupScopedJs<UserJs>>> = GlobalScope.promise {
			val userIdsConverted: List<GroupScoped<StoredDocumentIdentifier>> = arrayToList(
				userIds,
				"userIds",
				{ x1: GroupScopedJs<StoredDocumentIdentifierJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: StoredDocumentIdentifierJs ->
							storedDocumentIdentifier_fromJs(x2)
						},
					)
				},
			)
			val result = userApi.inGroup.undeleteUsersByIds(
				userIdsConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<User> ->
					groupScoped_toJs(
						x1,
						{ x2: User ->
							user_toJs(x2)
						},
					)
				},
			)
		}

		override fun undeleteUser(user: GroupScopedJs<UserJs>): Promise<GroupScopedJs<UserJs>> =
				GlobalScope.promise {
			val userConverted: GroupScoped<User> = groupScoped_fromJs(
				user,
				{ x1: UserJs ->
					user_fromJs(x1)
				},
			)
			val result = userApi.inGroup.undeleteUser(
				userConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: User ->
					user_toJs(x1)
				},
			)
		}

		override fun undeleteUsers(users: Array<GroupScopedJs<UserJs>>):
				Promise<Array<GroupScopedJs<UserJs>>> = GlobalScope.promise {
			val usersConverted: List<GroupScoped<User>> = arrayToList(
				users,
				"users",
				{ x1: GroupScopedJs<UserJs> ->
					groupScoped_fromJs(
						x1,
						{ x2: UserJs ->
							user_fromJs(x2)
						},
					)
				},
			)
			val result = userApi.inGroup.undeleteUsers(
				usersConverted,
			)
			listToArray(
				result,
				{ x1: GroupScoped<User> ->
					groupScoped_toJs(
						x1,
						{ x2: User ->
							user_toJs(x2)
						},
					)
				},
			)
		}

		override fun filterUsersBy(groupId: String, filter: BaseFilterOptionsJs<UserJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<UserJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<User> = baseFilterOptions_fromJs(filter)
			val result = userApi.inGroup.filterUsersBy(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<User> ->
					groupScoped_toJs(
						x1,
						{ x2: User ->
							user_toJs(x2)
						},
					)
				},
			)
		}

		override fun matchUsersBy(groupId: String, filter: BaseFilterOptionsJs<UserJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseFilterOptions<User> = baseFilterOptions_fromJs(filter)
			val result = userApi.inGroup.matchUsersBy(
				groupIdConverted,
				filterConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}

		override fun filterUsersBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<UserJs>):
				Promise<PaginatedListIteratorJs<GroupScopedJs<UserJs>>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<User> = baseSortableFilterOptions_fromJs(filter)
			val result = userApi.inGroup.filterUsersBySorted(
				groupIdConverted,
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: GroupScoped<User> ->
					groupScoped_toJs(
						x1,
						{ x2: User ->
							user_toJs(x2)
						},
					)
				},
			)
		}

		override fun matchUsersBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<UserJs>):
				Promise<Array<String>> = GlobalScope.promise {
			val groupIdConverted: String = groupId
			val filterConverted: BaseSortableFilterOptions<User> = baseSortableFilterOptions_fromJs(filter)
			val result = userApi.inGroup.matchUsersBySorted(
				groupIdConverted,
				filterConverted,
			)
			listToArray(
				result,
				{ x1: String ->
					x1
				},
			)
		}

		override fun setUserRoles(user: GroupScopedJs<UserJs>, rolesIds: Array<String>):
				Promise<GroupScopedJs<UserJs>> = GlobalScope.promise {
			val userConverted: GroupScoped<User> = groupScoped_fromJs(
				user,
				{ x1: UserJs ->
					user_fromJs(x1)
				},
			)
			val rolesIdsConverted: List<String> = arrayToList(
				rolesIds,
				"rolesIds",
				{ x1: String ->
					x1
				},
			)
			val result = userApi.inGroup.setUserRoles(
				userConverted,
				rolesIdsConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: User ->
					user_toJs(x1)
				},
			)
		}

		override fun resetUserRoles(user: GroupScopedJs<UserJs>): Promise<GroupScopedJs<UserJs>> =
				GlobalScope.promise {
			val userConverted: GroupScoped<User> = groupScoped_fromJs(
				user,
				{ x1: UserJs ->
					user_fromJs(x1)
				},
			)
			val result = userApi.inGroup.resetUserRoles(
				userConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: User ->
					user_toJs(x1)
				},
			)
		}

		override fun getToken(
			userIdentifier: String,
			groupId: String,
			key: String,
			options: dynamic,
		): Promise<String> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val userIdentifierConverted: String = userIdentifier
				val groupIdConverted: String = groupId
				val keyConverted: String = key
				val tokenConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"token",
					null
				) { token: String? ->
					undefinedToNull(token)
				}
				val tokenValidityConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"tokenValidity",
					null
				) { tokenValidity: Double? ->
					numberToLong(tokenValidity, "tokenValidity")
				}
				val result = userApi.inGroup.getToken(
					userIdentifierConverted,
					groupIdConverted,
					keyConverted,
					tokenConverted,
					tokenValidityConverted,
				)
				result
			}
		}

		override fun getTokenInAllGroups(
			userIdentifier: String,
			key: String,
			options: dynamic,
		): Promise<Array<TokenWithGroupJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val userIdentifierConverted: String = userIdentifier
				val keyConverted: String = key
				val tokenConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"token",
					null
				) { token: String? ->
					undefinedToNull(token)
				}
				val tokenValidityConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"tokenValidity",
					null
				) { tokenValidity: Double? ->
					numberToLong(tokenValidity, "tokenValidity")
				}
				val result = userApi.inGroup.getTokenInAllGroups(
					userIdentifierConverted,
					keyConverted,
					tokenConverted,
					tokenValidityConverted,
				)
				listToArray(
					result,
					{ x1: TokenWithGroup ->
						tokenWithGroup_toJs(x1)
					},
				)
			}
		}

		override fun enable2faForUser(user: GroupScopedJs<UserJs>, request: Enable2faRequestJs):
				Promise<Unit> = GlobalScope.promise {
			val userConverted: GroupScoped<User> = groupScoped_fromJs(
				user,
				{ x1: UserJs ->
					user_fromJs(x1)
				},
			)
			val requestConverted: Enable2faRequest = enable2faRequest_fromJs(request)
			userApi.inGroup.enable2faForUser(
				userConverted,
				requestConverted,
			)

		}

		override fun disable2faForUser(user: GroupScopedJs<UserJs>): Promise<Unit> = GlobalScope.promise {
			val userConverted: GroupScoped<User> = groupScoped_fromJs(
				user,
				{ x1: UserJs ->
					user_fromJs(x1)
				},
			)
			userApi.inGroup.disable2faForUser(
				userConverted,
			)

		}

		override fun createAdminUser(user: GroupScopedJs<UserJs>): Promise<GroupScopedJs<UserJs>> =
				GlobalScope.promise {
			val userConverted: GroupScoped<User> = groupScoped_fromJs(
				user,
				{ x1: UserJs ->
					user_fromJs(x1)
				},
			)
			val result = userApi.inGroup.createAdminUser(
				userConverted,
			)
			groupScoped_toJs(
				result,
				{ x1: User ->
					user_toJs(x1)
				},
			)
		}

		override fun setUserInheritsPermissions(user: GroupScopedJs<UserJs>, `value`: Boolean):
				Promise<Unit> = GlobalScope.promise {
			val userConverted: GroupScoped<User> = groupScoped_fromJs(
				user,
				{ x1: UserJs ->
					user_fromJs(x1)
				},
			)
			val valueConverted: Boolean = value
			userApi.inGroup.setUserInheritsPermissions(
				userConverted,
				valueConverted,
			)

		}

		override fun setLoginIdentifiers(
			user: GroupScopedJs<UserJs>,
			identifier: LoginIdentifierJs,
			replaceExisting: Boolean,
		): Promise<Boolean> = GlobalScope.promise {
			val userConverted: GroupScoped<User> = groupScoped_fromJs(
				user,
				{ x1: UserJs ->
					user_fromJs(x1)
				},
			)
			val identifierConverted: LoginIdentifier = loginIdentifier_fromJs(identifier)
			val replaceExistingConverted: Boolean = replaceExisting
			val result = userApi.inGroup.setLoginIdentifiers(
				userConverted,
				identifierConverted,
				replaceExistingConverted,
			)
			result
		}
	}

	override fun getCurrentUser(): Promise<UserJs> = GlobalScope.promise {
		val result = userApi.getCurrentUser(
		)
		user_toJs(result)
	}

	override fun createUser(user: UserJs): Promise<UserJs> = GlobalScope.promise {
		val userConverted: User = user_fromJs(user)
		val result = userApi.createUser(
			userConverted,
		)
		user_toJs(result)
	}

	override fun createUsers(users: Array<UserJs>): Promise<Array<UserJs>> = GlobalScope.promise {
		val usersConverted: List<User> = arrayToList(
			users,
			"users",
			{ x1: UserJs ->
				user_fromJs(x1)
			},
		)
		val result = userApi.createUsers(
			usersConverted,
		)
		listToArray(
			result,
			{ x1: User ->
				user_toJs(x1)
			},
		)
	}

	override fun getUser(userId: String): Promise<UserJs?> = GlobalScope.promise {
		val userIdConverted: String = userId
		val result = userApi.getUser(
			userIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				user_toJs(nonNull1)
			}
		)
	}

	override fun getUsers(userIds: Array<String>): Promise<Array<UserJs>> = GlobalScope.promise {
		val userIdsConverted: List<String> = arrayToList(
			userIds,
			"userIds",
			{ x1: String ->
				x1
			},
		)
		val result = userApi.getUsers(
			userIdsConverted,
		)
		listToArray(
			result,
			{ x1: User ->
				user_toJs(x1)
			},
		)
	}

	override fun modifyUser(user: UserJs): Promise<UserJs> = GlobalScope.promise {
		val userConverted: User = user_fromJs(user)
		val result = userApi.modifyUser(
			userConverted,
		)
		user_toJs(result)
	}

	override fun modifyUsers(users: Array<UserJs>): Promise<Array<UserJs>> = GlobalScope.promise {
		val usersConverted: List<User> = arrayToList(
			users,
			"users",
			{ x1: UserJs ->
				user_fromJs(x1)
			},
		)
		val result = userApi.modifyUsers(
			usersConverted,
		)
		listToArray(
			result,
			{ x1: User ->
				user_toJs(x1)
			},
		)
	}

	override fun getUserByEmail(email: String): Promise<UserJs?> = GlobalScope.promise {
		val emailConverted: String = email
		val result = userApi.getUserByEmail(
			emailConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				user_toJs(nonNull1)
			}
		)
	}

	override fun getUserByPhoneNumber(phoneNumber: String): Promise<UserJs?> = GlobalScope.promise {
		val phoneNumberConverted: String = phoneNumber
		val result = userApi.getUserByPhoneNumber(
			phoneNumberConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				user_toJs(nonNull1)
			}
		)
	}

	override fun findByHcpartyId(id: String): Promise<Array<String>> = GlobalScope.promise {
		val idConverted: String = id
		val result = userApi.findByHcpartyId(
			idConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun findByPatientId(id: String): Promise<Array<String>> = GlobalScope.promise {
		val idConverted: String = id
		val result = userApi.findByPatientId(
			idConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun assignHealthcareParty(healthcarePartyId: String): Promise<UserJs> =
			GlobalScope.promise {
		val healthcarePartyIdConverted: String = healthcarePartyId
		val result = userApi.assignHealthcareParty(
			healthcarePartyIdConverted,
		)
		user_toJs(result)
	}

	override fun modifyProperties(userId: String, properties: Array<EncryptedPropertyStubJs>?):
			Promise<UserJs> = GlobalScope.promise {
		val userIdConverted: String = userId
		val propertiesConverted: List<EncryptedPropertyStub>? = arrayToList(
			properties,
			"properties",
			{ x1: EncryptedPropertyStubJs ->
				propertyStub_fromJs(x1)
			},
		)
		val result = userApi.modifyProperties(
			userIdConverted,
			propertiesConverted,
		)
		user_toJs(result)
	}

	override fun getToken(
		userId: String,
		key: String,
		options: dynamic,
	): Promise<String> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val userIdConverted: String = userId
			val keyConverted: String = key
			val tokenValidityConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"tokenValidity",
				null
			) { tokenValidity: Double? ->
				numberToLong(tokenValidity, "tokenValidity")
			}
			val tokenConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"token",
				null
			) { token: String? ->
				undefinedToNull(token)
			}
			val result = userApi.getToken(
				userIdConverted,
				keyConverted,
				tokenValidityConverted,
				tokenConverted,
			)
			result
		}
	}

	override fun filterUsersBy(filter: BaseFilterOptionsJs<UserJs>):
			Promise<PaginatedListIteratorJs<UserJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<User> = baseFilterOptions_fromJs(filter)
		val result = userApi.filterUsersBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: User ->
				user_toJs(x1)
			},
		)
	}

	override fun matchUsersBy(filter: BaseFilterOptionsJs<UserJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<User> = baseFilterOptions_fromJs(filter)
		val result = userApi.matchUsersBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterUsersBySorted(filter: BaseSortableFilterOptionsJs<UserJs>):
			Promise<PaginatedListIteratorJs<UserJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<User> = baseSortableFilterOptions_fromJs(filter)
		val result = userApi.filterUsersBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: User ->
				user_toJs(x1)
			},
		)
	}

	override fun matchUsersBySorted(filter: BaseSortableFilterOptionsJs<UserJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<User> = baseSortableFilterOptions_fromJs(filter)
		val result = userApi.matchUsersBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun getMatchingUsers(): Promise<Array<UserGroupJs>> = GlobalScope.promise {
		val result = userApi.getMatchingUsers(
		)
		listToArray(
			result,
			{ x1: UserGroup ->
				userGroup_toJs(x1)
			},
		)
	}

	override fun setUserRoles(userId: String, rolesIds: Array<String>): Promise<UserJs> =
			GlobalScope.promise {
		val userIdConverted: String = userId
		val rolesIdsConverted: List<String> = arrayToList(
			rolesIds,
			"rolesIds",
			{ x1: String ->
				x1
			},
		)
		val result = userApi.setUserRoles(
			userIdConverted,
			rolesIdsConverted,
		)
		user_toJs(result)
	}

	override fun resetUserRoles(userId: String): Promise<UserJs> = GlobalScope.promise {
		val userIdConverted: String = userId
		val result = userApi.resetUserRoles(
			userIdConverted,
		)
		user_toJs(result)
	}

	override fun enable2faForUser(userId: String, request: Enable2faRequestJs): Promise<Unit> =
			GlobalScope.promise {
		val userIdConverted: String = userId
		val requestConverted: Enable2faRequest = enable2faRequest_fromJs(request)
		userApi.enable2faForUser(
			userIdConverted,
			requestConverted,
		)

	}

	override fun disable2faForUser(userId: String): Promise<Unit> = GlobalScope.promise {
		val userIdConverted: String = userId
		userApi.disable2faForUser(
			userIdConverted,
		)

	}

	override fun createAdminUser(user: UserJs): Promise<UserJs> = GlobalScope.promise {
		val userConverted: User = user_fromJs(user)
		val result = userApi.createAdminUser(
			userConverted,
		)
		user_toJs(result)
	}

	override fun deleteUserById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = userApi.deleteUserById(
			entityIdConverted,
			revConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteUsersByIds(userIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val userIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			userIds,
			"userIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = userApi.deleteUsersByIds(
			userIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeUserById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		userApi.purgeUserById(
			idConverted,
			revConverted,
		)

	}

	override fun purgeUsersByIds(userIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>> = GlobalScope.promise {
		val userIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			userIds,
			"userIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = userApi.purgeUsersByIds(
			userIdsConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun undeleteUserById(id: String, rev: String): Promise<UserJs> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = userApi.undeleteUserById(
			idConverted,
			revConverted,
		)
		user_toJs(result)
	}

	override fun undeleteUsersByIds(userIds: Array<StoredDocumentIdentifierJs>): Promise<Array<UserJs>>
			= GlobalScope.promise {
		val userIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			userIds,
			"userIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = userApi.undeleteUsersByIds(
			userIdsConverted,
		)
		listToArray(
			result,
			{ x1: User ->
				user_toJs(x1)
			},
		)
	}

	override fun deleteUser(user: UserJs): Promise<StoredDocumentIdentifierJs> = GlobalScope.promise {
		val userConverted: User = user_fromJs(user)
		val result = userApi.deleteUser(
			userConverted,
		)
		storedDocumentIdentifier_toJs(result)
	}

	override fun deleteUsers(users: Array<UserJs>): Promise<Array<StoredDocumentIdentifierJs>> =
			GlobalScope.promise {
		val usersConverted: List<User> = arrayToList(
			users,
			"users",
			{ x1: UserJs ->
				user_fromJs(x1)
			},
		)
		val result = userApi.deleteUsers(
			usersConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeUser(user: UserJs): Promise<Unit> = GlobalScope.promise {
		val userConverted: User = user_fromJs(user)
		userApi.purgeUser(
			userConverted,
		)

	}

	override fun purgeUsers(users: Array<UserJs>): Promise<Array<StoredDocumentIdentifierJs>> =
			GlobalScope.promise {
		val usersConverted: List<User> = arrayToList(
			users,
			"users",
			{ x1: UserJs ->
				user_fromJs(x1)
			},
		)
		val result = userApi.purgeUsers(
			usersConverted,
		)
		listToArray(
			result,
			{ x1: StoredDocumentIdentifier ->
				storedDocumentIdentifier_toJs(x1)
			},
		)
	}

	override fun undeleteUser(user: UserJs): Promise<UserJs> = GlobalScope.promise {
		val userConverted: User = user_fromJs(user)
		val result = userApi.undeleteUser(
			userConverted,
		)
		user_toJs(result)
	}

	override fun undeleteUsers(users: Array<UserJs>): Promise<Array<UserJs>> = GlobalScope.promise {
		val usersConverted: List<User> = arrayToList(
			users,
			"users",
			{ x1: UserJs ->
				user_fromJs(x1)
			},
		)
		val result = userApi.undeleteUsers(
			usersConverted,
		)
		listToArray(
			result,
			{ x1: User ->
				user_toJs(x1)
			},
		)
	}

	override fun setExternalJwtAuthByIdentifiersForCurrentUser(externalJwtConfigId: String,
			externalAuthenticationToken: String): Promise<Boolean> = GlobalScope.promise {
		val externalJwtConfigIdConverted: String = externalJwtConfigId
		val externalAuthenticationTokenConverted: String = externalAuthenticationToken
		val result = userApi.setExternalJwtAuthByIdentifiersForCurrentUser(
			externalJwtConfigIdConverted,
			externalAuthenticationTokenConverted,
		)
		result
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<UserJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<UserJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: FilterOptions<User> = filterOptions_fromJs(filter)
			val subscriptionConfigConverted: EntitySubscriptionConfiguration? =
					convertingOptionOrDefaultNullable(
				_options,
				"subscriptionConfig",
				null
			) { subscriptionConfig: EntitySubscriptionConfigurationJs? ->
				subscriptionConfig?.let { nonNull1 ->
					entitySubscriptionConfiguration_fromJs(nonNull1)
				}
			}
			val result = userApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: User ->
					user_toJs(x1)
				},
			)
		}
	}
}

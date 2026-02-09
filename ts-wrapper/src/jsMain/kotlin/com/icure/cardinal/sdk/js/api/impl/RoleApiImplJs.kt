// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.RoleApi
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.RoleApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.RoleJs
import com.icure.cardinal.sdk.js.model.role_toJs
import com.icure.cardinal.sdk.model.Role
import kotlin.Array
import kotlin.Double
import kotlin.Int
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
internal class RoleApiImplJs(
	private val roleApi: RoleApi,
) : RoleApiJs {
	override fun getAllRoles(): Promise<Array<RoleJs>> = GlobalScope.promise {
		val result = roleApi.getAllRoles(
		)
		listToArray(
			result,
			{ x1: Role ->
				role_toJs(x1)
			},
		)
	}

	override fun getAllRolesInGroup(groupId: String): Promise<Array<RoleJs>> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val result = roleApi.getAllRolesInGroup(
			groupIdConverted,
		)
		listToArray(
			result,
			{ x1: Role ->
				role_toJs(x1)
			},
		)
	}

	override fun getRole(roleId: String): Promise<RoleJs?> = GlobalScope.promise {
		val roleIdConverted: String = roleId
		val result = roleApi.getRole(
			roleIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				role_toJs(nonNull1)
			}
		)
	}

	override fun getRoles(rolesIds: Array<String>): Promise<Array<RoleJs>> = GlobalScope.promise {
		val rolesIdsConverted: List<String> = arrayToList(
			rolesIds,
			"rolesIds",
			{ x1: String ->
				x1
			},
		)
		val result = roleApi.getRoles(
			rolesIdsConverted,
		)
		listToArray(
			result,
			{ x1: Role ->
				role_toJs(x1)
			},
		)
	}

	override fun createRole(
		name: String,
		permissions: Array<String>,
		options: dynamic,
	): Promise<RoleJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val nameConverted: String = name
			val permissionsConverted: Set<String> = arrayToSet(
				permissions,
				"permissions",
				{ x1: String ->
					x1
				},
			)
			val inheritsUpToConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"inheritsUpTo",
				null
			) { inheritsUpTo: Double? ->
				numberToInt(inheritsUpTo, "inheritsUpTo")
			}
			val result = roleApi.createRole(
				nameConverted,
				permissionsConverted,
				inheritsUpToConverted,
			)
			role_toJs(result)
		}
	}

	override fun createRoleInGroup(
		groupId: String,
		name: String,
		permissions: Array<String>,
		options: dynamic,
	): Promise<RoleJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val nameConverted: String = name
			val permissionsConverted: Set<String> = arrayToSet(
				permissions,
				"permissions",
				{ x1: String ->
					x1
				},
			)
			val inheritsUpToConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"inheritsUpTo",
				null
			) { inheritsUpTo: Double? ->
				numberToInt(inheritsUpTo, "inheritsUpTo")
			}
			val result = roleApi.createRoleInGroup(
				groupIdConverted,
				nameConverted,
				permissionsConverted,
				inheritsUpToConverted,
			)
			role_toJs(result)
		}
	}

	override fun modifyRolePermissions(roleId: String, permissions: Array<String>): Promise<RoleJs> =
			GlobalScope.promise {
		val roleIdConverted: String = roleId
		val permissionsConverted: Set<String> = arrayToSet(
			permissions,
			"permissions",
			{ x1: String ->
				x1
			},
		)
		val result = roleApi.modifyRolePermissions(
			roleIdConverted,
			permissionsConverted,
		)
		role_toJs(result)
	}

	override fun purgeRole(roleId: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val roleIdConverted: String = roleId
		val revConverted: String = rev
		roleApi.purgeRole(
			roleIdConverted,
			revConverted,
		)

	}
}

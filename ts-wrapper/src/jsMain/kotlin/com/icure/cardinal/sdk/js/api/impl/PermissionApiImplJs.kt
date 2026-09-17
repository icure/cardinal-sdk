// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.PermissionApi
import com.icure.cardinal.sdk.js.api.PermissionApiJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.security.PermissionJs
import com.icure.cardinal.sdk.js.model.security.permission_fromJs
import com.icure.cardinal.sdk.js.model.security.permission_toJs
import com.icure.cardinal.sdk.model.security.Permission
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class PermissionApiImplJs(
	private val permissionApi: PermissionApi,
) : PermissionApiJs {
	override fun modifyUserPermissions(userId: String, permissions: PermissionJs): Promise<Array<PermissionJs>> = GlobalScope.promise {
		val userIdConverted: String = userId
		val permissionsConverted: Permission = permission_fromJs(permissions)
		val result = permissionApi.modifyUserPermissions(
			userIdConverted,
			permissionsConverted,
		)
		listToArray(
			result,
			{ x1: Permission ->
				permission_toJs(x1)
			},
		)
	}
}

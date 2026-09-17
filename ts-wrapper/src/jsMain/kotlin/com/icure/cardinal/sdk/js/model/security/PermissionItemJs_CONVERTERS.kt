// auto-generated file
package com.icure.cardinal.sdk.js.model.security

import com.icure.cardinal.sdk.model.security.AlwaysPermissionItem
import com.icure.cardinal.sdk.model.security.PermissionItem
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun permissionItem_toJs(obj: PermissionItem): PermissionItemJs = when (obj) {
	is AlwaysPermissionItem -> alwaysPermissionItem_toJs(obj)
}

public fun permissionItem_fromJs(obj: PermissionItemJs): PermissionItem = when {
	obj is AlwaysPermissionItemJs || obj.ktClass == "com.icure.cardinal.sdk.model.security.AlwaysPermissionItem" ->alwaysPermissionItem_fromJs(obj as com.icure.cardinal.sdk.js.model.security.AlwaysPermissionItemJs)
	else -> throw IllegalArgumentException("""Unknown concrete implementation for com.icure.cardinal.sdk.model.security.PermissionItem: $obj""")
}

// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.security.PermissionJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("PermissionApi")
public external interface PermissionApiJs {
	public fun modifyUserPermissions(userId: String, permissions: PermissionJs): Promise<Array<PermissionJs>>
}

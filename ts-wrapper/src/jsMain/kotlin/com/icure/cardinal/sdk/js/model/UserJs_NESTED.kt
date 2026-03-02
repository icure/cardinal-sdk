// auto-generated file
@file:JsQualifier("model.User")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.security.LoginIdentifierJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("SystemMetadata")
public external class UserJs_SystemMetadataJs(
	partial: dynamic,
) {
	public val roles: Array<String>

	public val isAdmin: Boolean

	public val inheritsRoles: Boolean

	public val loginIdentifiers: Array<LoginIdentifierJs>

	public val verifiedEmail: Boolean?

	public val verifiedMobilePhone: Boolean?
}

// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AuthApi")
public external interface AuthApiJs {
	public fun getBearerToken(): Promise<String>

	public fun getRefreshToken(): Promise<String>
}

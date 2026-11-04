// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.AuthApi
import com.icure.cardinal.sdk.js.api.AuthApiJs
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class AuthApiImplJs(
	private val authApi: AuthApi,
) : AuthApiJs {
	override fun getBearerToken(): Promise<String> = GlobalScope.promise {
		val result = authApi.getBearerToken(
		)
		result
	}

	override fun getRefreshToken(): Promise<String> = GlobalScope.promise {
		val result = authApi.getRefreshToken(
		)
		result
	}
}

package com.icure.cardinal.sdk.py.options

import com.icure.cardinal.sdk.auth.OAuthProvider
import com.icure.cardinal.sdk.options.AuthenticationMethod
import kotlinx.serialization.Serializable

@Serializable
internal sealed interface PyAuthMethod {
	fun toKt(): AuthenticationMethod

	@Serializable
	data class UsernamePassword(val username: String, val password: String): PyAuthMethod {
		override fun toKt() = AuthenticationMethod.UsingCredentials(com.icure.cardinal.sdk.auth.UsernamePassword(username, password))
	}
	@Serializable
	data class UsernameLongToken(val username: String, val token: String): PyAuthMethod {
		override fun toKt() = AuthenticationMethod.UsingCredentials(com.icure.cardinal.sdk.auth.UsernameLongToken(username, token))
	}
	@Serializable
	data class ThirdPartyAuthentication(val token: String, val provider: OAuthProvider): PyAuthMethod {
		override fun toKt() = AuthenticationMethod.UsingCredentials(com.icure.cardinal.sdk.auth.OAuthAuthentication(token, provider))
	}
}
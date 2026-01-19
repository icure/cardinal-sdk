package com.icure.cardinal.sdk.dart.auth

import kotlinx.serialization.Serializable

@Serializable
sealed interface Credentials {

	fun toKt(): com.icure.cardinal.sdk.auth.Credentials

	@Serializable
	data class UsernamePassword(val username: String, val password: String) : Credentials {
		override fun toKt() = com.icure.cardinal.sdk.auth.UsernamePassword(username, password)
	}

	@Serializable
	data class UsernameLongToken(val username: String, val token: String) : Credentials {
		override fun toKt() = com.icure.cardinal.sdk.auth.UsernameLongToken(username, token)
	}
}
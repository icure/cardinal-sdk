package com.icure.cardinal.sdk.auth

import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.utils.InternalIcureApi

sealed interface Credentials

data class UsernamePassword(
	/**
	 * A public identifier of the user logging in. This could be:
	 * - [User.id]
	 * - [Group.id]:[User.id]
	 * - [User.login]
	 * - [User.email]
	 */
	val username: String,
	/**
	 * The password of the user
	 */
	val password: String
) : Credentials

data class UsernameLongToken(
	/**
	 * A public identifier of the user logging in. This could be:
	 * - [User.id]
	 * - [Group.id]:[User.id]
	 * - [User.login]
	 * - [User.email]
	 */
	val username: String,
	/**
	 * A long-lived authentication token generated through iCure (cockpit or sdk)
	 */
	val token: String,
) : Credentials

data class ExternalAuthenticationToken(
	/**
	 * The id of the configuration that specifies how the token should be validated and how it should be used to find
	 * the corresponding user in iCure.
	 *
	 * Note you can only use external authentication if the sdk instance was initialized with an application id.
	 */
	val configId: String,
	/**
	 * A token used to perform the external authentication
	 */
	val token: String,
	/**
	 * During login consider only configurations that can provide at least this authentication class
	 */
	val minimumAuthenticationClass: AuthenticationClass = AuthenticationClass.ExternalAuthentication
) : Credentials

@InternalIcureApi
data class JwtCredentials(
	val initialBearer: JwtBearer?,
	val refresh: JwtRefresh
) : Credentials
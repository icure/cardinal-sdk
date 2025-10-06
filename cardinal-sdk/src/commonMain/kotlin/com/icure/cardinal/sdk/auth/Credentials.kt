package com.icure.cardinal.sdk.auth

import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.model.User
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

data class OAuthAuthentication(
	/**
	 * A token used to perform the OAuth authentication
	 */
	val token: String,
	/**
	 * The authentication provider
	 */
	val provider: OAuthProvider
) : Credentials

data class ExternalJwtProviderAuthentication(
	/**
	 * A token used to perform the external authentication
	 */
	val token: String,
	/**
	 * The identifier of the external JWT provider configuration that should be used to validate the provided token.
	 */
	val configId: String
) : Credentials

@InternalIcureApi
data class JwtCredentials(
	val initialBearer: JwtBearer?,
	val refresh: JwtRefresh
) : Credentials

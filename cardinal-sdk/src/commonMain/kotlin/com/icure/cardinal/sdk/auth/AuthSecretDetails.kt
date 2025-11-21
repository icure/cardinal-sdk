package com.icure.cardinal.sdk.auth

import com.icure.cardinal.sdk.model.embed.AuthenticationClass

sealed interface AuthSecretDetails {

	sealed interface Cacheable : AuthSecretDetails

	val type: AuthenticationClass
	val secret: String

	/**
	 * @param secret the password of the user
	 */
	data class PasswordDetails(override val secret: String) : AuthSecretDetails.Cacheable {
		override val type = AuthenticationClass.Password
	}

	/**
	 * @param secret the current two-factor authentication token of the user.
	 */
	data class TwoFactorAuthTokenDetails(override val secret: String) : AuthSecretDetails {
		override val type = AuthenticationClass.TwoFactorAuthentication
	}

	/**
	 * @param secret a short-lived token obtained through an authentication process
	 * @param authenticationProcessInfo the authentication process that was used to create the secret
	 */
	data class ShortLivedTokenDetails(
		override val secret: String,
		val authenticationProcessInfo: AuthenticationProcessRequest,
		val createLongLivedToken: Boolean = false
	) : AuthSecretDetails {
		override val type = AuthenticationClass.ShortLivedToken
	}

	/**
	 * @param secret a long-lived token of the user.
	 */
	data class LongLivedTokenDetails(override val secret: String) : AuthSecretDetails.Cacheable {
		override val type = AuthenticationClass.LongLivedToken
	}

	/**
	 * Login using a token or other secret provided by another authentication service configured for your project.
	 *
	 * This AuthSecretDetails type can only be used if the sdk initialization provided an application id: using
	 * this AuthSecretDetails with an instance of SDK that doesn't have a configured application id will result in a
	 * runtime exception.
	 *
	 * @param configId id of the configuration to use for authentication.
	 * @param secret the token or another secret that will be used for authentication.
	 * @param minimumAuthenticationClass only consider configurations that can provide at least this authentication class. The actual
	 * authentication class obtained for the token may be higher.
	 */
	data class ConfiguredExternalAuthenticationDetails(
		val configId: String,
		override val secret: String,
		val minimumAuthenticationClass: AuthenticationClass = AuthenticationClass.ExternalAuthentication
	): AuthSecretDetails {
		override val type: AuthenticationClass get() = minimumAuthenticationClass
	}
}

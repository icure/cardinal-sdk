package com.icure.sdk.auth

import com.icure.sdk.auth.AuthenticationProcessApi.AuthenticationProcessRequest
import com.icure.sdk.model.embed.AuthenticationClass

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
	data class ShortLivedTokenDetails(override val secret: String, val authenticationProcessInfo: AuthenticationProcessRequest) : AuthSecretDetails {
		override val type = AuthenticationClass.ShortLivedToken
	}

	/**
	 * @param secret a long-lived token of the user.
	 */
	data class LongLivedTokenDetails(override val secret: String) : AuthSecretDetails.Cacheable {
		override val type = AuthenticationClass.LongLivedToken
	}

	/**
	 * @param secret some token or another secret that can be used to authenticate the user to a supported third party service
	 * @param oauthType the third party service that should recognize the provided secret.
	 */
	data class ExternalAuthenticationDetails(override val secret: String, val oauthType: ThirdPartyProvider): AuthSecretDetails.Cacheable {
		override val type = AuthenticationClass.ExternalAuthentication
	}

	/**
	 * Not yet implemented
	 */
	data class DigitalIdDetails(override val secret: String) : AuthSecretDetails {
		override val type = AuthenticationClass.DigitalId
	}
}

package com.icure.cardinal.sdk.api

interface AuthApi {
	suspend fun getBearerToken(): String

	/**
	 * Get the refresh token currently used by the sdk.
	 *
	 * The refresh token is bound to the group (and data owner scope) of this sdk instance, and can be used to initialize
	 * a new sdk instance through the `existingRefreshJwt` of [com.icure.cardinal.sdk.options.AuthenticationMethod.UsingSecretProvider],
	 * without having to provide any secret while the refresh token is valid.
	 * Note that if the user can access multiple groups, the initialization of the new sdk still requires a group selector,
	 * and the new sdk will be bound to the group chosen by the selector, regardless of the group of the refresh token.
	 */
	suspend fun getRefreshToken(): String
}

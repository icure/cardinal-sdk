package com.icure.cardinal.sdk.auth.services

import com.icure.cardinal.sdk.auth.JwtBearer
import com.icure.cardinal.sdk.auth.JwtBearerAndRefresh
import com.icure.utils.InternalIcureApi

/**
 * An [AuthProvider] is responsible for instantiating an [AuthService] for each request of the raw api.
 * In the case of all the services that share the same state across requests (e.g. the [JwtAuthProvider]), then the concrete service
 * class should also implement this interface, returning itself on [AuthProvider.getAuthService].
 */
@InternalIcureApi
interface AuthProvider {
	fun getAuthService(): AuthService

	/**
	 * Create a new authentication provider based on this to connect to a different group of the user.
	 * The newGroupId must be a group for which the authentication credentials can be used.
	 */
	suspend fun switchGroup(newGroupId: String): AuthProvider

	/**
	 * Create a new authentication provider based on this to act as a different data owner in the same group of the
	 * user.
	 */
	suspend fun changeScope(dataOwnerId: String): AuthProvider
}

@InternalIcureApi
interface JwtBasedAuthProvider : AuthProvider {
	override fun getAuthService(): TokenBasedAuthService<JwtBearer>

	/**
	 * Get the bearer and refresh tokens used by this provider.
	 * If both the bearer and refresh tokens are cached, they will be returned, even if expired.
	 * If one of the tokens is not cached the provider will try to get a new one.
	 * In case this is not possible the method will fail.
	 */
	suspend fun getBearerAndRefreshToken(): JwtBearerAndRefresh
}

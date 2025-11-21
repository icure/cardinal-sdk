package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.model.LoginCredentials
import com.icure.cardinal.sdk.model.security.jwt.JwtResponse
import com.icure.utils.InternalIcureApi
import kotlin.Long
import kotlin.String
import kotlin.Unit

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawAnonymousAuthApi {
	// region common endpoints

	suspend fun login(
		duration: Long? = null,
		loginCredentials: LoginCredentials,
		groupId: String? = null,
		applicationId: String? = null,
	): HttpResponse<JwtResponse>

	suspend fun refresh(
		refreshToken: String,
		totp: String? = null,
	): HttpResponse<JwtResponse>

	suspend fun check(loginCredentials: LoginCredentials): HttpResponse<Unit>

	suspend fun getAuthJwtPublicKey(): HttpResponse<String>
	// endregion

	// region cloud endpoints

	suspend fun switchGroup(
		refreshToken: String,
		groupId: String,
	): HttpResponse<JwtResponse>

	suspend fun loginGoogle(
		token: String,
		groupId: String? = null,
		applicationId: String? = null,
	): HttpResponse<JwtResponse>

	suspend fun loginWithExternalJwt(
		token: String,
		configId: String,
		applicationId: String,
		groupId: String? = null,
		minimumAuthenticationClass: String? = null,
	): HttpResponse<JwtResponse>

	suspend fun loginFas(
		token: String,
		groupId: String? = null,
		applicationId: String? = null,
	): HttpResponse<JwtResponse>

	suspend fun invalidateRefreshJWT(refreshToken: String): HttpResponse<Unit>
	// endregion
}

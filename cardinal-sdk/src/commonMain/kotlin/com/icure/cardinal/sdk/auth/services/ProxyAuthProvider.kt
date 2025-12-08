package com.icure.cardinal.sdk.auth.services

import com.icure.cardinal.sdk.auth.JwtBearer
import com.icure.cardinal.sdk.auth.JwtBearerAndRefresh
import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.utils.InternalIcureApi
import com.icure.cardinal.sdk.utils.RequestStatusException
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.bearerAuth

@InternalIcureApi
abstract class ProxyAuthProvider : JwtBasedAuthProvider, TokenBasedAuthService<JwtBearer> {
	override suspend fun switchGroup(newGroupId: String): AuthProvider {
		throw UnsupportedOperationException("Proxy auth provider can't be group switched")
	}

	override suspend fun changeScope(dataOwnerId: String): AuthProvider {
		throw UnsupportedOperationException("Proxy auth provider can't change scope")
	}

	override fun getAuthService(): TokenBasedAuthService<JwtBearer> = this

	override suspend fun getBearerAndRefreshToken(): JwtBearerAndRefresh {
		throw UnsupportedOperationException("Can't get bearer and refresh token from proxy auth provider")
	}

	override suspend fun setAuthenticationInRequest(
		builder: HttpRequestBuilder,
		authenticationClass: AuthenticationClass?
	) {
		builder.bearerAuth(getToken().token)
	}

	override suspend fun invalidateCurrentAuthentication(
		error: RequestStatusException,
		requiredAuthClass: AuthenticationClass?
	) {
		throw error
	}
}
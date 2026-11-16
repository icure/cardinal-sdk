package com.icure.cardinal.sdk.auth

import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.cardinal.sdk.model.LoginCredentials
import com.icure.cardinal.sdk.options.HttpSdkOptions
import com.icure.cardinal.sdk.options.RequestRetryConfiguration
import com.icure.cardinal.sdk.options.SerializationOptions
import com.icure.cardinal.sdk.options.configuredClientOrDefault
import com.icure.cardinal.sdk.options.configuredJsonOrDefault
import com.icure.cardinal.sdk.utils.ensureNonNull
import com.icure.cardinal.sdk.utils.retryWithDelays
import com.icure.utils.InternalIcureApi
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Logs [username] in on [baseUrl] with the short-lived token that a validated authentication process created.
 * The login is retried a few times, in case the backend does not see the token yet.
 */
@InternalIcureApi
internal suspend fun <T> loginWithProcessToken(
	baseUrl: String,
	projectId: String?,
	options: T,
	username: String,
	token: String,
): JwtCredentials where T : HttpSdkOptions, T : SerializationOptions {
	val rawAuthApi = RawAnonymousAuthApiImpl(
		apiUrl = baseUrl,
		RawApiConfig(
			httpClient = options.configuredClientOrDefault(),
			json = options.configuredJsonOrDefault(),
			additionalHeaders = emptyMap(),
			requestTimeout = options.requestTimeout,
			retryConfiguration = options.requestRetryConfiguration ?: RequestRetryConfiguration(),
			entityListDecodingStrategy = options.entityListDecodingStrategy,
		)
	)
	val loginResult = retryWithDelays(
		listOf(100.milliseconds, 500.milliseconds, 1.seconds)
	) {
		rawAuthApi.login(
			loginCredentials = LoginCredentials(username = username, password = token),
			applicationId = projectId
		).successBody()
	}
	return JwtCredentials(
		JwtBearer(ensureNonNull(loginResult.token) { "Successful login gave null bearer token" }),
		JwtRefresh(ensureNonNull(loginResult.refreshToken) { "Successful login gave null refresh token" }),
	)
}

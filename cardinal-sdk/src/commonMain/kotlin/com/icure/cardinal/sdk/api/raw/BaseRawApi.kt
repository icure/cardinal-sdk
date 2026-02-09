package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.auth.minAuthClassForLevel
import com.icure.cardinal.sdk.auth.services.AuthProvider
import com.icure.cardinal.sdk.auth.services.AuthService
import com.icure.cardinal.sdk.auth.services.setAuthorizationWith
import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.cardinal.sdk.options.RequestRetryConfiguration
import com.icure.cardinal.sdk.utils.RequestStatusException
import com.icure.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.plugins.timeout
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.header
import io.ktor.client.request.headers
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.TextContent
import kotlinx.coroutines.delay
import kotlinx.serialization.json.Json
import kotlin.time.Duration

@InternalIcureApi
data class RawApiConfig(
	val httpClient: HttpClient,
	val additionalHeaders: Map<String, String>,
	val requestTimeout : Duration?,
	val json: Json,
	val retryConfiguration: RequestRetryConfiguration
)

@InternalIcureApi
abstract class BaseRawApi(
	private val config: RawApiConfig
) {
	init {
		require(config.additionalHeaders.keys.none { it.lowercase() == "content-type" }) {
			"You are not allowed to specify Content-Type header: it is automatically set on each request as needed."
		}
	}

	companion object {
		internal const val ACCESS_CONTROL_KEYS_HEADER = "Icure-Access-Control-Keys"
	}

	protected open suspend fun getAccessControlKeysHeaderValues(groupId: String?): List<String>? = null

	private suspend fun HttpRequestBuilder.addAccessControlKeys(groupId: String?) {
		getAccessControlKeysHeaderValues(groupId)?.forEach {
			header(ACCESS_CONTROL_KEYS_HEADER, it)
		}
	}

	protected suspend fun get(
		authProvider: AuthProvider? = null,
		accessControlKeysGroupId: String? = null,
		block: suspend HttpRequestBuilder.() -> Unit
	) = requestAndRetryOnServerOrConnectionError(
		HttpMethod.Get,
		authProvider?.getAuthService(),
		null,
		accessControlKeysGroupId,
		block
	)

	protected suspend fun post(
		authProvider: AuthProvider? = null,
		accessControlKeysGroupId: String? = null,
		block: suspend HttpRequestBuilder.() -> Unit
	) = requestAndRetryOnServerOrConnectionError(
		HttpMethod.Post,
		authProvider?.getAuthService(),
		null,
		accessControlKeysGroupId,
		block
	)

	protected suspend fun put(
		authProvider: AuthProvider? = null,
		accessControlKeysGroupId: String? = null,
		block: suspend HttpRequestBuilder.() -> Unit
	) = requestAndRetryOnServerOrConnectionError(
		HttpMethod.Put,
		authProvider?.getAuthService(),
		null,
		accessControlKeysGroupId,
		block
	)

	protected suspend fun delete(
		authProvider: AuthProvider? = null,
		accessControlKeysGroupId: String? = null,
		block: suspend HttpRequestBuilder.() -> Unit
	) = requestAndRetryOnServerOrConnectionError(
		HttpMethod.Delete,
		authProvider?.getAuthService(),
		null,
		accessControlKeysGroupId,
		block
	)

	private tailrec suspend fun requestAndRetryOnServerOrConnectionError(
		method: HttpMethod,
		authService: AuthService?,
		authenticationClass: AuthenticationClass?,
		accessControlKeysGroupId: String?,
		block: suspend HttpRequestBuilder.() -> Unit,
		remainingRetries: Int = config.retryConfiguration.maxRetries,
		delayOnFailureMs: Long = config.retryConfiguration.initialDelay.inWholeMilliseconds
	): HttpResponse {
		val result = requestAndRetryOnUnauthorized(
			method,
			authService,
			authenticationClass,
			accessControlKeysGroupId,
		) { block() }
		return when {
			remainingRetries <= 0 -> result.getOrThrow()
			result.isFailure || result.getOrThrow().status.value in 500 .. 599 -> {
				delay(delayOnFailureMs)
				requestAndRetryOnServerOrConnectionError(
					method,
					authService,
					authenticationClass,
					accessControlKeysGroupId,
					block,
					remainingRetries - 1,
					(delayOnFailureMs * config.retryConfiguration.exponentialBackoffFactor).toLong().let { newDelay ->
						config.retryConfiguration.exponentialBackoffCeil?.inWholeMilliseconds?.let { max ->
							newDelay.coerceAtMost(max)
						} ?: newDelay
					},
				)
			}
			else -> result.getOrThrow()
		}
	}

	private suspend inline fun requestAndRetryOnUnauthorized(
		method: HttpMethod,
		authService: AuthService?,
		authenticationClass: AuthenticationClass?,
		accessControlKeysGroupId: String?,
		block: HttpRequestBuilder.() -> Unit
	): Result<HttpResponse> {
		val responseResult = request(method, authService, authenticationClass, accessControlKeysGroupId, block)
		return if (authService != null && responseResult.getOrNull()?.status == HttpStatusCode.Unauthorized) {
			val response = responseResult.getOrThrow()
			val requiredAuthClass = response.headers["Icure-Minimum-Required-Auth-Level"]?.let { minAuthClassForLevel(it.toInt()) }
			authService.invalidateCurrentAuthentication(
				RequestStatusException(
					response.call.request.method,
					response.call.request.url.toString(),
					response.status.value,
					kotlin.runCatching { response.bodyAsText() }.getOrNull(),
				),
				requiredAuthClass
			)
			request(method, authService, requiredAuthClass, accessControlKeysGroupId, block)
		} else {
			responseResult
		}
	}

	private suspend inline fun request(
		method: HttpMethod,
		authService: AuthService?,
		authenticationClass: AuthenticationClass?,
		accessControlKeysGroupId: String?,
		block: HttpRequestBuilder.() -> Unit
	): Result<HttpResponse> {
		// If the builder fails we want to fail (could happen when getting the authorization, access control keys, ...)
		val requestBuilder = HttpRequestBuilder().apply {
			this.method = method
			headers {
				config.additionalHeaders.forEach { (header, headerValue) ->
					set(header, headerValue)
				}
				set("Cardinal-Model-Standard", "true")
			}
			config.requestTimeout?.also {
				timeout {
					requestTimeoutMillis = it.inWholeMilliseconds
				}
			}
			authService?.also {
				setAuthorizationWith(it, authenticationClass)
			}
			block()
			addAccessControlKeys(accessControlKeysGroupId)
		}
		// We want to retry only for exceptions from actually executing the request
		return kotlin.runCatching { config.httpClient.request(requestBuilder) }
	}

	protected fun <T> HttpRequestBuilder.setBodyWithSerializer(
		serializer: kotlinx.serialization.KSerializer<T>,
		body: T
	) = this.setBody(
		TextContent(
			config.json.encodeToString(serializer, body),
			ContentType.Application.Json
		)
	)
}

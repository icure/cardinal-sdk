package com.icure.cardinal.sdk.auth

import com.icure.cardinal.sdk.api.raw.RawApiConfig
import com.icure.cardinal.sdk.api.raw.impl.RawAnonymousAuthApiImpl
import com.icure.cardinal.sdk.auth.services.SmartAuthProvider
import com.icure.cardinal.sdk.model.embed.AuthenticationClass
import com.icure.cardinal.sdk.options.RequestRetryConfiguration
import com.icure.cardinal.sdk.utils.RequestStatusException
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.base64Encode
import com.icure.utils.InternalIcureApi
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.toByteArray
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlin.time.Clock

private const val KRAKEN_URL = "https://kraken.test"
private const val KHERMES_URL = "https://khermes.test"
private const val PROCESS_ID = "process-1"
private const val USER = "user@example.com"
private const val VALIDATE_PATH = "/v1/$PROCESS_ID/auth/validate"
private const val LOGIN_PATH = "/rest/v2/auth/login"

/** An unsigned JWT that the SDK accepts: it only reads its expiry and its authentication class. */
private fun fakeJwt(): String {
	val exp = Clock.System.now().epochSeconds + 3600
	val payload = base64Encode("""{"exp":$exp,"tac":${AuthenticationClass.ShortLivedToken.level}}""".encodeToByteArray())
	return "e30.$payload.signature"
}

/**
 * Answers each validation with the next status of [validateStatuses], and every login with a token. Records the
 * bodies it receives, by path.
 */
@OptIn(InternalIcureApi::class)
private class FakeBackends(validateStatuses: List<HttpStatusCode>) {
	private val validateAnswers = validateStatuses.iterator()
	val bodies = mutableListOf<Pair<String, JsonElement>>()

	val client = HttpClient(
		MockEngine { request ->
			val path = request.url.encodedPath
			bodies += path to Json.parseToJsonElement(request.body.toByteArray().decodeToString())
			val (status, body) = when (path) {
				VALIDATE_PATH -> validateAnswers.next().let {
					it to if (it.value < 300) """{"results":{}}""" else """{"error":"refused"}"""
				}
				LOGIN_PATH -> HttpStatusCode.OK to """{"token":"${fakeJwt()}","refreshToken":"${fakeJwt()}","successful":true}"""
				else -> HttpStatusCode.NotFound to "{}"
			}
			respond(body, status, headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString()))
		}
	) {
		install(ContentNegotiation) { json(Serialization.json) }
	}

	fun bodiesOf(path: String) = bodies.filter { it.first == path }.map { it.second }
}

/** Gives the codes of [codes] in turn, for a Khermes request already started, and records the previous attempts it is shown. */
@OptIn(InternalIcureApi::class)
private class CodesSecretProvider(codes: List<String>) : AuthSecretProvider {
	private val codes = codes.iterator()
	val previousAttemptsSeen = mutableListOf<Int>()

	override suspend fun getSecret(
		acceptedSecrets: Set<AuthenticationClass>,
		previousAttempts: List<AuthSecretDetails>,
		authProcessApi: AuthenticationProcessApi,
	): AuthSecretDetails {
		acceptedSecrets shouldContain AuthenticationClass.ShortLivedToken
		previousAttemptsSeen += previousAttempts.size
		return AuthSecretDetails.ShortLivedTokenDetails(
			secret = codes.next(),
			authenticationProcessInfo = AuthenticationProcessRequest.Khermes(
				khermesUrl = KHERMES_URL,
				processId = PROCESS_ID,
				requestId = "request-1",
			),
		)
	}
}

@OptIn(InternalIcureApi::class)
private suspend fun authProvider(backends: FakeBackends, secretProvider: AuthSecretProvider) = SmartAuthProvider.initialize(
	authApi = RawAnonymousAuthApiImpl(
		KRAKEN_URL,
		RawApiConfig(
			httpClient = backends.client,
			additionalHeaders = emptyMap(),
			requestTimeout = null,
			json = Serialization.json,
			retryConfiguration = RequestRetryConfiguration(),
		),
	),
	loginUsername = USER,
	secretProvider = secretProvider,
	initialSecret = null,
	initialAuthToken = null,
	initialRefreshToken = null,
	groupId = null,
	projectId = null,
	cryptoService = defaultCryptoService,
	cacheSecrets = false,
	allowSecretRetry = true,
	authProcessApi = AuthenticationProcessApiImpl(backends.client, defaultCryptoService, krakenUrl = KRAKEN_URL),
	designDocSchemaVersion = null,
)

@OptIn(InternalIcureApi::class)
class KhermesShortLivedTokenTest : StringSpec({

	"A code Khermes refuses makes the secret provider give another one, and the accepted code logs the user in" {
		val backends = FakeBackends(listOf(HttpStatusCode.Unauthorized, HttpStatusCode.OK))
		val secretProvider = CodesSecretProvider(listOf("wrong2", " right2 "))

		authProvider(backends, secretProvider).getBearerAndRefreshToken()

		secretProvider.previousAttemptsSeen shouldBe listOf(0, 1)
		backends.bodiesOf(VALIDATE_PATH).map { it.jsonObject.getValue("code").jsonPrimitive.content } shouldBe listOf("WRONG2", "RIGHT2")
		val login = backends.bodiesOf(LOGIN_PATH).single().jsonObject
		login.getValue("username").jsonPrimitive.content shouldBe USER
		login.getValue("password").jsonPrimitive.content shouldBe "RIGHT2"
	}

	"An expired or already used code also makes the secret provider give another one" {
		val backends = FakeBackends(listOf(HttpStatusCode.Gone, HttpStatusCode.Conflict, HttpStatusCode.OK))
		val secretProvider = CodesSecretProvider(listOf("AAAAA2", "BBBBB2", "CCCCC2"))

		authProvider(backends, secretProvider).getBearerAndRefreshToken()

		secretProvider.previousAttemptsSeen shouldBe listOf(0, 1, 2)
		backends.bodiesOf(LOGIN_PATH).single().jsonObject.getValue("password").jsonPrimitive.content shouldBe "CCCCC2"
	}

	"A failed completion step is not a wrong code: it is thrown, without asking for another code" {
		val backends = FakeBackends(listOf(HttpStatusCode.ServiceUnavailable))
		val secretProvider = CodesSecretProvider(listOf("ABCDE2"))

		shouldThrow<RequestStatusException> {
			authProvider(backends, secretProvider).getBearerAndRefreshToken()
		}.statusCode shouldBe 503

		secretProvider.previousAttemptsSeen shouldBe listOf(0)
		backends.bodiesOf(LOGIN_PATH) shouldBe emptyList()
	}
})

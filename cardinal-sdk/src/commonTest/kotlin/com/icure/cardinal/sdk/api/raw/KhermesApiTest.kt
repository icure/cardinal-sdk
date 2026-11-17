package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.auth.AuthenticationProcessRequest
import com.icure.cardinal.sdk.auth.CaptchaOptions
import com.icure.cardinal.sdk.utils.RequestStatusException
import com.icure.kerberus.Challenge
import com.icure.kerberus.Solution
import com.icure.kerberus.validateSolution
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.utils.InternalIcureApi
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.content.TextContent
import io.ktor.http.headersOf
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

private const val KHERMES_URL = "https://khermes.test"
private const val PROCESS_ID = "process-1"
private const val USER = "user@example.com"
private const val SECRET_KEY = "kerberus-secret"

private data class RecordedRequest(val method: HttpMethod, val path: String, val body: JsonElement)

/** A fake Khermes answering each path with a status and a JSON body, and recording what it receives. */
@OptIn(InternalIcureApi::class)
private class FakeKhermes(private val answers: Map<String, Pair<HttpStatusCode, String>>) {
	val requests = mutableListOf<RecordedRequest>()

	val api = RawKhermesApi(
		HttpClient(
			MockEngine { request ->
				requests += RecordedRequest(
					request.method,
					request.url.encodedPath,
					Json.parseToJsonElement((request.body as TextContent).text),
				)
				val (status, body) = answers[request.url.encodedPath] ?: (HttpStatusCode.NotFound to """{"error":"NOT_FOUND"}""")
				respond(body, status, headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString()))
			}
		),
		defaultCryptoService,
	)
}

// A challenge small enough to be solved instantly.
// language=JSON
private const val CHALLENGE = """{"id":"challenge-1","salts":["s1","s2"],"difficultyFactor":100}"""

// The start answer, with a property this SDK does not know yet.
// language=JSON
private const val STARTED = """{"requestId":"request-1","processId":"process-1","expiresAt":1767225600000,"addedLater":true}"""

private fun JsonElement.string(key: String) = jsonObject.getValue(key).jsonPrimitive.content

@OptIn(InternalIcureApi::class)
class KhermesApiTest : StringSpec({

	"A delegated Kerberus captcha is solved for the secret key, the process and the user, then sent with the start" {
		val khermes = FakeKhermes(
			mapOf(
				"/v1/$PROCESS_ID/kerberus/challenge" to (HttpStatusCode.OK to CHALLENGE),
				"/v1/$PROCESS_ID/auth/start" to (HttpStatusCode.OK to STARTED),
			)
		)

		val request = khermes.api.startProcess(
			khermesUrl = KHERMES_URL,
			processId = PROCESS_ID,
			userTelecom = USER,
			captcha = CaptchaOptions.Kerberus.Delegated(secretKey = SECRET_KEY),
			variables = emptyMap(),
			locale = null,
		)

		request.khermesUrl shouldBe KHERMES_URL
		request.processId shouldBe PROCESS_ID
		request.requestId shouldBe "request-1"
		khermes.requests shouldHaveSize 2
		val (challengeRequest, startRequest) = khermes.requests
		challengeRequest.method shouldBe HttpMethod.Post
		challengeRequest.body shouldBe Json.parseToJsonElement("""{"loginIdentifier":"$USER"}""")
		startRequest.method shouldBe HttpMethod.Post
		startRequest.body.string("to") shouldBe USER
		startRequest.body.jsonObject.containsKey("locale") shouldBe false
		startRequest.body.jsonObject.getValue("variables") shouldBe JsonObject(emptyMap())
		val captchaSolution = startRequest.body.jsonObject.getValue("captchaSolution")
		captchaSolution.string("type") shouldBe "KERBERUS"
		captchaSolution.string("id") shouldBe "challenge-1"
		val solution = Solution(
			id = captchaSolution.string("id"),
			nonces = captchaSolution.jsonObject.getValue("nonces").jsonArray.map { it.jsonPrimitive.content },
		)
		validateSolution(
			config = Challenge(id = "challenge-1", salts = listOf("s1", "s2"), difficultyFactor = 100),
			result = solution,
			serializedInput = "$SECRET_KEY|$PROCESS_ID|$USER",
		) shouldBe true
	}

	"A delegated Kerberus captcha without a secret key fails before calling Khermes" {
		val khermes = FakeKhermes(emptyMap())

		shouldThrow<IllegalArgumentException> {
			khermes.api.startProcess(
				khermesUrl = KHERMES_URL,
				processId = PROCESS_ID,
				userTelecom = USER,
				captcha = CaptchaOptions.Kerberus.Delegated(),
				variables = emptyMap(),
				locale = null,
			)
		}.message shouldContain "secret key"
		khermes.requests.shouldBeEmpty()
	}

	"A captcha that Khermes does not support fails before calling Khermes" {
		val khermes = FakeKhermes(emptyMap())

		listOf(CaptchaOptions.Recaptcha("token"), CaptchaOptions.FriendlyCaptcha("token")).forEach { captcha ->
			shouldThrow<IllegalArgumentException> {
				khermes.api.startProcess(
					khermesUrl = KHERMES_URL,
					processId = PROCESS_ID,
					userTelecom = USER,
					captcha = captcha,
					variables = emptyMap(),
					locale = null,
				)
			}.message shouldContain "Khermes does not support"
		}
		khermes.requests.shouldBeEmpty()
	}

	"A computed Kerberus solution is sent as is, with the variables and the locale" {
		val khermes = FakeKhermes(mapOf("/v1/$PROCESS_ID/auth/start" to (HttpStatusCode.OK to STARTED)))

		khermes.api.startProcess(
			khermesUrl = KHERMES_URL,
			processId = PROCESS_ID,
			userTelecom = USER,
			captcha = CaptchaOptions.Kerberus.Computed(Solution(id = "precomputed", nonces = listOf("n1", "n2"))),
			variables = mapOf("firstName" to "Jane", "lastName" to "Doe"),
			locale = "fr",
		)

		khermes.requests shouldHaveSize 1
		khermes.requests.single().body shouldBe Json.parseToJsonElement(
			"""
			{
				"to": "$USER",
				"locale": "fr",
				"variables": {"firstName": "Jane", "lastName": "Doe"},
				"captchaSolution": {"type": "KERBERUS", "id": "precomputed", "nonces": ["n1", "n2"]}
			}
			""".trimIndent()
		)
	}

	"The process id is one path segment, after the path of the Khermes url" {
		val processId = "a/b c"
		val khermes = FakeKhermes(mapOf("/khermes/v1/a%2Fb%20c/auth/start" to (HttpStatusCode.OK to STARTED)))

		khermes.api.startProcess(
			khermesUrl = "https://khermes.test/khermes/",
			processId = processId,
			userTelecom = USER,
			captcha = CaptchaOptions.Kerberus.Computed(Solution(id = "precomputed", nonces = emptyList())),
			variables = emptyMap(),
			locale = null,
		).processId shouldBe processId

		khermes.requests.single().path shouldBe "/khermes/v1/a%2Fb%20c/auth/start"
	}

	"A validation code is trimmed and upper cased, and the code sent is the token to log in with" {
		val khermes = FakeKhermes(mapOf("/v1/$PROCESS_ID/auth/validate" to (HttpStatusCode.OK to """{"results":{}}""")))

		val token = khermes.api.completeProcess(
			AuthenticationProcessRequest.Khermes(khermesUrl = KHERMES_URL, processId = PROCESS_ID, requestId = "request-1"),
			" abc234\n",
		)

		token shouldBe "ABC234"
		khermes.requests.single().body shouldBe Json.parseToJsonElement("""{"requestId":"request-1","code":"ABC234"}""")
	}

	"A refused validation code throws a RequestStatusException with the status and the body of Khermes" {
		val khermes = FakeKhermes(
			mapOf("/v1/$PROCESS_ID/auth/validate" to (HttpStatusCode.Unauthorized to """{"error":"Invalid OTP"}"""))
		)

		val exception = shouldThrow<RequestStatusException> {
			khermes.api.completeProcess(
				AuthenticationProcessRequest.Khermes(khermesUrl = KHERMES_URL, processId = PROCESS_ID, requestId = "request-1"),
				"WRONG2",
			)
		}

		exception.statusCode shouldBe 401
		exception.body shouldBe """{"error":"Invalid OTP"}"""
	}

	"The proof-of-work input is the secret key, the process id and the user telecom, separated by pipes" {
		RawKhermesApi.kerberusInput(secretKey = "k", processId = "p", userTelecom = "+32470123456") shouldBe "k|p|+32470123456"
	}
})

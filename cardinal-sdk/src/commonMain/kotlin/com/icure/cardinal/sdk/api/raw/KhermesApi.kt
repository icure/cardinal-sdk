package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.auth.AuthenticationProcessRequest
import com.icure.cardinal.sdk.auth.CaptchaOptions
import com.icure.cardinal.sdk.utils.RequestStatusException
import com.icure.kerberus.Challenge
import com.icure.kerberus.Solution
import com.icure.kerberus.resolveChallenge
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.request.accept
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.appendPathSegments
import io.ktor.http.content.TextContent
import io.ktor.http.isSuccess
import io.ktor.http.takeFrom
import kotlinx.serialization.DeserializationStrategy
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationStrategy
import kotlinx.serialization.json.Json

/**
 * The OTP authentication routes of Khermes (`/v1/{processId}/kerberus/challenge`, `/v1/{processId}/auth/start`,
 * `/v1/{processId}/auth/validate`). All of them are public: no token is sent.
 *
 * Bodies are encoded and decoded with this class's own [Json], whatever the configuration of [client].
 */
@InternalIcureApi
class RawKhermesApi(
	private val client: HttpClient,
	private val cryptoService: CryptoService,
) {

	/**
	 * Gets a Kerberus challenge for a login of [userTelecom] on the process [processId] and solves it.
	 *
	 * @param secretKey the secret key of the Kerberus provider of the process's Spec. It is part of the proof-of-work
	 * input, so a solution computed with another key is refused.
	 */
	suspend fun solveKerberusChallenge(
		khermesUrl: String,
		processId: String,
		userTelecom: String,
		secretKey: String,
		onProgress: (Double) -> Unit,
	): Solution {
		val challenge = post(
			khermesUrl = khermesUrl,
			path = listOf(processId, "kerberus", "challenge"),
			request = KhermesChallengeRequest(loginIdentifier = userTelecom),
			requestSerializer = KhermesChallengeRequest.serializer(),
		).decode(KhermesChallenge.serializer())
		return resolveChallenge(
			Challenge(id = challenge.id, salts = challenge.salts, difficultyFactor = challenge.difficultyFactor),
			kerberusInput(secretKey = secretKey, processId = processId, userTelecom = userTelecom),
			cryptoService,
			onProgress,
		)
	}

	/**
	 * Starts the authentication process [processId] for [userTelecom]: Khermes checks the captcha and sends an OTP to
	 * [userTelecom], through the channel of the process.
	 *
	 * @param captcha the captcha. Khermes only supports [CaptchaOptions.Kerberus] for now: any other option is refused
	 * with an [IllegalArgumentException], before any call to Khermes.
	 * @param variables the values of the variables declared by the process's templates. Khermes refuses any other.
	 * @param locale the locale of the telecom template to use, or null for the default locale of the process.
	 */
	suspend fun startProcess(
		khermesUrl: String,
		processId: String,
		userTelecom: String,
		captcha: CaptchaOptions,
		variables: Map<String, String>,
		locale: String?,
	): AuthenticationProcessRequest.Khermes {
		val solution = when (captcha) {
			is CaptchaOptions.Kerberus.Computed -> captcha.solution
			is CaptchaOptions.Kerberus.Delegated -> solveKerberusChallenge(
				khermesUrl = khermesUrl,
				processId = processId,
				userTelecom = userTelecom,
				secretKey = requireNotNull(captcha.secretKey) {
					"CaptchaOptions.Kerberus.Delegated needs the secret key of the process's Kerberus provider to solve a Khermes challenge."
				},
				onProgress = captcha.onProgress ?: {},
			)
			// No else branch: a new captcha option must be handled here before the SDK compiles.
			is CaptchaOptions.Recaptcha, is CaptchaOptions.FriendlyCaptcha -> throw IllegalArgumentException(
				"Khermes does not support ${captcha::class.simpleName} captchas: use CaptchaOptions.Kerberus."
			)
		}
		val response = post(
			khermesUrl = khermesUrl,
			path = listOf(processId, "auth", "start"),
			request = KhermesStartRequest(
				to = userTelecom,
				locale = locale,
				variables = variables,
				captchaSolution = KhermesKerberusSolution(id = solution.id, nonces = solution.nonces),
			),
			requestSerializer = KhermesStartRequest.serializer(),
		).decode(KhermesStartResponse.serializer())
		return AuthenticationProcessRequest.Khermes(
			khermesUrl = khermesUrl,
			processId = processId,
			requestId = response.requestId,
		)
	}

	/**
	 * Validates [validationCode] for [request]. Once Khermes accepts it, it runs the process's completion actions
	 * before answering.
	 *
	 * Khermes codes are upper case base32 and Khermes does not normalise them, so the code is trimmed and upper cased
	 * first.
	 *
	 * @return the code as sent to Khermes, which is the password of the short-lived token the process created.
	 * @throws RequestStatusException if Khermes refuses the code (401 wrong code, 409 already used, 410 expired) or a
	 * completion action fails.
	 */
	suspend fun completeProcess(
		request: AuthenticationProcessRequest.Khermes,
		validationCode: String,
	): String {
		val code = validationCode.trim().uppercase()
		post(
			khermesUrl = request.khermesUrl,
			path = listOf(request.processId, "auth", "validate"),
			request = KhermesValidateRequest(requestId = request.requestId, code = code),
			requestSerializer = KhermesValidateRequest.serializer(),
		)
		return code
	}

	private suspend fun <T> post(
		khermesUrl: String,
		path: List<String>,
		request: T,
		requestSerializer: SerializationStrategy<T>,
	): HttpResponse {
		val response = client.post {
			url {
				takeFrom(khermesUrl.trimEnd('/'))
				appendPathSegments(listOf("v1") + path, encodeSlash = true)
			}
			accept(ContentType.Application.Json)
			setBody(TextContent(khermesJson.encodeToString(requestSerializer, request), ContentType.Application.Json))
		}
		if (!response.status.isSuccess()) {
			throw RequestStatusException(
				response.call.request.method,
				response.call.request.url.toString(),
				response.status.value,
				runCatching { response.bodyAsText() }.getOrNull(),
			)
		}
		return response
	}

	private suspend fun <T> HttpResponse.decode(deserializer: DeserializationStrategy<T>): T =
		khermesJson.decodeFromString(deserializer, bodyAsText())

	internal companion object {
		/** The proof-of-work input of a Kerberus challenge. It must match Khermes's `KerberusCaptcha.validate`. */
		fun kerberusInput(secretKey: String, processId: String, userTelecom: String): String =
			"$secretKey|$processId|$userTelecom"

		private val khermesJson = Json {
			ignoreUnknownKeys = true
			encodeDefaults = true
			explicitNulls = false
		}
	}
}

// Copies of the Khermes wire types (`com.icure.khermes.dto`) for the routes above.

@Serializable
internal data class KhermesChallengeRequest(
	val loginIdentifier: String,
)

@Serializable
internal data class KhermesChallenge(
	val id: String,
	val salts: List<String>,
	val difficultyFactor: Int,
)

@Serializable
internal data class KhermesStartRequest(
	val to: String,
	val locale: String? = null,
	val variables: Map<String, String> = emptyMap(),
	val captchaSolution: KhermesCaptchaSolution,
)

/** Khermes tells the captcha types apart by the `type` property, kotlinx-serialization's default discriminator. */
@Serializable
internal sealed interface KhermesCaptchaSolution

@Serializable
@SerialName("KERBERUS")
internal data class KhermesKerberusSolution(
	val id: String,
	val nonces: List<String>,
) : KhermesCaptchaSolution

@Serializable
internal data class KhermesStartResponse(
	val requestId: String,
	val processId: String,
	val expiresAt: Long,
)

@Serializable
internal data class KhermesValidateRequest(
	val requestId: String,
	val code: String,
)

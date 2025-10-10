package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.auth.AuthenticationProcessTelecomType
import com.icure.cardinal.sdk.auth.CaptchaOptions
import com.icure.cardinal.sdk.auth.CaptchaOptions.FriendlyCaptcha
import com.icure.cardinal.sdk.auth.CaptchaOptions.Kerberus
import com.icure.cardinal.sdk.auth.CaptchaOptions.Recaptcha
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.kerberus.Challenge
import com.icure.kerberus.resolveChallenge
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.utils.io.InternalAPI
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.encodeToJsonElement

@InternalIcureApi
class RawMessageGatewayApi(
	private val client: HttpClient,
	private val cryptoService: CryptoService
) {

	private suspend fun askChallenge(
		messageGatewayUrl: String,
		externalServicesSpecId: String,
	): Challenge {
		return client.get("${messageGatewayUrl}/${externalServicesSpecId}/challenge"){
			accept(ContentType.Application.Json)
		}.body()
	}

	@OptIn(InternalAPI::class)
	suspend fun startProcess(
		messageGatewayUrl: String,
		externalServicesSpecId: String,
		processId: String,
		captcha: CaptchaOptions,
		firstName: String?,
		lastName: String?,
		userTelecom: String,
		userTelecomType: AuthenticationProcessTelecomType,
		krakenUrl: String,
	): String {

		val requestBodyJson = JsonObject(mapOf(
			"firstName" to JsonPrimitive(firstName ?: ""),
			"lastName" to JsonPrimitive(lastName ?: ""),
			captcha.msgGwIdentifier to
			when (captcha) {
				is Recaptcha -> JsonPrimitive(captcha.solution)
				is FriendlyCaptcha -> JsonPrimitive(captcha.solution)
				is Kerberus -> Serialization.json.encodeToJsonElement(
					when(captcha) {
						is Kerberus.Computed -> captcha.solution
						is Kerberus.Delegated -> {
							val challenge = askChallenge(messageGatewayUrl, externalServicesSpecId)
							resolveChallenge(challenge, externalServicesSpecId, cryptoService, captcha.onProgress ?: {})
						}
					}
				)
			},
			"email" to JsonPrimitive(if (userTelecomType == AuthenticationProcessTelecomType.Email) userTelecom else ""),
			"mobilePhone" to JsonPrimitive(if (userTelecomType == AuthenticationProcessTelecomType.MobilePhone) userTelecom else ""),
			"deployment" to JsonPrimitive(krakenUrl),
		))
		val requestId = cryptoService.strongRandom.randomUUID()
		client.post("${messageGatewayUrl}/${externalServicesSpecId}/process/${processId}/${requestId}") {
			contentType(ContentType.Application.Json)
			setBody(requestBodyJson)
		}.wrap<String>().successBody()
		return requestId
	}

	suspend fun completeProcess(
		messageGatewayUrl: String,
		externalServicesSpecId: String,
		requestId: String,
		validationCode: String
	) {
		client.get("${messageGatewayUrl}/${externalServicesSpecId}/process/validate/${requestId}-${validationCode}").requireSuccess()
	}
}

package com.icure.cardinal.sdk.test

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.api.raw.wrap
import com.icure.cardinal.sdk.auth.services.JwtBasedAuthProvider
import com.icure.utils.InternalIcureApi
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.coroutines.delay
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonArray
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.put
import kotlin.time.Clock
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

/**
 * Khermes, and the Mailpit it sends its emails to, in the local test environment (`initializeTestEnvironment`).
 */
object KhermesTestUtils {
	/**
	 * The canonical action template that creates a token for the user in the group of the Spec, by email.
	 * `initializeTestEnvironment` writes it in Khermes' configuration database.
	 */
	const val LOGIN_IN_GROUP_EMAIL_TEMPLATE_ID = "905507e3-e1d1-4473-aa29-a7977d13d0a3"

	data class TestProcess(val processId: String, val kerberusSecretKey: String)

	data class Email(val subject: String, val html: String)

	/**
	 * Creates an authentication process that logs the user into [groupId]: a Spec of [groupId] sending its emails to
	 * Mailpit, with a Kerberus provider of a new secret key, and the process with its English email template.
	 * The subject of the email is the validation code, like the emails of the mock message gateway.
	 *
	 * @param content the body of the email, which can use variables (`{{name}}`) that `auth/start` then accepts.
	 */
	suspend fun createLoginProcess(
		groupId: String = testGroupId,
		content: String = "<p>{{validationCode}}</p>",
	): TestProcess {
		val jwt = groupAdminJwt()
		val kerberusSecretKey = uuid()
		val specId = post(
			"/v1/specs",
			jwt,
			buildJsonObject {
				put("groupId", groupId)
				put("telecomProviders", buildJsonArray {
					add(buildJsonObject {
						put("providerType", "SMTP")
						put("from", "noreply@khermes.test")
						put("host", "mailpit")
						put("port", 1025)
						put("secure", false)
						put("username", "")
						put("password", "")
					})
				})
				put("captchaProviders", buildJsonArray {
					// Khermes calls the Kerberus secret key `apiKey`.
					add(buildJsonObject {
						put("type", "KERBERUS")
						put("apiKey", kerberusSecretKey)
					})
				})
			}
		).getValue("id").jsonPrimitive.content
		val processId = post(
			"/v1/processes",
			jwt,
			buildJsonObject {
				put("processType", "AUTHENTICATION")
				put("specId", specId)
				put("groupId", groupId)
				put("actionTemplateId", LOGIN_IN_GROUP_EMAIL_TEMPLATE_ID)
			}
		).getValue("id").jsonPrimitive.content
		post(
			"/v1/$processId/template",
			jwt,
			buildJsonObject {
				put("channelType", "EMAIL")
				put("locale", "en")
				put("subject", "{{validationCode}}")
				put("content", content)
			}
		)
		return TestProcess(processId = processId, kerberusSecretKey = kerberusSecretKey)
	}

	/**
	 * The latest email sent to [to], once Mailpit has received at least [count] emails for [to]: Khermes answers
	 * `auth/start` before it sends the email.
	 */
	@OptIn(InternalIcureApi::class)
	suspend fun waitForEmail(to: String, count: Int = 1): Email {
		val deadline = Clock.System.now() + 60.seconds
		while (true) {
			val messages = CardinalSdk.sharedHttpClient.get("$mailpitUrl/api/v1/search") {
				parameter("query", "to:\"$to\"")
			}.wrap<JsonObject>().successBody().getValue("messages").jsonArray
			if (messages.size >= count) {
				// Newest first
				val id = messages.first().jsonObject.getValue("ID").jsonPrimitive.content
				val message = CardinalSdk.sharedHttpClient.get("$mailpitUrl/api/v1/message/$id")
					.wrap<JsonObject>().successBody()
				return Email(
					subject = message.getValue("Subject").jsonPrimitive.content,
					html = message.getValue("HTML").jsonPrimitive.content,
				)
			}
			check(Clock.System.now() < deadline) { "Mailpit received ${messages.size} emails for $to, expected $count" }
			delay(250.milliseconds)
		}
	}

	/** A validation code of the same format as [code], but another one. */
	fun wrongCode(code: String): String = (if (code.first() == 'A') "B" else "A") + code.drop(1)

	/** A JWT of the admin of the test group: Khermes lets the admins of a group (or of a parent) administer it. */
	@OptIn(InternalIcureApi::class)
	private suspend fun groupAdminJwt(): String =
		(testGroupAdminAuth() as JwtBasedAuthProvider).getBearerAndRefreshToken().bearer.token

	@OptIn(InternalIcureApi::class)
	private suspend fun post(path: String, jwt: String, body: JsonObject): JsonObject =
		CardinalSdk.sharedHttpClient.post("$khermesUrl$path") {
			bearerAuth(jwt)
			contentType(ContentType.Application.Json)
			setBody(body)
		}.wrap<JsonObject>().successBody()
}

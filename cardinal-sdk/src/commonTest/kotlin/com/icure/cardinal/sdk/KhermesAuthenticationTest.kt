package com.icure.cardinal.sdk

import com.icure.cardinal.sdk.auth.CaptchaOptions
import com.icure.cardinal.sdk.auth.KhermesCaptcha
import com.icure.cardinal.sdk.storage.impl.VolatileStorageFacade
import com.icure.cardinal.sdk.test.KhermesTestUtils
import com.icure.cardinal.sdk.test.baseUrl
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.khermesUrl
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.LOCAL_ENV_ONLY
import com.icure.cardinal.sdk.utils.RequestStatusException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import kotlinx.coroutines.cancel

/**
 * Authentication through a Khermes process, against the Khermes of the local test environment.
 */
class KhermesAuthenticationTest : StringSpec({
	beforeAny { initializeTestEnvironment() }

	"A user initializes an sdk through a Khermes process, with a delegated Kerberus captcha".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val hcp = createHcpUser()
		val process = KhermesTestUtils.createLoginProcess()
		val step = CardinalSdk.initializeWithProcess(
			projectId = null,
			baseUrl = baseUrl,
			khermesUrl = khermesUrl,
			processId = process.processId,
			userTelecom = hcp.testEmail,
			captcha = CaptchaOptions.Kerberus.Delegated(secretKey = process.kerberusSecretKey),
			baseStorage = VolatileStorageFacade(),
		)
		val sdk = step.completeAuthentication(KhermesTestUtils.waitForEmail(hcp.testEmail).subject)
		sdk.user.getCurrentUser().login shouldBe hcp.username
		sdk.scope.cancel()
	}

	"A user initializes a base sdk through a Khermes process, with a Kerberus solution computed beforehand".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val hcp = createHcpUser()
		val process = KhermesTestUtils.createLoginProcess()
		val solution = KhermesCaptcha.solveKerberusChallenge(
			khermesUrl = khermesUrl,
			processId = process.processId,
			userTelecom = hcp.testEmail,
			secretKey = process.kerberusSecretKey,
		)
		val step = CardinalBaseSdk.initializeWithProcess(
			projectId = null,
			baseUrl = baseUrl,
			khermesUrl = khermesUrl,
			processId = process.processId,
			userTelecom = hcp.testEmail,
			captcha = CaptchaOptions.Kerberus.Computed(solution),
		)
		val sdk = step.completeAuthentication(KhermesTestUtils.waitForEmail(hcp.testEmail).subject)
		sdk.user.getCurrentUser().login shouldBe hcp.username
	}

	"After a wrong code, the step can complete with the right one, typed in lower case".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val hcp = createHcpUser()
		val process = KhermesTestUtils.createLoginProcess()
		val step = CardinalSdk.initializeWithProcess(
			projectId = null,
			baseUrl = baseUrl,
			khermesUrl = khermesUrl,
			processId = process.processId,
			userTelecom = hcp.testEmail,
			captcha = CaptchaOptions.Kerberus.Delegated(secretKey = process.kerberusSecretKey),
			baseStorage = VolatileStorageFacade(),
		)
		val code = KhermesTestUtils.waitForEmail(hcp.testEmail).subject
		shouldThrow<RequestStatusException> {
			step.completeAuthentication(KhermesTestUtils.wrongCode(code))
		}.statusCode shouldBe 401
		val sdk = step.completeAuthentication(code.lowercase())
		sdk.user.getCurrentUser().login shouldBe hcp.username
		sdk.scope.cancel()
	}

	"The variables are given to the email template".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val hcp = createHcpUser()
		val process = KhermesTestUtils.createLoginProcess(content = "<p>Hello {{firstName}}, your code is {{validationCode}}</p>")
		CardinalSdk.initializeWithProcess(
			projectId = null,
			baseUrl = baseUrl,
			khermesUrl = khermesUrl,
			processId = process.processId,
			userTelecom = hcp.testEmail,
			captcha = CaptchaOptions.Kerberus.Delegated(secretKey = process.kerberusSecretKey),
			baseStorage = VolatileStorageFacade(),
			variables = mapOf("firstName" to "Jane"),
			locale = "en",
		)
		KhermesTestUtils.waitForEmail(hcp.testEmail).html shouldContain "Hello Jane"
	}

	"Khermes refuses a variable that the templates of the process don't declare".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val hcp = createHcpUser()
		val process = KhermesTestUtils.createLoginProcess()
		val exception = shouldThrow<RequestStatusException> {
			CardinalSdk.initializeWithProcess(
				projectId = null,
				baseUrl = baseUrl,
				khermesUrl = khermesUrl,
				processId = process.processId,
				userTelecom = hcp.testEmail,
				captcha = CaptchaOptions.Kerberus.Delegated(secretKey = process.kerberusSecretKey),
				baseStorage = VolatileStorageFacade(),
				variables = mapOf("firstName" to "Jane"),
			)
		}
		exception.statusCode shouldBe 400
		exception.body shouldContain "firstName"
	}
})

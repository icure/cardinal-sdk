package com.icure.cardinal.sdk

import com.icure.cardinal.sdk.auth.AuthenticationProcessTelecomType
import com.icure.cardinal.sdk.auth.CaptchaOptions
import com.icure.cardinal.sdk.storage.impl.VolatileStorageFacade
import com.icure.cardinal.sdk.test.MockMessageGatewayUtils
import com.icure.cardinal.sdk.test.baseUrl
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.mockMessageGatewayUrl
import com.icure.cardinal.sdk.test.mockSpecId
import com.icure.cardinal.sdk.test.testGroupId
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.cardinal.sdk.utils.LOCAL_ENV_ONLY
import io.kotest.core.spec.style.StringSpec
import kotlinx.coroutines.cancel

class SdkAuthenticationTest : StringSpec({
	beforeAny { initializeTestEnvironment() }

	"A user should be able to initialize an sdk using an authentication process".config(enabled = DEFAULT_ENABLED && LOCAL_ENV_ONLY) {
		val hcpDetails = createHcpUser()
		val processId = MockMessageGatewayUtils.createTestProcess(
			groupId = testGroupId,
			hcpId = hcpDetails.dataOwnerId,
			userType = MockMessageGatewayUtils.UserType.Hcp
		)
		val authStep = CardinalSdk.initializeWithProcess(
			null,
			baseUrl,
			mockMessageGatewayUrl,
			mockSpecId,
			processId,
			AuthenticationProcessTelecomType.Email,
			hcpDetails.testEmail,
			CaptchaOptions.Recaptcha("onMock"),
			VolatileStorageFacade()
		)
		val authCode = MockMessageGatewayUtils.getLatestEmailTo(hcpDetails.testEmail).subject
		val sdk = authStep.completeAuthentication(authCode)
		sdk.user.getCurrentUser()
		sdk.scope.cancel()
	}
})
package com.icure.cardinal.sdk.api.raw

import com.icure.cardinal.sdk.CardinalSdk
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class HttpResponseTest : StringSpec({
	val specJob = autoCancelJob()
	lateinit var api: CardinalSdk

	beforeSpec {
		initializeTestEnvironment()
		val hcpDetails = createHcpUser()
		api = hcpDetails.api(specJob)
	}

	"Can receive a null response body".config(enabled = DEFAULT_ENABLED) {
		api.code.getCodeByRegionLanguageTypeLabel(uuid(), uuid(), uuid(), uuid()) shouldBe null
	}

	"Can receive 404 error as null".config(enabled = DEFAULT_ENABLED) {
		api.document.getDocument(uuid()) shouldBe null
	}
})

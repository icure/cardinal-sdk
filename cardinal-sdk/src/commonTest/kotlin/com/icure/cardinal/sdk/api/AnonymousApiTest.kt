package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.kryptom.crypto.defaultCryptoService
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class  AnonymousApiTest : StringSpec({
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	"It is possible to retrieve all the permissions".config(enabled = DEFAULT_ENABLED) {
		val hcpDetails = createHcpUser()
		val api = hcpDetails.api(specJob)

		api.anonymous.role.getPermissions().shouldNotBeEmpty()
	}

})

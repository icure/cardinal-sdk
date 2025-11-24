package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.uuid
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.kryptom.crypto.defaultCryptoService
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe

class  ByteArrayPayloadTest : StringSpec({
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	"It is possible to send a ByteArray payload and retrieve it".config(enabled = DEFAULT_ENABLED) {
		val hcpDetails = createHcpUser()
		val api = hcpDetails.api(specJob)
		val hcpUser = api.user.getCurrentUser()

		val newDocument = api.document.withEncryptionMetadataUnlinked(
            base = DecryptedDocument(id = uuid(), name = uuid()),
            user = hcpUser
		)
		val createdDocument = api.document.createDocument(newDocument)

		val payload = defaultCryptoService.strongRandom.randomBytes(2000)
		val uti = "com.microsoft.windows-executable"

		val updatedDocument = api.document.setRawMainAttachment(
			documentId = createdDocument.id,
			rev = createdDocument.rev.shouldNotBeNull(),
			utis = listOf(uti),
			attachment = payload,
			encrypted = false
		)

		val retrievedRawPayload = api.document.getRawMainAttachment(
			documentId = updatedDocument.id,
		)

		retrievedRawPayload.toList() shouldBe payload.toList()
	}

})

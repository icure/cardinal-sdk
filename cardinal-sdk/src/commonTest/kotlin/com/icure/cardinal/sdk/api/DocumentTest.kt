package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.test.autoCancelJob
import com.icure.cardinal.sdk.test.createHcpUser
import com.icure.cardinal.sdk.test.initializeTestEnvironment
import com.icure.cardinal.sdk.test.shouldBeNextRevOf
import com.icure.cardinal.sdk.utils.DEFAULT_ENABLED
import com.icure.kryptom.crypto.defaultCryptoService
import com.icure.kryptom.utils.toHexString
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import kotlin.random.Random

class DocumentTest : StringSpec({
	val specJob = autoCancelJob()

	beforeSpec {
		initializeTestEnvironment()
	}

	"Should be able to create document and set attachment with chosen uti".config(enabled = DEFAULT_ENABLED) {
		val api = createHcpUser().api(specJob)
		val doc = api.document.createDocument(
			api.document.withEncryptionMetadataUnlinked(
                base = DecryptedDocument(
                    id = defaultCryptoService.strongRandom.randomUUID()
                ),
			)
		)
		val mainUti = "public.plain-text"
		val otherUtis = listOf("public.text", "icure.text")
		val textAttachment = Random.Default.nextBytes(32).toHexString()
		val updatedDoc = api.document.encryptAndSetMainAttachment(
			doc,
			listOf(mainUti) + otherUtis,
			textAttachment.encodeToByteArray()
		)
		updatedDoc.rev shouldNotBe doc.rev
		updatedDoc.mainUti shouldBe mainUti
		updatedDoc.otherUtis shouldBe otherUtis
		api.document.getRawMainAttachment(doc.id).toList() shouldNotBe textAttachment.encodeToByteArray().toList()
		api.document.getAndDecryptMainAttachment(doc).decodeToString() shouldBe textAttachment
	}

	"Modifying a document after setting the attachment should preserve the attachment".config(enabled = DEFAULT_ENABLED) {
		val api = createHcpUser().api(specJob)
		val doc = api.document.createDocument(
			api.document.withEncryptionMetadataUnlinked(
                base = DecryptedDocument(
                    id = defaultCryptoService.strongRandom.randomUUID()
                ),
			)
		)
		val textAttachment = Random.Default.nextBytes(32).toHexString()
		val docWithAttachment = api.document.encryptAndSetMainAttachment(
			doc,
			null,
			textAttachment.encodeToByteArray()
		)
		docWithAttachment.rev shouldNotBe doc.rev
		api.document.getAndDecryptMainAttachment(doc).decodeToString() shouldBe textAttachment
		val name = "New document name"
		val updatedDoc = api.document.modifyDocument(api.document.decrypt(docWithAttachment).copy(name = name))
		updatedDoc.name shouldBe name
		updatedDoc.rev shouldBeNextRevOf docWithAttachment.rev
		api.document.getAndDecryptMainAttachment(updatedDoc).decodeToString() shouldBe textAttachment
	}
})

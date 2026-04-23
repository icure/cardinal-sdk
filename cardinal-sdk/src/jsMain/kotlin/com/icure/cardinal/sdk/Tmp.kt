package com.icure.cardinal.sdk

import com.icure.cardinal.sdk.auth.UsernameLongToken
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.options.AuthenticationMethod
import com.icure.cardinal.sdk.storage.impl.VolatileStorageFacade
import com.icure.kryptom.crypto.defaultCryptoService
import kotlinx.coroutines.cancel
import kotlin.random.Random

suspend fun main() {
	val sdk = CardinalSdk.initialize(
		null,
		"https://nightly.icure.cloud",
		AuthenticationMethod.UsingCredentials(UsernameLongToken("luca+xi@icure.com", "ad36de6c-0c79-47a1-a642-8d58b633a8f6")),
		VolatileStorageFacade(),
	)
	try {
		val doc = sdk.document.createDocument(
			sdk.document.withEncryptionMetadataUnlinked(
				base = DecryptedDocument(
					id = defaultCryptoService.strongRandom.randomUUID()
				),
			)
		)
		println("AAAA")
		val ilikebigbytes = Random.nextBytes(128 * 1024 * 1024)
		println("BBBB")
		sdk.document.encryptAndSetMainAttachment(
			doc,
			emptyList(),
			ilikebigbytes
		)
		println("Done")
	} finally {
		sdk.scope.cancel()
		CardinalSdk.closeSharedClient()
	}
}
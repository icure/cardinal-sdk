// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object PropertyStubDecryptor :
	AbstractEntityDecryptor<EncryptedPropertyStub, DecryptedPropertyStub>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedPropertyStub,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedPropertyStub {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedPropertyStub(
				id =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["id"]?.also { usedEncryptedContent += "id" },
						encryptedEntity.id,
						decryptedJsonStrictness,
					),
				type =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["type"]?.also { usedEncryptedContent += "type" },
						encryptedEntity.type,
						decryptedJsonStrictness,
					),
				typedValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["typedValue"]?.also { usedEncryptedContent += "typedValue" },
						encryptedEntity.typedValue?.let {
							TypedValueDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = it,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The PropertyStub encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedTelecom
import com.icure.cardinal.sdk.model.embed.EncryptedTelecom
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object TelecomDecryptor : AbstractEntityDecryptor<EncryptedTelecom, DecryptedTelecom>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedTelecom,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedTelecom {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedTelecom(
				telecomType =
					decryptedContent["telecomType"].let {
						if (it != null) {
							usedEncryptedContent += "telecomType"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.telecomType
						}
					},
				telecomNumber =
					decryptedContent["telecomNumber"].let {
						if (it != null) {
							usedEncryptedContent += "telecomNumber"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.telecomNumber
						}
					},
				telecomDescription =
					decryptedContent["telecomDescription"].let {
						if (it != null) {
							usedEncryptedContent += "telecomDescription"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.telecomDescription
						}
					},
				encryptedSelf = encryptedEntity.encryptedSelf,
				extensions = encryptedEntity.extensions,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Telecom encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

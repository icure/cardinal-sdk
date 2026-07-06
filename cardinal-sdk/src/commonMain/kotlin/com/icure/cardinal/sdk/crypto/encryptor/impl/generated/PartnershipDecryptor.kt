// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedPartnership
import com.icure.cardinal.sdk.model.embed.EncryptedPartnership
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object PartnershipDecryptor :
	AbstractEntityDecryptor<EncryptedPartnership, DecryptedPartnership>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedPartnership,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedPartnership {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedPartnership(
				type =
					decryptedContent["type"].let {
						if (it != null) {
							usedEncryptedContent += "type"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.type
						}
					},
				status =
					decryptedContent["status"].let {
						if (it != null) {
							usedEncryptedContent += "status"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.status
						}
					},
				partnerId =
					decryptedContent["partnerId"].let {
						if (it != null) {
							usedEncryptedContent += "partnerId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.partnerId
						}
					},
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Partnership encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedEmploymentInfo
import com.icure.cardinal.sdk.model.embed.EncryptedEmploymentInfo
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object EmploymentInfoDecryptor :
	AbstractEntityDecryptor<EncryptedEmploymentInfo, DecryptedEmploymentInfo>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedEmploymentInfo,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedEmploymentInfo {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedEmploymentInfo(
				startDate =
					decryptedContent["startDate"].let {
						if (it != null) {
							usedEncryptedContent += "startDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.startDate
						}
					},
				endDate =
					decryptedContent["endDate"].let {
						if (it != null) {
							usedEncryptedContent += "endDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.endDate
						}
					},
				professionType =
					decryptedContent["professionType"].let {
						if (it != null) {
							usedEncryptedContent += "professionType"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.professionType
						}
					},
				employer =
					decryptedContent["employer"].let {
						if (it != null) {
							usedEncryptedContent += "employer"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.employer
						}
					},
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The EmploymentInfo encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

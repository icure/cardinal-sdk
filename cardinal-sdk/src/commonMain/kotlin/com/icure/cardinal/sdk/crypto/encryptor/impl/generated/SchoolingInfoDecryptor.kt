// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedSchoolingInfo
import com.icure.cardinal.sdk.model.embed.EncryptedSchoolingInfo
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object SchoolingInfoDecryptor :
	AbstractEntityDecryptor<EncryptedSchoolingInfo, DecryptedSchoolingInfo>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedSchoolingInfo,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedSchoolingInfo {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedSchoolingInfo(
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
				school =
					decryptedContent["school"].let {
						if (it != null) {
							usedEncryptedContent += "school"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.school
						}
					},
				typeOfEducation =
					decryptedContent["typeOfEducation"].let {
						if (it != null) {
							usedEncryptedContent += "typeOfEducation"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.typeOfEducation
						}
					},
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The SchoolingInfo encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

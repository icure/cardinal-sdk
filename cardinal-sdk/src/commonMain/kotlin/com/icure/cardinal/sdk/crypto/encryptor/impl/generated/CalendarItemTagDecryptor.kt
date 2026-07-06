// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedCalendarItemTag
import com.icure.cardinal.sdk.model.embed.EncryptedCalendarItemTag
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object CalendarItemTagDecryptor :
	AbstractEntityDecryptor<EncryptedCalendarItemTag, DecryptedCalendarItemTag>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedCalendarItemTag,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedCalendarItemTag {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedCalendarItemTag(
				code =
					decryptedContent["code"].let {
						if (it != null) {
							usedEncryptedContent += "code"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.code
						}
					},
				date =
					decryptedContent["date"].let {
						if (it != null) {
							usedEncryptedContent += "date"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.date
						}
					},
				userId =
					decryptedContent["userId"].let {
						if (it != null) {
							usedEncryptedContent += "userId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.userId
						}
					},
				userName =
					decryptedContent["userName"].let {
						if (it != null) {
							usedEncryptedContent += "userName"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.userName
						}
					},
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The CalendarItemTag encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

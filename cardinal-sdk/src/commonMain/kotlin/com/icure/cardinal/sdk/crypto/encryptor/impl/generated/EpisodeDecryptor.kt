// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedEpisode
import com.icure.cardinal.sdk.model.embed.EncryptedEpisode
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object EpisodeDecryptor : AbstractEntityDecryptor<EncryptedEpisode, DecryptedEpisode>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedEpisode,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedEpisode {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedEpisode(
				id = encryptedEntity.id,
				name =
					decryptedContent["name"].let {
						if (it != null) {
							usedEncryptedContent += "name"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.name
						}
					},
				comment =
					decryptedContent["comment"].let {
						if (it != null) {
							usedEncryptedContent += "comment"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.comment
						}
					},
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
				encryptedSelf = encryptedEntity.encryptedSelf,
				extensions = encryptedEntity.extensions,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Episode encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

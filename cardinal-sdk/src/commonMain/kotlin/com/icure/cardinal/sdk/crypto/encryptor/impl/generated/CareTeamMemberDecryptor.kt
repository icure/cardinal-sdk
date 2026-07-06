// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMember
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMember
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object CareTeamMemberDecryptor :
	AbstractEntityDecryptor<EncryptedCareTeamMember, DecryptedCareTeamMember>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedCareTeamMember,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedCareTeamMember {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedCareTeamMember(
				id = encryptedEntity.id,
				careTeamMemberType =
					decryptedContent["careTeamMemberType"].let {
						if (it != null) {
							usedEncryptedContent += "careTeamMemberType"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.careTeamMemberType
						}
					},
				healthcarePartyId =
					decryptedContent["healthcarePartyId"].let {
						if (it != null) {
							usedEncryptedContent += "healthcarePartyId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.healthcarePartyId
						}
					},
				quality =
					decryptedContent["quality"].let {
						if (it != null) {
							usedEncryptedContent += "quality"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.quality
						}
					},
				encryptedSelf = encryptedEntity.encryptedSelf,
				extensions = encryptedEntity.extensions,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The CareTeamMember encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMembership
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMembership
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object CareTeamMembershipDecryptor :
	AbstractEntityDecryptor<EncryptedCareTeamMembership, DecryptedCareTeamMembership>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedCareTeamMembership,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedCareTeamMembership {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedCareTeamMembership(
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
				careTeamMemberId =
					decryptedContent["careTeamMemberId"].let {
						if (it != null) {
							usedEncryptedContent += "careTeamMemberId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.careTeamMemberId
						}
					},
				membershipType =
					decryptedContent["membershipType"].let {
						if (it != null) {
							usedEncryptedContent += "membershipType"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.membershipType
						}
					},
				encryptedSelf = encryptedEntity.encryptedSelf,
				extensions = encryptedEntity.extensions,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The CareTeamMembership encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

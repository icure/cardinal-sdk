// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMembership
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMembership
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object CareTeamMembershipDecryptor :
	AbstractEntityDecryptor<EncryptedCareTeamMembership, DecryptedCareTeamMembership>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedCareTeamMembership,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
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
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["startDate"]?.also { usedEncryptedContent += "startDate" },
						encryptedEntity.startDate,
						decryptedJsonStrictness,
					),
				endDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["endDate"]?.also { usedEncryptedContent += "endDate" },
						encryptedEntity.endDate,
						decryptedJsonStrictness,
					),
				careTeamMemberId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["careTeamMemberId"]?.also { usedEncryptedContent += "careTeamMemberId" },
						encryptedEntity.careTeamMemberId,
						decryptedJsonStrictness,
					),
				membershipType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["membershipType"]?.also { usedEncryptedContent += "membershipType" },
						encryptedEntity.membershipType,
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
				extensions = encryptedEntity.extensions,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The CareTeamMembership encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedCareTeamMember
import com.icure.cardinal.sdk.model.embed.EncryptedCareTeamMember
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object CareTeamMemberDecryptor :
	AbstractEntityDecryptor<EncryptedCareTeamMember, DecryptedCareTeamMember>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedCareTeamMember,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
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
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["careTeamMemberType"]?.also { usedEncryptedContent += "careTeamMemberType" },
						encryptedEntity.careTeamMemberType,
						decryptedJsonStrictness,
					),
				healthcarePartyId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["healthcarePartyId"]?.also { usedEncryptedContent += "healthcarePartyId" },
						encryptedEntity.healthcarePartyId,
						decryptedJsonStrictness,
					),
				quality =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["quality"]?.also { usedEncryptedContent += "quality" },
						encryptedEntity.quality,
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
				extensions = encryptedEntity.extensions,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The CareTeamMember encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

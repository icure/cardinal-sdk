// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedPartnership
import com.icure.cardinal.sdk.model.embed.EncryptedPartnership
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object PartnershipDecryptor :
	AbstractEntityDecryptor<EncryptedPartnership, DecryptedPartnership>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedPartnership,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
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
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["type"]?.also { usedEncryptedContent += "type" },
						encryptedEntity.type,
						decryptedJsonStrictness,
					),
				status =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["status"]?.also { usedEncryptedContent += "status" },
						encryptedEntity.status,
						decryptedJsonStrictness,
					),
				partnerId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["partnerId"]?.also { usedEncryptedContent += "partnerId" },
						encryptedEntity.partnerId,
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Partnership encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

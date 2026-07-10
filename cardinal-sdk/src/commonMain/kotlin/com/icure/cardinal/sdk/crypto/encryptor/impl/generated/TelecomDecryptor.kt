// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedTelecom
import com.icure.cardinal.sdk.model.embed.EncryptedTelecom
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object TelecomDecryptor : AbstractEntityDecryptor<EncryptedTelecom, DecryptedTelecom>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedTelecom,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedTelecom {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedTelecom(
				telecomType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["telecomType"]?.also { usedEncryptedContent += "telecomType" },
						encryptedEntity.telecomType,
						decryptedJsonStrictness,
					),
				telecomNumber =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["telecomNumber"]?.also { usedEncryptedContent += "telecomNumber" },
						encryptedEntity.telecomNumber,
						decryptedJsonStrictness,
					),
				telecomDescription =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["telecomDescription"]?.also { usedEncryptedContent += "telecomDescription" },
						encryptedEntity.telecomDescription,
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
				extensions = encryptedEntity.extensions,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Telecom encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

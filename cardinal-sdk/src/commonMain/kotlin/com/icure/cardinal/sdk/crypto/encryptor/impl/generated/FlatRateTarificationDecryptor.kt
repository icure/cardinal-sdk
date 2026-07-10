// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedFlatRateTarification
import com.icure.cardinal.sdk.model.embed.EncryptedFlatRateTarification
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object FlatRateTarificationDecryptor :
	AbstractEntityDecryptor<EncryptedFlatRateTarification, DecryptedFlatRateTarification>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedFlatRateTarification,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedFlatRateTarification {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedFlatRateTarification(
				code =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["code"]?.also { usedEncryptedContent += "code" },
						encryptedEntity.code,
						decryptedJsonStrictness,
					),
				flatRateType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["flatRateType"]?.also { usedEncryptedContent += "flatRateType" },
						encryptedEntity.flatRateType,
						decryptedJsonStrictness,
					),
				label =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["label"]?.also { usedEncryptedContent += "label" },
						encryptedEntity.label,
						decryptedJsonStrictness,
					),
				valorisations =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["valorisations"]?.also { usedEncryptedContent += "valorisations" },
						encryptedEntity.valorisations.map { x0 ->
							ValorisationDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The FlatRateTarification encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedInsurability
import com.icure.cardinal.sdk.model.embed.EncryptedInsurability
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object InsurabilityDecryptor :
	AbstractEntityDecryptor<EncryptedInsurability, DecryptedInsurability>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedInsurability,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedInsurability {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedInsurability(
				parameters =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["parameters"]?.also { usedEncryptedContent += "parameters" },
						encryptedEntity.parameters,
						decryptedJsonStrictness,
					),
				hospitalisation =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["hospitalisation"]?.also { usedEncryptedContent += "hospitalisation" },
						encryptedEntity.hospitalisation,
						decryptedJsonStrictness,
					),
				ambulatory =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["ambulatory"]?.also { usedEncryptedContent += "ambulatory" },
						encryptedEntity.ambulatory,
						decryptedJsonStrictness,
					),
				dental =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["dental"]?.also { usedEncryptedContent += "dental" },
						encryptedEntity.dental,
						decryptedJsonStrictness,
					),
				identificationNumber =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["identificationNumber"]?.also { usedEncryptedContent += "identificationNumber" },
						encryptedEntity.identificationNumber,
						decryptedJsonStrictness,
					),
				insuranceId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["insuranceId"]?.also { usedEncryptedContent += "insuranceId" },
						encryptedEntity.insuranceId,
						decryptedJsonStrictness,
					),
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
				titularyId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["titularyId"]?.also { usedEncryptedContent += "titularyId" },
						encryptedEntity.titularyId,
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
				extensions = encryptedEntity.extensions,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Insurability encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

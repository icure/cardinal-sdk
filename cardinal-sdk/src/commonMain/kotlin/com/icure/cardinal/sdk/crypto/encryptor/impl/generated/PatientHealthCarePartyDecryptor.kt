// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedPatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.EncryptedPatientHealthCareParty
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object PatientHealthCarePartyDecryptor :
	AbstractEntityDecryptor<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedPatientHealthCareParty,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedPatientHealthCareParty {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedPatientHealthCareParty(
				type =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["type"]?.also { usedEncryptedContent += "type" },
						encryptedEntity.type,
						decryptedJsonStrictness,
					),
				healthcarePartyId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["healthcarePartyId"]?.also { usedEncryptedContent += "healthcarePartyId" },
						encryptedEntity.healthcarePartyId,
						decryptedJsonStrictness,
					),
				sendFormats =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["sendFormats"]?.also { usedEncryptedContent += "sendFormats" },
						encryptedEntity.sendFormats,
						decryptedJsonStrictness,
					),
				referralPeriods =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["referralPeriods"]?.also { usedEncryptedContent += "referralPeriods" },
						encryptedEntity.referralPeriods,
						decryptedJsonStrictness,
					),
				properties =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["properties"]?.also { usedEncryptedContent += "properties" },
						encryptedEntity.properties?.let {
							it.mapTo(mutableSetOf()) { x0 ->
								PropertyStubDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									decryptedJsonStrictness = decryptedJsonStrictness,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						},
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The PatientHealthCareParty encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

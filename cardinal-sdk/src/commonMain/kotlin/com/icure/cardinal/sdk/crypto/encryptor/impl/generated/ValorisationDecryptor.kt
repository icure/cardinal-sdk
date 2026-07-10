// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedValorisation
import com.icure.cardinal.sdk.model.embed.EncryptedValorisation
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object ValorisationDecryptor :
	AbstractEntityDecryptor<EncryptedValorisation, DecryptedValorisation>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedValorisation,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedValorisation {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedValorisation(
				startOfValidity =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["startOfValidity"]?.also { usedEncryptedContent += "startOfValidity" },
						encryptedEntity.startOfValidity,
						decryptedJsonStrictness,
					),
				endOfValidity =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["endOfValidity"]?.also { usedEncryptedContent += "endOfValidity" },
						encryptedEntity.endOfValidity,
						decryptedJsonStrictness,
					),
				predicate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["predicate"]?.also { usedEncryptedContent += "predicate" },
						encryptedEntity.predicate,
						decryptedJsonStrictness,
					),
				reference =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["reference"]?.also { usedEncryptedContent += "reference" },
						encryptedEntity.reference,
						decryptedJsonStrictness,
					),
				totalAmount =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["totalAmount"]?.also { usedEncryptedContent += "totalAmount" },
						encryptedEntity.totalAmount,
						decryptedJsonStrictness,
					),
				reimbursement =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["reimbursement"]?.also { usedEncryptedContent += "reimbursement" },
						encryptedEntity.reimbursement,
						decryptedJsonStrictness,
					),
				patientIntervention =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["patientIntervention"]?.also { usedEncryptedContent += "patientIntervention" },
						encryptedEntity.patientIntervention,
						decryptedJsonStrictness,
					),
				doctorSupplement =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["doctorSupplement"]?.also { usedEncryptedContent += "doctorSupplement" },
						encryptedEntity.doctorSupplement,
						decryptedJsonStrictness,
					),
				vat =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["vat"]?.also { usedEncryptedContent += "vat" },
						encryptedEntity.vat,
						decryptedJsonStrictness,
					),
				label =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["label"]?.also { usedEncryptedContent += "label" },
						encryptedEntity.label,
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The Valorisation encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.embed.DecryptedValorisation
import com.icure.cardinal.sdk.model.embed.EncryptedValorisation
import com.icure.cardinal.sdk.options.DecryptedJsonStrictness
import com.icure.cardinal.sdk.utils.UnexpectedEncryptedContentException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.String
import kotlin.collections.Collection

@InternalIcureApi
internal object ValorisationDecryptorFactory :
	EntityDecryptorFactory<EncryptedValorisation, DecryptedValorisation> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedValorisation, DecryptedValorisation> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		require(manifest?.extensionsManifestsByModelVersion.isNullOrEmpty()) {
			"Valorisation is not Extendable and does not support extensions decryption, but its manifest defines extensionsManifestsByModelVersion."
		}
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
		return ValorisationDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class ValorisationDecryptor(
	private val encryptedContentDecoder: Json,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) : AbstractEntityDecryptor<EncryptedValorisation, DecryptedValorisation>(
		patchDecryptedSelfJson,
		cryptoService,
		unversionedEntitiesDecryptedJsonStrictness,
	) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedValorisation,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedValorisation {
		val entityCustomisedModelVersion = customisedModelVersion?.typeVersion
		val decryptedContent = decryptAndPatchContent(decryptionKeys, encryptedEntity)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedValorisation(
				startOfValidity =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["startOfValidity"]?.also { usedEncryptedContent += "startOfValidity" },
						encryptedEntity.startOfValidity,
						entityCustomisedModelVersion,
					),
				endOfValidity =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["endOfValidity"]?.also { usedEncryptedContent += "endOfValidity" },
						encryptedEntity.endOfValidity,
						entityCustomisedModelVersion,
					),
				predicate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["predicate"]?.also { usedEncryptedContent += "predicate" },
						encryptedEntity.predicate,
						entityCustomisedModelVersion,
					),
				reference =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["reference"]?.also { usedEncryptedContent += "reference" },
						encryptedEntity.reference,
						entityCustomisedModelVersion,
					),
				totalAmount =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["totalAmount"]?.also { usedEncryptedContent += "totalAmount" },
						encryptedEntity.totalAmount,
						entityCustomisedModelVersion,
					),
				reimbursement =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["reimbursement"]?.also { usedEncryptedContent += "reimbursement" },
						encryptedEntity.reimbursement,
						entityCustomisedModelVersion,
					),
				patientIntervention =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["patientIntervention"]?.also { usedEncryptedContent += "patientIntervention" },
						encryptedEntity.patientIntervention,
						entityCustomisedModelVersion,
					),
				doctorSupplement =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["doctorSupplement"]?.also { usedEncryptedContent += "doctorSupplement" },
						encryptedEntity.doctorSupplement,
						entityCustomisedModelVersion,
					),
				vat =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["vat"]?.also { usedEncryptedContent += "vat" },
						encryptedEntity.vat,
						entityCustomisedModelVersion,
					),
				label =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["label"]?.also { usedEncryptedContent += "label" },
						encryptedEntity.label,
						entityCustomisedModelVersion,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (entityCustomisedModelVersion == null &&
			unversionedEntitiesDecryptedJsonStrictness == DecryptedJsonStrictness.Strict &&
			decryptedContent.size != usedEncryptedContent.size
		) {
			throw UnexpectedEncryptedContentException(
				"The Valorisation encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

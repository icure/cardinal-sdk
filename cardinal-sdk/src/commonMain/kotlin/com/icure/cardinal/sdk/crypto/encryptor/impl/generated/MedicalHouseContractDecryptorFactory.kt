// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.embed.DecryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.EncryptedMedicalHouseContract
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
internal object MedicalHouseContractDecryptorFactory :
	EntityDecryptorFactory<EncryptedMedicalHouseContract, DecryptedMedicalHouseContract> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedMedicalHouseContract, DecryptedMedicalHouseContract> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		require(manifest?.extensionsManifestsByModelVersion.isNullOrEmpty()) {
			"MedicalHouseContract is not Extendable and does not support extensions decryption, but its manifest defines extensionsManifestsByModelVersion."
		}
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
		return MedicalHouseContractDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class MedicalHouseContractDecryptor(
	private val encryptedContentDecoder: Json,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) :
	AbstractEntityDecryptor<EncryptedMedicalHouseContract, DecryptedMedicalHouseContract>(
			patchDecryptedSelfJson,
			cryptoService,
			unversionedEntitiesDecryptedJsonStrictness,
		) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedMedicalHouseContract,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedMedicalHouseContract {
		val entityCustomisedModelVersion = customisedModelVersion?.typeVersion
		val decryptedContent = decryptAndPatchContent(decryptionKeys, encryptedEntity)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedMedicalHouseContract(
				contractId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["contractId"]?.also { usedEncryptedContent += "contractId" },
						encryptedEntity.contractId,
						entityCustomisedModelVersion,
					),
				validFrom =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["validFrom"]?.also { usedEncryptedContent += "validFrom" },
						encryptedEntity.validFrom,
						entityCustomisedModelVersion,
					),
				validTo =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["validTo"]?.also { usedEncryptedContent += "validTo" },
						encryptedEntity.validTo,
						entityCustomisedModelVersion,
					),
				mmNihii =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["mmNihii"]?.also { usedEncryptedContent += "mmNihii" },
						encryptedEntity.mmNihii,
						entityCustomisedModelVersion,
					),
				hcpId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["hcpId"]?.also { usedEncryptedContent += "hcpId" },
						encryptedEntity.hcpId,
						entityCustomisedModelVersion,
					),
				changeType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["changeType"]?.also { usedEncryptedContent += "changeType" },
						encryptedEntity.changeType,
						entityCustomisedModelVersion,
					),
				parentContractId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["parentContractId"]?.also { usedEncryptedContent += "parentContractId" },
						encryptedEntity.parentContractId,
						entityCustomisedModelVersion,
					),
				changedBy =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["changedBy"]?.also { usedEncryptedContent += "changedBy" },
						encryptedEntity.changedBy,
						entityCustomisedModelVersion,
					),
				startOfContract =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["startOfContract"]?.also { usedEncryptedContent += "startOfContract" },
						encryptedEntity.startOfContract,
						entityCustomisedModelVersion,
					),
				startOfCoverage =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["startOfCoverage"]?.also { usedEncryptedContent += "startOfCoverage" },
						encryptedEntity.startOfCoverage,
						entityCustomisedModelVersion,
					),
				endOfContract =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["endOfContract"]?.also { usedEncryptedContent += "endOfContract" },
						encryptedEntity.endOfContract,
						entityCustomisedModelVersion,
					),
				endOfCoverage =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["endOfCoverage"]?.also { usedEncryptedContent += "endOfCoverage" },
						encryptedEntity.endOfCoverage,
						entityCustomisedModelVersion,
					),
				kine =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["kine"]?.also { usedEncryptedContent += "kine" },
						encryptedEntity.kine,
						entityCustomisedModelVersion,
					),
				gp =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["gp"]?.also { usedEncryptedContent += "gp" },
						encryptedEntity.gp,
						entityCustomisedModelVersion,
					),
				ptd =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["ptd"]?.also { usedEncryptedContent += "ptd" },
						encryptedEntity.ptd,
						entityCustomisedModelVersion,
					),
				nurse =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["nurse"]?.also { usedEncryptedContent += "nurse" },
						encryptedEntity.nurse,
						entityCustomisedModelVersion,
					),
				noKine =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["noKine"]?.also { usedEncryptedContent += "noKine" },
						encryptedEntity.noKine,
						entityCustomisedModelVersion,
					),
				noGp =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["noGp"]?.also { usedEncryptedContent += "noGp" },
						encryptedEntity.noGp,
						entityCustomisedModelVersion,
					),
				noNurse =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["noNurse"]?.also { usedEncryptedContent += "noNurse" },
						encryptedEntity.noNurse,
						entityCustomisedModelVersion,
					),
				unsubscriptionReasonId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["unsubscriptionReasonId"]?.also { usedEncryptedContent += "unsubscriptionReasonId" },
						encryptedEntity.unsubscriptionReasonId,
						entityCustomisedModelVersion,
					),
				ptdStart =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["ptdStart"]?.also { usedEncryptedContent += "ptdStart" },
						encryptedEntity.ptdStart,
						entityCustomisedModelVersion,
					),
				ptdEnd =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["ptdEnd"]?.also { usedEncryptedContent += "ptdEnd" },
						encryptedEntity.ptdEnd,
						entityCustomisedModelVersion,
					),
				ptdLastInvoiced =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["ptdLastInvoiced"]?.also { usedEncryptedContent += "ptdLastInvoiced" },
						encryptedEntity.ptdLastInvoiced,
						entityCustomisedModelVersion,
					),
				startOfSuspension =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["startOfSuspension"]?.also { usedEncryptedContent += "startOfSuspension" },
						encryptedEntity.startOfSuspension,
						entityCustomisedModelVersion,
					),
				endOfSuspension =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["endOfSuspension"]?.also { usedEncryptedContent += "endOfSuspension" },
						encryptedEntity.endOfSuspension,
						entityCustomisedModelVersion,
					),
				suspensionReason =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["suspensionReason"]?.also { usedEncryptedContent += "suspensionReason" },
						encryptedEntity.suspensionReason,
						entityCustomisedModelVersion,
					),
				suspensionSource =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["suspensionSource"]?.also { usedEncryptedContent += "suspensionSource" },
						encryptedEntity.suspensionSource,
						entityCustomisedModelVersion,
					),
				forcedSuspension =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["forcedSuspension"]?.also { usedEncryptedContent += "forcedSuspension" },
						encryptedEntity.forcedSuspension,
						entityCustomisedModelVersion,
					),
				signatureType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["signatureType"]?.also { usedEncryptedContent += "signatureType" },
						encryptedEntity.signatureType,
						entityCustomisedModelVersion,
					),
				status =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["status"]?.also { usedEncryptedContent += "status" },
						encryptedEntity.status,
						entityCustomisedModelVersion,
					),
				options =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["options"]?.also { usedEncryptedContent += "options" },
						encryptedEntity.options,
						entityCustomisedModelVersion,
					),
				receipts =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["receipts"]?.also { usedEncryptedContent += "receipts" },
						encryptedEntity.receipts,
						entityCustomisedModelVersion,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (entityCustomisedModelVersion == null &&
			unversionedEntitiesDecryptedJsonStrictness == DecryptedJsonStrictness.Strict &&
			decryptedContent.size != usedEncryptedContent.size
		) {
			throw UnexpectedEncryptedContentException(
				"The MedicalHouseContract encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

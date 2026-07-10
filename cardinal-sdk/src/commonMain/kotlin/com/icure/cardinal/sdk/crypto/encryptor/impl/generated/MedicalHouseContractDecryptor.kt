// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.EncryptedMedicalHouseContract
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object MedicalHouseContractDecryptor :
	AbstractEntityDecryptor<EncryptedMedicalHouseContract, DecryptedMedicalHouseContract>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedMedicalHouseContract,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedMedicalHouseContract {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedMedicalHouseContract(
				contractId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["contractId"]?.also { usedEncryptedContent += "contractId" },
						encryptedEntity.contractId,
						decryptedJsonStrictness,
					),
				validFrom =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["validFrom"]?.also { usedEncryptedContent += "validFrom" },
						encryptedEntity.validFrom,
						decryptedJsonStrictness,
					),
				validTo =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["validTo"]?.also { usedEncryptedContent += "validTo" },
						encryptedEntity.validTo,
						decryptedJsonStrictness,
					),
				mmNihii =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["mmNihii"]?.also { usedEncryptedContent += "mmNihii" },
						encryptedEntity.mmNihii,
						decryptedJsonStrictness,
					),
				hcpId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["hcpId"]?.also { usedEncryptedContent += "hcpId" },
						encryptedEntity.hcpId,
						decryptedJsonStrictness,
					),
				changeType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["changeType"]?.also { usedEncryptedContent += "changeType" },
						encryptedEntity.changeType,
						decryptedJsonStrictness,
					),
				parentContractId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["parentContractId"]?.also { usedEncryptedContent += "parentContractId" },
						encryptedEntity.parentContractId,
						decryptedJsonStrictness,
					),
				changedBy =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["changedBy"]?.also { usedEncryptedContent += "changedBy" },
						encryptedEntity.changedBy,
						decryptedJsonStrictness,
					),
				startOfContract =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["startOfContract"]?.also { usedEncryptedContent += "startOfContract" },
						encryptedEntity.startOfContract,
						decryptedJsonStrictness,
					),
				startOfCoverage =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["startOfCoverage"]?.also { usedEncryptedContent += "startOfCoverage" },
						encryptedEntity.startOfCoverage,
						decryptedJsonStrictness,
					),
				endOfContract =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["endOfContract"]?.also { usedEncryptedContent += "endOfContract" },
						encryptedEntity.endOfContract,
						decryptedJsonStrictness,
					),
				endOfCoverage =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["endOfCoverage"]?.also { usedEncryptedContent += "endOfCoverage" },
						encryptedEntity.endOfCoverage,
						decryptedJsonStrictness,
					),
				kine =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["kine"]?.also { usedEncryptedContent += "kine" },
						encryptedEntity.kine,
						decryptedJsonStrictness,
					),
				gp =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["gp"]?.also { usedEncryptedContent += "gp" },
						encryptedEntity.gp,
						decryptedJsonStrictness,
					),
				ptd =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["ptd"]?.also { usedEncryptedContent += "ptd" },
						encryptedEntity.ptd,
						decryptedJsonStrictness,
					),
				nurse =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["nurse"]?.also { usedEncryptedContent += "nurse" },
						encryptedEntity.nurse,
						decryptedJsonStrictness,
					),
				noKine =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["noKine"]?.also { usedEncryptedContent += "noKine" },
						encryptedEntity.noKine,
						decryptedJsonStrictness,
					),
				noGp =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["noGp"]?.also { usedEncryptedContent += "noGp" },
						encryptedEntity.noGp,
						decryptedJsonStrictness,
					),
				noNurse =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["noNurse"]?.also { usedEncryptedContent += "noNurse" },
						encryptedEntity.noNurse,
						decryptedJsonStrictness,
					),
				unsubscriptionReasonId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["unsubscriptionReasonId"]?.also { usedEncryptedContent += "unsubscriptionReasonId" },
						encryptedEntity.unsubscriptionReasonId,
						decryptedJsonStrictness,
					),
				ptdStart =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["ptdStart"]?.also { usedEncryptedContent += "ptdStart" },
						encryptedEntity.ptdStart,
						decryptedJsonStrictness,
					),
				ptdEnd =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["ptdEnd"]?.also { usedEncryptedContent += "ptdEnd" },
						encryptedEntity.ptdEnd,
						decryptedJsonStrictness,
					),
				ptdLastInvoiced =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["ptdLastInvoiced"]?.also { usedEncryptedContent += "ptdLastInvoiced" },
						encryptedEntity.ptdLastInvoiced,
						decryptedJsonStrictness,
					),
				startOfSuspension =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["startOfSuspension"]?.also { usedEncryptedContent += "startOfSuspension" },
						encryptedEntity.startOfSuspension,
						decryptedJsonStrictness,
					),
				endOfSuspension =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["endOfSuspension"]?.also { usedEncryptedContent += "endOfSuspension" },
						encryptedEntity.endOfSuspension,
						decryptedJsonStrictness,
					),
				suspensionReason =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["suspensionReason"]?.also { usedEncryptedContent += "suspensionReason" },
						encryptedEntity.suspensionReason,
						decryptedJsonStrictness,
					),
				suspensionSource =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["suspensionSource"]?.also { usedEncryptedContent += "suspensionSource" },
						encryptedEntity.suspensionSource,
						decryptedJsonStrictness,
					),
				forcedSuspension =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["forcedSuspension"]?.also { usedEncryptedContent += "forcedSuspension" },
						encryptedEntity.forcedSuspension,
						decryptedJsonStrictness,
					),
				signatureType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["signatureType"]?.also { usedEncryptedContent += "signatureType" },
						encryptedEntity.signatureType,
						decryptedJsonStrictness,
					),
				status =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["status"]?.also { usedEncryptedContent += "status" },
						encryptedEntity.status,
						decryptedJsonStrictness,
					),
				options =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["options"]?.also { usedEncryptedContent += "options" },
						encryptedEntity.options,
						decryptedJsonStrictness,
					),
				receipts =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["receipts"]?.also { usedEncryptedContent += "receipts" },
						encryptedEntity.receipts,
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The MedicalHouseContract encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

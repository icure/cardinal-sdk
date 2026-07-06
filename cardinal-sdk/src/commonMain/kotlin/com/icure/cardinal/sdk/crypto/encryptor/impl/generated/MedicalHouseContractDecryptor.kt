// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.EncryptedMedicalHouseContract
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object MedicalHouseContractDecryptor :
	AbstractEntityDecryptor<EncryptedMedicalHouseContract, DecryptedMedicalHouseContract>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedMedicalHouseContract,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
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
					decryptedContent["contractId"].let {
						if (it != null) {
							usedEncryptedContent += "contractId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.contractId
						}
					},
				validFrom =
					decryptedContent["validFrom"].let {
						if (it != null) {
							usedEncryptedContent += "validFrom"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.validFrom
						}
					},
				validTo =
					decryptedContent["validTo"].let {
						if (it != null) {
							usedEncryptedContent += "validTo"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.validTo
						}
					},
				mmNihii =
					decryptedContent["mmNihii"].let {
						if (it != null) {
							usedEncryptedContent += "mmNihii"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.mmNihii
						}
					},
				hcpId =
					decryptedContent["hcpId"].let {
						if (it != null) {
							usedEncryptedContent += "hcpId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.hcpId
						}
					},
				changeType =
					decryptedContent["changeType"].let {
						if (it != null) {
							usedEncryptedContent += "changeType"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.changeType
						}
					},
				parentContractId =
					decryptedContent["parentContractId"].let {
						if (it != null) {
							usedEncryptedContent += "parentContractId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.parentContractId
						}
					},
				changedBy =
					decryptedContent["changedBy"].let {
						if (it != null) {
							usedEncryptedContent += "changedBy"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.changedBy
						}
					},
				startOfContract =
					decryptedContent["startOfContract"].let {
						if (it != null) {
							usedEncryptedContent += "startOfContract"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.startOfContract
						}
					},
				startOfCoverage =
					decryptedContent["startOfCoverage"].let {
						if (it != null) {
							usedEncryptedContent += "startOfCoverage"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.startOfCoverage
						}
					},
				endOfContract =
					decryptedContent["endOfContract"].let {
						if (it != null) {
							usedEncryptedContent += "endOfContract"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.endOfContract
						}
					},
				endOfCoverage =
					decryptedContent["endOfCoverage"].let {
						if (it != null) {
							usedEncryptedContent += "endOfCoverage"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.endOfCoverage
						}
					},
				kine =
					decryptedContent["kine"].let {
						if (it != null) {
							usedEncryptedContent += "kine"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.kine
						}
					},
				gp =
					decryptedContent["gp"].let {
						if (it != null) {
							usedEncryptedContent += "gp"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.gp
						}
					},
				ptd =
					decryptedContent["ptd"].let {
						if (it != null) {
							usedEncryptedContent += "ptd"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.ptd
						}
					},
				nurse =
					decryptedContent["nurse"].let {
						if (it != null) {
							usedEncryptedContent += "nurse"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.nurse
						}
					},
				noKine =
					decryptedContent["noKine"].let {
						if (it != null) {
							usedEncryptedContent += "noKine"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.noKine
						}
					},
				noGp =
					decryptedContent["noGp"].let {
						if (it != null) {
							usedEncryptedContent += "noGp"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.noGp
						}
					},
				noNurse =
					decryptedContent["noNurse"].let {
						if (it != null) {
							usedEncryptedContent += "noNurse"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.noNurse
						}
					},
				unsubscriptionReasonId =
					decryptedContent["unsubscriptionReasonId"].let {
						if (it != null) {
							usedEncryptedContent += "unsubscriptionReasonId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.unsubscriptionReasonId
						}
					},
				ptdStart =
					decryptedContent["ptdStart"].let {
						if (it != null) {
							usedEncryptedContent += "ptdStart"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.ptdStart
						}
					},
				ptdEnd =
					decryptedContent["ptdEnd"].let {
						if (it != null) {
							usedEncryptedContent += "ptdEnd"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.ptdEnd
						}
					},
				ptdLastInvoiced =
					decryptedContent["ptdLastInvoiced"].let {
						if (it != null) {
							usedEncryptedContent += "ptdLastInvoiced"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.ptdLastInvoiced
						}
					},
				startOfSuspension =
					decryptedContent["startOfSuspension"].let {
						if (it != null) {
							usedEncryptedContent += "startOfSuspension"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.startOfSuspension
						}
					},
				endOfSuspension =
					decryptedContent["endOfSuspension"].let {
						if (it != null) {
							usedEncryptedContent += "endOfSuspension"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.endOfSuspension
						}
					},
				suspensionReason =
					decryptedContent["suspensionReason"].let {
						if (it != null) {
							usedEncryptedContent += "suspensionReason"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.suspensionReason
						}
					},
				suspensionSource =
					decryptedContent["suspensionSource"].let {
						if (it != null) {
							usedEncryptedContent += "suspensionSource"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.suspensionSource
						}
					},
				forcedSuspension =
					decryptedContent["forcedSuspension"].let {
						if (it != null) {
							usedEncryptedContent += "forcedSuspension"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.forcedSuspension
						}
					},
				signatureType =
					decryptedContent["signatureType"].let {
						if (it != null) {
							usedEncryptedContent += "signatureType"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.signatureType
						}
					},
				status =
					decryptedContent["status"].let {
						if (it != null) {
							usedEncryptedContent += "status"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.status
						}
					},
				options =
					decryptedContent["options"].let {
						if (it != null) {
							usedEncryptedContent += "options"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.options
						}
					},
				receipts =
					decryptedContent["receipts"].let {
						if (it != null) {
							usedEncryptedContent += "receipts"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.receipts
						}
					},
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The MedicalHouseContract encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

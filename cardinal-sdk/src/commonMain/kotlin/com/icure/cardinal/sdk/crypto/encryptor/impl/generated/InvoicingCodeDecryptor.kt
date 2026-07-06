// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object InvoicingCodeDecryptor :
	AbstractEntityDecryptor<EncryptedInvoicingCode, DecryptedInvoicingCode>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedInvoicingCode,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedInvoicingCode {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedInvoicingCode(
				id = encryptedEntity.id,
				dateCode =
					decryptedContent["dateCode"].let {
						if (it != null) {
							usedEncryptedContent += "dateCode"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.dateCode
						}
					},
				logicalId =
					decryptedContent["logicalId"].let {
						if (it != null) {
							usedEncryptedContent += "logicalId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.logicalId
						}
					},
				label =
					decryptedContent["label"].let {
						if (it != null) {
							usedEncryptedContent += "label"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.label
						}
					},
				userId =
					decryptedContent["userId"].let {
						if (it != null) {
							usedEncryptedContent += "userId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.userId
						}
					},
				contactId =
					decryptedContent["contactId"].let {
						if (it != null) {
							usedEncryptedContent += "contactId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.contactId
						}
					},
				serviceId =
					decryptedContent["serviceId"].let {
						if (it != null) {
							usedEncryptedContent += "serviceId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.serviceId
						}
					},
				tarificationId =
					decryptedContent["tarificationId"].let {
						if (it != null) {
							usedEncryptedContent += "tarificationId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.tarificationId
						}
					},
				code =
					decryptedContent["code"].let {
						if (it != null) {
							usedEncryptedContent += "code"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.code
						}
					},
				paymentType =
					decryptedContent["paymentType"].let {
						if (it != null) {
							usedEncryptedContent += "paymentType"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.paymentType
						}
					},
				paid =
					decryptedContent["paid"].let {
						if (it != null) {
							usedEncryptedContent += "paid"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.paid
						}
					},
				totalAmount =
					decryptedContent["totalAmount"].let {
						if (it != null) {
							usedEncryptedContent += "totalAmount"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.totalAmount
						}
					},
				reimbursement =
					decryptedContent["reimbursement"].let {
						if (it != null) {
							usedEncryptedContent += "reimbursement"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.reimbursement
						}
					},
				patientIntervention =
					decryptedContent["patientIntervention"].let {
						if (it != null) {
							usedEncryptedContent += "patientIntervention"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.patientIntervention
						}
					},
				amiIntervention =
					decryptedContent["amiIntervention"].let {
						if (it != null) {
							usedEncryptedContent += "amiIntervention"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.amiIntervention
						}
					},
				doctorSupplement =
					decryptedContent["doctorSupplement"].let {
						if (it != null) {
							usedEncryptedContent += "doctorSupplement"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.doctorSupplement
						}
					},
				conventionAmount =
					decryptedContent["conventionAmount"].let {
						if (it != null) {
							usedEncryptedContent += "conventionAmount"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.conventionAmount
						}
					},
				vat =
					decryptedContent["vat"].let {
						if (it != null) {
							usedEncryptedContent += "vat"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.vat
						}
					},
				error =
					decryptedContent["error"].let {
						if (it != null) {
							usedEncryptedContent += "error"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.error
						}
					},
				contract =
					decryptedContent["contract"].let {
						if (it != null) {
							usedEncryptedContent += "contract"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.contract
						}
					},
				contractDate =
					decryptedContent["contractDate"].let {
						if (it != null) {
							usedEncryptedContent += "contractDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.contractDate
						}
					},
				units =
					decryptedContent["units"].let {
						if (it != null) {
							usedEncryptedContent += "units"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.units
						}
					},
				side =
					decryptedContent["side"].let {
						if (it != null) {
							usedEncryptedContent += "side"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.side
						}
					},
				timeOfDay =
					decryptedContent["timeOfDay"].let {
						if (it != null) {
							usedEncryptedContent += "timeOfDay"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.timeOfDay
						}
					},
				eidReadingHour =
					decryptedContent["eidReadingHour"].let {
						if (it != null) {
							usedEncryptedContent += "eidReadingHour"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.eidReadingHour
						}
					},
				eidReadingValue =
					decryptedContent["eidReadingValue"].let {
						if (it != null) {
							usedEncryptedContent += "eidReadingValue"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.eidReadingValue
						}
					},
				override3rdPayerCode =
					decryptedContent["override3rdPayerCode"].let {
						if (it != null) {
							usedEncryptedContent += "override3rdPayerCode"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.override3rdPayerCode
						}
					},
				override3rdPayerReason =
					decryptedContent["override3rdPayerReason"].let {
						if (it != null) {
							usedEncryptedContent += "override3rdPayerReason"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.override3rdPayerReason
						}
					},
				transplantationCode =
					decryptedContent["transplantationCode"].let {
						if (it != null) {
							usedEncryptedContent += "transplantationCode"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.transplantationCode
						}
					},
				prescriberNorm =
					decryptedContent["prescriberNorm"].let {
						if (it != null) {
							usedEncryptedContent += "prescriberNorm"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.prescriberNorm
						}
					},
				productLabel =
					decryptedContent["productLabel"].let {
						if (it != null) {
							usedEncryptedContent += "productLabel"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.productLabel
						}
					},
				percentNorm =
					decryptedContent["percentNorm"].let {
						if (it != null) {
							usedEncryptedContent += "percentNorm"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.percentNorm
						}
					},
				prescriberNihii =
					decryptedContent["prescriberNihii"].let {
						if (it != null) {
							usedEncryptedContent += "prescriberNihii"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.prescriberNihii
						}
					},
				relatedCode =
					decryptedContent["relatedCode"].let {
						if (it != null) {
							usedEncryptedContent += "relatedCode"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.relatedCode
						}
					},
				prescriptionDate =
					decryptedContent["prescriptionDate"].let {
						if (it != null) {
							usedEncryptedContent += "prescriptionDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.prescriptionDate
						}
					},
				derogationMaxNumber =
					decryptedContent["derogationMaxNumber"].let {
						if (it != null) {
							usedEncryptedContent += "derogationMaxNumber"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.derogationMaxNumber
						}
					},
				prescriberSsin =
					decryptedContent["prescriberSsin"].let {
						if (it != null) {
							usedEncryptedContent += "prescriberSsin"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.prescriberSsin
						}
					},
				prescriberLastName =
					decryptedContent["prescriberLastName"].let {
						if (it != null) {
							usedEncryptedContent += "prescriberLastName"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.prescriberLastName
						}
					},
				prescriberFirstName =
					decryptedContent["prescriberFirstName"].let {
						if (it != null) {
							usedEncryptedContent += "prescriberFirstName"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.prescriberFirstName
						}
					},
				prescriberCdHcParty =
					decryptedContent["prescriberCdHcParty"].let {
						if (it != null) {
							usedEncryptedContent += "prescriberCdHcParty"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.prescriberCdHcParty
						}
					},
				locationNihii =
					decryptedContent["locationNihii"].let {
						if (it != null) {
							usedEncryptedContent += "locationNihii"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.locationNihii
						}
					},
				locationCdHcParty =
					decryptedContent["locationCdHcParty"].let {
						if (it != null) {
							usedEncryptedContent += "locationCdHcParty"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.locationCdHcParty
						}
					},
				locationService =
					decryptedContent["locationService"].let {
						if (it != null) {
							usedEncryptedContent += "locationService"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.locationService
						}
					},
				admissionDate =
					decryptedContent["admissionDate"].let {
						if (it != null) {
							usedEncryptedContent += "admissionDate"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.admissionDate
						}
					},
				canceled =
					decryptedContent["canceled"].let {
						if (it != null) {
							usedEncryptedContent += "canceled"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.canceled
						}
					},
				accepted =
					decryptedContent["accepted"].let {
						if (it != null) {
							usedEncryptedContent += "accepted"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.accepted
						}
					},
				pending =
					decryptedContent["pending"].let {
						if (it != null) {
							usedEncryptedContent += "pending"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.pending
						}
					},
				resent =
					decryptedContent["resent"].let {
						if (it != null) {
							usedEncryptedContent += "resent"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.resent
						}
					},
				archived =
					decryptedContent["archived"].let {
						if (it != null) {
							usedEncryptedContent += "archived"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.archived
						}
					},
				lost =
					decryptedContent["lost"].let {
						if (it != null) {
							usedEncryptedContent += "lost"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.lost
						}
					},
				insuranceJustification =
					decryptedContent["insuranceJustification"].let {
						if (it != null) {
							usedEncryptedContent += "insuranceJustification"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.insuranceJustification
						}
					},
				cancelPatientInterventionReason =
					decryptedContent["cancelPatientInterventionReason"].let {
						if (it != null) {
							usedEncryptedContent += "cancelPatientInterventionReason"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.cancelPatientInterventionReason
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
				codeLabel =
					decryptedContent["codeLabel"].let {
						if (it != null) {
							usedEncryptedContent += "codeLabel"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.codeLabel
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
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The InvoicingCode encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

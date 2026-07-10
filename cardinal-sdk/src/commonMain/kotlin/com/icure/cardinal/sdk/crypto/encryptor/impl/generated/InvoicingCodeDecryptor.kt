// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.embed.DecryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object InvoicingCodeDecryptor :
	AbstractEntityDecryptor<EncryptedInvoicingCode, DecryptedInvoicingCode>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedInvoicingCode,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
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
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["dateCode"]?.also { usedEncryptedContent += "dateCode" },
						encryptedEntity.dateCode,
						decryptedJsonStrictness,
					),
				logicalId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["logicalId"]?.also { usedEncryptedContent += "logicalId" },
						encryptedEntity.logicalId,
						decryptedJsonStrictness,
					),
				label =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["label"]?.also { usedEncryptedContent += "label" },
						encryptedEntity.label,
						decryptedJsonStrictness,
					),
				userId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["userId"]?.also { usedEncryptedContent += "userId" },
						encryptedEntity.userId,
						decryptedJsonStrictness,
					),
				contactId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["contactId"]?.also { usedEncryptedContent += "contactId" },
						encryptedEntity.contactId,
						decryptedJsonStrictness,
					),
				serviceId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["serviceId"]?.also { usedEncryptedContent += "serviceId" },
						encryptedEntity.serviceId,
						decryptedJsonStrictness,
					),
				pricingId =
					encryptedContentDecoder.decodeDecrypted(
						(
							decryptedContent["pricingId"]?.also { usedEncryptedContent += "pricingId" }
								?: decryptedContent["tarificationId"]?.also { usedEncryptedContent += "tarificationId" }
						),
						encryptedEntity.pricingId,
						decryptedJsonStrictness,
					),
				code =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["code"]?.also { usedEncryptedContent += "code" },
						encryptedEntity.code,
						decryptedJsonStrictness,
					),
				paymentType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["paymentType"]?.also { usedEncryptedContent += "paymentType" },
						encryptedEntity.paymentType,
						decryptedJsonStrictness,
					),
				paid =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["paid"]?.also { usedEncryptedContent += "paid" },
						encryptedEntity.paid,
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
				amiIntervention =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["amiIntervention"]?.also { usedEncryptedContent += "amiIntervention" },
						encryptedEntity.amiIntervention,
						decryptedJsonStrictness,
					),
				doctorSupplement =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["doctorSupplement"]?.also { usedEncryptedContent += "doctorSupplement" },
						encryptedEntity.doctorSupplement,
						decryptedJsonStrictness,
					),
				conventionAmount =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["conventionAmount"]?.also { usedEncryptedContent += "conventionAmount" },
						encryptedEntity.conventionAmount,
						decryptedJsonStrictness,
					),
				vat =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["vat"]?.also { usedEncryptedContent += "vat" },
						encryptedEntity.vat,
						decryptedJsonStrictness,
					),
				error =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["error"]?.also { usedEncryptedContent += "error" },
						encryptedEntity.error,
						decryptedJsonStrictness,
					),
				contract =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["contract"]?.also { usedEncryptedContent += "contract" },
						encryptedEntity.contract,
						decryptedJsonStrictness,
					),
				contractDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["contractDate"]?.also { usedEncryptedContent += "contractDate" },
						encryptedEntity.contractDate,
						decryptedJsonStrictness,
					),
				units =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["units"]?.also { usedEncryptedContent += "units" },
						encryptedEntity.units,
						decryptedJsonStrictness,
					),
				side =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["side"]?.also { usedEncryptedContent += "side" },
						encryptedEntity.side,
						decryptedJsonStrictness,
					),
				timeOfDay =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["timeOfDay"]?.also { usedEncryptedContent += "timeOfDay" },
						encryptedEntity.timeOfDay,
						decryptedJsonStrictness,
					),
				eidReadingHour =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["eidReadingHour"]?.also { usedEncryptedContent += "eidReadingHour" },
						encryptedEntity.eidReadingHour,
						decryptedJsonStrictness,
					),
				eidReadingValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["eidReadingValue"]?.also { usedEncryptedContent += "eidReadingValue" },
						encryptedEntity.eidReadingValue,
						decryptedJsonStrictness,
					),
				override3rdPayerCode =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["override3rdPayerCode"]?.also { usedEncryptedContent += "override3rdPayerCode" },
						encryptedEntity.override3rdPayerCode,
						decryptedJsonStrictness,
					),
				override3rdPayerReason =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["override3rdPayerReason"]?.also { usedEncryptedContent += "override3rdPayerReason" },
						encryptedEntity.override3rdPayerReason,
						decryptedJsonStrictness,
					),
				transplantationCode =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["transplantationCode"]?.also { usedEncryptedContent += "transplantationCode" },
						encryptedEntity.transplantationCode,
						decryptedJsonStrictness,
					),
				prescriberNorm =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["prescriberNorm"]?.also { usedEncryptedContent += "prescriberNorm" },
						encryptedEntity.prescriberNorm,
						decryptedJsonStrictness,
					),
				productLabel =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["productLabel"]?.also { usedEncryptedContent += "productLabel" },
						encryptedEntity.productLabel,
						decryptedJsonStrictness,
					),
				percentNorm =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["percentNorm"]?.also { usedEncryptedContent += "percentNorm" },
						encryptedEntity.percentNorm,
						decryptedJsonStrictness,
					),
				prescriberNihii =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["prescriberNihii"]?.also { usedEncryptedContent += "prescriberNihii" },
						encryptedEntity.prescriberNihii,
						decryptedJsonStrictness,
					),
				relatedCode =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["relatedCode"]?.also { usedEncryptedContent += "relatedCode" },
						encryptedEntity.relatedCode,
						decryptedJsonStrictness,
					),
				prescriptionDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["prescriptionDate"]?.also { usedEncryptedContent += "prescriptionDate" },
						encryptedEntity.prescriptionDate,
						decryptedJsonStrictness,
					),
				derogationMaxNumber =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["derogationMaxNumber"]?.also { usedEncryptedContent += "derogationMaxNumber" },
						encryptedEntity.derogationMaxNumber,
						decryptedJsonStrictness,
					),
				prescriberSsin =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["prescriberSsin"]?.also { usedEncryptedContent += "prescriberSsin" },
						encryptedEntity.prescriberSsin,
						decryptedJsonStrictness,
					),
				prescriberLastName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["prescriberLastName"]?.also { usedEncryptedContent += "prescriberLastName" },
						encryptedEntity.prescriberLastName,
						decryptedJsonStrictness,
					),
				prescriberFirstName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["prescriberFirstName"]?.also { usedEncryptedContent += "prescriberFirstName" },
						encryptedEntity.prescriberFirstName,
						decryptedJsonStrictness,
					),
				prescriberCdHcParty =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["prescriberCdHcParty"]?.also { usedEncryptedContent += "prescriberCdHcParty" },
						encryptedEntity.prescriberCdHcParty,
						decryptedJsonStrictness,
					),
				locationNihii =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["locationNihii"]?.also { usedEncryptedContent += "locationNihii" },
						encryptedEntity.locationNihii,
						decryptedJsonStrictness,
					),
				locationCdHcParty =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["locationCdHcParty"]?.also { usedEncryptedContent += "locationCdHcParty" },
						encryptedEntity.locationCdHcParty,
						decryptedJsonStrictness,
					),
				locationService =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["locationService"]?.also { usedEncryptedContent += "locationService" },
						encryptedEntity.locationService,
						decryptedJsonStrictness,
					),
				admissionDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["admissionDate"]?.also { usedEncryptedContent += "admissionDate" },
						encryptedEntity.admissionDate,
						decryptedJsonStrictness,
					),
				canceled =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["canceled"]?.also { usedEncryptedContent += "canceled" },
						encryptedEntity.canceled,
						decryptedJsonStrictness,
					),
				accepted =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["accepted"]?.also { usedEncryptedContent += "accepted" },
						encryptedEntity.accepted,
						decryptedJsonStrictness,
					),
				pending =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["pending"]?.also { usedEncryptedContent += "pending" },
						encryptedEntity.pending,
						decryptedJsonStrictness,
					),
				resent =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["resent"]?.also { usedEncryptedContent += "resent" },
						encryptedEntity.resent,
						decryptedJsonStrictness,
					),
				archived =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["archived"]?.also { usedEncryptedContent += "archived" },
						encryptedEntity.archived,
						decryptedJsonStrictness,
					),
				lost =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["lost"]?.also { usedEncryptedContent += "lost" },
						encryptedEntity.lost,
						decryptedJsonStrictness,
					),
				insuranceJustification =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["insuranceJustification"]?.also { usedEncryptedContent += "insuranceJustification" },
						encryptedEntity.insuranceJustification,
						decryptedJsonStrictness,
					),
				cancelPatientInterventionReason =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["cancelPatientInterventionReason"]?.also { usedEncryptedContent += "cancelPatientInterventionReason" },
						encryptedEntity.cancelPatientInterventionReason,
						decryptedJsonStrictness,
					),
				status =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["status"]?.also { usedEncryptedContent += "status" },
						encryptedEntity.status,
						decryptedJsonStrictness,
					),
				codeLabel =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["codeLabel"]?.also { usedEncryptedContent += "codeLabel" },
						encryptedEntity.codeLabel,
						decryptedJsonStrictness,
					),
				options =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["options"]?.also { usedEncryptedContent += "options" },
						encryptedEntity.options,
						decryptedJsonStrictness,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The InvoicingCode encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

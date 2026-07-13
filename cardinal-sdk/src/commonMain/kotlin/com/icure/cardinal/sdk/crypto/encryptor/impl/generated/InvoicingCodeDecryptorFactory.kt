// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.embed.DecryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
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
internal object InvoicingCodeDecryptorFactory :
	EntityDecryptorFactory<EncryptedInvoicingCode, DecryptedInvoicingCode> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedInvoicingCode, DecryptedInvoicingCode> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		require(manifest?.extensionsManifestsByModelVersion.isNullOrEmpty()) {
			"InvoicingCode is not Extendable and does not support extensions decryption, but its manifest defines extensionsManifestsByModelVersion."
		}
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
		return InvoicingCodeDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class InvoicingCodeDecryptor(
	private val encryptedContentDecoder: Json,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) : AbstractEntityDecryptor<EncryptedInvoicingCode, DecryptedInvoicingCode>(
		patchDecryptedSelfJson,
		cryptoService,
		unversionedEntitiesDecryptedJsonStrictness,
	) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedInvoicingCode,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedInvoicingCode {
		val entityCustomisedModelVersion = customisedModelVersion?.typeVersion
		val decryptedContent = decryptAndPatchContent(decryptionKeys, encryptedEntity)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedInvoicingCode(
				id = encryptedEntity.id,
				dateCode =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["dateCode"]?.also { usedEncryptedContent += "dateCode" },
						encryptedEntity.dateCode,
						entityCustomisedModelVersion,
					),
				logicalId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["logicalId"]?.also { usedEncryptedContent += "logicalId" },
						encryptedEntity.logicalId,
						entityCustomisedModelVersion,
					),
				label =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["label"]?.also { usedEncryptedContent += "label" },
						encryptedEntity.label,
						entityCustomisedModelVersion,
					),
				userId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["userId"]?.also { usedEncryptedContent += "userId" },
						encryptedEntity.userId,
						entityCustomisedModelVersion,
					),
				contactId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["contactId"]?.also { usedEncryptedContent += "contactId" },
						encryptedEntity.contactId,
						entityCustomisedModelVersion,
					),
				serviceId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["serviceId"]?.also { usedEncryptedContent += "serviceId" },
						encryptedEntity.serviceId,
						entityCustomisedModelVersion,
					),
				pricingId =
					encryptedContentDecoder.decodeDecrypted(
						(
							decryptedContent["pricingId"]?.also { usedEncryptedContent += "pricingId" }
								?: decryptedContent["tarificationId"]?.also { usedEncryptedContent += "tarificationId" }
						),
						encryptedEntity.pricingId,
						entityCustomisedModelVersion,
					),
				code =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["code"]?.also { usedEncryptedContent += "code" },
						encryptedEntity.code,
						entityCustomisedModelVersion,
					),
				paymentType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["paymentType"]?.also { usedEncryptedContent += "paymentType" },
						encryptedEntity.paymentType,
						entityCustomisedModelVersion,
					),
				paid =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["paid"]?.also { usedEncryptedContent += "paid" },
						encryptedEntity.paid,
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
				amiIntervention =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["amiIntervention"]?.also { usedEncryptedContent += "amiIntervention" },
						encryptedEntity.amiIntervention,
						entityCustomisedModelVersion,
					),
				doctorSupplement =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["doctorSupplement"]?.also { usedEncryptedContent += "doctorSupplement" },
						encryptedEntity.doctorSupplement,
						entityCustomisedModelVersion,
					),
				conventionAmount =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["conventionAmount"]?.also { usedEncryptedContent += "conventionAmount" },
						encryptedEntity.conventionAmount,
						entityCustomisedModelVersion,
					),
				vat =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["vat"]?.also { usedEncryptedContent += "vat" },
						encryptedEntity.vat,
						entityCustomisedModelVersion,
					),
				error =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["error"]?.also { usedEncryptedContent += "error" },
						encryptedEntity.error,
						entityCustomisedModelVersion,
					),
				contract =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["contract"]?.also { usedEncryptedContent += "contract" },
						encryptedEntity.contract,
						entityCustomisedModelVersion,
					),
				contractDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["contractDate"]?.also { usedEncryptedContent += "contractDate" },
						encryptedEntity.contractDate,
						entityCustomisedModelVersion,
					),
				units =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["units"]?.also { usedEncryptedContent += "units" },
						encryptedEntity.units,
						entityCustomisedModelVersion,
					),
				side =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["side"]?.also { usedEncryptedContent += "side" },
						encryptedEntity.side,
						entityCustomisedModelVersion,
					),
				timeOfDay =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["timeOfDay"]?.also { usedEncryptedContent += "timeOfDay" },
						encryptedEntity.timeOfDay,
						entityCustomisedModelVersion,
					),
				eidReadingHour =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["eidReadingHour"]?.also { usedEncryptedContent += "eidReadingHour" },
						encryptedEntity.eidReadingHour,
						entityCustomisedModelVersion,
					),
				eidReadingValue =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["eidReadingValue"]?.also { usedEncryptedContent += "eidReadingValue" },
						encryptedEntity.eidReadingValue,
						entityCustomisedModelVersion,
					),
				override3rdPayerCode =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["override3rdPayerCode"]?.also { usedEncryptedContent += "override3rdPayerCode" },
						encryptedEntity.override3rdPayerCode,
						entityCustomisedModelVersion,
					),
				override3rdPayerReason =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["override3rdPayerReason"]?.also { usedEncryptedContent += "override3rdPayerReason" },
						encryptedEntity.override3rdPayerReason,
						entityCustomisedModelVersion,
					),
				transplantationCode =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["transplantationCode"]?.also { usedEncryptedContent += "transplantationCode" },
						encryptedEntity.transplantationCode,
						entityCustomisedModelVersion,
					),
				prescriberNorm =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["prescriberNorm"]?.also { usedEncryptedContent += "prescriberNorm" },
						encryptedEntity.prescriberNorm,
						entityCustomisedModelVersion,
					),
				productLabel =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["productLabel"]?.also { usedEncryptedContent += "productLabel" },
						encryptedEntity.productLabel,
						entityCustomisedModelVersion,
					),
				percentNorm =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["percentNorm"]?.also { usedEncryptedContent += "percentNorm" },
						encryptedEntity.percentNorm,
						entityCustomisedModelVersion,
					),
				prescriberNihii =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["prescriberNihii"]?.also { usedEncryptedContent += "prescriberNihii" },
						encryptedEntity.prescriberNihii,
						entityCustomisedModelVersion,
					),
				relatedCode =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["relatedCode"]?.also { usedEncryptedContent += "relatedCode" },
						encryptedEntity.relatedCode,
						entityCustomisedModelVersion,
					),
				prescriptionDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["prescriptionDate"]?.also { usedEncryptedContent += "prescriptionDate" },
						encryptedEntity.prescriptionDate,
						entityCustomisedModelVersion,
					),
				derogationMaxNumber =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["derogationMaxNumber"]?.also { usedEncryptedContent += "derogationMaxNumber" },
						encryptedEntity.derogationMaxNumber,
						entityCustomisedModelVersion,
					),
				prescriberSsin =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["prescriberSsin"]?.also { usedEncryptedContent += "prescriberSsin" },
						encryptedEntity.prescriberSsin,
						entityCustomisedModelVersion,
					),
				prescriberLastName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["prescriberLastName"]?.also { usedEncryptedContent += "prescriberLastName" },
						encryptedEntity.prescriberLastName,
						entityCustomisedModelVersion,
					),
				prescriberFirstName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["prescriberFirstName"]?.also { usedEncryptedContent += "prescriberFirstName" },
						encryptedEntity.prescriberFirstName,
						entityCustomisedModelVersion,
					),
				prescriberCdHcParty =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["prescriberCdHcParty"]?.also { usedEncryptedContent += "prescriberCdHcParty" },
						encryptedEntity.prescriberCdHcParty,
						entityCustomisedModelVersion,
					),
				locationNihii =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["locationNihii"]?.also { usedEncryptedContent += "locationNihii" },
						encryptedEntity.locationNihii,
						entityCustomisedModelVersion,
					),
				locationCdHcParty =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["locationCdHcParty"]?.also { usedEncryptedContent += "locationCdHcParty" },
						encryptedEntity.locationCdHcParty,
						entityCustomisedModelVersion,
					),
				locationService =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["locationService"]?.also { usedEncryptedContent += "locationService" },
						encryptedEntity.locationService,
						entityCustomisedModelVersion,
					),
				admissionDate =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["admissionDate"]?.also { usedEncryptedContent += "admissionDate" },
						encryptedEntity.admissionDate,
						entityCustomisedModelVersion,
					),
				canceled =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["canceled"]?.also { usedEncryptedContent += "canceled" },
						encryptedEntity.canceled,
						entityCustomisedModelVersion,
					),
				accepted =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["accepted"]?.also { usedEncryptedContent += "accepted" },
						encryptedEntity.accepted,
						entityCustomisedModelVersion,
					),
				pending =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["pending"]?.also { usedEncryptedContent += "pending" },
						encryptedEntity.pending,
						entityCustomisedModelVersion,
					),
				resent =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["resent"]?.also { usedEncryptedContent += "resent" },
						encryptedEntity.resent,
						entityCustomisedModelVersion,
					),
				archived =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["archived"]?.also { usedEncryptedContent += "archived" },
						encryptedEntity.archived,
						entityCustomisedModelVersion,
					),
				lost =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["lost"]?.also { usedEncryptedContent += "lost" },
						encryptedEntity.lost,
						entityCustomisedModelVersion,
					),
				insuranceJustification =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["insuranceJustification"]?.also { usedEncryptedContent += "insuranceJustification" },
						encryptedEntity.insuranceJustification,
						entityCustomisedModelVersion,
					),
				cancelPatientInterventionReason =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["cancelPatientInterventionReason"]?.also { usedEncryptedContent += "cancelPatientInterventionReason" },
						encryptedEntity.cancelPatientInterventionReason,
						entityCustomisedModelVersion,
					),
				status =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["status"]?.also { usedEncryptedContent += "status" },
						encryptedEntity.status,
						entityCustomisedModelVersion,
					),
				codeLabel =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["codeLabel"]?.also { usedEncryptedContent += "codeLabel" },
						encryptedEntity.codeLabel,
						entityCustomisedModelVersion,
					),
				options =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["options"]?.also { usedEncryptedContent += "options" },
						encryptedEntity.options,
						entityCustomisedModelVersion,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (entityCustomisedModelVersion == null &&
			unversionedEntitiesDecryptedJsonStrictness == DecryptedJsonStrictness.Strict &&
			decryptedContent.size != usedEncryptedContent.size
		) {
			throw UnexpectedEncryptedContentException(
				"The InvoicingCode encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

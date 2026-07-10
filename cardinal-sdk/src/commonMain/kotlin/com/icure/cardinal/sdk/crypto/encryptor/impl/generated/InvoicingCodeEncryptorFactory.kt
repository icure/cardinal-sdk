// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

@InternalIcureApi
internal object InvoicingCodeEncryptorFactory :
	EntityEncryptorFactory<EncryptedInvoicingCode, DecryptedInvoicingCode> {
	override val empty: EntityEncryptor<EncryptedInvoicingCode, DecryptedInvoicingCode> =
		object :
			EntityEncryptor<EncryptedInvoicingCode, DecryptedInvoicingCode> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedInvoicingCode,
			): EncryptedInvoicingCode =
				EncryptedInvoicingCode(
					id = clearEntity.id,
					dateCode = clearEntity.dateCode,
					logicalId = clearEntity.logicalId,
					label = clearEntity.label,
					userId = clearEntity.userId,
					contactId = clearEntity.contactId,
					serviceId = clearEntity.serviceId,
					pricingId = clearEntity.pricingId,
					code = clearEntity.code,
					paymentType = clearEntity.paymentType,
					paid = clearEntity.paid,
					totalAmount = clearEntity.totalAmount,
					reimbursement = clearEntity.reimbursement,
					patientIntervention = clearEntity.patientIntervention,
					amiIntervention = clearEntity.amiIntervention,
					doctorSupplement = clearEntity.doctorSupplement,
					conventionAmount = clearEntity.conventionAmount,
					vat = clearEntity.vat,
					error = clearEntity.error,
					contract = clearEntity.contract,
					contractDate = clearEntity.contractDate,
					units = clearEntity.units,
					side = clearEntity.side,
					timeOfDay = clearEntity.timeOfDay,
					eidReadingHour = clearEntity.eidReadingHour,
					eidReadingValue = clearEntity.eidReadingValue,
					override3rdPayerCode = clearEntity.override3rdPayerCode,
					override3rdPayerReason = clearEntity.override3rdPayerReason,
					transplantationCode = clearEntity.transplantationCode,
					prescriberNorm = clearEntity.prescriberNorm,
					productLabel = clearEntity.productLabel,
					percentNorm = clearEntity.percentNorm,
					prescriberNihii = clearEntity.prescriberNihii,
					relatedCode = clearEntity.relatedCode,
					prescriptionDate = clearEntity.prescriptionDate,
					derogationMaxNumber = clearEntity.derogationMaxNumber,
					prescriberSsin = clearEntity.prescriberSsin,
					prescriberLastName = clearEntity.prescriberLastName,
					prescriberFirstName = clearEntity.prescriberFirstName,
					prescriberCdHcParty = clearEntity.prescriberCdHcParty,
					locationNihii = clearEntity.locationNihii,
					locationCdHcParty = clearEntity.locationCdHcParty,
					locationService = clearEntity.locationService,
					admissionDate = clearEntity.admissionDate,
					canceled = clearEntity.canceled,
					accepted = clearEntity.accepted,
					pending = clearEntity.pending,
					resent = clearEntity.resent,
					archived = clearEntity.archived,
					lost = clearEntity.lost,
					insuranceJustification = clearEntity.insuranceJustification,
					cancelPatientInterventionReason = clearEntity.cancelPatientInterventionReason,
					status = clearEntity.status,
					codeLabel = clearEntity.codeLabel,
					options = clearEntity.options,
					encryptedSelf = null,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedInvoicingCode, DecryptedInvoicingCode> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return InvoicingCodeEncryptor(
			dateCode_e = "dateCode" in manifest.fieldsToEncrypt,
			logicalId_e = "logicalId" in manifest.fieldsToEncrypt,
			label_e = "label" in manifest.fieldsToEncrypt,
			userId_e = "userId" in manifest.fieldsToEncrypt,
			contactId_e = "contactId" in manifest.fieldsToEncrypt,
			serviceId_e = "serviceId" in manifest.fieldsToEncrypt,
			tarificationId_e = "pricingId" in manifest.fieldsToEncrypt,
			tarificationId_n = if (encryptorFactoryContext.serializeEncryptedSelfUsingLegacyNames) "tarificationId" else "pricingId",
			code_e = "code" in manifest.fieldsToEncrypt,
			paymentType_e = "paymentType" in manifest.fieldsToEncrypt,
			paid_e = "paid" in manifest.fieldsToEncrypt,
			totalAmount_e = "totalAmount" in manifest.fieldsToEncrypt,
			reimbursement_e = "reimbursement" in manifest.fieldsToEncrypt,
			patientIntervention_e = "patientIntervention" in manifest.fieldsToEncrypt,
			amiIntervention_e = "amiIntervention" in manifest.fieldsToEncrypt,
			doctorSupplement_e = "doctorSupplement" in manifest.fieldsToEncrypt,
			conventionAmount_e = "conventionAmount" in manifest.fieldsToEncrypt,
			vat_e = "vat" in manifest.fieldsToEncrypt,
			error_e = "error" in manifest.fieldsToEncrypt,
			contract_e = "contract" in manifest.fieldsToEncrypt,
			contractDate_e = "contractDate" in manifest.fieldsToEncrypt,
			units_e = "units" in manifest.fieldsToEncrypt,
			side_e = "side" in manifest.fieldsToEncrypt,
			timeOfDay_e = "timeOfDay" in manifest.fieldsToEncrypt,
			eidReadingHour_e = "eidReadingHour" in manifest.fieldsToEncrypt,
			eidReadingValue_e = "eidReadingValue" in manifest.fieldsToEncrypt,
			override3rdPayerCode_e = "override3rdPayerCode" in manifest.fieldsToEncrypt,
			override3rdPayerReason_e = "override3rdPayerReason" in manifest.fieldsToEncrypt,
			transplantationCode_e = "transplantationCode" in manifest.fieldsToEncrypt,
			prescriberNorm_e = "prescriberNorm" in manifest.fieldsToEncrypt,
			productLabel_e = "productLabel" in manifest.fieldsToEncrypt,
			percentNorm_e = "percentNorm" in manifest.fieldsToEncrypt,
			prescriberNihii_e = "prescriberNihii" in manifest.fieldsToEncrypt,
			relatedCode_e = "relatedCode" in manifest.fieldsToEncrypt,
			prescriptionDate_e = "prescriptionDate" in manifest.fieldsToEncrypt,
			derogationMaxNumber_e = "derogationMaxNumber" in manifest.fieldsToEncrypt,
			prescriberSsin_e = "prescriberSsin" in manifest.fieldsToEncrypt,
			prescriberLastName_e = "prescriberLastName" in manifest.fieldsToEncrypt,
			prescriberFirstName_e = "prescriberFirstName" in manifest.fieldsToEncrypt,
			prescriberCdHcParty_e = "prescriberCdHcParty" in manifest.fieldsToEncrypt,
			locationNihii_e = "locationNihii" in manifest.fieldsToEncrypt,
			locationCdHcParty_e = "locationCdHcParty" in manifest.fieldsToEncrypt,
			locationService_e = "locationService" in manifest.fieldsToEncrypt,
			admissionDate_e = "admissionDate" in manifest.fieldsToEncrypt,
			canceled_e = "canceled" in manifest.fieldsToEncrypt,
			accepted_e = "accepted" in manifest.fieldsToEncrypt,
			pending_e = "pending" in manifest.fieldsToEncrypt,
			resent_e = "resent" in manifest.fieldsToEncrypt,
			archived_e = "archived" in manifest.fieldsToEncrypt,
			lost_e = "lost" in manifest.fieldsToEncrypt,
			insuranceJustification_e = "insuranceJustification" in manifest.fieldsToEncrypt,
			cancelPatientInterventionReason_e = "cancelPatientInterventionReason" in manifest.fieldsToEncrypt,
			status_e = "status" in manifest.fieldsToEncrypt,
			codeLabel_e = "codeLabel" in manifest.fieldsToEncrypt,
			options_e = "options" in manifest.fieldsToEncrypt,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class InvoicingCodeEncryptor(
	private val dateCode_e: Boolean,
	private val logicalId_e: Boolean,
	private val label_e: Boolean,
	private val userId_e: Boolean,
	private val contactId_e: Boolean,
	private val serviceId_e: Boolean,
	private val tarificationId_e: Boolean,
	private val tarificationId_n: String,
	private val code_e: Boolean,
	private val paymentType_e: Boolean,
	private val paid_e: Boolean,
	private val totalAmount_e: Boolean,
	private val reimbursement_e: Boolean,
	private val patientIntervention_e: Boolean,
	private val amiIntervention_e: Boolean,
	private val doctorSupplement_e: Boolean,
	private val conventionAmount_e: Boolean,
	private val vat_e: Boolean,
	private val error_e: Boolean,
	private val contract_e: Boolean,
	private val contractDate_e: Boolean,
	private val units_e: Boolean,
	private val side_e: Boolean,
	private val timeOfDay_e: Boolean,
	private val eidReadingHour_e: Boolean,
	private val eidReadingValue_e: Boolean,
	private val override3rdPayerCode_e: Boolean,
	private val override3rdPayerReason_e: Boolean,
	private val transplantationCode_e: Boolean,
	private val prescriberNorm_e: Boolean,
	private val productLabel_e: Boolean,
	private val percentNorm_e: Boolean,
	private val prescriberNihii_e: Boolean,
	private val relatedCode_e: Boolean,
	private val prescriptionDate_e: Boolean,
	private val derogationMaxNumber_e: Boolean,
	private val prescriberSsin_e: Boolean,
	private val prescriberLastName_e: Boolean,
	private val prescriberFirstName_e: Boolean,
	private val prescriberCdHcParty_e: Boolean,
	private val locationNihii_e: Boolean,
	private val locationCdHcParty_e: Boolean,
	private val locationService_e: Boolean,
	private val admissionDate_e: Boolean,
	private val canceled_e: Boolean,
	private val accepted_e: Boolean,
	private val pending_e: Boolean,
	private val resent_e: Boolean,
	private val archived_e: Boolean,
	private val lost_e: Boolean,
	private val insuranceJustification_e: Boolean,
	private val cancelPatientInterventionReason_e: Boolean,
	private val status_e: Boolean,
	private val codeLabel_e: Boolean,
	private val options_e: Boolean,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedInvoicingCode, DecryptedInvoicingCode>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedInvoicingCode,
	): EncryptedInvoicingCode {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (dateCode_e && clearEntity.dateCode != null) dataToEncrypt["dateCode"] = encodingJson.encodeToJsonElement(clearEntity.dateCode)
		if (logicalId_e && clearEntity.logicalId != null) dataToEncrypt["logicalId"] = encodingJson.encodeToJsonElement(clearEntity.logicalId)
		if (label_e && clearEntity.label != null) dataToEncrypt["label"] = encodingJson.encodeToJsonElement(clearEntity.label)
		if (userId_e && clearEntity.userId != null) dataToEncrypt["userId"] = encodingJson.encodeToJsonElement(clearEntity.userId)
		if (contactId_e && clearEntity.contactId != null) dataToEncrypt["contactId"] = encodingJson.encodeToJsonElement(clearEntity.contactId)
		if (serviceId_e && clearEntity.serviceId != null) dataToEncrypt["serviceId"] = encodingJson.encodeToJsonElement(clearEntity.serviceId)
		if (tarificationId_e && clearEntity.pricingId != null) {
			dataToEncrypt[tarificationId_n] =
				encodingJson.encodeToJsonElement(
					clearEntity.pricingId,
				)
		}
		if (code_e && clearEntity.code != null) dataToEncrypt["code"] = encodingJson.encodeToJsonElement(clearEntity.code)
		if (paymentType_e && clearEntity.paymentType != null) {
			dataToEncrypt["paymentType"] =
				encodingJson.encodeToJsonElement(
					clearEntity.paymentType,
				)
		}
		if (paid_e && clearEntity.paid != null) dataToEncrypt["paid"] = encodingJson.encodeToJsonElement(clearEntity.paid)
		if (totalAmount_e && clearEntity.totalAmount != null) {
			dataToEncrypt["totalAmount"] =
				encodingJson.encodeToJsonElement(
					clearEntity.totalAmount,
				)
		}
		if (reimbursement_e && clearEntity.reimbursement != null) {
			dataToEncrypt["reimbursement"] =
				encodingJson.encodeToJsonElement(
					clearEntity.reimbursement,
				)
		}
		if (patientIntervention_e && clearEntity.patientIntervention != null) {
			dataToEncrypt["patientIntervention"] =
				encodingJson.encodeToJsonElement(
					clearEntity.patientIntervention,
				)
		}
		if (amiIntervention_e && clearEntity.amiIntervention != null) {
			dataToEncrypt["amiIntervention"] =
				encodingJson.encodeToJsonElement(
					clearEntity.amiIntervention,
				)
		}
		if (doctorSupplement_e && clearEntity.doctorSupplement != null) {
			dataToEncrypt["doctorSupplement"] =
				encodingJson.encodeToJsonElement(
					clearEntity.doctorSupplement,
				)
		}
		if (conventionAmount_e && clearEntity.conventionAmount != null) {
			dataToEncrypt["conventionAmount"] =
				encodingJson.encodeToJsonElement(
					clearEntity.conventionAmount,
				)
		}
		if (vat_e && clearEntity.vat != null) dataToEncrypt["vat"] = encodingJson.encodeToJsonElement(clearEntity.vat)
		if (error_e && clearEntity.error != null) dataToEncrypt["error"] = encodingJson.encodeToJsonElement(clearEntity.error)
		if (contract_e && clearEntity.contract != null) dataToEncrypt["contract"] = encodingJson.encodeToJsonElement(clearEntity.contract)
		if (contractDate_e && clearEntity.contractDate != null) {
			dataToEncrypt["contractDate"] =
				encodingJson.encodeToJsonElement(
					clearEntity.contractDate,
				)
		}
		if (units_e && clearEntity.units != null) dataToEncrypt["units"] = encodingJson.encodeToJsonElement(clearEntity.units)
		if (side_e && clearEntity.side != null) dataToEncrypt["side"] = encodingJson.encodeToJsonElement(clearEntity.side)
		if (timeOfDay_e && clearEntity.timeOfDay != null) dataToEncrypt["timeOfDay"] = encodingJson.encodeToJsonElement(clearEntity.timeOfDay)
		if (eidReadingHour_e && clearEntity.eidReadingHour != null) {
			dataToEncrypt["eidReadingHour"] =
				encodingJson.encodeToJsonElement(
					clearEntity.eidReadingHour,
				)
		}
		if (eidReadingValue_e && clearEntity.eidReadingValue != null) {
			dataToEncrypt["eidReadingValue"] =
				encodingJson.encodeToJsonElement(
					clearEntity.eidReadingValue,
				)
		}
		if (override3rdPayerCode_e && clearEntity.override3rdPayerCode != null) {
			dataToEncrypt["override3rdPayerCode"] =
				encodingJson.encodeToJsonElement(
					clearEntity.override3rdPayerCode,
				)
		}
		if (override3rdPayerReason_e && clearEntity.override3rdPayerReason != null) {
			dataToEncrypt["override3rdPayerReason"] =
				encodingJson.encodeToJsonElement(
					clearEntity.override3rdPayerReason,
				)
		}
		if (transplantationCode_e && clearEntity.transplantationCode != null) {
			dataToEncrypt["transplantationCode"] =
				encodingJson.encodeToJsonElement(
					clearEntity.transplantationCode,
				)
		}
		if (prescriberNorm_e && clearEntity.prescriberNorm != null) {
			dataToEncrypt["prescriberNorm"] =
				encodingJson.encodeToJsonElement(
					clearEntity.prescriberNorm,
				)
		}
		if (productLabel_e && clearEntity.productLabel != null) {
			dataToEncrypt["productLabel"] =
				encodingJson.encodeToJsonElement(
					clearEntity.productLabel,
				)
		}
		if (percentNorm_e && clearEntity.percentNorm != null) {
			dataToEncrypt["percentNorm"] =
				encodingJson.encodeToJsonElement(
					clearEntity.percentNorm,
				)
		}
		if (prescriberNihii_e && clearEntity.prescriberNihii != null) {
			dataToEncrypt["prescriberNihii"] =
				encodingJson.encodeToJsonElement(
					clearEntity.prescriberNihii,
				)
		}
		if (relatedCode_e && clearEntity.relatedCode != null) {
			dataToEncrypt["relatedCode"] =
				encodingJson.encodeToJsonElement(
					clearEntity.relatedCode,
				)
		}
		if (prescriptionDate_e && clearEntity.prescriptionDate != null) {
			dataToEncrypt["prescriptionDate"] =
				encodingJson.encodeToJsonElement(
					clearEntity.prescriptionDate,
				)
		}
		if (derogationMaxNumber_e && clearEntity.derogationMaxNumber != null) {
			dataToEncrypt["derogationMaxNumber"] =
				encodingJson.encodeToJsonElement(
					clearEntity.derogationMaxNumber,
				)
		}
		if (prescriberSsin_e && clearEntity.prescriberSsin != null) {
			dataToEncrypt["prescriberSsin"] =
				encodingJson.encodeToJsonElement(
					clearEntity.prescriberSsin,
				)
		}
		if (prescriberLastName_e && clearEntity.prescriberLastName != null) {
			dataToEncrypt["prescriberLastName"] =
				encodingJson.encodeToJsonElement(
					clearEntity.prescriberLastName,
				)
		}
		if (prescriberFirstName_e && clearEntity.prescriberFirstName != null) {
			dataToEncrypt["prescriberFirstName"] =
				encodingJson.encodeToJsonElement(
					clearEntity.prescriberFirstName,
				)
		}
		if (prescriberCdHcParty_e && clearEntity.prescriberCdHcParty != null) {
			dataToEncrypt["prescriberCdHcParty"] =
				encodingJson.encodeToJsonElement(
					clearEntity.prescriberCdHcParty,
				)
		}
		if (locationNihii_e && clearEntity.locationNihii != null) {
			dataToEncrypt["locationNihii"] =
				encodingJson.encodeToJsonElement(
					clearEntity.locationNihii,
				)
		}
		if (locationCdHcParty_e && clearEntity.locationCdHcParty != null) {
			dataToEncrypt["locationCdHcParty"] =
				encodingJson.encodeToJsonElement(
					clearEntity.locationCdHcParty,
				)
		}
		if (locationService_e && clearEntity.locationService != null) {
			dataToEncrypt["locationService"] =
				encodingJson.encodeToJsonElement(
					clearEntity.locationService,
				)
		}
		if (admissionDate_e && clearEntity.admissionDate != null) {
			dataToEncrypt["admissionDate"] =
				encodingJson.encodeToJsonElement(
					clearEntity.admissionDate,
				)
		}
		if (canceled_e && clearEntity.canceled != null) dataToEncrypt["canceled"] = encodingJson.encodeToJsonElement(clearEntity.canceled)
		if (accepted_e && clearEntity.accepted != null) dataToEncrypt["accepted"] = encodingJson.encodeToJsonElement(clearEntity.accepted)
		if (pending_e && clearEntity.pending != null) dataToEncrypt["pending"] = encodingJson.encodeToJsonElement(clearEntity.pending)
		if (resent_e && clearEntity.resent != null) dataToEncrypt["resent"] = encodingJson.encodeToJsonElement(clearEntity.resent)
		if (archived_e && clearEntity.archived != null) dataToEncrypt["archived"] = encodingJson.encodeToJsonElement(clearEntity.archived)
		if (lost_e && clearEntity.lost != null) dataToEncrypt["lost"] = encodingJson.encodeToJsonElement(clearEntity.lost)
		if (insuranceJustification_e && clearEntity.insuranceJustification != null) {
			dataToEncrypt["insuranceJustification"] =
				encodingJson.encodeToJsonElement(
					clearEntity.insuranceJustification,
				)
		}
		if (cancelPatientInterventionReason_e && clearEntity.cancelPatientInterventionReason != null) {
			dataToEncrypt["cancelPatientInterventionReason"] =
				encodingJson.encodeToJsonElement(
					clearEntity.cancelPatientInterventionReason,
				)
		}
		if (status_e && clearEntity.status != null) dataToEncrypt["status"] = encodingJson.encodeToJsonElement(clearEntity.status)
		if (codeLabel_e && clearEntity.codeLabel != null) dataToEncrypt["codeLabel"] = encodingJson.encodeToJsonElement(clearEntity.codeLabel)
		if (options_e && clearEntity.options.isNotEmpty()) dataToEncrypt["options"] = encodingJson.encodeToJsonElement(clearEntity.options)
		return EncryptedInvoicingCode(
			id = clearEntity.id,
			dateCode = if (dateCode_e) null else clearEntity.dateCode,
			logicalId = if (logicalId_e) null else clearEntity.logicalId,
			label = if (label_e) null else clearEntity.label,
			userId = if (userId_e) null else clearEntity.userId,
			contactId = if (contactId_e) null else clearEntity.contactId,
			serviceId = if (serviceId_e) null else clearEntity.serviceId,
			pricingId = if (tarificationId_e) null else clearEntity.pricingId,
			code = if (code_e) null else clearEntity.code,
			paymentType = if (paymentType_e) null else clearEntity.paymentType,
			paid = if (paid_e) null else clearEntity.paid,
			totalAmount = if (totalAmount_e) null else clearEntity.totalAmount,
			reimbursement = if (reimbursement_e) null else clearEntity.reimbursement,
			patientIntervention = if (patientIntervention_e) null else clearEntity.patientIntervention,
			amiIntervention = if (amiIntervention_e) null else clearEntity.amiIntervention,
			doctorSupplement = if (doctorSupplement_e) null else clearEntity.doctorSupplement,
			conventionAmount = if (conventionAmount_e) null else clearEntity.conventionAmount,
			vat = if (vat_e) null else clearEntity.vat,
			error = if (error_e) null else clearEntity.error,
			contract = if (contract_e) null else clearEntity.contract,
			contractDate = if (contractDate_e) null else clearEntity.contractDate,
			units = if (units_e) null else clearEntity.units,
			side = if (side_e) null else clearEntity.side,
			timeOfDay = if (timeOfDay_e) null else clearEntity.timeOfDay,
			eidReadingHour = if (eidReadingHour_e) null else clearEntity.eidReadingHour,
			eidReadingValue = if (eidReadingValue_e) null else clearEntity.eidReadingValue,
			override3rdPayerCode = if (override3rdPayerCode_e) null else clearEntity.override3rdPayerCode,
			override3rdPayerReason = if (override3rdPayerReason_e) null else clearEntity.override3rdPayerReason,
			transplantationCode = if (transplantationCode_e) null else clearEntity.transplantationCode,
			prescriberNorm = if (prescriberNorm_e) null else clearEntity.prescriberNorm,
			productLabel = if (productLabel_e) null else clearEntity.productLabel,
			percentNorm = if (percentNorm_e) null else clearEntity.percentNorm,
			prescriberNihii = if (prescriberNihii_e) null else clearEntity.prescriberNihii,
			relatedCode = if (relatedCode_e) null else clearEntity.relatedCode,
			prescriptionDate = if (prescriptionDate_e) null else clearEntity.prescriptionDate,
			derogationMaxNumber = if (derogationMaxNumber_e) null else clearEntity.derogationMaxNumber,
			prescriberSsin = if (prescriberSsin_e) null else clearEntity.prescriberSsin,
			prescriberLastName = if (prescriberLastName_e) null else clearEntity.prescriberLastName,
			prescriberFirstName = if (prescriberFirstName_e) null else clearEntity.prescriberFirstName,
			prescriberCdHcParty = if (prescriberCdHcParty_e) null else clearEntity.prescriberCdHcParty,
			locationNihii = if (locationNihii_e) null else clearEntity.locationNihii,
			locationCdHcParty = if (locationCdHcParty_e) null else clearEntity.locationCdHcParty,
			locationService = if (locationService_e) null else clearEntity.locationService,
			admissionDate = if (admissionDate_e) null else clearEntity.admissionDate,
			canceled = if (canceled_e) null else clearEntity.canceled,
			accepted = if (accepted_e) null else clearEntity.accepted,
			pending = if (pending_e) null else clearEntity.pending,
			resent = if (resent_e) null else clearEntity.resent,
			archived = if (archived_e) null else clearEntity.archived,
			lost = if (lost_e) null else clearEntity.lost,
			insuranceJustification = if (insuranceJustification_e) null else clearEntity.insuranceJustification,
			cancelPatientInterventionReason = if (cancelPatientInterventionReason_e) null else clearEntity.cancelPatientInterventionReason,
			status = if (status_e) null else clearEntity.status,
			codeLabel = if (codeLabel_e) null else clearEntity.codeLabel,
			options = if (options_e) emptyMap() else clearEntity.options,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
		)
	}
}

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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object InvoicingCodeEncryptorFactory :
	EntityEncryptorFactory<EncryptedInvoicingCode, DecryptedInvoicingCode> {
	override val empty: EntityEncryptor<EncryptedInvoicingCode, DecryptedInvoicingCode> =
		InvoicingCodeEncryptor(
			dateCode = false,
			logicalId = false,
			label = false,
			userId = false,
			contactId = false,
			serviceId = false,
			tarificationId = false,
			code = false,
			paymentType = false,
			paid = false,
			totalAmount = false,
			reimbursement = false,
			patientIntervention = false,
			amiIntervention = false,
			doctorSupplement = false,
			conventionAmount = false,
			vat = false,
			error = false,
			contract = false,
			contractDate = false,
			units = false,
			side = false,
			timeOfDay = false,
			eidReadingHour = false,
			eidReadingValue = false,
			override3rdPayerCode = false,
			override3rdPayerReason = false,
			transplantationCode = false,
			prescriberNorm = false,
			productLabel = false,
			percentNorm = false,
			prescriberNihii = false,
			relatedCode = false,
			prescriptionDate = false,
			derogationMaxNumber = false,
			prescriberSsin = false,
			prescriberLastName = false,
			prescriberFirstName = false,
			prescriberCdHcParty = false,
			locationNihii = false,
			locationCdHcParty = false,
			locationService = false,
			admissionDate = false,
			canceled = false,
			accepted = false,
			pending = false,
			resent = false,
			archived = false,
			lost = false,
			insuranceJustification = false,
			cancelPatientInterventionReason = false,
			status = false,
			codeLabel = false,
			options = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedInvoicingCode, DecryptedInvoicingCode> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return InvoicingCodeEncryptor(
			dateCode = "dateCode" in manifest.fieldsToEncrypt,
			logicalId = "logicalId" in manifest.fieldsToEncrypt,
			label = "label" in manifest.fieldsToEncrypt,
			userId = "userId" in manifest.fieldsToEncrypt,
			contactId = "contactId" in manifest.fieldsToEncrypt,
			serviceId = "serviceId" in manifest.fieldsToEncrypt,
			tarificationId = "tarificationId" in manifest.fieldsToEncrypt,
			code = "code" in manifest.fieldsToEncrypt,
			paymentType = "paymentType" in manifest.fieldsToEncrypt,
			paid = "paid" in manifest.fieldsToEncrypt,
			totalAmount = "totalAmount" in manifest.fieldsToEncrypt,
			reimbursement = "reimbursement" in manifest.fieldsToEncrypt,
			patientIntervention = "patientIntervention" in manifest.fieldsToEncrypt,
			amiIntervention = "amiIntervention" in manifest.fieldsToEncrypt,
			doctorSupplement = "doctorSupplement" in manifest.fieldsToEncrypt,
			conventionAmount = "conventionAmount" in manifest.fieldsToEncrypt,
			vat = "vat" in manifest.fieldsToEncrypt,
			error = "error" in manifest.fieldsToEncrypt,
			contract = "contract" in manifest.fieldsToEncrypt,
			contractDate = "contractDate" in manifest.fieldsToEncrypt,
			units = "units" in manifest.fieldsToEncrypt,
			side = "side" in manifest.fieldsToEncrypt,
			timeOfDay = "timeOfDay" in manifest.fieldsToEncrypt,
			eidReadingHour = "eidReadingHour" in manifest.fieldsToEncrypt,
			eidReadingValue = "eidReadingValue" in manifest.fieldsToEncrypt,
			override3rdPayerCode = "override3rdPayerCode" in manifest.fieldsToEncrypt,
			override3rdPayerReason = "override3rdPayerReason" in manifest.fieldsToEncrypt,
			transplantationCode = "transplantationCode" in manifest.fieldsToEncrypt,
			prescriberNorm = "prescriberNorm" in manifest.fieldsToEncrypt,
			productLabel = "productLabel" in manifest.fieldsToEncrypt,
			percentNorm = "percentNorm" in manifest.fieldsToEncrypt,
			prescriberNihii = "prescriberNihii" in manifest.fieldsToEncrypt,
			relatedCode = "relatedCode" in manifest.fieldsToEncrypt,
			prescriptionDate = "prescriptionDate" in manifest.fieldsToEncrypt,
			derogationMaxNumber = "derogationMaxNumber" in manifest.fieldsToEncrypt,
			prescriberSsin = "prescriberSsin" in manifest.fieldsToEncrypt,
			prescriberLastName = "prescriberLastName" in manifest.fieldsToEncrypt,
			prescriberFirstName = "prescriberFirstName" in manifest.fieldsToEncrypt,
			prescriberCdHcParty = "prescriberCdHcParty" in manifest.fieldsToEncrypt,
			locationNihii = "locationNihii" in manifest.fieldsToEncrypt,
			locationCdHcParty = "locationCdHcParty" in manifest.fieldsToEncrypt,
			locationService = "locationService" in manifest.fieldsToEncrypt,
			admissionDate = "admissionDate" in manifest.fieldsToEncrypt,
			canceled = "canceled" in manifest.fieldsToEncrypt,
			accepted = "accepted" in manifest.fieldsToEncrypt,
			pending = "pending" in manifest.fieldsToEncrypt,
			resent = "resent" in manifest.fieldsToEncrypt,
			archived = "archived" in manifest.fieldsToEncrypt,
			lost = "lost" in manifest.fieldsToEncrypt,
			insuranceJustification = "insuranceJustification" in manifest.fieldsToEncrypt,
			cancelPatientInterventionReason = "cancelPatientInterventionReason" in manifest.fieldsToEncrypt,
			status = "status" in manifest.fieldsToEncrypt,
			codeLabel = "codeLabel" in manifest.fieldsToEncrypt,
			options = "options" in manifest.fieldsToEncrypt,
		)
	}
}

private class InvoicingCodeEncryptor(
	private val dateCode: Boolean,
	private val logicalId: Boolean,
	private val label: Boolean,
	private val userId: Boolean,
	private val contactId: Boolean,
	private val serviceId: Boolean,
	private val tarificationId: Boolean,
	private val code: Boolean,
	private val paymentType: Boolean,
	private val paid: Boolean,
	private val totalAmount: Boolean,
	private val reimbursement: Boolean,
	private val patientIntervention: Boolean,
	private val amiIntervention: Boolean,
	private val doctorSupplement: Boolean,
	private val conventionAmount: Boolean,
	private val vat: Boolean,
	private val error: Boolean,
	private val contract: Boolean,
	private val contractDate: Boolean,
	private val units: Boolean,
	private val side: Boolean,
	private val timeOfDay: Boolean,
	private val eidReadingHour: Boolean,
	private val eidReadingValue: Boolean,
	private val override3rdPayerCode: Boolean,
	private val override3rdPayerReason: Boolean,
	private val transplantationCode: Boolean,
	private val prescriberNorm: Boolean,
	private val productLabel: Boolean,
	private val percentNorm: Boolean,
	private val prescriberNihii: Boolean,
	private val relatedCode: Boolean,
	private val prescriptionDate: Boolean,
	private val derogationMaxNumber: Boolean,
	private val prescriberSsin: Boolean,
	private val prescriberLastName: Boolean,
	private val prescriberFirstName: Boolean,
	private val prescriberCdHcParty: Boolean,
	private val locationNihii: Boolean,
	private val locationCdHcParty: Boolean,
	private val locationService: Boolean,
	private val admissionDate: Boolean,
	private val canceled: Boolean,
	private val accepted: Boolean,
	private val pending: Boolean,
	private val resent: Boolean,
	private val archived: Boolean,
	private val lost: Boolean,
	private val insuranceJustification: Boolean,
	private val cancelPatientInterventionReason: Boolean,
	private val status: Boolean,
	private val codeLabel: Boolean,
	private val options: Boolean,
) : AbstractEntityEncryptor<EncryptedInvoicingCode, DecryptedInvoicingCode>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedInvoicingCode,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedInvoicingCode {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (dateCode) dataToEncrypt["dateCode"] = encodingJson.encodeToJsonElement(clearEntity.dateCode)
		if (logicalId) dataToEncrypt["logicalId"] = encodingJson.encodeToJsonElement(clearEntity.logicalId)
		if (label) dataToEncrypt["label"] = encodingJson.encodeToJsonElement(clearEntity.label)
		if (userId) dataToEncrypt["userId"] = encodingJson.encodeToJsonElement(clearEntity.userId)
		if (contactId) dataToEncrypt["contactId"] = encodingJson.encodeToJsonElement(clearEntity.contactId)
		if (serviceId) dataToEncrypt["serviceId"] = encodingJson.encodeToJsonElement(clearEntity.serviceId)
		if (tarificationId) dataToEncrypt["tarificationId"] = encodingJson.encodeToJsonElement(clearEntity.tarificationId)
		if (code) dataToEncrypt["code"] = encodingJson.encodeToJsonElement(clearEntity.code)
		if (paymentType) dataToEncrypt["paymentType"] = encodingJson.encodeToJsonElement(clearEntity.paymentType)
		if (paid) dataToEncrypt["paid"] = encodingJson.encodeToJsonElement(clearEntity.paid)
		if (totalAmount) dataToEncrypt["totalAmount"] = encodingJson.encodeToJsonElement(clearEntity.totalAmount)
		if (reimbursement) dataToEncrypt["reimbursement"] = encodingJson.encodeToJsonElement(clearEntity.reimbursement)
		if (patientIntervention) dataToEncrypt["patientIntervention"] = encodingJson.encodeToJsonElement(clearEntity.patientIntervention)
		if (amiIntervention) dataToEncrypt["amiIntervention"] = encodingJson.encodeToJsonElement(clearEntity.amiIntervention)
		if (doctorSupplement) dataToEncrypt["doctorSupplement"] = encodingJson.encodeToJsonElement(clearEntity.doctorSupplement)
		if (conventionAmount) dataToEncrypt["conventionAmount"] = encodingJson.encodeToJsonElement(clearEntity.conventionAmount)
		if (vat) dataToEncrypt["vat"] = encodingJson.encodeToJsonElement(clearEntity.vat)
		if (error) dataToEncrypt["error"] = encodingJson.encodeToJsonElement(clearEntity.error)
		if (contract) dataToEncrypt["contract"] = encodingJson.encodeToJsonElement(clearEntity.contract)
		if (contractDate) dataToEncrypt["contractDate"] = encodingJson.encodeToJsonElement(clearEntity.contractDate)
		if (units) dataToEncrypt["units"] = encodingJson.encodeToJsonElement(clearEntity.units)
		if (side) dataToEncrypt["side"] = encodingJson.encodeToJsonElement(clearEntity.side)
		if (timeOfDay) dataToEncrypt["timeOfDay"] = encodingJson.encodeToJsonElement(clearEntity.timeOfDay)
		if (eidReadingHour) dataToEncrypt["eidReadingHour"] = encodingJson.encodeToJsonElement(clearEntity.eidReadingHour)
		if (eidReadingValue) dataToEncrypt["eidReadingValue"] = encodingJson.encodeToJsonElement(clearEntity.eidReadingValue)
		if (override3rdPayerCode) dataToEncrypt["override3rdPayerCode"] = encodingJson.encodeToJsonElement(clearEntity.override3rdPayerCode)
		if (override3rdPayerReason) dataToEncrypt["override3rdPayerReason"] = encodingJson.encodeToJsonElement(clearEntity.override3rdPayerReason)
		if (transplantationCode) dataToEncrypt["transplantationCode"] = encodingJson.encodeToJsonElement(clearEntity.transplantationCode)
		if (prescriberNorm) dataToEncrypt["prescriberNorm"] = encodingJson.encodeToJsonElement(clearEntity.prescriberNorm)
		if (productLabel) dataToEncrypt["productLabel"] = encodingJson.encodeToJsonElement(clearEntity.productLabel)
		if (percentNorm) dataToEncrypt["percentNorm"] = encodingJson.encodeToJsonElement(clearEntity.percentNorm)
		if (prescriberNihii) dataToEncrypt["prescriberNihii"] = encodingJson.encodeToJsonElement(clearEntity.prescriberNihii)
		if (relatedCode) dataToEncrypt["relatedCode"] = encodingJson.encodeToJsonElement(clearEntity.relatedCode)
		if (prescriptionDate) dataToEncrypt["prescriptionDate"] = encodingJson.encodeToJsonElement(clearEntity.prescriptionDate)
		if (derogationMaxNumber) dataToEncrypt["derogationMaxNumber"] = encodingJson.encodeToJsonElement(clearEntity.derogationMaxNumber)
		if (prescriberSsin) dataToEncrypt["prescriberSsin"] = encodingJson.encodeToJsonElement(clearEntity.prescriberSsin)
		if (prescriberLastName) dataToEncrypt["prescriberLastName"] = encodingJson.encodeToJsonElement(clearEntity.prescriberLastName)
		if (prescriberFirstName) dataToEncrypt["prescriberFirstName"] = encodingJson.encodeToJsonElement(clearEntity.prescriberFirstName)
		if (prescriberCdHcParty) dataToEncrypt["prescriberCdHcParty"] = encodingJson.encodeToJsonElement(clearEntity.prescriberCdHcParty)
		if (locationNihii) dataToEncrypt["locationNihii"] = encodingJson.encodeToJsonElement(clearEntity.locationNihii)
		if (locationCdHcParty) dataToEncrypt["locationCdHcParty"] = encodingJson.encodeToJsonElement(clearEntity.locationCdHcParty)
		if (locationService) dataToEncrypt["locationService"] = encodingJson.encodeToJsonElement(clearEntity.locationService)
		if (admissionDate) dataToEncrypt["admissionDate"] = encodingJson.encodeToJsonElement(clearEntity.admissionDate)
		if (canceled) dataToEncrypt["canceled"] = encodingJson.encodeToJsonElement(clearEntity.canceled)
		if (accepted) dataToEncrypt["accepted"] = encodingJson.encodeToJsonElement(clearEntity.accepted)
		if (pending) dataToEncrypt["pending"] = encodingJson.encodeToJsonElement(clearEntity.pending)
		if (resent) dataToEncrypt["resent"] = encodingJson.encodeToJsonElement(clearEntity.resent)
		if (archived) dataToEncrypt["archived"] = encodingJson.encodeToJsonElement(clearEntity.archived)
		if (lost) dataToEncrypt["lost"] = encodingJson.encodeToJsonElement(clearEntity.lost)
		if (insuranceJustification) dataToEncrypt["insuranceJustification"] = encodingJson.encodeToJsonElement(clearEntity.insuranceJustification)
		if (cancelPatientInterventionReason) {
			dataToEncrypt["cancelPatientInterventionReason"] =
				encodingJson.encodeToJsonElement(
					clearEntity.cancelPatientInterventionReason,
				)
		}
		if (status) dataToEncrypt["status"] = encodingJson.encodeToJsonElement(clearEntity.status)
		if (codeLabel) dataToEncrypt["codeLabel"] = encodingJson.encodeToJsonElement(clearEntity.codeLabel)
		if (options) dataToEncrypt["options"] = encodingJson.encodeToJsonElement(clearEntity.options)
		return EncryptedInvoicingCode(
			id = clearEntity.id,
			dateCode = if (dateCode) null else clearEntity.dateCode,
			logicalId = if (logicalId) null else clearEntity.logicalId,
			label = if (label) null else clearEntity.label,
			userId = if (userId) null else clearEntity.userId,
			contactId = if (contactId) null else clearEntity.contactId,
			serviceId = if (serviceId) null else clearEntity.serviceId,
			tarificationId = if (tarificationId) null else clearEntity.tarificationId,
			code = if (code) null else clearEntity.code,
			paymentType = if (paymentType) null else clearEntity.paymentType,
			paid = if (paid) null else clearEntity.paid,
			totalAmount = if (totalAmount) null else clearEntity.totalAmount,
			reimbursement = if (reimbursement) null else clearEntity.reimbursement,
			patientIntervention = if (patientIntervention) null else clearEntity.patientIntervention,
			amiIntervention = if (amiIntervention) null else clearEntity.amiIntervention,
			doctorSupplement = if (doctorSupplement) null else clearEntity.doctorSupplement,
			conventionAmount = if (conventionAmount) null else clearEntity.conventionAmount,
			vat = if (vat) null else clearEntity.vat,
			error = if (error) null else clearEntity.error,
			contract = if (contract) null else clearEntity.contract,
			contractDate = if (contractDate) null else clearEntity.contractDate,
			units = if (units) null else clearEntity.units,
			side = if (side) null else clearEntity.side,
			timeOfDay = if (timeOfDay) null else clearEntity.timeOfDay,
			eidReadingHour = if (eidReadingHour) null else clearEntity.eidReadingHour,
			eidReadingValue = if (eidReadingValue) null else clearEntity.eidReadingValue,
			override3rdPayerCode = if (override3rdPayerCode) null else clearEntity.override3rdPayerCode,
			override3rdPayerReason = if (override3rdPayerReason) null else clearEntity.override3rdPayerReason,
			transplantationCode = if (transplantationCode) null else clearEntity.transplantationCode,
			prescriberNorm = if (prescriberNorm) null else clearEntity.prescriberNorm,
			productLabel = if (productLabel) null else clearEntity.productLabel,
			percentNorm = if (percentNorm) null else clearEntity.percentNorm,
			prescriberNihii = if (prescriberNihii) null else clearEntity.prescriberNihii,
			relatedCode = if (relatedCode) null else clearEntity.relatedCode,
			prescriptionDate = if (prescriptionDate) null else clearEntity.prescriptionDate,
			derogationMaxNumber = if (derogationMaxNumber) null else clearEntity.derogationMaxNumber,
			prescriberSsin = if (prescriberSsin) null else clearEntity.prescriberSsin,
			prescriberLastName = if (prescriberLastName) null else clearEntity.prescriberLastName,
			prescriberFirstName = if (prescriberFirstName) null else clearEntity.prescriberFirstName,
			prescriberCdHcParty = if (prescriberCdHcParty) null else clearEntity.prescriberCdHcParty,
			locationNihii = if (locationNihii) null else clearEntity.locationNihii,
			locationCdHcParty = if (locationCdHcParty) null else clearEntity.locationCdHcParty,
			locationService = if (locationService) null else clearEntity.locationService,
			admissionDate = if (admissionDate) null else clearEntity.admissionDate,
			canceled = if (canceled) null else clearEntity.canceled,
			accepted = if (accepted) null else clearEntity.accepted,
			pending = if (pending) null else clearEntity.pending,
			resent = if (resent) null else clearEntity.resent,
			archived = if (archived) null else clearEntity.archived,
			lost = if (lost) null else clearEntity.lost,
			insuranceJustification = if (insuranceJustification) null else clearEntity.insuranceJustification,
			cancelPatientInterventionReason = if (cancelPatientInterventionReason) null else clearEntity.cancelPatientInterventionReason,
			status = if (status) null else clearEntity.status,
			codeLabel = if (codeLabel) null else clearEntity.codeLabel,
			options = if (options) emptyMap() else clearEntity.options,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}

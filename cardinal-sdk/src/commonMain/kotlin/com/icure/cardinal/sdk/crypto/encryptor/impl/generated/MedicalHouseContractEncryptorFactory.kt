// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.EncryptedMedicalHouseContract
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object MedicalHouseContractEncryptorFactory :
	EntityEncryptorFactory<EncryptedMedicalHouseContract, DecryptedMedicalHouseContract> {
	override val empty: EntityEncryptor<EncryptedMedicalHouseContract, DecryptedMedicalHouseContract> =
		MedicalHouseContractEncryptor(
			contractId = false,
			validFrom = false,
			validTo = false,
			mmNihii = false,
			hcpId = false,
			changeType = false,
			parentContractId = false,
			changedBy = false,
			startOfContract = false,
			startOfCoverage = false,
			endOfContract = false,
			endOfCoverage = false,
			kine = false,
			gp = false,
			ptd = false,
			nurse = false,
			noKine = false,
			noGp = false,
			noNurse = false,
			unsubscriptionReasonId = false,
			ptdStart = false,
			ptdEnd = false,
			ptdLastInvoiced = false,
			startOfSuspension = false,
			endOfSuspension = false,
			suspensionReason = false,
			suspensionSource = false,
			forcedSuspension = false,
			signatureType = false,
			status = false,
			options = false,
			receipts = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedMedicalHouseContract, DecryptedMedicalHouseContract> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return MedicalHouseContractEncryptor(
			contractId = "contractId" in manifest.fieldsToEncrypt,
			validFrom = "validFrom" in manifest.fieldsToEncrypt,
			validTo = "validTo" in manifest.fieldsToEncrypt,
			mmNihii = "mmNihii" in manifest.fieldsToEncrypt,
			hcpId = "hcpId" in manifest.fieldsToEncrypt,
			changeType = "changeType" in manifest.fieldsToEncrypt,
			parentContractId = "parentContractId" in manifest.fieldsToEncrypt,
			changedBy = "changedBy" in manifest.fieldsToEncrypt,
			startOfContract = "startOfContract" in manifest.fieldsToEncrypt,
			startOfCoverage = "startOfCoverage" in manifest.fieldsToEncrypt,
			endOfContract = "endOfContract" in manifest.fieldsToEncrypt,
			endOfCoverage = "endOfCoverage" in manifest.fieldsToEncrypt,
			kine = "kine" in manifest.fieldsToEncrypt,
			gp = "gp" in manifest.fieldsToEncrypt,
			ptd = "ptd" in manifest.fieldsToEncrypt,
			nurse = "nurse" in manifest.fieldsToEncrypt,
			noKine = "noKine" in manifest.fieldsToEncrypt,
			noGp = "noGp" in manifest.fieldsToEncrypt,
			noNurse = "noNurse" in manifest.fieldsToEncrypt,
			unsubscriptionReasonId = "unsubscriptionReasonId" in manifest.fieldsToEncrypt,
			ptdStart = "ptdStart" in manifest.fieldsToEncrypt,
			ptdEnd = "ptdEnd" in manifest.fieldsToEncrypt,
			ptdLastInvoiced = "ptdLastInvoiced" in manifest.fieldsToEncrypt,
			startOfSuspension = "startOfSuspension" in manifest.fieldsToEncrypt,
			endOfSuspension = "endOfSuspension" in manifest.fieldsToEncrypt,
			suspensionReason = "suspensionReason" in manifest.fieldsToEncrypt,
			suspensionSource = "suspensionSource" in manifest.fieldsToEncrypt,
			forcedSuspension = "forcedSuspension" in manifest.fieldsToEncrypt,
			signatureType = "signatureType" in manifest.fieldsToEncrypt,
			status = "status" in manifest.fieldsToEncrypt,
			options = "options" in manifest.fieldsToEncrypt,
			receipts = "receipts" in manifest.fieldsToEncrypt,
		)
	}
}

private class MedicalHouseContractEncryptor(
	private val contractId: Boolean,
	private val validFrom: Boolean,
	private val validTo: Boolean,
	private val mmNihii: Boolean,
	private val hcpId: Boolean,
	private val changeType: Boolean,
	private val parentContractId: Boolean,
	private val changedBy: Boolean,
	private val startOfContract: Boolean,
	private val startOfCoverage: Boolean,
	private val endOfContract: Boolean,
	private val endOfCoverage: Boolean,
	private val kine: Boolean,
	private val gp: Boolean,
	private val ptd: Boolean,
	private val nurse: Boolean,
	private val noKine: Boolean,
	private val noGp: Boolean,
	private val noNurse: Boolean,
	private val unsubscriptionReasonId: Boolean,
	private val ptdStart: Boolean,
	private val ptdEnd: Boolean,
	private val ptdLastInvoiced: Boolean,
	private val startOfSuspension: Boolean,
	private val endOfSuspension: Boolean,
	private val suspensionReason: Boolean,
	private val suspensionSource: Boolean,
	private val forcedSuspension: Boolean,
	private val signatureType: Boolean,
	private val status: Boolean,
	private val options: Boolean,
	private val receipts: Boolean,
) : AbstractEntityEncryptor<EncryptedMedicalHouseContract, DecryptedMedicalHouseContract>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedMedicalHouseContract,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedMedicalHouseContract {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (contractId) dataToEncrypt["contractId"] = encodingJson.encodeToJsonElement(clearEntity.contractId)
		if (validFrom) dataToEncrypt["validFrom"] = encodingJson.encodeToJsonElement(clearEntity.validFrom)
		if (validTo) dataToEncrypt["validTo"] = encodingJson.encodeToJsonElement(clearEntity.validTo)
		if (mmNihii) dataToEncrypt["mmNihii"] = encodingJson.encodeToJsonElement(clearEntity.mmNihii)
		if (hcpId) dataToEncrypt["hcpId"] = encodingJson.encodeToJsonElement(clearEntity.hcpId)
		if (changeType) dataToEncrypt["changeType"] = encodingJson.encodeToJsonElement(clearEntity.changeType)
		if (parentContractId) dataToEncrypt["parentContractId"] = encodingJson.encodeToJsonElement(clearEntity.parentContractId)
		if (changedBy) dataToEncrypt["changedBy"] = encodingJson.encodeToJsonElement(clearEntity.changedBy)
		if (startOfContract) dataToEncrypt["startOfContract"] = encodingJson.encodeToJsonElement(clearEntity.startOfContract)
		if (startOfCoverage) dataToEncrypt["startOfCoverage"] = encodingJson.encodeToJsonElement(clearEntity.startOfCoverage)
		if (endOfContract) dataToEncrypt["endOfContract"] = encodingJson.encodeToJsonElement(clearEntity.endOfContract)
		if (endOfCoverage) dataToEncrypt["endOfCoverage"] = encodingJson.encodeToJsonElement(clearEntity.endOfCoverage)
		if (kine) dataToEncrypt["kine"] = encodingJson.encodeToJsonElement(clearEntity.kine)
		if (gp) dataToEncrypt["gp"] = encodingJson.encodeToJsonElement(clearEntity.gp)
		if (ptd) dataToEncrypt["ptd"] = encodingJson.encodeToJsonElement(clearEntity.ptd)
		if (nurse) dataToEncrypt["nurse"] = encodingJson.encodeToJsonElement(clearEntity.nurse)
		if (noKine) dataToEncrypt["noKine"] = encodingJson.encodeToJsonElement(clearEntity.noKine)
		if (noGp) dataToEncrypt["noGp"] = encodingJson.encodeToJsonElement(clearEntity.noGp)
		if (noNurse) dataToEncrypt["noNurse"] = encodingJson.encodeToJsonElement(clearEntity.noNurse)
		if (unsubscriptionReasonId) dataToEncrypt["unsubscriptionReasonId"] = encodingJson.encodeToJsonElement(clearEntity.unsubscriptionReasonId)
		if (ptdStart) dataToEncrypt["ptdStart"] = encodingJson.encodeToJsonElement(clearEntity.ptdStart)
		if (ptdEnd) dataToEncrypt["ptdEnd"] = encodingJson.encodeToJsonElement(clearEntity.ptdEnd)
		if (ptdLastInvoiced) dataToEncrypt["ptdLastInvoiced"] = encodingJson.encodeToJsonElement(clearEntity.ptdLastInvoiced)
		if (startOfSuspension) dataToEncrypt["startOfSuspension"] = encodingJson.encodeToJsonElement(clearEntity.startOfSuspension)
		if (endOfSuspension) dataToEncrypt["endOfSuspension"] = encodingJson.encodeToJsonElement(clearEntity.endOfSuspension)
		if (suspensionReason) dataToEncrypt["suspensionReason"] = encodingJson.encodeToJsonElement(clearEntity.suspensionReason)
		if (suspensionSource) dataToEncrypt["suspensionSource"] = encodingJson.encodeToJsonElement(clearEntity.suspensionSource)
		if (forcedSuspension) dataToEncrypt["forcedSuspension"] = encodingJson.encodeToJsonElement(clearEntity.forcedSuspension)
		if (signatureType) dataToEncrypt["signatureType"] = encodingJson.encodeToJsonElement(clearEntity.signatureType)
		if (status) dataToEncrypt["status"] = encodingJson.encodeToJsonElement(clearEntity.status)
		if (options) dataToEncrypt["options"] = encodingJson.encodeToJsonElement(clearEntity.options)
		if (receipts) dataToEncrypt["receipts"] = encodingJson.encodeToJsonElement(clearEntity.receipts)
		return EncryptedMedicalHouseContract(
			contractId = if (contractId) null else clearEntity.contractId,
			validFrom = if (validFrom) null else clearEntity.validFrom,
			validTo = if (validTo) null else clearEntity.validTo,
			mmNihii = if (mmNihii) null else clearEntity.mmNihii,
			hcpId = if (hcpId) null else clearEntity.hcpId,
			changeType = if (changeType) null else clearEntity.changeType,
			parentContractId = if (parentContractId) null else clearEntity.parentContractId,
			changedBy = if (changedBy) null else clearEntity.changedBy,
			startOfContract = if (startOfContract) null else clearEntity.startOfContract,
			startOfCoverage = if (startOfCoverage) null else clearEntity.startOfCoverage,
			endOfContract = if (endOfContract) null else clearEntity.endOfContract,
			endOfCoverage = if (endOfCoverage) null else clearEntity.endOfCoverage,
			kine = if (kine) false else clearEntity.kine,
			gp = if (gp) false else clearEntity.gp,
			ptd = if (ptd) false else clearEntity.ptd,
			nurse = if (nurse) false else clearEntity.nurse,
			noKine = if (noKine) false else clearEntity.noKine,
			noGp = if (noGp) false else clearEntity.noGp,
			noNurse = if (noNurse) false else clearEntity.noNurse,
			unsubscriptionReasonId = if (unsubscriptionReasonId) null else clearEntity.unsubscriptionReasonId,
			ptdStart = if (ptdStart) null else clearEntity.ptdStart,
			ptdEnd = if (ptdEnd) null else clearEntity.ptdEnd,
			ptdLastInvoiced = if (ptdLastInvoiced) null else clearEntity.ptdLastInvoiced,
			startOfSuspension = if (startOfSuspension) null else clearEntity.startOfSuspension,
			endOfSuspension = if (endOfSuspension) null else clearEntity.endOfSuspension,
			suspensionReason = if (suspensionReason) null else clearEntity.suspensionReason,
			suspensionSource = if (suspensionSource) null else clearEntity.suspensionSource,
			forcedSuspension = if (forcedSuspension) false else clearEntity.forcedSuspension,
			signatureType = if (signatureType) null else clearEntity.signatureType,
			status = if (status) null else clearEntity.status,
			options = if (options) emptyMap() else clearEntity.options,
			receipts = if (receipts) emptyMap() else clearEntity.receipts,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}

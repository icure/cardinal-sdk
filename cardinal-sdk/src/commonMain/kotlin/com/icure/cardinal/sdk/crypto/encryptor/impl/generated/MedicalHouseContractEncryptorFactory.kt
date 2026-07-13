// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedMedicalHouseContract
import com.icure.cardinal.sdk.model.embed.EncryptedMedicalHouseContract
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
internal object MedicalHouseContractEncryptorFactory :
	EntityEncryptorFactory<EncryptedMedicalHouseContract, DecryptedMedicalHouseContract> {
	override val empty: EntityEncryptor<EncryptedMedicalHouseContract, DecryptedMedicalHouseContract> =
		object : EntityEncryptor<EncryptedMedicalHouseContract, DecryptedMedicalHouseContract> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedMedicalHouseContract,
			): EncryptedMedicalHouseContract =
				EncryptedMedicalHouseContract(
					contractId = clearEntity.contractId,
					validFrom = clearEntity.validFrom,
					validTo = clearEntity.validTo,
					mmNihii = clearEntity.mmNihii,
					hcpId = clearEntity.hcpId,
					changeType = clearEntity.changeType,
					parentContractId = clearEntity.parentContractId,
					changedBy = clearEntity.changedBy,
					startOfContract = clearEntity.startOfContract,
					startOfCoverage = clearEntity.startOfCoverage,
					endOfContract = clearEntity.endOfContract,
					endOfCoverage = clearEntity.endOfCoverage,
					kine = clearEntity.kine,
					gp = clearEntity.gp,
					ptd = clearEntity.ptd,
					nurse = clearEntity.nurse,
					noKine = clearEntity.noKine,
					noGp = clearEntity.noGp,
					noNurse = clearEntity.noNurse,
					unsubscriptionReasonId = clearEntity.unsubscriptionReasonId,
					ptdStart = clearEntity.ptdStart,
					ptdEnd = clearEntity.ptdEnd,
					ptdLastInvoiced = clearEntity.ptdLastInvoiced,
					startOfSuspension = clearEntity.startOfSuspension,
					endOfSuspension = clearEntity.endOfSuspension,
					suspensionReason = clearEntity.suspensionReason,
					suspensionSource = clearEntity.suspensionSource,
					forcedSuspension = clearEntity.forcedSuspension,
					signatureType = clearEntity.signatureType,
					status = clearEntity.status,
					options = clearEntity.options,
					receipts = clearEntity.receipts,
					encryptedSelf = null,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedMedicalHouseContract, DecryptedMedicalHouseContract> {
		val manifest = encryptorsFactoryContext.getManifest(entityManifestName)
		require(manifest.currentExtensionsManifest == null) {
			"MedicalHouseContract is not Extendable and does not support extensions encryption, but its manifest defines a currentExtensionsManifest."
		}
		return MedicalHouseContractEncryptor(
			contractId_e = "contractId" in manifest.fieldsToEncrypt,
			validFrom_e = "validFrom" in manifest.fieldsToEncrypt,
			validTo_e = "validTo" in manifest.fieldsToEncrypt,
			mmNihii_e = "mmNihii" in manifest.fieldsToEncrypt,
			hcpId_e = "hcpId" in manifest.fieldsToEncrypt,
			changeType_e = "changeType" in manifest.fieldsToEncrypt,
			parentContractId_e = "parentContractId" in manifest.fieldsToEncrypt,
			changedBy_e = "changedBy" in manifest.fieldsToEncrypt,
			startOfContract_e = "startOfContract" in manifest.fieldsToEncrypt,
			startOfCoverage_e = "startOfCoverage" in manifest.fieldsToEncrypt,
			endOfContract_e = "endOfContract" in manifest.fieldsToEncrypt,
			endOfCoverage_e = "endOfCoverage" in manifest.fieldsToEncrypt,
			kine_e = "kine" in manifest.fieldsToEncrypt,
			gp_e = "gp" in manifest.fieldsToEncrypt,
			ptd_e = "ptd" in manifest.fieldsToEncrypt,
			nurse_e = "nurse" in manifest.fieldsToEncrypt,
			noKine_e = "noKine" in manifest.fieldsToEncrypt,
			noGp_e = "noGp" in manifest.fieldsToEncrypt,
			noNurse_e = "noNurse" in manifest.fieldsToEncrypt,
			unsubscriptionReasonId_e = "unsubscriptionReasonId" in manifest.fieldsToEncrypt,
			ptdStart_e = "ptdStart" in manifest.fieldsToEncrypt,
			ptdEnd_e = "ptdEnd" in manifest.fieldsToEncrypt,
			ptdLastInvoiced_e = "ptdLastInvoiced" in manifest.fieldsToEncrypt,
			startOfSuspension_e = "startOfSuspension" in manifest.fieldsToEncrypt,
			endOfSuspension_e = "endOfSuspension" in manifest.fieldsToEncrypt,
			suspensionReason_e = "suspensionReason" in manifest.fieldsToEncrypt,
			suspensionSource_e = "suspensionSource" in manifest.fieldsToEncrypt,
			forcedSuspension_e = "forcedSuspension" in manifest.fieldsToEncrypt,
			signatureType_e = "signatureType" in manifest.fieldsToEncrypt,
			status_e = "status" in manifest.fieldsToEncrypt,
			options_e = "options" in manifest.fieldsToEncrypt,
			receipts_e = "receipts" in manifest.fieldsToEncrypt,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class MedicalHouseContractEncryptor(
	private val contractId_e: Boolean,
	private val validFrom_e: Boolean,
	private val validTo_e: Boolean,
	private val mmNihii_e: Boolean,
	private val hcpId_e: Boolean,
	private val changeType_e: Boolean,
	private val parentContractId_e: Boolean,
	private val changedBy_e: Boolean,
	private val startOfContract_e: Boolean,
	private val startOfCoverage_e: Boolean,
	private val endOfContract_e: Boolean,
	private val endOfCoverage_e: Boolean,
	private val kine_e: Boolean,
	private val gp_e: Boolean,
	private val ptd_e: Boolean,
	private val nurse_e: Boolean,
	private val noKine_e: Boolean,
	private val noGp_e: Boolean,
	private val noNurse_e: Boolean,
	private val unsubscriptionReasonId_e: Boolean,
	private val ptdStart_e: Boolean,
	private val ptdEnd_e: Boolean,
	private val ptdLastInvoiced_e: Boolean,
	private val startOfSuspension_e: Boolean,
	private val endOfSuspension_e: Boolean,
	private val suspensionReason_e: Boolean,
	private val suspensionSource_e: Boolean,
	private val forcedSuspension_e: Boolean,
	private val signatureType_e: Boolean,
	private val status_e: Boolean,
	private val options_e: Boolean,
	private val receipts_e: Boolean,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) :
	AbstractEntityEncryptor<EncryptedMedicalHouseContract, DecryptedMedicalHouseContract>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedMedicalHouseContract,
	): EncryptedMedicalHouseContract {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (contractId_e && clearEntity.contractId != null) dataToEncrypt["contractId"] = encodingJson.encodeToJsonElement(clearEntity.contractId)
		if (validFrom_e && clearEntity.validFrom != null) dataToEncrypt["validFrom"] = encodingJson.encodeToJsonElement(clearEntity.validFrom)
		if (validTo_e && clearEntity.validTo != null) dataToEncrypt["validTo"] = encodingJson.encodeToJsonElement(clearEntity.validTo)
		if (mmNihii_e && clearEntity.mmNihii != null) dataToEncrypt["mmNihii"] = encodingJson.encodeToJsonElement(clearEntity.mmNihii)
		if (hcpId_e && clearEntity.hcpId != null) dataToEncrypt["hcpId"] = encodingJson.encodeToJsonElement(clearEntity.hcpId)
		if (changeType_e && clearEntity.changeType != null) dataToEncrypt["changeType"] = encodingJson.encodeToJsonElement(clearEntity.changeType)
		if (parentContractId_e && clearEntity.parentContractId != null) {
			dataToEncrypt["parentContractId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.parentContractId,
				)
		}
		if (changedBy_e && clearEntity.changedBy != null) dataToEncrypt["changedBy"] = encodingJson.encodeToJsonElement(clearEntity.changedBy)
		if (startOfContract_e && clearEntity.startOfContract != null) {
			dataToEncrypt["startOfContract"] =
				encodingJson.encodeToJsonElement(
					clearEntity.startOfContract,
				)
		}
		if (startOfCoverage_e && clearEntity.startOfCoverage != null) {
			dataToEncrypt["startOfCoverage"] =
				encodingJson.encodeToJsonElement(
					clearEntity.startOfCoverage,
				)
		}
		if (endOfContract_e && clearEntity.endOfContract != null) {
			dataToEncrypt["endOfContract"] =
				encodingJson.encodeToJsonElement(
					clearEntity.endOfContract,
				)
		}
		if (endOfCoverage_e && clearEntity.endOfCoverage != null) {
			dataToEncrypt["endOfCoverage"] =
				encodingJson.encodeToJsonElement(
					clearEntity.endOfCoverage,
				)
		}
		if (kine_e && clearEntity.kine != false) dataToEncrypt["kine"] = encodingJson.encodeToJsonElement(clearEntity.kine)
		if (gp_e && clearEntity.gp != false) dataToEncrypt["gp"] = encodingJson.encodeToJsonElement(clearEntity.gp)
		if (ptd_e && clearEntity.ptd != false) dataToEncrypt["ptd"] = encodingJson.encodeToJsonElement(clearEntity.ptd)
		if (nurse_e && clearEntity.nurse != false) dataToEncrypt["nurse"] = encodingJson.encodeToJsonElement(clearEntity.nurse)
		if (noKine_e && clearEntity.noKine != false) dataToEncrypt["noKine"] = encodingJson.encodeToJsonElement(clearEntity.noKine)
		if (noGp_e && clearEntity.noGp != false) dataToEncrypt["noGp"] = encodingJson.encodeToJsonElement(clearEntity.noGp)
		if (noNurse_e && clearEntity.noNurse != false) dataToEncrypt["noNurse"] = encodingJson.encodeToJsonElement(clearEntity.noNurse)
		if (unsubscriptionReasonId_e && clearEntity.unsubscriptionReasonId != null) {
			dataToEncrypt["unsubscriptionReasonId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.unsubscriptionReasonId,
				)
		}
		if (ptdStart_e && clearEntity.ptdStart != null) dataToEncrypt["ptdStart"] = encodingJson.encodeToJsonElement(clearEntity.ptdStart)
		if (ptdEnd_e && clearEntity.ptdEnd != null) dataToEncrypt["ptdEnd"] = encodingJson.encodeToJsonElement(clearEntity.ptdEnd)
		if (ptdLastInvoiced_e && clearEntity.ptdLastInvoiced != null) {
			dataToEncrypt["ptdLastInvoiced"] =
				encodingJson.encodeToJsonElement(
					clearEntity.ptdLastInvoiced,
				)
		}
		if (startOfSuspension_e && clearEntity.startOfSuspension != null) {
			dataToEncrypt["startOfSuspension"] =
				encodingJson.encodeToJsonElement(
					clearEntity.startOfSuspension,
				)
		}
		if (endOfSuspension_e && clearEntity.endOfSuspension != null) {
			dataToEncrypt["endOfSuspension"] =
				encodingJson.encodeToJsonElement(
					clearEntity.endOfSuspension,
				)
		}
		if (suspensionReason_e && clearEntity.suspensionReason != null) {
			dataToEncrypt["suspensionReason"] =
				encodingJson.encodeToJsonElement(
					clearEntity.suspensionReason,
				)
		}
		if (suspensionSource_e && clearEntity.suspensionSource != null) {
			dataToEncrypt["suspensionSource"] =
				encodingJson.encodeToJsonElement(
					clearEntity.suspensionSource,
				)
		}
		if (forcedSuspension_e && clearEntity.forcedSuspension != false) {
			dataToEncrypt["forcedSuspension"] =
				encodingJson.encodeToJsonElement(
					clearEntity.forcedSuspension,
				)
		}
		if (signatureType_e && clearEntity.signatureType != null) {
			dataToEncrypt["signatureType"] =
				encodingJson.encodeToJsonElement(
					clearEntity.signatureType,
				)
		}
		if (status_e && clearEntity.status != null) dataToEncrypt["status"] = encodingJson.encodeToJsonElement(clearEntity.status)
		if (options_e && clearEntity.options.isNotEmpty()) dataToEncrypt["options"] = encodingJson.encodeToJsonElement(clearEntity.options)
		if (receipts_e && clearEntity.receipts.isNotEmpty()) dataToEncrypt["receipts"] = encodingJson.encodeToJsonElement(clearEntity.receipts)
		return EncryptedMedicalHouseContract(
			contractId = if (contractId_e) null else clearEntity.contractId,
			validFrom = if (validFrom_e) null else clearEntity.validFrom,
			validTo = if (validTo_e) null else clearEntity.validTo,
			mmNihii = if (mmNihii_e) null else clearEntity.mmNihii,
			hcpId = if (hcpId_e) null else clearEntity.hcpId,
			changeType = if (changeType_e) null else clearEntity.changeType,
			parentContractId = if (parentContractId_e) null else clearEntity.parentContractId,
			changedBy = if (changedBy_e) null else clearEntity.changedBy,
			startOfContract = if (startOfContract_e) null else clearEntity.startOfContract,
			startOfCoverage = if (startOfCoverage_e) null else clearEntity.startOfCoverage,
			endOfContract = if (endOfContract_e) null else clearEntity.endOfContract,
			endOfCoverage = if (endOfCoverage_e) null else clearEntity.endOfCoverage,
			kine = if (kine_e) false else clearEntity.kine,
			gp = if (gp_e) false else clearEntity.gp,
			ptd = if (ptd_e) false else clearEntity.ptd,
			nurse = if (nurse_e) false else clearEntity.nurse,
			noKine = if (noKine_e) false else clearEntity.noKine,
			noGp = if (noGp_e) false else clearEntity.noGp,
			noNurse = if (noNurse_e) false else clearEntity.noNurse,
			unsubscriptionReasonId = if (unsubscriptionReasonId_e) null else clearEntity.unsubscriptionReasonId,
			ptdStart = if (ptdStart_e) null else clearEntity.ptdStart,
			ptdEnd = if (ptdEnd_e) null else clearEntity.ptdEnd,
			ptdLastInvoiced = if (ptdLastInvoiced_e) null else clearEntity.ptdLastInvoiced,
			startOfSuspension = if (startOfSuspension_e) null else clearEntity.startOfSuspension,
			endOfSuspension = if (endOfSuspension_e) null else clearEntity.endOfSuspension,
			suspensionReason = if (suspensionReason_e) null else clearEntity.suspensionReason,
			suspensionSource = if (suspensionSource_e) null else clearEntity.suspensionSource,
			forcedSuspension = if (forcedSuspension_e) false else clearEntity.forcedSuspension,
			signatureType = if (signatureType_e) null else clearEntity.signatureType,
			status = if (status_e) null else clearEntity.status,
			options = if (options_e) emptyMap() else clearEntity.options,
			receipts = if (receipts_e) emptyMap() else clearEntity.receipts,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
		)
	}
}

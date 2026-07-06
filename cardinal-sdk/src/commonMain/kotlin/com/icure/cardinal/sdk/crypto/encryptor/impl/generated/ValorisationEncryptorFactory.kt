// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedValorisation
import com.icure.cardinal.sdk.model.embed.EncryptedValorisation
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object ValorisationEncryptorFactory :
	EntityEncryptorFactory<EncryptedValorisation, DecryptedValorisation> {
	override val empty: EntityEncryptor<EncryptedValorisation, DecryptedValorisation> =
		ValorisationEncryptor(
			startOfValidity = false,
			endOfValidity = false,
			predicate = false,
			reference = false,
			totalAmount = false,
			reimbursement = false,
			patientIntervention = false,
			doctorSupplement = false,
			vat = false,
			label = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedValorisation, DecryptedValorisation> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return ValorisationEncryptor(
			startOfValidity = "startOfValidity" in manifest.fieldsToEncrypt,
			endOfValidity = "endOfValidity" in manifest.fieldsToEncrypt,
			predicate = "predicate" in manifest.fieldsToEncrypt,
			reference = "reference" in manifest.fieldsToEncrypt,
			totalAmount = "totalAmount" in manifest.fieldsToEncrypt,
			reimbursement = "reimbursement" in manifest.fieldsToEncrypt,
			patientIntervention = "patientIntervention" in manifest.fieldsToEncrypt,
			doctorSupplement = "doctorSupplement" in manifest.fieldsToEncrypt,
			vat = "vat" in manifest.fieldsToEncrypt,
			label = "label" in manifest.fieldsToEncrypt,
		)
	}
}

private class ValorisationEncryptor(
	private val startOfValidity: Boolean,
	private val endOfValidity: Boolean,
	private val predicate: Boolean,
	private val reference: Boolean,
	private val totalAmount: Boolean,
	private val reimbursement: Boolean,
	private val patientIntervention: Boolean,
	private val doctorSupplement: Boolean,
	private val vat: Boolean,
	private val label: Boolean,
) : AbstractEntityEncryptor<EncryptedValorisation, DecryptedValorisation>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedValorisation,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedValorisation {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (startOfValidity) dataToEncrypt["startOfValidity"] = encodingJson.encodeToJsonElement(clearEntity.startOfValidity)
		if (endOfValidity) dataToEncrypt["endOfValidity"] = encodingJson.encodeToJsonElement(clearEntity.endOfValidity)
		if (predicate) dataToEncrypt["predicate"] = encodingJson.encodeToJsonElement(clearEntity.predicate)
		if (reference) dataToEncrypt["reference"] = encodingJson.encodeToJsonElement(clearEntity.reference)
		if (totalAmount) dataToEncrypt["totalAmount"] = encodingJson.encodeToJsonElement(clearEntity.totalAmount)
		if (reimbursement) dataToEncrypt["reimbursement"] = encodingJson.encodeToJsonElement(clearEntity.reimbursement)
		if (patientIntervention) dataToEncrypt["patientIntervention"] = encodingJson.encodeToJsonElement(clearEntity.patientIntervention)
		if (doctorSupplement) dataToEncrypt["doctorSupplement"] = encodingJson.encodeToJsonElement(clearEntity.doctorSupplement)
		if (vat) dataToEncrypt["vat"] = encodingJson.encodeToJsonElement(clearEntity.vat)
		if (label) dataToEncrypt["label"] = encodingJson.encodeToJsonElement(clearEntity.label)
		return EncryptedValorisation(
			startOfValidity = if (startOfValidity) null else clearEntity.startOfValidity,
			endOfValidity = if (endOfValidity) null else clearEntity.endOfValidity,
			predicate = if (predicate) null else clearEntity.predicate,
			reference = if (reference) null else clearEntity.reference,
			totalAmount = if (totalAmount) null else clearEntity.totalAmount,
			reimbursement = if (reimbursement) null else clearEntity.reimbursement,
			patientIntervention = if (patientIntervention) null else clearEntity.patientIntervention,
			doctorSupplement = if (doctorSupplement) null else clearEntity.doctorSupplement,
			vat = if (vat) null else clearEntity.vat,
			label = if (label) emptyMap() else clearEntity.label,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}

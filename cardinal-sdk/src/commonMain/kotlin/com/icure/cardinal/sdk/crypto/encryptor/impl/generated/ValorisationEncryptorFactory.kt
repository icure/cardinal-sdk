// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedValorisation
import com.icure.cardinal.sdk.model.embed.EncryptedValorisation
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
internal object ValorisationEncryptorFactory :
	EntityEncryptorFactory<EncryptedValorisation, DecryptedValorisation> {
	override val empty: EntityEncryptor<EncryptedValorisation, DecryptedValorisation> =
		object :
			EntityEncryptor<EncryptedValorisation, DecryptedValorisation> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedValorisation,
			): EncryptedValorisation =
				EncryptedValorisation(
					startOfValidity = clearEntity.startOfValidity,
					endOfValidity = clearEntity.endOfValidity,
					predicate = clearEntity.predicate,
					reference = clearEntity.reference,
					totalAmount = clearEntity.totalAmount,
					reimbursement = clearEntity.reimbursement,
					patientIntervention = clearEntity.patientIntervention,
					doctorSupplement = clearEntity.doctorSupplement,
					vat = clearEntity.vat,
					label = clearEntity.label,
					encryptedSelf = null,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedValorisation, DecryptedValorisation> {
		val manifest = encryptorsFactoryContext.getManifest(entityManifestName)
		require(manifest.currentExtensionsManifest == null) {
			"Valorisation is not Extendable and does not support extensions encryption, but its manifest defines a currentExtensionsManifest."
		}
		return ValorisationEncryptor(
			startOfValidity_e = "startOfValidity" in manifest.fieldsToEncrypt,
			endOfValidity_e = "endOfValidity" in manifest.fieldsToEncrypt,
			predicate_e = "predicate" in manifest.fieldsToEncrypt,
			reference_e = "reference" in manifest.fieldsToEncrypt,
			totalAmount_e = "totalAmount" in manifest.fieldsToEncrypt,
			reimbursement_e = "reimbursement" in manifest.fieldsToEncrypt,
			patientIntervention_e = "patientIntervention" in manifest.fieldsToEncrypt,
			doctorSupplement_e = "doctorSupplement" in manifest.fieldsToEncrypt,
			vat_e = "vat" in manifest.fieldsToEncrypt,
			label_e = "label" in manifest.fieldsToEncrypt,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class ValorisationEncryptor(
	private val startOfValidity_e: Boolean,
	private val endOfValidity_e: Boolean,
	private val predicate_e: Boolean,
	private val reference_e: Boolean,
	private val totalAmount_e: Boolean,
	private val reimbursement_e: Boolean,
	private val patientIntervention_e: Boolean,
	private val doctorSupplement_e: Boolean,
	private val vat_e: Boolean,
	private val label_e: Boolean,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedValorisation, DecryptedValorisation>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedValorisation,
	): EncryptedValorisation {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (startOfValidity_e && clearEntity.startOfValidity != null) {
			dataToEncrypt["startOfValidity"] =
				encodingJson.encodeToJsonElement(
					clearEntity.startOfValidity,
				)
		}
		if (endOfValidity_e && clearEntity.endOfValidity != null) {
			dataToEncrypt["endOfValidity"] =
				encodingJson.encodeToJsonElement(
					clearEntity.endOfValidity,
				)
		}
		if (predicate_e && clearEntity.predicate != null) dataToEncrypt["predicate"] = encodingJson.encodeToJsonElement(clearEntity.predicate)
		if (reference_e && clearEntity.reference != null) dataToEncrypt["reference"] = encodingJson.encodeToJsonElement(clearEntity.reference)
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
		if (doctorSupplement_e && clearEntity.doctorSupplement != null) {
			dataToEncrypt["doctorSupplement"] =
				encodingJson.encodeToJsonElement(
					clearEntity.doctorSupplement,
				)
		}
		if (vat_e && clearEntity.vat != null) dataToEncrypt["vat"] = encodingJson.encodeToJsonElement(clearEntity.vat)
		if (label_e && (clearEntity.label?.isNotEmpty() ?: true)) dataToEncrypt["label"] = encodingJson.encodeToJsonElement(clearEntity.label)
		return EncryptedValorisation(
			startOfValidity = if (startOfValidity_e) null else clearEntity.startOfValidity,
			endOfValidity = if (endOfValidity_e) null else clearEntity.endOfValidity,
			predicate = if (predicate_e) null else clearEntity.predicate,
			reference = if (reference_e) null else clearEntity.reference,
			totalAmount = if (totalAmount_e) null else clearEntity.totalAmount,
			reimbursement = if (reimbursement_e) null else clearEntity.reimbursement,
			patientIntervention = if (patientIntervention_e) null else clearEntity.patientIntervention,
			doctorSupplement = if (doctorSupplement_e) null else clearEntity.doctorSupplement,
			vat = if (vat_e) null else clearEntity.vat,
			label = if (label_e) emptyMap() else clearEntity.label,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
		)
	}
}

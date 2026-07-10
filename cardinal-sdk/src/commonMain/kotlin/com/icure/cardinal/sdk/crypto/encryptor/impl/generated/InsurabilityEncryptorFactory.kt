// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedInsurability
import com.icure.cardinal.sdk.model.embed.EncryptedInsurability
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
internal object InsurabilityEncryptorFactory :
	EntityEncryptorFactory<EncryptedInsurability, DecryptedInsurability> {
	override val empty: EntityEncryptor<EncryptedInsurability, DecryptedInsurability> =
		InsurabilityEncryptor(
			parameters_e = false,
			hospitalisation_e = false,
			ambulatory_e = false,
			dental_e = false,
			identificationNumber_e = false,
			insuranceId_e = false,
			startDate_e = false,
			endDate_e = false,
			titularyId_e = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedInsurability, DecryptedInsurability> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return InsurabilityEncryptor(
			parameters_e = "parameters" in manifest.fieldsToEncrypt,
			hospitalisation_e = "hospitalisation" in manifest.fieldsToEncrypt,
			ambulatory_e = "ambulatory" in manifest.fieldsToEncrypt,
			dental_e = "dental" in manifest.fieldsToEncrypt,
			identificationNumber_e = "identificationNumber" in manifest.fieldsToEncrypt,
			insuranceId_e = "insuranceId" in manifest.fieldsToEncrypt,
			startDate_e = "startDate" in manifest.fieldsToEncrypt,
			endDate_e = "endDate" in manifest.fieldsToEncrypt,
			titularyId_e = "titularyId" in manifest.fieldsToEncrypt,
		)
	}
}

@InternalIcureApi
private class InsurabilityEncryptor(
	private val parameters_e: Boolean,
	private val hospitalisation_e: Boolean,
	private val ambulatory_e: Boolean,
	private val dental_e: Boolean,
	private val identificationNumber_e: Boolean,
	private val insuranceId_e: Boolean,
	private val startDate_e: Boolean,
	private val endDate_e: Boolean,
	private val titularyId_e: Boolean,
) : AbstractEntityEncryptor<EncryptedInsurability, DecryptedInsurability>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedInsurability,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedInsurability {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (parameters_e && clearEntity.parameters.isNotEmpty()) {
			dataToEncrypt["parameters"] =
				encodingJson.encodeToJsonElement(
					clearEntity.parameters,
				)
		}
		if (hospitalisation_e && clearEntity.hospitalisation != null) {
			dataToEncrypt["hospitalisation"] =
				encodingJson.encodeToJsonElement(
					clearEntity.hospitalisation,
				)
		}
		if (ambulatory_e && clearEntity.ambulatory != null) dataToEncrypt["ambulatory"] = encodingJson.encodeToJsonElement(clearEntity.ambulatory)
		if (dental_e && clearEntity.dental != null) dataToEncrypt["dental"] = encodingJson.encodeToJsonElement(clearEntity.dental)
		if (identificationNumber_e && clearEntity.identificationNumber != null) {
			dataToEncrypt["identificationNumber"] =
				encodingJson.encodeToJsonElement(
					clearEntity.identificationNumber,
				)
		}
		if (insuranceId_e && clearEntity.insuranceId != null) {
			dataToEncrypt["insuranceId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.insuranceId,
				)
		}
		if (startDate_e && clearEntity.startDate != null) dataToEncrypt["startDate"] = encodingJson.encodeToJsonElement(clearEntity.startDate)
		if (endDate_e && clearEntity.endDate != null) dataToEncrypt["endDate"] = encodingJson.encodeToJsonElement(clearEntity.endDate)
		if (titularyId_e && clearEntity.titularyId != null) dataToEncrypt["titularyId"] = encodingJson.encodeToJsonElement(clearEntity.titularyId)
		return EncryptedInsurability(
			parameters = if (parameters_e) emptyMap() else clearEntity.parameters,
			hospitalisation = if (hospitalisation_e) null else clearEntity.hospitalisation,
			ambulatory = if (ambulatory_e) null else clearEntity.ambulatory,
			dental = if (dental_e) null else clearEntity.dental,
			identificationNumber = if (identificationNumber_e) null else clearEntity.identificationNumber,
			insuranceId = if (insuranceId_e) null else clearEntity.insuranceId,
			startDate = if (startDate_e) null else clearEntity.startDate,
			endDate = if (endDate_e) null else clearEntity.endDate,
			titularyId = if (titularyId_e) null else clearEntity.titularyId,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			extensions = clearEntity.extensions,
		)
	}
}

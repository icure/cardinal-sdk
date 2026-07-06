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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object InsurabilityEncryptorFactory :
	EntityEncryptorFactory<EncryptedInsurability, DecryptedInsurability> {
	override val empty: EntityEncryptor<EncryptedInsurability, DecryptedInsurability> =
		InsurabilityEncryptor(
			parameters = false,
			hospitalisation = false,
			ambulatory = false,
			dental = false,
			identificationNumber = false,
			insuranceId = false,
			startDate = false,
			endDate = false,
			titularyId = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedInsurability, DecryptedInsurability> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return InsurabilityEncryptor(
			parameters = "parameters" in manifest.fieldsToEncrypt,
			hospitalisation = "hospitalisation" in manifest.fieldsToEncrypt,
			ambulatory = "ambulatory" in manifest.fieldsToEncrypt,
			dental = "dental" in manifest.fieldsToEncrypt,
			identificationNumber = "identificationNumber" in manifest.fieldsToEncrypt,
			insuranceId = "insuranceId" in manifest.fieldsToEncrypt,
			startDate = "startDate" in manifest.fieldsToEncrypt,
			endDate = "endDate" in manifest.fieldsToEncrypt,
			titularyId = "titularyId" in manifest.fieldsToEncrypt,
		)
	}
}

private class InsurabilityEncryptor(
	private val parameters: Boolean,
	private val hospitalisation: Boolean,
	private val ambulatory: Boolean,
	private val dental: Boolean,
	private val identificationNumber: Boolean,
	private val insuranceId: Boolean,
	private val startDate: Boolean,
	private val endDate: Boolean,
	private val titularyId: Boolean,
) : AbstractEntityEncryptor<EncryptedInsurability, DecryptedInsurability>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedInsurability,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedInsurability {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (parameters) dataToEncrypt["parameters"] = encodingJson.encodeToJsonElement(clearEntity.parameters)
		if (hospitalisation) dataToEncrypt["hospitalisation"] = encodingJson.encodeToJsonElement(clearEntity.hospitalisation)
		if (ambulatory) dataToEncrypt["ambulatory"] = encodingJson.encodeToJsonElement(clearEntity.ambulatory)
		if (dental) dataToEncrypt["dental"] = encodingJson.encodeToJsonElement(clearEntity.dental)
		if (identificationNumber) dataToEncrypt["identificationNumber"] = encodingJson.encodeToJsonElement(clearEntity.identificationNumber)
		if (insuranceId) dataToEncrypt["insuranceId"] = encodingJson.encodeToJsonElement(clearEntity.insuranceId)
		if (startDate) dataToEncrypt["startDate"] = encodingJson.encodeToJsonElement(clearEntity.startDate)
		if (endDate) dataToEncrypt["endDate"] = encodingJson.encodeToJsonElement(clearEntity.endDate)
		if (titularyId) dataToEncrypt["titularyId"] = encodingJson.encodeToJsonElement(clearEntity.titularyId)
		return EncryptedInsurability(
			parameters = if (parameters) emptyMap() else clearEntity.parameters,
			hospitalisation = if (hospitalisation) null else clearEntity.hospitalisation,
			ambulatory = if (ambulatory) null else clearEntity.ambulatory,
			dental = if (dental) null else clearEntity.dental,
			identificationNumber = if (identificationNumber) null else clearEntity.identificationNumber,
			insuranceId = if (insuranceId) null else clearEntity.insuranceId,
			startDate = if (startDate) null else clearEntity.startDate,
			endDate = if (endDate) null else clearEntity.endDate,
			titularyId = if (titularyId) null else clearEntity.titularyId,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			extensions = clearEntity.extensions,
		)
	}
}

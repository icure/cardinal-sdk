// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedSchoolingInfo
import com.icure.cardinal.sdk.model.embed.EncryptedSchoolingInfo
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
internal object SchoolingInfoEncryptorFactory :
	EntityEncryptorFactory<EncryptedSchoolingInfo, DecryptedSchoolingInfo> {
	override val empty: EntityEncryptor<EncryptedSchoolingInfo, DecryptedSchoolingInfo> =
		SchoolingInfoEncryptor(
			startDate_e = false,
			endDate_e = false,
			school_e = false,
			typeOfEducation_e = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedSchoolingInfo, DecryptedSchoolingInfo> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return SchoolingInfoEncryptor(
			startDate_e = "startDate" in manifest.fieldsToEncrypt,
			endDate_e = "endDate" in manifest.fieldsToEncrypt,
			school_e = "school" in manifest.fieldsToEncrypt,
			typeOfEducation_e = "typeOfEducation" in manifest.fieldsToEncrypt,
		)
	}
}

@InternalIcureApi
private class SchoolingInfoEncryptor(
	private val startDate_e: Boolean,
	private val endDate_e: Boolean,
	private val school_e: Boolean,
	private val typeOfEducation_e: Boolean,
) : AbstractEntityEncryptor<EncryptedSchoolingInfo, DecryptedSchoolingInfo>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedSchoolingInfo,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedSchoolingInfo {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (startDate_e && clearEntity.startDate != null) dataToEncrypt["startDate"] = encodingJson.encodeToJsonElement(clearEntity.startDate)
		if (endDate_e && clearEntity.endDate != null) dataToEncrypt["endDate"] = encodingJson.encodeToJsonElement(clearEntity.endDate)
		if (school_e && clearEntity.school != null) dataToEncrypt["school"] = encodingJson.encodeToJsonElement(clearEntity.school)
		if (typeOfEducation_e && clearEntity.typeOfEducation != null) {
			dataToEncrypt["typeOfEducation"] =
				encodingJson.encodeToJsonElement(
					clearEntity.typeOfEducation,
				)
		}
		return EncryptedSchoolingInfo(
			startDate = if (startDate_e) null else clearEntity.startDate,
			endDate = if (endDate_e) null else clearEntity.endDate,
			school = if (school_e) null else clearEntity.school,
			typeOfEducation = if (typeOfEducation_e) null else clearEntity.typeOfEducation,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}

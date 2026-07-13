// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
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
		object :
			EntityEncryptor<EncryptedSchoolingInfo, DecryptedSchoolingInfo> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedSchoolingInfo,
			): EncryptedSchoolingInfo =
				EncryptedSchoolingInfo(
					startDate = clearEntity.startDate,
					endDate = clearEntity.endDate,
					school = clearEntity.school,
					typeOfEducation = clearEntity.typeOfEducation,
					encryptedSelf = null,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedSchoolingInfo, DecryptedSchoolingInfo> {
		val manifest = encryptorsFactoryContext.getManifest(entityManifestName)
		require(manifest.currentExtensionsManifest == null) {
			"SchoolingInfo is not Extendable and does not support extensions encryption, but its manifest defines a currentExtensionsManifest."
		}
		return SchoolingInfoEncryptor(
			startDate_e = "startDate" in manifest.fieldsToEncrypt,
			endDate_e = "endDate" in manifest.fieldsToEncrypt,
			school_e = "school" in manifest.fieldsToEncrypt,
			typeOfEducation_e = "typeOfEducation" in manifest.fieldsToEncrypt,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class SchoolingInfoEncryptor(
	private val startDate_e: Boolean,
	private val endDate_e: Boolean,
	private val school_e: Boolean,
	private val typeOfEducation_e: Boolean,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedSchoolingInfo, DecryptedSchoolingInfo>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedSchoolingInfo,
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
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
		)
	}
}

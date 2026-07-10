// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedEmploymentInfo
import com.icure.cardinal.sdk.model.embed.EncryptedEmploymentInfo
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
internal object EmploymentInfoEncryptorFactory :
	EntityEncryptorFactory<EncryptedEmploymentInfo, DecryptedEmploymentInfo> {
	override val empty: EntityEncryptor<EncryptedEmploymentInfo, DecryptedEmploymentInfo> =
		object :
			EntityEncryptor<EncryptedEmploymentInfo, DecryptedEmploymentInfo> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedEmploymentInfo,
			): EncryptedEmploymentInfo =
				EncryptedEmploymentInfo(
					startDate = clearEntity.startDate,
					endDate = clearEntity.endDate,
					professionType = clearEntity.professionType,
					employer = clearEntity.employer,
					encryptedSelf = null,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedEmploymentInfo, DecryptedEmploymentInfo> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return EmploymentInfoEncryptor(
			startDate_e = "startDate" in manifest.fieldsToEncrypt,
			endDate_e = "endDate" in manifest.fieldsToEncrypt,
			professionType_e = "professionType" in manifest.fieldsToEncrypt,
			employer_e = "employer" in manifest.fieldsToEncrypt,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class EmploymentInfoEncryptor(
	private val startDate_e: Boolean,
	private val endDate_e: Boolean,
	private val professionType_e: Boolean,
	private val employer_e: Boolean,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedEmploymentInfo, DecryptedEmploymentInfo>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedEmploymentInfo,
	): EncryptedEmploymentInfo {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (startDate_e && clearEntity.startDate != null) dataToEncrypt["startDate"] = encodingJson.encodeToJsonElement(clearEntity.startDate)
		if (endDate_e && clearEntity.endDate != null) dataToEncrypt["endDate"] = encodingJson.encodeToJsonElement(clearEntity.endDate)
		if (professionType_e && clearEntity.professionType != null) {
			dataToEncrypt["professionType"] =
				encodingJson.encodeToJsonElement(
					clearEntity.professionType,
				)
		}
		if (employer_e && clearEntity.employer != null) dataToEncrypt["employer"] = encodingJson.encodeToJsonElement(clearEntity.employer)
		return EncryptedEmploymentInfo(
			startDate = if (startDate_e) null else clearEntity.startDate,
			endDate = if (endDate_e) null else clearEntity.endDate,
			professionType = if (professionType_e) null else clearEntity.professionType,
			employer = if (employer_e) null else clearEntity.employer,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
		)
	}
}

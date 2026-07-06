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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object EmploymentInfoEncryptorFactory :
	EntityEncryptorFactory<EncryptedEmploymentInfo, DecryptedEmploymentInfo> {
	override val empty: EntityEncryptor<EncryptedEmploymentInfo, DecryptedEmploymentInfo> =
		EmploymentInfoEncryptor(
			startDate = false,
			endDate = false,
			professionType = false,
			employer = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedEmploymentInfo, DecryptedEmploymentInfo> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return EmploymentInfoEncryptor(
			startDate = "startDate" in manifest.fieldsToEncrypt,
			endDate = "endDate" in manifest.fieldsToEncrypt,
			professionType = "professionType" in manifest.fieldsToEncrypt,
			employer = "employer" in manifest.fieldsToEncrypt,
		)
	}
}

private class EmploymentInfoEncryptor(
	private val startDate: Boolean,
	private val endDate: Boolean,
	private val professionType: Boolean,
	private val employer: Boolean,
) : AbstractEntityEncryptor<EncryptedEmploymentInfo, DecryptedEmploymentInfo>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedEmploymentInfo,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedEmploymentInfo {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (startDate) dataToEncrypt["startDate"] = encodingJson.encodeToJsonElement(clearEntity.startDate)
		if (endDate) dataToEncrypt["endDate"] = encodingJson.encodeToJsonElement(clearEntity.endDate)
		if (professionType) dataToEncrypt["professionType"] = encodingJson.encodeToJsonElement(clearEntity.professionType)
		if (employer) dataToEncrypt["employer"] = encodingJson.encodeToJsonElement(clearEntity.employer)
		return EncryptedEmploymentInfo(
			startDate = if (startDate) null else clearEntity.startDate,
			endDate = if (endDate) null else clearEntity.endDate,
			professionType = if (professionType) null else clearEntity.professionType,
			employer = if (employer) null else clearEntity.employer,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}

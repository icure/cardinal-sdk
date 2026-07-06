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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object SchoolingInfoEncryptorFactory :
	EntityEncryptorFactory<EncryptedSchoolingInfo, DecryptedSchoolingInfo> {
	override val empty: EntityEncryptor<EncryptedSchoolingInfo, DecryptedSchoolingInfo> =
		SchoolingInfoEncryptor(
			startDate = false,
			endDate = false,
			school = false,
			typeOfEducation = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedSchoolingInfo, DecryptedSchoolingInfo> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return SchoolingInfoEncryptor(
			startDate = "startDate" in manifest.fieldsToEncrypt,
			endDate = "endDate" in manifest.fieldsToEncrypt,
			school = "school" in manifest.fieldsToEncrypt,
			typeOfEducation = "typeOfEducation" in manifest.fieldsToEncrypt,
		)
	}
}

private class SchoolingInfoEncryptor(
	private val startDate: Boolean,
	private val endDate: Boolean,
	private val school: Boolean,
	private val typeOfEducation: Boolean,
) : AbstractEntityEncryptor<EncryptedSchoolingInfo, DecryptedSchoolingInfo>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedSchoolingInfo,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedSchoolingInfo {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (startDate) dataToEncrypt["startDate"] = encodingJson.encodeToJsonElement(clearEntity.startDate)
		if (endDate) dataToEncrypt["endDate"] = encodingJson.encodeToJsonElement(clearEntity.endDate)
		if (school) dataToEncrypt["school"] = encodingJson.encodeToJsonElement(clearEntity.school)
		if (typeOfEducation) dataToEncrypt["typeOfEducation"] = encodingJson.encodeToJsonElement(clearEntity.typeOfEducation)
		return EncryptedSchoolingInfo(
			startDate = if (startDate) null else clearEntity.startDate,
			endDate = if (endDate) null else clearEntity.endDate,
			school = if (school) null else clearEntity.school,
			typeOfEducation = if (typeOfEducation) null else clearEntity.typeOfEducation,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}

// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedTelecom
import com.icure.cardinal.sdk.model.embed.EncryptedTelecom
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object TelecomEncryptorFactory : EntityEncryptorFactory<EncryptedTelecom, DecryptedTelecom> {
	override val empty: EntityEncryptor<EncryptedTelecom, DecryptedTelecom> =
		TelecomEncryptor(
			telecomType = false,
			telecomNumber = false,
			telecomDescription = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedTelecom, DecryptedTelecom> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return TelecomEncryptor(
			telecomType = "telecomType" in manifest.fieldsToEncrypt,
			telecomNumber = "telecomNumber" in manifest.fieldsToEncrypt,
			telecomDescription = "telecomDescription" in manifest.fieldsToEncrypt,
		)
	}
}

private class TelecomEncryptor(
	private val telecomType: Boolean,
	private val telecomNumber: Boolean,
	private val telecomDescription: Boolean,
) : AbstractEntityEncryptor<EncryptedTelecom, DecryptedTelecom>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedTelecom,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedTelecom {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (telecomType) dataToEncrypt["telecomType"] = encodingJson.encodeToJsonElement(clearEntity.telecomType)
		if (telecomNumber) dataToEncrypt["telecomNumber"] = encodingJson.encodeToJsonElement(clearEntity.telecomNumber)
		if (telecomDescription) dataToEncrypt["telecomDescription"] = encodingJson.encodeToJsonElement(clearEntity.telecomDescription)
		return EncryptedTelecom(
			telecomType = if (telecomType) null else clearEntity.telecomType,
			telecomNumber = if (telecomNumber) null else clearEntity.telecomNumber,
			telecomDescription = if (telecomDescription) null else clearEntity.telecomDescription,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			extensions = clearEntity.extensions,
		)
	}
}

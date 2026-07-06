// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedPartnership
import com.icure.cardinal.sdk.model.embed.EncryptedPartnership
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object PartnershipEncryptorFactory :
	EntityEncryptorFactory<EncryptedPartnership, DecryptedPartnership> {
	override val empty: EntityEncryptor<EncryptedPartnership, DecryptedPartnership> =
		PartnershipEncryptor(
			type = false,
			status = false,
			partnerId = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedPartnership, DecryptedPartnership> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return PartnershipEncryptor(
			type = "type" in manifest.fieldsToEncrypt,
			status = "status" in manifest.fieldsToEncrypt,
			partnerId = "partnerId" in manifest.fieldsToEncrypt,
		)
	}
}

private class PartnershipEncryptor(
	private val type: Boolean,
	private val status: Boolean,
	private val partnerId: Boolean,
) : AbstractEntityEncryptor<EncryptedPartnership, DecryptedPartnership>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedPartnership,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedPartnership {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (type) dataToEncrypt["type"] = encodingJson.encodeToJsonElement(clearEntity.type)
		if (status) dataToEncrypt["status"] = encodingJson.encodeToJsonElement(clearEntity.status)
		if (partnerId) dataToEncrypt["partnerId"] = encodingJson.encodeToJsonElement(clearEntity.partnerId)
		return EncryptedPartnership(
			type = if (type) null else clearEntity.type,
			status = if (status) null else clearEntity.status,
			partnerId = if (partnerId) null else clearEntity.partnerId,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}

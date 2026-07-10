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
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

@InternalIcureApi
internal object PartnershipEncryptorFactory :
	EntityEncryptorFactory<EncryptedPartnership, DecryptedPartnership> {
	override val empty: EntityEncryptor<EncryptedPartnership, DecryptedPartnership> =
		PartnershipEncryptor(
			type_e = false,
			status_e = false,
			partnerId_e = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedPartnership, DecryptedPartnership> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return PartnershipEncryptor(
			type_e = "type" in manifest.fieldsToEncrypt,
			status_e = "status" in manifest.fieldsToEncrypt,
			partnerId_e = "partnerId" in manifest.fieldsToEncrypt,
		)
	}
}

@InternalIcureApi
private class PartnershipEncryptor(
	private val type_e: Boolean,
	private val status_e: Boolean,
	private val partnerId_e: Boolean,
) : AbstractEntityEncryptor<EncryptedPartnership, DecryptedPartnership>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedPartnership,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedPartnership {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (type_e && clearEntity.type != null) dataToEncrypt["type"] = encodingJson.encodeToJsonElement(clearEntity.type)
		if (status_e && clearEntity.status != null) dataToEncrypt["status"] = encodingJson.encodeToJsonElement(clearEntity.status)
		if (partnerId_e && clearEntity.partnerId != null) dataToEncrypt["partnerId"] = encodingJson.encodeToJsonElement(clearEntity.partnerId)
		return EncryptedPartnership(
			type = if (type_e) null else clearEntity.type,
			status = if (status_e) null else clearEntity.status,
			partnerId = if (partnerId_e) null else clearEntity.partnerId,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}

// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedTypedValue
import com.icure.cardinal.sdk.model.embed.EncryptedTypedValue
import com.icure.cardinal.sdk.serialization.InstantSerializer
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object TypedValueEncryptorFactory :
	EntityEncryptorFactory<EncryptedTypedValue, DecryptedTypedValue> {
	override val empty: EntityEncryptor<EncryptedTypedValue, DecryptedTypedValue> =
		TypedValueEncryptor(
			type = false,
			booleanValue = false,
			integerValue = false,
			doubleValue = false,
			stringValue = false,
			dateValue = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedTypedValue, DecryptedTypedValue> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return TypedValueEncryptor(
			type = "type" in manifest.fieldsToEncrypt,
			booleanValue = "booleanValue" in manifest.fieldsToEncrypt,
			integerValue = "integerValue" in manifest.fieldsToEncrypt,
			doubleValue = "doubleValue" in manifest.fieldsToEncrypt,
			stringValue = "stringValue" in manifest.fieldsToEncrypt,
			dateValue = "dateValue" in manifest.fieldsToEncrypt,
		)
	}
}

private class TypedValueEncryptor(
	private val type: Boolean,
	private val booleanValue: Boolean,
	private val integerValue: Boolean,
	private val doubleValue: Boolean,
	private val stringValue: Boolean,
	private val dateValue: Boolean,
) : AbstractEntityEncryptor<EncryptedTypedValue, DecryptedTypedValue>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedTypedValue,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedTypedValue {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (type) dataToEncrypt["type"] = encodingJson.encodeToJsonElement(clearEntity.type)
		if (booleanValue) dataToEncrypt["booleanValue"] = encodingJson.encodeToJsonElement(clearEntity.booleanValue)
		if (integerValue) dataToEncrypt["integerValue"] = encodingJson.encodeToJsonElement(clearEntity.integerValue)
		if (doubleValue) dataToEncrypt["doubleValue"] = encodingJson.encodeToJsonElement(clearEntity.doubleValue)
		if (stringValue) dataToEncrypt["stringValue"] = encodingJson.encodeToJsonElement(clearEntity.stringValue)
		if (dateValue) dataToEncrypt["dateValue"] = encodingJson.encodeToJsonElement(InstantSerializer.nullable, clearEntity.dateValue)
		return EncryptedTypedValue(
			type = if (type) null else clearEntity.type,
			booleanValue = if (booleanValue) null else clearEntity.booleanValue,
			integerValue = if (integerValue) null else clearEntity.integerValue,
			doubleValue = if (doubleValue) null else clearEntity.doubleValue,
			stringValue = if (stringValue) null else clearEntity.stringValue,
			dateValue = if (dateValue) null else clearEntity.dateValue,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}

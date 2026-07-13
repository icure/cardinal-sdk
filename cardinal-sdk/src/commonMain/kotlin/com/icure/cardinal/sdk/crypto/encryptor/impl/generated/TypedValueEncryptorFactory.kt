// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedTypedValue
import com.icure.cardinal.sdk.model.embed.EncryptedTypedValue
import com.icure.cardinal.sdk.serialization.InstantSerializer
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

@InternalIcureApi
internal object TypedValueEncryptorFactory :
	EntityEncryptorFactory<EncryptedTypedValue, DecryptedTypedValue> {
	override val empty: EntityEncryptor<EncryptedTypedValue, DecryptedTypedValue> =
		object :
			EntityEncryptor<EncryptedTypedValue, DecryptedTypedValue> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedTypedValue,
			): EncryptedTypedValue =
				EncryptedTypedValue(
					type = clearEntity.type,
					booleanValue = clearEntity.booleanValue,
					integerValue = clearEntity.integerValue,
					doubleValue = clearEntity.doubleValue,
					stringValue = clearEntity.stringValue,
					dateValue = clearEntity.dateValue,
					encryptedSelf = null,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedTypedValue, DecryptedTypedValue> {
		val manifest = encryptorsFactoryContext.getManifest(entityManifestName)
		require(manifest.currentExtensionsManifest == null) {
			"TypedValue is not Extendable and does not support extensions encryption, but its manifest defines a currentExtensionsManifest."
		}
		return TypedValueEncryptor(
			type_e = "type" in manifest.fieldsToEncrypt,
			booleanValue_e = "booleanValue" in manifest.fieldsToEncrypt,
			integerValue_e = "integerValue" in manifest.fieldsToEncrypt,
			doubleValue_e = "doubleValue" in manifest.fieldsToEncrypt,
			stringValue_e = "stringValue" in manifest.fieldsToEncrypt,
			dateValue_e = "dateValue" in manifest.fieldsToEncrypt,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class TypedValueEncryptor(
	private val type_e: Boolean,
	private val booleanValue_e: Boolean,
	private val integerValue_e: Boolean,
	private val doubleValue_e: Boolean,
	private val stringValue_e: Boolean,
	private val dateValue_e: Boolean,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedTypedValue, DecryptedTypedValue>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedTypedValue,
	): EncryptedTypedValue {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (type_e && clearEntity.type != null) dataToEncrypt["type"] = encodingJson.encodeToJsonElement(clearEntity.type)
		if (booleanValue_e && clearEntity.booleanValue != null) {
			dataToEncrypt["booleanValue"] =
				encodingJson.encodeToJsonElement(
					clearEntity.booleanValue,
				)
		}
		if (integerValue_e && clearEntity.integerValue != null) {
			dataToEncrypt["integerValue"] =
				encodingJson.encodeToJsonElement(
					clearEntity.integerValue,
				)
		}
		if (doubleValue_e && clearEntity.doubleValue != null) {
			dataToEncrypt["doubleValue"] =
				encodingJson.encodeToJsonElement(
					clearEntity.doubleValue,
				)
		}
		if (stringValue_e && clearEntity.stringValue != null) {
			dataToEncrypt["stringValue"] =
				encodingJson.encodeToJsonElement(
					clearEntity.stringValue,
				)
		}
		if (dateValue_e && clearEntity.dateValue != null) {
			dataToEncrypt["dateValue"] =
				encodingJson.encodeToJsonElement(
					InstantSerializer.nullable,
					clearEntity.dateValue,
				)
		}
		return EncryptedTypedValue(
			type = if (type_e) null else clearEntity.type,
			booleanValue = if (booleanValue_e) null else clearEntity.booleanValue,
			integerValue = if (integerValue_e) null else clearEntity.integerValue,
			doubleValue = if (doubleValue_e) null else clearEntity.doubleValue,
			stringValue = if (stringValue_e) null else clearEntity.stringValue,
			dateValue = if (dateValue_e) null else clearEntity.dateValue,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
		)
	}
}

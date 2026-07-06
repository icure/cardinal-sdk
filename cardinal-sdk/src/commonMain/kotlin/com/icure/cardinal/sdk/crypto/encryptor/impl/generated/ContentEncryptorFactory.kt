// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.EncryptableFieldConfig
import com.icure.cardinal.sdk.model.embed.DecryptedContent
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedContent
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
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

internal object ContentEncryptorFactory : EntityEncryptorFactory<EncryptedContent, DecryptedContent> {
	override val empty: EntityEncryptor<EncryptedContent, DecryptedContent> =
		ContentEncryptor(
			stringValue = false,
			numberValue = false,
			booleanValue = false,
			instantValue = false,
			fuzzyDateValue = false,
			binaryValue = false,
			documentId = false,
			measureValue = false,
			medicationValue = false,
			timeSeries = false,
			compoundValue = EncryptableFieldConfig.None(ServiceEncryptorFactory),
			ratio = false,
			range = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedContent, DecryptedContent> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return ContentEncryptor(
			stringValue = "stringValue" in manifest.fieldsToEncrypt,
			numberValue = "numberValue" in manifest.fieldsToEncrypt,
			booleanValue = "booleanValue" in manifest.fieldsToEncrypt,
			instantValue = "instantValue" in manifest.fieldsToEncrypt,
			fuzzyDateValue = "fuzzyDateValue" in manifest.fieldsToEncrypt,
			binaryValue = "binaryValue" in manifest.fieldsToEncrypt,
			documentId = "documentId" in manifest.fieldsToEncrypt,
			measureValue = "measureValue" in manifest.fieldsToEncrypt,
			medicationValue = "medicationValue" in manifest.fieldsToEncrypt,
			timeSeries = "timeSeries" in manifest.fieldsToEncrypt,
			compoundValue =
				if ("compoundValue" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["compoundValue"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedService::class,
								decryptedClass = DecryptedService::class,
							),
						)
					} ?: EncryptableFieldConfig.None(ServiceEncryptorFactory)
				},
			ratio = "ratio" in manifest.fieldsToEncrypt,
			range = "range" in manifest.fieldsToEncrypt,
		)
	}
}

private class ContentEncryptor(
	private val stringValue: Boolean,
	private val numberValue: Boolean,
	private val booleanValue: Boolean,
	private val instantValue: Boolean,
	private val fuzzyDateValue: Boolean,
	private val binaryValue: Boolean,
	private val documentId: Boolean,
	private val measureValue: Boolean,
	private val medicationValue: Boolean,
	private val timeSeries: Boolean,
	private val compoundValue: EncryptableFieldConfig<EncryptedService, DecryptedService>,
	private val ratio: Boolean,
	private val range: Boolean,
) : AbstractEntityEncryptor<EncryptedContent, DecryptedContent>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedContent,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedContent {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (stringValue) dataToEncrypt["stringValue"] = encodingJson.encodeToJsonElement(clearEntity.stringValue)
		if (numberValue) dataToEncrypt["numberValue"] = encodingJson.encodeToJsonElement(clearEntity.numberValue)
		if (booleanValue) dataToEncrypt["booleanValue"] = encodingJson.encodeToJsonElement(clearEntity.booleanValue)
		if (instantValue) dataToEncrypt["instantValue"] = encodingJson.encodeToJsonElement(InstantSerializer.nullable, clearEntity.instantValue)
		if (fuzzyDateValue) dataToEncrypt["fuzzyDateValue"] = encodingJson.encodeToJsonElement(clearEntity.fuzzyDateValue)
		if (binaryValue) dataToEncrypt["binaryValue"] = encodingJson.encodeToJsonElement(ByteArraySerializer.nullable, clearEntity.binaryValue)
		if (documentId) dataToEncrypt["documentId"] = encodingJson.encodeToJsonElement(clearEntity.documentId)
		if (measureValue) dataToEncrypt["measureValue"] = encodingJson.encodeToJsonElement(clearEntity.measureValue)
		if (medicationValue) dataToEncrypt["medicationValue"] = encodingJson.encodeToJsonElement(clearEntity.medicationValue)
		if (timeSeries) dataToEncrypt["timeSeries"] = encodingJson.encodeToJsonElement(clearEntity.timeSeries)
		if (compoundValue.fullEncryption) dataToEncrypt["compoundValue"] = encodingJson.encodeToJsonElement(clearEntity.compoundValue)
		if (ratio) dataToEncrypt["ratio"] = encodingJson.encodeToJsonElement(clearEntity.ratio)
		if (range) dataToEncrypt["range"] = encodingJson.encodeToJsonElement(clearEntity.range)
		return EncryptedContent(
			stringValue = if (stringValue) null else clearEntity.stringValue,
			numberValue = if (numberValue) null else clearEntity.numberValue,
			booleanValue = if (booleanValue) null else clearEntity.booleanValue,
			instantValue = if (instantValue) null else clearEntity.instantValue,
			fuzzyDateValue = if (fuzzyDateValue) null else clearEntity.fuzzyDateValue,
			binaryValue = if (binaryValue) null else clearEntity.binaryValue,
			documentId = if (documentId) null else clearEntity.documentId,
			measureValue = if (measureValue) null else clearEntity.measureValue,
			medicationValue = if (medicationValue) null else clearEntity.medicationValue,
			timeSeries = if (timeSeries) null else clearEntity.timeSeries,
			compoundValue =
				compoundValue.encryptor.let { encryptor ->
					if (encryptor == null) {
						null
					} else {
						clearEntity.compoundValue?.let {
							it.map { x0 ->
								encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
							}
						}
					}
				},
			ratio = if (ratio) null else clearEntity.ratio,
			range = if (range) null else clearEntity.range,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}

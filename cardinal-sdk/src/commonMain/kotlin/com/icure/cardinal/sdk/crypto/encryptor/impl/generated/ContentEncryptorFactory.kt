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
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

@InternalIcureApi
internal object ContentEncryptorFactory : EntityEncryptorFactory<EncryptedContent, DecryptedContent> {
	override val empty: EntityEncryptor<EncryptedContent, DecryptedContent> =
		ContentEncryptor(
			stringValue_e = false,
			numberValue_e = false,
			booleanValue_e = false,
			instantValue_e = false,
			fuzzyDateValue_e = false,
			binaryValue_e = false,
			documentId_e = false,
			measureValue_e = false,
			medicationValue_e = false,
			timeSeries_e = false,
			compoundValue_e = EncryptableFieldConfig.None(ServiceEncryptorFactory),
			ratio_e = false,
			range_e = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedContent, DecryptedContent> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return ContentEncryptor(
			stringValue_e = "stringValue" in manifest.fieldsToEncrypt,
			numberValue_e = "numberValue" in manifest.fieldsToEncrypt,
			booleanValue_e = "booleanValue" in manifest.fieldsToEncrypt,
			instantValue_e = "instantValue" in manifest.fieldsToEncrypt,
			fuzzyDateValue_e = "fuzzyDateValue" in manifest.fieldsToEncrypt,
			binaryValue_e = "binaryValue" in manifest.fieldsToEncrypt,
			documentId_e = "documentId" in manifest.fieldsToEncrypt,
			measureValue_e = "measureValue" in manifest.fieldsToEncrypt,
			medicationValue_e = "medicationValue" in manifest.fieldsToEncrypt,
			timeSeries_e = "timeSeries" in manifest.fieldsToEncrypt,
			compoundValue_e =
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
			ratio_e = "ratio" in manifest.fieldsToEncrypt,
			range_e = "range" in manifest.fieldsToEncrypt,
		)
	}
}

@InternalIcureApi
private class ContentEncryptor(
	private val stringValue_e: Boolean,
	private val numberValue_e: Boolean,
	private val booleanValue_e: Boolean,
	private val instantValue_e: Boolean,
	private val fuzzyDateValue_e: Boolean,
	private val binaryValue_e: Boolean,
	private val documentId_e: Boolean,
	private val measureValue_e: Boolean,
	private val medicationValue_e: Boolean,
	private val timeSeries_e: Boolean,
	private val compoundValue_e: EncryptableFieldConfig<EncryptedService, DecryptedService>,
	private val ratio_e: Boolean,
	private val range_e: Boolean,
) : AbstractEntityEncryptor<EncryptedContent, DecryptedContent>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedContent,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedContent {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (stringValue_e && clearEntity.stringValue != null) {
			dataToEncrypt["stringValue"] =
				encodingJson.encodeToJsonElement(
					clearEntity.stringValue,
				)
		}
		if (numberValue_e && clearEntity.numberValue != null) {
			dataToEncrypt["numberValue"] =
				encodingJson.encodeToJsonElement(
					clearEntity.numberValue,
				)
		}
		if (booleanValue_e && clearEntity.booleanValue != null) {
			dataToEncrypt["booleanValue"] =
				encodingJson.encodeToJsonElement(
					clearEntity.booleanValue,
				)
		}
		if (instantValue_e && clearEntity.instantValue != null) {
			dataToEncrypt["instantValue"] =
				encodingJson.encodeToJsonElement(
					InstantSerializer.nullable,
					clearEntity.instantValue,
				)
		}
		if (fuzzyDateValue_e && clearEntity.fuzzyDateValue != null) {
			dataToEncrypt["fuzzyDateValue"] =
				encodingJson.encodeToJsonElement(
					clearEntity.fuzzyDateValue,
				)
		}
		if (binaryValue_e && clearEntity.binaryValue != null) {
			dataToEncrypt["binaryValue"] =
				encodingJson.encodeToJsonElement(
					ByteArraySerializer.nullable,
					clearEntity.binaryValue,
				)
		}
		if (documentId_e && clearEntity.documentId != null) dataToEncrypt["documentId"] = encodingJson.encodeToJsonElement(clearEntity.documentId)
		if (measureValue_e && clearEntity.measureValue != null) {
			dataToEncrypt["measureValue"] =
				encodingJson.encodeToJsonElement(
					clearEntity.measureValue,
				)
		}
		if (medicationValue_e && clearEntity.medicationValue != null) {
			dataToEncrypt["medicationValue"] =
				encodingJson.encodeToJsonElement(
					clearEntity.medicationValue,
				)
		}
		if (timeSeries_e && clearEntity.timeSeries != null) dataToEncrypt["timeSeries"] = encodingJson.encodeToJsonElement(clearEntity.timeSeries)
		if (compoundValue_e.fullEncryption && clearEntity.compoundValue != null) {
			dataToEncrypt["compoundValue"] =
				encodingJson.encodeToJsonElement(
					clearEntity.compoundValue,
				)
		}
		if (ratio_e && clearEntity.ratio != null) dataToEncrypt["ratio"] = encodingJson.encodeToJsonElement(clearEntity.ratio)
		if (range_e && clearEntity.range != null) dataToEncrypt["range"] = encodingJson.encodeToJsonElement(clearEntity.range)
		return EncryptedContent(
			stringValue = if (stringValue_e) null else clearEntity.stringValue,
			numberValue = if (numberValue_e) null else clearEntity.numberValue,
			booleanValue = if (booleanValue_e) null else clearEntity.booleanValue,
			instantValue = if (instantValue_e) null else clearEntity.instantValue,
			fuzzyDateValue = if (fuzzyDateValue_e) null else clearEntity.fuzzyDateValue,
			binaryValue = if (binaryValue_e) null else clearEntity.binaryValue,
			documentId = if (documentId_e) null else clearEntity.documentId,
			measureValue = if (measureValue_e) null else clearEntity.measureValue,
			medicationValue = if (medicationValue_e) null else clearEntity.medicationValue,
			timeSeries = if (timeSeries_e) null else clearEntity.timeSeries,
			compoundValue =
				compoundValue_e.encryptor.let { encryptor ->
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
			ratio = if (ratio_e) null else clearEntity.ratio,
			range = if (range_e) null else clearEntity.range,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}

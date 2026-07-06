// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.EncryptableFieldConfig
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.embed.DecryptedPatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.EncryptedPatientHealthCareParty
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object PatientHealthCarePartyEncryptorFactory :
	EntityEncryptorFactory<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty> {
	override val empty:
		EntityEncryptor<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty> =
		PatientHealthCarePartyEncryptor(
			type = false,
			healthcarePartyId = false,
			sendFormats = false,
			referralPeriods = false,
			properties = EncryptableFieldConfig.None(PropertyStubEncryptorFactory),
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return PatientHealthCarePartyEncryptor(
			type = "type" in manifest.fieldsToEncrypt,
			healthcarePartyId = "healthcarePartyId" in manifest.fieldsToEncrypt,
			sendFormats = "sendFormats" in manifest.fieldsToEncrypt,
			referralPeriods = "referralPeriods" in manifest.fieldsToEncrypt,
			properties =
				if ("properties" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["properties"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedPropertyStub::class,
								decryptedClass = DecryptedPropertyStub::class,
							),
						)
					} ?: EncryptableFieldConfig.None(PropertyStubEncryptorFactory)
				},
		)
	}
}

private class PatientHealthCarePartyEncryptor(
	private val type: Boolean,
	private val healthcarePartyId: Boolean,
	private val sendFormats: Boolean,
	private val referralPeriods: Boolean,
	private val properties: EncryptableFieldConfig<EncryptedPropertyStub, DecryptedPropertyStub>,
) : AbstractEntityEncryptor<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedPatientHealthCareParty,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedPatientHealthCareParty {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (type) dataToEncrypt["type"] = encodingJson.encodeToJsonElement(clearEntity.type)
		if (healthcarePartyId) dataToEncrypt["healthcarePartyId"] = encodingJson.encodeToJsonElement(clearEntity.healthcarePartyId)
		if (sendFormats) dataToEncrypt["sendFormats"] = encodingJson.encodeToJsonElement(clearEntity.sendFormats)
		if (referralPeriods) dataToEncrypt["referralPeriods"] = encodingJson.encodeToJsonElement(clearEntity.referralPeriods)
		if (properties.fullEncryption) dataToEncrypt["properties"] = encodingJson.encodeToJsonElement(clearEntity.properties)
		return EncryptedPatientHealthCareParty(
			type = if (type) null else clearEntity.type,
			healthcarePartyId = if (healthcarePartyId) null else clearEntity.healthcarePartyId,
			sendFormats = if (sendFormats) emptyMap() else clearEntity.sendFormats,
			referralPeriods = if (referralPeriods) emptyList() else clearEntity.referralPeriods,
			properties =
				properties.encryptor.let { encryptor ->
					if (encryptor == null) {
						null
					} else {
						clearEntity.properties?.let {
							it.mapTo(mutableSetOf()) { x0 ->
								encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
							}
						}
					}
				},
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}

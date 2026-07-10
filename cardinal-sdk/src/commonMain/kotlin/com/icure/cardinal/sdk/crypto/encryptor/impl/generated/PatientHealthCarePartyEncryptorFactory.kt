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
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

@InternalIcureApi
internal object PatientHealthCarePartyEncryptorFactory :
	EntityEncryptorFactory<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty> {
	override val empty:
		EntityEncryptor<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty> =
		PatientHealthCarePartyEncryptor(
			type_e = false,
			healthcarePartyId_e = false,
			sendFormats_e = false,
			referralPeriods_e = false,
			properties_e = EncryptableFieldConfig.None(PropertyStubEncryptorFactory),
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return PatientHealthCarePartyEncryptor(
			type_e = "type" in manifest.fieldsToEncrypt,
			healthcarePartyId_e = "healthcarePartyId" in manifest.fieldsToEncrypt,
			sendFormats_e = "sendFormats" in manifest.fieldsToEncrypt,
			referralPeriods_e = "referralPeriods" in manifest.fieldsToEncrypt,
			properties_e =
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

@InternalIcureApi
private class PatientHealthCarePartyEncryptor(
	private val type_e: Boolean,
	private val healthcarePartyId_e: Boolean,
	private val sendFormats_e: Boolean,
	private val referralPeriods_e: Boolean,
	private val properties_e: EncryptableFieldConfig<EncryptedPropertyStub, DecryptedPropertyStub>,
) : AbstractEntityEncryptor<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedPatientHealthCareParty,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedPatientHealthCareParty {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (type_e && clearEntity.type != null) dataToEncrypt["type"] = encodingJson.encodeToJsonElement(clearEntity.type)
		if (healthcarePartyId_e && clearEntity.healthcarePartyId != null) {
			dataToEncrypt["healthcarePartyId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.healthcarePartyId,
				)
		}
		if (sendFormats_e && clearEntity.sendFormats.isNotEmpty()) {
			dataToEncrypt["sendFormats"] =
				encodingJson.encodeToJsonElement(
					clearEntity.sendFormats,
				)
		}
		if (referralPeriods_e && clearEntity.referralPeriods.isNotEmpty()) {
			dataToEncrypt["referralPeriods"] =
				encodingJson.encodeToJsonElement(
					clearEntity.referralPeriods,
				)
		}
		if (properties_e.fullEncryption && clearEntity.properties != null) {
			dataToEncrypt["properties"] =
				encodingJson.encodeToJsonElement(
					clearEntity.properties,
				)
		}
		return EncryptedPatientHealthCareParty(
			type = if (type_e) null else clearEntity.type,
			healthcarePartyId = if (healthcarePartyId_e) null else clearEntity.healthcarePartyId,
			sendFormats = if (sendFormats_e) emptyMap() else clearEntity.sendFormats,
			referralPeriods = if (referralPeriods_e) emptyList() else clearEntity.referralPeriods,
			properties =
				properties_e.encryptor.let { encryptor ->
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

// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
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
		object :
			EntityEncryptor<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedPatientHealthCareParty,
			): EncryptedPatientHealthCareParty =
				EncryptedPatientHealthCareParty(
					type = clearEntity.type,
					healthcarePartyId = clearEntity.healthcarePartyId,
					sendFormats = clearEntity.sendFormats,
					referralPeriods = clearEntity.referralPeriods,
					properties =
						clearEntity.properties?.let {
							it.mapTo(mutableSetOf()) { x0 ->
								PropertyStubEncryptorFactory.empty.encrypt(encryptionKey, x0)
							}
						},
					encryptedSelf = null,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty> {
		val manifest = encryptorsFactoryContext.getManifest(entityManifestName)
		require(manifest.currentExtensionsManifest == null) {
			"PatientHealthCareParty is not Extendable and does not support extensions encryption, but its manifest defines a currentExtensionsManifest."
		}
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
							encryptorsFactoryContext.getEntityEncryptorsProvider(
								entityManifestName = it,
								encryptedClass = EncryptedPropertyStub::class,
								decryptedClass = DecryptedPropertyStub::class,
							),
						)
					} ?: EncryptableFieldConfig.None(PropertyStubEncryptorFactory)
				},
			encodingJson = encodingJson,
			cryptoService = cryptoService,
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
	private val encodingJson: Json,
	cryptoService: CryptoService,
) :
	AbstractEntityEncryptor<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedPatientHealthCareParty,
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
								encryptor.encrypt(encryptionKey, x0)
							}
						}
					}
				},
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
		)
	}
}

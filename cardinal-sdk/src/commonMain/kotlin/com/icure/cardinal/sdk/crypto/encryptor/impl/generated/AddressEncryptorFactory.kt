// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.EncryptableFieldConfig
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.DecryptedAnnotation
import com.icure.cardinal.sdk.model.embed.DecryptedTelecom
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
import com.icure.cardinal.sdk.model.embed.EncryptedAnnotation
import com.icure.cardinal.sdk.model.embed.EncryptedTelecom
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
internal object AddressEncryptorFactory : EntityEncryptorFactory<EncryptedAddress, DecryptedAddress> {
	override val empty: EntityEncryptor<EncryptedAddress, DecryptedAddress> =
		object :
			EntityEncryptor<EncryptedAddress, DecryptedAddress> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedAddress,
			): EncryptedAddress =
				EncryptedAddress(
					tags = clearEntity.tags,
					codes = clearEntity.codes,
					identifier = clearEntity.identifier,
					addressType = clearEntity.addressType,
					descr = clearEntity.descr,
					street = clearEntity.street,
					houseNumber = clearEntity.houseNumber,
					postboxNumber = clearEntity.postboxNumber,
					postalCode = clearEntity.postalCode,
					city = clearEntity.city,
					state = clearEntity.state,
					country = clearEntity.country,
					note = clearEntity.note,
					notes =
						clearEntity.notes.map { x0 ->
							AnnotationEncryptorFactory.empty.encrypt(encryptionKey, x0)
						},
					telecoms =
						clearEntity.telecoms.map { x0 ->
							TelecomEncryptorFactory.empty.encrypt(encryptionKey, x0)
						},
					encryptedSelf = null,
					extensions = clearEntity.extensions,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedAddress, DecryptedAddress> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return AddressEncryptor(
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			identifier_e = "identifier" in manifest.fieldsToEncrypt,
			addressType_e = "addressType" in manifest.fieldsToEncrypt,
			descr_e = "descr" in manifest.fieldsToEncrypt,
			street_e = "street" in manifest.fieldsToEncrypt,
			houseNumber_e = "houseNumber" in manifest.fieldsToEncrypt,
			postboxNumber_e = "postboxNumber" in manifest.fieldsToEncrypt,
			postalCode_e = "postalCode" in manifest.fieldsToEncrypt,
			city_e = "city" in manifest.fieldsToEncrypt,
			state_e = "state" in manifest.fieldsToEncrypt,
			country_e = "country" in manifest.fieldsToEncrypt,
			note_e = "note" in manifest.fieldsToEncrypt,
			notes_e =
				if ("notes" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["notes"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedAnnotation::class,
								decryptedClass = DecryptedAnnotation::class,
							),
						)
					} ?: EncryptableFieldConfig.None(AnnotationEncryptorFactory)
				},
			telecoms_e =
				if ("telecoms" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["telecoms"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedTelecom::class,
								decryptedClass = DecryptedTelecom::class,
							),
						)
					} ?: EncryptableFieldConfig.None(TelecomEncryptorFactory)
				},
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class AddressEncryptor(
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val identifier_e: Boolean,
	private val addressType_e: Boolean,
	private val descr_e: Boolean,
	private val street_e: Boolean,
	private val houseNumber_e: Boolean,
	private val postboxNumber_e: Boolean,
	private val postalCode_e: Boolean,
	private val city_e: Boolean,
	private val state_e: Boolean,
	private val country_e: Boolean,
	private val note_e: Boolean,
	private val notes_e: EncryptableFieldConfig<EncryptedAnnotation, DecryptedAnnotation>,
	private val telecoms_e: EncryptableFieldConfig<EncryptedTelecom, DecryptedTelecom>,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedAddress, DecryptedAddress>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedAddress,
	): EncryptedAddress {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (tags_e && clearEntity.tags.isNotEmpty()) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes_e && clearEntity.codes.isNotEmpty()) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (identifier_e && clearEntity.identifier.isNotEmpty()) {
			dataToEncrypt["identifier"] =
				encodingJson.encodeToJsonElement(
					clearEntity.identifier,
				)
		}
		if (addressType_e && clearEntity.addressType != null) {
			dataToEncrypt["addressType"] =
				encodingJson.encodeToJsonElement(
					clearEntity.addressType,
				)
		}
		if (descr_e && clearEntity.descr != null) dataToEncrypt["descr"] = encodingJson.encodeToJsonElement(clearEntity.descr)
		if (street_e && clearEntity.street != null) dataToEncrypt["street"] = encodingJson.encodeToJsonElement(clearEntity.street)
		if (houseNumber_e && clearEntity.houseNumber != null) {
			dataToEncrypt["houseNumber"] =
				encodingJson.encodeToJsonElement(
					clearEntity.houseNumber,
				)
		}
		if (postboxNumber_e && clearEntity.postboxNumber != null) {
			dataToEncrypt["postboxNumber"] =
				encodingJson.encodeToJsonElement(
					clearEntity.postboxNumber,
				)
		}
		if (postalCode_e && clearEntity.postalCode != null) dataToEncrypt["postalCode"] = encodingJson.encodeToJsonElement(clearEntity.postalCode)
		if (city_e && clearEntity.city != null) dataToEncrypt["city"] = encodingJson.encodeToJsonElement(clearEntity.city)
		if (state_e && clearEntity.state != null) dataToEncrypt["state"] = encodingJson.encodeToJsonElement(clearEntity.state)
		if (country_e && clearEntity.country != null) dataToEncrypt["country"] = encodingJson.encodeToJsonElement(clearEntity.country)
		if (note_e && clearEntity.note != null) dataToEncrypt["note"] = encodingJson.encodeToJsonElement(clearEntity.note)
		if (notes_e.fullEncryption && clearEntity.notes.isNotEmpty()) dataToEncrypt["notes"] = encodingJson.encodeToJsonElement(clearEntity.notes)
		if (telecoms_e.fullEncryption && clearEntity.telecoms.isNotEmpty()) {
			dataToEncrypt["telecoms"] =
				encodingJson.encodeToJsonElement(
					clearEntity.telecoms,
				)
		}
		return EncryptedAddress(
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			identifier = if (identifier_e) emptyList() else clearEntity.identifier,
			addressType = if (addressType_e) null else clearEntity.addressType,
			descr = if (descr_e) null else clearEntity.descr,
			street = if (street_e) null else clearEntity.street,
			houseNumber = if (houseNumber_e) null else clearEntity.houseNumber,
			postboxNumber = if (postboxNumber_e) null else clearEntity.postboxNumber,
			postalCode = if (postalCode_e) null else clearEntity.postalCode,
			city = if (city_e) null else clearEntity.city,
			state = if (state_e) null else clearEntity.state,
			country = if (country_e) null else clearEntity.country,
			note = if (note_e) null else clearEntity.note,
			notes =
				notes_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.notes.map { x0 ->
							encryptor.encrypt(encryptionKey, x0)
						}
					}
				},
			telecoms =
				telecoms_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.telecoms.map { x0 ->
							encryptor.encrypt(encryptionKey, x0)
						}
					}
				},
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
			extensions = clearEntity.extensions,
		)
	}
}

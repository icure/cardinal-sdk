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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object AddressEncryptorFactory : EntityEncryptorFactory<EncryptedAddress, DecryptedAddress> {
	override val empty: EntityEncryptor<EncryptedAddress, DecryptedAddress> =
		AddressEncryptor(
			tags = false,
			codes = false,
			identifier = false,
			addressType = false,
			descr = false,
			street = false,
			houseNumber = false,
			postboxNumber = false,
			postalCode = false,
			city = false,
			state = false,
			country = false,
			note = false,
			notes = EncryptableFieldConfig.None(AnnotationEncryptorFactory),
			telecoms = EncryptableFieldConfig.None(TelecomEncryptorFactory),
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedAddress, DecryptedAddress> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return AddressEncryptor(
			tags = "tags" in manifest.fieldsToEncrypt,
			codes = "codes" in manifest.fieldsToEncrypt,
			identifier = "identifier" in manifest.fieldsToEncrypt,
			addressType = "addressType" in manifest.fieldsToEncrypt,
			descr = "descr" in manifest.fieldsToEncrypt,
			street = "street" in manifest.fieldsToEncrypt,
			houseNumber = "houseNumber" in manifest.fieldsToEncrypt,
			postboxNumber = "postboxNumber" in manifest.fieldsToEncrypt,
			postalCode = "postalCode" in manifest.fieldsToEncrypt,
			city = "city" in manifest.fieldsToEncrypt,
			state = "state" in manifest.fieldsToEncrypt,
			country = "country" in manifest.fieldsToEncrypt,
			note = "note" in manifest.fieldsToEncrypt,
			notes =
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
			telecoms =
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
		)
	}
}

private class AddressEncryptor(
	private val tags: Boolean,
	private val codes: Boolean,
	private val identifier: Boolean,
	private val addressType: Boolean,
	private val descr: Boolean,
	private val street: Boolean,
	private val houseNumber: Boolean,
	private val postboxNumber: Boolean,
	private val postalCode: Boolean,
	private val city: Boolean,
	private val state: Boolean,
	private val country: Boolean,
	private val note: Boolean,
	private val notes: EncryptableFieldConfig<EncryptedAnnotation, DecryptedAnnotation>,
	private val telecoms: EncryptableFieldConfig<EncryptedTelecom, DecryptedTelecom>,
) : AbstractEntityEncryptor<EncryptedAddress, DecryptedAddress>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedAddress,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedAddress {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (tags) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (identifier) dataToEncrypt["identifier"] = encodingJson.encodeToJsonElement(clearEntity.identifier)
		if (addressType) dataToEncrypt["addressType"] = encodingJson.encodeToJsonElement(clearEntity.addressType)
		if (descr) dataToEncrypt["descr"] = encodingJson.encodeToJsonElement(clearEntity.descr)
		if (street) dataToEncrypt["street"] = encodingJson.encodeToJsonElement(clearEntity.street)
		if (houseNumber) dataToEncrypt["houseNumber"] = encodingJson.encodeToJsonElement(clearEntity.houseNumber)
		if (postboxNumber) dataToEncrypt["postboxNumber"] = encodingJson.encodeToJsonElement(clearEntity.postboxNumber)
		if (postalCode) dataToEncrypt["postalCode"] = encodingJson.encodeToJsonElement(clearEntity.postalCode)
		if (city) dataToEncrypt["city"] = encodingJson.encodeToJsonElement(clearEntity.city)
		if (state) dataToEncrypt["state"] = encodingJson.encodeToJsonElement(clearEntity.state)
		if (country) dataToEncrypt["country"] = encodingJson.encodeToJsonElement(clearEntity.country)
		if (note) dataToEncrypt["note"] = encodingJson.encodeToJsonElement(clearEntity.note)
		if (notes.fullEncryption) dataToEncrypt["notes"] = encodingJson.encodeToJsonElement(clearEntity.notes)
		if (telecoms.fullEncryption) dataToEncrypt["telecoms"] = encodingJson.encodeToJsonElement(clearEntity.telecoms)
		return EncryptedAddress(
			tags = if (tags) emptySet() else clearEntity.tags,
			codes = if (codes) emptySet() else clearEntity.codes,
			identifier = if (identifier) emptyList() else clearEntity.identifier,
			addressType = if (addressType) null else clearEntity.addressType,
			descr = if (descr) null else clearEntity.descr,
			street = if (street) null else clearEntity.street,
			houseNumber = if (houseNumber) null else clearEntity.houseNumber,
			postboxNumber = if (postboxNumber) null else clearEntity.postboxNumber,
			postalCode = if (postalCode) null else clearEntity.postalCode,
			city = if (city) null else clearEntity.city,
			state = if (state) null else clearEntity.state,
			country = if (country) null else clearEntity.country,
			note = if (note) null else clearEntity.note,
			notes =
				notes.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.notes.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			telecoms =
				telecoms.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.telecoms.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			extensions = clearEntity.extensions,
		)
	}
}

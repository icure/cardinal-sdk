// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.EncryptableFieldConfig
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.DecryptedAnnotation
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.DecryptedSubContact
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
import com.icure.cardinal.sdk.model.embed.EncryptedAnnotation
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedSubContact
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object ContactEncryptorFactory : EntityEncryptorFactory<EncryptedContact, DecryptedContact> {
	override val empty: EntityEncryptor<EncryptedContact, DecryptedContact> =
		ContactEncryptor(
			created = false,
			modified = false,
			author = false,
			responsible = false,
			tags = false,
			codes = false,
			identifier = false,
			groupId = false,
			openingDate = false,
			closingDate = false,
			descr = false,
			location = false,
			encounterType = false,
			encounterLocation = EncryptableFieldConfig.None(AddressEncryptorFactory),
			subContacts = EncryptableFieldConfig.None(SubContactEncryptorFactory),
			services = EncryptableFieldConfig.None(ServiceEncryptorFactory),
			participantList = false,
			notes = EncryptableFieldConfig.None(AnnotationEncryptorFactory),
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedContact, DecryptedContact> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return ContactEncryptor(
			created = "created" in manifest.fieldsToEncrypt,
			modified = "modified" in manifest.fieldsToEncrypt,
			author = "author" in manifest.fieldsToEncrypt,
			responsible = "responsible" in manifest.fieldsToEncrypt,
			tags = "tags" in manifest.fieldsToEncrypt,
			codes = "codes" in manifest.fieldsToEncrypt,
			identifier = "identifier" in manifest.fieldsToEncrypt,
			groupId = "groupId" in manifest.fieldsToEncrypt,
			openingDate = "openingDate" in manifest.fieldsToEncrypt,
			closingDate = "closingDate" in manifest.fieldsToEncrypt,
			descr = "descr" in manifest.fieldsToEncrypt,
			location = "location" in manifest.fieldsToEncrypt,
			encounterType = "encounterType" in manifest.fieldsToEncrypt,
			encounterLocation =
				if ("encounterLocation" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["encounterLocation"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedAddress::class,
								decryptedClass = DecryptedAddress::class,
							),
						)
					} ?: EncryptableFieldConfig.None(AddressEncryptorFactory)
				},
			subContacts =
				if ("subContacts" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["subContacts"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedSubContact::class,
								decryptedClass = DecryptedSubContact::class,
							),
						)
					} ?: EncryptableFieldConfig.None(SubContactEncryptorFactory)
				},
			services =
				if ("services" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["services"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedService::class,
								decryptedClass = DecryptedService::class,
							),
						)
					} ?: EncryptableFieldConfig.None(ServiceEncryptorFactory)
				},
			participantList = "participantList" in manifest.fieldsToEncrypt,
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
		)
	}
}

private class ContactEncryptor(
	private val created: Boolean,
	private val modified: Boolean,
	private val author: Boolean,
	private val responsible: Boolean,
	private val tags: Boolean,
	private val codes: Boolean,
	private val identifier: Boolean,
	private val groupId: Boolean,
	private val openingDate: Boolean,
	private val closingDate: Boolean,
	private val descr: Boolean,
	private val location: Boolean,
	private val encounterType: Boolean,
	private val encounterLocation: EncryptableFieldConfig<EncryptedAddress, DecryptedAddress>,
	private val subContacts: EncryptableFieldConfig<EncryptedSubContact, DecryptedSubContact>,
	private val services: EncryptableFieldConfig<EncryptedService, DecryptedService>,
	private val participantList: Boolean,
	private val notes: EncryptableFieldConfig<EncryptedAnnotation, DecryptedAnnotation>,
) : AbstractEntityEncryptor<EncryptedContact, DecryptedContact>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedContact,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedContact {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (created) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible) dataToEncrypt["responsible"] = encodingJson.encodeToJsonElement(clearEntity.responsible)
		if (tags) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (identifier) dataToEncrypt["identifier"] = encodingJson.encodeToJsonElement(clearEntity.identifier)
		if (groupId) dataToEncrypt["groupId"] = encodingJson.encodeToJsonElement(clearEntity.groupId)
		if (openingDate) dataToEncrypt["openingDate"] = encodingJson.encodeToJsonElement(clearEntity.openingDate)
		if (closingDate) dataToEncrypt["closingDate"] = encodingJson.encodeToJsonElement(clearEntity.closingDate)
		if (descr) dataToEncrypt["descr"] = encodingJson.encodeToJsonElement(clearEntity.descr)
		if (location) dataToEncrypt["location"] = encodingJson.encodeToJsonElement(clearEntity.location)
		if (encounterType) dataToEncrypt["encounterType"] = encodingJson.encodeToJsonElement(clearEntity.encounterType)
		if (encounterLocation.fullEncryption) dataToEncrypt["encounterLocation"] = encodingJson.encodeToJsonElement(clearEntity.encounterLocation)
		if (subContacts.fullEncryption) dataToEncrypt["subContacts"] = encodingJson.encodeToJsonElement(clearEntity.subContacts)
		if (services.fullEncryption) dataToEncrypt["services"] = encodingJson.encodeToJsonElement(clearEntity.services)
		if (participantList) dataToEncrypt["participantList"] = encodingJson.encodeToJsonElement(clearEntity.participantList)
		if (notes.fullEncryption) dataToEncrypt["notes"] = encodingJson.encodeToJsonElement(clearEntity.notes)
		return EncryptedContact(
			id = clearEntity.id,
			rev = clearEntity.rev,
			created = if (created) null else clearEntity.created,
			modified = if (modified) null else clearEntity.modified,
			author = if (author) null else clearEntity.author,
			responsible = if (responsible) null else clearEntity.responsible,
			tags = if (tags) emptySet() else clearEntity.tags,
			codes = if (codes) emptySet() else clearEntity.codes,
			identifier = if (identifier) emptyList() else clearEntity.identifier,
			endOfLife = clearEntity.endOfLife,
			deletionDate = clearEntity.deletionDate,
			groupId = if (groupId) null else clearEntity.groupId,
			openingDate = if (openingDate) null else clearEntity.openingDate,
			closingDate = if (closingDate) null else clearEntity.closingDate,
			descr = if (descr) null else clearEntity.descr,
			location = if (location) null else clearEntity.location,
			encounterType = if (encounterType) null else clearEntity.encounterType,
			encounterLocation =
				encounterLocation.encryptor.let { encryptor ->
					if (encryptor == null) {
						null
					} else {
						clearEntity.encounterLocation?.let {
							encryptor.encrypt(encryptionKey, it, encodingJson, cryptoService)
						}
					}
				},
			subContacts =
				subContacts.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptySet()
					} else {
						clearEntity.subContacts.mapTo(mutableSetOf()) { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			services =
				services.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptySet()
					} else {
						clearEntity.services.mapTo(mutableSetOf()) { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			participantList = if (participantList) emptyList() else clearEntity.participantList,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			securityMetadata = clearEntity.securityMetadata,
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
			extensions = clearEntity.extensions,
			extensionsVersion = clearEntity.extensionsVersion,
		)
	}
}

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
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

@InternalIcureApi
internal object ContactEncryptorFactory : EntityEncryptorFactory<EncryptedContact, DecryptedContact> {
	override val empty: EntityEncryptor<EncryptedContact, DecryptedContact> =
		object :
			EntityEncryptor<EncryptedContact, DecryptedContact> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedContact,
			): EncryptedContact =
				EncryptedContact(
					id = clearEntity.id,
					rev = clearEntity.rev,
					created = clearEntity.created,
					modified = clearEntity.modified,
					author = clearEntity.author,
					responsible = clearEntity.responsible,
					tags = clearEntity.tags,
					codes = clearEntity.codes,
					identifier = clearEntity.identifier,
					endOfLife = clearEntity.endOfLife,
					deletionDate = clearEntity.deletionDate,
					groupId = clearEntity.groupId,
					openingDate = clearEntity.openingDate,
					closingDate = clearEntity.closingDate,
					descr = clearEntity.descr,
					location = clearEntity.location,
					encounterType = clearEntity.encounterType,
					encounterLocation =
						clearEntity.encounterLocation?.let {
							AddressEncryptorFactory.empty.encrypt(encryptionKey, it)
						},
					subContacts =
						clearEntity.subContacts.mapTo(mutableSetOf()) { x0 ->
							SubContactEncryptorFactory.empty.encrypt(encryptionKey, x0)
						},
					services =
						clearEntity.services.mapTo(mutableSetOf()) { x0 ->
							ServiceEncryptorFactory.empty.encrypt(encryptionKey, x0)
						},
					participantList = clearEntity.participantList,
					secretForeignKeys = clearEntity.secretForeignKeys,
					cryptedForeignKeys = clearEntity.cryptedForeignKeys,
					delegations = clearEntity.delegations,
					encryptionKeys = clearEntity.encryptionKeys,
					encryptedSelf = null,
					securityMetadata = clearEntity.securityMetadata,
					notes =
						clearEntity.notes.map { x0 ->
							AnnotationEncryptorFactory.empty.encrypt(encryptionKey, x0)
						},
					extensions = clearEntity.extensions,
					extensionsVersion = clearEntity.extensionsVersion,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedContact, DecryptedContact> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return ContactEncryptor(
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			identifier_e = "identifier" in manifest.fieldsToEncrypt,
			groupId_e = "groupId" in manifest.fieldsToEncrypt,
			openingDate_e = "openingDate" in manifest.fieldsToEncrypt,
			closingDate_e = "closingDate" in manifest.fieldsToEncrypt,
			descr_e = "descr" in manifest.fieldsToEncrypt,
			location_e = "location" in manifest.fieldsToEncrypt,
			encounterType_e = "encounterType" in manifest.fieldsToEncrypt,
			encounterLocation_e =
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
			subContacts_e =
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
			services_e =
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
			participantList_e = "participantList" in manifest.fieldsToEncrypt,
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
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class ContactEncryptor(
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val identifier_e: Boolean,
	private val groupId_e: Boolean,
	private val openingDate_e: Boolean,
	private val closingDate_e: Boolean,
	private val descr_e: Boolean,
	private val location_e: Boolean,
	private val encounterType_e: Boolean,
	private val encounterLocation_e: EncryptableFieldConfig<EncryptedAddress, DecryptedAddress>,
	private val subContacts_e: EncryptableFieldConfig<EncryptedSubContact, DecryptedSubContact>,
	private val services_e: EncryptableFieldConfig<EncryptedService, DecryptedService>,
	private val participantList_e: Boolean,
	private val notes_e: EncryptableFieldConfig<EncryptedAnnotation, DecryptedAnnotation>,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedContact, DecryptedContact>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedContact,
	): EncryptedContact {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (created_e && clearEntity.created != null) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified_e && clearEntity.modified != null) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author_e && clearEntity.author != null) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible_e && clearEntity.responsible != null) {
			dataToEncrypt["responsible"] =
				encodingJson.encodeToJsonElement(
					clearEntity.responsible,
				)
		}
		if (tags_e && clearEntity.tags.isNotEmpty()) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes_e && clearEntity.codes.isNotEmpty()) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (identifier_e && clearEntity.identifier.isNotEmpty()) {
			dataToEncrypt["identifier"] =
				encodingJson.encodeToJsonElement(
					clearEntity.identifier,
				)
		}
		if (groupId_e && clearEntity.groupId != null) dataToEncrypt["groupId"] = encodingJson.encodeToJsonElement(clearEntity.groupId)
		if (openingDate_e && clearEntity.openingDate != null) {
			dataToEncrypt["openingDate"] =
				encodingJson.encodeToJsonElement(
					clearEntity.openingDate,
				)
		}
		if (closingDate_e && clearEntity.closingDate != null) {
			dataToEncrypt["closingDate"] =
				encodingJson.encodeToJsonElement(
					clearEntity.closingDate,
				)
		}
		if (descr_e && clearEntity.descr != null) dataToEncrypt["descr"] = encodingJson.encodeToJsonElement(clearEntity.descr)
		if (location_e && clearEntity.location != null) dataToEncrypt["location"] = encodingJson.encodeToJsonElement(clearEntity.location)
		if (encounterType_e && clearEntity.encounterType != null) {
			dataToEncrypt["encounterType"] =
				encodingJson.encodeToJsonElement(
					clearEntity.encounterType,
				)
		}
		if (encounterLocation_e.fullEncryption && clearEntity.encounterLocation != null) {
			dataToEncrypt["encounterLocation"] =
				encodingJson.encodeToJsonElement(
					clearEntity.encounterLocation,
				)
		}
		if (subContacts_e.fullEncryption && clearEntity.subContacts.isNotEmpty()) {
			dataToEncrypt["subContacts"] =
				encodingJson.encodeToJsonElement(
					clearEntity.subContacts,
				)
		}
		if (services_e.fullEncryption && clearEntity.services.isNotEmpty()) {
			dataToEncrypt["services"] =
				encodingJson.encodeToJsonElement(
					clearEntity.services,
				)
		}
		if (participantList_e && clearEntity.participantList.isNotEmpty()) {
			dataToEncrypt["participantList"] =
				encodingJson.encodeToJsonElement(
					clearEntity.participantList,
				)
		}
		if (notes_e.fullEncryption && clearEntity.notes.isNotEmpty()) dataToEncrypt["notes"] = encodingJson.encodeToJsonElement(clearEntity.notes)
		return EncryptedContact(
			id = clearEntity.id,
			rev = clearEntity.rev,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			identifier = if (identifier_e) emptyList() else clearEntity.identifier,
			endOfLife = clearEntity.endOfLife,
			deletionDate = clearEntity.deletionDate,
			groupId = if (groupId_e) null else clearEntity.groupId,
			openingDate = if (openingDate_e) null else clearEntity.openingDate,
			closingDate = if (closingDate_e) null else clearEntity.closingDate,
			descr = if (descr_e) null else clearEntity.descr,
			location = if (location_e) null else clearEntity.location,
			encounterType = if (encounterType_e) null else clearEntity.encounterType,
			encounterLocation =
				encounterLocation_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						null
					} else {
						clearEntity.encounterLocation?.let {
							encryptor.encrypt(encryptionKey, it)
						}
					}
				},
			subContacts =
				subContacts_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptySet()
					} else {
						clearEntity.subContacts.mapTo(mutableSetOf()) { x0 ->
							encryptor.encrypt(encryptionKey, x0)
						}
					}
				},
			services =
				services_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptySet()
					} else {
						clearEntity.services.mapTo(mutableSetOf()) { x0 ->
							encryptor.encrypt(encryptionKey, x0)
						}
					}
				},
			participantList = if (participantList_e) emptyList() else clearEntity.participantList,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
			securityMetadata = clearEntity.securityMetadata,
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
			extensions = clearEntity.extensions,
			extensionsVersion = clearEntity.extensionsVersion,
		)
	}
}

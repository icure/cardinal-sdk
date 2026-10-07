// This file is auto-generated
@file:Suppress("ktlint:standard:max-line-length")

package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.encryptExtension
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress

@InternalIcureApi
internal object DocumentEncryptorFactory : EntityEncryptorFactory<EncryptedDocument, DecryptedDocument> {
	override val empty: EntityEncryptor<EncryptedDocument, DecryptedDocument> =
		object : EntityEncryptor<EncryptedDocument, DecryptedDocument> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedDocument,
			): EncryptedDocument =
				EncryptedDocument(
					id = clearEntity.id,
					rev = clearEntity.rev,
					created = clearEntity.created,
					modified = clearEntity.modified,
					author = clearEntity.author,
					responsible = clearEntity.responsible,
					medicalLocationId = clearEntity.medicalLocationId,
					tags = clearEntity.tags,
					codes = clearEntity.codes,
					endOfLife = clearEntity.endOfLife,
					deletionDate = clearEntity.deletionDate,
					documentLocation = clearEntity.documentLocation,
					documentType = clearEntity.documentType,
					documentStatus = clearEntity.documentStatus,
					externalUri = clearEntity.externalUri,
					name = clearEntity.name,
					version = clearEntity.version,
					storedICureDocumentId = clearEntity.storedICureDocumentId,
					externalUuid = clearEntity.externalUuid,
					size = clearEntity.size,
					hash = clearEntity.hash,
					openingContactId = clearEntity.openingContactId,
					attachmentId = clearEntity.attachmentId,
					objectStoreReference = clearEntity.objectStoreReference,
					mainUti = clearEntity.mainUti,
					otherUtis = clearEntity.otherUtis,
					mainAttachmentStoredDataSize = clearEntity.mainAttachmentStoredDataSize,
					extraMainAttachmentInfo = clearEntity.extraMainAttachmentInfo,
					secondaryAttachments = clearEntity.secondaryAttachments,
					deletedAttachments = clearEntity.deletedAttachments,
					encryptedAttachment = clearEntity.encryptedAttachment,
					decryptedAttachment = clearEntity.decryptedAttachment,
					secretForeignKeys = clearEntity.secretForeignKeys,
					cryptedForeignKeys = clearEntity.cryptedForeignKeys,
					delegations = clearEntity.delegations,
					encryptionKeys = clearEntity.encryptionKeys,
					encryptedSelf = null,
					securityMetadata = clearEntity.securityMetadata,
					extensions = clearEntity.extensions,
					customisedModelVersion = clearEntity.customisedModelVersion,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedDocument, DecryptedDocument> {
		val manifest = encryptorsFactoryContext.getManifest(entityManifestName)
		val extensionsEncryptor =
			manifest.currentExtensionsManifest?.let {
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = it,
					encryptedClass = EncryptedDocument::class,
					decryptedClass = DecryptedDocument::class,
				)
			}
		return DocumentEncryptor(
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			medicalLocationId_e = "medicalLocationId" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			endOfLife_e = "endOfLife" in manifest.fieldsToEncrypt,
			documentLocation_e = "documentLocation" in manifest.fieldsToEncrypt,
			documentType_e = "documentType" in manifest.fieldsToEncrypt,
			documentStatus_e = "documentStatus" in manifest.fieldsToEncrypt,
			externalUri_e = "externalUri" in manifest.fieldsToEncrypt,
			name_e = "name" in manifest.fieldsToEncrypt,
			version_e = "version" in manifest.fieldsToEncrypt,
			storedICureDocumentId_e = "storedICureDocumentId" in manifest.fieldsToEncrypt,
			externalUuid_e = "externalUuid" in manifest.fieldsToEncrypt,
			openingContactId_e = "openingContactId" in manifest.fieldsToEncrypt,
			extensionsEncryptor = extensionsEncryptor,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class DocumentEncryptor(
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val medicalLocationId_e: Boolean,
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val endOfLife_e: Boolean,
	private val documentLocation_e: Boolean,
	private val documentType_e: Boolean,
	private val documentStatus_e: Boolean,
	private val externalUri_e: Boolean,
	private val name_e: Boolean,
	private val version_e: Boolean,
	private val storedICureDocumentId_e: Boolean,
	private val externalUuid_e: Boolean,
	private val openingContactId_e: Boolean,
	private val extensionsEncryptor: Lazy<ExtensionsEncryptors>?,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedDocument, DecryptedDocument>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedDocument,
	): EncryptedDocument {
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
		if (medicalLocationId_e && clearEntity.medicalLocationId != null) {
			dataToEncrypt["medicalLocationId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.medicalLocationId,
				)
		}
		if (tags_e && clearEntity.tags.isNotEmpty()) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes_e && clearEntity.codes.isNotEmpty()) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (endOfLife_e && clearEntity.endOfLife != null) dataToEncrypt["endOfLife"] = encodingJson.encodeToJsonElement(clearEntity.endOfLife)
		if (documentLocation_e && clearEntity.documentLocation != null) {
			dataToEncrypt["documentLocation"] =
				encodingJson.encodeToJsonElement(
					clearEntity.documentLocation,
				)
		}
		if (documentType_e && clearEntity.documentType != null) {
			dataToEncrypt["documentType"] =
				encodingJson.encodeToJsonElement(
					clearEntity.documentType,
				)
		}
		if (documentStatus_e && clearEntity.documentStatus != null) {
			dataToEncrypt["documentStatus"] =
				encodingJson.encodeToJsonElement(
					clearEntity.documentStatus,
				)
		}
		if (externalUri_e && clearEntity.externalUri != null) {
			dataToEncrypt["externalUri"] =
				encodingJson.encodeToJsonElement(
					clearEntity.externalUri,
				)
		}
		if (name_e && clearEntity.name != null) dataToEncrypt["name"] = encodingJson.encodeToJsonElement(clearEntity.name)
		if (version_e && clearEntity.version != null) dataToEncrypt["version"] = encodingJson.encodeToJsonElement(clearEntity.version)
		if (storedICureDocumentId_e && clearEntity.storedICureDocumentId != null) {
			dataToEncrypt["storedICureDocumentId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.storedICureDocumentId,
				)
		}
		if (externalUuid_e && clearEntity.externalUuid != null) {
			dataToEncrypt["externalUuid"] =
				encodingJson.encodeToJsonElement(
					clearEntity.externalUuid,
				)
		}
		if (openingContactId_e && clearEntity.openingContactId != null) {
			dataToEncrypt["openingContactId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.openingContactId,
				)
		}
		return EncryptedDocument(
			id = clearEntity.id,
			rev = clearEntity.rev,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			medicalLocationId = if (medicalLocationId_e) null else clearEntity.medicalLocationId,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			endOfLife = if (endOfLife_e) null else clearEntity.endOfLife,
			deletionDate = clearEntity.deletionDate,
			documentLocation = if (documentLocation_e) null else clearEntity.documentLocation,
			documentType = if (documentType_e) null else clearEntity.documentType,
			documentStatus = if (documentStatus_e) null else clearEntity.documentStatus,
			externalUri = if (externalUri_e) null else clearEntity.externalUri,
			name = if (name_e) null else clearEntity.name,
			version = if (version_e) null else clearEntity.version,
			storedICureDocumentId = if (storedICureDocumentId_e) null else clearEntity.storedICureDocumentId,
			externalUuid = if (externalUuid_e) null else clearEntity.externalUuid,
			size = clearEntity.size,
			hash = clearEntity.hash,
			openingContactId = if (openingContactId_e) null else clearEntity.openingContactId,
			attachmentId = clearEntity.attachmentId,
			objectStoreReference = clearEntity.objectStoreReference,
			mainUti = clearEntity.mainUti,
			otherUtis = clearEntity.otherUtis,
			mainAttachmentStoredDataSize = clearEntity.mainAttachmentStoredDataSize,
			extraMainAttachmentInfo = clearEntity.extraMainAttachmentInfo,
			secondaryAttachments = clearEntity.secondaryAttachments,
			deletedAttachments = clearEntity.deletedAttachments,
			encryptedAttachment = clearEntity.encryptedAttachment,
			decryptedAttachment = clearEntity.decryptedAttachment,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
			securityMetadata = clearEntity.securityMetadata,
			extensions = extensionsEncryptor?.value?.encryptExtension(encryptionKey, clearEntity.extensions) ?: clearEntity.extensions,
			customisedModelVersion = clearEntity.customisedModelVersion,
		)
	}
}

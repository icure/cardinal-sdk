// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
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
import kotlin.String

@InternalIcureApi
internal object DocumentEncryptorFactory :
	EntityEncryptorFactory<EncryptedDocument, DecryptedDocument> {
	override val empty: EntityEncryptor<EncryptedDocument, DecryptedDocument> =
		object :
			EntityEncryptor<EncryptedDocument, DecryptedDocument> {
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
					tags = clearEntity.tags,
					codes = clearEntity.codes,
					deletionDate = clearEntity.deletionDate,
					documentType = clearEntity.documentType,
					documentStatus = clearEntity.documentStatus,
					externalUri = clearEntity.externalUri,
					name = clearEntity.name,
					version = clearEntity.version,
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
					secretForeignKeys = clearEntity.secretForeignKeys,
					cryptedForeignKeys = clearEntity.cryptedForeignKeys,
					delegations = clearEntity.delegations,
					encryptionKeys = clearEntity.encryptionKeys,
					encryptedSelf = null,
					securityMetadata = clearEntity.securityMetadata,
					extensions = clearEntity.extensions,
					extensionsVersion = clearEntity.extensionsVersion,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedDocument, DecryptedDocument> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return DocumentEncryptor(
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			documentType_e = "documentType" in manifest.fieldsToEncrypt,
			documentStatus_e = "documentStatus" in manifest.fieldsToEncrypt,
			externalUri_e = "externalUri" in manifest.fieldsToEncrypt,
			name_e = "name" in manifest.fieldsToEncrypt,
			version_e = "version" in manifest.fieldsToEncrypt,
			openingContactId_e = "openingContactId" in manifest.fieldsToEncrypt,
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
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val documentType_e: Boolean,
	private val documentStatus_e: Boolean,
	private val externalUri_e: Boolean,
	private val name_e: Boolean,
	private val version_e: Boolean,
	private val openingContactId_e: Boolean,
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
		if (tags_e && clearEntity.tags.isNotEmpty()) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes_e && clearEntity.codes.isNotEmpty()) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
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
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			deletionDate = clearEntity.deletionDate,
			documentType = if (documentType_e) null else clearEntity.documentType,
			documentStatus = if (documentStatus_e) null else clearEntity.documentStatus,
			externalUri = if (externalUri_e) null else clearEntity.externalUri,
			name = if (name_e) null else clearEntity.name,
			version = if (version_e) null else clearEntity.version,
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
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
			securityMetadata = clearEntity.securityMetadata,
			extensions = clearEntity.extensions,
			extensionsVersion = clearEntity.extensionsVersion,
		)
	}
}

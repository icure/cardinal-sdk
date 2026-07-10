// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.DecryptedForm
import com.icure.cardinal.sdk.model.EncryptedForm
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
internal object FormEncryptorFactory : EntityEncryptorFactory<EncryptedForm, DecryptedForm> {
	override val empty: EntityEncryptor<EncryptedForm, DecryptedForm> =
		object :
			EntityEncryptor<EncryptedForm, DecryptedForm> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedForm,
			): EncryptedForm =
				EncryptedForm(
					id = clearEntity.id,
					rev = clearEntity.rev,
					created = clearEntity.created,
					modified = clearEntity.modified,
					author = clearEntity.author,
					responsible = clearEntity.responsible,
					tags = clearEntity.tags,
					codes = clearEntity.codes,
					deletionDate = clearEntity.deletionDate,
					openingDate = clearEntity.openingDate,
					status = clearEntity.status,
					version = clearEntity.version,
					descr = clearEntity.descr,
					uniqueId = clearEntity.uniqueId,
					formTemplateId = clearEntity.formTemplateId,
					contactId = clearEntity.contactId,
					healthElementId = clearEntity.healthElementId,
					planOfActionId = clearEntity.planOfActionId,
					parent = clearEntity.parent,
					anchorId = clearEntity.anchorId,
					secretForeignKeys = clearEntity.secretForeignKeys,
					cryptedForeignKeys = clearEntity.cryptedForeignKeys,
					delegations = clearEntity.delegations,
					encryptionKeys = clearEntity.encryptionKeys,
					encryptedSelf = null,
					securityMetadata = clearEntity.securityMetadata,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedForm, DecryptedForm> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return FormEncryptor(
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			openingDate_e = "openingDate" in manifest.fieldsToEncrypt,
			status_e = "status" in manifest.fieldsToEncrypt,
			version_e = "version" in manifest.fieldsToEncrypt,
			descr_e = "descr" in manifest.fieldsToEncrypt,
			uniqueId_e = "uniqueId" in manifest.fieldsToEncrypt,
			formTemplateId_e = "formTemplateId" in manifest.fieldsToEncrypt,
			contactId_e = "contactId" in manifest.fieldsToEncrypt,
			healthElementId_e = "healthElementId" in manifest.fieldsToEncrypt,
			planOfActionId_e = "planOfActionId" in manifest.fieldsToEncrypt,
			parent_e = "parent" in manifest.fieldsToEncrypt,
			anchorId_e = "anchorId" in manifest.fieldsToEncrypt,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class FormEncryptor(
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val openingDate_e: Boolean,
	private val status_e: Boolean,
	private val version_e: Boolean,
	private val descr_e: Boolean,
	private val uniqueId_e: Boolean,
	private val formTemplateId_e: Boolean,
	private val contactId_e: Boolean,
	private val healthElementId_e: Boolean,
	private val planOfActionId_e: Boolean,
	private val parent_e: Boolean,
	private val anchorId_e: Boolean,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedForm, DecryptedForm>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedForm,
	): EncryptedForm {
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
		if (openingDate_e && clearEntity.openingDate != null) {
			dataToEncrypt["openingDate"] =
				encodingJson.encodeToJsonElement(
					clearEntity.openingDate,
				)
		}
		if (status_e && clearEntity.status != null) dataToEncrypt["status"] = encodingJson.encodeToJsonElement(clearEntity.status)
		if (version_e && clearEntity.version != null) dataToEncrypt["version"] = encodingJson.encodeToJsonElement(clearEntity.version)
		if (descr_e && clearEntity.descr != null) dataToEncrypt["descr"] = encodingJson.encodeToJsonElement(clearEntity.descr)
		if (uniqueId_e && clearEntity.uniqueId != null) dataToEncrypt["uniqueId"] = encodingJson.encodeToJsonElement(clearEntity.uniqueId)
		if (formTemplateId_e && clearEntity.formTemplateId != null) {
			dataToEncrypt["formTemplateId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.formTemplateId,
				)
		}
		if (contactId_e && clearEntity.contactId != null) dataToEncrypt["contactId"] = encodingJson.encodeToJsonElement(clearEntity.contactId)
		if (healthElementId_e && clearEntity.healthElementId != null) {
			dataToEncrypt["healthElementId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.healthElementId,
				)
		}
		if (planOfActionId_e && clearEntity.planOfActionId != null) {
			dataToEncrypt["planOfActionId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.planOfActionId,
				)
		}
		if (parent_e && clearEntity.parent != null) dataToEncrypt["parent"] = encodingJson.encodeToJsonElement(clearEntity.parent)
		if (anchorId_e && clearEntity.anchorId != null) dataToEncrypt["anchorId"] = encodingJson.encodeToJsonElement(clearEntity.anchorId)
		return EncryptedForm(
			id = clearEntity.id,
			rev = clearEntity.rev,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			deletionDate = clearEntity.deletionDate,
			openingDate = if (openingDate_e) null else clearEntity.openingDate,
			status = if (status_e) null else clearEntity.status,
			version = if (version_e) null else clearEntity.version,
			descr = if (descr_e) null else clearEntity.descr,
			uniqueId = if (uniqueId_e) null else clearEntity.uniqueId,
			formTemplateId = if (formTemplateId_e) null else clearEntity.formTemplateId,
			contactId = if (contactId_e) null else clearEntity.contactId,
			healthElementId = if (healthElementId_e) null else clearEntity.healthElementId,
			planOfActionId = if (planOfActionId_e) null else clearEntity.planOfActionId,
			parent = if (parent_e) null else clearEntity.parent,
			anchorId = if (anchorId_e) null else clearEntity.anchorId,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
			securityMetadata = clearEntity.securityMetadata,
		)
	}
}

// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.EncryptableFieldConfig
import com.icure.cardinal.sdk.model.embed.DecryptedAnnotation
import com.icure.cardinal.sdk.model.embed.DecryptedContent
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedAnnotation
import com.icure.cardinal.sdk.model.embed.EncryptedContent
import com.icure.cardinal.sdk.model.embed.EncryptedService
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
internal object ServiceEncryptorFactory : EntityEncryptorFactory<EncryptedService, DecryptedService> {
	override val empty: EntityEncryptor<EncryptedService, DecryptedService> =
		ServiceEncryptor(
			transactionId_e = false,
			identifier_e = false,
			subContactIds_e = false,
			plansOfActionIds_e = false,
			healthElementsIds_e = false,
			formIds_e = false,
			label_e = false,
			index_e = false,
			content_e = EncryptableFieldConfig.None(ContentEncryptorFactory),
			textIndexes_e = false,
			valueDate_e = false,
			openingDate_e = false,
			closingDate_e = false,
			created_e = false,
			modified_e = false,
			author_e = false,
			responsible_e = false,
			comment_e = false,
			invoicingCodes_e = false,
			notes_e = EncryptableFieldConfig.None(AnnotationEncryptorFactory),
			qualifiedLinks_e = false,
			codes_e = false,
			tags_e = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedService, DecryptedService> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return ServiceEncryptor(
			transactionId_e = "transactionId" in manifest.fieldsToEncrypt,
			identifier_e = "identifier" in manifest.fieldsToEncrypt,
			subContactIds_e = "subContactIds" in manifest.fieldsToEncrypt,
			plansOfActionIds_e = "plansOfActionIds" in manifest.fieldsToEncrypt,
			healthElementsIds_e = "healthElementsIds" in manifest.fieldsToEncrypt,
			formIds_e = "formIds" in manifest.fieldsToEncrypt,
			label_e = "label" in manifest.fieldsToEncrypt,
			index_e = "index" in manifest.fieldsToEncrypt,
			content_e =
				if ("content" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["content"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedContent::class,
								decryptedClass = DecryptedContent::class,
							),
						)
					} ?: EncryptableFieldConfig.None(ContentEncryptorFactory)
				},
			textIndexes_e = "textIndexes" in manifest.fieldsToEncrypt,
			valueDate_e = "valueDate" in manifest.fieldsToEncrypt,
			openingDate_e = "openingDate" in manifest.fieldsToEncrypt,
			closingDate_e = "closingDate" in manifest.fieldsToEncrypt,
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			comment_e = "comment" in manifest.fieldsToEncrypt,
			invoicingCodes_e = "invoicingCodes" in manifest.fieldsToEncrypt,
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
			qualifiedLinks_e = "qualifiedLinks" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
		)
	}
}

@InternalIcureApi
private class ServiceEncryptor(
	private val transactionId_e: Boolean,
	private val identifier_e: Boolean,
	private val subContactIds_e: Boolean,
	private val plansOfActionIds_e: Boolean,
	private val healthElementsIds_e: Boolean,
	private val formIds_e: Boolean,
	private val label_e: Boolean,
	private val index_e: Boolean,
	private val content_e: EncryptableFieldConfig<EncryptedContent, DecryptedContent>,
	private val textIndexes_e: Boolean,
	private val valueDate_e: Boolean,
	private val openingDate_e: Boolean,
	private val closingDate_e: Boolean,
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val comment_e: Boolean,
	private val invoicingCodes_e: Boolean,
	private val notes_e: EncryptableFieldConfig<EncryptedAnnotation, DecryptedAnnotation>,
	private val qualifiedLinks_e: Boolean,
	private val codes_e: Boolean,
	private val tags_e: Boolean,
) : AbstractEntityEncryptor<EncryptedService, DecryptedService>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedService,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedService {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (transactionId_e && clearEntity.transactionId != null) {
			dataToEncrypt["transactionId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.transactionId,
				)
		}
		if (identifier_e && clearEntity.identifier.isNotEmpty()) {
			dataToEncrypt["identifier"] =
				encodingJson.encodeToJsonElement(
					clearEntity.identifier,
				)
		}
		if (subContactIds_e && clearEntity.subContactIds != null) {
			dataToEncrypt["subContactIds"] =
				encodingJson.encodeToJsonElement(
					clearEntity.subContactIds,
				)
		}
		if (plansOfActionIds_e && clearEntity.plansOfActionIds != null) {
			dataToEncrypt["plansOfActionIds"] =
				encodingJson.encodeToJsonElement(
					clearEntity.plansOfActionIds,
				)
		}
		if (healthElementsIds_e && clearEntity.healthElementsIds != null) {
			dataToEncrypt["healthElementsIds"] =
				encodingJson.encodeToJsonElement(
					clearEntity.healthElementsIds,
				)
		}
		if (formIds_e && clearEntity.formIds != null) dataToEncrypt["formIds"] = encodingJson.encodeToJsonElement(clearEntity.formIds)
		if (label_e && clearEntity.label != null) dataToEncrypt["label"] = encodingJson.encodeToJsonElement(clearEntity.label)
		if (index_e && clearEntity.index != null) dataToEncrypt["index"] = encodingJson.encodeToJsonElement(clearEntity.index)
		if (content_e.fullEncryption && clearEntity.content.isNotEmpty()) {
			dataToEncrypt["content"] =
				encodingJson.encodeToJsonElement(
					clearEntity.content,
				)
		}
		if (textIndexes_e && clearEntity.textIndexes.isNotEmpty()) {
			dataToEncrypt["textIndexes"] =
				encodingJson.encodeToJsonElement(
					clearEntity.textIndexes,
				)
		}
		if (valueDate_e && clearEntity.valueDate != null) dataToEncrypt["valueDate"] = encodingJson.encodeToJsonElement(clearEntity.valueDate)
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
		if (created_e && clearEntity.created != null) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified_e && clearEntity.modified != null) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author_e && clearEntity.author != null) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible_e && clearEntity.responsible != null) {
			dataToEncrypt["responsible"] =
				encodingJson.encodeToJsonElement(
					clearEntity.responsible,
				)
		}
		if (comment_e && clearEntity.comment != null) dataToEncrypt["comment"] = encodingJson.encodeToJsonElement(clearEntity.comment)
		if (invoicingCodes_e && clearEntity.invoicingCodes.isNotEmpty()) {
			dataToEncrypt["invoicingCodes"] =
				encodingJson.encodeToJsonElement(
					clearEntity.invoicingCodes,
				)
		}
		if (notes_e.fullEncryption && clearEntity.notes.isNotEmpty()) dataToEncrypt["notes"] = encodingJson.encodeToJsonElement(clearEntity.notes)
		if (qualifiedLinks_e && clearEntity.qualifiedLinks.isNotEmpty()) {
			dataToEncrypt["qualifiedLinks"] =
				encodingJson.encodeToJsonElement(
					clearEntity.qualifiedLinks,
				)
		}
		if (codes_e && clearEntity.codes.isNotEmpty()) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (tags_e && clearEntity.tags.isNotEmpty()) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		return EncryptedService(
			id = clearEntity.id,
			transactionId = if (transactionId_e) null else clearEntity.transactionId,
			identifier = if (identifier_e) emptyList() else clearEntity.identifier,
			contactId = clearEntity.contactId,
			subContactIds = if (subContactIds_e) null else clearEntity.subContactIds,
			plansOfActionIds = if (plansOfActionIds_e) null else clearEntity.plansOfActionIds,
			healthElementsIds = if (healthElementsIds_e) null else clearEntity.healthElementsIds,
			formIds = if (formIds_e) null else clearEntity.formIds,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			label = if (label_e) null else clearEntity.label,
			index = if (index_e) null else clearEntity.index,
			content =
				content_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyMap()
					} else {
						clearEntity.content.mapValues { (_, x0) ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			textIndexes = if (textIndexes_e) emptyMap() else clearEntity.textIndexes,
			valueDate = if (valueDate_e) null else clearEntity.valueDate,
			openingDate = if (openingDate_e) null else clearEntity.openingDate,
			closingDate = if (closingDate_e) null else clearEntity.closingDate,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			endOfLife = clearEntity.endOfLife,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			comment = if (comment_e) null else clearEntity.comment,
			invoicingCodes = if (invoicingCodes_e) emptySet() else clearEntity.invoicingCodes,
			notes =
				notes_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.notes.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			qualifiedLinks = if (qualifiedLinks_e) emptyMap() else clearEntity.qualifiedLinks,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			securityMetadata = clearEntity.securityMetadata,
			extensions = clearEntity.extensions,
			contactExtensionsVersions = clearEntity.contactExtensionsVersions,
		)
	}
}

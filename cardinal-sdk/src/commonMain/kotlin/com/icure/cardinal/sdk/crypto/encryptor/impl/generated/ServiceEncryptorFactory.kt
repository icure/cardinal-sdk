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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object ServiceEncryptorFactory : EntityEncryptorFactory<EncryptedService, DecryptedService> {
	override val empty: EntityEncryptor<EncryptedService, DecryptedService> =
		ServiceEncryptor(
			transactionId = false,
			identifier = false,
			subContactIds = false,
			plansOfActionIds = false,
			healthElementsIds = false,
			formIds = false,
			label = false,
			index = false,
			content = EncryptableFieldConfig.None(ContentEncryptorFactory),
			textIndexes = false,
			valueDate = false,
			openingDate = false,
			closingDate = false,
			created = false,
			modified = false,
			author = false,
			responsible = false,
			comment = false,
			invoicingCodes = false,
			notes = EncryptableFieldConfig.None(AnnotationEncryptorFactory),
			qualifiedLinks = false,
			codes = false,
			tags = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedService, DecryptedService> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return ServiceEncryptor(
			transactionId = "transactionId" in manifest.fieldsToEncrypt,
			identifier = "identifier" in manifest.fieldsToEncrypt,
			subContactIds = "subContactIds" in manifest.fieldsToEncrypt,
			plansOfActionIds = "plansOfActionIds" in manifest.fieldsToEncrypt,
			healthElementsIds = "healthElementsIds" in manifest.fieldsToEncrypt,
			formIds = "formIds" in manifest.fieldsToEncrypt,
			label = "label" in manifest.fieldsToEncrypt,
			index = "index" in manifest.fieldsToEncrypt,
			content =
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
			textIndexes = "textIndexes" in manifest.fieldsToEncrypt,
			valueDate = "valueDate" in manifest.fieldsToEncrypt,
			openingDate = "openingDate" in manifest.fieldsToEncrypt,
			closingDate = "closingDate" in manifest.fieldsToEncrypt,
			created = "created" in manifest.fieldsToEncrypt,
			modified = "modified" in manifest.fieldsToEncrypt,
			author = "author" in manifest.fieldsToEncrypt,
			responsible = "responsible" in manifest.fieldsToEncrypt,
			comment = "comment" in manifest.fieldsToEncrypt,
			invoicingCodes = "invoicingCodes" in manifest.fieldsToEncrypt,
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
			qualifiedLinks = "qualifiedLinks" in manifest.fieldsToEncrypt,
			codes = "codes" in manifest.fieldsToEncrypt,
			tags = "tags" in manifest.fieldsToEncrypt,
		)
	}
}

private class ServiceEncryptor(
	private val transactionId: Boolean,
	private val identifier: Boolean,
	private val subContactIds: Boolean,
	private val plansOfActionIds: Boolean,
	private val healthElementsIds: Boolean,
	private val formIds: Boolean,
	private val label: Boolean,
	private val index: Boolean,
	private val content: EncryptableFieldConfig<EncryptedContent, DecryptedContent>,
	private val textIndexes: Boolean,
	private val valueDate: Boolean,
	private val openingDate: Boolean,
	private val closingDate: Boolean,
	private val created: Boolean,
	private val modified: Boolean,
	private val author: Boolean,
	private val responsible: Boolean,
	private val comment: Boolean,
	private val invoicingCodes: Boolean,
	private val notes: EncryptableFieldConfig<EncryptedAnnotation, DecryptedAnnotation>,
	private val qualifiedLinks: Boolean,
	private val codes: Boolean,
	private val tags: Boolean,
) : AbstractEntityEncryptor<EncryptedService, DecryptedService>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedService,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedService {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (transactionId) dataToEncrypt["transactionId"] = encodingJson.encodeToJsonElement(clearEntity.transactionId)
		if (identifier) dataToEncrypt["identifier"] = encodingJson.encodeToJsonElement(clearEntity.identifier)
		if (subContactIds) dataToEncrypt["subContactIds"] = encodingJson.encodeToJsonElement(clearEntity.subContactIds)
		if (plansOfActionIds) dataToEncrypt["plansOfActionIds"] = encodingJson.encodeToJsonElement(clearEntity.plansOfActionIds)
		if (healthElementsIds) dataToEncrypt["healthElementsIds"] = encodingJson.encodeToJsonElement(clearEntity.healthElementsIds)
		if (formIds) dataToEncrypt["formIds"] = encodingJson.encodeToJsonElement(clearEntity.formIds)
		if (label) dataToEncrypt["label"] = encodingJson.encodeToJsonElement(clearEntity.label)
		if (index) dataToEncrypt["index"] = encodingJson.encodeToJsonElement(clearEntity.index)
		if (content.fullEncryption) dataToEncrypt["content"] = encodingJson.encodeToJsonElement(clearEntity.content)
		if (textIndexes) dataToEncrypt["textIndexes"] = encodingJson.encodeToJsonElement(clearEntity.textIndexes)
		if (valueDate) dataToEncrypt["valueDate"] = encodingJson.encodeToJsonElement(clearEntity.valueDate)
		if (openingDate) dataToEncrypt["openingDate"] = encodingJson.encodeToJsonElement(clearEntity.openingDate)
		if (closingDate) dataToEncrypt["closingDate"] = encodingJson.encodeToJsonElement(clearEntity.closingDate)
		if (created) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible) dataToEncrypt["responsible"] = encodingJson.encodeToJsonElement(clearEntity.responsible)
		if (comment) dataToEncrypt["comment"] = encodingJson.encodeToJsonElement(clearEntity.comment)
		if (invoicingCodes) dataToEncrypt["invoicingCodes"] = encodingJson.encodeToJsonElement(clearEntity.invoicingCodes)
		if (notes.fullEncryption) dataToEncrypt["notes"] = encodingJson.encodeToJsonElement(clearEntity.notes)
		if (qualifiedLinks) dataToEncrypt["qualifiedLinks"] = encodingJson.encodeToJsonElement(clearEntity.qualifiedLinks)
		if (codes) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (tags) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		return EncryptedService(
			id = clearEntity.id,
			transactionId = if (transactionId) null else clearEntity.transactionId,
			identifier = if (identifier) emptyList() else clearEntity.identifier,
			contactId = clearEntity.contactId,
			subContactIds = if (subContactIds) null else clearEntity.subContactIds,
			plansOfActionIds = if (plansOfActionIds) null else clearEntity.plansOfActionIds,
			healthElementsIds = if (healthElementsIds) null else clearEntity.healthElementsIds,
			formIds = if (formIds) null else clearEntity.formIds,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			label = if (label) null else clearEntity.label,
			index = if (index) null else clearEntity.index,
			content =
				content.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyMap()
					} else {
						clearEntity.content.mapValues { (_, x0) ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			textIndexes = if (textIndexes) emptyMap() else clearEntity.textIndexes,
			valueDate = if (valueDate) null else clearEntity.valueDate,
			openingDate = if (openingDate) null else clearEntity.openingDate,
			closingDate = if (closingDate) null else clearEntity.closingDate,
			created = if (created) null else clearEntity.created,
			modified = if (modified) null else clearEntity.modified,
			endOfLife = clearEntity.endOfLife,
			author = if (author) null else clearEntity.author,
			responsible = if (responsible) null else clearEntity.responsible,
			comment = if (comment) null else clearEntity.comment,
			invoicingCodes = if (invoicingCodes) emptySet() else clearEntity.invoicingCodes,
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
			qualifiedLinks = if (qualifiedLinks) emptyMap() else clearEntity.qualifiedLinks,
			codes = if (codes) emptySet() else clearEntity.codes,
			tags = if (tags) emptySet() else clearEntity.tags,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			securityMetadata = clearEntity.securityMetadata,
			extensions = clearEntity.extensions,
			contactExtensionsVersions = clearEntity.contactExtensionsVersions,
		)
	}
}

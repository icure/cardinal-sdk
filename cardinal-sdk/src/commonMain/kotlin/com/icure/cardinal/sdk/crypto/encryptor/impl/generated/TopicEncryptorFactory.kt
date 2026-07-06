// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.DecryptedTopic
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object TopicEncryptorFactory : EntityEncryptorFactory<EncryptedTopic, DecryptedTopic> {
	override val empty: EntityEncryptor<EncryptedTopic, DecryptedTopic> =
		TopicEncryptor(
			created = false,
			modified = false,
			healthElementId = false,
			contactId = false,
			description = false,
			codes = false,
			tags = false,
			author = false,
			responsible = false,
			linkedHealthElements = false,
			linkedServices = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedTopic, DecryptedTopic> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return TopicEncryptor(
			created = "created" in manifest.fieldsToEncrypt,
			modified = "modified" in manifest.fieldsToEncrypt,
			healthElementId = "healthElementId" in manifest.fieldsToEncrypt,
			contactId = "contactId" in manifest.fieldsToEncrypt,
			description = "description" in manifest.fieldsToEncrypt,
			codes = "codes" in manifest.fieldsToEncrypt,
			tags = "tags" in manifest.fieldsToEncrypt,
			author = "author" in manifest.fieldsToEncrypt,
			responsible = "responsible" in manifest.fieldsToEncrypt,
			linkedHealthElements = "linkedHealthElements" in manifest.fieldsToEncrypt,
			linkedServices = "linkedServices" in manifest.fieldsToEncrypt,
		)
	}
}

private class TopicEncryptor(
	private val created: Boolean,
	private val modified: Boolean,
	private val healthElementId: Boolean,
	private val contactId: Boolean,
	private val description: Boolean,
	private val codes: Boolean,
	private val tags: Boolean,
	private val author: Boolean,
	private val responsible: Boolean,
	private val linkedHealthElements: Boolean,
	private val linkedServices: Boolean,
) : AbstractEntityEncryptor<EncryptedTopic, DecryptedTopic>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedTopic,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedTopic {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (created) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (healthElementId) dataToEncrypt["healthElementId"] = encodingJson.encodeToJsonElement(clearEntity.healthElementId)
		if (contactId) dataToEncrypt["contactId"] = encodingJson.encodeToJsonElement(clearEntity.contactId)
		if (description) dataToEncrypt["description"] = encodingJson.encodeToJsonElement(clearEntity.description)
		if (codes) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (tags) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (author) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible) dataToEncrypt["responsible"] = encodingJson.encodeToJsonElement(clearEntity.responsible)
		if (linkedHealthElements) dataToEncrypt["linkedHealthElements"] = encodingJson.encodeToJsonElement(clearEntity.linkedHealthElements)
		if (linkedServices) dataToEncrypt["linkedServices"] = encodingJson.encodeToJsonElement(clearEntity.linkedServices)
		return EncryptedTopic(
			id = clearEntity.id,
			rev = clearEntity.rev,
			created = if (created) null else clearEntity.created,
			modified = if (modified) null else clearEntity.modified,
			healthElementId = if (healthElementId) null else clearEntity.healthElementId,
			contactId = if (contactId) null else clearEntity.contactId,
			description = if (description) null else clearEntity.description,
			codes = if (codes) emptySet() else clearEntity.codes,
			tags = if (tags) emptySet() else clearEntity.tags,
			author = if (author) null else clearEntity.author,
			responsible = if (responsible) null else clearEntity.responsible,
			deletionDate = clearEntity.deletionDate,
			activeParticipants = clearEntity.activeParticipants,
			securityMetadata = clearEntity.securityMetadata,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			linkedHealthElements = if (linkedHealthElements) emptySet() else clearEntity.linkedHealthElements,
			linkedServices = if (linkedServices) emptySet() else clearEntity.linkedServices,
			extensions = clearEntity.extensions,
			extensionsVersion = clearEntity.extensionsVersion,
		)
	}
}

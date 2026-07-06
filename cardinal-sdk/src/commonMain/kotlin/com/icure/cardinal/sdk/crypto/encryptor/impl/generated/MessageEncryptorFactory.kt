// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.EncryptableFieldConfig
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object MessageEncryptorFactory : EntityEncryptorFactory<EncryptedMessage, DecryptedMessage> {
	override val empty: EntityEncryptor<EncryptedMessage, DecryptedMessage> =
		MessageEncryptor(
			created = false,
			modified = false,
			author = false,
			responsible = false,
			tags = false,
			codes = false,
			fromAddress = false,
			fromHealthcarePartyId = false,
			recipients = false,
			toAddresses = false,
			received = false,
			sent = false,
			metas = false,
			readStatus = false,
			transportGuid = false,
			remark = false,
			conversationGuid = false,
			subject = false,
			invoiceIds = false,
			parentId = false,
			properties = EncryptableFieldConfig.None(PropertyStubEncryptorFactory),
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedMessage, DecryptedMessage> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return MessageEncryptor(
			created = "created" in manifest.fieldsToEncrypt,
			modified = "modified" in manifest.fieldsToEncrypt,
			author = "author" in manifest.fieldsToEncrypt,
			responsible = "responsible" in manifest.fieldsToEncrypt,
			tags = "tags" in manifest.fieldsToEncrypt,
			codes = "codes" in manifest.fieldsToEncrypt,
			fromAddress = "fromAddress" in manifest.fieldsToEncrypt,
			fromHealthcarePartyId = "fromHealthcarePartyId" in manifest.fieldsToEncrypt,
			recipients = "recipients" in manifest.fieldsToEncrypt,
			toAddresses = "toAddresses" in manifest.fieldsToEncrypt,
			received = "received" in manifest.fieldsToEncrypt,
			sent = "sent" in manifest.fieldsToEncrypt,
			metas = "metas" in manifest.fieldsToEncrypt,
			readStatus = "readStatus" in manifest.fieldsToEncrypt,
			transportGuid = "transportGuid" in manifest.fieldsToEncrypt,
			remark = "remark" in manifest.fieldsToEncrypt,
			conversationGuid = "conversationGuid" in manifest.fieldsToEncrypt,
			subject = "subject" in manifest.fieldsToEncrypt,
			invoiceIds = "invoiceIds" in manifest.fieldsToEncrypt,
			parentId = "parentId" in manifest.fieldsToEncrypt,
			properties =
				if ("properties" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["properties"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedPropertyStub::class,
								decryptedClass = DecryptedPropertyStub::class,
							),
						)
					} ?: EncryptableFieldConfig.None(PropertyStubEncryptorFactory)
				},
		)
	}
}

private class MessageEncryptor(
	private val created: Boolean,
	private val modified: Boolean,
	private val author: Boolean,
	private val responsible: Boolean,
	private val tags: Boolean,
	private val codes: Boolean,
	private val fromAddress: Boolean,
	private val fromHealthcarePartyId: Boolean,
	private val recipients: Boolean,
	private val toAddresses: Boolean,
	private val received: Boolean,
	private val sent: Boolean,
	private val metas: Boolean,
	private val readStatus: Boolean,
	private val transportGuid: Boolean,
	private val remark: Boolean,
	private val conversationGuid: Boolean,
	private val subject: Boolean,
	private val invoiceIds: Boolean,
	private val parentId: Boolean,
	private val properties: EncryptableFieldConfig<EncryptedPropertyStub, DecryptedPropertyStub>,
) : AbstractEntityEncryptor<EncryptedMessage, DecryptedMessage>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedMessage,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedMessage {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (created) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible) dataToEncrypt["responsible"] = encodingJson.encodeToJsonElement(clearEntity.responsible)
		if (tags) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (fromAddress) dataToEncrypt["fromAddress"] = encodingJson.encodeToJsonElement(clearEntity.fromAddress)
		if (fromHealthcarePartyId) dataToEncrypt["fromHealthcarePartyId"] = encodingJson.encodeToJsonElement(clearEntity.fromHealthcarePartyId)
		if (recipients) dataToEncrypt["recipients"] = encodingJson.encodeToJsonElement(clearEntity.recipients)
		if (toAddresses) dataToEncrypt["toAddresses"] = encodingJson.encodeToJsonElement(clearEntity.toAddresses)
		if (received) dataToEncrypt["received"] = encodingJson.encodeToJsonElement(clearEntity.received)
		if (sent) dataToEncrypt["sent"] = encodingJson.encodeToJsonElement(clearEntity.sent)
		if (metas) dataToEncrypt["metas"] = encodingJson.encodeToJsonElement(clearEntity.metas)
		if (readStatus) dataToEncrypt["readStatus"] = encodingJson.encodeToJsonElement(clearEntity.readStatus)
		if (transportGuid) dataToEncrypt["transportGuid"] = encodingJson.encodeToJsonElement(clearEntity.transportGuid)
		if (remark) dataToEncrypt["remark"] = encodingJson.encodeToJsonElement(clearEntity.remark)
		if (conversationGuid) dataToEncrypt["conversationGuid"] = encodingJson.encodeToJsonElement(clearEntity.conversationGuid)
		if (subject) dataToEncrypt["subject"] = encodingJson.encodeToJsonElement(clearEntity.subject)
		if (invoiceIds) dataToEncrypt["invoiceIds"] = encodingJson.encodeToJsonElement(clearEntity.invoiceIds)
		if (parentId) dataToEncrypt["parentId"] = encodingJson.encodeToJsonElement(clearEntity.parentId)
		if (properties.fullEncryption) dataToEncrypt["properties"] = encodingJson.encodeToJsonElement(clearEntity.properties)
		return EncryptedMessage(
			id = clearEntity.id,
			rev = clearEntity.rev,
			created = if (created) null else clearEntity.created,
			modified = if (modified) null else clearEntity.modified,
			author = if (author) null else clearEntity.author,
			responsible = if (responsible) null else clearEntity.responsible,
			tags = if (tags) emptySet() else clearEntity.tags,
			codes = if (codes) emptySet() else clearEntity.codes,
			deletionDate = clearEntity.deletionDate,
			fromAddress = if (fromAddress) null else clearEntity.fromAddress,
			fromHealthcarePartyId = if (fromHealthcarePartyId) null else clearEntity.fromHealthcarePartyId,
			recipients = if (recipients) emptySet() else clearEntity.recipients,
			toAddresses = if (toAddresses) emptySet() else clearEntity.toAddresses,
			received = if (received) null else clearEntity.received,
			sent = if (sent) null else clearEntity.sent,
			metas = if (metas) emptyMap() else clearEntity.metas,
			readStatus = if (readStatus) emptyMap() else clearEntity.readStatus,
			transportGuid = if (transportGuid) null else clearEntity.transportGuid,
			remark = if (remark) null else clearEntity.remark,
			conversationGuid = if (conversationGuid) null else clearEntity.conversationGuid,
			subject = if (subject) null else clearEntity.subject,
			invoiceIds = if (invoiceIds) emptySet() else clearEntity.invoiceIds,
			parentId = if (parentId) null else clearEntity.parentId,
			properties =
				properties.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptySet()
					} else {
						clearEntity.properties.mapTo(mutableSetOf()) { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			securityMetadata = clearEntity.securityMetadata,
			extensions = clearEntity.extensions,
			extensionsVersion = clearEntity.extensionsVersion,
		)
	}
}

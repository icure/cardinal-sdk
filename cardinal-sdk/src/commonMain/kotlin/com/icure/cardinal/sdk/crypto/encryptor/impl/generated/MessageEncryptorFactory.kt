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
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

@InternalIcureApi
internal object MessageEncryptorFactory : EntityEncryptorFactory<EncryptedMessage, DecryptedMessage> {
	override val empty: EntityEncryptor<EncryptedMessage, DecryptedMessage> =
		MessageEncryptor(
			created_e = false,
			modified_e = false,
			author_e = false,
			responsible_e = false,
			tags_e = false,
			codes_e = false,
			fromAddress_e = false,
			fromHealthcarePartyId_e = false,
			recipients_e = false,
			toAddresses_e = false,
			received_e = false,
			sent_e = false,
			metas_e = false,
			readStatus_e = false,
			transportGuid_e = false,
			remark_e = false,
			conversationGuid_e = false,
			subject_e = false,
			invoiceIds_e = false,
			parentId_e = false,
			properties_e = EncryptableFieldConfig.None(PropertyStubEncryptorFactory),
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedMessage, DecryptedMessage> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return MessageEncryptor(
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			fromAddress_e = "fromAddress" in manifest.fieldsToEncrypt,
			fromHealthcarePartyId_e = "fromHealthcarePartyId" in manifest.fieldsToEncrypt,
			recipients_e = "recipients" in manifest.fieldsToEncrypt,
			toAddresses_e = "toAddresses" in manifest.fieldsToEncrypt,
			received_e = "received" in manifest.fieldsToEncrypt,
			sent_e = "sent" in manifest.fieldsToEncrypt,
			metas_e = "metas" in manifest.fieldsToEncrypt,
			readStatus_e = "readStatus" in manifest.fieldsToEncrypt,
			transportGuid_e = "transportGuid" in manifest.fieldsToEncrypt,
			remark_e = "remark" in manifest.fieldsToEncrypt,
			conversationGuid_e = "conversationGuid" in manifest.fieldsToEncrypt,
			subject_e = "subject" in manifest.fieldsToEncrypt,
			invoiceIds_e = "invoiceIds" in manifest.fieldsToEncrypt,
			parentId_e = "parentId" in manifest.fieldsToEncrypt,
			properties_e =
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

@InternalIcureApi
private class MessageEncryptor(
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val fromAddress_e: Boolean,
	private val fromHealthcarePartyId_e: Boolean,
	private val recipients_e: Boolean,
	private val toAddresses_e: Boolean,
	private val received_e: Boolean,
	private val sent_e: Boolean,
	private val metas_e: Boolean,
	private val readStatus_e: Boolean,
	private val transportGuid_e: Boolean,
	private val remark_e: Boolean,
	private val conversationGuid_e: Boolean,
	private val subject_e: Boolean,
	private val invoiceIds_e: Boolean,
	private val parentId_e: Boolean,
	private val properties_e: EncryptableFieldConfig<EncryptedPropertyStub, DecryptedPropertyStub>,
) : AbstractEntityEncryptor<EncryptedMessage, DecryptedMessage>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedMessage,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedMessage {
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
		if (fromAddress_e && clearEntity.fromAddress != null) {
			dataToEncrypt["fromAddress"] =
				encodingJson.encodeToJsonElement(
					clearEntity.fromAddress,
				)
		}
		if (fromHealthcarePartyId_e && clearEntity.fromHealthcarePartyId != null) {
			dataToEncrypt["fromHealthcarePartyId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.fromHealthcarePartyId,
				)
		}
		if (recipients_e && clearEntity.recipients.isNotEmpty()) {
			dataToEncrypt["recipients"] =
				encodingJson.encodeToJsonElement(
					clearEntity.recipients,
				)
		}
		if (toAddresses_e && clearEntity.toAddresses.isNotEmpty()) {
			dataToEncrypt["toAddresses"] =
				encodingJson.encodeToJsonElement(
					clearEntity.toAddresses,
				)
		}
		if (received_e && clearEntity.received != null) dataToEncrypt["received"] = encodingJson.encodeToJsonElement(clearEntity.received)
		if (sent_e && clearEntity.sent != null) dataToEncrypt["sent"] = encodingJson.encodeToJsonElement(clearEntity.sent)
		if (metas_e && clearEntity.metas.isNotEmpty()) dataToEncrypt["metas"] = encodingJson.encodeToJsonElement(clearEntity.metas)
		if (readStatus_e && clearEntity.readStatus.isNotEmpty()) {
			dataToEncrypt["readStatus"] =
				encodingJson.encodeToJsonElement(
					clearEntity.readStatus,
				)
		}
		if (transportGuid_e && clearEntity.transportGuid != null) {
			dataToEncrypt["transportGuid"] =
				encodingJson.encodeToJsonElement(
					clearEntity.transportGuid,
				)
		}
		if (remark_e && clearEntity.remark != null) dataToEncrypt["remark"] = encodingJson.encodeToJsonElement(clearEntity.remark)
		if (conversationGuid_e && clearEntity.conversationGuid != null) {
			dataToEncrypt["conversationGuid"] =
				encodingJson.encodeToJsonElement(
					clearEntity.conversationGuid,
				)
		}
		if (subject_e && clearEntity.subject != null) dataToEncrypt["subject"] = encodingJson.encodeToJsonElement(clearEntity.subject)
		if (invoiceIds_e && clearEntity.invoiceIds.isNotEmpty()) {
			dataToEncrypt["invoiceIds"] =
				encodingJson.encodeToJsonElement(
					clearEntity.invoiceIds,
				)
		}
		if (parentId_e && clearEntity.parentId != null) dataToEncrypt["parentId"] = encodingJson.encodeToJsonElement(clearEntity.parentId)
		if (properties_e.fullEncryption && clearEntity.properties.isNotEmpty()) {
			dataToEncrypt["properties"] =
				encodingJson.encodeToJsonElement(
					clearEntity.properties,
				)
		}
		return EncryptedMessage(
			id = clearEntity.id,
			rev = clearEntity.rev,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			deletionDate = clearEntity.deletionDate,
			fromAddress = if (fromAddress_e) null else clearEntity.fromAddress,
			fromHealthcarePartyId = if (fromHealthcarePartyId_e) null else clearEntity.fromHealthcarePartyId,
			recipients = if (recipients_e) emptySet() else clearEntity.recipients,
			toAddresses = if (toAddresses_e) emptySet() else clearEntity.toAddresses,
			received = if (received_e) null else clearEntity.received,
			sent = if (sent_e) null else clearEntity.sent,
			metas = if (metas_e) emptyMap() else clearEntity.metas,
			readStatus = if (readStatus_e) emptyMap() else clearEntity.readStatus,
			transportGuid = if (transportGuid_e) null else clearEntity.transportGuid,
			remark = if (remark_e) null else clearEntity.remark,
			conversationGuid = if (conversationGuid_e) null else clearEntity.conversationGuid,
			subject = if (subject_e) null else clearEntity.subject,
			invoiceIds = if (invoiceIds_e) emptySet() else clearEntity.invoiceIds,
			parentId = if (parentId_e) null else clearEntity.parentId,
			properties =
				properties_e.encryptor.let { encryptor ->
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

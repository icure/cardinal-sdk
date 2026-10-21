// This file is auto-generated
@file:Suppress("ktlint:standard:max-line-length")

package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.encryptExtension
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.DecryptedCustomEntityBase
import com.icure.cardinal.sdk.model.EncryptedCustomEntityBase
import com.icure.cardinal.sdk.utils.ensure
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
internal object CustomEntityBaseEncryptorFactory : EntityEncryptorFactory<EncryptedCustomEntityBase, DecryptedCustomEntityBase> {
	override val empty: EntityEncryptor<EncryptedCustomEntityBase, DecryptedCustomEntityBase> =
		object : EntityEncryptor<EncryptedCustomEntityBase, DecryptedCustomEntityBase> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedCustomEntityBase,
			): EncryptedCustomEntityBase =
				EncryptedCustomEntityBase(
					id = clearEntity.id,
					rev = clearEntity.rev,
					deletionDate = clearEntity.deletionDate,
					secretForeignKeys = clearEntity.secretForeignKeys,
					cryptedForeignKeys = clearEntity.cryptedForeignKeys,
					delegations = clearEntity.delegations,
					encryptionKeys = clearEntity.encryptionKeys,
					securityMetadata = clearEntity.securityMetadata,
					created = clearEntity.created,
					modified = clearEntity.modified,
					author = clearEntity.author,
					responsible = clearEntity.responsible,
					endOfLife = clearEntity.endOfLife,
					tags = clearEntity.tags,
					codes = clearEntity.codes,
					customisedModelVersion = clearEntity.customisedModelVersion,
					extensions = clearEntity.extensions,
					dataAttachments = clearEntity.dataAttachments,
					deletedAttachments = clearEntity.deletedAttachments,
					encryptedSelf = null,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedCustomEntityBase, DecryptedCustomEntityBase> {
		val manifest = encryptorsFactoryContext.getManifest(entityManifestName)
		val extensionsEncryptor =
			manifest.currentExtensionsManifest?.let {
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = it,
					encryptedClass = EncryptedCustomEntityBase::class,
					decryptedClass = DecryptedCustomEntityBase::class,
				)
			}
		return CustomEntityBaseEncryptor(
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			endOfLife_e = "endOfLife" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			extensionsEncryptor = extensionsEncryptor,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class CustomEntityBaseEncryptor(
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val endOfLife_e: Boolean,
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val extensionsEncryptor: Lazy<ExtensionsEncryptors>?,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedCustomEntityBase, DecryptedCustomEntityBase>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedCustomEntityBase,
	): EncryptedCustomEntityBase {
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
		if (endOfLife_e && clearEntity.endOfLife != null) dataToEncrypt["endOfLife"] = encodingJson.encodeToJsonElement(clearEntity.endOfLife)
		if (tags_e && clearEntity.tags.isNotEmpty()) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes_e && clearEntity.codes.isNotEmpty()) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		ensure(getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)) == null) {
			"CustomEntityBase can't have an encrypted self, but there is data to encrypt"
		}
		return EncryptedCustomEntityBase(
			id = clearEntity.id,
			rev = clearEntity.rev,
			deletionDate = clearEntity.deletionDate,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			securityMetadata = clearEntity.securityMetadata,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			endOfLife = if (endOfLife_e) null else clearEntity.endOfLife,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			customisedModelVersion = clearEntity.customisedModelVersion,
			extensions = extensionsEncryptor?.value?.encryptExtension(encryptionKey, clearEntity.extensions) ?: clearEntity.extensions,
			dataAttachments = clearEntity.dataAttachments,
			deletedAttachments = clearEntity.deletedAttachments,
			encryptedSelf = null,
		)
	}
}

// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.DecryptedArticle
import com.icure.cardinal.sdk.model.EncryptedArticle
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
internal object ArticleEncryptorFactory : EntityEncryptorFactory<EncryptedArticle, DecryptedArticle> {
	override val empty: EntityEncryptor<EncryptedArticle, DecryptedArticle> =
		ArticleEncryptor(
			created_e = false,
			modified_e = false,
			author_e = false,
			responsible_e = false,
			tags_e = false,
			codes_e = false,
			name_e = false,
			classification_e = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedArticle, DecryptedArticle> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return ArticleEncryptor(
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			name_e = "name" in manifest.fieldsToEncrypt,
			classification_e = "classification" in manifest.fieldsToEncrypt,
		)
	}
}

@InternalIcureApi
private class ArticleEncryptor(
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val name_e: Boolean,
	private val classification_e: Boolean,
) : AbstractEntityEncryptor<EncryptedArticle, DecryptedArticle>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedArticle,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedArticle {
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
		if (name_e && clearEntity.name != null) dataToEncrypt["name"] = encodingJson.encodeToJsonElement(clearEntity.name)
		if (classification_e && clearEntity.classification != null) {
			dataToEncrypt["classification"] =
				encodingJson.encodeToJsonElement(
					clearEntity.classification,
				)
		}
		return EncryptedArticle(
			id = clearEntity.id,
			rev = clearEntity.rev,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			endOfLife = clearEntity.endOfLife,
			deletionDate = clearEntity.deletionDate,
			name = if (name_e) null else clearEntity.name,
			classification = if (classification_e) null else clearEntity.classification,
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			securityMetadata = clearEntity.securityMetadata,
		)
	}
}

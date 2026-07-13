// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedAnnotation
import com.icure.cardinal.sdk.model.embed.EncryptedAnnotation
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
internal object AnnotationEncryptorFactory :
	EntityEncryptorFactory<EncryptedAnnotation, DecryptedAnnotation> {
	override val empty: EntityEncryptor<EncryptedAnnotation, DecryptedAnnotation> =
		object :
			EntityEncryptor<EncryptedAnnotation, DecryptedAnnotation> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedAnnotation,
			): EncryptedAnnotation =
				EncryptedAnnotation(
					id = clearEntity.id,
					author = clearEntity.author,
					created = clearEntity.created,
					modified = clearEntity.modified,
					text = clearEntity.text,
					markdown = clearEntity.markdown,
					location = clearEntity.location,
					confidential = clearEntity.confidential,
					tags = clearEntity.tags,
					encryptedSelf = null,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedAnnotation, DecryptedAnnotation> {
		val manifest = encryptorsFactoryContext.getManifest(entityManifestName)
		require(manifest.currentExtensionsManifest == null) {
			"Annotation is not Extendable and does not support extensions encryption, but its manifest defines a currentExtensionsManifest."
		}
		return AnnotationEncryptor(
			author_e = "author" in manifest.fieldsToEncrypt,
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			text_e = "text" in manifest.fieldsToEncrypt,
			markdown_e = "markdown" in manifest.fieldsToEncrypt,
			location_e = "location" in manifest.fieldsToEncrypt,
			confidential_e = "confidential" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class AnnotationEncryptor(
	private val author_e: Boolean,
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val text_e: Boolean,
	private val markdown_e: Boolean,
	private val location_e: Boolean,
	private val confidential_e: Boolean,
	private val tags_e: Boolean,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedAnnotation, DecryptedAnnotation>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedAnnotation,
	): EncryptedAnnotation {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (author_e && clearEntity.author != null) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (created_e && clearEntity.created != null) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified_e && clearEntity.modified != null) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (text_e && clearEntity.text != null) dataToEncrypt["text"] = encodingJson.encodeToJsonElement(clearEntity.text)
		if (markdown_e && clearEntity.markdown.isNotEmpty()) dataToEncrypt["markdown"] = encodingJson.encodeToJsonElement(clearEntity.markdown)
		if (location_e && clearEntity.location != null) dataToEncrypt["location"] = encodingJson.encodeToJsonElement(clearEntity.location)
		if (confidential_e && clearEntity.confidential != null) {
			dataToEncrypt["confidential"] =
				encodingJson.encodeToJsonElement(
					clearEntity.confidential,
				)
		}
		if (tags_e && clearEntity.tags.isNotEmpty()) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		return EncryptedAnnotation(
			id = clearEntity.id,
			author = if (author_e) null else clearEntity.author,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			text = if (text_e) null else clearEntity.text,
			markdown = if (markdown_e) emptyMap() else clearEntity.markdown,
			location = if (location_e) null else clearEntity.location,
			confidential = if (confidential_e) null else clearEntity.confidential,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
		)
	}
}

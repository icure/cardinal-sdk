// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedAnnotation
import com.icure.cardinal.sdk.model.embed.EncryptedAnnotation
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object AnnotationEncryptorFactory :
	EntityEncryptorFactory<EncryptedAnnotation, DecryptedAnnotation> {
	override val empty: EntityEncryptor<EncryptedAnnotation, DecryptedAnnotation> =
		AnnotationEncryptor(
			author = false,
			created = false,
			modified = false,
			text = false,
			markdown = false,
			location = false,
			confidential = false,
			tags = false,
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedAnnotation, DecryptedAnnotation> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return AnnotationEncryptor(
			author = "author" in manifest.fieldsToEncrypt,
			created = "created" in manifest.fieldsToEncrypt,
			modified = "modified" in manifest.fieldsToEncrypt,
			text = "text" in manifest.fieldsToEncrypt,
			markdown = "markdown" in manifest.fieldsToEncrypt,
			location = "location" in manifest.fieldsToEncrypt,
			confidential = "confidential" in manifest.fieldsToEncrypt,
			tags = "tags" in manifest.fieldsToEncrypt,
		)
	}
}

private class AnnotationEncryptor(
	private val author: Boolean,
	private val created: Boolean,
	private val modified: Boolean,
	private val text: Boolean,
	private val markdown: Boolean,
	private val location: Boolean,
	private val confidential: Boolean,
	private val tags: Boolean,
) : AbstractEntityEncryptor<EncryptedAnnotation, DecryptedAnnotation>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedAnnotation,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedAnnotation {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (author) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (created) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (text) dataToEncrypt["text"] = encodingJson.encodeToJsonElement(clearEntity.text)
		if (markdown) dataToEncrypt["markdown"] = encodingJson.encodeToJsonElement(clearEntity.markdown)
		if (location) dataToEncrypt["location"] = encodingJson.encodeToJsonElement(clearEntity.location)
		if (confidential) dataToEncrypt["confidential"] = encodingJson.encodeToJsonElement(clearEntity.confidential)
		if (tags) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		return EncryptedAnnotation(
			id = clearEntity.id,
			author = if (author) null else clearEntity.author,
			created = if (created) null else clearEntity.created,
			modified = if (modified) null else clearEntity.modified,
			text = if (text) null else clearEntity.text,
			markdown = if (markdown) emptyMap() else clearEntity.markdown,
			location = if (location) null else clearEntity.location,
			confidential = if (confidential) null else clearEntity.confidential,
			tags = if (tags) emptySet() else clearEntity.tags,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}

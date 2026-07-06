// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.EncryptableFieldConfig
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.embed.DecryptedTypedValue
import com.icure.cardinal.sdk.model.embed.EncryptedTypedValue
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object PropertyStubEncryptorFactory :
	EntityEncryptorFactory<EncryptedPropertyStub, DecryptedPropertyStub> {
	override val empty: EntityEncryptor<EncryptedPropertyStub, DecryptedPropertyStub> =
		PropertyStubEncryptor(
			id = false,
			type = false,
			typedValue = EncryptableFieldConfig.None(TypedValueEncryptorFactory),
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedPropertyStub, DecryptedPropertyStub> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return PropertyStubEncryptor(
			id = "id" in manifest.fieldsToEncrypt,
			type = "type" in manifest.fieldsToEncrypt,
			typedValue =
				if ("typedValue" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["typedValue"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedTypedValue::class,
								decryptedClass = DecryptedTypedValue::class,
							),
						)
					} ?: EncryptableFieldConfig.None(TypedValueEncryptorFactory)
				},
		)
	}
}

private class PropertyStubEncryptor(
	private val id: Boolean,
	private val type: Boolean,
	private val typedValue: EncryptableFieldConfig<EncryptedTypedValue, DecryptedTypedValue>,
) : AbstractEntityEncryptor<EncryptedPropertyStub, DecryptedPropertyStub>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedPropertyStub,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedPropertyStub {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (id) dataToEncrypt["id"] = encodingJson.encodeToJsonElement(clearEntity.id)
		if (type) dataToEncrypt["type"] = encodingJson.encodeToJsonElement(clearEntity.type)
		if (typedValue.fullEncryption) dataToEncrypt["typedValue"] = encodingJson.encodeToJsonElement(clearEntity.typedValue)
		return EncryptedPropertyStub(
			id = if (id) null else clearEntity.id,
			type = if (type) null else clearEntity.type,
			typedValue =
				typedValue.encryptor.let { encryptor ->
					if (encryptor == null) {
						null
					} else {
						clearEntity.typedValue?.let {
							encryptor.encrypt(encryptionKey, it, encodingJson, cryptoService)
						}
					}
				},
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}

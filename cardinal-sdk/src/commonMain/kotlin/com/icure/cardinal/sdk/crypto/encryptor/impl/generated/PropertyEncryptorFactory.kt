// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.EncryptableFieldConfig
import com.icure.cardinal.sdk.model.DecryptedProperty
import com.icure.cardinal.sdk.model.EncryptedProperty
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

internal object PropertyEncryptorFactory :
	EntityEncryptorFactory<EncryptedProperty, DecryptedProperty> {
	override val empty: EntityEncryptor<EncryptedProperty, DecryptedProperty> =
		PropertyEncryptor(
			type = false,
			typedValue = EncryptableFieldConfig.None(TypedValueEncryptorFactory),
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedProperty, DecryptedProperty> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return PropertyEncryptor(
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

private class PropertyEncryptor(
	private val type: Boolean,
	private val typedValue: EncryptableFieldConfig<EncryptedTypedValue, DecryptedTypedValue>,
) : AbstractEntityEncryptor<EncryptedProperty, DecryptedProperty>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedProperty,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedProperty {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (type) dataToEncrypt["type"] = encodingJson.encodeToJsonElement(clearEntity.type)
		if (typedValue.fullEncryption) dataToEncrypt["typedValue"] = encodingJson.encodeToJsonElement(clearEntity.typedValue)
		return EncryptedProperty(
			id = clearEntity.id,
			rev = clearEntity.rev,
			deletionDate = clearEntity.deletionDate,
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

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
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

@InternalIcureApi
internal object PropertyEncryptorFactory :
	EntityEncryptorFactory<EncryptedProperty, DecryptedProperty> {
	override val empty: EntityEncryptor<EncryptedProperty, DecryptedProperty> =
		object :
			EntityEncryptor<EncryptedProperty, DecryptedProperty> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedProperty,
			): EncryptedProperty =
				EncryptedProperty(
					id = clearEntity.id,
					rev = clearEntity.rev,
					deletionDate = clearEntity.deletionDate,
					type = clearEntity.type,
					typedValue =
						clearEntity.typedValue?.let {
							TypedValueEncryptorFactory.empty.encrypt(encryptionKey, it)
						},
					encryptedSelf = null,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedProperty, DecryptedProperty> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return PropertyEncryptor(
			type_e = "type" in manifest.fieldsToEncrypt,
			typedValue_e =
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
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class PropertyEncryptor(
	private val type_e: Boolean,
	private val typedValue_e: EncryptableFieldConfig<EncryptedTypedValue, DecryptedTypedValue>,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedProperty, DecryptedProperty>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedProperty,
	): EncryptedProperty {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (type_e && clearEntity.type != null) dataToEncrypt["type"] = encodingJson.encodeToJsonElement(clearEntity.type)
		if (typedValue_e.fullEncryption && clearEntity.typedValue != null) {
			dataToEncrypt["typedValue"] =
				encodingJson.encodeToJsonElement(
					clearEntity.typedValue,
				)
		}
		return EncryptedProperty(
			id = clearEntity.id,
			rev = clearEntity.rev,
			deletionDate = clearEntity.deletionDate,
			type = if (type_e) null else clearEntity.type,
			typedValue =
				typedValue_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						null
					} else {
						clearEntity.typedValue?.let {
							encryptor.encrypt(encryptionKey, it)
						}
					}
				},
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
		)
	}
}

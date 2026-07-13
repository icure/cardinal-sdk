// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.encryptExtension
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.model.embed.DecryptedTelecom
import com.icure.cardinal.sdk.model.embed.EncryptedTelecom
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

@InternalIcureApi
internal object TelecomEncryptorFactory : EntityEncryptorFactory<EncryptedTelecom, DecryptedTelecom> {
	override val empty: EntityEncryptor<EncryptedTelecom, DecryptedTelecom> =
		object :
			EntityEncryptor<EncryptedTelecom, DecryptedTelecom> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedTelecom,
			): EncryptedTelecom =
				EncryptedTelecom(
					telecomType = clearEntity.telecomType,
					telecomNumber = clearEntity.telecomNumber,
					telecomDescription = clearEntity.telecomDescription,
					encryptedSelf = null,
					extensions = clearEntity.extensions,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedTelecom, DecryptedTelecom> {
		val manifest = encryptorsFactoryContext.getManifest(entityManifestName)
		val extensionsEncryptor =
			manifest.currentExtensionsManifest?.let {
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = it,
					encryptedClass = EncryptedTelecom::class,
					decryptedClass = DecryptedTelecom::class,
				)
			}
		return TelecomEncryptor(
			telecomType_e = "telecomType" in manifest.fieldsToEncrypt,
			telecomNumber_e = "telecomNumber" in manifest.fieldsToEncrypt,
			telecomDescription_e = "telecomDescription" in manifest.fieldsToEncrypt,
			extensionsEncryptor = extensionsEncryptor,
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class TelecomEncryptor(
	private val telecomType_e: Boolean,
	private val telecomNumber_e: Boolean,
	private val telecomDescription_e: Boolean,
	private val extensionsEncryptor: Lazy<ExtensionsEncryptors>?,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedTelecom, DecryptedTelecom>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedTelecom,
	): EncryptedTelecom {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (telecomType_e && clearEntity.telecomType != null) {
			dataToEncrypt["telecomType"] =
				encodingJson.encodeToJsonElement(
					clearEntity.telecomType,
				)
		}
		if (telecomNumber_e && clearEntity.telecomNumber != null) {
			dataToEncrypt["telecomNumber"] =
				encodingJson.encodeToJsonElement(
					clearEntity.telecomNumber,
				)
		}
		if (telecomDescription_e && clearEntity.telecomDescription != null) {
			dataToEncrypt["telecomDescription"] =
				encodingJson.encodeToJsonElement(
					clearEntity.telecomDescription,
				)
		}
		return EncryptedTelecom(
			telecomType = if (telecomType_e) null else clearEntity.telecomType,
			telecomNumber = if (telecomNumber_e) null else clearEntity.telecomNumber,
			telecomDescription = if (telecomDescription_e) null else clearEntity.telecomDescription,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
			extensions = extensionsEncryptor?.value?.encryptExtension(encryptionKey, clearEntity.extensions) ?: clearEntity.extensions,
		)
	}
}

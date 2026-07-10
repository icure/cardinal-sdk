// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.EncryptableFieldConfig
import com.icure.cardinal.sdk.model.embed.DecryptedFlatRateTarification
import com.icure.cardinal.sdk.model.embed.DecryptedValorisation
import com.icure.cardinal.sdk.model.embed.EncryptedFlatRateTarification
import com.icure.cardinal.sdk.model.embed.EncryptedValorisation
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
internal object FlatRateTarificationEncryptorFactory :
	EntityEncryptorFactory<EncryptedFlatRateTarification, DecryptedFlatRateTarification> {
	override val empty: EntityEncryptor<EncryptedFlatRateTarification, DecryptedFlatRateTarification> =
		object : EntityEncryptor<EncryptedFlatRateTarification, DecryptedFlatRateTarification> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedFlatRateTarification,
			): EncryptedFlatRateTarification =
				EncryptedFlatRateTarification(
					code = clearEntity.code,
					flatRateType = clearEntity.flatRateType,
					label = clearEntity.label,
					valorisations =
						clearEntity.valorisations.map { x0 ->
							ValorisationEncryptorFactory.empty.encrypt(encryptionKey, x0)
						},
					encryptedSelf = null,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedFlatRateTarification, DecryptedFlatRateTarification> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return FlatRateTarificationEncryptor(
			code_e = "code" in manifest.fieldsToEncrypt,
			flatRateType_e = "flatRateType" in manifest.fieldsToEncrypt,
			label_e = "label" in manifest.fieldsToEncrypt,
			valorisations_e =
				if ("valorisations" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["valorisations"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedValorisation::class,
								decryptedClass = DecryptedValorisation::class,
							),
						)
					} ?: EncryptableFieldConfig.None(ValorisationEncryptorFactory)
				},
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class FlatRateTarificationEncryptor(
	private val code_e: Boolean,
	private val flatRateType_e: Boolean,
	private val label_e: Boolean,
	private val valorisations_e: EncryptableFieldConfig<EncryptedValorisation, DecryptedValorisation>,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) :
	AbstractEntityEncryptor<EncryptedFlatRateTarification, DecryptedFlatRateTarification>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedFlatRateTarification,
	): EncryptedFlatRateTarification {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (code_e && clearEntity.code != null) dataToEncrypt["code"] = encodingJson.encodeToJsonElement(clearEntity.code)
		if (flatRateType_e && clearEntity.flatRateType != null) {
			dataToEncrypt["flatRateType"] =
				encodingJson.encodeToJsonElement(
					clearEntity.flatRateType,
				)
		}
		if (label_e && clearEntity.label != null) dataToEncrypt["label"] = encodingJson.encodeToJsonElement(clearEntity.label)
		if (valorisations_e.fullEncryption && clearEntity.valorisations.isNotEmpty()) {
			dataToEncrypt["valorisations"] =
				encodingJson.encodeToJsonElement(
					clearEntity.valorisations,
				)
		}
		return EncryptedFlatRateTarification(
			code = if (code_e) null else clearEntity.code,
			flatRateType = if (flatRateType_e) null else clearEntity.flatRateType,
			label = if (label_e) null else clearEntity.label,
			valorisations =
				valorisations_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.valorisations.map { x0 ->
							encryptor.encrypt(encryptionKey, x0)
						}
					}
				},
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
		)
	}
}

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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object FlatRateTarificationEncryptorFactory :
	EntityEncryptorFactory<EncryptedFlatRateTarification, DecryptedFlatRateTarification> {
	override val empty: EntityEncryptor<EncryptedFlatRateTarification, DecryptedFlatRateTarification> =
		FlatRateTarificationEncryptor(
			code = false,
			flatRateType = false,
			label = false,
			valorisations = EncryptableFieldConfig.None(ValorisationEncryptorFactory),
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedFlatRateTarification, DecryptedFlatRateTarification> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return FlatRateTarificationEncryptor(
			code = "code" in manifest.fieldsToEncrypt,
			flatRateType = "flatRateType" in manifest.fieldsToEncrypt,
			label = "label" in manifest.fieldsToEncrypt,
			valorisations =
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
		)
	}
}

private class FlatRateTarificationEncryptor(
	private val code: Boolean,
	private val flatRateType: Boolean,
	private val label: Boolean,
	private val valorisations: EncryptableFieldConfig<EncryptedValorisation, DecryptedValorisation>,
) : AbstractEntityEncryptor<EncryptedFlatRateTarification, DecryptedFlatRateTarification>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedFlatRateTarification,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedFlatRateTarification {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (code) dataToEncrypt["code"] = encodingJson.encodeToJsonElement(clearEntity.code)
		if (flatRateType) dataToEncrypt["flatRateType"] = encodingJson.encodeToJsonElement(clearEntity.flatRateType)
		if (label) dataToEncrypt["label"] = encodingJson.encodeToJsonElement(clearEntity.label)
		if (valorisations.fullEncryption) dataToEncrypt["valorisations"] = encodingJson.encodeToJsonElement(clearEntity.valorisations)
		return EncryptedFlatRateTarification(
			code = if (code) null else clearEntity.code,
			flatRateType = if (flatRateType) null else clearEntity.flatRateType,
			label = if (label) null else clearEntity.label,
			valorisations =
				valorisations.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptyList()
					} else {
						clearEntity.valorisations.map { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
		)
	}
}

// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.embed.DecryptedFlatRateTarification
import com.icure.cardinal.sdk.model.embed.DecryptedValorisation
import com.icure.cardinal.sdk.model.embed.EncryptedFlatRateTarification
import com.icure.cardinal.sdk.model.embed.EncryptedValorisation
import com.icure.cardinal.sdk.options.DecryptedJsonStrictness
import com.icure.cardinal.sdk.utils.UnexpectedEncryptedContentException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.Lazy
import kotlin.String
import kotlin.collections.Collection

@InternalIcureApi
internal object FlatRateTarificationDecryptorFactory :
	EntityDecryptorFactory<EncryptedFlatRateTarification, DecryptedFlatRateTarification> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedFlatRateTarification, DecryptedFlatRateTarification> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		require(manifest?.extensionsManifestsByModelVersion.isNullOrEmpty()) {
			"FlatRateTarification is not Extendable and does not support extensions decryption, but its manifest defines extensionsManifestsByModelVersion."
		}
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
		val valorisationsDecryptor =
			manifest?.recursiveEncryption?.get("valorisations")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedValorisation::class,
						decryptedClass = DecryptedValorisation::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedValorisation::class,
				decryptedClass = DecryptedValorisation::class,
			)
		return FlatRateTarificationDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			valorisationsDecryptor = valorisationsDecryptor,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class FlatRateTarificationDecryptor(
	private val encryptedContentDecoder: Json,
	private val valorisationsDecryptor: Lazy<EntityDecryptor<EncryptedValorisation, DecryptedValorisation>>,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) :
	AbstractEntityDecryptor<EncryptedFlatRateTarification, DecryptedFlatRateTarification>(
			patchDecryptedSelfJson,
			cryptoService,
			unversionedEntitiesDecryptedJsonStrictness,
		) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedFlatRateTarification,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedFlatRateTarification {
		val entityCustomisedModelVersion = customisedModelVersion?.typeVersion
		val decryptedContent = decryptAndPatchContent(decryptionKeys, encryptedEntity)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedFlatRateTarification(
				code =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["code"]?.also { usedEncryptedContent += "code" },
						encryptedEntity.code,
						entityCustomisedModelVersion,
					),
				flatRateType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["flatRateType"]?.also { usedEncryptedContent += "flatRateType" },
						encryptedEntity.flatRateType,
						entityCustomisedModelVersion,
					),
				label =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["label"]?.also { usedEncryptedContent += "label" },
						encryptedEntity.label,
						entityCustomisedModelVersion,
					),
				valorisations =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["valorisations"]?.also { usedEncryptedContent += "valorisations" },
						encryptedEntity.valorisations.map { x0 ->
							valorisationsDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
			)
		if (entityCustomisedModelVersion == null &&
			unversionedEntitiesDecryptedJsonStrictness == DecryptedJsonStrictness.Strict &&
			decryptedContent.size != usedEncryptedContent.size
		) {
			throw UnexpectedEncryptedContentException(
				"The FlatRateTarification encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

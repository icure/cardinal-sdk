// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.embed.DecryptedPatientHealthCareParty
import com.icure.cardinal.sdk.model.embed.EncryptedPatientHealthCareParty
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
internal object PatientHealthCarePartyDecryptorFactory :
	EntityDecryptorFactory<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		require(manifest?.extensionsManifestsByModelVersion.isNullOrEmpty()) {
			"PatientHealthCareParty is not Extendable and does not support extensions decryption, but its manifest defines extensionsManifestsByModelVersion."
		}
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
		val propertiesDecryptor =
			manifest?.recursiveEncryption?.get("properties")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedPropertyStub::class,
						decryptedClass = DecryptedPropertyStub::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedPropertyStub::class,
				decryptedClass = DecryptedPropertyStub::class,
			)
		return PatientHealthCarePartyDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			propertiesDecryptor = propertiesDecryptor,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class PatientHealthCarePartyDecryptor(
	private val encryptedContentDecoder: Json,
	private val propertiesDecryptor: Lazy<EntityDecryptor<EncryptedPropertyStub, DecryptedPropertyStub>>,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) :
	AbstractEntityDecryptor<EncryptedPatientHealthCareParty, DecryptedPatientHealthCareParty>(
			patchDecryptedSelfJson,
			cryptoService,
			unversionedEntitiesDecryptedJsonStrictness,
		) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedPatientHealthCareParty,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedPatientHealthCareParty {
		val entityCustomisedModelVersion = customisedModelVersion?.typeVersion
		val decryptedContent = decryptAndPatchContent(decryptionKeys, encryptedEntity)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedPatientHealthCareParty(
				type =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["type"]?.also { usedEncryptedContent += "type" },
						encryptedEntity.type,
						entityCustomisedModelVersion,
					),
				healthcarePartyId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["healthcarePartyId"]?.also { usedEncryptedContent += "healthcarePartyId" },
						encryptedEntity.healthcarePartyId,
						entityCustomisedModelVersion,
					),
				sendFormats =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["sendFormats"]?.also { usedEncryptedContent += "sendFormats" },
						encryptedEntity.sendFormats,
						entityCustomisedModelVersion,
					),
				referralPeriods =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["referralPeriods"]?.also { usedEncryptedContent += "referralPeriods" },
						encryptedEntity.referralPeriods,
						entityCustomisedModelVersion,
					),
				properties =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["properties"]?.also { usedEncryptedContent += "properties" },
						encryptedEntity.properties?.let {
							it.mapTo(mutableSetOf()) { x0 ->
								propertiesDecryptor.value.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									customisedModelVersion = customisedModelVersion,
								)
							}
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
				"The PatientHealthCareParty encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

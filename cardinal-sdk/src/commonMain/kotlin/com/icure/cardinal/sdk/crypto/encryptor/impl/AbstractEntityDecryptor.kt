package com.icure.cardinal.sdk.crypto.encryptor.impl

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.options.DecryptedJsonStrictness
import com.icure.cardinal.sdk.utils.UnexpectedEncryptedContentException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.serializer

@InternalIcureApi
internal abstract class AbstractEntityDecryptor<ENCRYPTED : Encryptable, DECRYPTED : Encryptable>(
	private val patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	private val cryptoService: CryptoService,
	protected val unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) : EntityDecryptor<ENCRYPTED, DECRYPTED> {

	protected suspend fun decryptAndPatchContent(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: ENCRYPTED,
	): Map<String, JsonElement> {
		val decryptedJson = EncryptorsHelpers.decryptEncryptSelf(
			decryptionKeys = decryptionKeys,
			encryptedSelf = encryptedEntity.encryptedSelf,
			cryptoService = cryptoService,
		)
		return if (patchDecryptedSelfJson != null) {
			patchDecryptedSelfJson(decryptedJson)
		} else {
			decryptedJson
		}
	}

	protected inline fun <reified T> Json.decodeDecrypted(
		json: JsonElement?,
		alternative: T,
		entityCustomisedModelVersion: Int?,
	): T =
		decodeDecrypted(
			serializersModule.serializer(),
			json,
			alternative,
			entityCustomisedModelVersion,
		)

	protected fun <T> Json.decodeDecrypted(
		serializer: KSerializer<T>,
		json: JsonElement?,
		alternative: T,
		entityCustomisedModelVersion: Int?,
	): T =
		if (json != null) {
			try {
				decodeFromJsonElement(serializer, json)
			} catch (e: SerializationException) {
				if (
					entityCustomisedModelVersion != null
					|| unversionedEntitiesDecryptedJsonStrictness == DecryptedJsonStrictness.IgnoreBadValues
				)
					alternative
				else
					throw UnexpectedEncryptedContentException(
						"Failed to deserialize ${serializer.descriptor.serialName} from encrypted content",
						e,
					)
			}
		} else {
			alternative
		}
}

internal fun Map<EntityWithEncryptionMetadataTypeName, Map<Int, String>>.loadExtensionsEncryptors(
	getExtensionsEncryptorsProvider: (extensionsManifestName: String) -> Lazy<ExtensionsEncryptors>
): Map<CustomisedModelVersion, Lazy<ExtensionsEncryptors>> = this.flatMap { (type, inner) ->
	inner.map { (version, manifestName) ->
		CustomisedModelVersion(modelType = type, typeVersion = version) to getExtensionsEncryptorsProvider(manifestName)
	}
}.toMap()
package com.icure.cardinal.sdk.crypto.encryptor.impl

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.impl.generated.CustomEntityBaseDecryptor
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.DecryptedCustomEntityBase
import com.icure.cardinal.sdk.model.EncryptedCustomEntityBase
import com.icure.cardinal.sdk.options.DecryptedJsonStrictness
import com.icure.cardinal.sdk.utils.ensure
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.Lazy
import kotlin.String
import kotlin.UnsupportedOperationException
import kotlin.collections.Collection
import kotlin.collections.Map

@InternalIcureApi
internal object CustomEntityBaseDecryptorFactory {
	fun create(
		customEntityTypeId: String,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedCustomEntityBase, DecryptedCustomEntityBase> {
		val manifest = encryptorsFactoryContext.getCustomEntityManifest(customEntityTypeId)
		val extensionsDecryptorsByVersion =
			manifest.extensionsManifestsByModelVersion.mapValues { (_, extensionsManifestName) ->
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = extensionsManifestName,
					encryptedClass = EncryptedCustomEntityBase::class,
					decryptedClass = DecryptedCustomEntityBase::class,
				)
			}
		// no json patching required for custom entities, since they are always properly versioned
		return CustomEntityBaseDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			extensionsDecryptorsByVersion = extensionsDecryptorsByVersion,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
			customEntityTypeId = customEntityTypeId,
		)
	}
}

@InternalIcureApi
internal abstract class AbstractCustomEntityBaseDecryptor(
	protected val encryptedContentDecoder: Json,
	private val extensionsDecryptorsByVersion: Map<Int, Lazy<ExtensionsEncryptors>>,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	private val customEntityTypeId: String,
) : AbstractEntityDecryptor<EncryptedCustomEntityBase, DecryptedCustomEntityBase>(
		null,
		cryptoService,
		unversionedEntitiesDecryptedJsonStrictness,
	) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedCustomEntityBase,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedCustomEntityBase {
		ensure(customisedModelVersion != null) {
			"Fully custom entity should always have a model version"
		}
		ensure(customisedModelVersion.modelType is EntityWithEncryptionMetadataTypeName.Custom) {
			"Custom entity decryptor used with non-custom entity model"
		}
		ensure(customisedModelVersion.modelType.entityTypeId == customEntityTypeId) {
			"Decryptor of wrong custom type used; expected $customEntityTypeId but got ${customisedModelVersion.modelType}"
		}
		val extensionsDecryptor = extensionsDecryptorsByVersion[customisedModelVersion.typeVersion]?.value
			?: throw UnsupportedOperationException(
				"This instance of the SDK is not capable of handling CustomEntityBase entities of version $customisedModelVersion.",
			)
		val extensions = encryptedEntity.extensions?.let { extensionsDecryptor.decryptExtension(decryptionKeys, it) }
		return decryptCommonMeta(
			decryptionKeys = decryptionKeys,
			encryptedEntity = encryptedEntity,
			entityCustomisedModelVersion = customisedModelVersion.typeVersion,
			extensions = extensions,
		)
	}

	protected abstract suspend fun decryptCommonMeta(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedCustomEntityBase,
		entityCustomisedModelVersion: Int,
		extensions: JsonObject?,
	): DecryptedCustomEntityBase
}

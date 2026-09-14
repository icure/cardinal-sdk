// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.loadExtensionsEncryptors
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.DecryptedRelatedPerson
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedRelatedPerson
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
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
import kotlin.UnsupportedOperationException
import kotlin.collections.Collection
import kotlin.collections.Map

@InternalIcureApi
internal object RelatedPersonDecryptorFactory :
	EntityDecryptorFactory<EncryptedRelatedPerson, DecryptedRelatedPerson> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedRelatedPerson, DecryptedRelatedPerson> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		val extensionsDecryptorsByVersion =
			manifest?.extensionsManifestsByModelVersion?.loadExtensionsEncryptors { extensionsManifestName ->
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = extensionsManifestName,
					encryptedClass = EncryptedRelatedPerson::class,
					decryptedClass = DecryptedRelatedPerson::class,
				)
			} ?: emptyMap()
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
		val addressesDecryptor =
			manifest?.recursiveEncryption?.get("addresses")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedAddress::class,
						decryptedClass = DecryptedAddress::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedAddress::class,
				decryptedClass = DecryptedAddress::class,
			)
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
		return RelatedPersonDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			addressesDecryptor = addressesDecryptor,
			propertiesDecryptor = propertiesDecryptor,
			extensionsDecryptorsByVersion = extensionsDecryptorsByVersion,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class RelatedPersonDecryptor(
	private val encryptedContentDecoder: Json,
	private val addressesDecryptor: Lazy<EntityDecryptor<EncryptedAddress, DecryptedAddress>>,
	private val propertiesDecryptor: Lazy<EntityDecryptor<EncryptedPropertyStub, DecryptedPropertyStub>>,
	private val extensionsDecryptorsByVersion: Map<CustomisedModelVersion, Lazy<ExtensionsEncryptors>>,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) : AbstractEntityDecryptor<EncryptedRelatedPerson, DecryptedRelatedPerson>(
		patchDecryptedSelfJson,
		cryptoService,
		unversionedEntitiesDecryptedJsonStrictness,
	) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedRelatedPerson,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedRelatedPerson {
		val extensions =
			if (customisedModelVersion != null) {
				val extensionsDecryptor =
					(
						extensionsDecryptorsByVersion[customisedModelVersion] ?: throw UnsupportedOperationException(
							"This instance of the SDK is not capable of handling RelatedPerson entities of version $customisedModelVersion.",
						)
					).value
				encryptedEntity.extensions?.let { extensionsDecryptor.decryptExtension(decryptionKeys, it) }
			} else {
				encryptedEntity.extensions
			}
		val entityCustomisedModelVersion = customisedModelVersion?.typeVersion
		val decryptedContent = decryptAndPatchContent(decryptionKeys, encryptedEntity)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedRelatedPerson(
				id = encryptedEntity.id,
				rev = encryptedEntity.rev,
				identifier =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["identifier"]?.also { usedEncryptedContent += "identifier" },
						encryptedEntity.identifier,
						entityCustomisedModelVersion,
					),
				created =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["created"]?.also { usedEncryptedContent += "created" },
						encryptedEntity.created,
						entityCustomisedModelVersion,
					),
				modified =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["modified"]?.also { usedEncryptedContent += "modified" },
						encryptedEntity.modified,
						entityCustomisedModelVersion,
					),
				author =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["author"]?.also { usedEncryptedContent += "author" },
						encryptedEntity.author,
						entityCustomisedModelVersion,
					),
				responsible =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["responsible"]?.also { usedEncryptedContent += "responsible" },
						encryptedEntity.responsible,
						entityCustomisedModelVersion,
					),
				tags =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["tags"]?.also { usedEncryptedContent += "tags" },
						encryptedEntity.tags,
						entityCustomisedModelVersion,
					),
				codes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["codes"]?.also { usedEncryptedContent += "codes" },
						encryptedEntity.codes,
						entityCustomisedModelVersion,
					),
				endOfLife = encryptedEntity.endOfLife,
				deletionDate = encryptedEntity.deletionDate,
				firstName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["firstName"]?.also { usedEncryptedContent += "firstName" },
						encryptedEntity.firstName,
						entityCustomisedModelVersion,
					),
				lastName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["lastName"]?.also { usedEncryptedContent += "lastName" },
						encryptedEntity.lastName,
						entityCustomisedModelVersion,
					),
				names =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["names"]?.also { usedEncryptedContent += "names" },
						encryptedEntity.names,
						entityCustomisedModelVersion,
					),
				companyName =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["companyName"]?.also { usedEncryptedContent += "companyName" },
						encryptedEntity.companyName,
						entityCustomisedModelVersion,
					),
				languages =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["languages"]?.also { usedEncryptedContent += "languages" },
						encryptedEntity.languages,
						entityCustomisedModelVersion,
					),
				addresses =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["addresses"]?.also { usedEncryptedContent += "addresses" },
						encryptedEntity.addresses.map { x0 ->
							addressesDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				civility =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["civility"]?.also { usedEncryptedContent += "civility" },
						encryptedEntity.civility,
						entityCustomisedModelVersion,
					),
				gender =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["gender"]?.also { usedEncryptedContent += "gender" },
						encryptedEntity.gender,
						entityCustomisedModelVersion,
					),
				properties =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["properties"]?.also { usedEncryptedContent += "properties" },
						encryptedEntity.properties.mapTo(mutableSetOf()) { x0 ->
							propertiesDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
				customisedModelVersion = encryptedEntity.customisedModelVersion,
				extensions = extensions,
			)
		if (entityCustomisedModelVersion == null &&
			unversionedEntitiesDecryptedJsonStrictness == DecryptedJsonStrictness.Strict &&
			decryptedContent.size != usedEncryptedContent.size
		) {
			throw UnexpectedEncryptedContentException(
				"The RelatedPerson encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

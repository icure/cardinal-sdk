// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.loadExtensionsEncryptors
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.DecryptedAnnotation
import com.icure.cardinal.sdk.model.embed.DecryptedTelecom
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
import com.icure.cardinal.sdk.model.embed.EncryptedAnnotation
import com.icure.cardinal.sdk.model.embed.EncryptedTelecom
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
internal object AddressDecryptorFactory : EntityDecryptorFactory<EncryptedAddress, DecryptedAddress> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedAddress, DecryptedAddress> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		val extensionsDecryptorsByVersion =
			manifest?.extensionsManifestsByModelVersion?.loadExtensionsEncryptors { extensionsManifestName ->
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = extensionsManifestName,
					encryptedClass = EncryptedAddress::class,
					decryptedClass = DecryptedAddress::class,
				)
			} ?: emptyMap()
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
		val notesDecryptor =
			manifest?.recursiveEncryption?.get("notes")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedAnnotation::class,
						decryptedClass = DecryptedAnnotation::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedAnnotation::class,
				decryptedClass = DecryptedAnnotation::class,
			)
		val telecomsDecryptor =
			manifest?.recursiveEncryption?.get("telecoms")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedTelecom::class,
						decryptedClass = DecryptedTelecom::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedTelecom::class,
				decryptedClass = DecryptedTelecom::class,
			)
		return AddressDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			notesDecryptor = notesDecryptor,
			telecomsDecryptor = telecomsDecryptor,
			extensionsDecryptorsByVersion = extensionsDecryptorsByVersion,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class AddressDecryptor(
	private val encryptedContentDecoder: Json,
	private val notesDecryptor: Lazy<EntityDecryptor<EncryptedAnnotation, DecryptedAnnotation>>,
	private val telecomsDecryptor: Lazy<EntityDecryptor<EncryptedTelecom, DecryptedTelecom>>,
	private val extensionsDecryptorsByVersion: Map<CustomisedModelVersion, Lazy<ExtensionsEncryptors>>,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) : AbstractEntityDecryptor<EncryptedAddress, DecryptedAddress>(
		patchDecryptedSelfJson,
		cryptoService,
		unversionedEntitiesDecryptedJsonStrictness,
	) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedAddress,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedAddress {
		val extensions =
			if (customisedModelVersion != null) {
				val extensionsDecryptor =
					(
						extensionsDecryptorsByVersion[customisedModelVersion] ?: throw UnsupportedOperationException(
							"This instance of the SDK is not capable of handling Address entities of version $customisedModelVersion.",
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
			DecryptedAddress(
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
				identifier =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["identifier"]?.also { usedEncryptedContent += "identifier" },
						encryptedEntity.identifier,
						entityCustomisedModelVersion,
					),
				addressType =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["addressType"]?.also { usedEncryptedContent += "addressType" },
						encryptedEntity.addressType,
						entityCustomisedModelVersion,
					),
				descr =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["descr"]?.also { usedEncryptedContent += "descr" },
						encryptedEntity.descr,
						entityCustomisedModelVersion,
					),
				street =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["street"]?.also { usedEncryptedContent += "street" },
						encryptedEntity.street,
						entityCustomisedModelVersion,
					),
				houseNumber =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["houseNumber"]?.also { usedEncryptedContent += "houseNumber" },
						encryptedEntity.houseNumber,
						entityCustomisedModelVersion,
					),
				postboxNumber =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["postboxNumber"]?.also { usedEncryptedContent += "postboxNumber" },
						encryptedEntity.postboxNumber,
						entityCustomisedModelVersion,
					),
				postalCode =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["postalCode"]?.also { usedEncryptedContent += "postalCode" },
						encryptedEntity.postalCode,
						entityCustomisedModelVersion,
					),
				city =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["city"]?.also { usedEncryptedContent += "city" },
						encryptedEntity.city,
						entityCustomisedModelVersion,
					),
				state =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["state"]?.also { usedEncryptedContent += "state" },
						encryptedEntity.state,
						entityCustomisedModelVersion,
					),
				country =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["country"]?.also { usedEncryptedContent += "country" },
						encryptedEntity.country,
						entityCustomisedModelVersion,
					),
				note =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["note"]?.also { usedEncryptedContent += "note" },
						encryptedEntity.note,
						entityCustomisedModelVersion,
					),
				notes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["notes"]?.also { usedEncryptedContent += "notes" },
						encryptedEntity.notes.map { x0 ->
							notesDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				telecoms =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["telecoms"]?.also { usedEncryptedContent += "telecoms" },
						encryptedEntity.telecoms.map { x0 ->
							telecomsDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				encryptedSelf = encryptedEntity.encryptedSelf,
				extensions = extensions,
			)
		if (entityCustomisedModelVersion == null &&
			unversionedEntitiesDecryptedJsonStrictness == DecryptedJsonStrictness.Strict &&
			decryptedContent.size != usedEncryptedContent.size
		) {
			throw UnexpectedEncryptedContentException(
				"The Address encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

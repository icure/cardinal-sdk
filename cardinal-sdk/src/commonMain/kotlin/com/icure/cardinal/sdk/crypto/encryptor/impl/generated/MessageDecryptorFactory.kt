// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.loadExtensionsEncryptors
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
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
internal object MessageDecryptorFactory : EntityDecryptorFactory<EncryptedMessage, DecryptedMessage> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedMessage, DecryptedMessage> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		val extensionsDecryptorsByVersion =
			manifest?.extensionsManifestsByModelVersion?.loadExtensionsEncryptors { extensionsManifestName ->
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = extensionsManifestName,
					encryptedClass = EncryptedMessage::class,
					decryptedClass = DecryptedMessage::class,
				)
			} ?: emptyMap()
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
		return MessageDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			propertiesDecryptor = propertiesDecryptor,
			extensionsDecryptorsByVersion = extensionsDecryptorsByVersion,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class MessageDecryptor(
	private val encryptedContentDecoder: Json,
	private val propertiesDecryptor: Lazy<EntityDecryptor<EncryptedPropertyStub, DecryptedPropertyStub>>,
	private val extensionsDecryptorsByVersion: Map<CustomisedModelVersion, Lazy<ExtensionsEncryptors>>,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) : AbstractEntityDecryptor<EncryptedMessage, DecryptedMessage>(
		patchDecryptedSelfJson,
		cryptoService,
		unversionedEntitiesDecryptedJsonStrictness,
	) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedMessage,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedMessage {
		val extensions =
			if (customisedModelVersion != null) {
				val extensionsDecryptor =
					(
						extensionsDecryptorsByVersion[customisedModelVersion] ?: throw UnsupportedOperationException(
							"This instance of the SDK is not capable of handling Message entities of version $customisedModelVersion.",
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
			DecryptedMessage(
				id = encryptedEntity.id,
				rev = encryptedEntity.rev,
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
				deletionDate = encryptedEntity.deletionDate,
				fromAddress =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["fromAddress"]?.also { usedEncryptedContent += "fromAddress" },
						encryptedEntity.fromAddress,
						entityCustomisedModelVersion,
					),
				fromHealthcarePartyId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["fromHealthcarePartyId"]?.also { usedEncryptedContent += "fromHealthcarePartyId" },
						encryptedEntity.fromHealthcarePartyId,
						entityCustomisedModelVersion,
					),
				recipients =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["recipients"]?.also { usedEncryptedContent += "recipients" },
						encryptedEntity.recipients,
						entityCustomisedModelVersion,
					),
				toAddresses =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["toAddresses"]?.also { usedEncryptedContent += "toAddresses" },
						encryptedEntity.toAddresses,
						entityCustomisedModelVersion,
					),
				received =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["received"]?.also { usedEncryptedContent += "received" },
						encryptedEntity.received,
						entityCustomisedModelVersion,
					),
				sent =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["sent"]?.also { usedEncryptedContent += "sent" },
						encryptedEntity.sent,
						entityCustomisedModelVersion,
					),
				metas =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["metas"]?.also { usedEncryptedContent += "metas" },
						encryptedEntity.metas,
						entityCustomisedModelVersion,
					),
				readStatus =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["readStatus"]?.also { usedEncryptedContent += "readStatus" },
						encryptedEntity.readStatus,
						entityCustomisedModelVersion,
					),
				transportGuid =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["transportGuid"]?.also { usedEncryptedContent += "transportGuid" },
						encryptedEntity.transportGuid,
						entityCustomisedModelVersion,
					),
				remark =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["remark"]?.also { usedEncryptedContent += "remark" },
						encryptedEntity.remark,
						entityCustomisedModelVersion,
					),
				conversationGuid =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["conversationGuid"]?.also { usedEncryptedContent += "conversationGuid" },
						encryptedEntity.conversationGuid,
						entityCustomisedModelVersion,
					),
				subject =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["subject"]?.also { usedEncryptedContent += "subject" },
						encryptedEntity.subject,
						entityCustomisedModelVersion,
					),
				invoiceIds =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["invoiceIds"]?.also { usedEncryptedContent += "invoiceIds" },
						encryptedEntity.invoiceIds,
						entityCustomisedModelVersion,
					),
				parentId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["parentId"]?.also { usedEncryptedContent += "parentId" },
						encryptedEntity.parentId,
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
				extensions = extensions,
				extensionsVersion = encryptedEntity.extensionsVersion,
			)
		if (entityCustomisedModelVersion == null &&
			unversionedEntitiesDecryptedJsonStrictness == DecryptedJsonStrictness.Strict &&
			decryptedContent.size != usedEncryptedContent.size
		) {
			throw UnexpectedEncryptedContentException(
				"The Message encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

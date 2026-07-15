// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityDecryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorsFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.ExtensionsEncryptors
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.loadExtensionsEncryptors
import com.icure.cardinal.sdk.customsdk.commons.model.CustomisedModelVersion
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.DecryptedCalendarItemTag
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
import com.icure.cardinal.sdk.model.embed.EncryptedCalendarItemTag
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
internal object CalendarItemDecryptorFactory :
	EntityDecryptorFactory<EncryptedCalendarItem, DecryptedCalendarItem> {
	override fun create(
		entityManifestName: String?,
		encryptorsFactoryContext: EntityEncryptorsFactoryContext,
		cryptoService: CryptoService,
		encryptedContentDecoder: Json,
		unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
	): EntityDecryptor<EncryptedCalendarItem, DecryptedCalendarItem> {
		val manifest = entityManifestName?.let { encryptorsFactoryContext.getManifest(it) }
		val extensionsDecryptorsByVersion =
			manifest?.extensionsManifestsByModelVersion?.loadExtensionsEncryptors { extensionsManifestName ->
				encryptorsFactoryContext.getExtensionEncryptorsProvider(
					extensionsManifestName = extensionsManifestName,
					encryptedClass = EncryptedCalendarItem::class,
					decryptedClass = DecryptedCalendarItem::class,
				)
			} ?: emptyMap()
		val patchDecryptedSelfJson = entityManifestName?.let { encryptorsFactoryContext.getManifestDecryptedJsonPatcher(it) }
		val addressDecryptor =
			manifest?.recursiveEncryption?.get("address")?.let { nestedManifestName ->
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
		val meetingTagsDecryptor =
			manifest?.recursiveEncryption?.get("meetingTags")?.let { nestedManifestName ->
				val pairLazy =
					encryptorsFactoryContext.getEntityEncryptorsProvider(
						entityManifestName = nestedManifestName,
						encryptedClass = EncryptedCalendarItemTag::class,
						decryptedClass = DecryptedCalendarItemTag::class,
					)
				lazy { pairLazy.value.decryptor }
			} ?: encryptorsFactoryContext.getEmptyEntityDecryptorProvider(
				encryptedClass = EncryptedCalendarItemTag::class,
				decryptedClass = DecryptedCalendarItemTag::class,
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
		return CalendarItemDecryptor(
			encryptedContentDecoder = encryptedContentDecoder,
			addressDecryptor = addressDecryptor,
			meetingTagsDecryptor = meetingTagsDecryptor,
			propertiesDecryptor = propertiesDecryptor,
			extensionsDecryptorsByVersion = extensionsDecryptorsByVersion,
			patchDecryptedSelfJson = patchDecryptedSelfJson,
			cryptoService = cryptoService,
			unversionedEntitiesDecryptedJsonStrictness = unversionedEntitiesDecryptedJsonStrictness,
		)
	}
}

@InternalIcureApi
private class CalendarItemDecryptor(
	private val encryptedContentDecoder: Json,
	private val addressDecryptor: Lazy<EntityDecryptor<EncryptedAddress, DecryptedAddress>>,
	private val meetingTagsDecryptor: Lazy<EntityDecryptor<EncryptedCalendarItemTag, DecryptedCalendarItemTag>>,
	private val propertiesDecryptor: Lazy<EntityDecryptor<EncryptedPropertyStub, DecryptedPropertyStub>>,
	private val extensionsDecryptorsByVersion: Map<CustomisedModelVersion, Lazy<ExtensionsEncryptors>>,
	patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
	cryptoService: CryptoService,
	unversionedEntitiesDecryptedJsonStrictness: DecryptedJsonStrictness,
) : AbstractEntityDecryptor<EncryptedCalendarItem, DecryptedCalendarItem>(
		patchDecryptedSelfJson,
		cryptoService,
		unversionedEntitiesDecryptedJsonStrictness,
	) {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedCalendarItem,
		customisedModelVersion: CustomisedModelVersion?,
	): DecryptedCalendarItem {
		val extensions =
			if (customisedModelVersion != null) {
				val extensionsDecryptor =
					(
						extensionsDecryptorsByVersion[customisedModelVersion] ?: throw UnsupportedOperationException(
							"This instance of the SDK is not capable of handling CalendarItem entities of version $customisedModelVersion.",
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
			DecryptedCalendarItem(
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
				title =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["title"]?.also { usedEncryptedContent += "title" },
						encryptedEntity.title,
						entityCustomisedModelVersion,
					),
				calendarItemTypeId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["calendarItemTypeId"]?.also { usedEncryptedContent += "calendarItemTypeId" },
						encryptedEntity.calendarItemTypeId,
						entityCustomisedModelVersion,
					),
				masterCalendarItemId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["masterCalendarItemId"]?.also { usedEncryptedContent += "masterCalendarItemId" },
						encryptedEntity.masterCalendarItemId,
						entityCustomisedModelVersion,
					),
				important =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["important"]?.also { usedEncryptedContent += "important" },
						encryptedEntity.important,
						entityCustomisedModelVersion,
					),
				homeVisit =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["homeVisit"]?.also { usedEncryptedContent += "homeVisit" },
						encryptedEntity.homeVisit,
						entityCustomisedModelVersion,
					),
				phoneNumber =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["phoneNumber"]?.also { usedEncryptedContent += "phoneNumber" },
						encryptedEntity.phoneNumber,
						entityCustomisedModelVersion,
					),
				placeId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["placeId"]?.also { usedEncryptedContent += "placeId" },
						encryptedEntity.placeId,
						entityCustomisedModelVersion,
					),
				address =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["address"]?.also { usedEncryptedContent += "address" },
						encryptedEntity.address?.let {
							addressDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = it,
								customisedModelVersion = customisedModelVersion,
							)
						},
						entityCustomisedModelVersion,
					),
				addressText =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["addressText"]?.also { usedEncryptedContent += "addressText" },
						encryptedEntity.addressText,
						entityCustomisedModelVersion,
					),
				startTime =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["startTime"]?.also { usedEncryptedContent += "startTime" },
						encryptedEntity.startTime,
						entityCustomisedModelVersion,
					),
				endTime =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["endTime"]?.also { usedEncryptedContent += "endTime" },
						encryptedEntity.endTime,
						entityCustomisedModelVersion,
					),
				confirmationTime =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["confirmationTime"]?.also { usedEncryptedContent += "confirmationTime" },
						encryptedEntity.confirmationTime,
						entityCustomisedModelVersion,
					),
				cancellationTimestamp =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["cancellationTimestamp"]?.also { usedEncryptedContent += "cancellationTimestamp" },
						encryptedEntity.cancellationTimestamp,
						entityCustomisedModelVersion,
					),
				confirmationId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["confirmationId"]?.also { usedEncryptedContent += "confirmationId" },
						encryptedEntity.confirmationId,
						entityCustomisedModelVersion,
					),
				duration =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["duration"]?.also { usedEncryptedContent += "duration" },
						encryptedEntity.duration,
						entityCustomisedModelVersion,
					),
				allDay =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["allDay"]?.also { usedEncryptedContent += "allDay" },
						encryptedEntity.allDay,
						entityCustomisedModelVersion,
					),
				details =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["details"]?.also { usedEncryptedContent += "details" },
						encryptedEntity.details,
						entityCustomisedModelVersion,
					),
				wasMigrated =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["wasMigrated"]?.also { usedEncryptedContent += "wasMigrated" },
						encryptedEntity.wasMigrated,
						entityCustomisedModelVersion,
					),
				agendaId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["agendaId"]?.also { usedEncryptedContent += "agendaId" },
						encryptedEntity.agendaId,
						entityCustomisedModelVersion,
					),
				resourceGroup =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["resourceGroup"]?.also { usedEncryptedContent += "resourceGroup" },
						encryptedEntity.resourceGroup,
						entityCustomisedModelVersion,
					),
				availabilitiesAssignmentStrategy = encryptedEntity.availabilitiesAssignmentStrategy,
				hcpId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["hcpId"]?.also { usedEncryptedContent += "hcpId" },
						encryptedEntity.hcpId,
						entityCustomisedModelVersion,
					),
				recurrenceId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["recurrenceId"]?.also { usedEncryptedContent += "recurrenceId" },
						encryptedEntity.recurrenceId,
						entityCustomisedModelVersion,
					),
				meetingTags =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["meetingTags"]?.also { usedEncryptedContent += "meetingTags" },
						encryptedEntity.meetingTags.mapTo(mutableSetOf()) { x0 ->
							meetingTagsDecryptor.value.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								customisedModelVersion = customisedModelVersion,
							)
						},
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
				"The CalendarItem encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

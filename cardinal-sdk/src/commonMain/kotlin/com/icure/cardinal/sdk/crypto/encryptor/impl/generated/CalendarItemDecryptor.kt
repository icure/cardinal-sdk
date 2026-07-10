// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.DecryptedJsonStrictness
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlin.collections.Collection

@InternalIcureApi
internal object CalendarItemDecryptor :
	AbstractEntityDecryptor<EncryptedCalendarItem, DecryptedCalendarItem>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedCalendarItem,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		decryptedJsonStrictness: DecryptedJsonStrictness,
		encryptedContentDecoder: Json,
		cryptoService: CryptoService,
	): DecryptedCalendarItem {
		val decryptedContent =
			decryptAndPatchContent(
				decryptionKeys,
				encryptedEntity,
				patchDecryptedSelfJson,
				cryptoService,
			)
		val usedEncryptedContent = mutableSetOf<String>()
		val result =
			DecryptedCalendarItem(
				id = encryptedEntity.id,
				rev = encryptedEntity.rev,
				created =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["created"]?.also { usedEncryptedContent += "created" },
						encryptedEntity.created,
						decryptedJsonStrictness,
					),
				modified =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["modified"]?.also { usedEncryptedContent += "modified" },
						encryptedEntity.modified,
						decryptedJsonStrictness,
					),
				author =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["author"]?.also { usedEncryptedContent += "author" },
						encryptedEntity.author,
						decryptedJsonStrictness,
					),
				responsible =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["responsible"]?.also { usedEncryptedContent += "responsible" },
						encryptedEntity.responsible,
						decryptedJsonStrictness,
					),
				tags =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["tags"]?.also { usedEncryptedContent += "tags" },
						encryptedEntity.tags,
						decryptedJsonStrictness,
					),
				codes =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["codes"]?.also { usedEncryptedContent += "codes" },
						encryptedEntity.codes,
						decryptedJsonStrictness,
					),
				deletionDate = encryptedEntity.deletionDate,
				title =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["title"]?.also { usedEncryptedContent += "title" },
						encryptedEntity.title,
						decryptedJsonStrictness,
					),
				calendarItemTypeId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["calendarItemTypeId"]?.also { usedEncryptedContent += "calendarItemTypeId" },
						encryptedEntity.calendarItemTypeId,
						decryptedJsonStrictness,
					),
				masterCalendarItemId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["masterCalendarItemId"]?.also { usedEncryptedContent += "masterCalendarItemId" },
						encryptedEntity.masterCalendarItemId,
						decryptedJsonStrictness,
					),
				important =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["important"]?.also { usedEncryptedContent += "important" },
						encryptedEntity.important,
						decryptedJsonStrictness,
					),
				homeVisit =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["homeVisit"]?.also { usedEncryptedContent += "homeVisit" },
						encryptedEntity.homeVisit,
						decryptedJsonStrictness,
					),
				phoneNumber =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["phoneNumber"]?.also { usedEncryptedContent += "phoneNumber" },
						encryptedEntity.phoneNumber,
						decryptedJsonStrictness,
					),
				placeId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["placeId"]?.also { usedEncryptedContent += "placeId" },
						encryptedEntity.placeId,
						decryptedJsonStrictness,
					),
				address =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["address"]?.also { usedEncryptedContent += "address" },
						encryptedEntity.address?.let {
							AddressDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = it,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				addressText =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["addressText"]?.also { usedEncryptedContent += "addressText" },
						encryptedEntity.addressText,
						decryptedJsonStrictness,
					),
				startTime =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["startTime"]?.also { usedEncryptedContent += "startTime" },
						encryptedEntity.startTime,
						decryptedJsonStrictness,
					),
				endTime =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["endTime"]?.also { usedEncryptedContent += "endTime" },
						encryptedEntity.endTime,
						decryptedJsonStrictness,
					),
				confirmationTime =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["confirmationTime"]?.also { usedEncryptedContent += "confirmationTime" },
						encryptedEntity.confirmationTime,
						decryptedJsonStrictness,
					),
				cancellationTimestamp =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["cancellationTimestamp"]?.also { usedEncryptedContent += "cancellationTimestamp" },
						encryptedEntity.cancellationTimestamp,
						decryptedJsonStrictness,
					),
				confirmationId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["confirmationId"]?.also { usedEncryptedContent += "confirmationId" },
						encryptedEntity.confirmationId,
						decryptedJsonStrictness,
					),
				duration =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["duration"]?.also { usedEncryptedContent += "duration" },
						encryptedEntity.duration,
						decryptedJsonStrictness,
					),
				allDay =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["allDay"]?.also { usedEncryptedContent += "allDay" },
						encryptedEntity.allDay,
						decryptedJsonStrictness,
					),
				details =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["details"]?.also { usedEncryptedContent += "details" },
						encryptedEntity.details,
						decryptedJsonStrictness,
					),
				wasMigrated =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["wasMigrated"]?.also { usedEncryptedContent += "wasMigrated" },
						encryptedEntity.wasMigrated,
						decryptedJsonStrictness,
					),
				agendaId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["agendaId"]?.also { usedEncryptedContent += "agendaId" },
						encryptedEntity.agendaId,
						decryptedJsonStrictness,
					),
				resourceGroup =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["resourceGroup"]?.also { usedEncryptedContent += "resourceGroup" },
						encryptedEntity.resourceGroup,
						decryptedJsonStrictness,
					),
				availabilitiesAssignmentStrategy = encryptedEntity.availabilitiesAssignmentStrategy,
				hcpId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["hcpId"]?.also { usedEncryptedContent += "hcpId" },
						encryptedEntity.hcpId,
						decryptedJsonStrictness,
					),
				recurrenceId =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["recurrenceId"]?.also { usedEncryptedContent += "recurrenceId" },
						encryptedEntity.recurrenceId,
						decryptedJsonStrictness,
					),
				meetingTags =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["meetingTags"]?.also { usedEncryptedContent += "meetingTags" },
						encryptedEntity.meetingTags.mapTo(mutableSetOf()) { x0 ->
							CalendarItemTagDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				properties =
					encryptedContentDecoder.decodeDecrypted(
						decryptedContent["properties"]?.also { usedEncryptedContent += "properties" },
						encryptedEntity.properties.mapTo(mutableSetOf()) { x0 ->
							PropertyStubDecryptor.decrypt(
								decryptionKeys = decryptionKeys,
								encryptedEntity = x0,
								patchDecryptedSelfJson = patchDecryptedSelfJson,
								decryptedJsonStrictness = decryptedJsonStrictness,
								encryptedContentDecoder = encryptedContentDecoder,
								cryptoService = cryptoService,
							)
						},
						decryptedJsonStrictness,
					),
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
				extensions = encryptedEntity.extensions,
				extensionsVersion = encryptedEntity.extensionsVersion,
			)
		if (decryptedJsonStrictness == DecryptedJsonStrictness.Strict && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The CalendarItem encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

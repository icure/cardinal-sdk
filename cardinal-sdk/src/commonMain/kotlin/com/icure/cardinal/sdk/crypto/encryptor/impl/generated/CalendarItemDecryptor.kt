// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityDecryptor
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlin.Boolean
import kotlin.collections.Collection

internal object CalendarItemDecryptor :
	AbstractEntityDecryptor<EncryptedCalendarItem, DecryptedCalendarItem>() {
	override suspend fun decrypt(
		decryptionKeys: Collection<AesKey<AesAlgorithm.CbcWithPkcs7Padding>>,
		encryptedEntity: EncryptedCalendarItem,
		patchDecryptedSelfJson: ((JsonObject) -> JsonObject)?,
		ignoreUnknownDecryptedFields: Boolean,
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
					decryptedContent["created"].let {
						if (it != null) {
							usedEncryptedContent += "created"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.created
						}
					},
				modified =
					decryptedContent["modified"].let {
						if (it != null) {
							usedEncryptedContent += "modified"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.modified
						}
					},
				author =
					decryptedContent["author"].let {
						if (it != null) {
							usedEncryptedContent += "author"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.author
						}
					},
				responsible =
					decryptedContent["responsible"].let {
						if (it != null) {
							usedEncryptedContent += "responsible"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.responsible
						}
					},
				tags =
					decryptedContent["tags"].let {
						if (it != null) {
							usedEncryptedContent += "tags"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.tags
						}
					},
				codes =
					decryptedContent["codes"].let {
						if (it != null) {
							usedEncryptedContent += "codes"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.codes
						}
					},
				deletionDate = encryptedEntity.deletionDate,
				title =
					decryptedContent["title"].let {
						if (it != null) {
							usedEncryptedContent += "title"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.title
						}
					},
				calendarItemTypeId =
					decryptedContent["calendarItemTypeId"].let {
						if (it != null) {
							usedEncryptedContent += "calendarItemTypeId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.calendarItemTypeId
						}
					},
				masterCalendarItemId =
					decryptedContent["masterCalendarItemId"].let {
						if (it != null) {
							usedEncryptedContent += "masterCalendarItemId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.masterCalendarItemId
						}
					},
				important =
					decryptedContent["important"].let {
						if (it != null) {
							usedEncryptedContent += "important"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.important
						}
					},
				homeVisit =
					decryptedContent["homeVisit"].let {
						if (it != null) {
							usedEncryptedContent += "homeVisit"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.homeVisit
						}
					},
				phoneNumber =
					decryptedContent["phoneNumber"].let {
						if (it != null) {
							usedEncryptedContent += "phoneNumber"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.phoneNumber
						}
					},
				placeId =
					decryptedContent["placeId"].let {
						if (it != null) {
							usedEncryptedContent += "placeId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.placeId
						}
					},
				address =
					decryptedContent["address"].let {
						if (it != null) {
							usedEncryptedContent += "address"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.address?.let {
								AddressDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = it,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				addressText =
					decryptedContent["addressText"].let {
						if (it != null) {
							usedEncryptedContent += "addressText"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.addressText
						}
					},
				startTime =
					decryptedContent["startTime"].let {
						if (it != null) {
							usedEncryptedContent += "startTime"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.startTime
						}
					},
				endTime =
					decryptedContent["endTime"].let {
						if (it != null) {
							usedEncryptedContent += "endTime"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.endTime
						}
					},
				confirmationTime =
					decryptedContent["confirmationTime"].let {
						if (it != null) {
							usedEncryptedContent += "confirmationTime"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.confirmationTime
						}
					},
				cancellationTimestamp =
					decryptedContent["cancellationTimestamp"].let {
						if (it != null) {
							usedEncryptedContent += "cancellationTimestamp"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.cancellationTimestamp
						}
					},
				confirmationId =
					decryptedContent["confirmationId"].let {
						if (it != null) {
							usedEncryptedContent += "confirmationId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.confirmationId
						}
					},
				duration =
					decryptedContent["duration"].let {
						if (it != null) {
							usedEncryptedContent += "duration"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.duration
						}
					},
				allDay =
					decryptedContent["allDay"].let {
						if (it != null) {
							usedEncryptedContent += "allDay"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.allDay
						}
					},
				details =
					decryptedContent["details"].let {
						if (it != null) {
							usedEncryptedContent += "details"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.details
						}
					},
				wasMigrated =
					decryptedContent["wasMigrated"].let {
						if (it != null) {
							usedEncryptedContent += "wasMigrated"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.wasMigrated
						}
					},
				agendaId =
					decryptedContent["agendaId"].let {
						if (it != null) {
							usedEncryptedContent += "agendaId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.agendaId
						}
					},
				resourceGroup =
					decryptedContent["resourceGroup"].let {
						if (it != null) {
							usedEncryptedContent += "resourceGroup"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.resourceGroup
						}
					},
				availabilitiesAssignmentStrategy = encryptedEntity.availabilitiesAssignmentStrategy,
				hcpId =
					decryptedContent["hcpId"].let {
						if (it != null) {
							usedEncryptedContent += "hcpId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.hcpId
						}
					},
				recurrenceId =
					decryptedContent["recurrenceId"].let {
						if (it != null) {
							usedEncryptedContent += "recurrenceId"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.recurrenceId
						}
					},
				meetingTags =
					decryptedContent["meetingTags"].let {
						if (it != null) {
							usedEncryptedContent += "meetingTags"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.meetingTags.mapTo(mutableSetOf()) { x0 ->
								CalendarItemTagDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				properties =
					decryptedContent["properties"].let {
						if (it != null) {
							usedEncryptedContent += "properties"
							encryptedContentDecoder.decodeFromJsonElement(it)
						} else {
							encryptedEntity.properties.mapTo(mutableSetOf()) { x0 ->
								PropertyStubDecryptor.decrypt(
									decryptionKeys = decryptionKeys,
									encryptedEntity = x0,
									patchDecryptedSelfJson = patchDecryptedSelfJson,
									ignoreUnknownDecryptedFields = ignoreUnknownDecryptedFields,
									encryptedContentDecoder = encryptedContentDecoder,
									cryptoService = cryptoService,
								)
							}
						}
					},
				secretForeignKeys = encryptedEntity.secretForeignKeys,
				cryptedForeignKeys = encryptedEntity.cryptedForeignKeys,
				delegations = encryptedEntity.delegations,
				encryptionKeys = encryptedEntity.encryptionKeys,
				encryptedSelf = encryptedEntity.encryptedSelf,
				securityMetadata = encryptedEntity.securityMetadata,
				extensions = encryptedEntity.extensions,
				extensionsVersion = encryptedEntity.extensionsVersion,
			)
		if (!ignoreUnknownDecryptedFields && decryptedContent.size != usedEncryptedContent.size) {
			throw EntityEncryptionException(
				"The CalendarItem encrypted content contains unexpected fields: ${decryptedContent.keys - usedEncryptedContent}",
			)
		}
		return result
	}
}

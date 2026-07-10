// This file is auto-generated
package com.icure.cardinal.sdk.crypto.encryptor.`impl`.generated

import com.icure.cardinal.sdk.crypto.encryptor.EncryptorFactoryContext
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.EntityEncryptorFactory
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.AbstractEntityEncryptor
import com.icure.cardinal.sdk.crypto.encryptor.`impl`.EncryptableFieldConfig
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.DecryptedPropertyStub
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedPropertyStub
import com.icure.cardinal.sdk.model.embed.DecryptedAddress
import com.icure.cardinal.sdk.model.embed.DecryptedCalendarItemTag
import com.icure.cardinal.sdk.model.embed.EncryptedAddress
import com.icure.cardinal.sdk.model.embed.EncryptedCalendarItemTag
import com.icure.kryptom.crypto.AesAlgorithm
import com.icure.kryptom.crypto.AesKey
import com.icure.kryptom.crypto.CryptoService
import com.icure.utils.InternalIcureApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

@InternalIcureApi
internal object CalendarItemEncryptorFactory :
	EntityEncryptorFactory<EncryptedCalendarItem, DecryptedCalendarItem> {
	override val empty: EntityEncryptor<EncryptedCalendarItem, DecryptedCalendarItem> =
		object :
			EntityEncryptor<EncryptedCalendarItem, DecryptedCalendarItem> {
			override suspend fun encrypt(
				encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
				clearEntity: DecryptedCalendarItem,
			): EncryptedCalendarItem =
				EncryptedCalendarItem(
					id = clearEntity.id,
					rev = clearEntity.rev,
					created = clearEntity.created,
					modified = clearEntity.modified,
					author = clearEntity.author,
					responsible = clearEntity.responsible,
					tags = clearEntity.tags,
					codes = clearEntity.codes,
					deletionDate = clearEntity.deletionDate,
					title = clearEntity.title,
					calendarItemTypeId = clearEntity.calendarItemTypeId,
					masterCalendarItemId = clearEntity.masterCalendarItemId,
					important = clearEntity.important,
					homeVisit = clearEntity.homeVisit,
					phoneNumber = clearEntity.phoneNumber,
					placeId = clearEntity.placeId,
					address =
						clearEntity.address?.let {
							AddressEncryptorFactory.empty.encrypt(encryptionKey, it)
						},
					addressText = clearEntity.addressText,
					startTime = clearEntity.startTime,
					endTime = clearEntity.endTime,
					confirmationTime = clearEntity.confirmationTime,
					cancellationTimestamp = clearEntity.cancellationTimestamp,
					confirmationId = clearEntity.confirmationId,
					duration = clearEntity.duration,
					allDay = clearEntity.allDay,
					details = clearEntity.details,
					wasMigrated = clearEntity.wasMigrated,
					agendaId = clearEntity.agendaId,
					resourceGroup = clearEntity.resourceGroup,
					availabilitiesAssignmentStrategy = clearEntity.availabilitiesAssignmentStrategy,
					hcpId = clearEntity.hcpId,
					recurrenceId = clearEntity.recurrenceId,
					meetingTags =
						clearEntity.meetingTags.mapTo(mutableSetOf()) { x0 ->
							CalendarItemTagEncryptorFactory.empty.encrypt(encryptionKey, x0)
						},
					properties =
						clearEntity.properties.mapTo(mutableSetOf()) { x0 ->
							PropertyStubEncryptorFactory.empty.encrypt(encryptionKey, x0)
						},
					secretForeignKeys = clearEntity.secretForeignKeys,
					cryptedForeignKeys = clearEntity.cryptedForeignKeys,
					delegations = clearEntity.delegations,
					encryptionKeys = clearEntity.encryptionKeys,
					encryptedSelf = null,
					securityMetadata = clearEntity.securityMetadata,
					extensions = clearEntity.extensions,
					extensionsVersion = clearEntity.extensionsVersion,
				)
		}

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EntityEncryptor<EncryptedCalendarItem, DecryptedCalendarItem> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return CalendarItemEncryptor(
			created_e = "created" in manifest.fieldsToEncrypt,
			modified_e = "modified" in manifest.fieldsToEncrypt,
			author_e = "author" in manifest.fieldsToEncrypt,
			responsible_e = "responsible" in manifest.fieldsToEncrypt,
			tags_e = "tags" in manifest.fieldsToEncrypt,
			codes_e = "codes" in manifest.fieldsToEncrypt,
			title_e = "title" in manifest.fieldsToEncrypt,
			calendarItemTypeId_e = "calendarItemTypeId" in manifest.fieldsToEncrypt,
			masterCalendarItemId_e = "masterCalendarItemId" in manifest.fieldsToEncrypt,
			important_e = "important" in manifest.fieldsToEncrypt,
			homeVisit_e = "homeVisit" in manifest.fieldsToEncrypt,
			phoneNumber_e = "phoneNumber" in manifest.fieldsToEncrypt,
			placeId_e = "placeId" in manifest.fieldsToEncrypt,
			address_e =
				if ("address" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["address"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedAddress::class,
								decryptedClass = DecryptedAddress::class,
							),
						)
					} ?: EncryptableFieldConfig.None(AddressEncryptorFactory)
				},
			addressText_e = "addressText" in manifest.fieldsToEncrypt,
			startTime_e = "startTime" in manifest.fieldsToEncrypt,
			endTime_e = "endTime" in manifest.fieldsToEncrypt,
			confirmationTime_e = "confirmationTime" in manifest.fieldsToEncrypt,
			cancellationTimestamp_e = "cancellationTimestamp" in manifest.fieldsToEncrypt,
			confirmationId_e = "confirmationId" in manifest.fieldsToEncrypt,
			duration_e = "duration" in manifest.fieldsToEncrypt,
			allDay_e = "allDay" in manifest.fieldsToEncrypt,
			details_e = "details" in manifest.fieldsToEncrypt,
			wasMigrated_e = "wasMigrated" in manifest.fieldsToEncrypt,
			agendaId_e = "agendaId" in manifest.fieldsToEncrypt,
			resourceGroup_e = "resourceGroup" in manifest.fieldsToEncrypt,
			hcpId_e = "hcpId" in manifest.fieldsToEncrypt,
			recurrenceId_e = "recurrenceId" in manifest.fieldsToEncrypt,
			meetingTags_e =
				if ("meetingTags" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["meetingTags"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedCalendarItemTag::class,
								decryptedClass = DecryptedCalendarItemTag::class,
							),
						)
					} ?: EncryptableFieldConfig.None(CalendarItemTagEncryptorFactory)
				},
			properties_e =
				if ("properties" in manifest.fieldsToEncrypt) {
					EncryptableFieldConfig.Full()
				} else {
					manifest.recursiveEncryption["properties"]?.let {
						EncryptableFieldConfig.Configured(
							encryptorFactoryContext.getEntityEncryptorProvider(
								entityManifestName = it,
								encryptedClass = EncryptedPropertyStub::class,
								decryptedClass = DecryptedPropertyStub::class,
							),
						)
					} ?: EncryptableFieldConfig.None(PropertyStubEncryptorFactory)
				},
			encodingJson = encodingJson,
			cryptoService = cryptoService,
		)
	}
}

@InternalIcureApi
private class CalendarItemEncryptor(
	private val created_e: Boolean,
	private val modified_e: Boolean,
	private val author_e: Boolean,
	private val responsible_e: Boolean,
	private val tags_e: Boolean,
	private val codes_e: Boolean,
	private val title_e: Boolean,
	private val calendarItemTypeId_e: Boolean,
	private val masterCalendarItemId_e: Boolean,
	private val important_e: Boolean,
	private val homeVisit_e: Boolean,
	private val phoneNumber_e: Boolean,
	private val placeId_e: Boolean,
	private val address_e: EncryptableFieldConfig<EncryptedAddress, DecryptedAddress>,
	private val addressText_e: Boolean,
	private val startTime_e: Boolean,
	private val endTime_e: Boolean,
	private val confirmationTime_e: Boolean,
	private val cancellationTimestamp_e: Boolean,
	private val confirmationId_e: Boolean,
	private val duration_e: Boolean,
	private val allDay_e: Boolean,
	private val details_e: Boolean,
	private val wasMigrated_e: Boolean,
	private val agendaId_e: Boolean,
	private val resourceGroup_e: Boolean,
	private val hcpId_e: Boolean,
	private val recurrenceId_e: Boolean,
	private val meetingTags_e: EncryptableFieldConfig<EncryptedCalendarItemTag, DecryptedCalendarItemTag>,
	private val properties_e: EncryptableFieldConfig<EncryptedPropertyStub, DecryptedPropertyStub>,
	private val encodingJson: Json,
	cryptoService: CryptoService,
) : AbstractEntityEncryptor<EncryptedCalendarItem, DecryptedCalendarItem>(cryptoService) {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedCalendarItem,
	): EncryptedCalendarItem {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (created_e && clearEntity.created != null) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified_e && clearEntity.modified != null) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author_e && clearEntity.author != null) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible_e && clearEntity.responsible != null) {
			dataToEncrypt["responsible"] =
				encodingJson.encodeToJsonElement(
					clearEntity.responsible,
				)
		}
		if (tags_e && clearEntity.tags.isNotEmpty()) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes_e && clearEntity.codes.isNotEmpty()) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (title_e && clearEntity.title != null) dataToEncrypt["title"] = encodingJson.encodeToJsonElement(clearEntity.title)
		if (calendarItemTypeId_e && clearEntity.calendarItemTypeId != null) {
			dataToEncrypt["calendarItemTypeId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.calendarItemTypeId,
				)
		}
		if (masterCalendarItemId_e && clearEntity.masterCalendarItemId != null) {
			dataToEncrypt["masterCalendarItemId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.masterCalendarItemId,
				)
		}
		if (important_e && clearEntity.important != null) dataToEncrypt["important"] = encodingJson.encodeToJsonElement(clearEntity.important)
		if (homeVisit_e && clearEntity.homeVisit != null) dataToEncrypt["homeVisit"] = encodingJson.encodeToJsonElement(clearEntity.homeVisit)
		if (phoneNumber_e && clearEntity.phoneNumber != null) {
			dataToEncrypt["phoneNumber"] =
				encodingJson.encodeToJsonElement(
					clearEntity.phoneNumber,
				)
		}
		if (placeId_e && clearEntity.placeId != null) dataToEncrypt["placeId"] = encodingJson.encodeToJsonElement(clearEntity.placeId)
		if (address_e.fullEncryption && clearEntity.address != null) {
			dataToEncrypt["address"] =
				encodingJson.encodeToJsonElement(
					clearEntity.address,
				)
		}
		if (addressText_e && clearEntity.addressText != null) {
			dataToEncrypt["addressText"] =
				encodingJson.encodeToJsonElement(
					clearEntity.addressText,
				)
		}
		if (startTime_e && clearEntity.startTime != null) dataToEncrypt["startTime"] = encodingJson.encodeToJsonElement(clearEntity.startTime)
		if (endTime_e && clearEntity.endTime != null) dataToEncrypt["endTime"] = encodingJson.encodeToJsonElement(clearEntity.endTime)
		if (confirmationTime_e && clearEntity.confirmationTime != null) {
			dataToEncrypt["confirmationTime"] =
				encodingJson.encodeToJsonElement(
					clearEntity.confirmationTime,
				)
		}
		if (cancellationTimestamp_e && clearEntity.cancellationTimestamp != null) {
			dataToEncrypt["cancellationTimestamp"] =
				encodingJson.encodeToJsonElement(
					clearEntity.cancellationTimestamp,
				)
		}
		if (confirmationId_e && clearEntity.confirmationId != null) {
			dataToEncrypt["confirmationId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.confirmationId,
				)
		}
		if (duration_e && clearEntity.duration != null) dataToEncrypt["duration"] = encodingJson.encodeToJsonElement(clearEntity.duration)
		if (allDay_e && clearEntity.allDay != null) dataToEncrypt["allDay"] = encodingJson.encodeToJsonElement(clearEntity.allDay)
		if (details_e && clearEntity.details != null) dataToEncrypt["details"] = encodingJson.encodeToJsonElement(clearEntity.details)
		if (wasMigrated_e && clearEntity.wasMigrated != null) {
			dataToEncrypt["wasMigrated"] =
				encodingJson.encodeToJsonElement(
					clearEntity.wasMigrated,
				)
		}
		if (agendaId_e && clearEntity.agendaId != null) dataToEncrypt["agendaId"] = encodingJson.encodeToJsonElement(clearEntity.agendaId)
		if (resourceGroup_e && clearEntity.resourceGroup != null) {
			dataToEncrypt["resourceGroup"] =
				encodingJson.encodeToJsonElement(
					clearEntity.resourceGroup,
				)
		}
		if (hcpId_e && clearEntity.hcpId != null) dataToEncrypt["hcpId"] = encodingJson.encodeToJsonElement(clearEntity.hcpId)
		if (recurrenceId_e && clearEntity.recurrenceId != null) {
			dataToEncrypt["recurrenceId"] =
				encodingJson.encodeToJsonElement(
					clearEntity.recurrenceId,
				)
		}
		if (meetingTags_e.fullEncryption && clearEntity.meetingTags.isNotEmpty()) {
			dataToEncrypt["meetingTags"] =
				encodingJson.encodeToJsonElement(
					clearEntity.meetingTags,
				)
		}
		if (properties_e.fullEncryption && clearEntity.properties.isNotEmpty()) {
			dataToEncrypt["properties"] =
				encodingJson.encodeToJsonElement(
					clearEntity.properties,
				)
		}
		return EncryptedCalendarItem(
			id = clearEntity.id,
			rev = clearEntity.rev,
			created = if (created_e) null else clearEntity.created,
			modified = if (modified_e) null else clearEntity.modified,
			author = if (author_e) null else clearEntity.author,
			responsible = if (responsible_e) null else clearEntity.responsible,
			tags = if (tags_e) emptySet() else clearEntity.tags,
			codes = if (codes_e) emptySet() else clearEntity.codes,
			deletionDate = clearEntity.deletionDate,
			title = if (title_e) null else clearEntity.title,
			calendarItemTypeId = if (calendarItemTypeId_e) null else clearEntity.calendarItemTypeId,
			masterCalendarItemId = if (masterCalendarItemId_e) null else clearEntity.masterCalendarItemId,
			important = if (important_e) null else clearEntity.important,
			homeVisit = if (homeVisit_e) null else clearEntity.homeVisit,
			phoneNumber = if (phoneNumber_e) null else clearEntity.phoneNumber,
			placeId = if (placeId_e) null else clearEntity.placeId,
			address =
				address_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						null
					} else {
						clearEntity.address?.let {
							encryptor.encrypt(encryptionKey, it)
						}
					}
				},
			addressText = if (addressText_e) null else clearEntity.addressText,
			startTime = if (startTime_e) null else clearEntity.startTime,
			endTime = if (endTime_e) null else clearEntity.endTime,
			confirmationTime = if (confirmationTime_e) null else clearEntity.confirmationTime,
			cancellationTimestamp = if (cancellationTimestamp_e) null else clearEntity.cancellationTimestamp,
			confirmationId = if (confirmationId_e) null else clearEntity.confirmationId,
			duration = if (duration_e) null else clearEntity.duration,
			allDay = if (allDay_e) null else clearEntity.allDay,
			details = if (details_e) null else clearEntity.details,
			wasMigrated = if (wasMigrated_e) null else clearEntity.wasMigrated,
			agendaId = if (agendaId_e) null else clearEntity.agendaId,
			resourceGroup = if (resourceGroup_e) null else clearEntity.resourceGroup,
			availabilitiesAssignmentStrategy = clearEntity.availabilitiesAssignmentStrategy,
			hcpId = if (hcpId_e) null else clearEntity.hcpId,
			recurrenceId = if (recurrenceId_e) null else clearEntity.recurrenceId,
			meetingTags =
				meetingTags_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptySet()
					} else {
						clearEntity.meetingTags.mapTo(mutableSetOf()) { x0 ->
							encryptor.encrypt(encryptionKey, x0)
						}
					}
				},
			properties =
				properties_e.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptySet()
					} else {
						clearEntity.properties.mapTo(mutableSetOf()) { x0 ->
							encryptor.encrypt(encryptionKey, x0)
						}
					}
				},
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt)),
			securityMetadata = clearEntity.securityMetadata,
			extensions = clearEntity.extensions,
			extensionsVersion = clearEntity.extensionsVersion,
		)
	}
}

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
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlin.Boolean
import kotlin.String

internal object CalendarItemEncryptorFactory :
	EntityEncryptorFactory<EncryptedCalendarItem, DecryptedCalendarItem> {
	override val empty: EntityEncryptor<EncryptedCalendarItem, DecryptedCalendarItem> =
		CalendarItemEncryptor(
			created = false,
			modified = false,
			author = false,
			responsible = false,
			tags = false,
			codes = false,
			title = false,
			calendarItemTypeId = false,
			masterCalendarItemId = false,
			important = false,
			homeVisit = false,
			phoneNumber = false,
			placeId = false,
			address = EncryptableFieldConfig.None(AddressEncryptorFactory),
			addressText = false,
			startTime = false,
			endTime = false,
			confirmationTime = false,
			cancellationTimestamp = false,
			confirmationId = false,
			duration = false,
			allDay = false,
			details = false,
			wasMigrated = false,
			agendaId = false,
			resourceGroup = false,
			hcpId = false,
			recurrenceId = false,
			meetingTags = EncryptableFieldConfig.None(CalendarItemTagEncryptorFactory),
			properties = EncryptableFieldConfig.None(PropertyStubEncryptorFactory),
		)

	override fun create(
		entityManifestName: String,
		encryptorFactoryContext: EncryptorFactoryContext,
	): EntityEncryptor<EncryptedCalendarItem, DecryptedCalendarItem> {
		val manifest = encryptorFactoryContext.getManifest(entityManifestName)
		return CalendarItemEncryptor(
			created = "created" in manifest.fieldsToEncrypt,
			modified = "modified" in manifest.fieldsToEncrypt,
			author = "author" in manifest.fieldsToEncrypt,
			responsible = "responsible" in manifest.fieldsToEncrypt,
			tags = "tags" in manifest.fieldsToEncrypt,
			codes = "codes" in manifest.fieldsToEncrypt,
			title = "title" in manifest.fieldsToEncrypt,
			calendarItemTypeId = "calendarItemTypeId" in manifest.fieldsToEncrypt,
			masterCalendarItemId = "masterCalendarItemId" in manifest.fieldsToEncrypt,
			important = "important" in manifest.fieldsToEncrypt,
			homeVisit = "homeVisit" in manifest.fieldsToEncrypt,
			phoneNumber = "phoneNumber" in manifest.fieldsToEncrypt,
			placeId = "placeId" in manifest.fieldsToEncrypt,
			address =
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
			addressText = "addressText" in manifest.fieldsToEncrypt,
			startTime = "startTime" in manifest.fieldsToEncrypt,
			endTime = "endTime" in manifest.fieldsToEncrypt,
			confirmationTime = "confirmationTime" in manifest.fieldsToEncrypt,
			cancellationTimestamp = "cancellationTimestamp" in manifest.fieldsToEncrypt,
			confirmationId = "confirmationId" in manifest.fieldsToEncrypt,
			duration = "duration" in manifest.fieldsToEncrypt,
			allDay = "allDay" in manifest.fieldsToEncrypt,
			details = "details" in manifest.fieldsToEncrypt,
			wasMigrated = "wasMigrated" in manifest.fieldsToEncrypt,
			agendaId = "agendaId" in manifest.fieldsToEncrypt,
			resourceGroup = "resourceGroup" in manifest.fieldsToEncrypt,
			hcpId = "hcpId" in manifest.fieldsToEncrypt,
			recurrenceId = "recurrenceId" in manifest.fieldsToEncrypt,
			meetingTags =
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
			properties =
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
		)
	}
}

private class CalendarItemEncryptor(
	private val created: Boolean,
	private val modified: Boolean,
	private val author: Boolean,
	private val responsible: Boolean,
	private val tags: Boolean,
	private val codes: Boolean,
	private val title: Boolean,
	private val calendarItemTypeId: Boolean,
	private val masterCalendarItemId: Boolean,
	private val important: Boolean,
	private val homeVisit: Boolean,
	private val phoneNumber: Boolean,
	private val placeId: Boolean,
	private val address: EncryptableFieldConfig<EncryptedAddress, DecryptedAddress>,
	private val addressText: Boolean,
	private val startTime: Boolean,
	private val endTime: Boolean,
	private val confirmationTime: Boolean,
	private val cancellationTimestamp: Boolean,
	private val confirmationId: Boolean,
	private val duration: Boolean,
	private val allDay: Boolean,
	private val details: Boolean,
	private val wasMigrated: Boolean,
	private val agendaId: Boolean,
	private val resourceGroup: Boolean,
	private val hcpId: Boolean,
	private val recurrenceId: Boolean,
	private val meetingTags: EncryptableFieldConfig<EncryptedCalendarItemTag, DecryptedCalendarItemTag>,
	private val properties: EncryptableFieldConfig<EncryptedPropertyStub, DecryptedPropertyStub>,
) : AbstractEntityEncryptor<EncryptedCalendarItem, DecryptedCalendarItem>() {
	override suspend fun encrypt(
		encryptionKey: AesKey<AesAlgorithm.CbcWithPkcs7Padding>,
		clearEntity: DecryptedCalendarItem,
		encodingJson: Json,
		cryptoService: CryptoService,
	): EncryptedCalendarItem {
		val dataToEncrypt = mutableMapOf<String, JsonElement>()
		if (created) dataToEncrypt["created"] = encodingJson.encodeToJsonElement(clearEntity.created)
		if (modified) dataToEncrypt["modified"] = encodingJson.encodeToJsonElement(clearEntity.modified)
		if (author) dataToEncrypt["author"] = encodingJson.encodeToJsonElement(clearEntity.author)
		if (responsible) dataToEncrypt["responsible"] = encodingJson.encodeToJsonElement(clearEntity.responsible)
		if (tags) dataToEncrypt["tags"] = encodingJson.encodeToJsonElement(clearEntity.tags)
		if (codes) dataToEncrypt["codes"] = encodingJson.encodeToJsonElement(clearEntity.codes)
		if (title) dataToEncrypt["title"] = encodingJson.encodeToJsonElement(clearEntity.title)
		if (calendarItemTypeId) dataToEncrypt["calendarItemTypeId"] = encodingJson.encodeToJsonElement(clearEntity.calendarItemTypeId)
		if (masterCalendarItemId) dataToEncrypt["masterCalendarItemId"] = encodingJson.encodeToJsonElement(clearEntity.masterCalendarItemId)
		if (important) dataToEncrypt["important"] = encodingJson.encodeToJsonElement(clearEntity.important)
		if (homeVisit) dataToEncrypt["homeVisit"] = encodingJson.encodeToJsonElement(clearEntity.homeVisit)
		if (phoneNumber) dataToEncrypt["phoneNumber"] = encodingJson.encodeToJsonElement(clearEntity.phoneNumber)
		if (placeId) dataToEncrypt["placeId"] = encodingJson.encodeToJsonElement(clearEntity.placeId)
		if (address.fullEncryption) dataToEncrypt["address"] = encodingJson.encodeToJsonElement(clearEntity.address)
		if (addressText) dataToEncrypt["addressText"] = encodingJson.encodeToJsonElement(clearEntity.addressText)
		if (startTime) dataToEncrypt["startTime"] = encodingJson.encodeToJsonElement(clearEntity.startTime)
		if (endTime) dataToEncrypt["endTime"] = encodingJson.encodeToJsonElement(clearEntity.endTime)
		if (confirmationTime) dataToEncrypt["confirmationTime"] = encodingJson.encodeToJsonElement(clearEntity.confirmationTime)
		if (cancellationTimestamp) dataToEncrypt["cancellationTimestamp"] = encodingJson.encodeToJsonElement(clearEntity.cancellationTimestamp)
		if (confirmationId) dataToEncrypt["confirmationId"] = encodingJson.encodeToJsonElement(clearEntity.confirmationId)
		if (duration) dataToEncrypt["duration"] = encodingJson.encodeToJsonElement(clearEntity.duration)
		if (allDay) dataToEncrypt["allDay"] = encodingJson.encodeToJsonElement(clearEntity.allDay)
		if (details) dataToEncrypt["details"] = encodingJson.encodeToJsonElement(clearEntity.details)
		if (wasMigrated) dataToEncrypt["wasMigrated"] = encodingJson.encodeToJsonElement(clearEntity.wasMigrated)
		if (agendaId) dataToEncrypt["agendaId"] = encodingJson.encodeToJsonElement(clearEntity.agendaId)
		if (resourceGroup) dataToEncrypt["resourceGroup"] = encodingJson.encodeToJsonElement(clearEntity.resourceGroup)
		if (hcpId) dataToEncrypt["hcpId"] = encodingJson.encodeToJsonElement(clearEntity.hcpId)
		if (recurrenceId) dataToEncrypt["recurrenceId"] = encodingJson.encodeToJsonElement(clearEntity.recurrenceId)
		if (meetingTags.fullEncryption) dataToEncrypt["meetingTags"] = encodingJson.encodeToJsonElement(clearEntity.meetingTags)
		if (properties.fullEncryption) dataToEncrypt["properties"] = encodingJson.encodeToJsonElement(clearEntity.properties)
		return EncryptedCalendarItem(
			id = clearEntity.id,
			rev = clearEntity.rev,
			created = if (created) null else clearEntity.created,
			modified = if (modified) null else clearEntity.modified,
			author = if (author) null else clearEntity.author,
			responsible = if (responsible) null else clearEntity.responsible,
			tags = if (tags) emptySet() else clearEntity.tags,
			codes = if (codes) emptySet() else clearEntity.codes,
			deletionDate = clearEntity.deletionDate,
			title = if (title) null else clearEntity.title,
			calendarItemTypeId = if (calendarItemTypeId) null else clearEntity.calendarItemTypeId,
			masterCalendarItemId = if (masterCalendarItemId) null else clearEntity.masterCalendarItemId,
			important = if (important) null else clearEntity.important,
			homeVisit = if (homeVisit) null else clearEntity.homeVisit,
			phoneNumber = if (phoneNumber) null else clearEntity.phoneNumber,
			placeId = if (placeId) null else clearEntity.placeId,
			address =
				address.encryptor.let { encryptor ->
					if (encryptor == null) {
						null
					} else {
						clearEntity.address?.let {
							encryptor.encrypt(encryptionKey, it, encodingJson, cryptoService)
						}
					}
				},
			addressText = if (addressText) null else clearEntity.addressText,
			startTime = if (startTime) null else clearEntity.startTime,
			endTime = if (endTime) null else clearEntity.endTime,
			confirmationTime = if (confirmationTime) null else clearEntity.confirmationTime,
			cancellationTimestamp = if (cancellationTimestamp) null else clearEntity.cancellationTimestamp,
			confirmationId = if (confirmationId) null else clearEntity.confirmationId,
			duration = if (duration) null else clearEntity.duration,
			allDay = if (allDay) null else clearEntity.allDay,
			details = if (details) null else clearEntity.details,
			wasMigrated = if (wasMigrated) null else clearEntity.wasMigrated,
			agendaId = if (agendaId) null else clearEntity.agendaId,
			resourceGroup = if (resourceGroup) null else clearEntity.resourceGroup,
			availabilitiesAssignmentStrategy = clearEntity.availabilitiesAssignmentStrategy,
			hcpId = if (hcpId) null else clearEntity.hcpId,
			recurrenceId = if (recurrenceId) null else clearEntity.recurrenceId,
			meetingTags =
				meetingTags.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptySet()
					} else {
						clearEntity.meetingTags.mapTo(mutableSetOf()) { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			properties =
				properties.encryptor.let { encryptor ->
					if (encryptor == null) {
						emptySet()
					} else {
						clearEntity.properties.mapTo(mutableSetOf()) { x0 ->
							encryptor.encrypt(encryptionKey, x0, encodingJson, cryptoService)
						}
					}
				},
			secretForeignKeys = clearEntity.secretForeignKeys,
			cryptedForeignKeys = clearEntity.cryptedForeignKeys,
			delegations = clearEntity.delegations,
			encryptionKeys = clearEntity.encryptionKeys,
			encryptedSelf = getUpdatedEncryptSelf(encryptionKey, clearEntity, JsonObject(dataToEncrypt), cryptoService),
			securityMetadata = clearEntity.securityMetadata,
			extensions = clearEntity.extensions,
			extensionsVersion = clearEntity.extensionsVersion,
		)
	}
}

package com.icure.cardinal.sdk.options

import com.icure.cardinal.sdk.crypto.JsonEncryptionService
import com.icure.cardinal.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.utils.InternalIcureApi

/**
 * Parse the fields on api initialization to avoid late throw of errors
 */
@InternalIcureApi
internal class EntitiesEncryptedFieldsManifests private constructor(
	val accessLog: EncryptedFieldsManifest,
	val calendarItem: EncryptedFieldsManifest,
	val contact: EncryptedFieldsManifest,
	val serviceBase: EncryptedFieldsManifest,
	val healthElement: EncryptedFieldsManifest,
	val maintenanceTask: EncryptedFieldsManifest,
	val patient: EncryptedFieldsManifest,
	val message: EncryptedFieldsManifest,
	val topic: EncryptedFieldsManifest,
	val document: EncryptedFieldsManifest,
	val timeTable: EncryptedFieldsManifest,
	val classification: EncryptedFieldsManifest,
	val form: EncryptedFieldsManifest,
	val invoice: EncryptedFieldsManifest,
	val receipt: EncryptedFieldsManifest,
	val relatedPerson: EncryptedFieldsManifest,
) {
	companion object {
		fun fromEncryptedFields(encryptedFields: EncryptedFieldsConfiguration): EntitiesEncryptedFieldsManifests {
			val contactManifest = JsonEncryptionService.parseEncryptedFields(
				encryptedFields.contact,
				"Contact."
			)
			require("services" !in contactManifest.allKeys) {
				"You can't customise encryption of the `services` field of Contact. Use the serviceEncryptedKeys parameter instead."
			}
			val serviceManifest = JsonEncryptionService.parseEncryptedFields(
				encryptedFields.service,
				"Service."
			)
			require("content" !in serviceManifest.allKeys) {
				"You can't customise encryption of the `content` of a Service. The content values for services is automatically encrypted."
			}
			return EntitiesEncryptedFieldsManifests(
				contact = contactManifest,
				serviceBase = serviceManifest,
				accessLog = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.accessLog,
					"AccessLog."
				),
				calendarItem = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.calendarItem,
					"CalendarItem."
				),
				healthElement = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.healthElement,
					"HealthElement."
				),
				maintenanceTask = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.maintenanceTask,
					"MaintenanceTask."
				),
				patient = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.patient,
					"Patient."
				),
				message = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.message,
					"Message."
				),
				topic = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.topic,
					"Topic."
				),
				document = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.document,
					"Document."
				),
				timeTable = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.timeTable,
					"TimeTable."
				),
				classification = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.classification,
					"Classification."
				),
				form = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.form,
					"Form."
				),
				invoice = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.invoice,
					"Invoice."
				),
				receipt = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.receipt ,
					"Receipt."
				),
				relatedPerson = JsonEncryptionService.parseEncryptedFields(
					encryptedFields.relatedPerson,
					"RelatedPerson."
				)
			)
		}
	}

	val serviceWithContent: EncryptedFieldsManifest = serviceBase.copy(topLevelFields = serviceBase.topLevelFields + "content")
}

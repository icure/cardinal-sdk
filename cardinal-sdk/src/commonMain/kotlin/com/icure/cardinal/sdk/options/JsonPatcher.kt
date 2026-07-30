package com.icure.cardinal.sdk.options

import kotlinx.serialization.json.JsonElement

/**
 * Provides methods to patch the json representing a certain type of entity after decryption and before validation and
 * proper deserialization.
 * Each of these methods takes in input the parsed json of the decrypted entity and must return the patched json.
 * All the patchers are optional, if you don't define a patcher the json of the entity will be used by the sdk as is
 * without any patching.
 */
interface JsonPatcher {
	/**
	 * Patches the decrypted json of an AccessLog
	 */
	fun patchAccessLog(decryptedJson: JsonElement): JsonElement = decryptedJson
	/**
	 * Patches the decrypted json of a CalendarItem
	 */
	fun patchCalendarItem(decryptedJson: JsonElement): JsonElement = decryptedJson
	/**
	 * Patches the decrypted json of a Contact
	 */
	fun patchContact(decryptedJson: JsonElement): JsonElement = decryptedJson
	/**
	 * Patches the decrypted json of a Service.
	 * This method is used only when a service is retrieved by itself, without the rest of the contact.
	 * Services retrieved as part of a contact should be patched with [patchContact]
	 */
	fun patchIndividualService(decryptedJson: JsonElement): JsonElement = decryptedJson
	/**
	 * Patches the decrypted json of a HealthElement
	 */
	fun patchHealthElement(decryptedJson: JsonElement): JsonElement = decryptedJson
	/**
	 * Patches the decrypted json of a MaintenanceTask
	 */
	fun patchMaintenanceTask(decryptedJson: JsonElement): JsonElement = decryptedJson
	/**
	 * Patches the decrypted json of a Patient
	 */
	fun patchPatient(decryptedJson: JsonElement): JsonElement = decryptedJson
	/**
	 * Patches the decrypted json of a Message
	 */
	fun patchMessage(decryptedJson: JsonElement): JsonElement = decryptedJson
	/**
	 * Patches the decrypted json of a Topic
	 */
	fun patchTopic(decryptedJson: JsonElement): JsonElement = decryptedJson
	/**
	 * Patches the decrypted json of a Document
	 */
	fun patchDocument(decryptedJson: JsonElement): JsonElement = decryptedJson
	/**
	 * Patches the decrypted json of a Form
	 */
	fun patchForm(decryptedJson: JsonElement): JsonElement = decryptedJson
	/**
	 * Patches the decrypted json of a RelatedPerson
	 */
	fun patchRelatedPerson(decryptedJson: JsonElement): JsonElement = decryptedJson
	/**
	 * Patches the decrypted json of a Receipt
	 */
	fun patchReceipt(decryptedJson: JsonElement): JsonElement = decryptedJson
	/**
	 * Patches the decrypted json of a Classification
	 */
	fun patchClassification(decryptedJson: JsonElement): JsonElement = decryptedJson
	/**
	 * Patches the decrypted json of a TimeTable
	 */
	fun patchTimeTable(decryptedJson: JsonElement): JsonElement = decryptedJson
	/**
	 * Patches the decrypted json of a Invoice
	 */
	fun patchInvoice(decryptedJson: JsonElement): JsonElement = decryptedJson
}
 
package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.model.DecryptedAccessLog
import com.icure.cardinal.sdk.model.DecryptedCalendarItem
import com.icure.cardinal.sdk.model.DecryptedClassification
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.DecryptedForm
import com.icure.cardinal.sdk.model.DecryptedHealthElement
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.DecryptedMaintenanceTask
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.DecryptedReceipt
import com.icure.cardinal.sdk.model.DecryptedTopic
import com.icure.cardinal.sdk.model.EncryptedAccessLog
import com.icure.cardinal.sdk.model.EncryptedCalendarItem
import com.icure.cardinal.sdk.model.EncryptedClassification
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.model.EncryptedForm
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.EncryptedMaintenanceTask
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.EncryptedReceipt
import com.icure.cardinal.sdk.model.EncryptedTopic

internal data class RootEntitiesEncryptors(
	val accessLog: EntityEncryptor<EncryptedAccessLog, DecryptedAccessLog>,
	val calendarItem: EntityEncryptor<EncryptedCalendarItem, DecryptedCalendarItem>,
	val contact: EntityEncryptor<EncryptedContact, DecryptedContact>,
	val healthElement: EntityEncryptor<EncryptedHealthElement, DecryptedHealthElement>,
	val maintenanceTask: EntityEncryptor<EncryptedMaintenanceTask, DecryptedMaintenanceTask>,
	val patient: EntityEncryptor<EncryptedPatient, DecryptedPatient>,
	val message: EntityEncryptor<EncryptedMessage, DecryptedMessage>,
	val topic: EntityEncryptor<EncryptedTopic, DecryptedTopic>,
	val document: EntityEncryptor<EncryptedDocument, DecryptedDocument>,
	val form: EntityEncryptor<EncryptedForm, DecryptedForm>,
	val receipt: EntityEncryptor<EncryptedReceipt, DecryptedReceipt>,
	val classification: EntityEncryptor<EncryptedClassification, DecryptedClassification>,
	val invoice: EntityEncryptor<EncryptedInvoice, DecryptedInvoice>,
)
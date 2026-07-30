package com.icure.cardinal.sdk.crypto.encryptor

import com.icure.cardinal.sdk.crypto.encryptor.impl.generated.ContactDecryptor
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
import com.icure.cardinal.sdk.model.DecryptedRelatedPerson
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
import com.icure.cardinal.sdk.model.EncryptedRelatedPerson
import com.icure.cardinal.sdk.model.EncryptedTopic
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal data class RootEntitiesEncryptors(
	val accessLog: EntityEncryptors<EncryptedAccessLog, DecryptedAccessLog>,
	val calendarItem: EntityEncryptors<EncryptedCalendarItem, DecryptedCalendarItem>,
	val contact: EntityEncryptors<EncryptedContact, DecryptedContact>,
	val healthElement: EntityEncryptors<EncryptedHealthElement, DecryptedHealthElement>,
	val patient: EntityEncryptors<EncryptedPatient, DecryptedPatient>,
	val message: EntityEncryptors<EncryptedMessage, DecryptedMessage>,
	val topic: EntityEncryptors<EncryptedTopic, DecryptedTopic>,
	val document: EntityEncryptors<EncryptedDocument, DecryptedDocument>,
	val form: EntityEncryptors<EncryptedForm, DecryptedForm>,
	val receipt: EntityEncryptors<EncryptedReceipt, DecryptedReceipt>,
	val classification: EntityEncryptors<EncryptedClassification, DecryptedClassification>,
	val invoice: EntityEncryptors<EncryptedInvoice, DecryptedInvoice>,
	val relatedPerson: EntityEncryptors<EncryptedRelatedPerson, DecryptedRelatedPerson>,
) {
	val serviceDecryptor = (contact.decryptor as ContactDecryptor).servicesDecryptor.value
}
// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.ContactShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.ContactJs
import com.icure.cardinal.sdk.js.model.DecryptedContactJs
import com.icure.cardinal.sdk.js.model.EncryptedContactJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedServiceJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedServiceJs
import com.icure.cardinal.sdk.js.model.embed.ServiceJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ContactApi")
public external interface ContactApiJs {
	public val encrypted: ContactFlavouredApiJs<EncryptedContactJs, EncryptedServiceJs>

	public val tryAndRecover: ContactFlavouredApiJs<ContactJs, ServiceJs>

	public val inGroup: ContactInGroupApiJs

	public fun matchContactsBy(filter: FilterOptionsJs<ContactJs>): Promise<Array<String>>

	public fun matchServicesBy(filter: FilterOptionsJs<ServiceJs>): Promise<Array<String>>

	public fun matchContactsBySorted(filter: SortableFilterOptionsJs<ContactJs>):
			Promise<Array<String>>

	public fun matchServicesBySorted(filter: SortableFilterOptionsJs<ServiceJs>):
			Promise<Array<String>>

	public fun withEncryptionMetadata(
		base: DecryptedContactJs?,
		patient: PatientJs,
		options: dynamic,
	): Promise<DecryptedContactJs>

	public fun getEncryptionKeysOf(contact: ContactJs): Promise<Array<String>>

	public fun hasWriteAccess(contact: ContactJs): Promise<Boolean>

	public fun decryptPatientIdOf(contact: ContactJs): Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: ContactJs, delegates: Array<String>):
			Promise<Unit>

	public fun decrypt(contact: EncryptedContactJs): Promise<DecryptedContactJs>

	public fun tryDecrypt(contact: EncryptedContactJs): Promise<ContactJs>

	public fun decryptService(service: EncryptedServiceJs): Promise<DecryptedServiceJs>

	public fun tryDecryptService(service: EncryptedServiceJs): Promise<ServiceJs>

	public fun subscribeToServiceCreateOrUpdateEvents(filter: FilterOptionsJs<ServiceJs>,
			options: dynamic): Promise<EntitySubscriptionJs<EncryptedServiceJs>>

	public fun deleteContactById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>

	public fun deleteContactsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeContactById(id: String, rev: String): Promise<Unit>

	public fun purgeContactsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deleteContact(contact: ContactJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteContacts(contacts: Array<ContactJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeContact(contact: ContactJs): Promise<Unit>

	public fun purgeContacts(contacts: Array<ContactJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun getServiceCodesOccurrences(codeType: String, minOccurrences: Double):
			Promise<Array<LabelledOccurenceJs>>

	public fun shareWith(
		delegateId: String,
		contact: DecryptedContactJs,
		options: dynamic,
	): Promise<DecryptedContactJs>

	public fun shareWithMany(contact: DecryptedContactJs,
			delegates: Record<String, ContactShareOptionsJs>): Promise<DecryptedContactJs>

	public fun filterContactsBy(filter: FilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<DecryptedContactJs>>

	public fun filterServicesBy(filter: FilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<DecryptedServiceJs>>

	public fun filterContactsBySorted(filter: SortableFilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<DecryptedContactJs>>

	public fun filterServicesBySorted(filter: SortableFilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<DecryptedServiceJs>>

	public fun createContact(entity: DecryptedContactJs): Promise<DecryptedContactJs>

	public fun createContacts(entities: Array<DecryptedContactJs>): Promise<Array<DecryptedContactJs>>

	public fun undeleteContactById(id: String, rev: String): Promise<DecryptedContactJs>

	public fun undeleteContactsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedContactJs>>

	public fun undeleteContact(contact: ContactJs): Promise<DecryptedContactJs>

	public fun undeleteContacts(contacts: Array<ContactJs>): Promise<Array<DecryptedContactJs>>

	public fun modifyContact(entity: DecryptedContactJs): Promise<DecryptedContactJs>

	public fun modifyContacts(entities: Array<DecryptedContactJs>): Promise<Array<DecryptedContactJs>>

	public fun getContact(entityId: String): Promise<DecryptedContactJs?>

	public fun getContacts(entityIds: Array<String>): Promise<Array<DecryptedContactJs>>

	public fun getService(serviceId: String): Promise<DecryptedServiceJs?>

	public fun getServices(entityIds: Array<String>): Promise<Array<DecryptedServiceJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<ContactJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedContactJs>>
}

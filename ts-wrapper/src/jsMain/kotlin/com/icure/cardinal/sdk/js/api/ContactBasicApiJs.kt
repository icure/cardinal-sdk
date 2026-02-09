// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.ContactJs
import com.icure.cardinal.sdk.js.model.EncryptedContactJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedServiceJs
import com.icure.cardinal.sdk.js.model.embed.ServiceJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ContactBasicApi")
public external interface ContactBasicApiJs {
	public val inGroup: ContactBasicInGroupApiJs

	public fun matchContactsBy(filter: BaseFilterOptionsJs<ContactJs>): Promise<Array<String>>

	public fun matchServicesBy(filter: BaseFilterOptionsJs<ServiceJs>): Promise<Array<String>>

	public fun matchContactsBySorted(filter: BaseSortableFilterOptionsJs<ContactJs>):
			Promise<Array<String>>

	public fun matchServicesBySorted(filter: BaseSortableFilterOptionsJs<ServiceJs>):
			Promise<Array<String>>

	public fun filterContactsBy(filter: BaseFilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<EncryptedContactJs>>

	public fun filterServicesBy(filter: BaseFilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<EncryptedServiceJs>>

	public fun filterContactsBySorted(filter: BaseSortableFilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<EncryptedContactJs>>

	public fun filterServicesBySorted(filter: BaseSortableFilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<EncryptedServiceJs>>

	public fun subscribeToServiceCreateOrUpdateEvents(filter: BaseFilterOptionsJs<ServiceJs>,
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

	public fun createContact(entity: EncryptedContactJs): Promise<EncryptedContactJs>

	public fun createContacts(entities: Array<EncryptedContactJs>): Promise<Array<EncryptedContactJs>>

	public fun undeleteContactById(id: String, rev: String): Promise<EncryptedContactJs>

	public fun undeleteContactsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<EncryptedContactJs>>

	public fun undeleteContact(contact: ContactJs): Promise<EncryptedContactJs>

	public fun undeleteContacts(contacts: Array<ContactJs>): Promise<Array<EncryptedContactJs>>

	public fun modifyContact(entity: EncryptedContactJs): Promise<EncryptedContactJs>

	public fun modifyContacts(entities: Array<EncryptedContactJs>): Promise<Array<EncryptedContactJs>>

	public fun getContact(entityId: String): Promise<EncryptedContactJs?>

	public fun getContacts(entityIds: Array<String>): Promise<Array<EncryptedContactJs>>

	public fun getService(serviceId: String): Promise<EncryptedServiceJs?>

	public fun getServices(entityIds: Array<String>): Promise<Array<EncryptedServiceJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<ContactJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedContactJs>>
}

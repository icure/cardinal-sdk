// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.ContactShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.ContactJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.embed.ServiceJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ContactFlavouredApi")
public external interface ContactFlavouredApiJs<E : ContactJs, S : ServiceJs> {
	public fun shareWith(
		delegateId: String,
		contact: E,
		options: dynamic,
	): Promise<E>

	public fun shareWithMany(contact: E, delegates: Record<String, ContactShareOptionsJs>): Promise<E>

	public fun filterContactsBy(filter: FilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun filterServicesBy(filter: FilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<S>>

	public fun filterContactsBySorted(filter: SortableFilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun filterServicesBySorted(filter: SortableFilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<S>>

	public fun createContact(entity: E): Promise<E>

	public fun createContacts(entities: Array<E>): Promise<Array<E>>

	public fun undeleteContactById(id: String, rev: String): Promise<E>

	public fun undeleteContactsByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<E>>

	public fun undeleteContact(contact: ContactJs): Promise<E>

	public fun undeleteContacts(contacts: Array<ContactJs>): Promise<Array<E>>

	public fun modifyContact(entity: E): Promise<E>

	public fun modifyContacts(entities: Array<E>): Promise<Array<E>>

	public fun getContact(entityId: String): Promise<E?>

	public fun getContacts(entityIds: Array<String>): Promise<Array<E>>

	public fun getService(serviceId: String): Promise<S?>

	public fun getServices(entityIds: Array<String>): Promise<Array<S>>
}

// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.ContactJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.embed.ServiceJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToContactShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ContactFlavouredInGroupApi")
public external interface ContactFlavouredInGroupApiJs<E : ContactJs, S : ServiceJs> {
	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		contact: GroupScopedJs<E>,
		options: dynamic,
	): Promise<GroupScopedJs<E>>

	public fun shareWithMany(contact: GroupScopedJs<E>,
			delegates: Array<EntityReferenceInGroupToContactShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<E>>

	public fun filterContactsBy(groupId: String, filter: FilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun filterContactsBySorted(groupId: String, filter: SortableFilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun createContact(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun createContacts(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun undeleteContactById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<E>>

	public fun undeleteContactsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun undeleteContact(contact: GroupScopedJs<ContactJs>): Promise<GroupScopedJs<E>>

	public fun undeleteContacts(contacts: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun modifyContact(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun modifyContacts(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun getContact(groupId: String, entityId: String): Promise<GroupScopedJs<E>?>

	public fun getContacts(groupId: String, entityIds: Array<String>): Promise<Array<GroupScopedJs<E>>>

	public fun getService(groupId: String, serviceId: String): Promise<GroupScopedJs<S>?>

	public fun getServices(groupId: String, entityIds: Array<String>): Promise<Array<GroupScopedJs<S>>>
}

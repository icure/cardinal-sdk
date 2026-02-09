// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.ContactJs
import com.icure.cardinal.sdk.js.model.EncryptedContactJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedServiceJs
import com.icure.cardinal.sdk.js.model.embed.ServiceJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ContactBasicInGroupApi")
public external interface ContactBasicInGroupApiJs {
	public fun matchContactsBy(groupId: String, filter: BaseFilterOptionsJs<ContactJs>):
			Promise<Array<String>>

	public fun matchContactsBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<ContactJs>):
			Promise<Array<String>>

	public fun matchServicesBy(groupId: String, filter: BaseFilterOptionsJs<ServiceJs>):
			Promise<Array<String>>

	public fun matchServicesBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<ServiceJs>):
			Promise<Array<String>>

	public fun filterContactsBy(groupId: String, filter: BaseFilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedContactJs>>>

	public fun filterContactsBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedContactJs>>>

	public fun filterServicesBy(groupId: String, filter: BaseFilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedServiceJs>>>

	public fun filterServicesBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedServiceJs>>>

	public fun deleteContactById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteContactsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeContactById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgeContactsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteContact(contact: GroupScopedJs<ContactJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteContacts(contacts: Array<GroupScopedJs<ContactJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeContact(contact: GroupScopedJs<ContactJs>): Promise<Unit>

	public fun purgeContacts(contacts: Array<GroupScopedJs<ContactJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun createContact(entity: GroupScopedJs<EncryptedContactJs>):
			Promise<GroupScopedJs<EncryptedContactJs>>

	public fun createContacts(entities: Array<GroupScopedJs<EncryptedContactJs>>):
			Promise<Array<GroupScopedJs<EncryptedContactJs>>>

	public fun undeleteContactById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<EncryptedContactJs>>

	public fun undeleteContactsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<EncryptedContactJs>>>

	public fun undeleteContact(contact: GroupScopedJs<ContactJs>):
			Promise<GroupScopedJs<EncryptedContactJs>>

	public fun undeleteContacts(contacts: Array<GroupScopedJs<EncryptedContactJs>>):
			Promise<Array<GroupScopedJs<EncryptedContactJs>>>

	public fun modifyContact(entity: GroupScopedJs<EncryptedContactJs>):
			Promise<GroupScopedJs<EncryptedContactJs>>

	public fun modifyContacts(entities: Array<GroupScopedJs<EncryptedContactJs>>):
			Promise<Array<GroupScopedJs<EncryptedContactJs>>>

	public fun getContact(groupId: String, entityId: String):
			Promise<GroupScopedJs<EncryptedContactJs>?>

	public fun getContacts(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<EncryptedContactJs>>>

	public fun getService(groupId: String, serviceId: String):
			Promise<GroupScopedJs<EncryptedServiceJs>?>

	public fun getServices(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<EncryptedServiceJs>>>
}

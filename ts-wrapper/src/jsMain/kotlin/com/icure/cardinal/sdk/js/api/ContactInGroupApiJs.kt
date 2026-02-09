// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.ContactJs
import com.icure.cardinal.sdk.js.model.DecryptedContactJs
import com.icure.cardinal.sdk.js.model.EncryptedContactJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedServiceJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedServiceJs
import com.icure.cardinal.sdk.js.model.embed.ServiceJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToContactShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ContactInGroupApi")
public external interface ContactInGroupApiJs {
	public val encrypted: ContactFlavouredInGroupApiJs<EncryptedContactJs, EncryptedServiceJs>

	public val tryAndRecover: ContactFlavouredInGroupApiJs<ContactJs, ServiceJs>

	public fun withEncryptionMetadata(
		entityGroupId: String,
		base: DecryptedContactJs?,
		patient: GroupScopedJs<PatientJs>?,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedContactJs>>

	public fun getEncryptionKeysOf(contact: GroupScopedJs<ContactJs>): Promise<Array<String>>

	public fun hasWriteAccess(contact: GroupScopedJs<ContactJs>): Promise<Boolean>

	public fun decryptPatientIdOf(contact: GroupScopedJs<ContactJs>):
			Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<ContactJs>,
			delegates: Array<EntityReferenceInGroupJs>): Promise<Unit>

	public fun decrypt(contacts: Array<GroupScopedJs<EncryptedContactJs>>):
			Promise<Array<GroupScopedJs<DecryptedContactJs>>>

	public fun tryDecrypt(contacts: Array<GroupScopedJs<EncryptedContactJs>>):
			Promise<Array<GroupScopedJs<ContactJs>>>

	public fun decryptService(service: GroupScopedJs<EncryptedServiceJs>):
			Promise<GroupScopedJs<DecryptedServiceJs>>

	public fun tryDecryptService(service: GroupScopedJs<EncryptedServiceJs>):
			Promise<GroupScopedJs<ServiceJs>>

	public fun matchContactsBy(groupId: String, filter: FilterOptionsJs<ContactJs>):
			Promise<Array<String>>

	public fun matchContactsBySorted(groupId: String, filter: SortableFilterOptionsJs<ContactJs>):
			Promise<Array<String>>

	public fun matchServicesBy(groupId: String, filter: FilterOptionsJs<ServiceJs>):
			Promise<Array<String>>

	public fun matchServicesBySorted(groupId: String, filter: SortableFilterOptionsJs<ServiceJs>):
			Promise<Array<String>>

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

	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		contact: GroupScopedJs<DecryptedContactJs>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedContactJs>>

	public fun shareWithMany(contact: GroupScopedJs<DecryptedContactJs>,
			delegates: Array<EntityReferenceInGroupToContactShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<DecryptedContactJs>>

	public fun filterContactsBy(groupId: String, filter: FilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedContactJs>>>

	public fun filterContactsBySorted(groupId: String, filter: SortableFilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedContactJs>>>

	public fun createContact(entity: GroupScopedJs<DecryptedContactJs>):
			Promise<GroupScopedJs<DecryptedContactJs>>

	public fun createContacts(entities: Array<GroupScopedJs<DecryptedContactJs>>):
			Promise<Array<GroupScopedJs<DecryptedContactJs>>>

	public fun undeleteContactById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<DecryptedContactJs>>

	public fun undeleteContactsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<DecryptedContactJs>>>

	public fun undeleteContact(contact: GroupScopedJs<ContactJs>):
			Promise<GroupScopedJs<DecryptedContactJs>>

	public fun undeleteContacts(contacts: Array<GroupScopedJs<DecryptedContactJs>>):
			Promise<Array<GroupScopedJs<DecryptedContactJs>>>

	public fun modifyContact(entity: GroupScopedJs<DecryptedContactJs>):
			Promise<GroupScopedJs<DecryptedContactJs>>

	public fun modifyContacts(entities: Array<GroupScopedJs<DecryptedContactJs>>):
			Promise<Array<GroupScopedJs<DecryptedContactJs>>>

	public fun getContact(groupId: String, entityId: String):
			Promise<GroupScopedJs<DecryptedContactJs>?>

	public fun getContacts(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<DecryptedContactJs>>>

	public fun getService(groupId: String, serviceId: String):
			Promise<GroupScopedJs<DecryptedServiceJs>?>

	public fun getServices(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<DecryptedServiceJs>>>
}

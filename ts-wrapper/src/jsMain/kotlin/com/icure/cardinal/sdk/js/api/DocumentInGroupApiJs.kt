// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedDocumentJs
import com.icure.cardinal.sdk.js.model.DocumentJs
import com.icure.cardinal.sdk.js.model.EncryptedDocumentJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.MessageJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToDocumentShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("DocumentInGroupApi")
public external interface DocumentInGroupApiJs {
	public val encrypted: DocumentFlavouredInGroupApiJs<EncryptedDocumentJs>

	public val tryAndRecover: DocumentFlavouredInGroupApiJs<DocumentJs>

	public fun withEncryptionMetadataLinkedToMessage(
		entityGroupId: String,
		base: DecryptedDocumentJs?,
		message: GroupScopedJs<MessageJs>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedDocumentJs>>

	public fun withEncryptionMetadataLinkedToPatient(
		entityGroupId: String,
		base: DecryptedDocumentJs?,
		patient: GroupScopedJs<PatientJs>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedDocumentJs>>

	public fun withEncryptionMetadataUnlinked(
		entityGroupId: String,
		base: DecryptedDocumentJs?,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedDocumentJs>>

	public fun getEncryptionKeysOf(document: GroupScopedJs<DocumentJs>): Promise<Array<String>>

	public fun hasWriteAccess(document: GroupScopedJs<DocumentJs>): Promise<Boolean>

	public fun decryptOwningEntityIdsOf(document: GroupScopedJs<DocumentJs>):
			Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<DocumentJs>,
			delegates: Array<EntityReferenceInGroupJs>): Promise<Unit>

	public fun decrypt(documents: Array<GroupScopedJs<EncryptedDocumentJs>>):
			Promise<Array<GroupScopedJs<DecryptedDocumentJs>>>

	public fun tryDecrypt(documents: Array<GroupScopedJs<EncryptedDocumentJs>>):
			Promise<Array<GroupScopedJs<DocumentJs>>>

	public fun matchDocumentsBy(groupId: String, filter: FilterOptionsJs<DocumentJs>):
			Promise<Array<String>>

	public fun matchDocumentsBySorted(groupId: String, filter: SortableFilterOptionsJs<DocumentJs>):
			Promise<Array<String>>

	public fun deleteDocumentById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteDocumentsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeDocumentById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgeDocumentsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteDocument(document: GroupScopedJs<DocumentJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteDocuments(documents: Array<GroupScopedJs<DocumentJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeDocument(document: GroupScopedJs<DocumentJs>): Promise<Unit>

	public fun purgeDocuments(documents: Array<GroupScopedJs<DocumentJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		document: GroupScopedJs<DecryptedDocumentJs>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedDocumentJs>>

	public fun shareWithMany(document: GroupScopedJs<DecryptedDocumentJs>,
			delegates: Array<EntityReferenceInGroupToDocumentShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<DecryptedDocumentJs>>

	public fun filterDocumentsBy(groupId: String, filter: FilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedDocumentJs>>>

	public fun filterDocumentsBySorted(groupId: String, filter: SortableFilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedDocumentJs>>>

	public fun createDocument(entity: GroupScopedJs<DecryptedDocumentJs>):
			Promise<GroupScopedJs<DecryptedDocumentJs>>

	public fun createDocuments(entities: Array<GroupScopedJs<DecryptedDocumentJs>>):
			Promise<Array<GroupScopedJs<DecryptedDocumentJs>>>

	public fun undeleteDocumentById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<DecryptedDocumentJs>>

	public fun undeleteDocumentsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<DecryptedDocumentJs>>>

	public fun undeleteDocument(document: GroupScopedJs<DocumentJs>):
			Promise<GroupScopedJs<DecryptedDocumentJs>>

	public fun undeleteDocuments(documents: Array<GroupScopedJs<DecryptedDocumentJs>>):
			Promise<Array<GroupScopedJs<DecryptedDocumentJs>>>

	public fun modifyDocument(entity: GroupScopedJs<DecryptedDocumentJs>):
			Promise<GroupScopedJs<DecryptedDocumentJs>>

	public fun modifyDocuments(entities: Array<GroupScopedJs<DecryptedDocumentJs>>):
			Promise<Array<GroupScopedJs<DecryptedDocumentJs>>>

	public fun getDocument(groupId: String, entityId: String):
			Promise<GroupScopedJs<DecryptedDocumentJs>?>

	public fun getDocuments(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<DecryptedDocumentJs>>>
}

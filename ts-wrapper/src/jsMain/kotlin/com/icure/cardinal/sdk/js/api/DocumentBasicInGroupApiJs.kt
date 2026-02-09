// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DocumentJs
import com.icure.cardinal.sdk.js.model.EncryptedDocumentJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("DocumentBasicInGroupApi")
public external interface DocumentBasicInGroupApiJs {
	public fun matchDocumentsBy(groupId: String, filter: BaseFilterOptionsJs<DocumentJs>):
			Promise<Array<String>>

	public fun matchDocumentsBySorted(groupId: String,
			filter: BaseSortableFilterOptionsJs<DocumentJs>): Promise<Array<String>>

	public fun filterDocumentsBy(groupId: String, filter: BaseFilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedDocumentJs>>>

	public fun filterDocumentsBySorted(groupId: String,
			filter: BaseSortableFilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedDocumentJs>>>

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

	public fun createDocument(entity: GroupScopedJs<EncryptedDocumentJs>):
			Promise<GroupScopedJs<EncryptedDocumentJs>>

	public fun createDocuments(entities: Array<GroupScopedJs<EncryptedDocumentJs>>):
			Promise<Array<GroupScopedJs<EncryptedDocumentJs>>>

	public fun undeleteDocumentById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<EncryptedDocumentJs>>

	public fun undeleteDocumentsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<EncryptedDocumentJs>>>

	public fun undeleteDocument(document: GroupScopedJs<DocumentJs>):
			Promise<GroupScopedJs<EncryptedDocumentJs>>

	public fun undeleteDocuments(documents: Array<GroupScopedJs<EncryptedDocumentJs>>):
			Promise<Array<GroupScopedJs<EncryptedDocumentJs>>>

	public fun modifyDocument(entity: GroupScopedJs<EncryptedDocumentJs>):
			Promise<GroupScopedJs<EncryptedDocumentJs>>

	public fun modifyDocuments(entities: Array<GroupScopedJs<EncryptedDocumentJs>>):
			Promise<Array<GroupScopedJs<EncryptedDocumentJs>>>

	public fun getDocument(groupId: String, entityId: String):
			Promise<GroupScopedJs<EncryptedDocumentJs>?>

	public fun getDocuments(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<EncryptedDocumentJs>>>
}

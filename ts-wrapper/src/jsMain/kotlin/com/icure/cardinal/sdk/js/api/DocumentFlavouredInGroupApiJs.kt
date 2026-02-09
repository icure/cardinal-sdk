// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DocumentJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToDocumentShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("DocumentFlavouredInGroupApi")
public external interface DocumentFlavouredInGroupApiJs<E : DocumentJs> {
	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		document: GroupScopedJs<E>,
		options: dynamic,
	): Promise<GroupScopedJs<E>>

	public fun shareWithMany(document: GroupScopedJs<E>,
			delegates: Array<EntityReferenceInGroupToDocumentShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<E>>

	public fun filterDocumentsBy(groupId: String, filter: FilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun filterDocumentsBySorted(groupId: String, filter: SortableFilterOptionsJs<DocumentJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun createDocument(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun createDocuments(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun undeleteDocumentById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<E>>

	public fun undeleteDocumentsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun undeleteDocument(document: GroupScopedJs<DocumentJs>): Promise<GroupScopedJs<E>>

	public fun undeleteDocuments(documents: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun modifyDocument(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun modifyDocuments(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun getDocument(groupId: String, entityId: String): Promise<GroupScopedJs<E>?>

	public fun getDocuments(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<E>>>
}

// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.RelatedPersonJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToRelatedPersonShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("RelatedPersonFlavouredInGroupApi")
public external interface RelatedPersonFlavouredInGroupApiJs<E : RelatedPersonJs> {
	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		relatedPerson: GroupScopedJs<E>,
		options: dynamic,
	): Promise<GroupScopedJs<E>>

	public fun shareWithMany(relatedPerson: GroupScopedJs<E>,
			delegates: Array<EntityReferenceInGroupToRelatedPersonShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<E>>

	public fun filterRelatedPersonsBy(groupId: String, filter: FilterOptionsJs<RelatedPersonJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun filterRelatedPersonsBySorted(groupId: String,
			filter: SortableFilterOptionsJs<RelatedPersonJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun createRelatedPerson(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun createRelatedPersons(entities: Array<GroupScopedJs<E>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun undeleteRelatedPersonById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<E>>

	public
			fun undeleteRelatedPersonsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun undeleteRelatedPerson(relatedPerson: GroupScopedJs<RelatedPersonJs>):
			Promise<GroupScopedJs<E>>

	public fun undeleteRelatedPersons(relatedPersons: Array<GroupScopedJs<E>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun modifyRelatedPerson(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun modifyRelatedPersons(entities: Array<GroupScopedJs<E>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun getRelatedPerson(groupId: String, entityId: String): Promise<GroupScopedJs<E>?>

	public fun getRelatedPersons(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<E>>>
}

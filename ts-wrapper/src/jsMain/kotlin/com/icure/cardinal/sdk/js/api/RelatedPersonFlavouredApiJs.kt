// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.RelatedPersonShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.RelatedPersonJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("RelatedPersonFlavouredApi")
public external interface RelatedPersonFlavouredApiJs<E : RelatedPersonJs> {
	public fun shareWith(
		delegateId: String,
		relatedPerson: E,
		options: dynamic,
	): Promise<E>

	public fun shareWithMany(relatedPerson: E, delegates: Record<String, RelatedPersonShareOptionsJs>):
			Promise<E>

	public fun filterRelatedPersonsBy(filter: FilterOptionsJs<RelatedPersonJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun filterRelatedPersonsBySorted(filter: SortableFilterOptionsJs<RelatedPersonJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun createRelatedPerson(entity: E): Promise<E>

	public fun createRelatedPersons(entities: Array<E>): Promise<Array<E>>

	public fun undeleteRelatedPersonById(id: String, rev: String): Promise<E>

	public fun undeleteRelatedPersonsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<E>>

	public fun undeleteRelatedPerson(relatedPerson: RelatedPersonJs): Promise<E>

	public fun undeleteRelatedPersons(relatedPersons: Array<RelatedPersonJs>): Promise<Array<E>>

	public fun modifyRelatedPerson(entity: E): Promise<E>

	public fun modifyRelatedPersons(entities: Array<E>): Promise<Array<E>>

	public fun getRelatedPerson(entityId: String): Promise<E?>

	public fun getRelatedPersons(entityIds: Array<String>): Promise<Array<E>>
}

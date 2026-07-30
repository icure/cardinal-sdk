// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EncryptedRelatedPersonJs
import com.icure.cardinal.sdk.js.model.RelatedPersonJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("RelatedPersonBasicApi")
public external interface RelatedPersonBasicApiJs {
	public val inGroup: RelatedPersonBasicInGroupApiJs

	public fun matchRelatedPersonsBy(filter: BaseFilterOptionsJs<RelatedPersonJs>):
			Promise<Array<String>>

	public fun matchRelatedPersonsBySorted(filter: BaseSortableFilterOptionsJs<RelatedPersonJs>):
			Promise<Array<String>>

	public fun filterRelatedPersonsBy(filter: BaseFilterOptionsJs<RelatedPersonJs>):
			Promise<PaginatedListIteratorJs<EncryptedRelatedPersonJs>>

	public fun filterRelatedPersonsBySorted(filter: BaseSortableFilterOptionsJs<RelatedPersonJs>):
			Promise<PaginatedListIteratorJs<EncryptedRelatedPersonJs>>

	public fun deleteRelatedPersonById(entityId: String, rev: String):
			Promise<StoredDocumentIdentifierJs>

	public fun deleteRelatedPersonsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeRelatedPersonById(id: String, rev: String): Promise<Unit>

	public fun purgeRelatedPersonsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deleteRelatedPerson(relatedPerson: RelatedPersonJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteRelatedPersons(relatedPersons: Array<RelatedPersonJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeRelatedPerson(relatedPerson: RelatedPersonJs): Promise<Unit>

	public fun purgeRelatedPersons(relatedPersons: Array<RelatedPersonJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun createRelatedPerson(entity: EncryptedRelatedPersonJs): Promise<EncryptedRelatedPersonJs>

	public fun createRelatedPersons(entities: Array<EncryptedRelatedPersonJs>):
			Promise<Array<EncryptedRelatedPersonJs>>

	public fun undeleteRelatedPersonById(id: String, rev: String): Promise<EncryptedRelatedPersonJs>

	public fun undeleteRelatedPersonsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<EncryptedRelatedPersonJs>>

	public fun undeleteRelatedPerson(relatedPerson: RelatedPersonJs): Promise<EncryptedRelatedPersonJs>

	public fun undeleteRelatedPersons(relatedPersons: Array<RelatedPersonJs>):
			Promise<Array<EncryptedRelatedPersonJs>>

	public fun modifyRelatedPerson(entity: EncryptedRelatedPersonJs): Promise<EncryptedRelatedPersonJs>

	public fun modifyRelatedPersons(entities: Array<EncryptedRelatedPersonJs>):
			Promise<Array<EncryptedRelatedPersonJs>>

	public fun getRelatedPerson(entityId: String): Promise<EncryptedRelatedPersonJs?>

	public fun getRelatedPersons(entityIds: Array<String>): Promise<Array<EncryptedRelatedPersonJs>>
}

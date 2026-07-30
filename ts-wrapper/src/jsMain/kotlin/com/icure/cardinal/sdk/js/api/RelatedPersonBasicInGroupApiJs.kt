// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EncryptedRelatedPersonJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.RelatedPersonJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("RelatedPersonBasicInGroupApi")
public external interface RelatedPersonBasicInGroupApiJs {
	public fun matchRelatedPersonsBy(groupId: String, filter: BaseFilterOptionsJs<RelatedPersonJs>):
			Promise<Array<String>>

	public fun matchRelatedPersonsBySorted(groupId: String,
			filter: BaseSortableFilterOptionsJs<RelatedPersonJs>): Promise<Array<String>>

	public fun filterRelatedPersonsBy(groupId: String, filter: BaseFilterOptionsJs<RelatedPersonJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedRelatedPersonJs>>>

	public fun filterRelatedPersonsBySorted(groupId: String,
			filter: BaseSortableFilterOptionsJs<RelatedPersonJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedRelatedPersonJs>>>

	public fun deleteRelatedPersonById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteRelatedPersonsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeRelatedPersonById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<Unit>

	public fun purgeRelatedPersonsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteRelatedPerson(relatedPerson: GroupScopedJs<RelatedPersonJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteRelatedPersons(relatedPersons: Array<GroupScopedJs<RelatedPersonJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeRelatedPerson(relatedPerson: GroupScopedJs<RelatedPersonJs>): Promise<Unit>

	public fun purgeRelatedPersons(relatedPersons: Array<GroupScopedJs<RelatedPersonJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun createRelatedPerson(entity: GroupScopedJs<EncryptedRelatedPersonJs>):
			Promise<GroupScopedJs<EncryptedRelatedPersonJs>>

	public fun createRelatedPersons(entities: Array<GroupScopedJs<EncryptedRelatedPersonJs>>):
			Promise<Array<GroupScopedJs<EncryptedRelatedPersonJs>>>

	public fun undeleteRelatedPersonById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<EncryptedRelatedPersonJs>>

	public
			fun undeleteRelatedPersonsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<EncryptedRelatedPersonJs>>>

	public fun undeleteRelatedPerson(relatedPerson: GroupScopedJs<RelatedPersonJs>):
			Promise<GroupScopedJs<EncryptedRelatedPersonJs>>

	public fun undeleteRelatedPersons(relatedPersons: Array<GroupScopedJs<EncryptedRelatedPersonJs>>):
			Promise<Array<GroupScopedJs<EncryptedRelatedPersonJs>>>

	public fun modifyRelatedPerson(entity: GroupScopedJs<EncryptedRelatedPersonJs>):
			Promise<GroupScopedJs<EncryptedRelatedPersonJs>>

	public fun modifyRelatedPersons(entities: Array<GroupScopedJs<EncryptedRelatedPersonJs>>):
			Promise<Array<GroupScopedJs<EncryptedRelatedPersonJs>>>

	public fun getRelatedPerson(groupId: String, entityId: String):
			Promise<GroupScopedJs<EncryptedRelatedPersonJs>?>

	public fun getRelatedPersons(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<EncryptedRelatedPersonJs>>>
}

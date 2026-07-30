// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedRelatedPersonJs
import com.icure.cardinal.sdk.js.model.EncryptedRelatedPersonJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.RelatedPersonJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToRelatedPersonDelegateOptionsMapObject_delegate_delegateOptions
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToRelatedPersonShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("RelatedPersonInGroupApi")
public external interface RelatedPersonInGroupApiJs {
	public val encrypted: RelatedPersonFlavouredInGroupApiJs<EncryptedRelatedPersonJs>

	public val tryAndRecover: RelatedPersonFlavouredInGroupApiJs<RelatedPersonJs>

	public fun withEncryptionMetadata(
		entityGroupId: String,
		base: DecryptedRelatedPersonJs?,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedRelatedPersonJs>>

	public fun withEncryptionMetadataAndDelegates(
		entityGroupId: String,
		base: DecryptedRelatedPersonJs?,
		delegates: Array<EntityReferenceInGroupToRelatedPersonDelegateOptionsMapObject_delegate_delegateOptions>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedRelatedPersonJs>>

	public fun getEncryptionKeysOf(relatedPerson: GroupScopedJs<RelatedPersonJs>):
			Promise<Array<String>>

	public fun hasWriteAccess(relatedPerson: GroupScopedJs<RelatedPersonJs>): Promise<Boolean>

	public fun getSecretIdsOf(relatedPerson: GroupScopedJs<RelatedPersonJs>): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<RelatedPersonJs>,
			delegates: Array<EntityReferenceInGroupJs>): Promise<Unit>

	public fun decrypt(relatedPersons: Array<GroupScopedJs<EncryptedRelatedPersonJs>>):
			Promise<Array<GroupScopedJs<DecryptedRelatedPersonJs>>>

	public fun tryDecrypt(relatedPersons: Array<GroupScopedJs<EncryptedRelatedPersonJs>>):
			Promise<Array<GroupScopedJs<RelatedPersonJs>>>

	public fun encryptOrValidate(relatedPersons: Array<GroupScopedJs<RelatedPersonJs>>):
			Promise<Array<GroupScopedJs<EncryptedRelatedPersonJs>>>

	public fun matchRelatedPersonsBy(groupId: String, filter: FilterOptionsJs<RelatedPersonJs>):
			Promise<Array<String>>

	public fun matchRelatedPersonsBySorted(groupId: String,
			filter: SortableFilterOptionsJs<RelatedPersonJs>): Promise<Array<String>>

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

	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		relatedPerson: GroupScopedJs<DecryptedRelatedPersonJs>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedRelatedPersonJs>>

	public fun shareWithMany(relatedPerson: GroupScopedJs<DecryptedRelatedPersonJs>,
			delegates: Array<EntityReferenceInGroupToRelatedPersonShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<DecryptedRelatedPersonJs>>

	public fun filterRelatedPersonsBy(groupId: String, filter: FilterOptionsJs<RelatedPersonJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedRelatedPersonJs>>>

	public fun filterRelatedPersonsBySorted(groupId: String,
			filter: SortableFilterOptionsJs<RelatedPersonJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedRelatedPersonJs>>>

	public fun createRelatedPerson(entity: GroupScopedJs<DecryptedRelatedPersonJs>):
			Promise<GroupScopedJs<DecryptedRelatedPersonJs>>

	public fun createRelatedPersons(entities: Array<GroupScopedJs<DecryptedRelatedPersonJs>>):
			Promise<Array<GroupScopedJs<DecryptedRelatedPersonJs>>>

	public fun undeleteRelatedPersonById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<DecryptedRelatedPersonJs>>

	public
			fun undeleteRelatedPersonsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<DecryptedRelatedPersonJs>>>

	public fun undeleteRelatedPerson(relatedPerson: GroupScopedJs<RelatedPersonJs>):
			Promise<GroupScopedJs<DecryptedRelatedPersonJs>>

	public fun undeleteRelatedPersons(relatedPersons: Array<GroupScopedJs<DecryptedRelatedPersonJs>>):
			Promise<Array<GroupScopedJs<DecryptedRelatedPersonJs>>>

	public fun modifyRelatedPerson(entity: GroupScopedJs<DecryptedRelatedPersonJs>):
			Promise<GroupScopedJs<DecryptedRelatedPersonJs>>

	public fun modifyRelatedPersons(entities: Array<GroupScopedJs<DecryptedRelatedPersonJs>>):
			Promise<Array<GroupScopedJs<DecryptedRelatedPersonJs>>>

	public fun getRelatedPerson(groupId: String, entityId: String):
			Promise<GroupScopedJs<DecryptedRelatedPersonJs>?>

	public fun getRelatedPersons(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<DecryptedRelatedPersonJs>>>
}

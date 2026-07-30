// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.RelatedPersonDelegateOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.RelatedPersonShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedRelatedPersonJs
import com.icure.cardinal.sdk.js.model.EncryptedRelatedPersonJs
import com.icure.cardinal.sdk.js.model.RelatedPersonJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("RelatedPersonApi")
public external interface RelatedPersonApiJs {
	public val encrypted: RelatedPersonFlavouredApiJs<EncryptedRelatedPersonJs>

	public val tryAndRecover: RelatedPersonFlavouredApiJs<RelatedPersonJs>

	public val inGroup: RelatedPersonInGroupApiJs

	public fun withEncryptionMetadata(base: DecryptedRelatedPersonJs?, options: dynamic):
			Promise<DecryptedRelatedPersonJs>

	public fun withEncryptionMetadataAndDelegates(
		base: DecryptedRelatedPersonJs?,
		delegates: Record<String, RelatedPersonDelegateOptionsJs>,
		options: dynamic,
	): Promise<DecryptedRelatedPersonJs>

	public fun getEncryptionKeysOf(relatedPerson: RelatedPersonJs): Promise<Array<String>>

	public fun hasWriteAccess(relatedPerson: RelatedPersonJs): Promise<Boolean>

	public fun getSecretIdsOf(relatedPerson: RelatedPersonJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: RelatedPersonJs,
			delegates: Array<String>): Promise<Unit>

	public fun decrypt(relatedPersons: Array<EncryptedRelatedPersonJs>):
			Promise<Array<DecryptedRelatedPersonJs>>

	public fun tryDecrypt(relatedPersons: Array<EncryptedRelatedPersonJs>):
			Promise<Array<RelatedPersonJs>>

	public fun encryptOrValidate(relatedPersons: Array<RelatedPersonJs>):
			Promise<Array<EncryptedRelatedPersonJs>>

	public fun matchRelatedPersonsBy(filter: FilterOptionsJs<RelatedPersonJs>): Promise<Array<String>>

	public fun matchRelatedPersonsBySorted(filter: SortableFilterOptionsJs<RelatedPersonJs>):
			Promise<Array<String>>

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

	public fun shareWith(
		delegateId: String,
		relatedPerson: DecryptedRelatedPersonJs,
		options: dynamic,
	): Promise<DecryptedRelatedPersonJs>

	public fun shareWithMany(relatedPerson: DecryptedRelatedPersonJs,
			delegates: Record<String, RelatedPersonShareOptionsJs>): Promise<DecryptedRelatedPersonJs>

	public fun filterRelatedPersonsBy(filter: FilterOptionsJs<RelatedPersonJs>):
			Promise<PaginatedListIteratorJs<DecryptedRelatedPersonJs>>

	public fun filterRelatedPersonsBySorted(filter: SortableFilterOptionsJs<RelatedPersonJs>):
			Promise<PaginatedListIteratorJs<DecryptedRelatedPersonJs>>

	public fun createRelatedPerson(entity: DecryptedRelatedPersonJs): Promise<DecryptedRelatedPersonJs>

	public fun createRelatedPersons(entities: Array<DecryptedRelatedPersonJs>):
			Promise<Array<DecryptedRelatedPersonJs>>

	public fun undeleteRelatedPersonById(id: String, rev: String): Promise<DecryptedRelatedPersonJs>

	public fun undeleteRelatedPersonsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedRelatedPersonJs>>

	public fun undeleteRelatedPerson(relatedPerson: RelatedPersonJs): Promise<DecryptedRelatedPersonJs>

	public fun undeleteRelatedPersons(relatedPersons: Array<RelatedPersonJs>):
			Promise<Array<DecryptedRelatedPersonJs>>

	public fun modifyRelatedPerson(entity: DecryptedRelatedPersonJs): Promise<DecryptedRelatedPersonJs>

	public fun modifyRelatedPersons(entities: Array<DecryptedRelatedPersonJs>):
			Promise<Array<DecryptedRelatedPersonJs>>

	public fun getRelatedPerson(entityId: String): Promise<DecryptedRelatedPersonJs?>

	public fun getRelatedPersons(entityIds: Array<String>): Promise<Array<DecryptedRelatedPersonJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<RelatedPersonJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedRelatedPersonJs>>
}

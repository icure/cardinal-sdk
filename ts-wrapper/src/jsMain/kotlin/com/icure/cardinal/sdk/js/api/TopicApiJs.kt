// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.TopicShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedTopicJs
import com.icure.cardinal.sdk.js.model.EncryptedTopicJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.TopicJs
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

@JsName("TopicApi")
public external interface TopicApiJs {
	public val encrypted: TopicFlavouredApiJs<EncryptedTopicJs>

	public val tryAndRecover: TopicFlavouredApiJs<TopicJs>

	public val inGroup: TopicInGroupApiJs

	public fun withEncryptionMetadata(
		base: DecryptedTopicJs?,
		patient: PatientJs?,
		options: dynamic,
	): Promise<DecryptedTopicJs>

	public fun getEncryptionKeysOf(topic: TopicJs): Promise<Array<String>>

	public fun hasWriteAccess(topic: TopicJs): Promise<Boolean>

	public fun decryptPatientIdOf(topic: TopicJs): Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: TopicJs, delegates: Array<String>):
			Promise<Unit>

	public fun decrypt(topic: EncryptedTopicJs): Promise<DecryptedTopicJs>

	public fun tryDecrypt(topic: EncryptedTopicJs): Promise<TopicJs>

	public fun matchTopicsBy(filter: FilterOptionsJs<TopicJs>): Promise<Array<String>>

	public fun matchTopicsBySorted(filter: SortableFilterOptionsJs<TopicJs>): Promise<Array<String>>

	public fun deleteTopicById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>

	public fun deleteTopicsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeTopicById(id: String, rev: String): Promise<Unit>

	public fun purgeTopicsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deleteTopic(topic: TopicJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteTopics(topics: Array<TopicJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeTopic(topic: TopicJs): Promise<Unit>

	public fun purgeTopics(topics: Array<TopicJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun shareWith(
		delegateId: String,
		topic: DecryptedTopicJs,
		options: dynamic,
	): Promise<DecryptedTopicJs>

	public fun shareWithMany(topic: DecryptedTopicJs, delegates: Record<String, TopicShareOptionsJs>):
			Promise<DecryptedTopicJs>

	public fun filterTopicsBy(filter: FilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<DecryptedTopicJs>>

	public fun filterTopicsBySorted(filter: SortableFilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<DecryptedTopicJs>>

	public fun createTopic(entity: DecryptedTopicJs): Promise<DecryptedTopicJs>

	public fun createTopics(entities: Array<DecryptedTopicJs>): Promise<Array<DecryptedTopicJs>>

	public fun undeleteTopicById(id: String, rev: String): Promise<DecryptedTopicJs>

	public fun undeleteTopicsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedTopicJs>>

	public fun undeleteTopic(topic: TopicJs): Promise<DecryptedTopicJs>

	public fun undeleteTopics(topics: Array<TopicJs>): Promise<Array<DecryptedTopicJs>>

	public fun modifyTopic(entity: DecryptedTopicJs): Promise<DecryptedTopicJs>

	public fun modifyTopics(entities: Array<DecryptedTopicJs>): Promise<Array<DecryptedTopicJs>>

	public fun getTopic(entityId: String): Promise<DecryptedTopicJs?>

	public fun getTopics(entityIds: Array<String>): Promise<Array<DecryptedTopicJs>>

	public fun addParticipant(
		entityId: String,
		dataOwnerId: String,
		topicRole: String,
	): Promise<DecryptedTopicJs>

	public fun removeParticipant(entityId: String, dataOwnerId: String): Promise<DecryptedTopicJs>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<TopicJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedTopicJs>>
}

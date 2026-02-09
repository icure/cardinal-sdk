// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EncryptedTopicJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.TopicJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("TopicBasicApi")
public external interface TopicBasicApiJs {
	public val inGroup: TopicBasicInGroupApiJs

	public fun matchTopicsBy(filter: BaseFilterOptionsJs<TopicJs>): Promise<Array<String>>

	public fun matchTopicsBySorted(filter: BaseSortableFilterOptionsJs<TopicJs>):
			Promise<Array<String>>

	public fun filterTopicsBy(filter: BaseFilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<EncryptedTopicJs>>

	public fun filterTopicsBySorted(filter: BaseSortableFilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<EncryptedTopicJs>>

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

	public fun createTopic(entity: EncryptedTopicJs): Promise<EncryptedTopicJs>

	public fun createTopics(entities: Array<EncryptedTopicJs>): Promise<Array<EncryptedTopicJs>>

	public fun undeleteTopicById(id: String, rev: String): Promise<EncryptedTopicJs>

	public fun undeleteTopicsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<EncryptedTopicJs>>

	public fun undeleteTopic(topic: TopicJs): Promise<EncryptedTopicJs>

	public fun undeleteTopics(topics: Array<TopicJs>): Promise<Array<EncryptedTopicJs>>

	public fun modifyTopic(entity: EncryptedTopicJs): Promise<EncryptedTopicJs>

	public fun modifyTopics(entities: Array<EncryptedTopicJs>): Promise<Array<EncryptedTopicJs>>

	public fun getTopic(entityId: String): Promise<EncryptedTopicJs?>

	public fun getTopics(entityIds: Array<String>): Promise<Array<EncryptedTopicJs>>

	public fun addParticipant(
		entityId: String,
		dataOwnerId: String,
		topicRole: String,
	): Promise<EncryptedTopicJs>

	public fun removeParticipant(entityId: String, dataOwnerId: String): Promise<EncryptedTopicJs>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<TopicJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedTopicJs>>
}

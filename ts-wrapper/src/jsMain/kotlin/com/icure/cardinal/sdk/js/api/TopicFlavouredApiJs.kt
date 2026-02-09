// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.TopicShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.TopicJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("TopicFlavouredApi")
public external interface TopicFlavouredApiJs<E : TopicJs> {
	public fun shareWith(
		delegateId: String,
		topic: E,
		options: dynamic,
	): Promise<E>

	public fun shareWithMany(topic: E, delegates: Record<String, TopicShareOptionsJs>): Promise<E>

	public fun filterTopicsBy(filter: FilterOptionsJs<TopicJs>): Promise<PaginatedListIteratorJs<E>>

	public fun filterTopicsBySorted(filter: SortableFilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun createTopic(entity: E): Promise<E>

	public fun createTopics(entities: Array<E>): Promise<Array<E>>

	public fun undeleteTopicById(id: String, rev: String): Promise<E>

	public fun undeleteTopicsByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<E>>

	public fun undeleteTopic(topic: TopicJs): Promise<E>

	public fun undeleteTopics(topics: Array<TopicJs>): Promise<Array<E>>

	public fun modifyTopic(entity: E): Promise<E>

	public fun modifyTopics(entities: Array<E>): Promise<Array<E>>

	public fun getTopic(entityId: String): Promise<E?>

	public fun getTopics(entityIds: Array<String>): Promise<Array<E>>

	public fun addParticipant(
		entityId: String,
		dataOwnerId: String,
		topicRole: String,
	): Promise<E>

	public fun removeParticipant(entityId: String, dataOwnerId: String): Promise<E>
}

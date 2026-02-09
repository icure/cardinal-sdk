// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EncryptedTopicJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.TopicJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("TopicBasicInGroupApi")
public external interface TopicBasicInGroupApiJs {
	public fun matchTopicsBy(groupId: String, filter: BaseFilterOptionsJs<TopicJs>):
			Promise<Array<String>>

	public fun matchTopicsBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<TopicJs>):
			Promise<Array<String>>

	public fun filterTopicsBy(groupId: String, filter: BaseFilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedTopicJs>>>

	public fun filterTopicsBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedTopicJs>>>

	public fun deleteTopicById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteTopicsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeTopicById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgeTopicsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteTopic(topic: GroupScopedJs<TopicJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteTopics(topics: Array<GroupScopedJs<TopicJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeTopic(topic: GroupScopedJs<TopicJs>): Promise<Unit>

	public fun purgeTopics(topics: Array<GroupScopedJs<TopicJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun createTopic(entity: GroupScopedJs<EncryptedTopicJs>):
			Promise<GroupScopedJs<EncryptedTopicJs>>

	public fun createTopics(entities: Array<GroupScopedJs<EncryptedTopicJs>>):
			Promise<Array<GroupScopedJs<EncryptedTopicJs>>>

	public fun undeleteTopicById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<EncryptedTopicJs>>

	public fun undeleteTopicsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<EncryptedTopicJs>>>

	public fun undeleteTopic(topic: GroupScopedJs<TopicJs>): Promise<GroupScopedJs<EncryptedTopicJs>>

	public fun undeleteTopics(topics: Array<GroupScopedJs<EncryptedTopicJs>>):
			Promise<Array<GroupScopedJs<EncryptedTopicJs>>>

	public fun modifyTopic(entity: GroupScopedJs<EncryptedTopicJs>):
			Promise<GroupScopedJs<EncryptedTopicJs>>

	public fun modifyTopics(entities: Array<GroupScopedJs<EncryptedTopicJs>>):
			Promise<Array<GroupScopedJs<EncryptedTopicJs>>>

	public fun getTopic(groupId: String, entityId: String): Promise<GroupScopedJs<EncryptedTopicJs>?>

	public fun getTopics(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<EncryptedTopicJs>>>
}

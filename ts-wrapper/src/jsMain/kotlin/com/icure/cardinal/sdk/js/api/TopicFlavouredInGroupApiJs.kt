// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.TopicJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToTopicShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("TopicFlavouredInGroupApi")
public external interface TopicFlavouredInGroupApiJs<E : TopicJs> {
	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		topic: GroupScopedJs<E>,
		options: dynamic,
	): Promise<GroupScopedJs<E>>

	public fun shareWithMany(topic: GroupScopedJs<E>,
			delegates: Array<EntityReferenceInGroupToTopicShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<E>>

	public fun filterTopicsBy(groupId: String, filter: FilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun filterTopicsBySorted(groupId: String, filter: SortableFilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun createTopic(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun createTopics(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun undeleteTopicById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<E>>

	public fun undeleteTopicsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun undeleteTopic(topic: GroupScopedJs<TopicJs>): Promise<GroupScopedJs<E>>

	public fun undeleteTopics(topics: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun modifyTopic(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun modifyTopics(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun getTopic(groupId: String, entityId: String): Promise<GroupScopedJs<E>?>

	public fun getTopics(groupId: String, entityIds: Array<String>): Promise<Array<GroupScopedJs<E>>>
}

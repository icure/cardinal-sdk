// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedTopicJs
import com.icure.cardinal.sdk.js.model.EncryptedTopicJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.TopicJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToTopicShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("TopicInGroupApi")
public external interface TopicInGroupApiJs {
	public val encrypted: TopicFlavouredInGroupApiJs<EncryptedTopicJs>

	public val tryAndRecover: TopicFlavouredInGroupApiJs<TopicJs>

	public fun withEncryptionMetadata(
		groupId: String,
		base: DecryptedTopicJs?,
		patient: GroupScopedJs<PatientJs>?,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedTopicJs>>

	public fun getEncryptionKeysOf(topic: GroupScopedJs<TopicJs>): Promise<Array<String>>

	public fun hasWriteAccess(topic: GroupScopedJs<TopicJs>): Promise<Boolean>

	public fun decryptPatientIdOf(topic: GroupScopedJs<TopicJs>):
			Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<TopicJs>,
			delegates: Array<EntityReferenceInGroupJs>): Promise<Unit>

	public fun decrypt(topics: Array<GroupScopedJs<EncryptedTopicJs>>):
			Promise<Array<GroupScopedJs<DecryptedTopicJs>>>

	public fun tryDecrypt(topics: Array<GroupScopedJs<EncryptedTopicJs>>):
			Promise<Array<GroupScopedJs<TopicJs>>>

	public fun matchTopicsBy(groupId: String, filter: FilterOptionsJs<TopicJs>): Promise<Array<String>>

	public fun matchTopicsBySorted(groupId: String, filter: SortableFilterOptionsJs<TopicJs>):
			Promise<Array<String>>

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

	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		topic: GroupScopedJs<DecryptedTopicJs>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedTopicJs>>

	public fun shareWithMany(topic: GroupScopedJs<DecryptedTopicJs>,
			delegates: Array<EntityReferenceInGroupToTopicShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<DecryptedTopicJs>>

	public fun filterTopicsBy(groupId: String, filter: FilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedTopicJs>>>

	public fun filterTopicsBySorted(groupId: String, filter: SortableFilterOptionsJs<TopicJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedTopicJs>>>

	public fun createTopic(entity: GroupScopedJs<DecryptedTopicJs>):
			Promise<GroupScopedJs<DecryptedTopicJs>>

	public fun createTopics(entities: Array<GroupScopedJs<DecryptedTopicJs>>):
			Promise<Array<GroupScopedJs<DecryptedTopicJs>>>

	public fun undeleteTopicById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<DecryptedTopicJs>>

	public fun undeleteTopicsByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<DecryptedTopicJs>>>

	public fun undeleteTopic(topic: GroupScopedJs<TopicJs>): Promise<GroupScopedJs<DecryptedTopicJs>>

	public fun undeleteTopics(topics: Array<GroupScopedJs<DecryptedTopicJs>>):
			Promise<Array<GroupScopedJs<DecryptedTopicJs>>>

	public fun modifyTopic(entity: GroupScopedJs<DecryptedTopicJs>):
			Promise<GroupScopedJs<DecryptedTopicJs>>

	public fun modifyTopics(entities: Array<GroupScopedJs<DecryptedTopicJs>>):
			Promise<Array<GroupScopedJs<DecryptedTopicJs>>>

	public fun getTopic(groupId: String, entityId: String): Promise<GroupScopedJs<DecryptedTopicJs>?>

	public fun getTopics(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<DecryptedTopicJs>>>
}

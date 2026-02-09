// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.MessageJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToMessageShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MessageFlavouredInGroupApi")
public external interface MessageFlavouredInGroupApiJs<E : MessageJs> {
	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		message: GroupScopedJs<E>,
		options: dynamic,
	): Promise<GroupScopedJs<E>>

	public fun shareWithMany(message: GroupScopedJs<E>,
			delegates: Array<EntityReferenceInGroupToMessageShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<E>>

	public fun filterMessagesBy(groupId: String, filter: FilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun filterMessagesBySorted(groupId: String, filter: SortableFilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<E>>>

	public fun createMessage(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun createMessages(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun undeleteMessageById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<E>>

	public fun undeleteMessagesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<E>>>

	public fun undeleteMessage(message: GroupScopedJs<MessageJs>): Promise<GroupScopedJs<E>>

	public fun undeleteMessages(messages: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun modifyMessage(entity: GroupScopedJs<E>): Promise<GroupScopedJs<E>>

	public fun modifyMessages(entities: Array<GroupScopedJs<E>>): Promise<Array<GroupScopedJs<E>>>

	public fun getMessage(groupId: String, entityId: String): Promise<GroupScopedJs<E>?>

	public fun getMessages(groupId: String, entityIds: Array<String>): Promise<Array<GroupScopedJs<E>>>
}

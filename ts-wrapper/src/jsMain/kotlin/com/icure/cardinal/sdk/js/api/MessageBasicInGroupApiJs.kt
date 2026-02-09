// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EncryptedMessageJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.MessageJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MessageBasicInGroupApi")
public external interface MessageBasicInGroupApiJs {
	public fun matchMessagesBy(groupId: String, filter: BaseFilterOptionsJs<MessageJs>):
			Promise<Array<String>>

	public fun matchMessagesBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<MessageJs>):
			Promise<Array<String>>

	public fun filterMessagesBy(groupId: String, filter: BaseFilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedMessageJs>>>

	public fun filterMessagesBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedMessageJs>>>

	public fun deleteMessageById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteMessagesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeMessageById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>): Promise<Unit>

	public fun purgeMessagesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun deleteMessage(message: GroupScopedJs<MessageJs>):
			Promise<GroupScopedJs<StoredDocumentIdentifierJs>>

	public fun deleteMessages(messages: Array<GroupScopedJs<MessageJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun purgeMessage(message: GroupScopedJs<MessageJs>): Promise<Unit>

	public fun purgeMessages(messages: Array<GroupScopedJs<MessageJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun createMessage(entity: GroupScopedJs<EncryptedMessageJs>):
			Promise<GroupScopedJs<EncryptedMessageJs>>

	public fun createMessages(entities: Array<GroupScopedJs<EncryptedMessageJs>>):
			Promise<Array<GroupScopedJs<EncryptedMessageJs>>>

	public fun undeleteMessageById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<EncryptedMessageJs>>

	public fun undeleteMessagesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<EncryptedMessageJs>>>

	public fun undeleteMessage(message: GroupScopedJs<MessageJs>):
			Promise<GroupScopedJs<EncryptedMessageJs>>

	public fun undeleteMessages(messages: Array<GroupScopedJs<EncryptedMessageJs>>):
			Promise<Array<GroupScopedJs<EncryptedMessageJs>>>

	public fun modifyMessage(entity: GroupScopedJs<EncryptedMessageJs>):
			Promise<GroupScopedJs<EncryptedMessageJs>>

	public fun modifyMessages(entities: Array<GroupScopedJs<EncryptedMessageJs>>):
			Promise<Array<GroupScopedJs<EncryptedMessageJs>>>

	public fun getMessage(groupId: String, entityId: String):
			Promise<GroupScopedJs<EncryptedMessageJs>?>

	public fun getMessages(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<EncryptedMessageJs>>>
}

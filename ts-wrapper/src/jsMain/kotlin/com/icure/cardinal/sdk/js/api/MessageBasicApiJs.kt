// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EncryptedMessageJs
import com.icure.cardinal.sdk.js.model.MessageJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MessageBasicApi")
public external interface MessageBasicApiJs {
	public val inGroup: MessageBasicInGroupApiJs

	public fun matchMessagesBy(filter: BaseFilterOptionsJs<MessageJs>): Promise<Array<String>>

	public fun matchMessagesBySorted(filter: BaseSortableFilterOptionsJs<MessageJs>):
			Promise<Array<String>>

	public fun filterMessagesBy(filter: BaseFilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<EncryptedMessageJs>>

	public fun filterMessagesBySorted(filter: BaseSortableFilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<EncryptedMessageJs>>

	public fun deleteMessageById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>

	public fun deleteMessagesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeMessageById(id: String, rev: String): Promise<Unit>

	public fun purgeMessagesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deleteMessage(message: MessageJs): Promise<StoredDocumentIdentifierJs>

	public fun deleteMessages(messages: Array<MessageJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgeMessage(message: MessageJs): Promise<Unit>

	public fun purgeMessages(messages: Array<MessageJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun createMessage(entity: EncryptedMessageJs): Promise<EncryptedMessageJs>

	public fun createMessages(entities: Array<EncryptedMessageJs>): Promise<Array<EncryptedMessageJs>>

	public fun createMessageInTopic(entity: EncryptedMessageJs): Promise<EncryptedMessageJs>

	public fun undeleteMessageById(id: String, rev: String): Promise<EncryptedMessageJs>

	public fun undeleteMessagesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<EncryptedMessageJs>>

	public fun undeleteMessage(message: MessageJs): Promise<EncryptedMessageJs>

	public fun undeleteMessages(messages: Array<MessageJs>): Promise<Array<EncryptedMessageJs>>

	public fun modifyMessage(entity: EncryptedMessageJs): Promise<EncryptedMessageJs>

	public fun modifyMessages(entities: Array<EncryptedMessageJs>): Promise<Array<EncryptedMessageJs>>

	public fun getMessage(entityId: String): Promise<EncryptedMessageJs?>

	public fun getMessages(entityIds: Array<String>): Promise<Array<EncryptedMessageJs>>

	public fun setMessagesReadStatus(
		entityIds: Array<String>,
		time: Double?,
		readStatus: Boolean,
		userId: String?,
	): Promise<Array<EncryptedMessageJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<MessageJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedMessageJs>>
}

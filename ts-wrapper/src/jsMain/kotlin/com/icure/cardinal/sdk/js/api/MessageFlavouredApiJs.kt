// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.MessageShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.MessageJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MessageFlavouredApi")
public external interface MessageFlavouredApiJs<E : MessageJs> {
	public fun shareWith(
		delegateId: String,
		message: E,
		options: dynamic,
	): Promise<E>

	public fun shareWithMany(message: E, delegates: Record<String, MessageShareOptionsJs>): Promise<E>

	public fun filterMessagesBy(filter: FilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun filterMessagesBySorted(filter: SortableFilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun createMessage(entity: E): Promise<E>

	public fun createMessages(entities: Array<E>): Promise<Array<E>>

	public fun createMessageInTopic(entity: E): Promise<E>

	public fun undeleteMessageById(id: String, rev: String): Promise<E>

	public fun undeleteMessagesByIds(entityIds: Array<StoredDocumentIdentifierJs>): Promise<Array<E>>

	public fun undeleteMessage(message: MessageJs): Promise<E>

	public fun undeleteMessages(messages: Array<MessageJs>): Promise<Array<E>>

	public fun modifyMessage(entity: E): Promise<E>

	public fun modifyMessages(entities: Array<E>): Promise<Array<E>>

	public fun getMessage(entityId: String): Promise<E?>

	public fun getMessages(entityIds: Array<String>): Promise<Array<E>>

	public fun setMessagesReadStatus(
		entityIds: Array<String>,
		time: Double?,
		readStatus: Boolean,
		userId: String?,
	): Promise<Array<E>>
}

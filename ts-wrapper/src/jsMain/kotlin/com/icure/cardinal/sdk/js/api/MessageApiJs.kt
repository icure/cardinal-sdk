// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.MessageShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedMessageJs
import com.icure.cardinal.sdk.js.model.EncryptedMessageJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.MessageJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MessageApi")
public external interface MessageApiJs {
	public val encrypted: MessageFlavouredApiJs<EncryptedMessageJs>

	public val tryAndRecover: MessageFlavouredApiJs<MessageJs>

	public val inGroup: MessageInGroupApiJs

	public fun withEncryptionMetadata(
		base: DecryptedMessageJs?,
		patient: PatientJs?,
		options: dynamic,
	): Promise<DecryptedMessageJs>

	public fun getEncryptionKeysOf(message: MessageJs): Promise<Array<String>>

	public fun hasWriteAccess(message: MessageJs): Promise<Boolean>

	public fun decryptPatientIdOf(message: MessageJs): Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: MessageJs, delegates: Array<String>):
			Promise<Unit>

	public fun decrypt(message: EncryptedMessageJs): Promise<DecryptedMessageJs>

	public fun tryDecrypt(message: EncryptedMessageJs): Promise<MessageJs>

	public fun encryptOrValidate(messages: Array<MessageJs>): Promise<Array<EncryptedMessageJs>>

	public fun getSecretIdsOf(message: MessageJs):
			Promise<Record<String, Array<EntityReferenceInGroupJs>>>

	public fun matchMessagesBy(filter: FilterOptionsJs<MessageJs>): Promise<Array<String>>

	public fun matchMessagesBySorted(filter: SortableFilterOptionsJs<MessageJs>):
			Promise<Array<String>>

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

	public fun shareWith(
		delegateId: String,
		message: DecryptedMessageJs,
		options: dynamic,
	): Promise<DecryptedMessageJs>

	public fun shareWithMany(message: DecryptedMessageJs,
			delegates: Record<String, MessageShareOptionsJs>): Promise<DecryptedMessageJs>

	public fun filterMessagesBy(filter: FilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<DecryptedMessageJs>>

	public fun filterMessagesBySorted(filter: SortableFilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<DecryptedMessageJs>>

	public fun createMessage(entity: DecryptedMessageJs): Promise<DecryptedMessageJs>

	public fun createMessages(entities: Array<DecryptedMessageJs>): Promise<Array<DecryptedMessageJs>>

	public fun createMessageInTopic(entity: DecryptedMessageJs): Promise<DecryptedMessageJs>

	public fun undeleteMessageById(id: String, rev: String): Promise<DecryptedMessageJs>

	public fun undeleteMessagesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedMessageJs>>

	public fun undeleteMessage(message: MessageJs): Promise<DecryptedMessageJs>

	public fun undeleteMessages(messages: Array<MessageJs>): Promise<Array<DecryptedMessageJs>>

	public fun modifyMessage(entity: DecryptedMessageJs): Promise<DecryptedMessageJs>

	public fun modifyMessages(entities: Array<DecryptedMessageJs>): Promise<Array<DecryptedMessageJs>>

	public fun getMessage(entityId: String): Promise<DecryptedMessageJs?>

	public fun getMessages(entityIds: Array<String>): Promise<Array<DecryptedMessageJs>>

	public fun setMessagesReadStatus(
		entityIds: Array<String>,
		time: Double?,
		readStatus: Boolean,
		userId: String?,
	): Promise<Array<DecryptedMessageJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<MessageJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedMessageJs>>
}

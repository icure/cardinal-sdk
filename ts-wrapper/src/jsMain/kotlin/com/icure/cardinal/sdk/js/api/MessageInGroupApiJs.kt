// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedMessageJs
import com.icure.cardinal.sdk.js.model.EncryptedMessageJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.MessageJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.synthetic.mapasobjectarray.EntityReferenceInGroupToMessageShareOptionsMapObject_delegate_shareOptions
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MessageInGroupApi")
public external interface MessageInGroupApiJs {
	public val encrypted: MessageFlavouredInGroupApiJs<EncryptedMessageJs>

	public val tryAndRecover: MessageFlavouredInGroupApiJs<MessageJs>

	public fun withEncryptionMetadata(
		entityGroupId: String,
		base: DecryptedMessageJs?,
		patient: GroupScopedJs<PatientJs>?,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedMessageJs>>

	public fun getEncryptionKeysOf(message: GroupScopedJs<MessageJs>): Promise<Array<String>>

	public fun hasWriteAccess(message: GroupScopedJs<MessageJs>): Promise<Boolean>

	public fun decryptPatientIdOf(message: GroupScopedJs<MessageJs>):
			Promise<Array<EntityReferenceInGroupJs>>

	public fun createDelegationDeAnonymizationMetadata(entity: GroupScopedJs<MessageJs>,
			delegates: Array<EntityReferenceInGroupJs>): Promise<Unit>

	public fun decrypt(messages: Array<GroupScopedJs<EncryptedMessageJs>>):
			Promise<Array<GroupScopedJs<DecryptedMessageJs>>>

	public fun tryDecrypt(messages: Array<GroupScopedJs<EncryptedMessageJs>>):
			Promise<Array<GroupScopedJs<MessageJs>>>

	public fun matchMessagesBy(groupId: String, filter: FilterOptionsJs<MessageJs>):
			Promise<Array<String>>

	public fun matchMessagesBySorted(groupId: String, filter: SortableFilterOptionsJs<MessageJs>):
			Promise<Array<String>>

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

	public fun shareWith(
		`delegate`: EntityReferenceInGroupJs,
		message: GroupScopedJs<DecryptedMessageJs>,
		options: dynamic,
	): Promise<GroupScopedJs<DecryptedMessageJs>>

	public fun shareWithMany(message: GroupScopedJs<DecryptedMessageJs>,
			delegates: Array<EntityReferenceInGroupToMessageShareOptionsMapObject_delegate_shareOptions>):
			Promise<GroupScopedJs<DecryptedMessageJs>>

	public fun filterMessagesBy(groupId: String, filter: FilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedMessageJs>>>

	public fun filterMessagesBySorted(groupId: String, filter: SortableFilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<DecryptedMessageJs>>>

	public fun createMessage(entity: GroupScopedJs<DecryptedMessageJs>):
			Promise<GroupScopedJs<DecryptedMessageJs>>

	public fun createMessages(entities: Array<GroupScopedJs<DecryptedMessageJs>>):
			Promise<Array<GroupScopedJs<DecryptedMessageJs>>>

	public fun undeleteMessageById(entityId: GroupScopedJs<StoredDocumentIdentifierJs>):
			Promise<GroupScopedJs<DecryptedMessageJs>>

	public fun undeleteMessagesByIds(entityIds: Array<GroupScopedJs<StoredDocumentIdentifierJs>>):
			Promise<Array<GroupScopedJs<DecryptedMessageJs>>>

	public fun undeleteMessage(message: GroupScopedJs<MessageJs>):
			Promise<GroupScopedJs<DecryptedMessageJs>>

	public fun undeleteMessages(messages: Array<GroupScopedJs<DecryptedMessageJs>>):
			Promise<Array<GroupScopedJs<DecryptedMessageJs>>>

	public fun modifyMessage(entity: GroupScopedJs<DecryptedMessageJs>):
			Promise<GroupScopedJs<DecryptedMessageJs>>

	public fun modifyMessages(entities: Array<GroupScopedJs<DecryptedMessageJs>>):
			Promise<Array<GroupScopedJs<DecryptedMessageJs>>>

	public fun getMessage(groupId: String, entityId: String):
			Promise<GroupScopedJs<DecryptedMessageJs>?>

	public fun getMessages(groupId: String, entityIds: Array<String>):
			Promise<Array<GroupScopedJs<DecryptedMessageJs>>>
}

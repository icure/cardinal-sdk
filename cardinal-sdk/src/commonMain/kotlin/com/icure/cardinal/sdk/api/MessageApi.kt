package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.crypto.entities.MessageShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.MessageReadStatus
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.subscription.Subscribable
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.EntityEncryptionException
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator
import kotlinx.serialization.json.JsonElement

/* This interface includes the API calls that do not need encryption keys and do not return or consume encrypted/decrypted items, they are completely agnostic towards the presence of encrypted items */
interface MessageBasicFlavourlessApi {

	/**
	 * Deletes a message. If you don't have write access to the Message the method will fail.
	 * @param entityId id of the Message.
	 * @return the id and revision of the deleted Message.
	 */
	suspend fun deleteMessage(entityId: String): DocIdentifier

	/**
	 * Deletes many messages. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids of the messages.
	 * @return the id and revision of the deleted messages. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteMessages(entityIds: List<String>): List<DocIdentifier>
}

/* This interface includes the API calls can be used on decrypted items if encryption keys are available *or* encrypted items if no encryption keys are available */
interface MessageBasicFlavouredApi<E : Message> {
	/**
	 * Modifies a message. You need to have write access to the entity.
	 * Flavoured method.
	 * @param entity a message with update content
	 * @return the Message updated with the provided content and a new revision.
	 */
	suspend fun modifyMessage(entity: E): E

	/**
	 * Get a message by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 * entity, corresponds to an entity that is not a message, or corresponds to an entity for which you don't have
	 * read access.
	 * Flavoured method.
	 * @param entityId a message id.
	 * @return the Message with id [entityId].
	 */
	suspend fun getMessage(entityId: String): E

	/**
	 * Get multiple messages by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 * an entity that is not a message, or correspond to an entity for which you don't have read access.
	 * Flavoured method.
	 * @param entityIds a list of messages ids
	 * @return all messages that you can access with one of the provided ids.
	 */
	suspend fun getMessages(entityIds: List<String>): List<E>

	@Deprecated("Use filter instead")
	suspend fun listMessagesByTransportGuids(hcPartyId: String, transportGuids: List<String>): List<E>

	@Deprecated("Use filter instead")
	suspend fun findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: List<String>): List<E>

	@Deprecated("Use filter instead")
	suspend fun findMessages(startKey: JsonElement?, startDocumentId: String?, limit: Int?): PaginatedList<E>

	@Deprecated("Use filter instead")
	suspend fun getChildrenMessages(messageId: String): List<E>

	@Deprecated("Use filter instead")
	suspend fun getMessagesChildren(messageIds: List<String>): List<E>

	@Deprecated("Use filter instead")
	suspend fun listMessagesByInvoices(invoiceIds: List<String>): List<E>

	@Deprecated("Use filter instead")
	suspend fun findMessagesByTransportGuid(transportGuid: String): PaginatedList<E>

	// TODO: Implement filter for this method
	@Deprecated("Find methods are deprecated", ReplaceWith("filterMessagesBy()"))
	suspend fun findMessagesByTransportGuidSentDate(
		transportGuid: String,
		from: Long,
		to: Long,
		@DefaultValue("null")
		startKey: JsonElement? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		@DefaultValue("null")
		hcpId: String? = null,
	): PaginatedList<E>

	// TODO: Implement filter for this method
	@Deprecated("Find methods are deprecated", ReplaceWith("filterMessagesBy()"))
	suspend fun findMessagesByToAddress(toAddress: String, startKey: JsonElement?, startDocumentId: String?, limit: Int?): PaginatedList<E>

	// TODO: Implement filter for this method
	@Deprecated("Find methods are deprecated", ReplaceWith("filterMessagesBy()"))
	suspend fun findMessagesByFromAddress(
		fromAddress: String,
		startKey: JsonElement?,
		startDocumentId: String?,
		limit: Int?,
    ): PaginatedList<E>

	@Deprecated("Status bits have unclear meaning, use read status instead")
	suspend fun setMessagesStatusBits(entityIds: List<String>, statusBits: Int): List<E>

	/**
	 * Updates the [Message.readStatus] of messages with the provided ids. You can use this method even if you don't
	 * have write permissions on the message, but you still need read permissions.
	 *
	 * Depending on the permissions of the current user the method may have some restrictions:
	 * - If the user does not have the permission `MessageManagement.ReadStatusUpdate.UnrestrictedUser` then the [userId]
	 *   must be either null or the current user id.
	 * - If the user does not have the permission `MessageManagement.ReadStatusUpdate.UnrestrictedTime` then [time] must
	 *   be null (will be set automatically by the server)
	 * If one of these two restrictions is not respected the method will fail.
	 *
	 * Additionally, unless the user has the `MessageManagement.ReadStatusUpdate.UnrestrictedEntryOverride`, the status
	 * update request will only succeed in the following condition:
	 * - If the [readStatus] is false there must no entry in the [Message.readStatus] for [userId] (the message goes from
	 *   undelivered to delivered but unread)
	 * - If the [readStatus] is true there must either be no entry in [Message.readStatus] for [userId] (the message goes
	 *   from undelivered to read), or there is an entry with [MessageReadStatus.read] set to false (the message goes from
	 *   delivered to read).
	 * If for a specific message these conditions are not satisfied (and the user does not have the
	 * `MessageManagement.ReadStatusUpdate.UnrestrictedEntryOverride` permission), or if the user does not have read
	 * access to that method that message will be ignored and will not be included in the result. Other messages will
	 * still be updated if they satisfy these condition.
	 *
	 * @param entityIds the ids of the messages to update
	 * @param time the unix timestamp of when the message was read
	 * @param readStatus true if the message was read, false if it was just received.
	 * @param userId the id of the user for which the status should be updated. Null will be considered as the current
	 * user id.
	 * @return the updated messages.
	 */
	suspend fun setMessagesReadStatus(entityIds: List<String>, time: Long?, readStatus: Boolean, userId: String?): List<E>
}

/* The extra API calls declared in this interface are the ones that can be used on encrypted or decrypted items but only when the user is a data owner */
interface MessageFlavouredApi<E : Message> : MessageBasicFlavouredApi<E> {
	/**
	 * Share a message with another data owner. The Message must already exist in the database for this method to
	 * succeed. If you want to share the Message before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param delegateId the owner that will gain access to the Message
	 * @param message the Message to share with [delegateId]
	 * @param options specifies how the Message will be shared. Refer to the documentation of [MessageShareOptions] for
	 * more information.
	 * @return the updated Message if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun shareWith(
		delegateId: String,
		message: E,
		options: MessageShareOptions
	): SimpleShareResult<E>

	/**
	 * Share a message with multiple data owners. The Message must already exist in the database for this method to
	 * succeed. If you want to share the Message before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * @param message the Message to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated Message if the sharing was successful, or details on the errors if the sharing failed.
	 */
	suspend fun tryShareWithMany(
		message: E,
		delegates: Map<String, MessageShareOptions>
	): SimpleShareResult<E>

	/**
	 * Share a message with multiple data owners. The Message must already exist in the database for this method to
	 * succeed. If you want to share the Message before creation you should instead pass provide the delegates in
	 * the initialize encryption metadata method.
	 * Throws an exception if the operation fails.
	 * @param message the Message to share
	 * @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 * each of them.
	 * @return the updated Message.
	 */
	suspend fun shareWithMany(
		message: E,
		delegates: Map<String, MessageShareOptions>
	): E

	@Deprecated("Use filter instead")
	suspend fun findMessagesByHcPartyPatient(
		hcPartyId: String,
		patient: Patient,
		@DefaultValue("null")
		startDate: Long? = null,
		@DefaultValue("null")
		endDate: Long? = null,
		@DefaultValue("null")
		descending: Boolean? = null,
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all messages matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterMessagesBySorted] instead.
	 *
	 * @param filter a message filter
	 * @return an iterator that iterates over all messages matching the provided filter.
	 */
	suspend fun filterMessagesBy(
		filter: FilterOptions<Message>
	): PaginatedListIterator<E>

	/**
	 * Get an iterator that iterates through all messages matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterMessagesBy].
	 *
	 * @param filter a message filter
	 * @return an iterator that iterates over all messages matching the provided filter.
	 */
	suspend fun filterMessagesBySorted(
		filter: SortableFilterOptions<Message>
	): PaginatedListIterator<E>
}

/* The extra API calls declared in this interface are the ones that can only be used on decrypted items when encryption keys are available */
interface MessageApi : MessageBasicFlavourlessApi, MessageFlavouredApi<DecryptedMessage>, Subscribable<Message, EncryptedMessage, FilterOptions<Message>> {
	/**
	 * Create a new Message. The provided Message must have the encryption metadata initialized. This method requires
	 * the permission to create messages outside of topics. If you want to create a message within a topic use the
	 * [createMessageInTopic] method instead.
	 * @param entity a message with initialized encryption metadata
	 * @return the created Message with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createMessage(entity: DecryptedMessage): DecryptedMessage

	/**
	 * Create a new Message. The provided Message must have the encryption metadata initialized, and the id of the topic
	 * set in [Message.transportGuid] (note that your configuration must not encrypt the transport guid). The user needs
	 * to be a participant in that topic for this method to succeed.
	 * @param entity a message with initialized encryption metadata and with a transportGuid set to the topic
	 * @return the created Message with updated revision.
	 * @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	suspend fun createMessageInTopic(entity: DecryptedMessage): DecryptedMessage

	/**
	 * Creates a new Message with initialized encryption metadata
	 * @param base a message with initialized content and uninitialized encryption metadata. The result of this
	 * method takes the content from [base] if provided.
	 * @param patient the patient linked to the Message.
	 * @param user the current user, will be used for the auto-delegations if provided.
	 * @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 * permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 * @param secretId specifies which secret id of [patient] to use for the new Message
	 * @return a message with initialized encryption metadata.
	 * @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	suspend fun withEncryptionMetadata(
		base: DecryptedMessage?,
		patient: Patient?,
		@DefaultValue("null")
		user: User? = null,
		@DefaultValue("emptyMap()")
		delegates: Map<String, AccessLevel> = emptyMap(),
		@DefaultValue("com.icure.cardinal.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent")
		secretId: SecretIdUseOption = SecretIdUseOption.UseAnySharedWithParent,
	): DecryptedMessage

	/**
	 * Attempts to extract the encryption keys of a message. If the user does not have access to any encryption key
	 * of the access log the method will return an empty set.
	 * Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 * versions of iCure where this was not a guarantee.
	 * @param message a message
	 * @return the encryption keys extracted from the provided Message.
	 */
	suspend fun getEncryptionKeysOf(message: Message): Set<HexString>

	/**
	 * Specifies if the current user has write access to a message.
	 * @param message a message
	 * @return if the current user has write access to the provided Message
	 */
	suspend fun hasWriteAccess(message: Message): Boolean

	/**
	 * Attempts to extract the patient id linked to a message.
	 * Note: messages usually should be linked with only one patient, but this method returns a set for compatibility
	 * with older versions of iCure
	 * @param message a message
	 * @return the id of the patient linked to the Message, or empty if the current user can't access any patient id
	 * of the Message.
	 */
	suspend fun decryptPatientIdOf(message: Message): Set<String>

	/**
	 * Create metadata to allow other users to identify the anonymous delegates of a message.
	 *
	 * When calling this method the SDK will use all the information available to the current user to try to identify
	 * any anonymous data-owners in the delegations of the provided Message. The SDK will be able to identify the
	 * anonymous data owners of the delegations only under the following conditions:
	 * - The other participant of the delegation is the current data owner
	 * - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 * current data owner
	 * - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 * After identifying the anonymous delegates in the Message the sdk will create the corresponding de-anonymization
	 * metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 * Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Message,
	 * not only in the provided instance.
	 *
	 * ## Example
	 *
	 * If you have a message E, and you have shared it with patient P and healthcare party H, H will not
	 * be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 * H. From now on, for any Message that you have shared with P, H will be able to know that the Message was
	 * shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 * At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 * delegator-delegate pair, you will not be able to see if P has access to a message that was created by H and
	 * shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 * @param entity a message
	 * @param delegates a set of data owner ids
	 */
	suspend fun createDelegationDeAnonymizationMetadata(entity: Message, delegates: Set<String>)

	/**
	 * Decrypts a message, throwing an exception if it is not possible.
	 * @param message a message
	 * @return the decrypted Message
	 * @throws EntityEncryptionException if the Message could not be decrypted
	 */
	suspend fun decrypt(message: EncryptedMessage): DecryptedMessage

	/**
	 * Tries to decrypt a message, returns the input if it is not possible.
	 * @param message an encrypted Message
	 * @return the decrypted Message if the decryption was successful or the input if it was not.
	 */
	suspend fun tryDecrypt(message: EncryptedMessage): Message
	
	/**
	 * Give access to the encrypted flavour of the api
	 */
	val encrypted: MessageFlavouredApi<EncryptedMessage>

	/**
	 * Gives access to the polymorphic flavour of the api
	 */
	val tryAndRecover: MessageFlavouredApi<Message>

	/**
	 * Get the ids of all messages matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchMessagesBySorted] instead.
	 *
	 * @param filter a message filter
	 * @return a list of message ids
	 */
	suspend fun matchMessagesBy(filter: FilterOptions<Message>): List<String>

	/**
	 * Get the ids of all messages matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchMessagesBy].
	 *
	 * @param filter a message filter
	 * @return a list of message ids
	 */
	suspend fun matchMessagesBySorted(filter: SortableFilterOptions<Message>): List<String>
}

interface MessageBasicApi : MessageBasicFlavourlessApi, MessageBasicFlavouredApi<EncryptedMessage>, Subscribable<Message, EncryptedMessage, BaseFilterOptions<Message>> {
	/**
	 * Get the ids of all messages matching the provided filter.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [matchMessagesBySorted] instead.
	 *
	 * @param filter a message filter
	 * @return a list of message ids
	 */
	suspend fun matchMessagesBy(filter: BaseFilterOptions<Message>): List<String>

	/**
	 * Get the ids of all messages matching the provided filter.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [matchMessagesBy].
	 *
	 * @param filter a message filter
	 * @return a list of message ids
	 */
	suspend fun matchMessagesBySorted(filter: BaseSortableFilterOptions<Message>): List<String>

	/**
	 * Get an iterator that iterates through all messages matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 * Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 * or to the internal iCure implementations, may cause future invocations to return unordered data.
	 * If you need ordered data use [filterMessagesBySorted] instead.
	 *
	 * @param filter a message filter
	 * @return an iterator that iterates over all messages matching the provided filter.
	 */
	suspend fun filterMessagesBy(
		filter: BaseFilterOptions<Message>
	): PaginatedListIterator<EncryptedMessage>

	/**
	 * Get an iterator that iterates through all messages matching the provided filter, executing multiple requests to
	 * the api if needed.
	 *
	 * This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 * but the operation may take longer than [filterMessagesBy].
	 *
	 * @param filter a message filter
	 * @return an iterator that iterates over all messages matching the provided filter.
	 */
	suspend fun filterMessagesBySorted(
		filter: BaseSortableFilterOptions<Message>
	): PaginatedListIterator<EncryptedMessage>
}


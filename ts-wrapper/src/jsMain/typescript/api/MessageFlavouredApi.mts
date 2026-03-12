// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {MessageShareOptions} from '../crypto/entities/MessageShareOptions.mjs';
import {Message} from '../model/Message.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface MessageFlavouredApi<E extends Message> {

	/**
	 *
	 *  Share a message with another data owner. The Message must already exist in the database for this method to
	 *  succeed. If you want to share the Message before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  @param delegateId the owner that will gain access to the Message
	 *  @param message the Message to share with [delegateId]
	 *  @param options specifies how the Message will be shared. Refer to the documentation of [MessageShareOptions] for
	 *  more information.
	 *  @return the updated Message if the sharing was successful, or details on the errors if the sharing failed.
	 */
	shareWith(delegateId: string, message: E,
			options?: { options?: MessageShareOptions | undefined }): Promise<E>;

	/**
	 *
	 *  Share a message with multiple data owners. The Message must already exist in the database for this method to
	 *  succeed. If you want to share the Message before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  Throws an exception if the operation fails.
	 *  @param message the Message to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated Message.
	 */
	shareWithMany(message: E, delegates: { [ key: string ]: MessageShareOptions }): Promise<E>;

	/**
	 *
	 *  Get an iterator that iterates through all messages matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [filterMessagesBySorted] instead.
	 *
	 *  @param filter a message filter
	 *  @return an iterator that iterates over all messages matching the provided filter.
	 */
	filterMessagesBy(filter: FilterOptions<Message>): Promise<PaginatedListIterator<E>>;

	/**
	 *
	 *  Get an iterator that iterates through all messages matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [filterMessagesBy].
	 *
	 *  @param filter a message filter
	 *  @return an iterator that iterates over all messages matching the provided filter.
	 */
	filterMessagesBySorted(filter: SortableFilterOptions<Message>): Promise<PaginatedListIterator<E>>;

	/**
	 *
	 *  Create a new Message. The provided Message must have the encryption metadata initialized. This method requires
	 *  the permission to create messages outside of topics. If you want to create a message within a topic use the
	 *  [createMessageInTopic] method instead.
	 *  @param entity a message with initialized encryption metadata
	 *  @return the created Message with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createMessage(entity: E): Promise<E>;

	/**
	 *
	 *  Create multiple messages. All the provided messages must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything. This method requires the permission to create messages outside of topics.
	 *  @param entities messages with initialized encryption metadata
	 *  @return the created messages with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any message in the input was not initialized.
	 */
	createMessages(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Create a new Message. The provided Message must have the encryption metadata initialized, and the id of the topic
	 *  set in [Message.transportGuid] (note that your configuration must not encrypt the transport guid). The user needs
	 *  to be a participant in that topic for this method to succeed.
	 *  @param entity a message with initialized encryption metadata and with a transportGuid set to the topic
	 *  @return the created Message with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createMessageInTopic(entity: E): Promise<E>;

	/**
	 *
	 *  Restores a message that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteMessageById(id: string, rev: string): Promise<E>;

	/**
	 *
	 *  Restores a batch of messages that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the messages to restore.
	 *  @return the restored messages. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteMessagesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a message that was marked as deleted.
	 *  @param message the message to undelete
	 *  @return the restored message.
	 *  @throws RevisionConflictException if the provided message doesn't match the latest known revision
	 */
	undeleteMessage(message: Message): Promise<E>;

	/**
	 *
	 *  Restores a batch of messages that were marked as deleted.
	 *  @param messages the messages to restore.
	 *  @return the restored messages. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteMessages(messages: Array<Message>): Promise<Array<E>>;

	/**
	 *
	 *  Modifies a message. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a message with update content
	 *  @return the Message updated with the provided content and a new revision.
	 */
	modifyMessage(entity: E): Promise<E>;

	/**
	 *
	 *  Modifies multiple messages. Ignores all messages for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities messages with update content
	 *  @return the updated messages with a new revision.
	 */
	modifyMessages(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Get a message by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a message, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a message id.
	 *  @return the Message with id [entityId].
	 */
	getMessage(entityId: string): Promise<E | undefined>;

	/**
	 *
	 *  Get multiple messages by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a message, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of messages ids
	 *  @return all messages that you can access with one of the provided ids.
	 */
	getMessages(entityIds: Array<string>): Promise<Array<E>>;

	/**
	 *
	 *  Updates the [Message.readStatus] of messages with the provided ids. You can use this method even if you don't
	 *  have write permissions on the message, but you still need read permissions.
	 *
	 *  Depending on the permissions of the current user the method may have some restrictions:
	 *  - If the user does not have the permission `MessageManagement.ReadStatusUpdate.UnrestrictedUser` then the [userId]
	 *    must be either null or the current user id.
	 *  - If the user does not have the permission `MessageManagement.ReadStatusUpdate.UnrestrictedTime` then [time] must
	 *    be null (will be set automatically by the server)
	 *  If one of these two restrictions is not respected the method will fail.
	 *
	 *  Additionally, unless the user has the `MessageManagement.ReadStatusUpdate.UnrestrictedEntryOverride`, the status
	 *  update request will only succeed in the following condition:
	 *  - If the [readStatus] is false there must no entry in the [Message.readStatus] for [userId] (the message goes from
	 *    undelivered to delivered but unread)
	 *  - If the [readStatus] is true there must either be no entry in [Message.readStatus] for [userId] (the message goes
	 *    from undelivered to read), or there is an entry with [MessageReadStatus.read] set to false (the message goes from
	 *    delivered to read).
	 *  If for a specific message these conditions are not satisfied (and the user does not have the
	 *  `MessageManagement.ReadStatusUpdate.UnrestrictedEntryOverride` permission), or if the user does not have read
	 *  access to that method that message will be ignored and will not be included in the result. Other messages will
	 *  still be updated if they satisfy these condition.
	 *
	 *  @param entityIds the ids of the messages to update
	 *  @param time the unix timestamp of when the message was read
	 *  @param readStatus true if the message was read, false if it was just received.
	 *  @param userId the id of the user for which the status should be updated. Null will be considered as the current
	 *  user id.
	 *  @return the updated messages.
	 */
	setMessagesReadStatus(entityIds: Array<string>, time: number | undefined, readStatus: boolean,
			userId: string | undefined): Promise<Array<E>>;

}

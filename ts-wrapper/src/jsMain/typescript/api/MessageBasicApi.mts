// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EncryptedMessage, Message} from '../model/Message.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {MessageBasicInGroupApi} from './MessageBasicInGroupApi.mjs';


export interface MessageBasicApi {

	inGroup: MessageBasicInGroupApi;

	/**
	 *
	 *  Get the ids of all messages matching the provided filter.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [matchMessagesBySorted] instead.
	 *
	 *  @param filter a message filter
	 *  @return a list of message ids
	 */
	matchMessagesBy(filter: BaseFilterOptions<Message>): Promise<Array<string>>;

	/**
	 *
	 *  Get the ids of all messages matching the provided filter.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [matchMessagesBy].
	 *
	 *  @param filter a message filter
	 *  @return a list of message ids
	 */
	matchMessagesBySorted(filter: BaseSortableFilterOptions<Message>): Promise<Array<string>>;

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
	filterMessagesBy(filter: BaseFilterOptions<Message>): Promise<PaginatedListIterator<EncryptedMessage>>;

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
	filterMessagesBySorted(filter: BaseSortableFilterOptions<Message>): Promise<PaginatedListIterator<EncryptedMessage>>;

	/**
	 *
	 *  Deletes a message. If you don't have write access to the message the method will fail.
	 *  @param entityId id of the message.
	 *  @param rev the latest known rev of the message to delete
	 *  @return the id and revision of the deleted message.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteMessageById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many messages. Ids that do not correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the messages to delete.
	 *  @return the id and revision of the deleted messages. If some entities could not be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteMessagesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a message.
	 *  @param id id of the message to purge
	 *  @param rev latest revision of the message
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeMessageById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes many messages.
	 *  @param entityIds ids and revisions of the messages to delete
	 *  @return the id and revision of the deleted messages. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeMessagesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Deletes a message. If you don't have write access to the message the method will fail.
	 *  @param message the message to delete
	 *  @return the id and revision of the deleted message.
	 *  @throws RevisionConflictException if the provided message doesn't match the latest known revision
	 */
	deleteMessage(message: Message): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many messages. Ignores message for which you don't have write access or that don't match the latest revision.
	 *  @param messages the messages to delete
	 *  @return the id and revision of the deleted messages. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteMessages(messages: Array<Message>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a message.
	 *  @param message the message to purge.
	 *  @throws RevisionConflictException if the provided message doesn't match the latest known revision
	 */
	purgeMessage(message: Message): Promise<void>;

	/**
	 *
	 *  Permanently deletes many messages.
	 *  @param messages the messages to purge.
	 *  @return the id and revision of the deleted messages. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeMessages(messages: Array<Message>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Create a new Message. The provided Message must have the encryption metadata initialized. This method requires
	 *  the permission to create messages outside of topics. If you want to create a message within a topic use the
	 *  [createMessageInTopic] method instead.
	 *  @param entity a message with initialized encryption metadata
	 *  @return the created Message with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createMessage(entity: EncryptedMessage): Promise<EncryptedMessage>;

	/**
	 *
	 *  Create multiple messages. All the provided messages must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything. This method requires the permission to create messages outside of topics.
	 *  @param entities messages with initialized encryption metadata
	 *  @return the created messages with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any message in the input was not initialized.
	 */
	createMessages(entities: Array<EncryptedMessage>): Promise<Array<EncryptedMessage>>;

	/**
	 *
	 *  Create a new Message. The provided Message must have the encryption metadata initialized, and the id of the topic
	 *  set in [Message.transportGuid] (note that your configuration must not encrypt the transport guid). The user needs
	 *  to be a participant in that topic for this method to succeed.
	 *  @param entity a message with initialized encryption metadata and with a transportGuid set to the topic
	 *  @return the created Message with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createMessageInTopic(entity: EncryptedMessage): Promise<EncryptedMessage>;

	/**
	 *
	 *  Restores a message that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteMessageById(id: string, rev: string): Promise<EncryptedMessage>;

	/**
	 *
	 *  Restores a batch of messages that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the messages to restore.
	 *  @return the restored messages. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteMessagesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedMessage>>;

	/**
	 *
	 *  Restores a message that was marked as deleted.
	 *  @param message the message to undelete
	 *  @return the restored message.
	 *  @throws RevisionConflictException if the provided message doesn't match the latest known revision
	 */
	undeleteMessage(message: Message): Promise<EncryptedMessage>;

	/**
	 *
	 *  Restores a batch of messages that were marked as deleted.
	 *  @param messages the messages to restore.
	 *  @return the restored messages. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteMessages(messages: Array<Message>): Promise<Array<EncryptedMessage>>;

	/**
	 *
	 *  Modifies a message. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a message with update content
	 *  @return the Message updated with the provided content and a new revision.
	 */
	modifyMessage(entity: EncryptedMessage): Promise<EncryptedMessage>;

	/**
	 *
	 *  Modifies multiple messages. Ignores all messages for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities messages with update content
	 *  @return the updated messages with a new revision.
	 */
	modifyMessages(entities: Array<EncryptedMessage>): Promise<Array<EncryptedMessage>>;

	/**
	 *
	 *  Get a message by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a message, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a message id.
	 *  @return the Message with id [entityId].
	 */
	getMessage(entityId: string): Promise<EncryptedMessage | undefined>;

	/**
	 *
	 *  Get multiple messages by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a message, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of messages ids
	 *  @return all messages that you can access with one of the provided ids.
	 */
	getMessages(entityIds: Array<string>): Promise<Array<EncryptedMessage>>;

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
			userId: string | undefined): Promise<Array<EncryptedMessage>>;

	/**
	 *
	 *  Subscribe to receive real-time notifications when an entity is updated.
	 *  @param events the type of events that will be notified to the subscription
	 *  @param filter the subscription will receive notifications only for entities matching this filter, you should
	 *  make the filter as restrictive as possible.
	 *  @param subscriptionConfig customize the configuration for the subscription
	 *  @return a subscription that receives notifications for the configured events.
	 */
	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<Message>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedMessage>>;

}

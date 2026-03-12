// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {MessageShareOptions} from '../crypto/entities/MessageShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {DecryptedMessage, EncryptedMessage, Message} from '../model/Message.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {MessageFlavouredApi} from './MessageFlavouredApi.mjs';
import {MessageInGroupApi} from './MessageInGroupApi.mjs';


export interface MessageApi {

	encrypted: MessageFlavouredApi<EncryptedMessage>;

	tryAndRecover: MessageFlavouredApi<Message>;

	inGroup: MessageInGroupApi;

	/**
	 *
	 *  Creates a new Message with initialized encryption metadata
	 *  @param base a message with initialized content and uninitialized encryption metadata. The result of this
	 *  method takes the content from [base] if provided.
	 *  @param patient the patient linked to the Message.
	 *  @param user the current user, will be used for the auto-delegations if provided.
	 *  @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 *  permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 *  @param secretId specifies which secret id of [patient] to use for the new Message
	 *  @return a message with initialized encryption metadata.
	 *  @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	withEncryptionMetadata(base: DecryptedMessage | undefined, patient: Patient | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedMessage>;

	/**
	 *
	 *  Attempts to extract the encryption keys of a message. If the user does not have access to any encryption key
	 *  of the access log the method will return an empty set.
	 *  Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 *  versions of iCure where this was not a guarantee.
	 *  @param message a message
	 *  @return the encryption keys extracted from the provided Message.
	 */
	getEncryptionKeysOf(message: Message): Promise<Array<HexString>>;

	/**
	 *
	 *  Specifies if the current user has write access to a message through delegations.
	 *  Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 *  thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 *  if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 *  side this method will still return true if there is a delegation to the parent.
	 *  @param message a message
	 *  @return if the current user has write access to the provided Message
	 */
	hasWriteAccess(message: Message): Promise<boolean>;

	/**
	 *
	 *  Attempts to extract the patient id linked to a message.
	 *  Note: messages usually should be linked with only one patient, but this method returns a set for compatibility
	 *  with older versions of iCure
	 *  @param message a message
	 *  @return the id of the patient linked to the Message, or empty if the current user can't access any patient id
	 *  of the Message.
	 */
	decryptPatientIdOf(message: Message): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  Create metadata to allow other users to identify the anonymous delegates of a message.
	 *
	 *  When calling this method the SDK will use all the information available to the current user to try to identify
	 *  any anonymous data-owners in the delegations of the provided Message. The SDK will be able to identify the
	 *  anonymous data owners of the delegations only under the following conditions:
	 *  - The other participant of the delegation is the current data owner
	 *  - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 *  current data owner
	 *  - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 *  After identifying the anonymous delegates in the Message the sdk will create the corresponding de-anonymization
	 *  metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 *  Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Message,
	 *  not only in the provided instance.
	 *
	 *  ## Example
	 *
	 *  If you have a message E, and you have shared it with patient P and healthcare party H, H will not
	 *  be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 *  H. From now on, for any Message that you have shared with P, H will be able to know that the Message was
	 *  shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 *  At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 *  delegator-delegate pair, you will not be able to see if P has access to a message that was created by H and
	 *  shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 *  @param entity a message
	 *  @param delegates a set of data owner ids
	 */
	createDelegationDeAnonymizationMetadata(entity: Message, delegates: Array<string>): Promise<void>;

	/**
	 *
	 *  Decrypts a message, throwing an exception if it is not possible.
	 *  @param message a message
	 *  @return the decrypted Message
	 *  @throws EntityEncryptionException if the Message could not be decrypted
	 */
	decrypt(message: EncryptedMessage): Promise<DecryptedMessage>;

	/**
	 *
	 *  Tries to decrypt a message, returns the input if it is not possible.
	 *  @param message an encrypted Message
	 *  @return the decrypted Message if the decryption was successful or the input if it was not.
	 */
	tryDecrypt(message: EncryptedMessage): Promise<Message>;

	/**
	 *
	 *  Encrypts provided decrypted Messages, and validates already encrypted Messages.
	 *  @param messages Messages to encrypt and/or validate
	 *  @return the encrypted and validates Messages
	 *  @throws EntityEncryptionException if any of the provided decrypted Messages couldn't be encrypted (the current
	 *  user can't access its encryption key or no key was initialized) or if the already encrypted Messages don't
	 *  respect the manifest.
	 */
	encryptOrValidate(messages: Array<Message>): Promise<Array<EncryptedMessage>>;

	/**
	 *
	 *  Get all the secret ids that the current data owner can access from the provided message.
	 *  @param message a message
	 *  @return a map where the keys are the secret ids of the patient and the value is a set of references
	 *  ([EntityReferenceInGroup]) to the data owners that the current user knows have access to that secret id.
	 */
	getSecretIdsOf(message: Message): Promise<{ [ key: string ]: Array<EntityReferenceInGroup> }>;

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
	matchMessagesBy(filter: FilterOptions<Message>): Promise<Array<string>>;

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
	matchMessagesBySorted(filter: SortableFilterOptions<Message>): Promise<Array<string>>;

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
	shareWith(delegateId: string, message: DecryptedMessage,
			options?: { options?: MessageShareOptions | undefined }): Promise<DecryptedMessage>;

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
	shareWithMany(message: DecryptedMessage,
			delegates: { [ key: string ]: MessageShareOptions }): Promise<DecryptedMessage>;

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
	filterMessagesBy(filter: FilterOptions<Message>): Promise<PaginatedListIterator<DecryptedMessage>>;

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
	filterMessagesBySorted(filter: SortableFilterOptions<Message>): Promise<PaginatedListIterator<DecryptedMessage>>;

	/**
	 *
	 *  Create a new Message. The provided Message must have the encryption metadata initialized. This method requires
	 *  the permission to create messages outside of topics. If you want to create a message within a topic use the
	 *  [createMessageInTopic] method instead.
	 *  @param entity a message with initialized encryption metadata
	 *  @return the created Message with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createMessage(entity: DecryptedMessage): Promise<DecryptedMessage>;

	/**
	 *
	 *  Create multiple messages. All the provided messages must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything. This method requires the permission to create messages outside of topics.
	 *  @param entities messages with initialized encryption metadata
	 *  @return the created messages with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any message in the input was not initialized.
	 */
	createMessages(entities: Array<DecryptedMessage>): Promise<Array<DecryptedMessage>>;

	/**
	 *
	 *  Create a new Message. The provided Message must have the encryption metadata initialized, and the id of the topic
	 *  set in [Message.transportGuid] (note that your configuration must not encrypt the transport guid). The user needs
	 *  to be a participant in that topic for this method to succeed.
	 *  @param entity a message with initialized encryption metadata and with a transportGuid set to the topic
	 *  @return the created Message with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createMessageInTopic(entity: DecryptedMessage): Promise<DecryptedMessage>;

	/**
	 *
	 *  Restores a message that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteMessageById(id: string, rev: string): Promise<DecryptedMessage>;

	/**
	 *
	 *  Restores a batch of messages that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the messages to restore.
	 *  @return the restored messages. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteMessagesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedMessage>>;

	/**
	 *
	 *  Restores a message that was marked as deleted.
	 *  @param message the message to undelete
	 *  @return the restored message.
	 *  @throws RevisionConflictException if the provided message doesn't match the latest known revision
	 */
	undeleteMessage(message: Message): Promise<DecryptedMessage>;

	/**
	 *
	 *  Restores a batch of messages that were marked as deleted.
	 *  @param messages the messages to restore.
	 *  @return the restored messages. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteMessages(messages: Array<Message>): Promise<Array<DecryptedMessage>>;

	/**
	 *
	 *  Modifies a message. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a message with update content
	 *  @return the Message updated with the provided content and a new revision.
	 */
	modifyMessage(entity: DecryptedMessage): Promise<DecryptedMessage>;

	/**
	 *
	 *  Modifies multiple messages. Ignores all messages for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities messages with update content
	 *  @return the updated messages with a new revision.
	 */
	modifyMessages(entities: Array<DecryptedMessage>): Promise<Array<DecryptedMessage>>;

	/**
	 *
	 *  Get a message by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a message, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a message id.
	 *  @return the Message with id [entityId].
	 */
	getMessage(entityId: string): Promise<DecryptedMessage | undefined>;

	/**
	 *
	 *  Get multiple messages by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a message, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of messages ids
	 *  @return all messages that you can access with one of the provided ids.
	 */
	getMessages(entityIds: Array<string>): Promise<Array<DecryptedMessage>>;

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
			userId: string | undefined): Promise<Array<DecryptedMessage>>;

	/**
	 *
	 *  Subscribe to receive real-time notifications when an entity is updated.
	 *  @param events the type of events that will be notified to the subscription
	 *  @param filter the subscription will receive notifications only for entities matching this filter, you should
	 *  make the filter as restrictive as possible.
	 *  @param subscriptionConfig customize the configuration for the subscription
	 *  @return a subscription that receives notifications for the configured events.
	 */
	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<Message>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedMessage>>;

}

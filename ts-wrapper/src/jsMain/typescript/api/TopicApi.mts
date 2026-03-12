// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {TopicShareOptions} from '../crypto/entities/TopicShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {DecryptedTopic, EncryptedTopic, Topic} from '../model/Topic.mjs';
import {TopicRole} from '../model/TopicRole.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {TopicFlavouredApi} from './TopicFlavouredApi.mjs';
import {TopicInGroupApi} from './TopicInGroupApi.mjs';


export interface TopicApi {

	encrypted: TopicFlavouredApi<EncryptedTopic>;

	tryAndRecover: TopicFlavouredApi<Topic>;

	inGroup: TopicInGroupApi;

	/**
	 *
	 *  Creates a new topic with initialized encryption metadata
	 *  @param base a topic with initialized content and uninitialized encryption metadata. The result of this
	 *  method takes the content from [base] if provided.
	 *  @param patient the patient linked to the topic.
	 *  @param user the current user, will be used for the auto-delegations if provided.
	 *  @param delegates additional data owners that will have access to the newly created entity. You may choose the
	 *  permissions that the delegates will have on the entity, but they will have access to all encryption metadata.
	 *  @param secretId specifies which secret id of [patient] to use for the new topic
	 *  @return a topic with initialized encryption metadata.
	 *  @throws IllegalArgumentException if base is not null and has a revision or has encryption metadata.
	 */
	withEncryptionMetadata(base: DecryptedTopic | undefined, patient: Patient | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedTopic>;

	/**
	 *
	 *  Attempts to extract the encryption keys of a topic. If the user does not have access to any encryption key
	 *  of the access log the method will return an empty set.
	 *  Note: entities now have only one encryption key, but this method returns a set for compatibility with older
	 *  versions of iCure where this was not a guarantee.
	 *  @param topic a topic
	 *  @return the encryption keys extracted from the provided topic.
	 */
	getEncryptionKeysOf(topic: Topic): Promise<Array<HexString>>;

	/**
	 *
	 *  Specifies if the current user has write access to a topic through delegations.
	 *  Doesn't consider actual permissions on the server side: for example, if the data owner has access to all entities
	 *  thanks to extended permission but has no delegation on the provided entity this method returns false. Similarly,
	 *  if the SDK was initialized in hierarchical mode but the user is lacking the hierarchical permission on the server
	 *  side this method will still return true if there is a delegation to the parent.
	 *  @param topic a topic
	 *  @return if the current user has write access to the provided topic
	 */
	hasWriteAccess(topic: Topic): Promise<boolean>;

	/**
	 *
	 *  Attempts to extract the patient id linked to a topic.
	 *  Note: topics usually should be linked with only one patient, but this method returns a set for compatibility
	 *  with older versions of iCure
	 *  @param topic a topic
	 *  @return the id of the patient linked to the topic, or empty if the current user can't access any patient id
	 *  of the topic.
	 */
	decryptPatientIdOf(topic: Topic): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  Create metadata to allow other users to identify the anonymous delegates of a topic.
	 *
	 *  When calling this method the SDK will use all the information available to the current user to try to identify
	 *  any anonymous data-owners in the delegations of the provided topic. The SDK will be able to identify the
	 *  anonymous data owners of the delegations only under the following conditions:
	 *  - The other participant of the delegation is the current data owner
	 *  - The SDK is using hierarchical data owners and the other participant of the delegation is a parent of the
	 *  current data owner
	 *  - There is de-anonymization metadata for the delegation shared with the current data owner.
	 *
	 *  After identifying the anonymous delegates in the topic the sdk will create the corresponding de-anonymization
	 *  metadata if it does not yet exist, and then share it with the provided delegates.
	 *
	 *  Note that this delegation metadata may be used to de-anonymize the corresponding delegation in any Topic,
	 *  not only in the provided instance.
	 *
	 *  ## Example
	 *
	 *  If you have a topic E, and you have shared it with patient P and healthcare party H, H will not
	 *  be able to know that P has access to E until you create delegations de anonymization metadata and share that with
	 *  H. From now on, for any topic that you have shared with P, H will be able to know that the topic was
	 *  shared with P, regardless of whether it was created before or after the corresponding de-anonymization metadata.
	 *
	 *  At the same time since the de-anonymization metadata applies to a specific delegation and therefore to a specific
	 *  delegator-delegate pair, you will not be able to see if P has access to a topic that was created by H and
	 *  shared with you and P unless also H creates delegations de-anonymization metadata.
	 *
	 *  @param entity a topic
	 *  @param delegates a set of data owner ids
	 */
	createDelegationDeAnonymizationMetadata(entity: Topic, delegates: Array<string>): Promise<void>;

	/**
	 *
	 *  Decrypts a topic, throwing an exception if it is not possible.
	 *  @param topic a topic
	 *  @return the decrypted topic
	 *  @throws EntityEncryptionException if the topic could not be decrypted
	 */
	decrypt(topic: EncryptedTopic): Promise<DecryptedTopic>;

	/**
	 *
	 *  Tries to decrypt a topic, returns the input if it is not possible.
	 *  @param topic an encrypted topic
	 *  @return the decrypted topic if the decryption was successful or the input if it was not.
	 */
	tryDecrypt(topic: EncryptedTopic): Promise<Topic>;

	/**
	 *
	 *  Get the ids of all topics matching the provided filter.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [matchTopicsBySorted] instead.
	 *
	 *  @param filter a topic filter
	 *  @return a list of topic ids
	 */
	matchTopicsBy(filter: FilterOptions<Topic>): Promise<Array<string>>;

	/**
	 *
	 *  Get the ids of all topics matching the provided filter.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [matchTopicsBy].
	 *
	 *  @param filter a topic filter
	 *  @return a list of topic ids
	 */
	matchTopicsBySorted(filter: SortableFilterOptions<Topic>): Promise<Array<string>>;

	/**
	 *
	 *  Deletes a topic. If you don't have write access to the topic the method will fail.
	 *  @param entityId id of the topic.
	 *  @param rev the latest known rev of the topic to delete
	 *  @return the id and revision of the deleted topic.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteTopicById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many topics. Ids that do not correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the topics to delete.
	 *  @return the id and revision of the deleted topics. If some entities could not be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteTopicsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a topic.
	 *  @param id id of the topic to purge
	 *  @param rev latest revision of the topic
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeTopicById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes many topics.
	 *  @param entityIds ids and revisions of the topics to delete
	 *  @return the id and revision of the deleted topics. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeTopicsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Deletes a topic. If you don't have write access to the topic the method will fail.
	 *  @param topic the topic to delete
	 *  @return the id and revision of the deleted topic.
	 *  @throws RevisionConflictException if the provided topic doesn't match the latest known revision
	 */
	deleteTopic(topic: Topic): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many topics. Ignores topic for which you don't have write access or that don't match the latest revision.
	 *  @param topics the topics to delete
	 *  @return the id and revision of the deleted topics. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteTopics(topics: Array<Topic>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a topic.
	 *  @param topic the topic to purge.
	 *  @throws RevisionConflictException if the provided topic doesn't match the latest known revision
	 */
	purgeTopic(topic: Topic): Promise<void>;

	/**
	 *
	 *  Permanently deletes many topics.
	 *  @param topics the topics to purge.
	 *  @return the id and revision of the deleted topics. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeTopics(topics: Array<Topic>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Share a topic with another data owner. The topic must already exist in the database for this method to
	 *  succeed. If you want to share the topic before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  @param delegateId the owner that will gain access to the topic
	 *  @param topic the topic to share with [delegateId]
	 *  @param options specifies how the topic will be shared. By default, all data available to the current user
	 *  will be shared, and the delegate will have the same permissions as the current user on the topic. Refer
	 *  to the documentation of [TopicShareOptions] for more information.
	 *  @return the updated topic if the sharing was successful, or details on the errors if the sharing failed.
	 */
	shareWith(delegateId: string, topic: DecryptedTopic,
			options?: { options?: TopicShareOptions | undefined }): Promise<DecryptedTopic>;

	/**
	 *
	 *  Share a topic with multiple data owners. The topic must already exist in the database for this method to
	 *  succeed. If you want to share the topic before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  Throws an exception if the operation fails.
	 *  @param topic the topic to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated topic.
	 */
	shareWithMany(topic: DecryptedTopic,
			delegates: { [ key: string ]: TopicShareOptions }): Promise<DecryptedTopic>;

	/**
	 *
	 *  Get an iterator that iterates through all topics matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method does not guarantee that the returned data will be ordered when using sortable filter options.
	 *  Even if the data obtained from an invocation of the method appears to be ordered, any changes to the stored data,
	 *  or to the internal iCure implementations, may cause future invocations to return unordered data.
	 *  If you need ordered data use [filterTopicsBySorted] instead.
	 *
	 *  @param filter a topic filter
	 *  @return an iterator that iterates over all topics matching the provided filter.
	 */
	filterTopicsBy(filter: FilterOptions<Topic>): Promise<PaginatedListIterator<DecryptedTopic>>;

	/**
	 *
	 *  Get an iterator that iterates through all topics matching the provided filter, executing multiple requests to
	 *  the api if needed.
	 *
	 *  This method guarantees that the returned data will be ordered using the rules specified by the provided filter,
	 *  but the operation may take longer than [filterTopicsBy].
	 *
	 *  @param filter a topic filter
	 *  @return an iterator that iterates over all topics matching the provided filter.
	 */
	filterTopicsBySorted(filter: SortableFilterOptions<Topic>): Promise<PaginatedListIterator<DecryptedTopic>>;

	/**
	 *
	 *  Create a new topic. The provided topic must have the encryption metadata initialized.
	 *  @param entity a topic with initialized encryption metadata
	 *  @return the created topic with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createTopic(entity: DecryptedTopic): Promise<DecryptedTopic>;

	/**
	 *
	 *  Create multiple topics. All the provided topics must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities topics with initialized encryption metadata
	 *  @return the created topics with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any topic in the input was not initialized.
	 */
	createTopics(entities: Array<DecryptedTopic>): Promise<Array<DecryptedTopic>>;

	/**
	 *
	 *  Restores a topic that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteTopicById(id: string, rev: string): Promise<DecryptedTopic>;

	/**
	 *
	 *  Restores a batch of topics that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the topics to restore.
	 *  @return the restored topics. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteTopicsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedTopic>>;

	/**
	 *
	 *  Restores a topic that was marked as deleted.
	 *  @param topic the topic to undelete
	 *  @return the restored topic.
	 *  @throws RevisionConflictException if the provided topic doesn't match the latest known revision
	 */
	undeleteTopic(topic: Topic): Promise<DecryptedTopic>;

	/**
	 *
	 *  Restores a batch of topics that were marked as deleted.
	 *  @param topics the topics to restore.
	 *  @return the restored topics. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteTopics(topics: Array<Topic>): Promise<Array<DecryptedTopic>>;

	/**
	 *
	 *  Modifies a topic. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a topic with update content
	 *  @return the topic updated with the provided content and a new revision.
	 */
	modifyTopic(entity: DecryptedTopic): Promise<DecryptedTopic>;

	/**
	 *
	 *  Modifies multiple topics. Ignores all topics for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities topics with update content
	 *  @return the updated topics with a new revision.
	 */
	modifyTopics(entities: Array<DecryptedTopic>): Promise<Array<DecryptedTopic>>;

	/**
	 *
	 *  Get a topic by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a topic, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a topic id.
	 *  @return the topic with id [entityId].
	 */
	getTopic(entityId: string): Promise<DecryptedTopic | undefined>;

	/**
	 *
	 *  Get multiple topics by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a topic, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of topics ids
	 *  @return all topics that you can access with one of the provided ids.
	 */
	getTopics(entityIds: Array<string>): Promise<Array<DecryptedTopic>>;

	/**
	 *
	 *  Add a participant to the topic. The participant will be able to create messages associated to the topic.
	 *  Any user with a [TopicRole.Admin] on the can use this method, even if they don't have direct write access
	 *  to it through delegations.
	 *  @param entityId id of the topic
	 *  @param dataOwnerId id of the new participant
	 *  @param topicRole the role that the participant will have in the topic
	 *  @return the updated topic
	 */
	addParticipant(entityId: string, dataOwnerId: string,
			topicRole: TopicRole): Promise<DecryptedTopic>;

	/**
	 *
	 *  Removes a participant from a topic. The participant will not be able anymore to search for messages of that topic.
	 *  Any user with a [TopicRole.Admin] on the can use this method, even if they don't have direct write access
	 *  to it through delegations.
	 *  @param entityId id of the topic
	 *  @param dataOwnerId id of the participant to remove
	 *  @return the updated topic
	 */
	removeParticipant(entityId: string, dataOwnerId: string): Promise<DecryptedTopic>;

	/**
	 *
	 *  Subscribe to receive real-time notifications when an entity is updated.
	 *  @param events the type of events that will be notified to the subscription
	 *  @param filter the subscription will receive notifications only for entities matching this filter, you should
	 *  make the filter as restrictive as possible.
	 *  @param subscriptionConfig customize the configuration for the subscription
	 *  @return a subscription that receives notifications for the configured events.
	 */
	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<Topic>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedTopic>>;

}

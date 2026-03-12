// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {EncryptedTopic, Topic} from '../model/Topic.mjs';
import {TopicRole} from '../model/TopicRole.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {TopicBasicInGroupApi} from './TopicBasicInGroupApi.mjs';


export interface TopicBasicApi {

	inGroup: TopicBasicInGroupApi;

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
	matchTopicsBy(filter: BaseFilterOptions<Topic>): Promise<Array<string>>;

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
	matchTopicsBySorted(filter: BaseSortableFilterOptions<Topic>): Promise<Array<string>>;

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
	filterTopicsBy(filter: BaseFilterOptions<Topic>): Promise<PaginatedListIterator<EncryptedTopic>>;

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
	filterTopicsBySorted(filter: BaseSortableFilterOptions<Topic>): Promise<PaginatedListIterator<EncryptedTopic>>;

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
	 *  Create a new topic. The provided topic must have the encryption metadata initialized.
	 *  @param entity a topic with initialized encryption metadata
	 *  @return the created topic with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createTopic(entity: EncryptedTopic): Promise<EncryptedTopic>;

	/**
	 *
	 *  Create multiple topics. All the provided topics must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities topics with initialized encryption metadata
	 *  @return the created topics with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any topic in the input was not initialized.
	 */
	createTopics(entities: Array<EncryptedTopic>): Promise<Array<EncryptedTopic>>;

	/**
	 *
	 *  Restores a topic that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteTopicById(id: string, rev: string): Promise<EncryptedTopic>;

	/**
	 *
	 *  Restores a batch of topics that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the topics to restore.
	 *  @return the restored topics. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteTopicsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedTopic>>;

	/**
	 *
	 *  Restores a topic that was marked as deleted.
	 *  @param topic the topic to undelete
	 *  @return the restored topic.
	 *  @throws RevisionConflictException if the provided topic doesn't match the latest known revision
	 */
	undeleteTopic(topic: Topic): Promise<EncryptedTopic>;

	/**
	 *
	 *  Restores a batch of topics that were marked as deleted.
	 *  @param topics the topics to restore.
	 *  @return the restored topics. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteTopics(topics: Array<Topic>): Promise<Array<EncryptedTopic>>;

	/**
	 *
	 *  Modifies a topic. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a topic with update content
	 *  @return the topic updated with the provided content and a new revision.
	 */
	modifyTopic(entity: EncryptedTopic): Promise<EncryptedTopic>;

	/**
	 *
	 *  Modifies multiple topics. Ignores all topics for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities topics with update content
	 *  @return the updated topics with a new revision.
	 */
	modifyTopics(entities: Array<EncryptedTopic>): Promise<Array<EncryptedTopic>>;

	/**
	 *
	 *  Get a topic by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a topic, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a topic id.
	 *  @return the topic with id [entityId].
	 */
	getTopic(entityId: string): Promise<EncryptedTopic | undefined>;

	/**
	 *
	 *  Get multiple topics by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a topic, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of topics ids
	 *  @return all topics that you can access with one of the provided ids.
	 */
	getTopics(entityIds: Array<string>): Promise<Array<EncryptedTopic>>;

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
			topicRole: TopicRole): Promise<EncryptedTopic>;

	/**
	 *
	 *  Removes a participant from a topic. The participant will not be able anymore to search for messages of that topic.
	 *  Any user with a [TopicRole.Admin] on the can use this method, even if they don't have direct write access
	 *  to it through delegations.
	 *  @param entityId id of the topic
	 *  @param dataOwnerId id of the participant to remove
	 *  @return the updated topic
	 */
	removeParticipant(entityId: string, dataOwnerId: string): Promise<EncryptedTopic>;

	/**
	 *
	 *  Subscribe to receive real-time notifications when an entity is updated.
	 *  @param events the type of events that will be notified to the subscription
	 *  @param filter the subscription will receive notifications only for entities matching this filter, you should
	 *  make the filter as restrictive as possible.
	 *  @param subscriptionConfig customize the configuration for the subscription
	 *  @return a subscription that receives notifications for the configured events.
	 */
	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<Topic>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedTopic>>;

}

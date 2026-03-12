// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {TopicShareOptions} from '../crypto/entities/TopicShareOptions.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {Topic} from '../model/Topic.mjs';
import {TopicRole} from '../model/TopicRole.mjs';


export interface TopicFlavouredApi<E extends Topic> {

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
	shareWith(delegateId: string, topic: E,
			options?: { options?: TopicShareOptions | undefined }): Promise<E>;

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
	shareWithMany(topic: E, delegates: { [ key: string ]: TopicShareOptions }): Promise<E>;

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
	filterTopicsBy(filter: FilterOptions<Topic>): Promise<PaginatedListIterator<E>>;

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
	filterTopicsBySorted(filter: SortableFilterOptions<Topic>): Promise<PaginatedListIterator<E>>;

	/**
	 *
	 *  Create a new topic. The provided topic must have the encryption metadata initialized.
	 *  @param entity a topic with initialized encryption metadata
	 *  @return the created topic with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createTopic(entity: E): Promise<E>;

	/**
	 *
	 *  Create multiple topics. All the provided topics must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities topics with initialized encryption metadata
	 *  @return the created topics with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any topic in the input was not initialized.
	 */
	createTopics(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a topic that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteTopicById(id: string, rev: string): Promise<E>;

	/**
	 *
	 *  Restores a batch of topics that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the topics to restore.
	 *  @return the restored topics. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteTopicsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a topic that was marked as deleted.
	 *  @param topic the topic to undelete
	 *  @return the restored topic.
	 *  @throws RevisionConflictException if the provided topic doesn't match the latest known revision
	 */
	undeleteTopic(topic: Topic): Promise<E>;

	/**
	 *
	 *  Restores a batch of topics that were marked as deleted.
	 *  @param topics the topics to restore.
	 *  @return the restored topics. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteTopics(topics: Array<Topic>): Promise<Array<E>>;

	/**
	 *
	 *  Modifies a topic. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a topic with update content
	 *  @return the topic updated with the provided content and a new revision.
	 */
	modifyTopic(entity: E): Promise<E>;

	/**
	 *
	 *  Modifies multiple topics. Ignores all topics for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities topics with update content
	 *  @return the updated topics with a new revision.
	 */
	modifyTopics(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Get a topic by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a topic, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a topic id.
	 *  @return the topic with id [entityId].
	 */
	getTopic(entityId: string): Promise<E | undefined>;

	/**
	 *
	 *  Get multiple topics by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a topic, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of topics ids
	 *  @return all topics that you can access with one of the provided ids.
	 */
	getTopics(entityIds: Array<string>): Promise<Array<E>>;

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
	addParticipant(entityId: string, dataOwnerId: string, topicRole: TopicRole): Promise<E>;

	/**
	 *
	 *  Removes a participant from a topic. The participant will not be able anymore to search for messages of that topic.
	 *  Any user with a [TopicRole.Admin] on the can use this method, even if they don't have direct write access
	 *  to it through delegations.
	 *  @param entityId id of the topic
	 *  @param dataOwnerId id of the participant to remove
	 *  @return the updated topic
	 */
	removeParticipant(entityId: string, dataOwnerId: string): Promise<E>;

}

// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {TopicShareOptions} from '../crypto/entities/TopicShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {Topic} from '../model/Topic.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface TopicFlavouredInGroupApi<E extends Topic> {

	/**
	 *
	 *  In-group version of [TopicFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, topic: GroupScoped<E>,
			options?: { options?: TopicShareOptions | undefined }): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [TopicFlavouredApi.shareWithMany]
	 */
	shareWithMany(topic: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: TopicShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [TopicFlavouredApi.filterTopicsBy]
	 */
	filterTopicsBy(groupId: string,
			filter: FilterOptions<Topic>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [TopicFlavouredApi.filterTopicsBySorted]
	 */
	filterTopicsBySorted(groupId: string,
			filter: SortableFilterOptions<Topic>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.createTopic]
	 */
	createTopic(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.createTopics]
	 */
	createTopics(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.undeleteTopicById]
	 */
	undeleteTopicById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.undeleteTopicsByIds]
	 */
	undeleteTopicsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.undeleteTopic]
	 */
	undeleteTopic(topic: GroupScoped<Topic>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.undeleteTopics]
	 */
	undeleteTopics(topics: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.modifyTopic]
	 */
	modifyTopic(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.modifyTopics]
	 */
	modifyTopics(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.getTopic]
	 */
	getTopic(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.getTopics]
	 */
	getTopics(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}

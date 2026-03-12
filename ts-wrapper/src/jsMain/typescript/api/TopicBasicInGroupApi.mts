// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {EncryptedTopic, Topic} from '../model/Topic.mjs';


export interface TopicBasicInGroupApi {

	/**
	 *
	 *  In-group version of [TopicBasicApi.matchTopicsBy]
	 */
	matchTopicsBy(groupId: string, filter: BaseFilterOptions<Topic>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [TopicBasicApi.matchTopicsBySorted]
	 */
	matchTopicsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Topic>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [TopicBasicApi.filterTopicsBy]
	 */
	filterTopicsBy(groupId: string,
			filter: BaseFilterOptions<Topic>): Promise<PaginatedListIterator<GroupScoped<EncryptedTopic>>>;

	/**
	 *
	 *  In-group version of [TopicBasicApi.filterTopicsBySorted]
	 */
	filterTopicsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Topic>): Promise<PaginatedListIterator<GroupScoped<EncryptedTopic>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavourlessApi.deleteTopicById]
	 */
	deleteTopicById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavourlessApi.deleteTopicsByIds]
	 */
	deleteTopicsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavourlessApi.purgeTopicById]
	 */
	purgeTopicById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavourlessApi.purgeTopicsByIds]
	 */
	purgeTopicsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavourlessApi.deleteTopic]
	 */
	deleteTopic(topic: GroupScoped<Topic>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavourlessApi.deleteTopics]
	 */
	deleteTopics(topics: Array<GroupScoped<Topic>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavourlessApi.purgeTopic]
	 */
	purgeTopic(topic: GroupScoped<Topic>): Promise<void>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavourlessApi.purgeTopics]
	 */
	purgeTopics(topics: Array<GroupScoped<Topic>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.createTopic]
	 */
	createTopic(entity: GroupScoped<EncryptedTopic>): Promise<GroupScoped<EncryptedTopic>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.createTopics]
	 */
	createTopics(entities: Array<GroupScoped<EncryptedTopic>>): Promise<Array<GroupScoped<EncryptedTopic>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.undeleteTopicById]
	 */
	undeleteTopicById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedTopic>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.undeleteTopicsByIds]
	 */
	undeleteTopicsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedTopic>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.undeleteTopic]
	 */
	undeleteTopic(topic: GroupScoped<Topic>): Promise<GroupScoped<EncryptedTopic>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.undeleteTopics]
	 */
	undeleteTopics(topics: Array<GroupScoped<EncryptedTopic>>): Promise<Array<GroupScoped<EncryptedTopic>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.modifyTopic]
	 */
	modifyTopic(entity: GroupScoped<EncryptedTopic>): Promise<GroupScoped<EncryptedTopic>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.modifyTopics]
	 */
	modifyTopics(entities: Array<GroupScoped<EncryptedTopic>>): Promise<Array<GroupScoped<EncryptedTopic>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.getTopic]
	 */
	getTopic(groupId: string, entityId: string): Promise<GroupScoped<EncryptedTopic> | undefined>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.getTopics]
	 */
	getTopics(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedTopic>>>;

}

// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {EncryptedTopic, Topic} from '../model/Topic.mjs';


export interface TopicBasicInGroupApi {

	matchTopicsBy(groupId: string, filter: BaseFilterOptions<Topic>): Promise<Array<string>>;

	matchTopicsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Topic>): Promise<Array<string>>;

	filterTopicsBy(groupId: string,
			filter: BaseFilterOptions<Topic>): Promise<PaginatedListIterator<GroupScoped<EncryptedTopic>>>;

	filterTopicsBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Topic>): Promise<PaginatedListIterator<GroupScoped<EncryptedTopic>>>;

	deleteTopicById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteTopicsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeTopicById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeTopicsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteTopic(topic: GroupScoped<Topic>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteTopics(topics: Array<GroupScoped<Topic>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeTopic(topic: GroupScoped<Topic>): Promise<void>;

	purgeTopics(topics: Array<GroupScoped<Topic>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	createTopic(entity: GroupScoped<EncryptedTopic>): Promise<GroupScoped<EncryptedTopic>>;

	createTopics(entities: Array<GroupScoped<EncryptedTopic>>): Promise<Array<GroupScoped<EncryptedTopic>>>;

	undeleteTopicById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedTopic>>;

	undeleteTopicsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedTopic>>>;

	undeleteTopic(topic: GroupScoped<Topic>): Promise<GroupScoped<EncryptedTopic>>;

	undeleteTopics(topics: Array<GroupScoped<EncryptedTopic>>): Promise<Array<GroupScoped<EncryptedTopic>>>;

	modifyTopic(entity: GroupScoped<EncryptedTopic>): Promise<GroupScoped<EncryptedTopic>>;

	modifyTopics(entities: Array<GroupScoped<EncryptedTopic>>): Promise<Array<GroupScoped<EncryptedTopic>>>;

	getTopic(groupId: string, entityId: string): Promise<GroupScoped<EncryptedTopic> | undefined>;

	getTopics(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedTopic>>>;

}

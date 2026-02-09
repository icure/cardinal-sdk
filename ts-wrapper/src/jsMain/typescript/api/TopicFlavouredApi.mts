// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {TopicShareOptions} from '../crypto/entities/TopicShareOptions.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {Topic} from '../model/Topic.mjs';
import {TopicRole} from '../model/TopicRole.mjs';


export interface TopicFlavouredApi<E extends Topic> {

	shareWith(delegateId: string, topic: E,
			options?: { options?: TopicShareOptions | undefined }): Promise<E>;

	shareWithMany(topic: E, delegates: { [ key: string ]: TopicShareOptions }): Promise<E>;

	filterTopicsBy(filter: FilterOptions<Topic>): Promise<PaginatedListIterator<E>>;

	filterTopicsBySorted(filter: SortableFilterOptions<Topic>): Promise<PaginatedListIterator<E>>;

	createTopic(entity: E): Promise<E>;

	createTopics(entities: Array<E>): Promise<Array<E>>;

	undeleteTopicById(id: string, rev: string): Promise<E>;

	undeleteTopicsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	undeleteTopic(topic: Topic): Promise<E>;

	undeleteTopics(topics: Array<Topic>): Promise<Array<E>>;

	modifyTopic(entity: E): Promise<E>;

	modifyTopics(entities: Array<E>): Promise<Array<E>>;

	getTopic(entityId: string): Promise<E | undefined>;

	getTopics(entityIds: Array<string>): Promise<Array<E>>;

	addParticipant(entityId: string, dataOwnerId: string, topicRole: TopicRole): Promise<E>;

	removeParticipant(entityId: string, dataOwnerId: string): Promise<E>;

}

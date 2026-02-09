// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {TopicShareOptions} from '../crypto/entities/TopicShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {Topic} from '../model/Topic.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface TopicFlavouredInGroupApi<E extends Topic> {

	shareWith(delegate: EntityReferenceInGroup, topic: GroupScoped<E>,
			options?: { options?: TopicShareOptions | undefined }): Promise<GroupScoped<E>>;

	shareWithMany(topic: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: TopicShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	filterTopicsBy(groupId: string,
			filter: FilterOptions<Topic>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	filterTopicsBySorted(groupId: string,
			filter: SortableFilterOptions<Topic>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	createTopic(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	createTopics(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	undeleteTopicById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	undeleteTopicsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	undeleteTopic(topic: GroupScoped<Topic>): Promise<GroupScoped<E>>;

	undeleteTopics(topics: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	modifyTopic(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	modifyTopics(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	getTopic(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	getTopics(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}

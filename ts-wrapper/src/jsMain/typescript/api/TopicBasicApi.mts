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

	matchTopicsBy(filter: BaseFilterOptions<Topic>): Promise<Array<string>>;

	matchTopicsBySorted(filter: BaseSortableFilterOptions<Topic>): Promise<Array<string>>;

	filterTopicsBy(filter: BaseFilterOptions<Topic>): Promise<PaginatedListIterator<EncryptedTopic>>;

	filterTopicsBySorted(filter: BaseSortableFilterOptions<Topic>): Promise<PaginatedListIterator<EncryptedTopic>>;

	deleteTopicById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteTopicsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeTopicById(id: string, rev: string): Promise<void>;

	purgeTopicsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteTopic(topic: Topic): Promise<StoredDocumentIdentifier>;

	deleteTopics(topics: Array<Topic>): Promise<Array<StoredDocumentIdentifier>>;

	purgeTopic(topic: Topic): Promise<void>;

	purgeTopics(topics: Array<Topic>): Promise<Array<StoredDocumentIdentifier>>;

	createTopic(entity: EncryptedTopic): Promise<EncryptedTopic>;

	createTopics(entities: Array<EncryptedTopic>): Promise<Array<EncryptedTopic>>;

	undeleteTopicById(id: string, rev: string): Promise<EncryptedTopic>;

	undeleteTopicsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedTopic>>;

	undeleteTopic(topic: Topic): Promise<EncryptedTopic>;

	undeleteTopics(topics: Array<Topic>): Promise<Array<EncryptedTopic>>;

	modifyTopic(entity: EncryptedTopic): Promise<EncryptedTopic>;

	modifyTopics(entities: Array<EncryptedTopic>): Promise<Array<EncryptedTopic>>;

	getTopic(entityId: string): Promise<EncryptedTopic | undefined>;

	getTopics(entityIds: Array<string>): Promise<Array<EncryptedTopic>>;

	addParticipant(entityId: string, dataOwnerId: string,
			topicRole: TopicRole): Promise<EncryptedTopic>;

	removeParticipant(entityId: string, dataOwnerId: string): Promise<EncryptedTopic>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<Topic>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedTopic>>;

}

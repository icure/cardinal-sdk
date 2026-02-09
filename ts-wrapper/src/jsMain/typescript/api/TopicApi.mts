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

	withEncryptionMetadata(base: DecryptedTopic | undefined, patient: Patient | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedTopic>;

	getEncryptionKeysOf(topic: Topic): Promise<Array<HexString>>;

	hasWriteAccess(topic: Topic): Promise<boolean>;

	decryptPatientIdOf(topic: Topic): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: Topic, delegates: Array<string>): Promise<void>;

	decrypt(topic: EncryptedTopic): Promise<DecryptedTopic>;

	tryDecrypt(topic: EncryptedTopic): Promise<Topic>;

	matchTopicsBy(filter: FilterOptions<Topic>): Promise<Array<string>>;

	matchTopicsBySorted(filter: SortableFilterOptions<Topic>): Promise<Array<string>>;

	deleteTopicById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteTopicsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeTopicById(id: string, rev: string): Promise<void>;

	purgeTopicsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteTopic(topic: Topic): Promise<StoredDocumentIdentifier>;

	deleteTopics(topics: Array<Topic>): Promise<Array<StoredDocumentIdentifier>>;

	purgeTopic(topic: Topic): Promise<void>;

	purgeTopics(topics: Array<Topic>): Promise<Array<StoredDocumentIdentifier>>;

	shareWith(delegateId: string, topic: DecryptedTopic,
			options?: { options?: TopicShareOptions | undefined }): Promise<DecryptedTopic>;

	shareWithMany(topic: DecryptedTopic,
			delegates: { [ key: string ]: TopicShareOptions }): Promise<DecryptedTopic>;

	filterTopicsBy(filter: FilterOptions<Topic>): Promise<PaginatedListIterator<DecryptedTopic>>;

	filterTopicsBySorted(filter: SortableFilterOptions<Topic>): Promise<PaginatedListIterator<DecryptedTopic>>;

	createTopic(entity: DecryptedTopic): Promise<DecryptedTopic>;

	createTopics(entities: Array<DecryptedTopic>): Promise<Array<DecryptedTopic>>;

	undeleteTopicById(id: string, rev: string): Promise<DecryptedTopic>;

	undeleteTopicsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedTopic>>;

	undeleteTopic(topic: Topic): Promise<DecryptedTopic>;

	undeleteTopics(topics: Array<Topic>): Promise<Array<DecryptedTopic>>;

	modifyTopic(entity: DecryptedTopic): Promise<DecryptedTopic>;

	modifyTopics(entities: Array<DecryptedTopic>): Promise<Array<DecryptedTopic>>;

	getTopic(entityId: string): Promise<DecryptedTopic | undefined>;

	getTopics(entityIds: Array<string>): Promise<Array<DecryptedTopic>>;

	addParticipant(entityId: string, dataOwnerId: string,
			topicRole: TopicRole): Promise<DecryptedTopic>;

	removeParticipant(entityId: string, dataOwnerId: string): Promise<DecryptedTopic>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<Topic>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedTopic>>;

}

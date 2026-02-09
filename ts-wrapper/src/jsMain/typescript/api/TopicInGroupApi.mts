// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {TopicShareOptions} from '../crypto/entities/TopicShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {DecryptedTopic, EncryptedTopic, Topic} from '../model/Topic.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';
import {TopicFlavouredInGroupApi} from './TopicFlavouredInGroupApi.mjs';


export interface TopicInGroupApi {

	encrypted: TopicFlavouredInGroupApi<EncryptedTopic>;

	tryAndRecover: TopicFlavouredInGroupApi<Topic>;

	withEncryptionMetadata(groupId: string, base: DecryptedTopic | undefined,
			patient: GroupScoped<Patient> | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<GroupScoped<DecryptedTopic>>;

	getEncryptionKeysOf(topic: GroupScoped<Topic>): Promise<Array<HexString>>;

	hasWriteAccess(topic: GroupScoped<Topic>): Promise<boolean>;

	decryptPatientIdOf(topic: GroupScoped<Topic>): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: GroupScoped<Topic>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	decrypt(topics: Array<GroupScoped<EncryptedTopic>>): Promise<Array<GroupScoped<DecryptedTopic>>>;

	tryDecrypt(topics: Array<GroupScoped<EncryptedTopic>>): Promise<Array<GroupScoped<Topic>>>;

	matchTopicsBy(groupId: string, filter: FilterOptions<Topic>): Promise<Array<string>>;

	matchTopicsBySorted(groupId: string, filter: SortableFilterOptions<Topic>): Promise<Array<string>>;

	deleteTopicById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteTopicsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeTopicById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeTopicsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteTopic(topic: GroupScoped<Topic>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteTopics(topics: Array<GroupScoped<Topic>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeTopic(topic: GroupScoped<Topic>): Promise<void>;

	purgeTopics(topics: Array<GroupScoped<Topic>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	shareWith(delegate: EntityReferenceInGroup, topic: GroupScoped<DecryptedTopic>,
			options?: { options?: TopicShareOptions | undefined }): Promise<GroupScoped<DecryptedTopic>>;

	shareWithMany(topic: GroupScoped<DecryptedTopic>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: TopicShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedTopic>>;

	filterTopicsBy(groupId: string,
			filter: FilterOptions<Topic>): Promise<PaginatedListIterator<GroupScoped<DecryptedTopic>>>;

	filterTopicsBySorted(groupId: string,
			filter: SortableFilterOptions<Topic>): Promise<PaginatedListIterator<GroupScoped<DecryptedTopic>>>;

	createTopic(entity: GroupScoped<DecryptedTopic>): Promise<GroupScoped<DecryptedTopic>>;

	createTopics(entities: Array<GroupScoped<DecryptedTopic>>): Promise<Array<GroupScoped<DecryptedTopic>>>;

	undeleteTopicById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedTopic>>;

	undeleteTopicsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedTopic>>>;

	undeleteTopic(topic: GroupScoped<Topic>): Promise<GroupScoped<DecryptedTopic>>;

	undeleteTopics(topics: Array<GroupScoped<DecryptedTopic>>): Promise<Array<GroupScoped<DecryptedTopic>>>;

	modifyTopic(entity: GroupScoped<DecryptedTopic>): Promise<GroupScoped<DecryptedTopic>>;

	modifyTopics(entities: Array<GroupScoped<DecryptedTopic>>): Promise<Array<GroupScoped<DecryptedTopic>>>;

	getTopic(groupId: string, entityId: string): Promise<GroupScoped<DecryptedTopic> | undefined>;

	getTopics(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedTopic>>>;

}

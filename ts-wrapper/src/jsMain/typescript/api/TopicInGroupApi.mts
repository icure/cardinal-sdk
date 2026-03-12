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

	/**
	 *
	 *  In-group version of [TopicApi.withEncryptionMetadata]
	 */
	withEncryptionMetadata(groupId: string, base: DecryptedTopic | undefined,
			patient: GroupScoped<Patient> | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<GroupScoped<DecryptedTopic>>;

	/**
	 *
	 *  In-group version of [TopicApi.getEncryptionKeysOf]
	 */
	getEncryptionKeysOf(topic: GroupScoped<Topic>): Promise<Array<HexString>>;

	/**
	 *
	 *  In-group version of [TopicApi.hasWriteAccess]
	 */
	hasWriteAccess(topic: GroupScoped<Topic>): Promise<boolean>;

	/**
	 *
	 *  In-group version of [TopicApi.decryptPatientIdOf]
	 */
	decryptPatientIdOf(topic: GroupScoped<Topic>): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  In-group version of [TopicApi.createDelegationDeAnonymizationMetadata]
	 */
	createDelegationDeAnonymizationMetadata(entity: GroupScoped<Topic>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	/**
	 *
	 *  In-group version of [TopicApi.decrypt]
	 */
	decrypt(topics: Array<GroupScoped<EncryptedTopic>>): Promise<Array<GroupScoped<DecryptedTopic>>>;

	/**
	 *
	 *  In-group version of [TopicApi.tryDecrypt]
	 */
	tryDecrypt(topics: Array<GroupScoped<EncryptedTopic>>): Promise<Array<GroupScoped<Topic>>>;

	/**
	 *
	 *  In-group version of [TopicApi.matchTopicsBy]
	 */
	matchTopicsBy(groupId: string, filter: FilterOptions<Topic>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [TopicApi.matchTopicsBySorted]
	 */
	matchTopicsBySorted(groupId: string, filter: SortableFilterOptions<Topic>): Promise<Array<string>>;

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
	 *  In-group version of [TopicFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, topic: GroupScoped<DecryptedTopic>,
			options?: { options?: TopicShareOptions | undefined }): Promise<GroupScoped<DecryptedTopic>>;

	/**
	 *
	 *  In-group version of [TopicFlavouredApi.shareWithMany]
	 */
	shareWithMany(topic: GroupScoped<DecryptedTopic>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: TopicShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedTopic>>;

	/**
	 *
	 *  In-group version of [TopicFlavouredApi.filterTopicsBy]
	 */
	filterTopicsBy(groupId: string,
			filter: FilterOptions<Topic>): Promise<PaginatedListIterator<GroupScoped<DecryptedTopic>>>;

	/**
	 *
	 *  In-group version of [TopicFlavouredApi.filterTopicsBySorted]
	 */
	filterTopicsBySorted(groupId: string,
			filter: SortableFilterOptions<Topic>): Promise<PaginatedListIterator<GroupScoped<DecryptedTopic>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.createTopic]
	 */
	createTopic(entity: GroupScoped<DecryptedTopic>): Promise<GroupScoped<DecryptedTopic>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.createTopics]
	 */
	createTopics(entities: Array<GroupScoped<DecryptedTopic>>): Promise<Array<GroupScoped<DecryptedTopic>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.undeleteTopicById]
	 */
	undeleteTopicById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedTopic>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.undeleteTopicsByIds]
	 */
	undeleteTopicsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedTopic>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.undeleteTopic]
	 */
	undeleteTopic(topic: GroupScoped<Topic>): Promise<GroupScoped<DecryptedTopic>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.undeleteTopics]
	 */
	undeleteTopics(topics: Array<GroupScoped<DecryptedTopic>>): Promise<Array<GroupScoped<DecryptedTopic>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.modifyTopic]
	 */
	modifyTopic(entity: GroupScoped<DecryptedTopic>): Promise<GroupScoped<DecryptedTopic>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.modifyTopics]
	 */
	modifyTopics(entities: Array<GroupScoped<DecryptedTopic>>): Promise<Array<GroupScoped<DecryptedTopic>>>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.getTopic]
	 */
	getTopic(groupId: string, entityId: string): Promise<GroupScoped<DecryptedTopic> | undefined>;

	/**
	 *
	 *  In-group version of [TopicBasicFlavouredApi.getTopics]
	 */
	getTopics(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedTopic>>>;

}

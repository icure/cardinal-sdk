// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {MessageShareOptions} from '../crypto/entities/MessageShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {DecryptedMessage, EncryptedMessage, Message} from '../model/Message.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';
import {MessageFlavouredInGroupApi} from './MessageFlavouredInGroupApi.mjs';


export interface MessageInGroupApi {

	encrypted: MessageFlavouredInGroupApi<EncryptedMessage>;

	tryAndRecover: MessageFlavouredInGroupApi<Message>;

	/**
	 *
	 *  In-group version of [MessageApi.withEncryptionMetadata]
	 */
	withEncryptionMetadata(entityGroupId: string, base: DecryptedMessage | undefined,
			patient: GroupScoped<Patient> | undefined,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, secretId?: SecretIdUseOption, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedMessage>>;

	/**
	 *
	 *  In-group version of [MessageApi.getEncryptionKeysOf]
	 */
	getEncryptionKeysOf(message: GroupScoped<Message>): Promise<Array<HexString>>;

	/**
	 *
	 *  In-group version of [MessageApi.hasWriteAccess]
	 */
	hasWriteAccess(message: GroupScoped<Message>): Promise<boolean>;

	/**
	 *
	 *  In-group version of [MessageApi.decryptPatientIdOf]
	 */
	decryptPatientIdOf(message: GroupScoped<Message>): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  In-group version of [MessageApi.createDelegationDeAnonymizationMetadata]
	 */
	createDelegationDeAnonymizationMetadata(entity: GroupScoped<Message>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	/**
	 *
	 *  In-group version of [MessageApi.decrypt]
	 */
	decrypt(messages: Array<GroupScoped<EncryptedMessage>>): Promise<Array<GroupScoped<DecryptedMessage>>>;

	/**
	 *
	 *  In-group version of [MessageApi.tryDecrypt]
	 */
	tryDecrypt(messages: Array<GroupScoped<EncryptedMessage>>): Promise<Array<GroupScoped<Message>>>;

	/**
	 *
	 *  In-group version of [MessageApi.matchMessagesBy]
	 */
	matchMessagesBy(groupId: string, filter: FilterOptions<Message>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [MessageApi.matchMessagesBySorted]
	 */
	matchMessagesBySorted(groupId: string,
			filter: SortableFilterOptions<Message>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavourlessApi.deleteMessageById]
	 */
	deleteMessageById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavourlessApi.deleteMessagesByIds]
	 */
	deleteMessagesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavourlessApi.purgeMessageById]
	 */
	purgeMessageById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavourlessApi.purgeMessagesByIds]
	 */
	purgeMessagesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavourlessApi.deleteMessage]
	 */
	deleteMessage(message: GroupScoped<Message>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavourlessApi.deleteMessages]
	 */
	deleteMessages(messages: Array<GroupScoped<Message>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavourlessApi.purgeMessage]
	 */
	purgeMessage(message: GroupScoped<Message>): Promise<void>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavourlessApi.purgeMessages]
	 */
	purgeMessages(messages: Array<GroupScoped<Message>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [MessageFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, message: GroupScoped<DecryptedMessage>,
			options?: { options?: MessageShareOptions | undefined }): Promise<GroupScoped<DecryptedMessage>>;

	/**
	 *
	 *  In-group version of [MessageFlavouredApi.shareWithMany]
	 */
	shareWithMany(message: GroupScoped<DecryptedMessage>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: MessageShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedMessage>>;

	/**
	 *
	 *  In-group version of [MessageFlavouredApi.filterMessagesBy]
	 */
	filterMessagesBy(groupId: string,
			filter: FilterOptions<Message>): Promise<PaginatedListIterator<GroupScoped<DecryptedMessage>>>;

	/**
	 *
	 *  In-group version of [MessageFlavouredApi.filterMessagesBySorted]
	 */
	filterMessagesBySorted(groupId: string,
			filter: SortableFilterOptions<Message>): Promise<PaginatedListIterator<GroupScoped<DecryptedMessage>>>;

	/**
	 *
	 *  In-group version of [MessageApi.createMessage]
	 */
	createMessage(entity: GroupScoped<DecryptedMessage>): Promise<GroupScoped<DecryptedMessage>>;

	/**
	 *
	 *  In-group version of [MessageApi.createMessages]
	 */
	createMessages(entities: Array<GroupScoped<DecryptedMessage>>): Promise<Array<GroupScoped<DecryptedMessage>>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.undeleteMessageById]
	 */
	undeleteMessageById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedMessage>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.undeleteMessagesByIds]
	 */
	undeleteMessagesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedMessage>>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.undeleteMessage]
	 */
	undeleteMessage(message: GroupScoped<Message>): Promise<GroupScoped<DecryptedMessage>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.undeleteMessages]
	 */
	undeleteMessages(messages: Array<GroupScoped<DecryptedMessage>>): Promise<Array<GroupScoped<DecryptedMessage>>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.modifyMessage]
	 */
	modifyMessage(entity: GroupScoped<DecryptedMessage>): Promise<GroupScoped<DecryptedMessage>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.modifyMessages]
	 */
	modifyMessages(entities: Array<GroupScoped<DecryptedMessage>>): Promise<Array<GroupScoped<DecryptedMessage>>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.getMessage]
	 */
	getMessage(groupId: string, entityId: string): Promise<GroupScoped<DecryptedMessage> | undefined>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.getMessages]
	 */
	getMessages(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedMessage>>>;

}

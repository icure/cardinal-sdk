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

	withEncryptionMetadata(entityGroupId: string, base: DecryptedMessage | undefined,
			patient: GroupScoped<Patient> | undefined,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, secretId?: SecretIdUseOption, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedMessage>>;

	getEncryptionKeysOf(message: GroupScoped<Message>): Promise<Array<HexString>>;

	hasWriteAccess(message: GroupScoped<Message>): Promise<boolean>;

	decryptPatientIdOf(message: GroupScoped<Message>): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: GroupScoped<Message>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	decrypt(messages: Array<GroupScoped<EncryptedMessage>>): Promise<Array<GroupScoped<DecryptedMessage>>>;

	tryDecrypt(messages: Array<GroupScoped<EncryptedMessage>>): Promise<Array<GroupScoped<Message>>>;

	matchMessagesBy(groupId: string, filter: FilterOptions<Message>): Promise<Array<string>>;

	matchMessagesBySorted(groupId: string,
			filter: SortableFilterOptions<Message>): Promise<Array<string>>;

	deleteMessageById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteMessagesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeMessageById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeMessagesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteMessage(message: GroupScoped<Message>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteMessages(messages: Array<GroupScoped<Message>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeMessage(message: GroupScoped<Message>): Promise<void>;

	purgeMessages(messages: Array<GroupScoped<Message>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	shareWith(delegate: EntityReferenceInGroup, message: GroupScoped<DecryptedMessage>,
			options?: { options?: MessageShareOptions | undefined }): Promise<GroupScoped<DecryptedMessage>>;

	shareWithMany(message: GroupScoped<DecryptedMessage>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: MessageShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedMessage>>;

	filterMessagesBy(groupId: string,
			filter: FilterOptions<Message>): Promise<PaginatedListIterator<GroupScoped<DecryptedMessage>>>;

	filterMessagesBySorted(groupId: string,
			filter: SortableFilterOptions<Message>): Promise<PaginatedListIterator<GroupScoped<DecryptedMessage>>>;

	createMessage(entity: GroupScoped<DecryptedMessage>): Promise<GroupScoped<DecryptedMessage>>;

	createMessages(entities: Array<GroupScoped<DecryptedMessage>>): Promise<Array<GroupScoped<DecryptedMessage>>>;

	undeleteMessageById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedMessage>>;

	undeleteMessagesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedMessage>>>;

	undeleteMessage(message: GroupScoped<Message>): Promise<GroupScoped<DecryptedMessage>>;

	undeleteMessages(messages: Array<GroupScoped<DecryptedMessage>>): Promise<Array<GroupScoped<DecryptedMessage>>>;

	modifyMessage(entity: GroupScoped<DecryptedMessage>): Promise<GroupScoped<DecryptedMessage>>;

	modifyMessages(entities: Array<GroupScoped<DecryptedMessage>>): Promise<Array<GroupScoped<DecryptedMessage>>>;

	getMessage(groupId: string, entityId: string): Promise<GroupScoped<DecryptedMessage> | undefined>;

	getMessages(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedMessage>>>;

}

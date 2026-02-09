// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {MessageShareOptions} from '../crypto/entities/MessageShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {DecryptedMessage, EncryptedMessage, Message} from '../model/Message.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {MessageFlavouredApi} from './MessageFlavouredApi.mjs';
import {MessageInGroupApi} from './MessageInGroupApi.mjs';


export interface MessageApi {

	encrypted: MessageFlavouredApi<EncryptedMessage>;

	tryAndRecover: MessageFlavouredApi<Message>;

	inGroup: MessageInGroupApi;

	withEncryptionMetadata(base: DecryptedMessage | undefined, patient: Patient | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedMessage>;

	getEncryptionKeysOf(message: Message): Promise<Array<HexString>>;

	hasWriteAccess(message: Message): Promise<boolean>;

	decryptPatientIdOf(message: Message): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: Message, delegates: Array<string>): Promise<void>;

	decrypt(message: EncryptedMessage): Promise<DecryptedMessage>;

	tryDecrypt(message: EncryptedMessage): Promise<Message>;

	encryptOrValidate(messages: Array<Message>): Promise<Array<EncryptedMessage>>;

	getSecretIdsOf(message: Message): Promise<{ [ key: string ]: Array<EntityReferenceInGroup> }>;

	matchMessagesBy(filter: FilterOptions<Message>): Promise<Array<string>>;

	matchMessagesBySorted(filter: SortableFilterOptions<Message>): Promise<Array<string>>;

	deleteMessageById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteMessagesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeMessageById(id: string, rev: string): Promise<void>;

	purgeMessagesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteMessage(message: Message): Promise<StoredDocumentIdentifier>;

	deleteMessages(messages: Array<Message>): Promise<Array<StoredDocumentIdentifier>>;

	purgeMessage(message: Message): Promise<void>;

	purgeMessages(messages: Array<Message>): Promise<Array<StoredDocumentIdentifier>>;

	shareWith(delegateId: string, message: DecryptedMessage,
			options?: { options?: MessageShareOptions | undefined }): Promise<DecryptedMessage>;

	shareWithMany(message: DecryptedMessage,
			delegates: { [ key: string ]: MessageShareOptions }): Promise<DecryptedMessage>;

	filterMessagesBy(filter: FilterOptions<Message>): Promise<PaginatedListIterator<DecryptedMessage>>;

	filterMessagesBySorted(filter: SortableFilterOptions<Message>): Promise<PaginatedListIterator<DecryptedMessage>>;

	createMessage(entity: DecryptedMessage): Promise<DecryptedMessage>;

	createMessages(entities: Array<DecryptedMessage>): Promise<Array<DecryptedMessage>>;

	createMessageInTopic(entity: DecryptedMessage): Promise<DecryptedMessage>;

	undeleteMessageById(id: string, rev: string): Promise<DecryptedMessage>;

	undeleteMessagesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedMessage>>;

	undeleteMessage(message: Message): Promise<DecryptedMessage>;

	undeleteMessages(messages: Array<Message>): Promise<Array<DecryptedMessage>>;

	modifyMessage(entity: DecryptedMessage): Promise<DecryptedMessage>;

	modifyMessages(entities: Array<DecryptedMessage>): Promise<Array<DecryptedMessage>>;

	getMessage(entityId: string): Promise<DecryptedMessage | undefined>;

	getMessages(entityIds: Array<string>): Promise<Array<DecryptedMessage>>;

	setMessagesReadStatus(entityIds: Array<string>, time: number | undefined, readStatus: boolean,
			userId: string | undefined): Promise<Array<DecryptedMessage>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: FilterOptions<Message>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedMessage>>;

}

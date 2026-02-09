// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {EncryptedMessage, Message} from '../model/Message.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {EntitySubscription} from '../subscription/EntitySubscription.mjs';
import {EntitySubscriptionConfiguration} from '../subscription/EntitySubscriptionConfiguration.mjs';
import {SubscriptionEventType} from '../subscription/SubscriptionEventType.mjs';
import {MessageBasicInGroupApi} from './MessageBasicInGroupApi.mjs';


export interface MessageBasicApi {

	inGroup: MessageBasicInGroupApi;

	matchMessagesBy(filter: BaseFilterOptions<Message>): Promise<Array<string>>;

	matchMessagesBySorted(filter: BaseSortableFilterOptions<Message>): Promise<Array<string>>;

	filterMessagesBy(filter: BaseFilterOptions<Message>): Promise<PaginatedListIterator<EncryptedMessage>>;

	filterMessagesBySorted(filter: BaseSortableFilterOptions<Message>): Promise<PaginatedListIterator<EncryptedMessage>>;

	deleteMessageById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteMessagesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeMessageById(id: string, rev: string): Promise<void>;

	purgeMessagesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteMessage(message: Message): Promise<StoredDocumentIdentifier>;

	deleteMessages(messages: Array<Message>): Promise<Array<StoredDocumentIdentifier>>;

	purgeMessage(message: Message): Promise<void>;

	purgeMessages(messages: Array<Message>): Promise<Array<StoredDocumentIdentifier>>;

	createMessage(entity: EncryptedMessage): Promise<EncryptedMessage>;

	createMessages(entities: Array<EncryptedMessage>): Promise<Array<EncryptedMessage>>;

	createMessageInTopic(entity: EncryptedMessage): Promise<EncryptedMessage>;

	undeleteMessageById(id: string, rev: string): Promise<EncryptedMessage>;

	undeleteMessagesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedMessage>>;

	undeleteMessage(message: Message): Promise<EncryptedMessage>;

	undeleteMessages(messages: Array<Message>): Promise<Array<EncryptedMessage>>;

	modifyMessage(entity: EncryptedMessage): Promise<EncryptedMessage>;

	modifyMessages(entities: Array<EncryptedMessage>): Promise<Array<EncryptedMessage>>;

	getMessage(entityId: string): Promise<EncryptedMessage | undefined>;

	getMessages(entityIds: Array<string>): Promise<Array<EncryptedMessage>>;

	setMessagesReadStatus(entityIds: Array<string>, time: number | undefined, readStatus: boolean,
			userId: string | undefined): Promise<Array<EncryptedMessage>>;

	subscribeToEvents(events: Array<SubscriptionEventType>, filter: BaseFilterOptions<Message>,
			options?: { subscriptionConfig?: EntitySubscriptionConfiguration | undefined }): Promise<EntitySubscription<EncryptedMessage>>;

}

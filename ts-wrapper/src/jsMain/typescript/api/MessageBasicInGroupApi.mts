// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {EncryptedMessage, Message} from '../model/Message.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface MessageBasicInGroupApi {

	matchMessagesBy(groupId: string, filter: BaseFilterOptions<Message>): Promise<Array<string>>;

	matchMessagesBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Message>): Promise<Array<string>>;

	filterMessagesBy(groupId: string,
			filter: BaseFilterOptions<Message>): Promise<PaginatedListIterator<GroupScoped<EncryptedMessage>>>;

	filterMessagesBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Message>): Promise<PaginatedListIterator<GroupScoped<EncryptedMessage>>>;

	deleteMessageById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteMessagesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeMessageById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeMessagesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteMessage(message: GroupScoped<Message>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteMessages(messages: Array<GroupScoped<Message>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeMessage(message: GroupScoped<Message>): Promise<void>;

	purgeMessages(messages: Array<GroupScoped<Message>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	createMessage(entity: GroupScoped<EncryptedMessage>): Promise<GroupScoped<EncryptedMessage>>;

	createMessages(entities: Array<GroupScoped<EncryptedMessage>>): Promise<Array<GroupScoped<EncryptedMessage>>>;

	undeleteMessageById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedMessage>>;

	undeleteMessagesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedMessage>>>;

	undeleteMessage(message: GroupScoped<Message>): Promise<GroupScoped<EncryptedMessage>>;

	undeleteMessages(messages: Array<GroupScoped<EncryptedMessage>>): Promise<Array<GroupScoped<EncryptedMessage>>>;

	modifyMessage(entity: GroupScoped<EncryptedMessage>): Promise<GroupScoped<EncryptedMessage>>;

	modifyMessages(entities: Array<GroupScoped<EncryptedMessage>>): Promise<Array<GroupScoped<EncryptedMessage>>>;

	getMessage(groupId: string, entityId: string): Promise<GroupScoped<EncryptedMessage> | undefined>;

	getMessages(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedMessage>>>;

}

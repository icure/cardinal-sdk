// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {EncryptedMessage, Message} from '../model/Message.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface MessageBasicInGroupApi {

	/**
	 *
	 *  In-group version of [MessageApi.matchMessagesBy]
	 */
	matchMessagesBy(groupId: string, filter: BaseFilterOptions<Message>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [MessageApi.matchMessagesBySorted]
	 */
	matchMessagesBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Message>): Promise<Array<string>>;

	/**
	 *
	 *  In-group version of [MessageApi.filterMessagesBy]
	 */
	filterMessagesBy(groupId: string,
			filter: BaseFilterOptions<Message>): Promise<PaginatedListIterator<GroupScoped<EncryptedMessage>>>;

	/**
	 *
	 *  In-group version of [MessageApi.filterMessagesBySorted]
	 */
	filterMessagesBySorted(groupId: string,
			filter: BaseSortableFilterOptions<Message>): Promise<PaginatedListIterator<GroupScoped<EncryptedMessage>>>;

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
	 *  In-group version of [MessageApi.createMessage]
	 */
	createMessage(entity: GroupScoped<EncryptedMessage>): Promise<GroupScoped<EncryptedMessage>>;

	/**
	 *
	 *  In-group version of [MessageApi.createMessages]
	 */
	createMessages(entities: Array<GroupScoped<EncryptedMessage>>): Promise<Array<GroupScoped<EncryptedMessage>>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.undeleteMessageById]
	 */
	undeleteMessageById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedMessage>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.undeleteMessagesByIds]
	 */
	undeleteMessagesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedMessage>>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.undeleteMessage]
	 */
	undeleteMessage(message: GroupScoped<Message>): Promise<GroupScoped<EncryptedMessage>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.undeleteMessages]
	 */
	undeleteMessages(messages: Array<GroupScoped<EncryptedMessage>>): Promise<Array<GroupScoped<EncryptedMessage>>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.modifyMessage]
	 */
	modifyMessage(entity: GroupScoped<EncryptedMessage>): Promise<GroupScoped<EncryptedMessage>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.modifyMessages]
	 */
	modifyMessages(entities: Array<GroupScoped<EncryptedMessage>>): Promise<Array<GroupScoped<EncryptedMessage>>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.getMessage]
	 */
	getMessage(groupId: string, entityId: string): Promise<GroupScoped<EncryptedMessage> | undefined>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.getMessages]
	 */
	getMessages(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedMessage>>>;

}

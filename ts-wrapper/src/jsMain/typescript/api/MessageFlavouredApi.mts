// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {MessageShareOptions} from '../crypto/entities/MessageShareOptions.mjs';
import {Message} from '../model/Message.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface MessageFlavouredApi<E extends Message> {

	shareWith(delegateId: string, message: E,
			options?: { options?: MessageShareOptions | undefined }): Promise<E>;

	shareWithMany(message: E, delegates: { [ key: string ]: MessageShareOptions }): Promise<E>;

	filterMessagesBy(filter: FilterOptions<Message>): Promise<PaginatedListIterator<E>>;

	filterMessagesBySorted(filter: SortableFilterOptions<Message>): Promise<PaginatedListIterator<E>>;

	createMessage(entity: E): Promise<E>;

	createMessages(entities: Array<E>): Promise<Array<E>>;

	createMessageInTopic(entity: E): Promise<E>;

	undeleteMessageById(id: string, rev: string): Promise<E>;

	undeleteMessagesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	undeleteMessage(message: Message): Promise<E>;

	undeleteMessages(messages: Array<Message>): Promise<Array<E>>;

	modifyMessage(entity: E): Promise<E>;

	modifyMessages(entities: Array<E>): Promise<Array<E>>;

	getMessage(entityId: string): Promise<E | undefined>;

	getMessages(entityIds: Array<string>): Promise<Array<E>>;

	setMessagesReadStatus(entityIds: Array<string>, time: number | undefined, readStatus: boolean,
			userId: string | undefined): Promise<Array<E>>;

}

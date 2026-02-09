// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {MessageShareOptions} from '../crypto/entities/MessageShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Message} from '../model/Message.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface MessageFlavouredInGroupApi<E extends Message> {

	shareWith(delegate: EntityReferenceInGroup, message: GroupScoped<E>,
			options?: { options?: MessageShareOptions | undefined }): Promise<GroupScoped<E>>;

	shareWithMany(message: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: MessageShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	filterMessagesBy(groupId: string,
			filter: FilterOptions<Message>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	filterMessagesBySorted(groupId: string,
			filter: SortableFilterOptions<Message>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	createMessage(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	createMessages(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	undeleteMessageById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	undeleteMessagesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	undeleteMessage(message: GroupScoped<Message>): Promise<GroupScoped<E>>;

	undeleteMessages(messages: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	modifyMessage(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	modifyMessages(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	getMessage(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	getMessages(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}

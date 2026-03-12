// auto-generated file
import {FilterOptions, PaginatedListIterator, SortableFilterOptions} from '../cardinal-sdk-ts.mjs';
import {MessageShareOptions} from '../crypto/entities/MessageShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Message} from '../model/Message.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface MessageFlavouredInGroupApi<E extends Message> {

	/**
	 *
	 *  In-group version of [MessageFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, message: GroupScoped<E>,
			options?: { options?: MessageShareOptions | undefined }): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [MessageFlavouredApi.shareWithMany]
	 */
	shareWithMany(message: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: MessageShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [MessageFlavouredApi.filterMessagesBy]
	 */
	filterMessagesBy(groupId: string,
			filter: FilterOptions<Message>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [MessageFlavouredApi.filterMessagesBySorted]
	 */
	filterMessagesBySorted(groupId: string,
			filter: SortableFilterOptions<Message>): Promise<PaginatedListIterator<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [MessageApi.createMessage]
	 */
	createMessage(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [MessageApi.createMessages]
	 */
	createMessages(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.undeleteMessageById]
	 */
	undeleteMessageById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.undeleteMessagesByIds]
	 */
	undeleteMessagesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.undeleteMessage]
	 */
	undeleteMessage(message: GroupScoped<Message>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.undeleteMessages]
	 */
	undeleteMessages(messages: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.modifyMessage]
	 */
	modifyMessage(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.modifyMessages]
	 */
	modifyMessages(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.getMessage]
	 */
	getMessage(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	/**
	 *
	 *  In-group version of [MessageBasicFlavouredApi.getMessages]
	 */
	getMessages(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}

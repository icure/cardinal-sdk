// auto-generated file
import {ReceiptShareOptions} from '../crypto/entities/ReceiptShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Receipt} from '../model/Receipt.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface ReceiptFlavouredInGroupApi<E extends Receipt> {

	/**
	 *
	 *  In-group version of [ReceiptFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, receipt: GroupScoped<E>,
			options?: { options?: ReceiptShareOptions | undefined }): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [ReceiptFlavouredApi.shareWithMany]
	 */
	shareWithMany(receipt: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: ReceiptShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [ReceiptApi.createReceipt]
	 */
	createReceipt(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [ReceiptApi.createReceipts]
	 */
	createReceipts(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.undeleteReceiptById]
	 */
	undeleteReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.undeleteReceiptsByIds]
	 */
	undeleteReceiptsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.undeleteReceipt]
	 */
	undeleteReceipt(receipt: GroupScoped<Receipt>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.undeleteReceipts]
	 */
	undeleteReceipts(receipts: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.modifyReceipt]
	 */
	modifyReceipt(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.modifyReceipts]
	 */
	modifyReceipts(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.getReceipt]
	 */
	getReceipt(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.getReceipts]
	 */
	getReceipts(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}

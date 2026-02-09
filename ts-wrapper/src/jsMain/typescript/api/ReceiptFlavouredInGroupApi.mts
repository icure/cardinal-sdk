// auto-generated file
import {ReceiptShareOptions} from '../crypto/entities/ReceiptShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Receipt} from '../model/Receipt.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface ReceiptFlavouredInGroupApi<E extends Receipt> {

	shareWith(delegate: EntityReferenceInGroup, receipt: GroupScoped<E>,
			options?: { options?: ReceiptShareOptions | undefined }): Promise<GroupScoped<E>>;

	shareWithMany(receipt: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: ReceiptShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	createReceipt(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	createReceipts(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	undeleteReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	undeleteReceiptsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	undeleteReceipt(receipt: GroupScoped<Receipt>): Promise<GroupScoped<E>>;

	undeleteReceipts(receipts: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	modifyReceipt(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	modifyReceipts(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	getReceipt(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	getReceipts(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}

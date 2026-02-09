// auto-generated file
import {ReceiptShareOptions} from '../crypto/entities/ReceiptShareOptions.mjs';
import {Receipt} from '../model/Receipt.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface ReceiptFlavouredApi<E extends Receipt> {

	shareWith(delegateId: string, receipt: E,
			options?: { options?: ReceiptShareOptions | undefined }): Promise<E>;

	shareWithMany(receipt: E, delegates: { [ key: string ]: ReceiptShareOptions }): Promise<E>;

	createReceipt(entity: E): Promise<E>;

	createReceipts(entities: Array<E>): Promise<Array<E>>;

	undeleteReceiptById(id: string, rev: string): Promise<E>;

	undeleteReceiptsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	undeleteReceipt(receipt: Receipt): Promise<E>;

	undeleteReceipts(receipts: Array<Receipt>): Promise<Array<E>>;

	modifyReceipt(entity: E): Promise<E>;

	modifyReceipts(entities: Array<E>): Promise<Array<E>>;

	getReceipt(entityId: string): Promise<E | undefined>;

	getReceipts(entityIds: Array<string>): Promise<Array<E>>;

	listByReference(reference: string): Promise<Array<E>>;

}

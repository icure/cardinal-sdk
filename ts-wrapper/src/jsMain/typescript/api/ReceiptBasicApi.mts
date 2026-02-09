// auto-generated file
import {EncryptedReceipt, Receipt} from '../model/Receipt.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ReceiptBasicInGroupApi} from './ReceiptBasicInGroupApi.mjs';


export interface ReceiptBasicApi {

	inGroup: ReceiptBasicInGroupApi;

	deleteReceiptById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteReceiptsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeReceiptById(id: string, rev: string): Promise<void>;

	purgeReceiptsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteReceipt(receipt: Receipt): Promise<StoredDocumentIdentifier>;

	deleteReceipts(receipts: Array<Receipt>): Promise<Array<StoredDocumentIdentifier>>;

	purgeReceipt(receipt: Receipt): Promise<void>;

	purgeReceipts(receipts: Array<Receipt>): Promise<Array<StoredDocumentIdentifier>>;

	getRawReceiptAttachment(receiptId: string, attachmentId: string): Promise<Int8Array>;

	setRawReceiptAttachment(receiptId: string, rev: string, blobType: string,
			attachment: Int8Array): Promise<EncryptedReceipt>;

	createReceipt(entity: EncryptedReceipt): Promise<EncryptedReceipt>;

	createReceipts(entities: Array<EncryptedReceipt>): Promise<Array<EncryptedReceipt>>;

	undeleteReceiptById(id: string, rev: string): Promise<EncryptedReceipt>;

	undeleteReceiptsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedReceipt>>;

	undeleteReceipt(receipt: Receipt): Promise<EncryptedReceipt>;

	undeleteReceipts(receipts: Array<Receipt>): Promise<Array<EncryptedReceipt>>;

	modifyReceipt(entity: EncryptedReceipt): Promise<EncryptedReceipt>;

	modifyReceipts(entities: Array<EncryptedReceipt>): Promise<Array<EncryptedReceipt>>;

	getReceipt(entityId: string): Promise<EncryptedReceipt | undefined>;

	getReceipts(entityIds: Array<string>): Promise<Array<EncryptedReceipt>>;

	listByReference(reference: string): Promise<Array<EncryptedReceipt>>;

}

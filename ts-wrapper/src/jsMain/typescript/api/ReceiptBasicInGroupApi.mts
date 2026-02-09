// auto-generated file
import {GroupScoped} from '../model/GroupScoped.mjs';
import {EncryptedReceipt, Receipt} from '../model/Receipt.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface ReceiptBasicInGroupApi {

	deleteReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteReceiptsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeReceiptsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteReceipt(receipt: GroupScoped<Receipt>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteReceipts(receipts: Array<GroupScoped<Receipt>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeReceipt(receipt: GroupScoped<Receipt>): Promise<void>;

	purgeReceipts(receipts: Array<GroupScoped<Receipt>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	createReceipt(entity: GroupScoped<EncryptedReceipt>): Promise<GroupScoped<EncryptedReceipt>>;

	createReceipts(entities: Array<GroupScoped<EncryptedReceipt>>): Promise<Array<GroupScoped<EncryptedReceipt>>>;

	undeleteReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedReceipt>>;

	undeleteReceiptsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedReceipt>>>;

	undeleteReceipt(receipt: GroupScoped<Receipt>): Promise<GroupScoped<EncryptedReceipt>>;

	undeleteReceipts(receipts: Array<GroupScoped<EncryptedReceipt>>): Promise<Array<GroupScoped<EncryptedReceipt>>>;

	modifyReceipt(entity: GroupScoped<EncryptedReceipt>): Promise<GroupScoped<EncryptedReceipt>>;

	modifyReceipts(entities: Array<GroupScoped<EncryptedReceipt>>): Promise<Array<GroupScoped<EncryptedReceipt>>>;

	getReceipt(groupId: string, entityId: string): Promise<GroupScoped<EncryptedReceipt> | undefined>;

	getReceipts(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedReceipt>>>;

}

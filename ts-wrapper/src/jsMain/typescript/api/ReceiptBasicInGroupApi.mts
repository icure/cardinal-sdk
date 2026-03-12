// auto-generated file
import {GroupScoped} from '../model/GroupScoped.mjs';
import {EncryptedReceipt, Receipt} from '../model/Receipt.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface ReceiptBasicInGroupApi {

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavourlessApi.deleteReceiptById]
	 */
	deleteReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavourlessApi.deleteReceiptsByIds]
	 */
	deleteReceiptsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavourlessApi.purgeReceiptById]
	 */
	purgeReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavourlessApi.purgeReceiptsByIds]
	 */
	purgeReceiptsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavourlessApi.deleteReceipt]
	 */
	deleteReceipt(receipt: GroupScoped<Receipt>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavourlessApi.deleteReceipts]
	 */
	deleteReceipts(receipts: Array<GroupScoped<Receipt>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavourlessApi.purgeReceipt]
	 */
	purgeReceipt(receipt: GroupScoped<Receipt>): Promise<void>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavourlessApi.purgeReceipts]
	 */
	purgeReceipts(receipts: Array<GroupScoped<Receipt>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [ReceiptApi.createReceipt]
	 */
	createReceipt(entity: GroupScoped<EncryptedReceipt>): Promise<GroupScoped<EncryptedReceipt>>;

	/**
	 *
	 *  In-group version of [ReceiptApi.createReceipts]
	 */
	createReceipts(entities: Array<GroupScoped<EncryptedReceipt>>): Promise<Array<GroupScoped<EncryptedReceipt>>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.undeleteReceiptById]
	 */
	undeleteReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedReceipt>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.undeleteReceiptsByIds]
	 */
	undeleteReceiptsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedReceipt>>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.undeleteReceipt]
	 */
	undeleteReceipt(receipt: GroupScoped<Receipt>): Promise<GroupScoped<EncryptedReceipt>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.undeleteReceipts]
	 */
	undeleteReceipts(receipts: Array<GroupScoped<EncryptedReceipt>>): Promise<Array<GroupScoped<EncryptedReceipt>>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.modifyReceipt]
	 */
	modifyReceipt(entity: GroupScoped<EncryptedReceipt>): Promise<GroupScoped<EncryptedReceipt>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.modifyReceipts]
	 */
	modifyReceipts(entities: Array<GroupScoped<EncryptedReceipt>>): Promise<Array<GroupScoped<EncryptedReceipt>>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.getReceipt]
	 */
	getReceipt(groupId: string, entityId: string): Promise<GroupScoped<EncryptedReceipt> | undefined>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.getReceipts]
	 */
	getReceipts(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedReceipt>>>;

}

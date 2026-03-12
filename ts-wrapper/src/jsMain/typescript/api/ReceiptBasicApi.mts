// auto-generated file
import {EncryptedReceipt, Receipt} from '../model/Receipt.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ReceiptBasicInGroupApi} from './ReceiptBasicInGroupApi.mjs';


export interface ReceiptBasicApi {

	inGroup: ReceiptBasicInGroupApi;

	/**
	 *
	 *  Deletes a receipt. If you don't have write access to the receipt the method will fail.
	 *  @param entityId id of the receipt.
	 *  @param rev the latest known rev of the receipt to delete
	 *  @return the id and revision of the deleted receipt.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteReceiptById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many receipts. Ids that do not correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the receipts to delete.
	 *  @return the id and revision of the deleted receipts. If some entities could not be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteReceiptsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a receipt.
	 *  @param id id of the receipt to purge
	 *  @param rev latest revision of the receipt
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeReceiptById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes many receipts.
	 *  @param entityIds ids and revisions of the receipts to delete
	 *  @return the id and revision of the deleted receipts. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeReceiptsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Deletes a receipt. If you don't have write access to the receipt the method will fail.
	 *  @param receipt the receipt to delete
	 *  @return the id and revision of the deleted receipt.
	 *  @throws RevisionConflictException if the provided receipt doesn't match the latest known revision
	 */
	deleteReceipt(receipt: Receipt): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many receipts. Ignores receipt for which you don't have write access or that don't match the latest revision.
	 *  @param receipts the receipts to delete
	 *  @return the id and revision of the deleted receipts. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteReceipts(receipts: Array<Receipt>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes a receipt.
	 *  @param receipt the receipt to purge.
	 *  @throws RevisionConflictException if the provided receipt doesn't match the latest known revision
	 */
	purgeReceipt(receipt: Receipt): Promise<void>;

	/**
	 *
	 *  Permanently deletes many receipts.
	 *  @param receipts the receipts to purge.
	 *  @return the id and revision of the deleted receipts. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeReceipts(receipts: Array<Receipt>): Promise<Array<StoredDocumentIdentifier>>;

	getRawReceiptAttachment(receiptId: string, attachmentId: string): Promise<Int8Array>;

	setRawReceiptAttachment(receiptId: string, rev: string, blobType: string,
			attachment: Int8Array): Promise<EncryptedReceipt>;

	/**
	 *
	 *  Create a new receipt. The provided receipt must have the encryption metadata initialized.
	 *  @param entity a receipt with initialized encryption metadata
	 *  @return the created receipt with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createReceipt(entity: EncryptedReceipt): Promise<EncryptedReceipt>;

	/**
	 *
	 *  Create multiple receipts. All the provided receipts must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities receipts with initialized encryption metadata
	 *  @return the created receipts with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any receipt in the input was not initialized.
	 */
	createReceipts(entities: Array<EncryptedReceipt>): Promise<Array<EncryptedReceipt>>;

	/**
	 *
	 *  Restores a receipt that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteReceiptById(id: string, rev: string): Promise<EncryptedReceipt>;

	/**
	 *
	 *  Restores a batch of receiptIds that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the receiptIds to restore.
	 *  @return the restored receiptIds. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteReceiptsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedReceipt>>;

	/**
	 *
	 *  Restores a receipt that was marked as deleted.
	 *  @param receipt the receipt to undelete
	 *  @return the restored receipt.
	 *  @throws RevisionConflictException if the provided receipt doesn't match the latest known revision
	 */
	undeleteReceipt(receipt: Receipt): Promise<EncryptedReceipt>;

	/**
	 *
	 *  Restores a batch of receipts that were marked as deleted.
	 *  @param receipts the receipts to restore.
	 *  @return the restored receipts. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteReceipts(receipts: Array<Receipt>): Promise<Array<EncryptedReceipt>>;

	/**
	 *
	 *  Modifies a receipt. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a receipt with update content
	 *  @return the receipt updated with the provided content and a new revision.
	 */
	modifyReceipt(entity: EncryptedReceipt): Promise<EncryptedReceipt>;

	/**
	 *
	 *  Modifies multiple receipts. Ignores all receipts for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities receipts with update content
	 *  @return the updated receipts with a new revision.
	 */
	modifyReceipts(entities: Array<EncryptedReceipt>): Promise<Array<EncryptedReceipt>>;

	/**
	 *
	 *  Get a receipt by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a receipt, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a receipt id.
	 *  @return the receipt with id [entityId].
	 */
	getReceipt(entityId: string): Promise<EncryptedReceipt | undefined>;

	/**
	 *
	 *  Get multiple receipts by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a receipt, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of receipts ids
	 *  @return all receipts that you can access with one of the provided ids.
	 */
	getReceipts(entityIds: Array<string>): Promise<Array<EncryptedReceipt>>;

	listByReference(reference: string): Promise<Array<EncryptedReceipt>>;

}

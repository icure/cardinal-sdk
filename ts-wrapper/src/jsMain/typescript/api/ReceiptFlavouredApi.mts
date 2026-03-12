// auto-generated file
import {ReceiptShareOptions} from '../crypto/entities/ReceiptShareOptions.mjs';
import {Receipt} from '../model/Receipt.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface ReceiptFlavouredApi<E extends Receipt> {

	shareWith(delegateId: string, receipt: E,
			options?: { options?: ReceiptShareOptions | undefined }): Promise<E>;

	/**
	 *
	 *  Shares an existing access log with other data owners, allowing them to access the non-encrypted data of the access log and optionally also the
	 *  encrypted content, with read-only or read-write permissions.
	 *  @param receipt the [Receipt] to share.
	 *  @param delegates associates the id of data owners which will be granted access to the entity, to the following sharing options:
	 *  - shareEncryptionKey: specifies if the encryption key of the access log should be shared with the delegate, giving access to all encrypted
	 *  content of the entity, excluding other encrypted metadata (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 *  - sharePatientId: specifies if the id of the patient that this access log refers to should be shared with the delegate. Normally this would
	 *  be the same as objectId, but it is encrypted separately from it allowing you to give access to the patient id without giving access to the other
	 *  encrypted data of the access log (defaults to [ShareMetadataBehaviour.IfAvailable]).
	 *  - requestedPermissions: the requested permissions for the delegate, defaults to [ShareMetadataBehaviour.IfAvailable].
	 *  @return the updated entity.
	 *  @throws IllegalStateException if the operation was not successful.
	 */
	shareWithMany(receipt: E, delegates: { [ key: string ]: ReceiptShareOptions }): Promise<E>;

	/**
	 *
	 *  Create a new receipt. The provided receipt must have the encryption metadata initialized.
	 *  @param entity a receipt with initialized encryption metadata
	 *  @return the created receipt with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createReceipt(entity: E): Promise<E>;

	/**
	 *
	 *  Create multiple receipts. All the provided receipts must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities receipts with initialized encryption metadata
	 *  @return the created receipts with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any receipt in the input was not initialized.
	 */
	createReceipts(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a receipt that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteReceiptById(id: string, rev: string): Promise<E>;

	/**
	 *
	 *  Restores a batch of receiptIds that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the receiptIds to restore.
	 *  @return the restored receiptIds. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteReceiptsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	/**
	 *
	 *  Restores a receipt that was marked as deleted.
	 *  @param receipt the receipt to undelete
	 *  @return the restored receipt.
	 *  @throws RevisionConflictException if the provided receipt doesn't match the latest known revision
	 */
	undeleteReceipt(receipt: Receipt): Promise<E>;

	/**
	 *
	 *  Restores a batch of receipts that were marked as deleted.
	 *  @param receipts the receipts to restore.
	 *  @return the restored receipts. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteReceipts(receipts: Array<Receipt>): Promise<Array<E>>;

	/**
	 *
	 *  Modifies a receipt. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a receipt with update content
	 *  @return the receipt updated with the provided content and a new revision.
	 */
	modifyReceipt(entity: E): Promise<E>;

	/**
	 *
	 *  Modifies multiple receipts. Ignores all receipts for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities receipts with update content
	 *  @return the updated receipts with a new revision.
	 */
	modifyReceipts(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Get a receipt by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a receipt, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a receipt id.
	 *  @return the receipt with id [entityId].
	 */
	getReceipt(entityId: string): Promise<E | undefined>;

	/**
	 *
	 *  Get multiple receipts by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a receipt, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of receipts ids
	 *  @return all receipts that you can access with one of the provided ids.
	 */
	getReceipts(entityIds: Array<string>): Promise<Array<E>>;

	listByReference(reference: string): Promise<Array<E>>;

}

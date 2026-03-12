// auto-generated file
import {ReceiptShareOptions} from '../crypto/entities/ReceiptShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {Patient} from '../model/Patient.mjs';
import {DecryptedReceipt, EncryptedReceipt, Receipt} from '../model/Receipt.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {ReceiptFlavouredApi} from './ReceiptFlavouredApi.mjs';
import {ReceiptInGroupApi} from './ReceiptInGroupApi.mjs';


export interface ReceiptApi {

	encrypted: ReceiptFlavouredApi<EncryptedReceipt>;

	tryAndRecover: ReceiptFlavouredApi<Receipt>;

	inGroup: ReceiptInGroupApi;

	withEncryptionMetadata(base: DecryptedReceipt | undefined, patient: Patient | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<DecryptedReceipt>;

	getAndDecryptReceiptAttachment(receipt: Receipt, attachmentId: string): Promise<Int8Array>;

	encryptAndSetReceiptAttachment(receipt: Receipt, blobType: string,
			attachment: Int8Array): Promise<EncryptedReceipt>;

	getEncryptionKeysOf(receipt: Receipt): Promise<Array<HexString>>;

	hasWriteAccess(receipt: Receipt): Promise<boolean>;

	decryptPatientIdOf(receipt: Receipt): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: Receipt, delegates: Array<string>): Promise<void>;

	logReceipt(
			user: User,
			docId: string,
			refs: Array<string>,
			blobType: string,
			blob: Int8Array
	): Promise<Receipt>;

	decrypt(receipt: EncryptedReceipt): Promise<DecryptedReceipt>;

	tryDecrypt(receipt: EncryptedReceipt): Promise<Receipt>;

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

	shareWith(delegateId: string, receipt: DecryptedReceipt,
			options?: { options?: ReceiptShareOptions | undefined }): Promise<DecryptedReceipt>;

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
	shareWithMany(receipt: DecryptedReceipt,
			delegates: { [ key: string ]: ReceiptShareOptions }): Promise<DecryptedReceipt>;

	/**
	 *
	 *  Create a new receipt. The provided receipt must have the encryption metadata initialized.
	 *  @param entity a receipt with initialized encryption metadata
	 *  @return the created receipt with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createReceipt(entity: DecryptedReceipt): Promise<DecryptedReceipt>;

	/**
	 *
	 *  Create multiple receipts. All the provided receipts must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities receipts with initialized encryption metadata
	 *  @return the created receipts with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any receipt in the input was not initialized.
	 */
	createReceipts(entities: Array<DecryptedReceipt>): Promise<Array<DecryptedReceipt>>;

	/**
	 *
	 *  Restores a receipt that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteReceiptById(id: string, rev: string): Promise<DecryptedReceipt>;

	/**
	 *
	 *  Restores a batch of receiptIds that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the receiptIds to restore.
	 *  @return the restored receiptIds. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteReceiptsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedReceipt>>;

	/**
	 *
	 *  Restores a receipt that was marked as deleted.
	 *  @param receipt the receipt to undelete
	 *  @return the restored receipt.
	 *  @throws RevisionConflictException if the provided receipt doesn't match the latest known revision
	 */
	undeleteReceipt(receipt: Receipt): Promise<DecryptedReceipt>;

	/**
	 *
	 *  Restores a batch of receipts that were marked as deleted.
	 *  @param receipts the receipts to restore.
	 *  @return the restored receipts. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteReceipts(receipts: Array<Receipt>): Promise<Array<DecryptedReceipt>>;

	/**
	 *
	 *  Modifies a receipt. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity a receipt with update content
	 *  @return the receipt updated with the provided content and a new revision.
	 */
	modifyReceipt(entity: DecryptedReceipt): Promise<DecryptedReceipt>;

	/**
	 *
	 *  Modifies multiple receipts. Ignores all receipts for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities receipts with update content
	 *  @return the updated receipts with a new revision.
	 */
	modifyReceipts(entities: Array<DecryptedReceipt>): Promise<Array<DecryptedReceipt>>;

	/**
	 *
	 *  Get a receipt by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not a receipt, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId a receipt id.
	 *  @return the receipt with id [entityId].
	 */
	getReceipt(entityId: string): Promise<DecryptedReceipt | undefined>;

	/**
	 *
	 *  Get multiple receipts by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not a receipt, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of receipts ids
	 *  @return all receipts that you can access with one of the provided ids.
	 */
	getReceipts(entityIds: Array<string>): Promise<Array<DecryptedReceipt>>;

	listByReference(reference: string): Promise<Array<DecryptedReceipt>>;

}

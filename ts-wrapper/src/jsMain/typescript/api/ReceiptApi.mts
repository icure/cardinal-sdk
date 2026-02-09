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

	shareWith(delegateId: string, receipt: DecryptedReceipt,
			options?: { options?: ReceiptShareOptions | undefined }): Promise<DecryptedReceipt>;

	shareWithMany(receipt: DecryptedReceipt,
			delegates: { [ key: string ]: ReceiptShareOptions }): Promise<DecryptedReceipt>;

	createReceipt(entity: DecryptedReceipt): Promise<DecryptedReceipt>;

	createReceipts(entities: Array<DecryptedReceipt>): Promise<Array<DecryptedReceipt>>;

	undeleteReceiptById(id: string, rev: string): Promise<DecryptedReceipt>;

	undeleteReceiptsByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<DecryptedReceipt>>;

	undeleteReceipt(receipt: Receipt): Promise<DecryptedReceipt>;

	undeleteReceipts(receipts: Array<Receipt>): Promise<Array<DecryptedReceipt>>;

	modifyReceipt(entity: DecryptedReceipt): Promise<DecryptedReceipt>;

	modifyReceipts(entities: Array<DecryptedReceipt>): Promise<Array<DecryptedReceipt>>;

	getReceipt(entityId: string): Promise<DecryptedReceipt | undefined>;

	getReceipts(entityIds: Array<string>): Promise<Array<DecryptedReceipt>>;

	listByReference(reference: string): Promise<Array<DecryptedReceipt>>;

}

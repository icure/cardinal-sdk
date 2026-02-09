// auto-generated file
import {ReceiptShareOptions} from '../crypto/entities/ReceiptShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Patient} from '../model/Patient.mjs';
import {DecryptedReceipt, EncryptedReceipt, Receipt} from '../model/Receipt.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';
import {ReceiptFlavouredInGroupApi} from './ReceiptFlavouredInGroupApi.mjs';


export interface ReceiptInGroupApi {

	encrypted: ReceiptFlavouredInGroupApi<EncryptedReceipt>;

	tryAndRecover: ReceiptFlavouredInGroupApi<Receipt>;

	withEncryptionMetadata(groupId: string, base: DecryptedReceipt | undefined,
			patient: GroupScoped<Patient> | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<GroupScoped<DecryptedReceipt>>;

	getEncryptionKeysOf(receipt: GroupScoped<Receipt>): Promise<Array<HexString>>;

	hasWriteAccess(receipt: GroupScoped<Receipt>): Promise<boolean>;

	decryptPatientIdOf(receipt: GroupScoped<Receipt>): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: GroupScoped<Receipt>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	decrypt(receipts: Array<GroupScoped<EncryptedReceipt>>): Promise<Array<GroupScoped<DecryptedReceipt>>>;

	tryDecrypt(receipts: Array<GroupScoped<EncryptedReceipt>>): Promise<Array<GroupScoped<Receipt>>>;

	deleteReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteReceiptsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeReceiptsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteReceipt(receipt: GroupScoped<Receipt>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteReceipts(receipts: Array<GroupScoped<Receipt>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeReceipt(receipt: GroupScoped<Receipt>): Promise<void>;

	purgeReceipts(receipts: Array<GroupScoped<Receipt>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	shareWith(delegate: EntityReferenceInGroup, receipt: GroupScoped<DecryptedReceipt>,
			options?: { options?: ReceiptShareOptions | undefined }): Promise<GroupScoped<DecryptedReceipt>>;

	shareWithMany(receipt: GroupScoped<DecryptedReceipt>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: ReceiptShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedReceipt>>;

	createReceipt(entity: GroupScoped<DecryptedReceipt>): Promise<GroupScoped<DecryptedReceipt>>;

	createReceipts(entities: Array<GroupScoped<DecryptedReceipt>>): Promise<Array<GroupScoped<DecryptedReceipt>>>;

	undeleteReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedReceipt>>;

	undeleteReceiptsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedReceipt>>>;

	undeleteReceipt(receipt: GroupScoped<Receipt>): Promise<GroupScoped<DecryptedReceipt>>;

	undeleteReceipts(receipts: Array<GroupScoped<DecryptedReceipt>>): Promise<Array<GroupScoped<DecryptedReceipt>>>;

	modifyReceipt(entity: GroupScoped<DecryptedReceipt>): Promise<GroupScoped<DecryptedReceipt>>;

	modifyReceipts(entities: Array<GroupScoped<DecryptedReceipt>>): Promise<Array<GroupScoped<DecryptedReceipt>>>;

	getReceipt(groupId: string, entityId: string): Promise<GroupScoped<DecryptedReceipt> | undefined>;

	getReceipts(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedReceipt>>>;

}

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

	/**
	 *
	 *  In-group version of [ReceiptApi.withEncryptionMetadata]
	 */
	withEncryptionMetadata(groupId: string, base: DecryptedReceipt | undefined,
			patient: GroupScoped<Patient> | undefined,
			options?: { user?: User | undefined, delegates?: { [ key: string ]: AccessLevel }, secretId?: SecretIdUseOption, alternateRootDelegateId?: string | undefined }): Promise<GroupScoped<DecryptedReceipt>>;

	/**
	 *
	 *  In-group version of [ReceiptApi.getEncryptionKeysOf]
	 */
	getEncryptionKeysOf(receipt: GroupScoped<Receipt>): Promise<Array<HexString>>;

	/**
	 *
	 *  In-group version of [ReceiptApi.hasWriteAccess]
	 */
	hasWriteAccess(receipt: GroupScoped<Receipt>): Promise<boolean>;

	/**
	 *
	 *  In-group version of [ReceiptApi.decryptPatientIdOf]
	 */
	decryptPatientIdOf(receipt: GroupScoped<Receipt>): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  In-group version of [ReceiptApi.createDelegationDeAnonymizationMetadata]
	 */
	createDelegationDeAnonymizationMetadata(entity: GroupScoped<Receipt>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	/**
	 *
	 *  In-group version of [ReceiptApi.decrypt]
	 */
	decrypt(receipts: Array<GroupScoped<EncryptedReceipt>>): Promise<Array<GroupScoped<DecryptedReceipt>>>;

	/**
	 *
	 *  In-group version of [ReceiptApi.tryDecrypt]
	 */
	tryDecrypt(receipts: Array<GroupScoped<EncryptedReceipt>>): Promise<Array<GroupScoped<Receipt>>>;

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
	 *  In-group version of [ReceiptFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, receipt: GroupScoped<DecryptedReceipt>,
			options?: { options?: ReceiptShareOptions | undefined }): Promise<GroupScoped<DecryptedReceipt>>;

	/**
	 *
	 *  In-group version of [ReceiptFlavouredApi.shareWithMany]
	 */
	shareWithMany(receipt: GroupScoped<DecryptedReceipt>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: ReceiptShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedReceipt>>;

	/**
	 *
	 *  In-group version of [ReceiptApi.createReceipt]
	 */
	createReceipt(entity: GroupScoped<DecryptedReceipt>): Promise<GroupScoped<DecryptedReceipt>>;

	/**
	 *
	 *  In-group version of [ReceiptApi.createReceipts]
	 */
	createReceipts(entities: Array<GroupScoped<DecryptedReceipt>>): Promise<Array<GroupScoped<DecryptedReceipt>>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.undeleteReceiptById]
	 */
	undeleteReceiptById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedReceipt>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.undeleteReceiptsByIds]
	 */
	undeleteReceiptsByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedReceipt>>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.undeleteReceipt]
	 */
	undeleteReceipt(receipt: GroupScoped<Receipt>): Promise<GroupScoped<DecryptedReceipt>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.undeleteReceipts]
	 */
	undeleteReceipts(receipts: Array<GroupScoped<DecryptedReceipt>>): Promise<Array<GroupScoped<DecryptedReceipt>>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.modifyReceipt]
	 */
	modifyReceipt(entity: GroupScoped<DecryptedReceipt>): Promise<GroupScoped<DecryptedReceipt>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.modifyReceipts]
	 */
	modifyReceipts(entities: Array<GroupScoped<DecryptedReceipt>>): Promise<Array<GroupScoped<DecryptedReceipt>>>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.getReceipt]
	 */
	getReceipt(groupId: string, entityId: string): Promise<GroupScoped<DecryptedReceipt> | undefined>;

	/**
	 *
	 *  In-group version of [ReceiptBasicFlavouredApi.getReceipts]
	 */
	getReceipts(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedReceipt>>>;

}

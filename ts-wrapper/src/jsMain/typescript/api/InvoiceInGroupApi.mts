// auto-generated file
import {InvoiceShareOptions} from '../crypto/entities/InvoiceShareOptions.mjs';
import {SecretIdUseOption} from '../crypto/entities/SecretIdUseOption.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {DecryptedInvoice, EncryptedInvoice, Invoice} from '../model/Invoice.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {User} from '../model/User.mjs';
import {AccessLevel} from '../model/embed/AccessLevel.mjs';
import {HexString} from '../model/specializations/HexString.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';
import {InvoiceFlavouredInGroupApi} from './InvoiceFlavouredInGroupApi.mjs';


export interface InvoiceInGroupApi {

	encrypted: InvoiceFlavouredInGroupApi<EncryptedInvoice>;

	tryAndRecover: InvoiceFlavouredInGroupApi<Invoice>;

	/**
	 *
	 *  In-group version of [InvoiceApi.withEncryptionMetadata]
	 */
	withEncryptionMetadata(entityGroupId: string, base: DecryptedInvoice | undefined,
			patient: GroupScoped<Patient> | undefined,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, secretId?: SecretIdUseOption, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedInvoice>>;

	/**
	 *
	 *  In-group version of [InvoiceApi.getEncryptionKeysOf]
	 */
	getEncryptionKeysOf(invoice: GroupScoped<Invoice>): Promise<Array<HexString>>;

	/**
	 *
	 *  In-group version of [InvoiceApi.hasWriteAccess]
	 */
	hasWriteAccess(invoice: GroupScoped<Invoice>): Promise<boolean>;

	/**
	 *
	 *  In-group version of [InvoiceApi.decryptPatientIdOf]
	 */
	decryptPatientIdOf(invoice: GroupScoped<Invoice>): Promise<Array<EntityReferenceInGroup>>;

	/**
	 *
	 *  In-group version of [InvoiceApi.createDelegationDeAnonymizationMetadata]
	 */
	createDelegationDeAnonymizationMetadata(entity: GroupScoped<Invoice>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	/**
	 *
	 *  In-group version of [InvoiceApi.decrypt]
	 */
	decrypt(invoices: Array<GroupScoped<EncryptedInvoice>>): Promise<Array<GroupScoped<DecryptedInvoice>>>;

	/**
	 *
	 *  In-group version of [InvoiceApi.tryDecrypt]
	 */
	tryDecrypt(invoices: Array<GroupScoped<EncryptedInvoice>>): Promise<Array<GroupScoped<Invoice>>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavourlessApi.deleteInvoiceById]
	 */
	deleteInvoiceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavourlessApi.deleteInvoicesByIds]
	 */
	deleteInvoicesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavourlessApi.purgeInvoiceById]
	 */
	purgeInvoiceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavourlessApi.purgeInvoicesByIds]
	 */
	purgeInvoicesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavourlessApi.deleteInvoice]
	 */
	deleteInvoice(invoice: GroupScoped<Invoice>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavourlessApi.deleteInvoices]
	 */
	deleteInvoices(invoices: Array<GroupScoped<Invoice>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavourlessApi.purgeInvoice]
	 */
	purgeInvoice(invoice: GroupScoped<Invoice>): Promise<void>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavourlessApi.purgeInvoices]
	 */
	purgeInvoices(invoices: Array<GroupScoped<Invoice>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	/**
	 *
	 *  In-group version of [InvoiceFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, invoice: GroupScoped<DecryptedInvoice>,
			options?: { options?: InvoiceShareOptions | undefined }): Promise<GroupScoped<DecryptedInvoice>>;

	/**
	 *
	 *  In-group version of [InvoiceFlavouredApi.shareWithMany]
	 */
	shareWithMany(invoice: GroupScoped<DecryptedInvoice>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: InvoiceShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedInvoice>>;

	/**
	 *
	 *  In-group version of [InvoiceApi.createInvoice]
	 */
	createInvoice(entity: GroupScoped<DecryptedInvoice>): Promise<GroupScoped<DecryptedInvoice>>;

	/**
	 *
	 *  In-group version of [InvoiceApi.createInvoices]
	 */
	createInvoices(entities: Array<GroupScoped<DecryptedInvoice>>): Promise<Array<GroupScoped<DecryptedInvoice>>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.undeleteInvoiceById]
	 */
	undeleteInvoiceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedInvoice>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.undeleteInvoicesByIds]
	 */
	undeleteInvoicesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedInvoice>>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.undeleteInvoice]
	 */
	undeleteInvoice(invoice: GroupScoped<Invoice>): Promise<GroupScoped<DecryptedInvoice>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.undeleteInvoices]
	 */
	undeleteInvoices(invoices: Array<GroupScoped<DecryptedInvoice>>): Promise<Array<GroupScoped<DecryptedInvoice>>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.modifyInvoice]
	 */
	modifyInvoice(entity: GroupScoped<DecryptedInvoice>): Promise<GroupScoped<DecryptedInvoice>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.modifyInvoices]
	 */
	modifyInvoices(entities: Array<GroupScoped<DecryptedInvoice>>): Promise<Array<GroupScoped<DecryptedInvoice>>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.getInvoice]
	 */
	getInvoice(groupId: string, entityId: string): Promise<GroupScoped<DecryptedInvoice> | undefined>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.getInvoices]
	 */
	getInvoices(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedInvoice>>>;

}

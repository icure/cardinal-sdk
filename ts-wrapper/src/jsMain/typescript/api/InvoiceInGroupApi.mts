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

	withEncryptionMetadata(entityGroupId: string, base: DecryptedInvoice | undefined,
			patient: GroupScoped<Patient> | undefined,
			options?: { user?: User | undefined, delegates?: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>, secretId?: SecretIdUseOption, alternateRootDelegateReference?: EntityReferenceInGroup | undefined }): Promise<GroupScoped<DecryptedInvoice>>;

	getEncryptionKeysOf(invoice: GroupScoped<Invoice>): Promise<Array<HexString>>;

	hasWriteAccess(invoice: GroupScoped<Invoice>): Promise<boolean>;

	decryptPatientIdOf(invoice: GroupScoped<Invoice>): Promise<Array<EntityReferenceInGroup>>;

	createDelegationDeAnonymizationMetadata(entity: GroupScoped<Invoice>,
			delegates: Array<EntityReferenceInGroup>): Promise<void>;

	decrypt(invoices: Array<GroupScoped<EncryptedInvoice>>): Promise<Array<GroupScoped<DecryptedInvoice>>>;

	tryDecrypt(invoices: Array<GroupScoped<EncryptedInvoice>>): Promise<Array<GroupScoped<Invoice>>>;

	deleteInvoiceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteInvoicesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeInvoiceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeInvoicesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteInvoice(invoice: GroupScoped<Invoice>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteInvoices(invoices: Array<GroupScoped<Invoice>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeInvoice(invoice: GroupScoped<Invoice>): Promise<void>;

	purgeInvoices(invoices: Array<GroupScoped<Invoice>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	shareWith(delegate: EntityReferenceInGroup, invoice: GroupScoped<DecryptedInvoice>,
			options?: { options?: InvoiceShareOptions | undefined }): Promise<GroupScoped<DecryptedInvoice>>;

	shareWithMany(invoice: GroupScoped<DecryptedInvoice>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: InvoiceShareOptions }, 'delegate'>): Promise<GroupScoped<DecryptedInvoice>>;

	createInvoice(entity: GroupScoped<DecryptedInvoice>): Promise<GroupScoped<DecryptedInvoice>>;

	createInvoices(entities: Array<GroupScoped<DecryptedInvoice>>): Promise<Array<GroupScoped<DecryptedInvoice>>>;

	undeleteInvoiceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<DecryptedInvoice>>;

	undeleteInvoicesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<DecryptedInvoice>>>;

	undeleteInvoice(invoice: GroupScoped<Invoice>): Promise<GroupScoped<DecryptedInvoice>>;

	undeleteInvoices(invoices: Array<GroupScoped<DecryptedInvoice>>): Promise<Array<GroupScoped<DecryptedInvoice>>>;

	modifyInvoice(entity: GroupScoped<DecryptedInvoice>): Promise<GroupScoped<DecryptedInvoice>>;

	modifyInvoices(entities: Array<GroupScoped<DecryptedInvoice>>): Promise<Array<GroupScoped<DecryptedInvoice>>>;

	getInvoice(groupId: string, entityId: string): Promise<GroupScoped<DecryptedInvoice> | undefined>;

	getInvoices(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<DecryptedInvoice>>>;

}

// auto-generated file
import {GroupScoped} from '../model/GroupScoped.mjs';
import {EncryptedInvoice, Invoice} from '../model/Invoice.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface InvoiceBasicInGroupApi {

	deleteInvoiceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteInvoicesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeInvoiceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<void>;

	purgeInvoicesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	deleteInvoice(invoice: GroupScoped<Invoice>): Promise<GroupScoped<StoredDocumentIdentifier>>;

	deleteInvoices(invoices: Array<GroupScoped<Invoice>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	purgeInvoice(invoice: GroupScoped<Invoice>): Promise<void>;

	purgeInvoices(invoices: Array<GroupScoped<Invoice>>): Promise<Array<GroupScoped<StoredDocumentIdentifier>>>;

	createInvoice(entity: GroupScoped<EncryptedInvoice>): Promise<GroupScoped<EncryptedInvoice>>;

	createInvoices(entities: Array<GroupScoped<EncryptedInvoice>>): Promise<Array<GroupScoped<EncryptedInvoice>>>;

	undeleteInvoiceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedInvoice>>;

	undeleteInvoicesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedInvoice>>>;

	undeleteInvoice(invoice: GroupScoped<Invoice>): Promise<GroupScoped<EncryptedInvoice>>;

	undeleteInvoices(invoices: Array<GroupScoped<EncryptedInvoice>>): Promise<Array<GroupScoped<EncryptedInvoice>>>;

	modifyInvoice(entity: GroupScoped<EncryptedInvoice>): Promise<GroupScoped<EncryptedInvoice>>;

	modifyInvoices(entities: Array<GroupScoped<EncryptedInvoice>>): Promise<Array<GroupScoped<EncryptedInvoice>>>;

	getInvoice(groupId: string, entityId: string): Promise<GroupScoped<EncryptedInvoice> | undefined>;

	getInvoices(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedInvoice>>>;

}

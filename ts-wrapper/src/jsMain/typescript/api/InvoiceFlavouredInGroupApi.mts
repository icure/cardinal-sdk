// auto-generated file
import {InvoiceShareOptions} from '../crypto/entities/InvoiceShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Invoice} from '../model/Invoice.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface InvoiceFlavouredInGroupApi<E extends Invoice> {

	shareWith(delegate: EntityReferenceInGroup, invoice: GroupScoped<E>,
			options?: { options?: InvoiceShareOptions | undefined }): Promise<GroupScoped<E>>;

	shareWithMany(invoice: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: InvoiceShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	createInvoice(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	createInvoices(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	undeleteInvoiceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	undeleteInvoicesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	undeleteInvoice(invoice: GroupScoped<Invoice>): Promise<GroupScoped<E>>;

	undeleteInvoices(invoices: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	modifyInvoice(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	modifyInvoices(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	getInvoice(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	getInvoices(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}

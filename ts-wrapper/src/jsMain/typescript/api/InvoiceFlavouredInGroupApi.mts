// auto-generated file
import {InvoiceShareOptions} from '../crypto/entities/InvoiceShareOptions.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {GroupScoped} from '../model/GroupScoped.mjs';
import {Invoice} from '../model/Invoice.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {ArrayWithUniqueKeys} from '../utils/ArrayWithUniqueKeys.mjs';


export interface InvoiceFlavouredInGroupApi<E extends Invoice> {

	/**
	 *
	 *  In-group version of [InvoiceFlavouredApi.shareWith]
	 */
	shareWith(delegate: EntityReferenceInGroup, invoice: GroupScoped<E>,
			options?: { options?: InvoiceShareOptions | undefined }): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [InvoiceFlavouredApi.shareWithMany]
	 */
	shareWithMany(invoice: GroupScoped<E>,
			delegates: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, shareOptions: InvoiceShareOptions }, 'delegate'>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [InvoiceApi.createInvoice]
	 */
	createInvoice(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [InvoiceApi.createInvoices]
	 */
	createInvoices(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.undeleteInvoiceById]
	 */
	undeleteInvoiceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.undeleteInvoicesByIds]
	 */
	undeleteInvoicesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.undeleteInvoice]
	 */
	undeleteInvoice(invoice: GroupScoped<Invoice>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.undeleteInvoices]
	 */
	undeleteInvoices(invoices: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.modifyInvoice]
	 */
	modifyInvoice(entity: GroupScoped<E>): Promise<GroupScoped<E>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.modifyInvoices]
	 */
	modifyInvoices(entities: Array<GroupScoped<E>>): Promise<Array<GroupScoped<E>>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.getInvoice]
	 */
	getInvoice(groupId: string, entityId: string): Promise<GroupScoped<E> | undefined>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.getInvoices]
	 */
	getInvoices(groupId: string, entityIds: Array<string>): Promise<Array<GroupScoped<E>>>;

}

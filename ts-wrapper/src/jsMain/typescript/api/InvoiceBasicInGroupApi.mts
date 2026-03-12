// auto-generated file
import {GroupScoped} from '../model/GroupScoped.mjs';
import {EncryptedInvoice, Invoice} from '../model/Invoice.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';


export interface InvoiceBasicInGroupApi {

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
	 *  In-group version of [InvoiceApi.createInvoice]
	 */
	createInvoice(entity: GroupScoped<EncryptedInvoice>): Promise<GroupScoped<EncryptedInvoice>>;

	/**
	 *
	 *  In-group version of [InvoiceApi.createInvoices]
	 */
	createInvoices(entities: Array<GroupScoped<EncryptedInvoice>>): Promise<Array<GroupScoped<EncryptedInvoice>>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.undeleteInvoiceById]
	 */
	undeleteInvoiceById(entityId: GroupScoped<StoredDocumentIdentifier>): Promise<GroupScoped<EncryptedInvoice>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.undeleteInvoicesByIds]
	 */
	undeleteInvoicesByIds(entityIds: Array<GroupScoped<StoredDocumentIdentifier>>): Promise<Array<GroupScoped<EncryptedInvoice>>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.undeleteInvoice]
	 */
	undeleteInvoice(invoice: GroupScoped<Invoice>): Promise<GroupScoped<EncryptedInvoice>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.undeleteInvoices]
	 */
	undeleteInvoices(invoices: Array<GroupScoped<EncryptedInvoice>>): Promise<Array<GroupScoped<EncryptedInvoice>>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.modifyInvoice]
	 */
	modifyInvoice(entity: GroupScoped<EncryptedInvoice>): Promise<GroupScoped<EncryptedInvoice>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.modifyInvoices]
	 */
	modifyInvoices(entities: Array<GroupScoped<EncryptedInvoice>>): Promise<Array<GroupScoped<EncryptedInvoice>>>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.getInvoice]
	 */
	getInvoice(groupId: string, entityId: string): Promise<GroupScoped<EncryptedInvoice> | undefined>;

	/**
	 *
	 *  In-group version of [InvoiceBasicFlavouredApi.getInvoices]
	 */
	getInvoices(groupId: string,
			entityIds: Array<string>): Promise<Array<GroupScoped<EncryptedInvoice>>>;

}

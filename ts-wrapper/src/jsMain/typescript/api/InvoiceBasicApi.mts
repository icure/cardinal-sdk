// auto-generated file
import {EncryptedInvoice, Invoice} from '../model/Invoice.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {LabelledOccurence} from '../model/data/LabelledOccurence.mjs';
import {InvoiceType} from '../model/embed/InvoiceType.mjs';
import {EncryptedInvoicingCode} from '../model/embed/InvoicingCode.mjs';
import {MediumType} from '../model/embed/MediumType.mjs';
import {InvoiceBasicInGroupApi} from './InvoiceBasicInGroupApi.mjs';


export interface InvoiceBasicApi {

	inGroup: InvoiceBasicInGroupApi;

	/**
	 *
	 *  Deletes an invoice. If you don't have write access to the invoice the method will fail.
	 *  @param entityId id of the invoice.
	 *  @param rev the latest known rev of the invoice to delete
	 *  @return the id and revision of the deleted invoice.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	deleteInvoiceById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many invoices. Ids that do not correspond to an entity, or that correspond to an entity for which
	 *  you don't have write access will be ignored.
	 *  @param entityIds ids and revisions of the invoices to delete.
	 *  @return the id and revision of the deleted invoices. If some entities could not be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	deleteInvoicesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes an invoice.
	 *  @param id id of the invoice to purge
	 *  @param rev latest revision of the invoice
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	purgeInvoiceById(id: string, rev: string): Promise<void>;

	/**
	 *
	 *  Permanently deletes many invoices.
	 *  @param entityIds ids and revisions of the invoices to delete
	 *  @return the id and revision of the deleted invoices. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeInvoicesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Deletes an invoice. If you don't have write access to the invoice the method will fail.
	 *  @param invoice the invoice to delete
	 *  @return the id and revision of the deleted invoice.
	 *  @throws RevisionConflictException if the provided invoice doesn't match the latest known revision
	 */
	deleteInvoice(invoice: Invoice): Promise<StoredDocumentIdentifier>;

	/**
	 *
	 *  Deletes many invoices. Ignores invoice for which you don't have write access or that don't match the latest revision.
	 *  @param invoices the invoices to delete
	 *  @return the id and revision of the deleted invoices. If some entities couldn't be deleted they will not be
	 *  included in this list.
	 */
	deleteInvoices(invoices: Array<Invoice>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Permanently deletes an invoice.
	 *  @param invoice the invoice to purge.
	 *  @throws RevisionConflictException if the provided invoice doesn't match the latest known revision
	 */
	purgeInvoice(invoice: Invoice): Promise<void>;

	/**
	 *
	 *  Permanently deletes many invoices.
	 *  @param invoices the invoices to purge.
	 *  @return the id and revision of the deleted invoices. If some entities couldn't be deleted (for example
	 *  because you had no write access to them) they will not be included in this list.
	 */
	purgeInvoices(invoices: Array<Invoice>): Promise<Array<StoredDocumentIdentifier>>;

	/**
	 *
	 *  Gives an approximation of the amount of times each tarification code ([Invoice.invoicingCodes] ->
	 *  [InvoicingCode.tarificationId]) is used in invoices where the current data owner is a direct delegate (does not
	 *  count situations where the data owner has access to the service through delegations to a parent data owner).
	 *  This number is not exact, and may be cached, so you should not use this method if you need precise values, but
	 *  it can be useful if you want to give suggestions.
	 *  Only codes that occur at least [minOccurrence] times will be used.
	 *  @return the occurrences for each invoicing code that is used at least [minOccurrence] times.
	 */
	getTarificationsCodesOccurrences(minOccurrence: number): Promise<Array<LabelledOccurence>>;

	/**
	 *
	 *  Create a new invoice. The provided invoice must have the encryption metadata initialized.
	 *  @param entity an invoice with initialized encryption metadata
	 *  @return the created invoice with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createInvoice(entity: EncryptedInvoice): Promise<EncryptedInvoice>;

	/**
	 *
	 *  Create multiple invoices. All the provided invoices must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities invoices with initialized encryption metadata
	 *  @return the created invoices with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any invoice in the input was not initialized.
	 */
	createInvoices(entities: Array<EncryptedInvoice>): Promise<Array<EncryptedInvoice>>;

	/**
	 *
	 *  Restores an invoice that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteInvoiceById(id: string, rev: string): Promise<EncryptedInvoice>;

	/**
	 *
	 *  Restores a batch of invoiceIds that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the invoiceIds to restore.
	 *  @return the restored invoiceIds. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteInvoicesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedInvoice>>;

	/**
	 *
	 *  Restores an invoice that was marked as deleted.
	 *  @param invoice the invoice to undelete
	 *  @return the restored invoice.
	 *  @throws RevisionConflictException if the provided invoice doesn't match the latest known revision
	 */
	undeleteInvoice(invoice: Invoice): Promise<EncryptedInvoice>;

	/**
	 *
	 *  Restores a batch of invoices that were marked as deleted.
	 *  @param invoices the invoices to restore.
	 *  @return the restored invoices. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteInvoices(invoices: Array<Invoice>): Promise<Array<EncryptedInvoice>>;

	/**
	 *
	 *  Modifies an invoice. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity an invoice with update content
	 *  @return the invoice updated with the provided content and a new revision.
	 */
	modifyInvoice(entity: EncryptedInvoice): Promise<EncryptedInvoice>;

	/**
	 *
	 *  Modifies multiple invoices. Ignores all invoices for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities invoices with update content
	 *  @return the updated invoices with a new revision.
	 */
	modifyInvoices(entities: Array<EncryptedInvoice>): Promise<Array<EncryptedInvoice>>;

	/**
	 *
	 *  Get an invoice by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not an invoice, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId an invoice id.
	 *  @return the invoice with id [entityId].
	 */
	getInvoice(entityId: string): Promise<EncryptedInvoice | undefined>;

	/**
	 *
	 *  Get multiple invoices by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not an invoice, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of invoices ids
	 *  @return all invoices that you can access with one of the provided ids.
	 */
	getInvoices(entityIds: Array<string>): Promise<Array<EncryptedInvoice>>;

	reassignInvoice(invoice: EncryptedInvoice): Promise<EncryptedInvoice>;

	mergeTo(invoiceId: string, ids: Array<string>): Promise<EncryptedInvoice>;

	validate(invoiceId: string, scheme: string, forcedValue: string): Promise<EncryptedInvoice>;

	appendCodes(
			userId: string,
			type: string,
			sentMediumType: string,
			secretFKeys: string,
			invoicingCodes: Array<EncryptedInvoicingCode>,
			options?: { insuranceId?: string | undefined, invoiceId?: string | undefined, gracePeriod?: number | undefined }
	): Promise<Array<EncryptedInvoice>>;

	removeCodes(userId: string, serviceId: string, secretFKeys: string,
			tarificationIds: Array<string>): Promise<Array<EncryptedInvoice>>;

	findInvoicesByAuthor(hcPartyId: string,
			options?: { fromDate?: number | undefined, toDate?: number | undefined, startKey?: any | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<EncryptedInvoice>>;

	listInvoicesByHcPartyAndGroupId(hcPartyId: string,
			groupId: string): Promise<Array<EncryptedInvoice>>;

	listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
			hcPartyId: string,
			sentMediumType: MediumType,
			invoiceType: InvoiceType,
			sent: boolean,
			options?: { from?: number | undefined, to?: number | undefined }
	): Promise<Array<EncryptedInvoice>>;

	listInvoicesByContactIds(contactIds: Array<string>): Promise<Array<EncryptedInvoice>>;

	listInvoicesByRecipientsIds(recipientsIds: Array<string>): Promise<Array<EncryptedInvoice>>;

	listToInsurances(userIds: Array<string>): Promise<Array<EncryptedInvoice>>;

	listToInsurancesUnsent(userIds: Array<string>): Promise<Array<EncryptedInvoice>>;

	listToPatients(hcPartyId: string): Promise<Array<EncryptedInvoice>>;

	listToPatientsUnsent(hcPartyId: string | undefined): Promise<Array<EncryptedInvoice>>;

	listInvoicesByIds(ids: Array<string>): Promise<Array<EncryptedInvoice>>;

	listInvoicesByHcpartySendingModeStatusDate(
			hcPartyId: string,
			sendingMode: string,
			status: string,
			from: number,
			to: number
	): Promise<Array<EncryptedInvoice>>;

	listInvoicesByServiceIds(serviceIds: Array<string>): Promise<Array<EncryptedInvoice>>;

	listAllHcpsByStatus(status: string, hcpIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined }): Promise<Array<EncryptedInvoice>>;

}

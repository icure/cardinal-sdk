// auto-generated file
import {PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {InvoiceShareOptions} from '../crypto/entities/InvoiceShareOptions.mjs';
import {Invoice} from '../model/Invoice.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {Patient} from '../model/Patient.mjs';
import {StoredDocumentIdentifier} from '../model/StoredDocumentIdentifier.mjs';
import {InvoiceType} from '../model/embed/InvoiceType.mjs';
import {EncryptedInvoicingCode} from '../model/embed/InvoicingCode.mjs';
import {MediumType} from '../model/embed/MediumType.mjs';


export interface InvoiceFlavouredApi<E extends Invoice> {

	/**
	 *
	 *  Share an invoice with another data owner. The invoice must already exist in the database for this method to
	 *  succeed. If you want to share the invoice before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  @param delegateId the owner that will gain access to the invoice
	 *  @param invoice the invoice to share with [delegateId]
	 *  @param options specifies how the invoice will be shared. By default, all data available to the current user
	 *  will be shared, and the delegate will have the same permissions as the current user on the invoice. Refer
	 *  to the documentation of [InvoiceShareOptions] for more information.
	 *  @return the updated invoice if the sharing was successful, or details on the errors if the sharing failed.
	 */
	shareWith(delegateId: string, invoice: E,
			options?: { options?: InvoiceShareOptions | undefined }): Promise<E>;

	/**
	 *
	 *  Share an invoice with multiple data owners. The invoice must already exist in the database for this method to
	 *  succeed. If you want to share the invoice before creation you should instead pass provide the delegates in
	 *  the initialize encryption metadata method.
	 *  Note: this method only updates the security metadata. If the input entity has unsaved changes they may be lost.
	 *  Throws an exception if the operation fails.
	 *  @param invoice the invoice to share
	 *  @param delegates specify the data owners which will gain access to the entity and the options for sharing with
	 *  each of them.
	 *  @return the updated invoice.
	 */
	shareWithMany(invoice: E, delegates: { [ key: string ]: InvoiceShareOptions }): Promise<E>;

	findInvoicesByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<E>>;

	/**
	 *
	 *  Create a new invoice. The provided invoice must have the encryption metadata initialized.
	 *  @param entity an invoice with initialized encryption metadata
	 *  @return the created invoice with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of the input was not initialized.
	 */
	createInvoice(entity: E): Promise<E>;

	/**
	 *
	 *  Create multiple invoices. All the provided invoices must have the encryption metadata initialized, otherwise
	 *  this method fails without doing anything.
	 *  @param entities invoices with initialized encryption metadata
	 *  @return the created invoices with updated revision.
	 *  @throws IllegalArgumentException if the encryption metadata of any invoice in the input was not initialized.
	 */
	createInvoices(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Restores an invoice that was marked as deleted.
	 *  @param id the id of the entity
	 *  @param rev the latest revision of the entity.
	 *  @return the restored entity.
	 *  @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	undeleteInvoiceById(id: string, rev: string): Promise<E>;

	/**
	 *
	 *  Restores a batch of invoiceIds that were marked as deleted.
	 *  @param entityIds the ids and the revisions of the invoiceIds to restore.
	 *  @return the restored invoiceIds. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteInvoicesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	/**
	 *
	 *  Restores an invoice that was marked as deleted.
	 *  @param invoice the invoice to undelete
	 *  @return the restored invoice.
	 *  @throws RevisionConflictException if the provided invoice doesn't match the latest known revision
	 */
	undeleteInvoice(invoice: Invoice): Promise<E>;

	/**
	 *
	 *  Restores a batch of invoices that were marked as deleted.
	 *  @param invoices the invoices to restore.
	 *  @return the restored invoices. If some entities couldn't be restored (because the user does not have access or the revision is not
	 *  up-to-date), then those entities will not be restored and will not appear in this list.
	 */
	undeleteInvoices(invoices: Array<Invoice>): Promise<Array<E>>;

	/**
	 *
	 *  Modifies an invoice. You need to have write access to the entity.
	 *  Flavoured method.
	 *  @param entity an invoice with update content
	 *  @return the invoice updated with the provided content and a new revision.
	 */
	modifyInvoice(entity: E): Promise<E>;

	/**
	 *
	 *  Modifies multiple invoices. Ignores all invoices for which you don't have write access.
	 *  Flavoured method.
	 *  @param entities invoices with update content
	 *  @return the updated invoices with a new revision.
	 */
	modifyInvoices(entities: Array<E>): Promise<Array<E>>;

	/**
	 *
	 *  Get an invoice by its id. You must have read access to the entity. Fails if the id does not correspond to any
	 *  entity, corresponds to an entity that is not an invoice, or corresponds to an entity for which you don't have
	 *  read access.
	 *  Flavoured method.
	 *  @param entityId an invoice id.
	 *  @return the invoice with id [entityId].
	 */
	getInvoice(entityId: string): Promise<E | undefined>;

	/**
	 *
	 *  Get multiple invoices by their ids. Ignores all ids that do not correspond to an entity, correspond to
	 *  an entity that is not an invoice, or correspond to an entity for which you don't have read access.
	 *  Flavoured method.
	 *  @param entityIds a list of invoices ids
	 *  @return all invoices that you can access with one of the provided ids.
	 */
	getInvoices(entityIds: Array<string>): Promise<Array<E>>;

	reassignInvoice(invoice: E): Promise<E>;

	mergeTo(invoiceId: string, ids: Array<string>): Promise<E>;

	validate(invoiceId: string, scheme: string, forcedValue: string): Promise<E>;

	appendCodes(
			userId: string,
			type: string,
			sentMediumType: string,
			secretFKeys: string,
			invoicingCodes: Array<EncryptedInvoicingCode>,
			options?: { insuranceId?: string | undefined, invoiceId?: string | undefined, gracePeriod?: number | undefined }
	): Promise<Array<E>>;

	removeCodes(userId: string, serviceId: string, secretFKeys: string,
			tarificationIds: Array<string>): Promise<Array<E>>;

	findInvoicesByAuthor(hcPartyId: string,
			options?: { fromDate?: number | undefined, toDate?: number | undefined, startKey?: any | undefined, startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<E>>;

	listInvoicesByHcPartyAndGroupId(hcPartyId: string, groupId: string): Promise<Array<E>>;

	listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
			hcPartyId: string,
			sentMediumType: MediumType,
			invoiceType: InvoiceType,
			sent: boolean,
			options?: { from?: number | undefined, to?: number | undefined }
	): Promise<Array<E>>;

	listInvoicesByContactIds(contactIds: Array<string>): Promise<Array<E>>;

	listInvoicesByRecipientsIds(recipientsIds: Array<string>): Promise<Array<E>>;

	listToInsurances(userIds: Array<string>): Promise<Array<E>>;

	listToInsurancesUnsent(userIds: Array<string>): Promise<Array<E>>;

	listToPatients(hcPartyId: string): Promise<Array<E>>;

	listToPatientsUnsent(hcPartyId: string | undefined): Promise<Array<E>>;

	listInvoicesByIds(ids: Array<string>): Promise<Array<E>>;

	listInvoicesByHcpartySendingModeStatusDate(
			hcPartyId: string,
			sendingMode: string,
			status: string,
			from: number,
			to: number
	): Promise<Array<E>>;

	listInvoicesByServiceIds(serviceIds: Array<string>): Promise<Array<E>>;

	listAllHcpsByStatus(status: string, hcpIds: Array<string>,
			options?: { from?: number | undefined, to?: number | undefined }): Promise<Array<E>>;

}

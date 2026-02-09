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

	shareWith(delegateId: string, invoice: E,
			options?: { options?: InvoiceShareOptions | undefined }): Promise<E>;

	shareWithMany(invoice: E, delegates: { [ key: string ]: InvoiceShareOptions }): Promise<E>;

	findInvoicesByHcPartyPatient(hcPartyId: string, patient: Patient,
			options?: { startDate?: number | undefined, endDate?: number | undefined, descending?: boolean | undefined }): Promise<PaginatedListIterator<E>>;

	createInvoice(entity: E): Promise<E>;

	createInvoices(entities: Array<E>): Promise<Array<E>>;

	undeleteInvoiceById(id: string, rev: string): Promise<E>;

	undeleteInvoicesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<E>>;

	undeleteInvoice(invoice: Invoice): Promise<E>;

	undeleteInvoices(invoices: Array<Invoice>): Promise<Array<E>>;

	modifyInvoice(entity: E): Promise<E>;

	modifyInvoices(entities: Array<E>): Promise<Array<E>>;

	getInvoice(entityId: string): Promise<E | undefined>;

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

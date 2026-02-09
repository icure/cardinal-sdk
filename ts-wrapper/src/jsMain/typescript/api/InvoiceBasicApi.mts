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

	deleteInvoiceById(entityId: string, rev: string): Promise<StoredDocumentIdentifier>;

	deleteInvoicesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	purgeInvoiceById(id: string, rev: string): Promise<void>;

	purgeInvoicesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<StoredDocumentIdentifier>>;

	deleteInvoice(invoice: Invoice): Promise<StoredDocumentIdentifier>;

	deleteInvoices(invoices: Array<Invoice>): Promise<Array<StoredDocumentIdentifier>>;

	purgeInvoice(invoice: Invoice): Promise<void>;

	purgeInvoices(invoices: Array<Invoice>): Promise<Array<StoredDocumentIdentifier>>;

	getTarificationsCodesOccurrences(minOccurrence: number): Promise<Array<LabelledOccurence>>;

	createInvoice(entity: EncryptedInvoice): Promise<EncryptedInvoice>;

	createInvoices(entities: Array<EncryptedInvoice>): Promise<Array<EncryptedInvoice>>;

	undeleteInvoiceById(id: string, rev: string): Promise<EncryptedInvoice>;

	undeleteInvoicesByIds(entityIds: Array<StoredDocumentIdentifier>): Promise<Array<EncryptedInvoice>>;

	undeleteInvoice(invoice: Invoice): Promise<EncryptedInvoice>;

	undeleteInvoices(invoices: Array<Invoice>): Promise<Array<EncryptedInvoice>>;

	modifyInvoice(entity: EncryptedInvoice): Promise<EncryptedInvoice>;

	modifyInvoices(entities: Array<EncryptedInvoice>): Promise<Array<EncryptedInvoice>>;

	getInvoice(entityId: string): Promise<EncryptedInvoice | undefined>;

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

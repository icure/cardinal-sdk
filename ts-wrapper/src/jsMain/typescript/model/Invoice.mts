// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectObject, expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {Identifier} from './base/Identifier.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {IdentityDocumentReader} from './embed/IdentityDocumentReader.mjs';
import {DecryptedInvoicingCode, EncryptedInvoicingCode, InvoicingCode} from './embed/InvoicingCode.mjs';
import {Payment} from './embed/Payment.mjs';
import {PaymentType} from './embed/PaymentType.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


/**
 *
 *  Represents an invoice. An invoice is used to bill patients, mutual funds, or paying agencies for
 *  healthcare
 *  services rendered. It is serialized in JSON and saved in the underlying iCure CouchDB database.
 *  /
 */
export interface Invoice extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

	/**
	 *
	 *  The identifiers of the invoice.
	 */
	identifier: Array<Identifier>;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the invoice was drafted.
	 */
	invoiceDate: number | undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the invoice was sent.
	 */
	sentDate: number | undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the invoice was printed.
	 */
	printedDate: number | undefined;

	/**
	 *
	 *  The list of invoicing codes associated with this invoice.
	 */
	invoicingCodes: Array<InvoicingCode>;

	/**
	 *
	 *  Map of receipt references.
	 */
	receipts: { [ key: string ]: string };

	/**
	 *
	 *  Id of the recipient of the invoice.
	 */
	recipientId: string | undefined;

	/**
	 *
	 *  The invoice reference number.
	 */
	invoiceReference: string | undefined;

	/**
	 *
	 *  The decision reference number.
	 */
	decisionReference: string | undefined;

	/**
	 *
	 *  The third party reference.
	 */
	thirdPartyReference: string | undefined;

	/**
	 *
	 *  Justification for third party payment.
	 */
	thirdPartyPaymentJustification: string | undefined;

	/**
	 *
	 *  Reason for third party payment.
	 */
	thirdPartyPaymentReason: string | undefined;

	/**
	 *
	 *  The reason for the invoice.
	 */
	reason: string | undefined;

	/**
	 *
	 *  The group id for grouping related invoices.
	 */
	groupId: string | undefined;

	/**
	 *
	 *  Type of payment (cash, wired, insurance, debit card, etc.).
	 */
	paymentType: PaymentType | undefined;

	/**
	 *
	 *  The amount paid.
	 */
	paid: number | undefined;

	/**
	 *
	 *  List of payments made for this invoice.
	 */
	payments: Array<Payment> | undefined;

	/**
	 *
	 *  SSIN of the gnotion.
	 */
	gnotionSsin: string | undefined;

	/**
	 *
	 *  Last name of the gnotion.
	 */
	gnotionLastName: string | undefined;

	/**
	 *
	 *  First name of the gnotion.
	 */
	gnotionFirstName: string | undefined;

	/**
	 *
	 *  CD-HCPARTY code of the gnotion.
	 */
	gnotionCdHcParty: string | undefined;

	/**
	 *
	 *  The invoicing period.
	 */
	invoicePeriod: number | undefined;

	/**
	 *
	 *  The type of care provider.
	 */
	careProviderType: string | undefined;

	/**
	 *
	 *  SSIN of the internship.
	 */
	internshipSsin: string | undefined;

	/**
	 *
	 *  Last name of the internship supervisor.
	 */
	internshipLastName: string | undefined;

	/**
	 *
	 *  First name of the internship supervisor.
	 */
	internshipFirstName: string | undefined;

	/**
	 *
	 *  CD-HCPARTY code of the internship.
	 */
	internshipCdHcParty: string | undefined;

	/**
	 *
	 *  CBE number of the internship.
	 */
	internshipCbe: string | undefined;

	/**
	 *
	 *  SSIN of the supervisor.
	 */
	supervisorSsin: string | undefined;

	/**
	 *
	 *  Last name of the supervisor.
	 */
	supervisorLastName: string | undefined;

	/**
	 *
	 *  First name of the supervisor.
	 */
	supervisorFirstName: string | undefined;

	/**
	 *
	 *  CD-HCPARTY code of the supervisor.
	 */
	supervisorCdHcParty: string | undefined;

	/**
	 *
	 *  CBE number of the supervisor.
	 */
	supervisorCbe: string | undefined;

	/**
	 *
	 *  Error message if any.
	 */
	error: string | undefined;

	/**
	 *
	 *  Name of the encounter location.
	 */
	encounterLocationName: string | undefined;

	/**
	 *
	 *  Norm of the encounter location.
	 */
	encounterLocationNorm: number | undefined;

	/**
	 *
	 *  Justification for long delay.
	 */
	longDelayJustification: number | undefined;

	/**
	 *
	 *  Id of the corrective invoice.
	 */
	correctiveInvoiceId: string | undefined;

	/**
	 *
	 *  Id of the corrected invoice.
	 */
	correctedInvoiceId: string | undefined;

	/**
	 *
	 *  Whether this invoice is a credit note.
	 */
	creditNote: boolean | undefined;

	/**
	 *
	 *  Id of the related invoice for the credit note.
	 */
	creditNoteRelatedInvoiceId: string | undefined;

	/**
	 *
	 *  Identity document reader information.
	 */
	idDocument: IdentityDocumentReader | undefined;

	/**
	 *
	 *  The admission date for hospitalization invoices.
	 */
	admissionDate: number | undefined;

	/**
	 *
	 *  Service code of the location.
	 */
	locationService: number | undefined;

	/**
	 *
	 *  The reason for cancellation.
	 */
	cancelReason: string | undefined;

	/**
	 *
	 *  The date of cancellation.
	 */
	cancelDate: number | undefined;

	/**
	 *
	 *  Extra options for the invoice.
	 */
	options: { [ key: string ]: string };

	readonly isEncrypted: boolean;

	toJSON(): object;

}

/**
 *
 *  Represents an invoice. An invoice is used to bill patients, mutual funds, or paying agencies for
 *  healthcare
 *  services rendered. It is serialized in JSON and saved in the underlying iCure CouchDB database.
 *  /
 */
export class DecryptedInvoice {

	/**
	 *
	 *  The Id of the Invoice. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The revision of the invoice in the database, used for conflict management / optimistic locking.
	 */
	rev: string | undefined = undefined;

	/**
	 *
	 *  The identifiers of the invoice.
	 */
	identifier: Array<Identifier> = [];

	/**
	 *
	 *  The timestamp (unix epoch in ms) of creation.
	 */
	created: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of the latest modification.
	 */
	modified: number | undefined = undefined;

	/**
	 *
	 *  The id of the User that created this invoice.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the HealthcareParty that is responsible for this invoice.
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Tags that qualify the invoice as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  Codes that identify or qualify this particular invoice.
	 */
	codes: Array<CodeStub> = [];

	/**
	 *
	 *  Hard delete (unix epoch in ms) timestamp of the object.
	 */
	deletionDate: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the invoice was drafted.
	 */
	invoiceDate: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the invoice was sent.
	 */
	sentDate: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the invoice was printed.
	 */
	printedDate: number | undefined = undefined;

	/**
	 *
	 *  The list of invoicing codes associated with this invoice.
	 */
	invoicingCodes: Array<DecryptedInvoicingCode> = [];

	/**
	 *
	 *  Map of receipt references.
	 */
	receipts: { [ key: string ]: string } = {};

	/**
	 *
	 *  Id of the recipient of the invoice.
	 */
	recipientId: string | undefined = undefined;

	/**
	 *
	 *  The invoice reference number.
	 */
	invoiceReference: string | undefined = undefined;

	/**
	 *
	 *  The decision reference number.
	 */
	decisionReference: string | undefined = undefined;

	/**
	 *
	 *  The third party reference.
	 */
	thirdPartyReference: string | undefined = undefined;

	/**
	 *
	 *  Justification for third party payment.
	 */
	thirdPartyPaymentJustification: string | undefined = undefined;

	/**
	 *
	 *  Reason for third party payment.
	 */
	thirdPartyPaymentReason: string | undefined = undefined;

	/**
	 *
	 *  The reason for the invoice.
	 */
	reason: string | undefined = undefined;

	/**
	 *
	 *  The group id for grouping related invoices.
	 */
	groupId: string | undefined = undefined;

	/**
	 *
	 *  Type of payment (cash, wired, insurance, debit card, etc.).
	 */
	paymentType: PaymentType | undefined = undefined;

	/**
	 *
	 *  The amount paid.
	 */
	paid: number | undefined = undefined;

	/**
	 *
	 *  List of payments made for this invoice.
	 */
	payments: Array<Payment> | undefined = undefined;

	/**
	 *
	 *  SSIN of the gnotion.
	 */
	gnotionSsin: string | undefined = undefined;

	/**
	 *
	 *  Last name of the gnotion.
	 */
	gnotionLastName: string | undefined = undefined;

	/**
	 *
	 *  First name of the gnotion.
	 */
	gnotionFirstName: string | undefined = undefined;

	/**
	 *
	 *  CD-HCPARTY code of the gnotion.
	 */
	gnotionCdHcParty: string | undefined = undefined;

	/**
	 *
	 *  The invoicing period.
	 */
	invoicePeriod: number | undefined = undefined;

	/**
	 *
	 *  The type of care provider.
	 */
	careProviderType: string | undefined = undefined;

	/**
	 *
	 *  SSIN of the internship.
	 */
	internshipSsin: string | undefined = undefined;

	/**
	 *
	 *  Last name of the internship supervisor.
	 */
	internshipLastName: string | undefined = undefined;

	/**
	 *
	 *  First name of the internship supervisor.
	 */
	internshipFirstName: string | undefined = undefined;

	/**
	 *
	 *  CD-HCPARTY code of the internship.
	 */
	internshipCdHcParty: string | undefined = undefined;

	/**
	 *
	 *  CBE number of the internship.
	 */
	internshipCbe: string | undefined = undefined;

	/**
	 *
	 *  SSIN of the supervisor.
	 */
	supervisorSsin: string | undefined = undefined;

	/**
	 *
	 *  Last name of the supervisor.
	 */
	supervisorLastName: string | undefined = undefined;

	/**
	 *
	 *  First name of the supervisor.
	 */
	supervisorFirstName: string | undefined = undefined;

	/**
	 *
	 *  CD-HCPARTY code of the supervisor.
	 */
	supervisorCdHcParty: string | undefined = undefined;

	/**
	 *
	 *  CBE number of the supervisor.
	 */
	supervisorCbe: string | undefined = undefined;

	/**
	 *
	 *  Error message if any.
	 */
	error: string | undefined = undefined;

	/**
	 *
	 *  Name of the encounter location.
	 */
	encounterLocationName: string | undefined = undefined;

	/**
	 *
	 *  Norm of the encounter location.
	 */
	encounterLocationNorm: number | undefined = undefined;

	/**
	 *
	 *  Justification for long delay.
	 */
	longDelayJustification: number | undefined = undefined;

	/**
	 *
	 *  Id of the corrective invoice.
	 */
	correctiveInvoiceId: string | undefined = undefined;

	/**
	 *
	 *  Id of the corrected invoice.
	 */
	correctedInvoiceId: string | undefined = undefined;

	/**
	 *
	 *  Whether this invoice is a credit note.
	 */
	creditNote: boolean | undefined = undefined;

	/**
	 *
	 *  Id of the related invoice for the credit note.
	 */
	creditNoteRelatedInvoiceId: string | undefined = undefined;

	/**
	 *
	 *  Identity document reader information.
	 */
	idDocument: IdentityDocumentReader | undefined = undefined;

	/**
	 *
	 *  The admission date for hospitalization invoices.
	 */
	admissionDate: number | undefined = undefined;

	/**
	 *
	 *  Service code of the location.
	 */
	locationService: number | undefined = undefined;

	/**
	 *
	 *  The reason for cancellation.
	 */
	cancelReason: string | undefined = undefined;

	/**
	 *
	 *  The date of cancellation.
	 */
	cancelDate: number | undefined = undefined;

	/**
	 *
	 *  Extra options for the invoice.
	 */
	options: { [ key: string ]: string } = {};

	/**
	 *
	 *  The secret patient key, encrypted in the patient's own AES key.
	 */
	secretForeignKeys: Array<string> = [];

	/**
	 *
	 *  The patient id encrypted in the delegates' AES keys.
	 */
	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The delegations giving access to connected healthcare information.
	 */
	delegations: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The keys used to encrypt this entity when stored encrypted.
	 */
	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The base64-encoded encrypted fields of this entity.
	 */
	encryptedSelf: Base64String | undefined = undefined;

	/**
	 *
	 *  The security metadata of the entity.
	 */
	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedInvoice>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('invoiceDate' in partial) this.invoiceDate = partial.invoiceDate;
		if ('sentDate' in partial) this.sentDate = partial.sentDate;
		if ('printedDate' in partial) this.printedDate = partial.printedDate;
		if ('invoicingCodes' in partial && partial.invoicingCodes !== undefined) this.invoicingCodes = partial.invoicingCodes;
		if ('receipts' in partial && partial.receipts !== undefined) this.receipts = partial.receipts;
		if ('recipientId' in partial) this.recipientId = partial.recipientId;
		if ('invoiceReference' in partial) this.invoiceReference = partial.invoiceReference;
		if ('decisionReference' in partial) this.decisionReference = partial.decisionReference;
		if ('thirdPartyReference' in partial) this.thirdPartyReference = partial.thirdPartyReference;
		if ('thirdPartyPaymentJustification' in partial) this.thirdPartyPaymentJustification = partial.thirdPartyPaymentJustification;
		if ('thirdPartyPaymentReason' in partial) this.thirdPartyPaymentReason = partial.thirdPartyPaymentReason;
		if ('reason' in partial) this.reason = partial.reason;
		if ('groupId' in partial) this.groupId = partial.groupId;
		if ('paymentType' in partial) this.paymentType = partial.paymentType;
		if ('paid' in partial) this.paid = partial.paid;
		if ('payments' in partial) this.payments = partial.payments;
		if ('gnotionSsin' in partial) this.gnotionSsin = partial.gnotionSsin;
		if ('gnotionLastName' in partial) this.gnotionLastName = partial.gnotionLastName;
		if ('gnotionFirstName' in partial) this.gnotionFirstName = partial.gnotionFirstName;
		if ('gnotionCdHcParty' in partial) this.gnotionCdHcParty = partial.gnotionCdHcParty;
		if ('invoicePeriod' in partial) this.invoicePeriod = partial.invoicePeriod;
		if ('careProviderType' in partial) this.careProviderType = partial.careProviderType;
		if ('internshipSsin' in partial) this.internshipSsin = partial.internshipSsin;
		if ('internshipLastName' in partial) this.internshipLastName = partial.internshipLastName;
		if ('internshipFirstName' in partial) this.internshipFirstName = partial.internshipFirstName;
		if ('internshipCdHcParty' in partial) this.internshipCdHcParty = partial.internshipCdHcParty;
		if ('internshipCbe' in partial) this.internshipCbe = partial.internshipCbe;
		if ('supervisorSsin' in partial) this.supervisorSsin = partial.supervisorSsin;
		if ('supervisorLastName' in partial) this.supervisorLastName = partial.supervisorLastName;
		if ('supervisorFirstName' in partial) this.supervisorFirstName = partial.supervisorFirstName;
		if ('supervisorCdHcParty' in partial) this.supervisorCdHcParty = partial.supervisorCdHcParty;
		if ('supervisorCbe' in partial) this.supervisorCbe = partial.supervisorCbe;
		if ('error' in partial) this.error = partial.error;
		if ('encounterLocationName' in partial) this.encounterLocationName = partial.encounterLocationName;
		if ('encounterLocationNorm' in partial) this.encounterLocationNorm = partial.encounterLocationNorm;
		if ('longDelayJustification' in partial) this.longDelayJustification = partial.longDelayJustification;
		if ('correctiveInvoiceId' in partial) this.correctiveInvoiceId = partial.correctiveInvoiceId;
		if ('correctedInvoiceId' in partial) this.correctedInvoiceId = partial.correctedInvoiceId;
		if ('creditNote' in partial) this.creditNote = partial.creditNote;
		if ('creditNoteRelatedInvoiceId' in partial) this.creditNoteRelatedInvoiceId = partial.creditNoteRelatedInvoiceId;
		if ('idDocument' in partial) this.idDocument = partial.idDocument;
		if ('admissionDate' in partial) this.admissionDate = partial.admissionDate;
		if ('locationService' in partial) this.locationService = partial.locationService;
		if ('cancelReason' in partial) this.cancelReason = partial.cancelReason;
		if ('cancelDate' in partial) this.cancelDate = partial.cancelDate;
		if ('options' in partial && partial.options !== undefined) this.options = partial.options;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		res['identifier'] = this.identifier.map((x0) => x0.toJSON() )
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.invoiceDate != undefined) res['invoiceDate'] = this.invoiceDate
		if (this.sentDate != undefined) res['sentDate'] = this.sentDate
		if (this.printedDate != undefined) res['printedDate'] = this.printedDate
		res['invoicingCodes'] = this.invoicingCodes.map((x0) => x0.toJSON() )
		res['receipts'] = Object.fromEntries(Object.entries(this.receipts).map(([k0, v0]) => [k0, v0]))
		if (this.recipientId != undefined) res['recipientId'] = this.recipientId
		if (this.invoiceReference != undefined) res['invoiceReference'] = this.invoiceReference
		if (this.decisionReference != undefined) res['decisionReference'] = this.decisionReference
		if (this.thirdPartyReference != undefined) res['thirdPartyReference'] = this.thirdPartyReference
		if (this.thirdPartyPaymentJustification != undefined) res['thirdPartyPaymentJustification'] = this.thirdPartyPaymentJustification
		if (this.thirdPartyPaymentReason != undefined) res['thirdPartyPaymentReason'] = this.thirdPartyPaymentReason
		if (this.reason != undefined) res['reason'] = this.reason
		if (this.groupId != undefined) res['groupId'] = this.groupId
		if (this.paymentType != undefined) res['paymentType'] = this.paymentType
		if (this.paid != undefined) res['paid'] = this.paid
		if (this.payments != undefined) res['payments'] = this.payments.map((x0) => x0.toJSON() )
		if (this.gnotionSsin != undefined) res['gnotionSsin'] = this.gnotionSsin
		if (this.gnotionLastName != undefined) res['gnotionLastName'] = this.gnotionLastName
		if (this.gnotionFirstName != undefined) res['gnotionFirstName'] = this.gnotionFirstName
		if (this.gnotionCdHcParty != undefined) res['gnotionCdHcParty'] = this.gnotionCdHcParty
		if (this.invoicePeriod != undefined) res['invoicePeriod'] = this.invoicePeriod
		if (this.careProviderType != undefined) res['careProviderType'] = this.careProviderType
		if (this.internshipSsin != undefined) res['internshipSsin'] = this.internshipSsin
		if (this.internshipLastName != undefined) res['internshipLastName'] = this.internshipLastName
		if (this.internshipFirstName != undefined) res['internshipFirstName'] = this.internshipFirstName
		if (this.internshipCdHcParty != undefined) res['internshipCdHcParty'] = this.internshipCdHcParty
		if (this.internshipCbe != undefined) res['internshipCbe'] = this.internshipCbe
		if (this.supervisorSsin != undefined) res['supervisorSsin'] = this.supervisorSsin
		if (this.supervisorLastName != undefined) res['supervisorLastName'] = this.supervisorLastName
		if (this.supervisorFirstName != undefined) res['supervisorFirstName'] = this.supervisorFirstName
		if (this.supervisorCdHcParty != undefined) res['supervisorCdHcParty'] = this.supervisorCdHcParty
		if (this.supervisorCbe != undefined) res['supervisorCbe'] = this.supervisorCbe
		if (this.error != undefined) res['error'] = this.error
		if (this.encounterLocationName != undefined) res['encounterLocationName'] = this.encounterLocationName
		if (this.encounterLocationNorm != undefined) res['encounterLocationNorm'] = this.encounterLocationNorm
		if (this.longDelayJustification != undefined) res['longDelayJustification'] = this.longDelayJustification
		if (this.correctiveInvoiceId != undefined) res['correctiveInvoiceId'] = this.correctiveInvoiceId
		if (this.correctedInvoiceId != undefined) res['correctedInvoiceId'] = this.correctedInvoiceId
		if (this.creditNote != undefined) res['creditNote'] = this.creditNote
		if (this.creditNoteRelatedInvoiceId != undefined) res['creditNoteRelatedInvoiceId'] = this.creditNoteRelatedInvoiceId
		if (this.idDocument != undefined) res['idDocument'] = this.idDocument.toJSON()
		if (this.admissionDate != undefined) res['admissionDate'] = this.admissionDate
		if (this.locationService != undefined) res['locationService'] = this.locationService
		if (this.cancelReason != undefined) res['cancelReason'] = this.cancelReason
		if (this.cancelDate != undefined) res['cancelDate'] = this.cancelDate
		res['options'] = Object.fromEntries(Object.entries(this.options).map(([k0, v0]) => [k0, v0]))
		res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedInvoice']): DecryptedInvoice {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedInvoice`)
		const res = new DecryptedInvoice({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			identifier: expectArray(extractEntry(jCpy, 'identifier', false, path), false, [...path, ".identifier"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Identifier.fromJSON)),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			invoiceDate: expectNumber(extractEntry(jCpy, 'invoiceDate', false, path), true, true, [...path, ".invoiceDate"]),
			sentDate: expectNumber(extractEntry(jCpy, 'sentDate', false, path), true, true, [...path, ".sentDate"]),
			printedDate: expectNumber(extractEntry(jCpy, 'printedDate', false, path), true, true, [...path, ".printedDate"]),
			invoicingCodes: expectArray(extractEntry(jCpy, 'invoicingCodes', false, path), false, [...path, ".invoicingCodes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedInvoicingCode.fromJSON)),
			receipts: expectMap(
				extractEntry(jCpy, 'receipts', false, path),
				false,
				[...path, ".receipts"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			recipientId: expectString(extractEntry(jCpy, 'recipientId', false, path), true, [...path, ".recipientId"]),
			invoiceReference: expectString(extractEntry(jCpy, 'invoiceReference', false, path), true, [...path, ".invoiceReference"]),
			decisionReference: expectString(extractEntry(jCpy, 'decisionReference', false, path), true, [...path, ".decisionReference"]),
			thirdPartyReference: expectString(extractEntry(jCpy, 'thirdPartyReference', false, path), true, [...path, ".thirdPartyReference"]),
			thirdPartyPaymentJustification: expectString(extractEntry(jCpy, 'thirdPartyPaymentJustification', false, path), true, [...path, ".thirdPartyPaymentJustification"]),
			thirdPartyPaymentReason: expectString(extractEntry(jCpy, 'thirdPartyPaymentReason', false, path), true, [...path, ".thirdPartyPaymentReason"]),
			reason: expectString(extractEntry(jCpy, 'reason', false, path), true, [...path, ".reason"]),
			groupId: expectString(extractEntry(jCpy, 'groupId', false, path), true, [...path, ".groupId"]),
			paymentType: expectStringEnum(extractEntry(jCpy, 'paymentType', false, path), true, [...path, ".paymentType"], PaymentType, 'PaymentType'),
			paid: expectNumber(extractEntry(jCpy, 'paid', false, path), true, false, [...path, ".paid"]),
			payments: expectArray(extractEntry(jCpy, 'payments', false, path), true, [...path, ".payments"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Payment.fromJSON)),
			gnotionSsin: expectString(extractEntry(jCpy, 'gnotionSsin', false, path), true, [...path, ".gnotionSsin"]),
			gnotionLastName: expectString(extractEntry(jCpy, 'gnotionLastName', false, path), true, [...path, ".gnotionLastName"]),
			gnotionFirstName: expectString(extractEntry(jCpy, 'gnotionFirstName', false, path), true, [...path, ".gnotionFirstName"]),
			gnotionCdHcParty: expectString(extractEntry(jCpy, 'gnotionCdHcParty', false, path), true, [...path, ".gnotionCdHcParty"]),
			invoicePeriod: expectNumber(extractEntry(jCpy, 'invoicePeriod', false, path), true, true, [...path, ".invoicePeriod"]),
			careProviderType: expectString(extractEntry(jCpy, 'careProviderType', false, path), true, [...path, ".careProviderType"]),
			internshipSsin: expectString(extractEntry(jCpy, 'internshipSsin', false, path), true, [...path, ".internshipSsin"]),
			internshipLastName: expectString(extractEntry(jCpy, 'internshipLastName', false, path), true, [...path, ".internshipLastName"]),
			internshipFirstName: expectString(extractEntry(jCpy, 'internshipFirstName', false, path), true, [...path, ".internshipFirstName"]),
			internshipCdHcParty: expectString(extractEntry(jCpy, 'internshipCdHcParty', false, path), true, [...path, ".internshipCdHcParty"]),
			internshipCbe: expectString(extractEntry(jCpy, 'internshipCbe', false, path), true, [...path, ".internshipCbe"]),
			supervisorSsin: expectString(extractEntry(jCpy, 'supervisorSsin', false, path), true, [...path, ".supervisorSsin"]),
			supervisorLastName: expectString(extractEntry(jCpy, 'supervisorLastName', false, path), true, [...path, ".supervisorLastName"]),
			supervisorFirstName: expectString(extractEntry(jCpy, 'supervisorFirstName', false, path), true, [...path, ".supervisorFirstName"]),
			supervisorCdHcParty: expectString(extractEntry(jCpy, 'supervisorCdHcParty', false, path), true, [...path, ".supervisorCdHcParty"]),
			supervisorCbe: expectString(extractEntry(jCpy, 'supervisorCbe', false, path), true, [...path, ".supervisorCbe"]),
			error: expectString(extractEntry(jCpy, 'error', false, path), true, [...path, ".error"]),
			encounterLocationName: expectString(extractEntry(jCpy, 'encounterLocationName', false, path), true, [...path, ".encounterLocationName"]),
			encounterLocationNorm: expectNumber(extractEntry(jCpy, 'encounterLocationNorm', false, path), true, true, [...path, ".encounterLocationNorm"]),
			longDelayJustification: expectNumber(extractEntry(jCpy, 'longDelayJustification', false, path), true, true, [...path, ".longDelayJustification"]),
			correctiveInvoiceId: expectString(extractEntry(jCpy, 'correctiveInvoiceId', false, path), true, [...path, ".correctiveInvoiceId"]),
			correctedInvoiceId: expectString(extractEntry(jCpy, 'correctedInvoiceId', false, path), true, [...path, ".correctedInvoiceId"]),
			creditNote: expectBoolean(extractEntry(jCpy, 'creditNote', false, path), true, [...path, ".creditNote"]),
			creditNoteRelatedInvoiceId: expectString(extractEntry(jCpy, 'creditNoteRelatedInvoiceId', false, path), true, [...path, ".creditNoteRelatedInvoiceId"]),
			idDocument: expectObject(extractEntry(jCpy, 'idDocument', false, path), true, ignoreUnknownKeys, [...path, ".idDocument"], IdentityDocumentReader.fromJSON),
			admissionDate: expectNumber(extractEntry(jCpy, 'admissionDate', false, path), true, true, [...path, ".admissionDate"]),
			locationService: expectNumber(extractEntry(jCpy, 'locationService', false, path), true, true, [...path, ".locationService"]),
			cancelReason: expectString(extractEntry(jCpy, 'cancelReason', false, path), true, [...path, ".cancelReason"]),
			cancelDate: expectNumber(extractEntry(jCpy, 'cancelDate', false, path), true, true, [...path, ".cancelDate"]),
			options: expectMap(
				extractEntry(jCpy, 'options', false, path),
				false,
				[...path, ".options"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			secretForeignKeys: expectArray(extractEntry(jCpy, 'secretForeignKeys', false, path), false, [...path, ".secretForeignKeys"], (x0, p0) => expectString(x0, false, p0)),
			cryptedForeignKeys: expectMap(
				extractEntry(jCpy, 'cryptedForeignKeys', false, path),
				false,
				[...path, ".cryptedForeignKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			delegations: expectMap(
				extractEntry(jCpy, 'delegations', false, path),
				false,
				[...path, ".delegations"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			encryptionKeys: expectMap(
				extractEntry(jCpy, 'encryptionKeys', false, path),
				false,
				[...path, ".encryptionKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
			securityMetadata: expectObject(extractEntry(jCpy, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedInvoice at path ${path.join("")}: ${unused}`)}
		return res
	}

}

/**
 *
 *  Represents an invoice. An invoice is used to bill patients, mutual funds, or paying agencies for
 *  healthcare
 *  services rendered. It is serialized in JSON and saved in the underlying iCure CouchDB database.
 *  /
 */
export class EncryptedInvoice {

	/**
	 *
	 *  The Id of the Invoice. We encourage using either a v4 UUID or a HL7 Id.
	 */
	id: string;

	/**
	 *
	 *  The revision of the invoice in the database, used for conflict management / optimistic locking.
	 */
	rev: string | undefined = undefined;

	/**
	 *
	 *  The identifiers of the invoice.
	 */
	identifier: Array<Identifier> = [];

	/**
	 *
	 *  The timestamp (unix epoch in ms) of creation.
	 */
	created: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) of the latest modification.
	 */
	modified: number | undefined = undefined;

	/**
	 *
	 *  The id of the User that created this invoice.
	 */
	author: string | undefined = undefined;

	/**
	 *
	 *  The id of the HealthcareParty that is responsible for this invoice.
	 */
	responsible: string | undefined = undefined;

	/**
	 *
	 *  Tags that qualify the invoice as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  Codes that identify or qualify this particular invoice.
	 */
	codes: Array<CodeStub> = [];

	/**
	 *
	 *  Hard delete (unix epoch in ms) timestamp of the object.
	 */
	deletionDate: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the invoice was drafted.
	 */
	invoiceDate: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the invoice was sent.
	 */
	sentDate: number | undefined = undefined;

	/**
	 *
	 *  The timestamp (unix epoch in ms) when the invoice was printed.
	 */
	printedDate: number | undefined = undefined;

	/**
	 *
	 *  The list of invoicing codes associated with this invoice.
	 */
	invoicingCodes: Array<EncryptedInvoicingCode> = [];

	/**
	 *
	 *  Map of receipt references.
	 */
	receipts: { [ key: string ]: string } = {};

	/**
	 *
	 *  Id of the recipient of the invoice.
	 */
	recipientId: string | undefined = undefined;

	/**
	 *
	 *  The invoice reference number.
	 */
	invoiceReference: string | undefined = undefined;

	/**
	 *
	 *  The decision reference number.
	 */
	decisionReference: string | undefined = undefined;

	/**
	 *
	 *  The third party reference.
	 */
	thirdPartyReference: string | undefined = undefined;

	/**
	 *
	 *  Justification for third party payment.
	 */
	thirdPartyPaymentJustification: string | undefined = undefined;

	/**
	 *
	 *  Reason for third party payment.
	 */
	thirdPartyPaymentReason: string | undefined = undefined;

	/**
	 *
	 *  The reason for the invoice.
	 */
	reason: string | undefined = undefined;

	/**
	 *
	 *  The group id for grouping related invoices.
	 */
	groupId: string | undefined = undefined;

	/**
	 *
	 *  Type of payment (cash, wired, insurance, debit card, etc.).
	 */
	paymentType: PaymentType | undefined = undefined;

	/**
	 *
	 *  The amount paid.
	 */
	paid: number | undefined = undefined;

	/**
	 *
	 *  List of payments made for this invoice.
	 */
	payments: Array<Payment> | undefined = undefined;

	/**
	 *
	 *  SSIN of the gnotion.
	 */
	gnotionSsin: string | undefined = undefined;

	/**
	 *
	 *  Last name of the gnotion.
	 */
	gnotionLastName: string | undefined = undefined;

	/**
	 *
	 *  First name of the gnotion.
	 */
	gnotionFirstName: string | undefined = undefined;

	/**
	 *
	 *  CD-HCPARTY code of the gnotion.
	 */
	gnotionCdHcParty: string | undefined = undefined;

	/**
	 *
	 *  The invoicing period.
	 */
	invoicePeriod: number | undefined = undefined;

	/**
	 *
	 *  The type of care provider.
	 */
	careProviderType: string | undefined = undefined;

	/**
	 *
	 *  SSIN of the internship.
	 */
	internshipSsin: string | undefined = undefined;

	/**
	 *
	 *  Last name of the internship supervisor.
	 */
	internshipLastName: string | undefined = undefined;

	/**
	 *
	 *  First name of the internship supervisor.
	 */
	internshipFirstName: string | undefined = undefined;

	/**
	 *
	 *  CD-HCPARTY code of the internship.
	 */
	internshipCdHcParty: string | undefined = undefined;

	/**
	 *
	 *  CBE number of the internship.
	 */
	internshipCbe: string | undefined = undefined;

	/**
	 *
	 *  SSIN of the supervisor.
	 */
	supervisorSsin: string | undefined = undefined;

	/**
	 *
	 *  Last name of the supervisor.
	 */
	supervisorLastName: string | undefined = undefined;

	/**
	 *
	 *  First name of the supervisor.
	 */
	supervisorFirstName: string | undefined = undefined;

	/**
	 *
	 *  CD-HCPARTY code of the supervisor.
	 */
	supervisorCdHcParty: string | undefined = undefined;

	/**
	 *
	 *  CBE number of the supervisor.
	 */
	supervisorCbe: string | undefined = undefined;

	/**
	 *
	 *  Error message if any.
	 */
	error: string | undefined = undefined;

	/**
	 *
	 *  Name of the encounter location.
	 */
	encounterLocationName: string | undefined = undefined;

	/**
	 *
	 *  Norm of the encounter location.
	 */
	encounterLocationNorm: number | undefined = undefined;

	/**
	 *
	 *  Justification for long delay.
	 */
	longDelayJustification: number | undefined = undefined;

	/**
	 *
	 *  Id of the corrective invoice.
	 */
	correctiveInvoiceId: string | undefined = undefined;

	/**
	 *
	 *  Id of the corrected invoice.
	 */
	correctedInvoiceId: string | undefined = undefined;

	/**
	 *
	 *  Whether this invoice is a credit note.
	 */
	creditNote: boolean | undefined = undefined;

	/**
	 *
	 *  Id of the related invoice for the credit note.
	 */
	creditNoteRelatedInvoiceId: string | undefined = undefined;

	/**
	 *
	 *  Identity document reader information.
	 */
	idDocument: IdentityDocumentReader | undefined = undefined;

	/**
	 *
	 *  The admission date for hospitalization invoices.
	 */
	admissionDate: number | undefined = undefined;

	/**
	 *
	 *  Service code of the location.
	 */
	locationService: number | undefined = undefined;

	/**
	 *
	 *  The reason for cancellation.
	 */
	cancelReason: string | undefined = undefined;

	/**
	 *
	 *  The date of cancellation.
	 */
	cancelDate: number | undefined = undefined;

	/**
	 *
	 *  Extra options for the invoice.
	 */
	options: { [ key: string ]: string } = {};

	/**
	 *
	 *  The secret patient key, encrypted in the patient's own AES key.
	 */
	secretForeignKeys: Array<string> = [];

	/**
	 *
	 *  The patient id encrypted in the delegates' AES keys.
	 */
	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The delegations giving access to connected healthcare information.
	 */
	delegations: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The keys used to encrypt this entity when stored encrypted.
	 */
	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	/**
	 *
	 *  The base64-encoded encrypted fields of this entity.
	 */
	encryptedSelf: Base64String | undefined = undefined;

	/**
	 *
	 *  The security metadata of the entity.
	 */
	securityMetadata: SecurityMetadata | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedInvoice>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
		if ('created' in partial) this.created = partial.created;
		if ('modified' in partial) this.modified = partial.modified;
		if ('author' in partial) this.author = partial.author;
		if ('responsible' in partial) this.responsible = partial.responsible;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('invoiceDate' in partial) this.invoiceDate = partial.invoiceDate;
		if ('sentDate' in partial) this.sentDate = partial.sentDate;
		if ('printedDate' in partial) this.printedDate = partial.printedDate;
		if ('invoicingCodes' in partial && partial.invoicingCodes !== undefined) this.invoicingCodes = partial.invoicingCodes;
		if ('receipts' in partial && partial.receipts !== undefined) this.receipts = partial.receipts;
		if ('recipientId' in partial) this.recipientId = partial.recipientId;
		if ('invoiceReference' in partial) this.invoiceReference = partial.invoiceReference;
		if ('decisionReference' in partial) this.decisionReference = partial.decisionReference;
		if ('thirdPartyReference' in partial) this.thirdPartyReference = partial.thirdPartyReference;
		if ('thirdPartyPaymentJustification' in partial) this.thirdPartyPaymentJustification = partial.thirdPartyPaymentJustification;
		if ('thirdPartyPaymentReason' in partial) this.thirdPartyPaymentReason = partial.thirdPartyPaymentReason;
		if ('reason' in partial) this.reason = partial.reason;
		if ('groupId' in partial) this.groupId = partial.groupId;
		if ('paymentType' in partial) this.paymentType = partial.paymentType;
		if ('paid' in partial) this.paid = partial.paid;
		if ('payments' in partial) this.payments = partial.payments;
		if ('gnotionSsin' in partial) this.gnotionSsin = partial.gnotionSsin;
		if ('gnotionLastName' in partial) this.gnotionLastName = partial.gnotionLastName;
		if ('gnotionFirstName' in partial) this.gnotionFirstName = partial.gnotionFirstName;
		if ('gnotionCdHcParty' in partial) this.gnotionCdHcParty = partial.gnotionCdHcParty;
		if ('invoicePeriod' in partial) this.invoicePeriod = partial.invoicePeriod;
		if ('careProviderType' in partial) this.careProviderType = partial.careProviderType;
		if ('internshipSsin' in partial) this.internshipSsin = partial.internshipSsin;
		if ('internshipLastName' in partial) this.internshipLastName = partial.internshipLastName;
		if ('internshipFirstName' in partial) this.internshipFirstName = partial.internshipFirstName;
		if ('internshipCdHcParty' in partial) this.internshipCdHcParty = partial.internshipCdHcParty;
		if ('internshipCbe' in partial) this.internshipCbe = partial.internshipCbe;
		if ('supervisorSsin' in partial) this.supervisorSsin = partial.supervisorSsin;
		if ('supervisorLastName' in partial) this.supervisorLastName = partial.supervisorLastName;
		if ('supervisorFirstName' in partial) this.supervisorFirstName = partial.supervisorFirstName;
		if ('supervisorCdHcParty' in partial) this.supervisorCdHcParty = partial.supervisorCdHcParty;
		if ('supervisorCbe' in partial) this.supervisorCbe = partial.supervisorCbe;
		if ('error' in partial) this.error = partial.error;
		if ('encounterLocationName' in partial) this.encounterLocationName = partial.encounterLocationName;
		if ('encounterLocationNorm' in partial) this.encounterLocationNorm = partial.encounterLocationNorm;
		if ('longDelayJustification' in partial) this.longDelayJustification = partial.longDelayJustification;
		if ('correctiveInvoiceId' in partial) this.correctiveInvoiceId = partial.correctiveInvoiceId;
		if ('correctedInvoiceId' in partial) this.correctedInvoiceId = partial.correctedInvoiceId;
		if ('creditNote' in partial) this.creditNote = partial.creditNote;
		if ('creditNoteRelatedInvoiceId' in partial) this.creditNoteRelatedInvoiceId = partial.creditNoteRelatedInvoiceId;
		if ('idDocument' in partial) this.idDocument = partial.idDocument;
		if ('admissionDate' in partial) this.admissionDate = partial.admissionDate;
		if ('locationService' in partial) this.locationService = partial.locationService;
		if ('cancelReason' in partial) this.cancelReason = partial.cancelReason;
		if ('cancelDate' in partial) this.cancelDate = partial.cancelDate;
		if ('options' in partial && partial.options !== undefined) this.options = partial.options;
		if ('secretForeignKeys' in partial && partial.secretForeignKeys !== undefined) this.secretForeignKeys = partial.secretForeignKeys;
		if ('cryptedForeignKeys' in partial && partial.cryptedForeignKeys !== undefined) this.cryptedForeignKeys = partial.cryptedForeignKeys;
		if ('delegations' in partial && partial.delegations !== undefined) this.delegations = partial.delegations;
		if ('encryptionKeys' in partial && partial.encryptionKeys !== undefined) this.encryptionKeys = partial.encryptionKeys;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
		if ('securityMetadata' in partial) this.securityMetadata = partial.securityMetadata;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		res['identifier'] = this.identifier.map((x0) => x0.toJSON() )
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.invoiceDate != undefined) res['invoiceDate'] = this.invoiceDate
		if (this.sentDate != undefined) res['sentDate'] = this.sentDate
		if (this.printedDate != undefined) res['printedDate'] = this.printedDate
		res['invoicingCodes'] = this.invoicingCodes.map((x0) => x0.toJSON() )
		res['receipts'] = Object.fromEntries(Object.entries(this.receipts).map(([k0, v0]) => [k0, v0]))
		if (this.recipientId != undefined) res['recipientId'] = this.recipientId
		if (this.invoiceReference != undefined) res['invoiceReference'] = this.invoiceReference
		if (this.decisionReference != undefined) res['decisionReference'] = this.decisionReference
		if (this.thirdPartyReference != undefined) res['thirdPartyReference'] = this.thirdPartyReference
		if (this.thirdPartyPaymentJustification != undefined) res['thirdPartyPaymentJustification'] = this.thirdPartyPaymentJustification
		if (this.thirdPartyPaymentReason != undefined) res['thirdPartyPaymentReason'] = this.thirdPartyPaymentReason
		if (this.reason != undefined) res['reason'] = this.reason
		if (this.groupId != undefined) res['groupId'] = this.groupId
		if (this.paymentType != undefined) res['paymentType'] = this.paymentType
		if (this.paid != undefined) res['paid'] = this.paid
		if (this.payments != undefined) res['payments'] = this.payments.map((x0) => x0.toJSON() )
		if (this.gnotionSsin != undefined) res['gnotionSsin'] = this.gnotionSsin
		if (this.gnotionLastName != undefined) res['gnotionLastName'] = this.gnotionLastName
		if (this.gnotionFirstName != undefined) res['gnotionFirstName'] = this.gnotionFirstName
		if (this.gnotionCdHcParty != undefined) res['gnotionCdHcParty'] = this.gnotionCdHcParty
		if (this.invoicePeriod != undefined) res['invoicePeriod'] = this.invoicePeriod
		if (this.careProviderType != undefined) res['careProviderType'] = this.careProviderType
		if (this.internshipSsin != undefined) res['internshipSsin'] = this.internshipSsin
		if (this.internshipLastName != undefined) res['internshipLastName'] = this.internshipLastName
		if (this.internshipFirstName != undefined) res['internshipFirstName'] = this.internshipFirstName
		if (this.internshipCdHcParty != undefined) res['internshipCdHcParty'] = this.internshipCdHcParty
		if (this.internshipCbe != undefined) res['internshipCbe'] = this.internshipCbe
		if (this.supervisorSsin != undefined) res['supervisorSsin'] = this.supervisorSsin
		if (this.supervisorLastName != undefined) res['supervisorLastName'] = this.supervisorLastName
		if (this.supervisorFirstName != undefined) res['supervisorFirstName'] = this.supervisorFirstName
		if (this.supervisorCdHcParty != undefined) res['supervisorCdHcParty'] = this.supervisorCdHcParty
		if (this.supervisorCbe != undefined) res['supervisorCbe'] = this.supervisorCbe
		if (this.error != undefined) res['error'] = this.error
		if (this.encounterLocationName != undefined) res['encounterLocationName'] = this.encounterLocationName
		if (this.encounterLocationNorm != undefined) res['encounterLocationNorm'] = this.encounterLocationNorm
		if (this.longDelayJustification != undefined) res['longDelayJustification'] = this.longDelayJustification
		if (this.correctiveInvoiceId != undefined) res['correctiveInvoiceId'] = this.correctiveInvoiceId
		if (this.correctedInvoiceId != undefined) res['correctedInvoiceId'] = this.correctedInvoiceId
		if (this.creditNote != undefined) res['creditNote'] = this.creditNote
		if (this.creditNoteRelatedInvoiceId != undefined) res['creditNoteRelatedInvoiceId'] = this.creditNoteRelatedInvoiceId
		if (this.idDocument != undefined) res['idDocument'] = this.idDocument.toJSON()
		if (this.admissionDate != undefined) res['admissionDate'] = this.admissionDate
		if (this.locationService != undefined) res['locationService'] = this.locationService
		if (this.cancelReason != undefined) res['cancelReason'] = this.cancelReason
		if (this.cancelDate != undefined) res['cancelDate'] = this.cancelDate
		res['options'] = Object.fromEntries(Object.entries(this.options).map(([k0, v0]) => [k0, v0]))
		res['secretForeignKeys'] = this.secretForeignKeys.map((x0) => x0 )
		res['cryptedForeignKeys'] = Object.fromEntries(Object.entries(this.cryptedForeignKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['delegations'] = Object.fromEntries(Object.entries(this.delegations).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		res['encryptionKeys'] = Object.fromEntries(Object.entries(this.encryptionKeys).map(([k0, v0]) => [k0, v0.map((x1) => x1.toJSON() )]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		if (this.securityMetadata != undefined) res['securityMetadata'] = this.securityMetadata.toJSON()
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedInvoice']): EncryptedInvoice {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedInvoice`)
		const res = new EncryptedInvoice({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			identifier: expectArray(extractEntry(jCpy, 'identifier', false, path), false, [...path, ".identifier"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Identifier.fromJSON)),
			created: expectNumber(extractEntry(jCpy, 'created', false, path), true, true, [...path, ".created"]),
			modified: expectNumber(extractEntry(jCpy, 'modified', false, path), true, true, [...path, ".modified"]),
			author: expectString(extractEntry(jCpy, 'author', false, path), true, [...path, ".author"]),
			responsible: expectString(extractEntry(jCpy, 'responsible', false, path), true, [...path, ".responsible"]),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			invoiceDate: expectNumber(extractEntry(jCpy, 'invoiceDate', false, path), true, true, [...path, ".invoiceDate"]),
			sentDate: expectNumber(extractEntry(jCpy, 'sentDate', false, path), true, true, [...path, ".sentDate"]),
			printedDate: expectNumber(extractEntry(jCpy, 'printedDate', false, path), true, true, [...path, ".printedDate"]),
			invoicingCodes: expectArray(extractEntry(jCpy, 'invoicingCodes', false, path), false, [...path, ".invoicingCodes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedInvoicingCode.fromJSON)),
			receipts: expectMap(
				extractEntry(jCpy, 'receipts', false, path),
				false,
				[...path, ".receipts"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			recipientId: expectString(extractEntry(jCpy, 'recipientId', false, path), true, [...path, ".recipientId"]),
			invoiceReference: expectString(extractEntry(jCpy, 'invoiceReference', false, path), true, [...path, ".invoiceReference"]),
			decisionReference: expectString(extractEntry(jCpy, 'decisionReference', false, path), true, [...path, ".decisionReference"]),
			thirdPartyReference: expectString(extractEntry(jCpy, 'thirdPartyReference', false, path), true, [...path, ".thirdPartyReference"]),
			thirdPartyPaymentJustification: expectString(extractEntry(jCpy, 'thirdPartyPaymentJustification', false, path), true, [...path, ".thirdPartyPaymentJustification"]),
			thirdPartyPaymentReason: expectString(extractEntry(jCpy, 'thirdPartyPaymentReason', false, path), true, [...path, ".thirdPartyPaymentReason"]),
			reason: expectString(extractEntry(jCpy, 'reason', false, path), true, [...path, ".reason"]),
			groupId: expectString(extractEntry(jCpy, 'groupId', false, path), true, [...path, ".groupId"]),
			paymentType: expectStringEnum(extractEntry(jCpy, 'paymentType', false, path), true, [...path, ".paymentType"], PaymentType, 'PaymentType'),
			paid: expectNumber(extractEntry(jCpy, 'paid', false, path), true, false, [...path, ".paid"]),
			payments: expectArray(extractEntry(jCpy, 'payments', false, path), true, [...path, ".payments"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Payment.fromJSON)),
			gnotionSsin: expectString(extractEntry(jCpy, 'gnotionSsin', false, path), true, [...path, ".gnotionSsin"]),
			gnotionLastName: expectString(extractEntry(jCpy, 'gnotionLastName', false, path), true, [...path, ".gnotionLastName"]),
			gnotionFirstName: expectString(extractEntry(jCpy, 'gnotionFirstName', false, path), true, [...path, ".gnotionFirstName"]),
			gnotionCdHcParty: expectString(extractEntry(jCpy, 'gnotionCdHcParty', false, path), true, [...path, ".gnotionCdHcParty"]),
			invoicePeriod: expectNumber(extractEntry(jCpy, 'invoicePeriod', false, path), true, true, [...path, ".invoicePeriod"]),
			careProviderType: expectString(extractEntry(jCpy, 'careProviderType', false, path), true, [...path, ".careProviderType"]),
			internshipSsin: expectString(extractEntry(jCpy, 'internshipSsin', false, path), true, [...path, ".internshipSsin"]),
			internshipLastName: expectString(extractEntry(jCpy, 'internshipLastName', false, path), true, [...path, ".internshipLastName"]),
			internshipFirstName: expectString(extractEntry(jCpy, 'internshipFirstName', false, path), true, [...path, ".internshipFirstName"]),
			internshipCdHcParty: expectString(extractEntry(jCpy, 'internshipCdHcParty', false, path), true, [...path, ".internshipCdHcParty"]),
			internshipCbe: expectString(extractEntry(jCpy, 'internshipCbe', false, path), true, [...path, ".internshipCbe"]),
			supervisorSsin: expectString(extractEntry(jCpy, 'supervisorSsin', false, path), true, [...path, ".supervisorSsin"]),
			supervisorLastName: expectString(extractEntry(jCpy, 'supervisorLastName', false, path), true, [...path, ".supervisorLastName"]),
			supervisorFirstName: expectString(extractEntry(jCpy, 'supervisorFirstName', false, path), true, [...path, ".supervisorFirstName"]),
			supervisorCdHcParty: expectString(extractEntry(jCpy, 'supervisorCdHcParty', false, path), true, [...path, ".supervisorCdHcParty"]),
			supervisorCbe: expectString(extractEntry(jCpy, 'supervisorCbe', false, path), true, [...path, ".supervisorCbe"]),
			error: expectString(extractEntry(jCpy, 'error', false, path), true, [...path, ".error"]),
			encounterLocationName: expectString(extractEntry(jCpy, 'encounterLocationName', false, path), true, [...path, ".encounterLocationName"]),
			encounterLocationNorm: expectNumber(extractEntry(jCpy, 'encounterLocationNorm', false, path), true, true, [...path, ".encounterLocationNorm"]),
			longDelayJustification: expectNumber(extractEntry(jCpy, 'longDelayJustification', false, path), true, true, [...path, ".longDelayJustification"]),
			correctiveInvoiceId: expectString(extractEntry(jCpy, 'correctiveInvoiceId', false, path), true, [...path, ".correctiveInvoiceId"]),
			correctedInvoiceId: expectString(extractEntry(jCpy, 'correctedInvoiceId', false, path), true, [...path, ".correctedInvoiceId"]),
			creditNote: expectBoolean(extractEntry(jCpy, 'creditNote', false, path), true, [...path, ".creditNote"]),
			creditNoteRelatedInvoiceId: expectString(extractEntry(jCpy, 'creditNoteRelatedInvoiceId', false, path), true, [...path, ".creditNoteRelatedInvoiceId"]),
			idDocument: expectObject(extractEntry(jCpy, 'idDocument', false, path), true, ignoreUnknownKeys, [...path, ".idDocument"], IdentityDocumentReader.fromJSON),
			admissionDate: expectNumber(extractEntry(jCpy, 'admissionDate', false, path), true, true, [...path, ".admissionDate"]),
			locationService: expectNumber(extractEntry(jCpy, 'locationService', false, path), true, true, [...path, ".locationService"]),
			cancelReason: expectString(extractEntry(jCpy, 'cancelReason', false, path), true, [...path, ".cancelReason"]),
			cancelDate: expectNumber(extractEntry(jCpy, 'cancelDate', false, path), true, true, [...path, ".cancelDate"]),
			options: expectMap(
				extractEntry(jCpy, 'options', false, path),
				false,
				[...path, ".options"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			secretForeignKeys: expectArray(extractEntry(jCpy, 'secretForeignKeys', false, path), false, [...path, ".secretForeignKeys"], (x0, p0) => expectString(x0, false, p0)),
			cryptedForeignKeys: expectMap(
				extractEntry(jCpy, 'cryptedForeignKeys', false, path),
				false,
				[...path, ".cryptedForeignKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			delegations: expectMap(
				extractEntry(jCpy, 'delegations', false, path),
				false,
				[...path, ".delegations"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			encryptionKeys: expectMap(
				extractEntry(jCpy, 'encryptionKeys', false, path),
				false,
				[...path, ".encryptionKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => expectObject(x1, false, ignoreUnknownKeys, p1, Delegation.fromJSON))
			),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
			securityMetadata: expectObject(extractEntry(jCpy, 'securityMetadata', false, path), true, ignoreUnknownKeys, [...path, ".securityMetadata"], SecurityMetadata.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedInvoice at path ${path.join("")}: ${unused}`)}
		return res
	}

}

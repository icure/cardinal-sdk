// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectString, expectStringEnum, requireEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasEncryptionMetadata} from './base/HasEncryptionMetadata.mjs';
import {ICureDocument} from './base/ICureDocument.mjs';
import {Identifier} from './base/Identifier.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {Delegation} from './embed/Delegation.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {IdentityDocumentReader} from './embed/IdentityDocumentReader.mjs';
import {InvoiceInterventionType} from './embed/InvoiceInterventionType.mjs';
import {InvoiceType} from './embed/InvoiceType.mjs';
import {DecryptedInvoicingCode, EncryptedInvoicingCode, InvoicingCode} from './embed/InvoicingCode.mjs';
import {MediumType} from './embed/MediumType.mjs';
import {Payment} from './embed/Payment.mjs';
import {PaymentType} from './embed/PaymentType.mjs';
import {SecurityMetadata} from './embed/SecurityMetadata.mjs';
import {Base64String} from './specializations/Base64String.mjs';


export interface Invoice extends StoredDocument, ICureDocument<string>, HasEncryptionMetadata, Encryptable {

	identifier: Array<Identifier>;

	invoiceDate: number | undefined;

	sentDate: number | undefined;

	printedDate: number | undefined;

	invoicingCodes: Array<InvoicingCode>;

	receipts: { [ key: string ]: string };

	recipientType: string | undefined;

	recipientId: string | undefined;

	invoiceReference: string | undefined;

	decisionReference: string | undefined;

	thirdPartyReference: string | undefined;

	thirdPartyPaymentJustification: string | undefined;

	thirdPartyPaymentReason: string | undefined;

	reason: string | undefined;

	invoiceType: InvoiceType | undefined;

	sentMediumType: MediumType | undefined;

	interventionType: InvoiceInterventionType | undefined;

	groupId: string | undefined;

	paymentType: PaymentType | undefined;

	paid: number | undefined;

	payments: Array<Payment> | undefined;

	gnotionNihii: string | undefined;

	gnotionSsin: string | undefined;

	gnotionLastName: string | undefined;

	gnotionFirstName: string | undefined;

	gnotionCdHcParty: string | undefined;

	invoicePeriod: number | undefined;

	careProviderType: string | undefined;

	internshipNihii: string | undefined;

	internshipSsin: string | undefined;

	internshipLastName: string | undefined;

	internshipFirstName: string | undefined;

	internshipCdHcParty: string | undefined;

	internshipCbe: string | undefined;

	supervisorNihii: string | undefined;

	supervisorSsin: string | undefined;

	supervisorLastName: string | undefined;

	supervisorFirstName: string | undefined;

	supervisorCdHcParty: string | undefined;

	supervisorCbe: string | undefined;

	error: string | undefined;

	encounterLocationName: string | undefined;

	encounterLocationNihii: string | undefined;

	encounterLocationNorm: number | undefined;

	longDelayJustification: number | undefined;

	correctiveInvoiceId: string | undefined;

	correctedInvoiceId: string | undefined;

	creditNote: boolean | undefined;

	creditNoteRelatedInvoiceId: string | undefined;

	idDocument: IdentityDocumentReader | undefined;

	admissionDate: number | undefined;

	locationNihii: string | undefined;

	locationService: number | undefined;

	cancelReason: string | undefined;

	cancelDate: number | undefined;

	options: { [ key: string ]: string };

	readonly isEncrypted: boolean;

}

export class DecryptedInvoice {

	id: string;

	rev: string | undefined = undefined;

	identifier: Array<Identifier> = [];

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	invoiceDate: number | undefined = undefined;

	sentDate: number | undefined = undefined;

	printedDate: number | undefined = undefined;

	invoicingCodes: Array<DecryptedInvoicingCode> = [];

	receipts: { [ key: string ]: string } = {};

	recipientType: string | undefined = undefined;

	recipientId: string | undefined = undefined;

	invoiceReference: string | undefined = undefined;

	decisionReference: string | undefined = undefined;

	thirdPartyReference: string | undefined = undefined;

	thirdPartyPaymentJustification: string | undefined = undefined;

	thirdPartyPaymentReason: string | undefined = undefined;

	reason: string | undefined = undefined;

	invoiceType: InvoiceType | undefined = undefined;

	sentMediumType: MediumType | undefined = undefined;

	interventionType: InvoiceInterventionType | undefined = undefined;

	groupId: string | undefined = undefined;

	paymentType: PaymentType | undefined = undefined;

	paid: number | undefined = undefined;

	payments: Array<Payment> | undefined = undefined;

	gnotionNihii: string | undefined = undefined;

	gnotionSsin: string | undefined = undefined;

	gnotionLastName: string | undefined = undefined;

	gnotionFirstName: string | undefined = undefined;

	gnotionCdHcParty: string | undefined = undefined;

	invoicePeriod: number | undefined = undefined;

	careProviderType: string | undefined = undefined;

	internshipNihii: string | undefined = undefined;

	internshipSsin: string | undefined = undefined;

	internshipLastName: string | undefined = undefined;

	internshipFirstName: string | undefined = undefined;

	internshipCdHcParty: string | undefined = undefined;

	internshipCbe: string | undefined = undefined;

	supervisorNihii: string | undefined = undefined;

	supervisorSsin: string | undefined = undefined;

	supervisorLastName: string | undefined = undefined;

	supervisorFirstName: string | undefined = undefined;

	supervisorCdHcParty: string | undefined = undefined;

	supervisorCbe: string | undefined = undefined;

	error: string | undefined = undefined;

	encounterLocationName: string | undefined = undefined;

	encounterLocationNihii: string | undefined = undefined;

	encounterLocationNorm: number | undefined = undefined;

	longDelayJustification: number | undefined = undefined;

	correctiveInvoiceId: string | undefined = undefined;

	correctedInvoiceId: string | undefined = undefined;

	creditNote: boolean | undefined = undefined;

	creditNoteRelatedInvoiceId: string | undefined = undefined;

	idDocument: IdentityDocumentReader | undefined = undefined;

	admissionDate: number | undefined = undefined;

	locationNihii: string | undefined = undefined;

	locationService: number | undefined = undefined;

	cancelReason: string | undefined = undefined;

	cancelDate: number | undefined = undefined;

	options: { [ key: string ]: string } = {};

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

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
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('invoiceDate' in partial) this.invoiceDate = partial.invoiceDate;
		if ('sentDate' in partial) this.sentDate = partial.sentDate;
		if ('printedDate' in partial) this.printedDate = partial.printedDate;
		if ('invoicingCodes' in partial && partial.invoicingCodes !== undefined) this.invoicingCodes = partial.invoicingCodes;
		if ('receipts' in partial && partial.receipts !== undefined) this.receipts = partial.receipts;
		if ('recipientType' in partial) this.recipientType = partial.recipientType;
		if ('recipientId' in partial) this.recipientId = partial.recipientId;
		if ('invoiceReference' in partial) this.invoiceReference = partial.invoiceReference;
		if ('decisionReference' in partial) this.decisionReference = partial.decisionReference;
		if ('thirdPartyReference' in partial) this.thirdPartyReference = partial.thirdPartyReference;
		if ('thirdPartyPaymentJustification' in partial) this.thirdPartyPaymentJustification = partial.thirdPartyPaymentJustification;
		if ('thirdPartyPaymentReason' in partial) this.thirdPartyPaymentReason = partial.thirdPartyPaymentReason;
		if ('reason' in partial) this.reason = partial.reason;
		if ('invoiceType' in partial) this.invoiceType = partial.invoiceType;
		if ('sentMediumType' in partial) this.sentMediumType = partial.sentMediumType;
		if ('interventionType' in partial) this.interventionType = partial.interventionType;
		if ('groupId' in partial) this.groupId = partial.groupId;
		if ('paymentType' in partial) this.paymentType = partial.paymentType;
		if ('paid' in partial) this.paid = partial.paid;
		if ('payments' in partial) this.payments = partial.payments;
		if ('gnotionNihii' in partial) this.gnotionNihii = partial.gnotionNihii;
		if ('gnotionSsin' in partial) this.gnotionSsin = partial.gnotionSsin;
		if ('gnotionLastName' in partial) this.gnotionLastName = partial.gnotionLastName;
		if ('gnotionFirstName' in partial) this.gnotionFirstName = partial.gnotionFirstName;
		if ('gnotionCdHcParty' in partial) this.gnotionCdHcParty = partial.gnotionCdHcParty;
		if ('invoicePeriod' in partial) this.invoicePeriod = partial.invoicePeriod;
		if ('careProviderType' in partial) this.careProviderType = partial.careProviderType;
		if ('internshipNihii' in partial) this.internshipNihii = partial.internshipNihii;
		if ('internshipSsin' in partial) this.internshipSsin = partial.internshipSsin;
		if ('internshipLastName' in partial) this.internshipLastName = partial.internshipLastName;
		if ('internshipFirstName' in partial) this.internshipFirstName = partial.internshipFirstName;
		if ('internshipCdHcParty' in partial) this.internshipCdHcParty = partial.internshipCdHcParty;
		if ('internshipCbe' in partial) this.internshipCbe = partial.internshipCbe;
		if ('supervisorNihii' in partial) this.supervisorNihii = partial.supervisorNihii;
		if ('supervisorSsin' in partial) this.supervisorSsin = partial.supervisorSsin;
		if ('supervisorLastName' in partial) this.supervisorLastName = partial.supervisorLastName;
		if ('supervisorFirstName' in partial) this.supervisorFirstName = partial.supervisorFirstName;
		if ('supervisorCdHcParty' in partial) this.supervisorCdHcParty = partial.supervisorCdHcParty;
		if ('supervisorCbe' in partial) this.supervisorCbe = partial.supervisorCbe;
		if ('error' in partial) this.error = partial.error;
		if ('encounterLocationName' in partial) this.encounterLocationName = partial.encounterLocationName;
		if ('encounterLocationNihii' in partial) this.encounterLocationNihii = partial.encounterLocationNihii;
		if ('encounterLocationNorm' in partial) this.encounterLocationNorm = partial.encounterLocationNorm;
		if ('longDelayJustification' in partial) this.longDelayJustification = partial.longDelayJustification;
		if ('correctiveInvoiceId' in partial) this.correctiveInvoiceId = partial.correctiveInvoiceId;
		if ('correctedInvoiceId' in partial) this.correctedInvoiceId = partial.correctedInvoiceId;
		if ('creditNote' in partial) this.creditNote = partial.creditNote;
		if ('creditNoteRelatedInvoiceId' in partial) this.creditNoteRelatedInvoiceId = partial.creditNoteRelatedInvoiceId;
		if ('idDocument' in partial) this.idDocument = partial.idDocument;
		if ('admissionDate' in partial) this.admissionDate = partial.admissionDate;
		if ('locationNihii' in partial) this.locationNihii = partial.locationNihii;
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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		res['identifier'] = this.identifier.map((x0) => x0.toJSON() )
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		if (this.medicalLocationId != undefined) res['medicalLocationId'] = this.medicalLocationId
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.invoiceDate != undefined) res['invoiceDate'] = this.invoiceDate
		if (this.sentDate != undefined) res['sentDate'] = this.sentDate
		if (this.printedDate != undefined) res['printedDate'] = this.printedDate
		res['invoicingCodes'] = this.invoicingCodes.map((x0) => x0.toJSON() )
		res['receipts'] = Object.fromEntries(Object.entries(this.receipts).map(([k0, v0]) => [k0, v0]))
		if (this.recipientType != undefined) res['recipientType'] = this.recipientType
		if (this.recipientId != undefined) res['recipientId'] = this.recipientId
		if (this.invoiceReference != undefined) res['invoiceReference'] = this.invoiceReference
		if (this.decisionReference != undefined) res['decisionReference'] = this.decisionReference
		if (this.thirdPartyReference != undefined) res['thirdPartyReference'] = this.thirdPartyReference
		if (this.thirdPartyPaymentJustification != undefined) res['thirdPartyPaymentJustification'] = this.thirdPartyPaymentJustification
		if (this.thirdPartyPaymentReason != undefined) res['thirdPartyPaymentReason'] = this.thirdPartyPaymentReason
		if (this.reason != undefined) res['reason'] = this.reason
		if (this.invoiceType != undefined) res['invoiceType'] = this.invoiceType
		if (this.sentMediumType != undefined) res['sentMediumType'] = this.sentMediumType
		if (this.interventionType != undefined) res['interventionType'] = this.interventionType
		if (this.groupId != undefined) res['groupId'] = this.groupId
		if (this.paymentType != undefined) res['paymentType'] = this.paymentType
		if (this.paid != undefined) res['paid'] = this.paid
		if (this.payments != undefined) res['payments'] = this.payments.map((x0) => x0.toJSON() )
		if (this.gnotionNihii != undefined) res['gnotionNihii'] = this.gnotionNihii
		if (this.gnotionSsin != undefined) res['gnotionSsin'] = this.gnotionSsin
		if (this.gnotionLastName != undefined) res['gnotionLastName'] = this.gnotionLastName
		if (this.gnotionFirstName != undefined) res['gnotionFirstName'] = this.gnotionFirstName
		if (this.gnotionCdHcParty != undefined) res['gnotionCdHcParty'] = this.gnotionCdHcParty
		if (this.invoicePeriod != undefined) res['invoicePeriod'] = this.invoicePeriod
		if (this.careProviderType != undefined) res['careProviderType'] = this.careProviderType
		if (this.internshipNihii != undefined) res['internshipNihii'] = this.internshipNihii
		if (this.internshipSsin != undefined) res['internshipSsin'] = this.internshipSsin
		if (this.internshipLastName != undefined) res['internshipLastName'] = this.internshipLastName
		if (this.internshipFirstName != undefined) res['internshipFirstName'] = this.internshipFirstName
		if (this.internshipCdHcParty != undefined) res['internshipCdHcParty'] = this.internshipCdHcParty
		if (this.internshipCbe != undefined) res['internshipCbe'] = this.internshipCbe
		if (this.supervisorNihii != undefined) res['supervisorNihii'] = this.supervisorNihii
		if (this.supervisorSsin != undefined) res['supervisorSsin'] = this.supervisorSsin
		if (this.supervisorLastName != undefined) res['supervisorLastName'] = this.supervisorLastName
		if (this.supervisorFirstName != undefined) res['supervisorFirstName'] = this.supervisorFirstName
		if (this.supervisorCdHcParty != undefined) res['supervisorCdHcParty'] = this.supervisorCdHcParty
		if (this.supervisorCbe != undefined) res['supervisorCbe'] = this.supervisorCbe
		if (this.error != undefined) res['error'] = this.error
		if (this.encounterLocationName != undefined) res['encounterLocationName'] = this.encounterLocationName
		if (this.encounterLocationNihii != undefined) res['encounterLocationNihii'] = this.encounterLocationNihii
		if (this.encounterLocationNorm != undefined) res['encounterLocationNorm'] = this.encounterLocationNorm
		if (this.longDelayJustification != undefined) res['longDelayJustification'] = this.longDelayJustification
		if (this.correctiveInvoiceId != undefined) res['correctiveInvoiceId'] = this.correctiveInvoiceId
		if (this.correctedInvoiceId != undefined) res['correctedInvoiceId'] = this.correctedInvoiceId
		if (this.creditNote != undefined) res['creditNote'] = this.creditNote
		if (this.creditNoteRelatedInvoiceId != undefined) res['creditNoteRelatedInvoiceId'] = this.creditNoteRelatedInvoiceId
		if (this.idDocument != undefined) res['idDocument'] = this.idDocument.toJSON()
		if (this.admissionDate != undefined) res['admissionDate'] = this.admissionDate
		if (this.locationNihii != undefined) res['locationNihii'] = this.locationNihii
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
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['DecryptedInvoice']): DecryptedInvoice {
		return new DecryptedInvoice({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			identifier: expectArray(json.identifier, false, [...path, ".identifier"], (x0, p0) => Identifier.fromJSON(x0, p0)),
			created: expectNumber(json.created, true, true, [...path, ".created"]),
			modified: expectNumber(json.modified, true, true, [...path, ".modified"]),
			author: expectString(json.author, true, [...path, ".author"]),
			responsible: expectString(json.responsible, true, [...path, ".responsible"]),
			medicalLocationId: expectString(json.medicalLocationId, true, [...path, ".medicalLocationId"]),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			endOfLife: expectNumber(json.endOfLife, true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			invoiceDate: expectNumber(json.invoiceDate, true, true, [...path, ".invoiceDate"]),
			sentDate: expectNumber(json.sentDate, true, true, [...path, ".sentDate"]),
			printedDate: expectNumber(json.printedDate, true, true, [...path, ".printedDate"]),
			invoicingCodes: expectArray(json.invoicingCodes, false, [...path, ".invoicingCodes"], (x0, p0) => DecryptedInvoicingCode.fromJSON(x0, p0)),
			receipts: expectMap(
				json.receipts,
				false,
				[...path, ".receipts"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			recipientType: expectString(json.recipientType, true, [...path, ".recipientType"]),
			recipientId: expectString(json.recipientId, true, [...path, ".recipientId"]),
			invoiceReference: expectString(json.invoiceReference, true, [...path, ".invoiceReference"]),
			decisionReference: expectString(json.decisionReference, true, [...path, ".decisionReference"]),
			thirdPartyReference: expectString(json.thirdPartyReference, true, [...path, ".thirdPartyReference"]),
			thirdPartyPaymentJustification: expectString(json.thirdPartyPaymentJustification, true, [...path, ".thirdPartyPaymentJustification"]),
			thirdPartyPaymentReason: expectString(json.thirdPartyPaymentReason, true, [...path, ".thirdPartyPaymentReason"]),
			reason: expectString(json.reason, true, [...path, ".reason"]),
			invoiceType: expectStringEnum(json.invoiceType, true, [...path, ".invoiceType"], InvoiceType, 'InvoiceType'),
			sentMediumType: expectStringEnum(json.sentMediumType, true, [...path, ".sentMediumType"], MediumType, 'MediumType'),
			interventionType: expectStringEnum(json.interventionType, true, [...path, ".interventionType"], InvoiceInterventionType, 'InvoiceInterventionType'),
			groupId: expectString(json.groupId, true, [...path, ".groupId"]),
			paymentType: expectStringEnum(json.paymentType, true, [...path, ".paymentType"], PaymentType, 'PaymentType'),
			paid: expectNumber(json.paid, true, false, [...path, ".paid"]),
			payments: expectArray(json.payments, true, [...path, ".payments"], (x0, p0) => Payment.fromJSON(x0, p0)),
			gnotionNihii: expectString(json.gnotionNihii, true, [...path, ".gnotionNihii"]),
			gnotionSsin: expectString(json.gnotionSsin, true, [...path, ".gnotionSsin"]),
			gnotionLastName: expectString(json.gnotionLastName, true, [...path, ".gnotionLastName"]),
			gnotionFirstName: expectString(json.gnotionFirstName, true, [...path, ".gnotionFirstName"]),
			gnotionCdHcParty: expectString(json.gnotionCdHcParty, true, [...path, ".gnotionCdHcParty"]),
			invoicePeriod: expectNumber(json.invoicePeriod, true, true, [...path, ".invoicePeriod"]),
			careProviderType: expectString(json.careProviderType, true, [...path, ".careProviderType"]),
			internshipNihii: expectString(json.internshipNihii, true, [...path, ".internshipNihii"]),
			internshipSsin: expectString(json.internshipSsin, true, [...path, ".internshipSsin"]),
			internshipLastName: expectString(json.internshipLastName, true, [...path, ".internshipLastName"]),
			internshipFirstName: expectString(json.internshipFirstName, true, [...path, ".internshipFirstName"]),
			internshipCdHcParty: expectString(json.internshipCdHcParty, true, [...path, ".internshipCdHcParty"]),
			internshipCbe: expectString(json.internshipCbe, true, [...path, ".internshipCbe"]),
			supervisorNihii: expectString(json.supervisorNihii, true, [...path, ".supervisorNihii"]),
			supervisorSsin: expectString(json.supervisorSsin, true, [...path, ".supervisorSsin"]),
			supervisorLastName: expectString(json.supervisorLastName, true, [...path, ".supervisorLastName"]),
			supervisorFirstName: expectString(json.supervisorFirstName, true, [...path, ".supervisorFirstName"]),
			supervisorCdHcParty: expectString(json.supervisorCdHcParty, true, [...path, ".supervisorCdHcParty"]),
			supervisorCbe: expectString(json.supervisorCbe, true, [...path, ".supervisorCbe"]),
			error: expectString(json.error, true, [...path, ".error"]),
			encounterLocationName: expectString(json.encounterLocationName, true, [...path, ".encounterLocationName"]),
			encounterLocationNihii: expectString(json.encounterLocationNihii, true, [...path, ".encounterLocationNihii"]),
			encounterLocationNorm: expectNumber(json.encounterLocationNorm, true, true, [...path, ".encounterLocationNorm"]),
			longDelayJustification: expectNumber(json.longDelayJustification, true, true, [...path, ".longDelayJustification"]),
			correctiveInvoiceId: expectString(json.correctiveInvoiceId, true, [...path, ".correctiveInvoiceId"]),
			correctedInvoiceId: expectString(json.correctedInvoiceId, true, [...path, ".correctedInvoiceId"]),
			creditNote: expectBoolean(json.creditNote, true, [...path, ".creditNote"]),
			creditNoteRelatedInvoiceId: expectString(json.creditNoteRelatedInvoiceId, true, [...path, ".creditNoteRelatedInvoiceId"]),
			idDocument: IdentityDocumentReader.fromJSON(json.idDocument, [...path, ".idDocument"]),
			admissionDate: expectNumber(json.admissionDate, true, true, [...path, ".admissionDate"]),
			locationNihii: expectString(json.locationNihii, true, [...path, ".locationNihii"]),
			locationService: expectNumber(json.locationService, true, true, [...path, ".locationService"]),
			cancelReason: expectString(json.cancelReason, true, [...path, ".cancelReason"]),
			cancelDate: expectNumber(json.cancelDate, true, true, [...path, ".cancelDate"]),
			options: expectMap(
				json.options,
				false,
				[...path, ".options"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			secretForeignKeys: expectArray(json.secretForeignKeys, false, [...path, ".secretForeignKeys"], (x0, p0) => expectString(x0, false, p0)),
			cryptedForeignKeys: expectMap(
				json.cryptedForeignKeys,
				false,
				[...path, ".cryptedForeignKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			delegations: expectMap(
				json.delegations,
				false,
				[...path, ".delegations"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			encryptionKeys: expectMap(
				json.encryptionKeys,
				false,
				[...path, ".encryptionKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
			securityMetadata: SecurityMetadata.fromJSON(json.securityMetadata, [...path, ".securityMetadata"]),
		})
	}

}

export class EncryptedInvoice {

	id: string;

	rev: string | undefined = undefined;

	identifier: Array<Identifier> = [];

	created: number | undefined = undefined;

	modified: number | undefined = undefined;

	author: string | undefined = undefined;

	responsible: string | undefined = undefined;

	medicalLocationId: string | undefined = undefined;

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	endOfLife: number | undefined = undefined;

	deletionDate: number | undefined = undefined;

	invoiceDate: number | undefined = undefined;

	sentDate: number | undefined = undefined;

	printedDate: number | undefined = undefined;

	invoicingCodes: Array<EncryptedInvoicingCode> = [];

	receipts: { [ key: string ]: string } = {};

	recipientType: string | undefined = undefined;

	recipientId: string | undefined = undefined;

	invoiceReference: string | undefined = undefined;

	decisionReference: string | undefined = undefined;

	thirdPartyReference: string | undefined = undefined;

	thirdPartyPaymentJustification: string | undefined = undefined;

	thirdPartyPaymentReason: string | undefined = undefined;

	reason: string | undefined = undefined;

	invoiceType: InvoiceType | undefined = undefined;

	sentMediumType: MediumType | undefined = undefined;

	interventionType: InvoiceInterventionType | undefined = undefined;

	groupId: string | undefined = undefined;

	paymentType: PaymentType | undefined = undefined;

	paid: number | undefined = undefined;

	payments: Array<Payment> | undefined = undefined;

	gnotionNihii: string | undefined = undefined;

	gnotionSsin: string | undefined = undefined;

	gnotionLastName: string | undefined = undefined;

	gnotionFirstName: string | undefined = undefined;

	gnotionCdHcParty: string | undefined = undefined;

	invoicePeriod: number | undefined = undefined;

	careProviderType: string | undefined = undefined;

	internshipNihii: string | undefined = undefined;

	internshipSsin: string | undefined = undefined;

	internshipLastName: string | undefined = undefined;

	internshipFirstName: string | undefined = undefined;

	internshipCdHcParty: string | undefined = undefined;

	internshipCbe: string | undefined = undefined;

	supervisorNihii: string | undefined = undefined;

	supervisorSsin: string | undefined = undefined;

	supervisorLastName: string | undefined = undefined;

	supervisorFirstName: string | undefined = undefined;

	supervisorCdHcParty: string | undefined = undefined;

	supervisorCbe: string | undefined = undefined;

	error: string | undefined = undefined;

	encounterLocationName: string | undefined = undefined;

	encounterLocationNihii: string | undefined = undefined;

	encounterLocationNorm: number | undefined = undefined;

	longDelayJustification: number | undefined = undefined;

	correctiveInvoiceId: string | undefined = undefined;

	correctedInvoiceId: string | undefined = undefined;

	creditNote: boolean | undefined = undefined;

	creditNoteRelatedInvoiceId: string | undefined = undefined;

	idDocument: IdentityDocumentReader | undefined = undefined;

	admissionDate: number | undefined = undefined;

	locationNihii: string | undefined = undefined;

	locationService: number | undefined = undefined;

	cancelReason: string | undefined = undefined;

	cancelDate: number | undefined = undefined;

	options: { [ key: string ]: string } = {};

	secretForeignKeys: Array<string> = [];

	cryptedForeignKeys: { [ key: string ]: Array<Delegation> } = {};

	delegations: { [ key: string ]: Array<Delegation> } = {};

	encryptionKeys: { [ key: string ]: Array<Delegation> } = {};

	encryptedSelf: Base64String | undefined = undefined;

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
		if ('medicalLocationId' in partial) this.medicalLocationId = partial.medicalLocationId;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('endOfLife' in partial) this.endOfLife = partial.endOfLife;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('invoiceDate' in partial) this.invoiceDate = partial.invoiceDate;
		if ('sentDate' in partial) this.sentDate = partial.sentDate;
		if ('printedDate' in partial) this.printedDate = partial.printedDate;
		if ('invoicingCodes' in partial && partial.invoicingCodes !== undefined) this.invoicingCodes = partial.invoicingCodes;
		if ('receipts' in partial && partial.receipts !== undefined) this.receipts = partial.receipts;
		if ('recipientType' in partial) this.recipientType = partial.recipientType;
		if ('recipientId' in partial) this.recipientId = partial.recipientId;
		if ('invoiceReference' in partial) this.invoiceReference = partial.invoiceReference;
		if ('decisionReference' in partial) this.decisionReference = partial.decisionReference;
		if ('thirdPartyReference' in partial) this.thirdPartyReference = partial.thirdPartyReference;
		if ('thirdPartyPaymentJustification' in partial) this.thirdPartyPaymentJustification = partial.thirdPartyPaymentJustification;
		if ('thirdPartyPaymentReason' in partial) this.thirdPartyPaymentReason = partial.thirdPartyPaymentReason;
		if ('reason' in partial) this.reason = partial.reason;
		if ('invoiceType' in partial) this.invoiceType = partial.invoiceType;
		if ('sentMediumType' in partial) this.sentMediumType = partial.sentMediumType;
		if ('interventionType' in partial) this.interventionType = partial.interventionType;
		if ('groupId' in partial) this.groupId = partial.groupId;
		if ('paymentType' in partial) this.paymentType = partial.paymentType;
		if ('paid' in partial) this.paid = partial.paid;
		if ('payments' in partial) this.payments = partial.payments;
		if ('gnotionNihii' in partial) this.gnotionNihii = partial.gnotionNihii;
		if ('gnotionSsin' in partial) this.gnotionSsin = partial.gnotionSsin;
		if ('gnotionLastName' in partial) this.gnotionLastName = partial.gnotionLastName;
		if ('gnotionFirstName' in partial) this.gnotionFirstName = partial.gnotionFirstName;
		if ('gnotionCdHcParty' in partial) this.gnotionCdHcParty = partial.gnotionCdHcParty;
		if ('invoicePeriod' in partial) this.invoicePeriod = partial.invoicePeriod;
		if ('careProviderType' in partial) this.careProviderType = partial.careProviderType;
		if ('internshipNihii' in partial) this.internshipNihii = partial.internshipNihii;
		if ('internshipSsin' in partial) this.internshipSsin = partial.internshipSsin;
		if ('internshipLastName' in partial) this.internshipLastName = partial.internshipLastName;
		if ('internshipFirstName' in partial) this.internshipFirstName = partial.internshipFirstName;
		if ('internshipCdHcParty' in partial) this.internshipCdHcParty = partial.internshipCdHcParty;
		if ('internshipCbe' in partial) this.internshipCbe = partial.internshipCbe;
		if ('supervisorNihii' in partial) this.supervisorNihii = partial.supervisorNihii;
		if ('supervisorSsin' in partial) this.supervisorSsin = partial.supervisorSsin;
		if ('supervisorLastName' in partial) this.supervisorLastName = partial.supervisorLastName;
		if ('supervisorFirstName' in partial) this.supervisorFirstName = partial.supervisorFirstName;
		if ('supervisorCdHcParty' in partial) this.supervisorCdHcParty = partial.supervisorCdHcParty;
		if ('supervisorCbe' in partial) this.supervisorCbe = partial.supervisorCbe;
		if ('error' in partial) this.error = partial.error;
		if ('encounterLocationName' in partial) this.encounterLocationName = partial.encounterLocationName;
		if ('encounterLocationNihii' in partial) this.encounterLocationNihii = partial.encounterLocationNihii;
		if ('encounterLocationNorm' in partial) this.encounterLocationNorm = partial.encounterLocationNorm;
		if ('longDelayJustification' in partial) this.longDelayJustification = partial.longDelayJustification;
		if ('correctiveInvoiceId' in partial) this.correctiveInvoiceId = partial.correctiveInvoiceId;
		if ('correctedInvoiceId' in partial) this.correctedInvoiceId = partial.correctedInvoiceId;
		if ('creditNote' in partial) this.creditNote = partial.creditNote;
		if ('creditNoteRelatedInvoiceId' in partial) this.creditNoteRelatedInvoiceId = partial.creditNoteRelatedInvoiceId;
		if ('idDocument' in partial) this.idDocument = partial.idDocument;
		if ('admissionDate' in partial) this.admissionDate = partial.admissionDate;
		if ('locationNihii' in partial) this.locationNihii = partial.locationNihii;
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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		res['identifier'] = this.identifier.map((x0) => x0.toJSON() )
		if (this.created != undefined) res['created'] = this.created
		if (this.modified != undefined) res['modified'] = this.modified
		if (this.author != undefined) res['author'] = this.author
		if (this.responsible != undefined) res['responsible'] = this.responsible
		if (this.medicalLocationId != undefined) res['medicalLocationId'] = this.medicalLocationId
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.endOfLife != undefined) res['endOfLife'] = this.endOfLife
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.invoiceDate != undefined) res['invoiceDate'] = this.invoiceDate
		if (this.sentDate != undefined) res['sentDate'] = this.sentDate
		if (this.printedDate != undefined) res['printedDate'] = this.printedDate
		res['invoicingCodes'] = this.invoicingCodes.map((x0) => x0.toJSON() )
		res['receipts'] = Object.fromEntries(Object.entries(this.receipts).map(([k0, v0]) => [k0, v0]))
		if (this.recipientType != undefined) res['recipientType'] = this.recipientType
		if (this.recipientId != undefined) res['recipientId'] = this.recipientId
		if (this.invoiceReference != undefined) res['invoiceReference'] = this.invoiceReference
		if (this.decisionReference != undefined) res['decisionReference'] = this.decisionReference
		if (this.thirdPartyReference != undefined) res['thirdPartyReference'] = this.thirdPartyReference
		if (this.thirdPartyPaymentJustification != undefined) res['thirdPartyPaymentJustification'] = this.thirdPartyPaymentJustification
		if (this.thirdPartyPaymentReason != undefined) res['thirdPartyPaymentReason'] = this.thirdPartyPaymentReason
		if (this.reason != undefined) res['reason'] = this.reason
		if (this.invoiceType != undefined) res['invoiceType'] = this.invoiceType
		if (this.sentMediumType != undefined) res['sentMediumType'] = this.sentMediumType
		if (this.interventionType != undefined) res['interventionType'] = this.interventionType
		if (this.groupId != undefined) res['groupId'] = this.groupId
		if (this.paymentType != undefined) res['paymentType'] = this.paymentType
		if (this.paid != undefined) res['paid'] = this.paid
		if (this.payments != undefined) res['payments'] = this.payments.map((x0) => x0.toJSON() )
		if (this.gnotionNihii != undefined) res['gnotionNihii'] = this.gnotionNihii
		if (this.gnotionSsin != undefined) res['gnotionSsin'] = this.gnotionSsin
		if (this.gnotionLastName != undefined) res['gnotionLastName'] = this.gnotionLastName
		if (this.gnotionFirstName != undefined) res['gnotionFirstName'] = this.gnotionFirstName
		if (this.gnotionCdHcParty != undefined) res['gnotionCdHcParty'] = this.gnotionCdHcParty
		if (this.invoicePeriod != undefined) res['invoicePeriod'] = this.invoicePeriod
		if (this.careProviderType != undefined) res['careProviderType'] = this.careProviderType
		if (this.internshipNihii != undefined) res['internshipNihii'] = this.internshipNihii
		if (this.internshipSsin != undefined) res['internshipSsin'] = this.internshipSsin
		if (this.internshipLastName != undefined) res['internshipLastName'] = this.internshipLastName
		if (this.internshipFirstName != undefined) res['internshipFirstName'] = this.internshipFirstName
		if (this.internshipCdHcParty != undefined) res['internshipCdHcParty'] = this.internshipCdHcParty
		if (this.internshipCbe != undefined) res['internshipCbe'] = this.internshipCbe
		if (this.supervisorNihii != undefined) res['supervisorNihii'] = this.supervisorNihii
		if (this.supervisorSsin != undefined) res['supervisorSsin'] = this.supervisorSsin
		if (this.supervisorLastName != undefined) res['supervisorLastName'] = this.supervisorLastName
		if (this.supervisorFirstName != undefined) res['supervisorFirstName'] = this.supervisorFirstName
		if (this.supervisorCdHcParty != undefined) res['supervisorCdHcParty'] = this.supervisorCdHcParty
		if (this.supervisorCbe != undefined) res['supervisorCbe'] = this.supervisorCbe
		if (this.error != undefined) res['error'] = this.error
		if (this.encounterLocationName != undefined) res['encounterLocationName'] = this.encounterLocationName
		if (this.encounterLocationNihii != undefined) res['encounterLocationNihii'] = this.encounterLocationNihii
		if (this.encounterLocationNorm != undefined) res['encounterLocationNorm'] = this.encounterLocationNorm
		if (this.longDelayJustification != undefined) res['longDelayJustification'] = this.longDelayJustification
		if (this.correctiveInvoiceId != undefined) res['correctiveInvoiceId'] = this.correctiveInvoiceId
		if (this.correctedInvoiceId != undefined) res['correctedInvoiceId'] = this.correctedInvoiceId
		if (this.creditNote != undefined) res['creditNote'] = this.creditNote
		if (this.creditNoteRelatedInvoiceId != undefined) res['creditNoteRelatedInvoiceId'] = this.creditNoteRelatedInvoiceId
		if (this.idDocument != undefined) res['idDocument'] = this.idDocument.toJSON()
		if (this.admissionDate != undefined) res['admissionDate'] = this.admissionDate
		if (this.locationNihii != undefined) res['locationNihii'] = this.locationNihii
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
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['EncryptedInvoice']): EncryptedInvoice {
		return new EncryptedInvoice({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			identifier: expectArray(json.identifier, false, [...path, ".identifier"], (x0, p0) => Identifier.fromJSON(x0, p0)),
			created: expectNumber(json.created, true, true, [...path, ".created"]),
			modified: expectNumber(json.modified, true, true, [...path, ".modified"]),
			author: expectString(json.author, true, [...path, ".author"]),
			responsible: expectString(json.responsible, true, [...path, ".responsible"]),
			medicalLocationId: expectString(json.medicalLocationId, true, [...path, ".medicalLocationId"]),
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			endOfLife: expectNumber(json.endOfLife, true, true, [...path, ".endOfLife"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			invoiceDate: expectNumber(json.invoiceDate, true, true, [...path, ".invoiceDate"]),
			sentDate: expectNumber(json.sentDate, true, true, [...path, ".sentDate"]),
			printedDate: expectNumber(json.printedDate, true, true, [...path, ".printedDate"]),
			invoicingCodes: expectArray(json.invoicingCodes, false, [...path, ".invoicingCodes"], (x0, p0) => EncryptedInvoicingCode.fromJSON(x0, p0)),
			receipts: expectMap(
				json.receipts,
				false,
				[...path, ".receipts"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			recipientType: expectString(json.recipientType, true, [...path, ".recipientType"]),
			recipientId: expectString(json.recipientId, true, [...path, ".recipientId"]),
			invoiceReference: expectString(json.invoiceReference, true, [...path, ".invoiceReference"]),
			decisionReference: expectString(json.decisionReference, true, [...path, ".decisionReference"]),
			thirdPartyReference: expectString(json.thirdPartyReference, true, [...path, ".thirdPartyReference"]),
			thirdPartyPaymentJustification: expectString(json.thirdPartyPaymentJustification, true, [...path, ".thirdPartyPaymentJustification"]),
			thirdPartyPaymentReason: expectString(json.thirdPartyPaymentReason, true, [...path, ".thirdPartyPaymentReason"]),
			reason: expectString(json.reason, true, [...path, ".reason"]),
			invoiceType: expectStringEnum(json.invoiceType, true, [...path, ".invoiceType"], InvoiceType, 'InvoiceType'),
			sentMediumType: expectStringEnum(json.sentMediumType, true, [...path, ".sentMediumType"], MediumType, 'MediumType'),
			interventionType: expectStringEnum(json.interventionType, true, [...path, ".interventionType"], InvoiceInterventionType, 'InvoiceInterventionType'),
			groupId: expectString(json.groupId, true, [...path, ".groupId"]),
			paymentType: expectStringEnum(json.paymentType, true, [...path, ".paymentType"], PaymentType, 'PaymentType'),
			paid: expectNumber(json.paid, true, false, [...path, ".paid"]),
			payments: expectArray(json.payments, true, [...path, ".payments"], (x0, p0) => Payment.fromJSON(x0, p0)),
			gnotionNihii: expectString(json.gnotionNihii, true, [...path, ".gnotionNihii"]),
			gnotionSsin: expectString(json.gnotionSsin, true, [...path, ".gnotionSsin"]),
			gnotionLastName: expectString(json.gnotionLastName, true, [...path, ".gnotionLastName"]),
			gnotionFirstName: expectString(json.gnotionFirstName, true, [...path, ".gnotionFirstName"]),
			gnotionCdHcParty: expectString(json.gnotionCdHcParty, true, [...path, ".gnotionCdHcParty"]),
			invoicePeriod: expectNumber(json.invoicePeriod, true, true, [...path, ".invoicePeriod"]),
			careProviderType: expectString(json.careProviderType, true, [...path, ".careProviderType"]),
			internshipNihii: expectString(json.internshipNihii, true, [...path, ".internshipNihii"]),
			internshipSsin: expectString(json.internshipSsin, true, [...path, ".internshipSsin"]),
			internshipLastName: expectString(json.internshipLastName, true, [...path, ".internshipLastName"]),
			internshipFirstName: expectString(json.internshipFirstName, true, [...path, ".internshipFirstName"]),
			internshipCdHcParty: expectString(json.internshipCdHcParty, true, [...path, ".internshipCdHcParty"]),
			internshipCbe: expectString(json.internshipCbe, true, [...path, ".internshipCbe"]),
			supervisorNihii: expectString(json.supervisorNihii, true, [...path, ".supervisorNihii"]),
			supervisorSsin: expectString(json.supervisorSsin, true, [...path, ".supervisorSsin"]),
			supervisorLastName: expectString(json.supervisorLastName, true, [...path, ".supervisorLastName"]),
			supervisorFirstName: expectString(json.supervisorFirstName, true, [...path, ".supervisorFirstName"]),
			supervisorCdHcParty: expectString(json.supervisorCdHcParty, true, [...path, ".supervisorCdHcParty"]),
			supervisorCbe: expectString(json.supervisorCbe, true, [...path, ".supervisorCbe"]),
			error: expectString(json.error, true, [...path, ".error"]),
			encounterLocationName: expectString(json.encounterLocationName, true, [...path, ".encounterLocationName"]),
			encounterLocationNihii: expectString(json.encounterLocationNihii, true, [...path, ".encounterLocationNihii"]),
			encounterLocationNorm: expectNumber(json.encounterLocationNorm, true, true, [...path, ".encounterLocationNorm"]),
			longDelayJustification: expectNumber(json.longDelayJustification, true, true, [...path, ".longDelayJustification"]),
			correctiveInvoiceId: expectString(json.correctiveInvoiceId, true, [...path, ".correctiveInvoiceId"]),
			correctedInvoiceId: expectString(json.correctedInvoiceId, true, [...path, ".correctedInvoiceId"]),
			creditNote: expectBoolean(json.creditNote, true, [...path, ".creditNote"]),
			creditNoteRelatedInvoiceId: expectString(json.creditNoteRelatedInvoiceId, true, [...path, ".creditNoteRelatedInvoiceId"]),
			idDocument: IdentityDocumentReader.fromJSON(json.idDocument, [...path, ".idDocument"]),
			admissionDate: expectNumber(json.admissionDate, true, true, [...path, ".admissionDate"]),
			locationNihii: expectString(json.locationNihii, true, [...path, ".locationNihii"]),
			locationService: expectNumber(json.locationService, true, true, [...path, ".locationService"]),
			cancelReason: expectString(json.cancelReason, true, [...path, ".cancelReason"]),
			cancelDate: expectNumber(json.cancelDate, true, true, [...path, ".cancelDate"]),
			options: expectMap(
				json.options,
				false,
				[...path, ".options"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			secretForeignKeys: expectArray(json.secretForeignKeys, false, [...path, ".secretForeignKeys"], (x0, p0) => expectString(x0, false, p0)),
			cryptedForeignKeys: expectMap(
				json.cryptedForeignKeys,
				false,
				[...path, ".cryptedForeignKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			delegations: expectMap(
				json.delegations,
				false,
				[...path, ".delegations"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			encryptionKeys: expectMap(
				json.encryptionKeys,
				false,
				[...path, ".encryptionKeys"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectArray(v0, false, p0, (x1, p1) => Delegation.fromJSON(x1, p1))
			),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
			securityMetadata: SecurityMetadata.fromJSON(json.securityMetadata, [...path, ".securityMetadata"]),
		})
	}

}

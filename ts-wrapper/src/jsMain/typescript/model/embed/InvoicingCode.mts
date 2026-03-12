// auto-generated file
import {expectBoolean, expectMap, expectNumber, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';
import {PaymentType} from './PaymentType.mjs';


/**
 *
 *  Represents an invoicing code within an invoice, containing tarification details, amounts,
 *  prescriber information,
 *  and lifecycle status flags. Each invoicing code corresponds to a billable medical act or service.
 *  /
 */
export interface InvoicingCode extends Encryptable {

	/**
	 *
	 *  The unique identifier of this invoicing code.
	 */
	id: string | undefined;

	/**
	 *
	 *  The date of the invoicing code as a long (yyyyMMdd format).
	 */
	dateCode: number | undefined;

	/**
	 *
	 *  A logical identifier that remains stable when a code is resent to the insuring organization.
	 */
	logicalId: string | undefined;

	/**
	 *
	 *  The label of the invoicing code.
	 */
	label: string | undefined;

	/**
	 *
	 *  The identifier of the user who created this invoicing code.
	 */
	userId: string | undefined;

	/**
	 *
	 *  The identifier of the associated contact.
	 */
	contactId: string | undefined;

	/**
	 *
	 *  The identifier of the associated service.
	 */
	serviceId: string | undefined;

	/**
	 *
	 *  The identifier of the associated tarification.
	 */
	pricingId: string | undefined;

	/**
	 *
	 *  The code value, for obsolete codes or codes not linked to a tarification.
	 */
	code: string | undefined;

	/**
	 *
	 *  The type of payment.
	 */
	paymentType: PaymentType | undefined;

	/**
	 *
	 *  The amount already paid.
	 */
	paid: number | undefined;

	/**
	 *
	 *  The total amount (reimbursement + doctor supplement + intervention).
	 */
	totalAmount: number | undefined;

	/**
	 *
	 *  The reimbursement amount.
	 */
	reimbursement: number | undefined;

	/**
	 *
	 *  The patient intervention amount.
	 */
	patientIntervention: number | undefined;

	/**
	 *
	 *  The AMI (insurance) intervention amount.
	 */
	amiIntervention: number | undefined;

	/**
	 *
	 *  The doctor supplement amount.
	 */
	doctorSupplement: number | undefined;

	/**
	 *
	 *  The convention amount (reimbursement + intervention).
	 */
	conventionAmount: number | undefined;

	/**
	 *
	 *  The VAT amount.
	 */
	vat: number | undefined;

	/**
	 *
	 *  The error message from eTarif, if any.
	 */
	error: string | undefined;

	/**
	 *
	 *  The contract identifier.
	 */
	contract: string | undefined;

	/**
	 *
	 *  The contract date.
	 */
	contractDate: number | undefined;

	/**
	 *
	 *  The number of units.
	 */
	units: number | undefined;

	/**
	 *
	 *  The side indicator.
	 */
	side: number | undefined;

	/**
	 *
	 *  The time of day.
	 */
	timeOfDay: number | undefined;

	/**
	 *
	 *  The hour when the eID was read.
	 */
	eidReadingHour: number | undefined;

	/**
	 *
	 *  The value read from the eID.
	 */
	eidReadingValue: string | undefined;

	/**
	 *
	 *  The override code for third-party payer.
	 */
	override3rdPayerCode: number | undefined;

	/**
	 *
	 *  The reason for overriding the third-party payer.
	 */
	override3rdPayerReason: string | undefined;

	/**
	 *
	 *  The transplantation code.
	 */
	transplantationCode: number | undefined;

	/**
	 *
	 *  The prescriber norm code.
	 */
	prescriberNorm: number | undefined;

	/**
	 *
	 *  The label of the product.
	 */
	productLabel: string | undefined;

	/**
	 *
	 *  The percent norm.
	 */
	percentNorm: number | undefined;

	/**
	 *
	 *  The NIHII number of the prescriber.
	 */
	prescriberNihii: string | undefined;

	/**
	 *
	 *  A related code.
	 */
	relatedCode: string | undefined;

	/**
	 *
	 *  The prescription date (yyyyMMdd).
	 */
	prescriptionDate: number | undefined;

	/**
	 *
	 *  The maximum derogation number.
	 */
	derogationMaxNumber: number | undefined;

	/**
	 *
	 *  The SSIN of the prescriber.
	 */
	prescriberSsin: string | undefined;

	/**
	 *
	 *  The last name of the prescriber.
	 */
	prescriberLastName: string | undefined;

	/**
	 *
	 *  The first name of the prescriber.
	 */
	prescriberFirstName: string | undefined;

	/**
	 *
	 *  The CD-HCPARTY code of the prescriber.
	 */
	prescriberCdHcParty: string | undefined;

	/**
	 *
	 *  The NIHII number of the location.
	 */
	locationNihii: string | undefined;

	/**
	 *
	 *  The CD-HCPARTY code of the location.
	 */
	locationCdHcParty: string | undefined;

	/**
	 *
	 *  The service code of the location.
	 */
	locationService: number | undefined;

	/**
	 *
	 *  The admission date.
	 */
	admissionDate: number | undefined;

	/**
	 *
	 *  Whether this code has been canceled.
	 */
	canceled: boolean | undefined;

	/**
	 *
	 *  Whether this code has been accepted.
	 */
	accepted: boolean | undefined;

	/**
	 *
	 *  Whether this code is pending.
	 */
	pending: boolean | undefined;

	/**
	 *
	 *  Whether this code has been resent.
	 */
	resent: boolean | undefined;

	/**
	 *
	 *  Whether this code has been archived.
	 */
	archived: boolean | undefined;

	/**
	 *
	 *  Whether this code has been lost.
	 */
	lost: boolean | undefined;

	/**
	 *
	 *  The insurance justification code.
	 */
	insuranceJustification: number | undefined;

	/**
	 *
	 *  The reason for canceling patient intervention.
	 */
	cancelPatientInterventionReason: number | undefined;

	/**
	 *
	 *  The status bitmask of this invoicing code.
	 */
	status: number | undefined;

	/**
	 *
	 *  The label of the code.
	 */
	codeLabel: string | undefined;

	/**
	 *
	 *  Additional options as key-value pairs.
	 */
	options: { [ key: string ]: string };

	readonly isEncrypted: boolean;

	toJSON(): object;

}

/**
 *
 *  Represents an invoicing code within an invoice, containing tarification details, amounts,
 *  prescriber information,
 *  and lifecycle status flags. Each invoicing code corresponds to a billable medical act or service.
 *  /
 */
export class DecryptedInvoicingCode {

	/**
	 *
	 *  The unique identifier of this invoicing code.
	 */
	id: string | undefined;

	/**
	 *
	 *  The date of the invoicing code as a long (yyyyMMdd format).
	 */
	dateCode: number | undefined = undefined;

	/**
	 *
	 *  A logical identifier that remains stable when a code is resent to the insuring organization.
	 */
	logicalId: string | undefined = undefined;

	/**
	 *
	 *  The label of the invoicing code.
	 */
	label: string | undefined = undefined;

	/**
	 *
	 *  The identifier of the user who created this invoicing code.
	 */
	userId: string | undefined = undefined;

	/**
	 *
	 *  The identifier of the associated contact.
	 */
	contactId: string | undefined = undefined;

	/**
	 *
	 *  The identifier of the associated service.
	 */
	serviceId: string | undefined = undefined;

	/**
	 *
	 *  The identifier of the associated tarification.
	 */
	pricingId: string | undefined = undefined;

	/**
	 *
	 *  The code value, for obsolete codes or codes not linked to a tarification.
	 */
	code: string | undefined = undefined;

	/**
	 *
	 *  The type of payment.
	 */
	paymentType: PaymentType | undefined = undefined;

	/**
	 *
	 *  The amount already paid.
	 */
	paid: number | undefined = undefined;

	/**
	 *
	 *  The total amount (reimbursement + doctor supplement + intervention).
	 */
	totalAmount: number | undefined = undefined;

	/**
	 *
	 *  The reimbursement amount.
	 */
	reimbursement: number | undefined = undefined;

	/**
	 *
	 *  The patient intervention amount.
	 */
	patientIntervention: number | undefined = undefined;

	/**
	 *
	 *  The AMI (insurance) intervention amount.
	 */
	amiIntervention: number | undefined = undefined;

	/**
	 *
	 *  The doctor supplement amount.
	 */
	doctorSupplement: number | undefined = undefined;

	/**
	 *
	 *  The convention amount (reimbursement + intervention).
	 */
	conventionAmount: number | undefined = undefined;

	/**
	 *
	 *  The VAT amount.
	 */
	vat: number | undefined = undefined;

	/**
	 *
	 *  The error message from eTarif, if any.
	 */
	error: string | undefined = undefined;

	/**
	 *
	 *  The contract identifier.
	 */
	contract: string | undefined = undefined;

	/**
	 *
	 *  The contract date.
	 */
	contractDate: number | undefined = undefined;

	/**
	 *
	 *  The number of units.
	 */
	units: number | undefined = undefined;

	/**
	 *
	 *  The side indicator.
	 */
	side: number | undefined = undefined;

	/**
	 *
	 *  The time of day.
	 */
	timeOfDay: number | undefined = undefined;

	/**
	 *
	 *  The hour when the eID was read.
	 */
	eidReadingHour: number | undefined = undefined;

	/**
	 *
	 *  The value read from the eID.
	 */
	eidReadingValue: string | undefined = undefined;

	/**
	 *
	 *  The override code for third-party payer.
	 */
	override3rdPayerCode: number | undefined = undefined;

	/**
	 *
	 *  The reason for overriding the third-party payer.
	 */
	override3rdPayerReason: string | undefined = undefined;

	/**
	 *
	 *  The transplantation code.
	 */
	transplantationCode: number | undefined = undefined;

	/**
	 *
	 *  The prescriber norm code.
	 */
	prescriberNorm: number | undefined = undefined;

	/**
	 *
	 *  The label of the product.
	 */
	productLabel: string | undefined = undefined;

	/**
	 *
	 *  The percent norm.
	 */
	percentNorm: number | undefined = undefined;

	/**
	 *
	 *  The NIHII number of the prescriber.
	 */
	prescriberNihii: string | undefined = undefined;

	/**
	 *
	 *  A related code.
	 */
	relatedCode: string | undefined = undefined;

	/**
	 *
	 *  The prescription date (yyyyMMdd).
	 */
	prescriptionDate: number | undefined = undefined;

	/**
	 *
	 *  The maximum derogation number.
	 */
	derogationMaxNumber: number | undefined = undefined;

	/**
	 *
	 *  The SSIN of the prescriber.
	 */
	prescriberSsin: string | undefined = undefined;

	/**
	 *
	 *  The last name of the prescriber.
	 */
	prescriberLastName: string | undefined = undefined;

	/**
	 *
	 *  The first name of the prescriber.
	 */
	prescriberFirstName: string | undefined = undefined;

	/**
	 *
	 *  The CD-HCPARTY code of the prescriber.
	 */
	prescriberCdHcParty: string | undefined = undefined;

	/**
	 *
	 *  The NIHII number of the location.
	 */
	locationNihii: string | undefined = undefined;

	/**
	 *
	 *  The CD-HCPARTY code of the location.
	 */
	locationCdHcParty: string | undefined = undefined;

	/**
	 *
	 *  The service code of the location.
	 */
	locationService: number | undefined = undefined;

	/**
	 *
	 *  The admission date.
	 */
	admissionDate: number | undefined = undefined;

	/**
	 *
	 *  Whether this code has been canceled.
	 */
	canceled: boolean | undefined = undefined;

	/**
	 *
	 *  Whether this code has been accepted.
	 */
	accepted: boolean | undefined = undefined;

	/**
	 *
	 *  Whether this code is pending.
	 */
	pending: boolean | undefined = undefined;

	/**
	 *
	 *  Whether this code has been resent.
	 */
	resent: boolean | undefined = undefined;

	/**
	 *
	 *  Whether this code has been archived.
	 */
	archived: boolean | undefined = undefined;

	/**
	 *
	 *  Whether this code has been lost.
	 */
	lost: boolean | undefined = undefined;

	/**
	 *
	 *  The insurance justification code.
	 */
	insuranceJustification: number | undefined = undefined;

	/**
	 *
	 *  The reason for canceling patient intervention.
	 */
	cancelPatientInterventionReason: number | undefined = undefined;

	/**
	 *
	 *  The status bitmask of this invoicing code.
	 */
	status: number | undefined = undefined;

	/**
	 *
	 *  The label of the code.
	 */
	codeLabel: string | undefined = undefined;

	/**
	 *
	 *  Additional options as key-value pairs.
	 */
	options: { [ key: string ]: string } = {};

	/**
	 *
	 *  The base64-encoded encrypted content.
	 */
	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedInvoicingCode> & Pick<DecryptedInvoicingCode, "id">) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		this.id = partial.id;
		if ('dateCode' in partial) this.dateCode = partial.dateCode;
		if ('logicalId' in partial) this.logicalId = partial.logicalId;
		if ('label' in partial) this.label = partial.label;
		if ('userId' in partial) this.userId = partial.userId;
		if ('contactId' in partial) this.contactId = partial.contactId;
		if ('serviceId' in partial) this.serviceId = partial.serviceId;
		if ('pricingId' in partial) this.pricingId = partial.pricingId;
		if ('code' in partial) this.code = partial.code;
		if ('paymentType' in partial) this.paymentType = partial.paymentType;
		if ('paid' in partial) this.paid = partial.paid;
		if ('totalAmount' in partial) this.totalAmount = partial.totalAmount;
		if ('reimbursement' in partial) this.reimbursement = partial.reimbursement;
		if ('patientIntervention' in partial) this.patientIntervention = partial.patientIntervention;
		if ('amiIntervention' in partial) this.amiIntervention = partial.amiIntervention;
		if ('doctorSupplement' in partial) this.doctorSupplement = partial.doctorSupplement;
		if ('conventionAmount' in partial) this.conventionAmount = partial.conventionAmount;
		if ('vat' in partial) this.vat = partial.vat;
		if ('error' in partial) this.error = partial.error;
		if ('contract' in partial) this.contract = partial.contract;
		if ('contractDate' in partial) this.contractDate = partial.contractDate;
		if ('units' in partial) this.units = partial.units;
		if ('side' in partial) this.side = partial.side;
		if ('timeOfDay' in partial) this.timeOfDay = partial.timeOfDay;
		if ('eidReadingHour' in partial) this.eidReadingHour = partial.eidReadingHour;
		if ('eidReadingValue' in partial) this.eidReadingValue = partial.eidReadingValue;
		if ('override3rdPayerCode' in partial) this.override3rdPayerCode = partial.override3rdPayerCode;
		if ('override3rdPayerReason' in partial) this.override3rdPayerReason = partial.override3rdPayerReason;
		if ('transplantationCode' in partial) this.transplantationCode = partial.transplantationCode;
		if ('prescriberNorm' in partial) this.prescriberNorm = partial.prescriberNorm;
		if ('productLabel' in partial) this.productLabel = partial.productLabel;
		if ('percentNorm' in partial) this.percentNorm = partial.percentNorm;
		if ('prescriberNihii' in partial) this.prescriberNihii = partial.prescriberNihii;
		if ('relatedCode' in partial) this.relatedCode = partial.relatedCode;
		if ('prescriptionDate' in partial) this.prescriptionDate = partial.prescriptionDate;
		if ('derogationMaxNumber' in partial) this.derogationMaxNumber = partial.derogationMaxNumber;
		if ('prescriberSsin' in partial) this.prescriberSsin = partial.prescriberSsin;
		if ('prescriberLastName' in partial) this.prescriberLastName = partial.prescriberLastName;
		if ('prescriberFirstName' in partial) this.prescriberFirstName = partial.prescriberFirstName;
		if ('prescriberCdHcParty' in partial) this.prescriberCdHcParty = partial.prescriberCdHcParty;
		if ('locationNihii' in partial) this.locationNihii = partial.locationNihii;
		if ('locationCdHcParty' in partial) this.locationCdHcParty = partial.locationCdHcParty;
		if ('locationService' in partial) this.locationService = partial.locationService;
		if ('admissionDate' in partial) this.admissionDate = partial.admissionDate;
		if ('canceled' in partial) this.canceled = partial.canceled;
		if ('accepted' in partial) this.accepted = partial.accepted;
		if ('pending' in partial) this.pending = partial.pending;
		if ('resent' in partial) this.resent = partial.resent;
		if ('archived' in partial) this.archived = partial.archived;
		if ('lost' in partial) this.lost = partial.lost;
		if ('insuranceJustification' in partial) this.insuranceJustification = partial.insuranceJustification;
		if ('cancelPatientInterventionReason' in partial) this.cancelPatientInterventionReason = partial.cancelPatientInterventionReason;
		if ('status' in partial) this.status = partial.status;
		if ('codeLabel' in partial) this.codeLabel = partial.codeLabel;
		if ('options' in partial && partial.options !== undefined) this.options = partial.options;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id ?? null
		if (this.dateCode != undefined) res['dateCode'] = this.dateCode
		if (this.logicalId != undefined) res['logicalId'] = this.logicalId
		if (this.label != undefined) res['label'] = this.label
		if (this.userId != undefined) res['userId'] = this.userId
		if (this.contactId != undefined) res['contactId'] = this.contactId
		if (this.serviceId != undefined) res['serviceId'] = this.serviceId
		if (this.pricingId != undefined) res['pricingId'] = this.pricingId
		if (this.code != undefined) res['code'] = this.code
		if (this.paymentType != undefined) res['paymentType'] = this.paymentType
		if (this.paid != undefined) res['paid'] = this.paid
		if (this.totalAmount != undefined) res['totalAmount'] = this.totalAmount
		if (this.reimbursement != undefined) res['reimbursement'] = this.reimbursement
		if (this.patientIntervention != undefined) res['patientIntervention'] = this.patientIntervention
		if (this.amiIntervention != undefined) res['amiIntervention'] = this.amiIntervention
		if (this.doctorSupplement != undefined) res['doctorSupplement'] = this.doctorSupplement
		if (this.conventionAmount != undefined) res['conventionAmount'] = this.conventionAmount
		if (this.vat != undefined) res['vat'] = this.vat
		if (this.error != undefined) res['error'] = this.error
		if (this.contract != undefined) res['contract'] = this.contract
		if (this.contractDate != undefined) res['contractDate'] = this.contractDate
		if (this.units != undefined) res['units'] = this.units
		if (this.side != undefined) res['side'] = this.side
		if (this.timeOfDay != undefined) res['timeOfDay'] = this.timeOfDay
		if (this.eidReadingHour != undefined) res['eidReadingHour'] = this.eidReadingHour
		if (this.eidReadingValue != undefined) res['eidReadingValue'] = this.eidReadingValue
		if (this.override3rdPayerCode != undefined) res['override3rdPayerCode'] = this.override3rdPayerCode
		if (this.override3rdPayerReason != undefined) res['override3rdPayerReason'] = this.override3rdPayerReason
		if (this.transplantationCode != undefined) res['transplantationCode'] = this.transplantationCode
		if (this.prescriberNorm != undefined) res['prescriberNorm'] = this.prescriberNorm
		if (this.productLabel != undefined) res['productLabel'] = this.productLabel
		if (this.percentNorm != undefined) res['percentNorm'] = this.percentNorm
		if (this.prescriberNihii != undefined) res['prescriberNihii'] = this.prescriberNihii
		if (this.relatedCode != undefined) res['relatedCode'] = this.relatedCode
		if (this.prescriptionDate != undefined) res['prescriptionDate'] = this.prescriptionDate
		if (this.derogationMaxNumber != undefined) res['derogationMaxNumber'] = this.derogationMaxNumber
		if (this.prescriberSsin != undefined) res['prescriberSsin'] = this.prescriberSsin
		if (this.prescriberLastName != undefined) res['prescriberLastName'] = this.prescriberLastName
		if (this.prescriberFirstName != undefined) res['prescriberFirstName'] = this.prescriberFirstName
		if (this.prescriberCdHcParty != undefined) res['prescriberCdHcParty'] = this.prescriberCdHcParty
		if (this.locationNihii != undefined) res['locationNihii'] = this.locationNihii
		if (this.locationCdHcParty != undefined) res['locationCdHcParty'] = this.locationCdHcParty
		if (this.locationService != undefined) res['locationService'] = this.locationService
		if (this.admissionDate != undefined) res['admissionDate'] = this.admissionDate
		if (this.canceled != undefined) res['canceled'] = this.canceled
		if (this.accepted != undefined) res['accepted'] = this.accepted
		if (this.pending != undefined) res['pending'] = this.pending
		if (this.resent != undefined) res['resent'] = this.resent
		if (this.archived != undefined) res['archived'] = this.archived
		if (this.lost != undefined) res['lost'] = this.lost
		if (this.insuranceJustification != undefined) res['insuranceJustification'] = this.insuranceJustification
		if (this.cancelPatientInterventionReason != undefined) res['cancelPatientInterventionReason'] = this.cancelPatientInterventionReason
		if (this.status != undefined) res['status'] = this.status
		if (this.codeLabel != undefined) res['codeLabel'] = this.codeLabel
		res['options'] = Object.fromEntries(Object.entries(this.options).map(([k0, v0]) => [k0, v0]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedInvoicingCode']): DecryptedInvoicingCode {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedInvoicingCode`)
		const res = new DecryptedInvoicingCode({
			id: expectString(extractEntry(jCpy, 'id', true, path), true, [...path, ".id"]),
			dateCode: expectNumber(extractEntry(jCpy, 'dateCode', false, path), true, true, [...path, ".dateCode"]),
			logicalId: expectString(extractEntry(jCpy, 'logicalId', false, path), true, [...path, ".logicalId"]),
			label: expectString(extractEntry(jCpy, 'label', false, path), true, [...path, ".label"]),
			userId: expectString(extractEntry(jCpy, 'userId', false, path), true, [...path, ".userId"]),
			contactId: expectString(extractEntry(jCpy, 'contactId', false, path), true, [...path, ".contactId"]),
			serviceId: expectString(extractEntry(jCpy, 'serviceId', false, path), true, [...path, ".serviceId"]),
			pricingId: expectString(extractEntry(jCpy, 'pricingId', false, path), true, [...path, ".pricingId"]),
			code: expectString(extractEntry(jCpy, 'code', false, path), true, [...path, ".code"]),
			paymentType: expectStringEnum(extractEntry(jCpy, 'paymentType', false, path), true, [...path, ".paymentType"], PaymentType, 'PaymentType'),
			paid: expectNumber(extractEntry(jCpy, 'paid', false, path), true, false, [...path, ".paid"]),
			totalAmount: expectNumber(extractEntry(jCpy, 'totalAmount', false, path), true, false, [...path, ".totalAmount"]),
			reimbursement: expectNumber(extractEntry(jCpy, 'reimbursement', false, path), true, false, [...path, ".reimbursement"]),
			patientIntervention: expectNumber(extractEntry(jCpy, 'patientIntervention', false, path), true, false, [...path, ".patientIntervention"]),
			amiIntervention: expectNumber(extractEntry(jCpy, 'amiIntervention', false, path), true, false, [...path, ".amiIntervention"]),
			doctorSupplement: expectNumber(extractEntry(jCpy, 'doctorSupplement', false, path), true, false, [...path, ".doctorSupplement"]),
			conventionAmount: expectNumber(extractEntry(jCpy, 'conventionAmount', false, path), true, false, [...path, ".conventionAmount"]),
			vat: expectNumber(extractEntry(jCpy, 'vat', false, path), true, false, [...path, ".vat"]),
			error: expectString(extractEntry(jCpy, 'error', false, path), true, [...path, ".error"]),
			contract: expectString(extractEntry(jCpy, 'contract', false, path), true, [...path, ".contract"]),
			contractDate: expectNumber(extractEntry(jCpy, 'contractDate', false, path), true, true, [...path, ".contractDate"]),
			units: expectNumber(extractEntry(jCpy, 'units', false, path), true, true, [...path, ".units"]),
			side: expectNumber(extractEntry(jCpy, 'side', false, path), true, true, [...path, ".side"]),
			timeOfDay: expectNumber(extractEntry(jCpy, 'timeOfDay', false, path), true, true, [...path, ".timeOfDay"]),
			eidReadingHour: expectNumber(extractEntry(jCpy, 'eidReadingHour', false, path), true, true, [...path, ".eidReadingHour"]),
			eidReadingValue: expectString(extractEntry(jCpy, 'eidReadingValue', false, path), true, [...path, ".eidReadingValue"]),
			override3rdPayerCode: expectNumber(extractEntry(jCpy, 'override3rdPayerCode', false, path), true, true, [...path, ".override3rdPayerCode"]),
			override3rdPayerReason: expectString(extractEntry(jCpy, 'override3rdPayerReason', false, path), true, [...path, ".override3rdPayerReason"]),
			transplantationCode: expectNumber(extractEntry(jCpy, 'transplantationCode', false, path), true, true, [...path, ".transplantationCode"]),
			prescriberNorm: expectNumber(extractEntry(jCpy, 'prescriberNorm', false, path), true, true, [...path, ".prescriberNorm"]),
			productLabel: expectString(extractEntry(jCpy, 'productLabel', false, path), true, [...path, ".productLabel"]),
			percentNorm: expectNumber(extractEntry(jCpy, 'percentNorm', false, path), true, true, [...path, ".percentNorm"]),
			prescriberNihii: expectString(extractEntry(jCpy, 'prescriberNihii', false, path), true, [...path, ".prescriberNihii"]),
			relatedCode: expectString(extractEntry(jCpy, 'relatedCode', false, path), true, [...path, ".relatedCode"]),
			prescriptionDate: expectNumber(extractEntry(jCpy, 'prescriptionDate', false, path), true, true, [...path, ".prescriptionDate"]),
			derogationMaxNumber: expectNumber(extractEntry(jCpy, 'derogationMaxNumber', false, path), true, true, [...path, ".derogationMaxNumber"]),
			prescriberSsin: expectString(extractEntry(jCpy, 'prescriberSsin', false, path), true, [...path, ".prescriberSsin"]),
			prescriberLastName: expectString(extractEntry(jCpy, 'prescriberLastName', false, path), true, [...path, ".prescriberLastName"]),
			prescriberFirstName: expectString(extractEntry(jCpy, 'prescriberFirstName', false, path), true, [...path, ".prescriberFirstName"]),
			prescriberCdHcParty: expectString(extractEntry(jCpy, 'prescriberCdHcParty', false, path), true, [...path, ".prescriberCdHcParty"]),
			locationNihii: expectString(extractEntry(jCpy, 'locationNihii', false, path), true, [...path, ".locationNihii"]),
			locationCdHcParty: expectString(extractEntry(jCpy, 'locationCdHcParty', false, path), true, [...path, ".locationCdHcParty"]),
			locationService: expectNumber(extractEntry(jCpy, 'locationService', false, path), true, true, [...path, ".locationService"]),
			admissionDate: expectNumber(extractEntry(jCpy, 'admissionDate', false, path), true, true, [...path, ".admissionDate"]),
			canceled: expectBoolean(extractEntry(jCpy, 'canceled', false, path), true, [...path, ".canceled"]),
			accepted: expectBoolean(extractEntry(jCpy, 'accepted', false, path), true, [...path, ".accepted"]),
			pending: expectBoolean(extractEntry(jCpy, 'pending', false, path), true, [...path, ".pending"]),
			resent: expectBoolean(extractEntry(jCpy, 'resent', false, path), true, [...path, ".resent"]),
			archived: expectBoolean(extractEntry(jCpy, 'archived', false, path), true, [...path, ".archived"]),
			lost: expectBoolean(extractEntry(jCpy, 'lost', false, path), true, [...path, ".lost"]),
			insuranceJustification: expectNumber(extractEntry(jCpy, 'insuranceJustification', false, path), true, true, [...path, ".insuranceJustification"]),
			cancelPatientInterventionReason: expectNumber(extractEntry(jCpy, 'cancelPatientInterventionReason', false, path), true, true, [...path, ".cancelPatientInterventionReason"]),
			status: expectNumber(extractEntry(jCpy, 'status', false, path), true, true, [...path, ".status"]),
			codeLabel: expectString(extractEntry(jCpy, 'codeLabel', false, path), true, [...path, ".codeLabel"]),
			options: expectMap(
				extractEntry(jCpy, 'options', false, path),
				false,
				[...path, ".options"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedInvoicingCode at path ${path.join("")}: ${unused}`)}
		return res
	}

}

/**
 *
 *  Represents an invoicing code within an invoice, containing tarification details, amounts,
 *  prescriber information,
 *  and lifecycle status flags. Each invoicing code corresponds to a billable medical act or service.
 *  /
 */
export class EncryptedInvoicingCode {

	/**
	 *
	 *  The unique identifier of this invoicing code.
	 */
	id: string | undefined;

	/**
	 *
	 *  The date of the invoicing code as a long (yyyyMMdd format).
	 */
	dateCode: number | undefined = undefined;

	/**
	 *
	 *  A logical identifier that remains stable when a code is resent to the insuring organization.
	 */
	logicalId: string | undefined = undefined;

	/**
	 *
	 *  The label of the invoicing code.
	 */
	label: string | undefined = undefined;

	/**
	 *
	 *  The identifier of the user who created this invoicing code.
	 */
	userId: string | undefined = undefined;

	/**
	 *
	 *  The identifier of the associated contact.
	 */
	contactId: string | undefined = undefined;

	/**
	 *
	 *  The identifier of the associated service.
	 */
	serviceId: string | undefined = undefined;

	/**
	 *
	 *  The identifier of the associated tarification.
	 */
	pricingId: string | undefined = undefined;

	/**
	 *
	 *  The code value, for obsolete codes or codes not linked to a tarification.
	 */
	code: string | undefined = undefined;

	/**
	 *
	 *  The type of payment.
	 */
	paymentType: PaymentType | undefined = undefined;

	/**
	 *
	 *  The amount already paid.
	 */
	paid: number | undefined = undefined;

	/**
	 *
	 *  The total amount (reimbursement + doctor supplement + intervention).
	 */
	totalAmount: number | undefined = undefined;

	/**
	 *
	 *  The reimbursement amount.
	 */
	reimbursement: number | undefined = undefined;

	/**
	 *
	 *  The patient intervention amount.
	 */
	patientIntervention: number | undefined = undefined;

	/**
	 *
	 *  The AMI (insurance) intervention amount.
	 */
	amiIntervention: number | undefined = undefined;

	/**
	 *
	 *  The doctor supplement amount.
	 */
	doctorSupplement: number | undefined = undefined;

	/**
	 *
	 *  The convention amount (reimbursement + intervention).
	 */
	conventionAmount: number | undefined = undefined;

	/**
	 *
	 *  The VAT amount.
	 */
	vat: number | undefined = undefined;

	/**
	 *
	 *  The error message from eTarif, if any.
	 */
	error: string | undefined = undefined;

	/**
	 *
	 *  The contract identifier.
	 */
	contract: string | undefined = undefined;

	/**
	 *
	 *  The contract date.
	 */
	contractDate: number | undefined = undefined;

	/**
	 *
	 *  The number of units.
	 */
	units: number | undefined = undefined;

	/**
	 *
	 *  The side indicator.
	 */
	side: number | undefined = undefined;

	/**
	 *
	 *  The time of day.
	 */
	timeOfDay: number | undefined = undefined;

	/**
	 *
	 *  The hour when the eID was read.
	 */
	eidReadingHour: number | undefined = undefined;

	/**
	 *
	 *  The value read from the eID.
	 */
	eidReadingValue: string | undefined = undefined;

	/**
	 *
	 *  The override code for third-party payer.
	 */
	override3rdPayerCode: number | undefined = undefined;

	/**
	 *
	 *  The reason for overriding the third-party payer.
	 */
	override3rdPayerReason: string | undefined = undefined;

	/**
	 *
	 *  The transplantation code.
	 */
	transplantationCode: number | undefined = undefined;

	/**
	 *
	 *  The prescriber norm code.
	 */
	prescriberNorm: number | undefined = undefined;

	/**
	 *
	 *  The label of the product.
	 */
	productLabel: string | undefined = undefined;

	/**
	 *
	 *  The percent norm.
	 */
	percentNorm: number | undefined = undefined;

	/**
	 *
	 *  The NIHII number of the prescriber.
	 */
	prescriberNihii: string | undefined = undefined;

	/**
	 *
	 *  A related code.
	 */
	relatedCode: string | undefined = undefined;

	/**
	 *
	 *  The prescription date (yyyyMMdd).
	 */
	prescriptionDate: number | undefined = undefined;

	/**
	 *
	 *  The maximum derogation number.
	 */
	derogationMaxNumber: number | undefined = undefined;

	/**
	 *
	 *  The SSIN of the prescriber.
	 */
	prescriberSsin: string | undefined = undefined;

	/**
	 *
	 *  The last name of the prescriber.
	 */
	prescriberLastName: string | undefined = undefined;

	/**
	 *
	 *  The first name of the prescriber.
	 */
	prescriberFirstName: string | undefined = undefined;

	/**
	 *
	 *  The CD-HCPARTY code of the prescriber.
	 */
	prescriberCdHcParty: string | undefined = undefined;

	/**
	 *
	 *  The NIHII number of the location.
	 */
	locationNihii: string | undefined = undefined;

	/**
	 *
	 *  The CD-HCPARTY code of the location.
	 */
	locationCdHcParty: string | undefined = undefined;

	/**
	 *
	 *  The service code of the location.
	 */
	locationService: number | undefined = undefined;

	/**
	 *
	 *  The admission date.
	 */
	admissionDate: number | undefined = undefined;

	/**
	 *
	 *  Whether this code has been canceled.
	 */
	canceled: boolean | undefined = undefined;

	/**
	 *
	 *  Whether this code has been accepted.
	 */
	accepted: boolean | undefined = undefined;

	/**
	 *
	 *  Whether this code is pending.
	 */
	pending: boolean | undefined = undefined;

	/**
	 *
	 *  Whether this code has been resent.
	 */
	resent: boolean | undefined = undefined;

	/**
	 *
	 *  Whether this code has been archived.
	 */
	archived: boolean | undefined = undefined;

	/**
	 *
	 *  Whether this code has been lost.
	 */
	lost: boolean | undefined = undefined;

	/**
	 *
	 *  The insurance justification code.
	 */
	insuranceJustification: number | undefined = undefined;

	/**
	 *
	 *  The reason for canceling patient intervention.
	 */
	cancelPatientInterventionReason: number | undefined = undefined;

	/**
	 *
	 *  The status bitmask of this invoicing code.
	 */
	status: number | undefined = undefined;

	/**
	 *
	 *  The label of the code.
	 */
	codeLabel: string | undefined = undefined;

	/**
	 *
	 *  Additional options as key-value pairs.
	 */
	options: { [ key: string ]: string } = {};

	/**
	 *
	 *  The base64-encoded encrypted content.
	 */
	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedInvoicingCode> & Pick<EncryptedInvoicingCode, "id">) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		this.id = partial.id;
		if ('dateCode' in partial) this.dateCode = partial.dateCode;
		if ('logicalId' in partial) this.logicalId = partial.logicalId;
		if ('label' in partial) this.label = partial.label;
		if ('userId' in partial) this.userId = partial.userId;
		if ('contactId' in partial) this.contactId = partial.contactId;
		if ('serviceId' in partial) this.serviceId = partial.serviceId;
		if ('pricingId' in partial) this.pricingId = partial.pricingId;
		if ('code' in partial) this.code = partial.code;
		if ('paymentType' in partial) this.paymentType = partial.paymentType;
		if ('paid' in partial) this.paid = partial.paid;
		if ('totalAmount' in partial) this.totalAmount = partial.totalAmount;
		if ('reimbursement' in partial) this.reimbursement = partial.reimbursement;
		if ('patientIntervention' in partial) this.patientIntervention = partial.patientIntervention;
		if ('amiIntervention' in partial) this.amiIntervention = partial.amiIntervention;
		if ('doctorSupplement' in partial) this.doctorSupplement = partial.doctorSupplement;
		if ('conventionAmount' in partial) this.conventionAmount = partial.conventionAmount;
		if ('vat' in partial) this.vat = partial.vat;
		if ('error' in partial) this.error = partial.error;
		if ('contract' in partial) this.contract = partial.contract;
		if ('contractDate' in partial) this.contractDate = partial.contractDate;
		if ('units' in partial) this.units = partial.units;
		if ('side' in partial) this.side = partial.side;
		if ('timeOfDay' in partial) this.timeOfDay = partial.timeOfDay;
		if ('eidReadingHour' in partial) this.eidReadingHour = partial.eidReadingHour;
		if ('eidReadingValue' in partial) this.eidReadingValue = partial.eidReadingValue;
		if ('override3rdPayerCode' in partial) this.override3rdPayerCode = partial.override3rdPayerCode;
		if ('override3rdPayerReason' in partial) this.override3rdPayerReason = partial.override3rdPayerReason;
		if ('transplantationCode' in partial) this.transplantationCode = partial.transplantationCode;
		if ('prescriberNorm' in partial) this.prescriberNorm = partial.prescriberNorm;
		if ('productLabel' in partial) this.productLabel = partial.productLabel;
		if ('percentNorm' in partial) this.percentNorm = partial.percentNorm;
		if ('prescriberNihii' in partial) this.prescriberNihii = partial.prescriberNihii;
		if ('relatedCode' in partial) this.relatedCode = partial.relatedCode;
		if ('prescriptionDate' in partial) this.prescriptionDate = partial.prescriptionDate;
		if ('derogationMaxNumber' in partial) this.derogationMaxNumber = partial.derogationMaxNumber;
		if ('prescriberSsin' in partial) this.prescriberSsin = partial.prescriberSsin;
		if ('prescriberLastName' in partial) this.prescriberLastName = partial.prescriberLastName;
		if ('prescriberFirstName' in partial) this.prescriberFirstName = partial.prescriberFirstName;
		if ('prescriberCdHcParty' in partial) this.prescriberCdHcParty = partial.prescriberCdHcParty;
		if ('locationNihii' in partial) this.locationNihii = partial.locationNihii;
		if ('locationCdHcParty' in partial) this.locationCdHcParty = partial.locationCdHcParty;
		if ('locationService' in partial) this.locationService = partial.locationService;
		if ('admissionDate' in partial) this.admissionDate = partial.admissionDate;
		if ('canceled' in partial) this.canceled = partial.canceled;
		if ('accepted' in partial) this.accepted = partial.accepted;
		if ('pending' in partial) this.pending = partial.pending;
		if ('resent' in partial) this.resent = partial.resent;
		if ('archived' in partial) this.archived = partial.archived;
		if ('lost' in partial) this.lost = partial.lost;
		if ('insuranceJustification' in partial) this.insuranceJustification = partial.insuranceJustification;
		if ('cancelPatientInterventionReason' in partial) this.cancelPatientInterventionReason = partial.cancelPatientInterventionReason;
		if ('status' in partial) this.status = partial.status;
		if ('codeLabel' in partial) this.codeLabel = partial.codeLabel;
		if ('options' in partial && partial.options !== undefined) this.options = partial.options;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id ?? null
		if (this.dateCode != undefined) res['dateCode'] = this.dateCode
		if (this.logicalId != undefined) res['logicalId'] = this.logicalId
		if (this.label != undefined) res['label'] = this.label
		if (this.userId != undefined) res['userId'] = this.userId
		if (this.contactId != undefined) res['contactId'] = this.contactId
		if (this.serviceId != undefined) res['serviceId'] = this.serviceId
		if (this.pricingId != undefined) res['pricingId'] = this.pricingId
		if (this.code != undefined) res['code'] = this.code
		if (this.paymentType != undefined) res['paymentType'] = this.paymentType
		if (this.paid != undefined) res['paid'] = this.paid
		if (this.totalAmount != undefined) res['totalAmount'] = this.totalAmount
		if (this.reimbursement != undefined) res['reimbursement'] = this.reimbursement
		if (this.patientIntervention != undefined) res['patientIntervention'] = this.patientIntervention
		if (this.amiIntervention != undefined) res['amiIntervention'] = this.amiIntervention
		if (this.doctorSupplement != undefined) res['doctorSupplement'] = this.doctorSupplement
		if (this.conventionAmount != undefined) res['conventionAmount'] = this.conventionAmount
		if (this.vat != undefined) res['vat'] = this.vat
		if (this.error != undefined) res['error'] = this.error
		if (this.contract != undefined) res['contract'] = this.contract
		if (this.contractDate != undefined) res['contractDate'] = this.contractDate
		if (this.units != undefined) res['units'] = this.units
		if (this.side != undefined) res['side'] = this.side
		if (this.timeOfDay != undefined) res['timeOfDay'] = this.timeOfDay
		if (this.eidReadingHour != undefined) res['eidReadingHour'] = this.eidReadingHour
		if (this.eidReadingValue != undefined) res['eidReadingValue'] = this.eidReadingValue
		if (this.override3rdPayerCode != undefined) res['override3rdPayerCode'] = this.override3rdPayerCode
		if (this.override3rdPayerReason != undefined) res['override3rdPayerReason'] = this.override3rdPayerReason
		if (this.transplantationCode != undefined) res['transplantationCode'] = this.transplantationCode
		if (this.prescriberNorm != undefined) res['prescriberNorm'] = this.prescriberNorm
		if (this.productLabel != undefined) res['productLabel'] = this.productLabel
		if (this.percentNorm != undefined) res['percentNorm'] = this.percentNorm
		if (this.prescriberNihii != undefined) res['prescriberNihii'] = this.prescriberNihii
		if (this.relatedCode != undefined) res['relatedCode'] = this.relatedCode
		if (this.prescriptionDate != undefined) res['prescriptionDate'] = this.prescriptionDate
		if (this.derogationMaxNumber != undefined) res['derogationMaxNumber'] = this.derogationMaxNumber
		if (this.prescriberSsin != undefined) res['prescriberSsin'] = this.prescriberSsin
		if (this.prescriberLastName != undefined) res['prescriberLastName'] = this.prescriberLastName
		if (this.prescriberFirstName != undefined) res['prescriberFirstName'] = this.prescriberFirstName
		if (this.prescriberCdHcParty != undefined) res['prescriberCdHcParty'] = this.prescriberCdHcParty
		if (this.locationNihii != undefined) res['locationNihii'] = this.locationNihii
		if (this.locationCdHcParty != undefined) res['locationCdHcParty'] = this.locationCdHcParty
		if (this.locationService != undefined) res['locationService'] = this.locationService
		if (this.admissionDate != undefined) res['admissionDate'] = this.admissionDate
		if (this.canceled != undefined) res['canceled'] = this.canceled
		if (this.accepted != undefined) res['accepted'] = this.accepted
		if (this.pending != undefined) res['pending'] = this.pending
		if (this.resent != undefined) res['resent'] = this.resent
		if (this.archived != undefined) res['archived'] = this.archived
		if (this.lost != undefined) res['lost'] = this.lost
		if (this.insuranceJustification != undefined) res['insuranceJustification'] = this.insuranceJustification
		if (this.cancelPatientInterventionReason != undefined) res['cancelPatientInterventionReason'] = this.cancelPatientInterventionReason
		if (this.status != undefined) res['status'] = this.status
		if (this.codeLabel != undefined) res['codeLabel'] = this.codeLabel
		res['options'] = Object.fromEntries(Object.entries(this.options).map(([k0, v0]) => [k0, v0]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedInvoicingCode']): EncryptedInvoicingCode {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedInvoicingCode`)
		const res = new EncryptedInvoicingCode({
			id: expectString(extractEntry(jCpy, 'id', true, path), true, [...path, ".id"]),
			dateCode: expectNumber(extractEntry(jCpy, 'dateCode', false, path), true, true, [...path, ".dateCode"]),
			logicalId: expectString(extractEntry(jCpy, 'logicalId', false, path), true, [...path, ".logicalId"]),
			label: expectString(extractEntry(jCpy, 'label', false, path), true, [...path, ".label"]),
			userId: expectString(extractEntry(jCpy, 'userId', false, path), true, [...path, ".userId"]),
			contactId: expectString(extractEntry(jCpy, 'contactId', false, path), true, [...path, ".contactId"]),
			serviceId: expectString(extractEntry(jCpy, 'serviceId', false, path), true, [...path, ".serviceId"]),
			pricingId: expectString(extractEntry(jCpy, 'pricingId', false, path), true, [...path, ".pricingId"]),
			code: expectString(extractEntry(jCpy, 'code', false, path), true, [...path, ".code"]),
			paymentType: expectStringEnum(extractEntry(jCpy, 'paymentType', false, path), true, [...path, ".paymentType"], PaymentType, 'PaymentType'),
			paid: expectNumber(extractEntry(jCpy, 'paid', false, path), true, false, [...path, ".paid"]),
			totalAmount: expectNumber(extractEntry(jCpy, 'totalAmount', false, path), true, false, [...path, ".totalAmount"]),
			reimbursement: expectNumber(extractEntry(jCpy, 'reimbursement', false, path), true, false, [...path, ".reimbursement"]),
			patientIntervention: expectNumber(extractEntry(jCpy, 'patientIntervention', false, path), true, false, [...path, ".patientIntervention"]),
			amiIntervention: expectNumber(extractEntry(jCpy, 'amiIntervention', false, path), true, false, [...path, ".amiIntervention"]),
			doctorSupplement: expectNumber(extractEntry(jCpy, 'doctorSupplement', false, path), true, false, [...path, ".doctorSupplement"]),
			conventionAmount: expectNumber(extractEntry(jCpy, 'conventionAmount', false, path), true, false, [...path, ".conventionAmount"]),
			vat: expectNumber(extractEntry(jCpy, 'vat', false, path), true, false, [...path, ".vat"]),
			error: expectString(extractEntry(jCpy, 'error', false, path), true, [...path, ".error"]),
			contract: expectString(extractEntry(jCpy, 'contract', false, path), true, [...path, ".contract"]),
			contractDate: expectNumber(extractEntry(jCpy, 'contractDate', false, path), true, true, [...path, ".contractDate"]),
			units: expectNumber(extractEntry(jCpy, 'units', false, path), true, true, [...path, ".units"]),
			side: expectNumber(extractEntry(jCpy, 'side', false, path), true, true, [...path, ".side"]),
			timeOfDay: expectNumber(extractEntry(jCpy, 'timeOfDay', false, path), true, true, [...path, ".timeOfDay"]),
			eidReadingHour: expectNumber(extractEntry(jCpy, 'eidReadingHour', false, path), true, true, [...path, ".eidReadingHour"]),
			eidReadingValue: expectString(extractEntry(jCpy, 'eidReadingValue', false, path), true, [...path, ".eidReadingValue"]),
			override3rdPayerCode: expectNumber(extractEntry(jCpy, 'override3rdPayerCode', false, path), true, true, [...path, ".override3rdPayerCode"]),
			override3rdPayerReason: expectString(extractEntry(jCpy, 'override3rdPayerReason', false, path), true, [...path, ".override3rdPayerReason"]),
			transplantationCode: expectNumber(extractEntry(jCpy, 'transplantationCode', false, path), true, true, [...path, ".transplantationCode"]),
			prescriberNorm: expectNumber(extractEntry(jCpy, 'prescriberNorm', false, path), true, true, [...path, ".prescriberNorm"]),
			productLabel: expectString(extractEntry(jCpy, 'productLabel', false, path), true, [...path, ".productLabel"]),
			percentNorm: expectNumber(extractEntry(jCpy, 'percentNorm', false, path), true, true, [...path, ".percentNorm"]),
			prescriberNihii: expectString(extractEntry(jCpy, 'prescriberNihii', false, path), true, [...path, ".prescriberNihii"]),
			relatedCode: expectString(extractEntry(jCpy, 'relatedCode', false, path), true, [...path, ".relatedCode"]),
			prescriptionDate: expectNumber(extractEntry(jCpy, 'prescriptionDate', false, path), true, true, [...path, ".prescriptionDate"]),
			derogationMaxNumber: expectNumber(extractEntry(jCpy, 'derogationMaxNumber', false, path), true, true, [...path, ".derogationMaxNumber"]),
			prescriberSsin: expectString(extractEntry(jCpy, 'prescriberSsin', false, path), true, [...path, ".prescriberSsin"]),
			prescriberLastName: expectString(extractEntry(jCpy, 'prescriberLastName', false, path), true, [...path, ".prescriberLastName"]),
			prescriberFirstName: expectString(extractEntry(jCpy, 'prescriberFirstName', false, path), true, [...path, ".prescriberFirstName"]),
			prescriberCdHcParty: expectString(extractEntry(jCpy, 'prescriberCdHcParty', false, path), true, [...path, ".prescriberCdHcParty"]),
			locationNihii: expectString(extractEntry(jCpy, 'locationNihii', false, path), true, [...path, ".locationNihii"]),
			locationCdHcParty: expectString(extractEntry(jCpy, 'locationCdHcParty', false, path), true, [...path, ".locationCdHcParty"]),
			locationService: expectNumber(extractEntry(jCpy, 'locationService', false, path), true, true, [...path, ".locationService"]),
			admissionDate: expectNumber(extractEntry(jCpy, 'admissionDate', false, path), true, true, [...path, ".admissionDate"]),
			canceled: expectBoolean(extractEntry(jCpy, 'canceled', false, path), true, [...path, ".canceled"]),
			accepted: expectBoolean(extractEntry(jCpy, 'accepted', false, path), true, [...path, ".accepted"]),
			pending: expectBoolean(extractEntry(jCpy, 'pending', false, path), true, [...path, ".pending"]),
			resent: expectBoolean(extractEntry(jCpy, 'resent', false, path), true, [...path, ".resent"]),
			archived: expectBoolean(extractEntry(jCpy, 'archived', false, path), true, [...path, ".archived"]),
			lost: expectBoolean(extractEntry(jCpy, 'lost', false, path), true, [...path, ".lost"]),
			insuranceJustification: expectNumber(extractEntry(jCpy, 'insuranceJustification', false, path), true, true, [...path, ".insuranceJustification"]),
			cancelPatientInterventionReason: expectNumber(extractEntry(jCpy, 'cancelPatientInterventionReason', false, path), true, true, [...path, ".cancelPatientInterventionReason"]),
			status: expectNumber(extractEntry(jCpy, 'status', false, path), true, true, [...path, ".status"]),
			codeLabel: expectString(extractEntry(jCpy, 'codeLabel', false, path), true, [...path, ".codeLabel"]),
			options: expectMap(
				extractEntry(jCpy, 'options', false, path),
				false,
				[...path, ".options"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedInvoicingCode at path ${path.join("")}: ${unused}`)}
		return res
	}

}

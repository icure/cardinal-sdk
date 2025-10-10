// auto-generated file
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';
import {PaymentType} from './PaymentType.mjs';


export interface InvoicingCode extends Encryptable {

	id: string | undefined;

	dateCode: number | undefined;

	logicalId: string | undefined;

	label: string | undefined;

	userId: string | undefined;

	contactId: string | undefined;

	serviceId: string | undefined;

	tarificationId: string | undefined;

	code: string | undefined;

	paymentType: PaymentType | undefined;

	paid: number | undefined;

	totalAmount: number | undefined;

	reimbursement: number | undefined;

	patientIntervention: number | undefined;

	amiIntervention: number | undefined;

	doctorSupplement: number | undefined;

	conventionAmount: number | undefined;

	vat: number | undefined;

	error: string | undefined;

	contract: string | undefined;

	contractDate: number | undefined;

	units: number | undefined;

	side: number | undefined;

	timeOfDay: number | undefined;

	eidReadingHour: number | undefined;

	eidReadingValue: string | undefined;

	override3rdPayerCode: number | undefined;

	override3rdPayerReason: string | undefined;

	transplantationCode: number | undefined;

	prescriberNorm: number | undefined;

	productLabel: string | undefined;

	percentNorm: number | undefined;

	prescriberNihii: string | undefined;

	relatedCode: string | undefined;

	prescriptionDate: number | undefined;

	derogationMaxNumber: number | undefined;

	prescriberSsin: string | undefined;

	prescriberLastName: string | undefined;

	prescriberFirstName: string | undefined;

	prescriberCdHcParty: string | undefined;

	locationNihii: string | undefined;

	locationCdHcParty: string | undefined;

	locationService: number | undefined;

	admissionDate: number | undefined;

	canceled: boolean | undefined;

	accepted: boolean | undefined;

	pending: boolean | undefined;

	resent: boolean | undefined;

	archived: boolean | undefined;

	lost: boolean | undefined;

	insuranceJustification: number | undefined;

	cancelPatientInterventionReason: number | undefined;

	status: number | undefined;

	codeLabel: string | undefined;

	options: { [ key: string ]: string };

	readonly isEncrypted: boolean;

}

export class DecryptedInvoicingCode {

	id: string | undefined;

	dateCode: number | undefined = undefined;

	logicalId: string | undefined = undefined;

	label: string | undefined = undefined;

	userId: string | undefined = undefined;

	contactId: string | undefined = undefined;

	serviceId: string | undefined = undefined;

	tarificationId: string | undefined = undefined;

	code: string | undefined = undefined;

	paymentType: PaymentType | undefined = undefined;

	paid: number | undefined = undefined;

	totalAmount: number | undefined = undefined;

	reimbursement: number | undefined = undefined;

	patientIntervention: number | undefined = undefined;

	amiIntervention: number | undefined = undefined;

	doctorSupplement: number | undefined = undefined;

	conventionAmount: number | undefined = undefined;

	vat: number | undefined = undefined;

	error: string | undefined = undefined;

	contract: string | undefined = undefined;

	contractDate: number | undefined = undefined;

	units: number | undefined = undefined;

	side: number | undefined = undefined;

	timeOfDay: number | undefined = undefined;

	eidReadingHour: number | undefined = undefined;

	eidReadingValue: string | undefined = undefined;

	override3rdPayerCode: number | undefined = undefined;

	override3rdPayerReason: string | undefined = undefined;

	transplantationCode: number | undefined = undefined;

	prescriberNorm: number | undefined = undefined;

	productLabel: string | undefined = undefined;

	percentNorm: number | undefined = undefined;

	prescriberNihii: string | undefined = undefined;

	relatedCode: string | undefined = undefined;

	prescriptionDate: number | undefined = undefined;

	derogationMaxNumber: number | undefined = undefined;

	prescriberSsin: string | undefined = undefined;

	prescriberLastName: string | undefined = undefined;

	prescriberFirstName: string | undefined = undefined;

	prescriberCdHcParty: string | undefined = undefined;

	locationNihii: string | undefined = undefined;

	locationCdHcParty: string | undefined = undefined;

	locationService: number | undefined = undefined;

	admissionDate: number | undefined = undefined;

	canceled: boolean | undefined = undefined;

	accepted: boolean | undefined = undefined;

	pending: boolean | undefined = undefined;

	resent: boolean | undefined = undefined;

	archived: boolean | undefined = undefined;

	lost: boolean | undefined = undefined;

	insuranceJustification: number | undefined = undefined;

	cancelPatientInterventionReason: number | undefined = undefined;

	status: number | undefined = undefined;

	codeLabel: string | undefined = undefined;

	options: { [ key: string ]: string } = {};

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
		if ('tarificationId' in partial) this.tarificationId = partial.tarificationId;
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

}

export class EncryptedInvoicingCode {

	id: string | undefined;

	dateCode: number | undefined = undefined;

	logicalId: string | undefined = undefined;

	label: string | undefined = undefined;

	userId: string | undefined = undefined;

	contactId: string | undefined = undefined;

	serviceId: string | undefined = undefined;

	tarificationId: string | undefined = undefined;

	code: string | undefined = undefined;

	paymentType: PaymentType | undefined = undefined;

	paid: number | undefined = undefined;

	totalAmount: number | undefined = undefined;

	reimbursement: number | undefined = undefined;

	patientIntervention: number | undefined = undefined;

	amiIntervention: number | undefined = undefined;

	doctorSupplement: number | undefined = undefined;

	conventionAmount: number | undefined = undefined;

	vat: number | undefined = undefined;

	error: string | undefined = undefined;

	contract: string | undefined = undefined;

	contractDate: number | undefined = undefined;

	units: number | undefined = undefined;

	side: number | undefined = undefined;

	timeOfDay: number | undefined = undefined;

	eidReadingHour: number | undefined = undefined;

	eidReadingValue: string | undefined = undefined;

	override3rdPayerCode: number | undefined = undefined;

	override3rdPayerReason: string | undefined = undefined;

	transplantationCode: number | undefined = undefined;

	prescriberNorm: number | undefined = undefined;

	productLabel: string | undefined = undefined;

	percentNorm: number | undefined = undefined;

	prescriberNihii: string | undefined = undefined;

	relatedCode: string | undefined = undefined;

	prescriptionDate: number | undefined = undefined;

	derogationMaxNumber: number | undefined = undefined;

	prescriberSsin: string | undefined = undefined;

	prescriberLastName: string | undefined = undefined;

	prescriberFirstName: string | undefined = undefined;

	prescriberCdHcParty: string | undefined = undefined;

	locationNihii: string | undefined = undefined;

	locationCdHcParty: string | undefined = undefined;

	locationService: number | undefined = undefined;

	admissionDate: number | undefined = undefined;

	canceled: boolean | undefined = undefined;

	accepted: boolean | undefined = undefined;

	pending: boolean | undefined = undefined;

	resent: boolean | undefined = undefined;

	archived: boolean | undefined = undefined;

	lost: boolean | undefined = undefined;

	insuranceJustification: number | undefined = undefined;

	cancelPatientInterventionReason: number | undefined = undefined;

	status: number | undefined = undefined;

	codeLabel: string | undefined = undefined;

	options: { [ key: string ]: string } = {};

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
		if ('tarificationId' in partial) this.tarificationId = partial.tarificationId;
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

}

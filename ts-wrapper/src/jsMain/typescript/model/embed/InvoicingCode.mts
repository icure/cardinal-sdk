// auto-generated file
import {expectBoolean, expectMap, expectNumber, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id ?? null
		if (this.dateCode != undefined) res['dateCode'] = this.dateCode
		if (this.logicalId != undefined) res['logicalId'] = this.logicalId
		if (this.label != undefined) res['label'] = this.label
		if (this.userId != undefined) res['userId'] = this.userId
		if (this.contactId != undefined) res['contactId'] = this.contactId
		if (this.serviceId != undefined) res['serviceId'] = this.serviceId
		if (this.tarificationId != undefined) res['tarificationId'] = this.tarificationId
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
			tarificationId: expectString(extractEntry(jCpy, 'tarificationId', false, path), true, [...path, ".tarificationId"]),
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
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedInvoicingCode at path ${path.join("")}: ${unused}`)}
		return res
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

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id ?? null
		if (this.dateCode != undefined) res['dateCode'] = this.dateCode
		if (this.logicalId != undefined) res['logicalId'] = this.logicalId
		if (this.label != undefined) res['label'] = this.label
		if (this.userId != undefined) res['userId'] = this.userId
		if (this.contactId != undefined) res['contactId'] = this.contactId
		if (this.serviceId != undefined) res['serviceId'] = this.serviceId
		if (this.tarificationId != undefined) res['tarificationId'] = this.tarificationId
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
			tarificationId: expectString(extractEntry(jCpy, 'tarificationId', false, path), true, [...path, ".tarificationId"]),
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
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedInvoicingCode at path ${path.join("")}: ${unused}`)}
		return res
	}

}

// auto-generated file
import {expectArray, expectBoolean, expectMap, expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {DecryptedAddress} from './Address.mjs';
import {Duration} from './Duration.mjs';
import {Medicinalproduct} from './Medicinalproduct.mjs';
import {ParagraphAgreement} from './ParagraphAgreement.mjs';
import {RegimenItem} from './RegimenItem.mjs';
import {Renewal} from './Renewal.mjs';
import {Substanceproduct} from './Substanceproduct.mjs';
import {Suspension} from './Suspension.mjs';


export class Medication {

	compoundPrescription: string | undefined = undefined;

	substanceProduct: Substanceproduct | undefined = undefined;

	medicinalProduct: Medicinalproduct | undefined = undefined;

	numberOfPackages: number | undefined = undefined;

	batch: string | undefined = undefined;

	expirationDate: number | undefined = undefined;

	instructionForPatient: string | undefined = undefined;

	instructionForReimbursement: string | undefined = undefined;

	commentForDelivery: string | undefined = undefined;

	drugRoute: string | undefined = undefined;

	temporality: string | undefined = undefined;

	frequency: CodeStub | undefined = undefined;

	reimbursementReason: CodeStub | undefined = undefined;

	substitutionAllowed: boolean | undefined = undefined;

	beginMoment: number | undefined = undefined;

	endMoment: number | undefined = undefined;

	deliveryMoment: number | undefined = undefined;

	endExecutionMoment: number | undefined = undefined;

	duration: Duration | undefined = undefined;

	renewal: Renewal | undefined = undefined;

	knownUsage: boolean | undefined = undefined;

	regimen: Array<RegimenItem> | undefined = undefined;

	posology: string | undefined = undefined;

	agreements: { [ key: string ]: ParagraphAgreement } | undefined = undefined;

	medicationSchemeIdOnSafe: string | undefined = undefined;

	medicationSchemeSafeVersion: number | undefined = undefined;

	medicationSchemeTimeStampOnSafe: number | undefined = undefined;

	medicationSchemeDocumentId: string | undefined = undefined;

	safeIdName: string | undefined = undefined;

	idOnSafes: string | undefined = undefined;

	timestampOnSafe: number | undefined = undefined;

	changeValidated: boolean | undefined = undefined;

	newSafeMedication: boolean | undefined = undefined;

	medicationUse: string | undefined = undefined;

	beginCondition: string | undefined = undefined;

	endCondition: string | undefined = undefined;

	origin: string | undefined = undefined;

	medicationChanged: boolean | undefined = undefined;

	posologyChanged: boolean | undefined = undefined;

	suspension: Array<Suspension> | undefined = undefined;

	prescriptionRID: string | undefined = undefined;

	status: number | undefined = undefined;

	stockLocation: DecryptedAddress | undefined = undefined;

	constructor(partial: Partial<Medication>) {
		if ('compoundPrescription' in partial) this.compoundPrescription = partial.compoundPrescription;
		if ('substanceProduct' in partial) this.substanceProduct = partial.substanceProduct;
		if ('medicinalProduct' in partial) this.medicinalProduct = partial.medicinalProduct;
		if ('numberOfPackages' in partial) this.numberOfPackages = partial.numberOfPackages;
		if ('batch' in partial) this.batch = partial.batch;
		if ('expirationDate' in partial) this.expirationDate = partial.expirationDate;
		if ('instructionForPatient' in partial) this.instructionForPatient = partial.instructionForPatient;
		if ('instructionForReimbursement' in partial) this.instructionForReimbursement = partial.instructionForReimbursement;
		if ('commentForDelivery' in partial) this.commentForDelivery = partial.commentForDelivery;
		if ('drugRoute' in partial) this.drugRoute = partial.drugRoute;
		if ('temporality' in partial) this.temporality = partial.temporality;
		if ('frequency' in partial) this.frequency = partial.frequency;
		if ('reimbursementReason' in partial) this.reimbursementReason = partial.reimbursementReason;
		if ('substitutionAllowed' in partial) this.substitutionAllowed = partial.substitutionAllowed;
		if ('beginMoment' in partial) this.beginMoment = partial.beginMoment;
		if ('endMoment' in partial) this.endMoment = partial.endMoment;
		if ('deliveryMoment' in partial) this.deliveryMoment = partial.deliveryMoment;
		if ('endExecutionMoment' in partial) this.endExecutionMoment = partial.endExecutionMoment;
		if ('duration' in partial) this.duration = partial.duration;
		if ('renewal' in partial) this.renewal = partial.renewal;
		if ('knownUsage' in partial) this.knownUsage = partial.knownUsage;
		if ('regimen' in partial) this.regimen = partial.regimen;
		if ('posology' in partial) this.posology = partial.posology;
		if ('agreements' in partial) this.agreements = partial.agreements;
		if ('medicationSchemeIdOnSafe' in partial) this.medicationSchemeIdOnSafe = partial.medicationSchemeIdOnSafe;
		if ('medicationSchemeSafeVersion' in partial) this.medicationSchemeSafeVersion = partial.medicationSchemeSafeVersion;
		if ('medicationSchemeTimeStampOnSafe' in partial) this.medicationSchemeTimeStampOnSafe = partial.medicationSchemeTimeStampOnSafe;
		if ('medicationSchemeDocumentId' in partial) this.medicationSchemeDocumentId = partial.medicationSchemeDocumentId;
		if ('safeIdName' in partial) this.safeIdName = partial.safeIdName;
		if ('idOnSafes' in partial) this.idOnSafes = partial.idOnSafes;
		if ('timestampOnSafe' in partial) this.timestampOnSafe = partial.timestampOnSafe;
		if ('changeValidated' in partial) this.changeValidated = partial.changeValidated;
		if ('newSafeMedication' in partial) this.newSafeMedication = partial.newSafeMedication;
		if ('medicationUse' in partial) this.medicationUse = partial.medicationUse;
		if ('beginCondition' in partial) this.beginCondition = partial.beginCondition;
		if ('endCondition' in partial) this.endCondition = partial.endCondition;
		if ('origin' in partial) this.origin = partial.origin;
		if ('medicationChanged' in partial) this.medicationChanged = partial.medicationChanged;
		if ('posologyChanged' in partial) this.posologyChanged = partial.posologyChanged;
		if ('suspension' in partial) this.suspension = partial.suspension;
		if ('prescriptionRID' in partial) this.prescriptionRID = partial.prescriptionRID;
		if ('status' in partial) this.status = partial.status;
		if ('stockLocation' in partial) this.stockLocation = partial.stockLocation;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.compoundPrescription != undefined) res['compoundPrescription'] = this.compoundPrescription
		if (this.substanceProduct != undefined) res['substanceProduct'] = this.substanceProduct.toJSON()
		if (this.medicinalProduct != undefined) res['medicinalProduct'] = this.medicinalProduct.toJSON()
		if (this.numberOfPackages != undefined) res['numberOfPackages'] = this.numberOfPackages
		if (this.batch != undefined) res['batch'] = this.batch
		if (this.expirationDate != undefined) res['expirationDate'] = this.expirationDate
		if (this.instructionForPatient != undefined) res['instructionForPatient'] = this.instructionForPatient
		if (this.instructionForReimbursement != undefined) res['instructionForReimbursement'] = this.instructionForReimbursement
		if (this.commentForDelivery != undefined) res['commentForDelivery'] = this.commentForDelivery
		if (this.drugRoute != undefined) res['drugRoute'] = this.drugRoute
		if (this.temporality != undefined) res['temporality'] = this.temporality
		if (this.frequency != undefined) res['frequency'] = this.frequency.toJSON()
		if (this.reimbursementReason != undefined) res['reimbursementReason'] = this.reimbursementReason.toJSON()
		if (this.substitutionAllowed != undefined) res['substitutionAllowed'] = this.substitutionAllowed
		if (this.beginMoment != undefined) res['beginMoment'] = this.beginMoment
		if (this.endMoment != undefined) res['endMoment'] = this.endMoment
		if (this.deliveryMoment != undefined) res['deliveryMoment'] = this.deliveryMoment
		if (this.endExecutionMoment != undefined) res['endExecutionMoment'] = this.endExecutionMoment
		if (this.duration != undefined) res['duration'] = this.duration.toJSON()
		if (this.renewal != undefined) res['renewal'] = this.renewal.toJSON()
		if (this.knownUsage != undefined) res['knownUsage'] = this.knownUsage
		if (this.regimen != undefined) res['regimen'] = this.regimen.map((x0) => x0.toJSON() )
		if (this.posology != undefined) res['posology'] = this.posology
		if (this.agreements != undefined) res['agreements'] = Object.fromEntries(Object.entries(this.agreements).map(([k0, v0]) => [k0, v0.toJSON()]))
		if (this.medicationSchemeIdOnSafe != undefined) res['medicationSchemeIdOnSafe'] = this.medicationSchemeIdOnSafe
		if (this.medicationSchemeSafeVersion != undefined) res['medicationSchemeSafeVersion'] = this.medicationSchemeSafeVersion
		if (this.medicationSchemeTimeStampOnSafe != undefined) res['medicationSchemeTimeStampOnSafe'] = this.medicationSchemeTimeStampOnSafe
		if (this.medicationSchemeDocumentId != undefined) res['medicationSchemeDocumentId'] = this.medicationSchemeDocumentId
		if (this.safeIdName != undefined) res['safeIdName'] = this.safeIdName
		if (this.idOnSafes != undefined) res['idOnSafes'] = this.idOnSafes
		if (this.timestampOnSafe != undefined) res['timestampOnSafe'] = this.timestampOnSafe
		if (this.changeValidated != undefined) res['changeValidated'] = this.changeValidated
		if (this.newSafeMedication != undefined) res['newSafeMedication'] = this.newSafeMedication
		if (this.medicationUse != undefined) res['medicationUse'] = this.medicationUse
		if (this.beginCondition != undefined) res['beginCondition'] = this.beginCondition
		if (this.endCondition != undefined) res['endCondition'] = this.endCondition
		if (this.origin != undefined) res['origin'] = this.origin
		if (this.medicationChanged != undefined) res['medicationChanged'] = this.medicationChanged
		if (this.posologyChanged != undefined) res['posologyChanged'] = this.posologyChanged
		if (this.suspension != undefined) res['suspension'] = this.suspension.map((x0) => x0.toJSON() )
		if (this.prescriptionRID != undefined) res['prescriptionRID'] = this.prescriptionRID
		if (this.status != undefined) res['status'] = this.status
		if (this.stockLocation != undefined) res['stockLocation'] = this.stockLocation.toJSON()
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Medication']): Medication {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Medication({
			compoundPrescription: expectString(extractEntry(jCpy.compoundPrescription, 'compoundPrescription', false, path), true, [...path, ".compoundPrescription"]),
			substanceProduct: expectObject(extractEntry(jCpy.substanceProduct, 'substanceProduct', false, path), true, ignoreUnknownKeys, [...path, ".substanceProduct"], Substanceproduct.fromJSON),
			medicinalProduct: expectObject(extractEntry(jCpy.medicinalProduct, 'medicinalProduct', false, path), true, ignoreUnknownKeys, [...path, ".medicinalProduct"], Medicinalproduct.fromJSON),
			numberOfPackages: expectNumber(extractEntry(jCpy.numberOfPackages, 'numberOfPackages', false, path), true, true, [...path, ".numberOfPackages"]),
			batch: expectString(extractEntry(jCpy.batch, 'batch', false, path), true, [...path, ".batch"]),
			expirationDate: expectNumber(extractEntry(jCpy.expirationDate, 'expirationDate', false, path), true, true, [...path, ".expirationDate"]),
			instructionForPatient: expectString(extractEntry(jCpy.instructionForPatient, 'instructionForPatient', false, path), true, [...path, ".instructionForPatient"]),
			instructionForReimbursement: expectString(extractEntry(jCpy.instructionForReimbursement, 'instructionForReimbursement', false, path), true, [...path, ".instructionForReimbursement"]),
			commentForDelivery: expectString(extractEntry(jCpy.commentForDelivery, 'commentForDelivery', false, path), true, [...path, ".commentForDelivery"]),
			drugRoute: expectString(extractEntry(jCpy.drugRoute, 'drugRoute', false, path), true, [...path, ".drugRoute"]),
			temporality: expectString(extractEntry(jCpy.temporality, 'temporality', false, path), true, [...path, ".temporality"]),
			frequency: expectObject(extractEntry(jCpy.frequency, 'frequency', false, path), true, ignoreUnknownKeys, [...path, ".frequency"], CodeStub.fromJSON),
			reimbursementReason: expectObject(extractEntry(jCpy.reimbursementReason, 'reimbursementReason', false, path), true, ignoreUnknownKeys, [...path, ".reimbursementReason"], CodeStub.fromJSON),
			substitutionAllowed: expectBoolean(extractEntry(jCpy.substitutionAllowed, 'substitutionAllowed', false, path), true, [...path, ".substitutionAllowed"]),
			beginMoment: expectNumber(extractEntry(jCpy.beginMoment, 'beginMoment', false, path), true, true, [...path, ".beginMoment"]),
			endMoment: expectNumber(extractEntry(jCpy.endMoment, 'endMoment', false, path), true, true, [...path, ".endMoment"]),
			deliveryMoment: expectNumber(extractEntry(jCpy.deliveryMoment, 'deliveryMoment', false, path), true, true, [...path, ".deliveryMoment"]),
			endExecutionMoment: expectNumber(extractEntry(jCpy.endExecutionMoment, 'endExecutionMoment', false, path), true, true, [...path, ".endExecutionMoment"]),
			duration: expectObject(extractEntry(jCpy.duration, 'duration', false, path), true, ignoreUnknownKeys, [...path, ".duration"], Duration.fromJSON),
			renewal: expectObject(extractEntry(jCpy.renewal, 'renewal', false, path), true, ignoreUnknownKeys, [...path, ".renewal"], Renewal.fromJSON),
			knownUsage: expectBoolean(extractEntry(jCpy.knownUsage, 'knownUsage', false, path), true, [...path, ".knownUsage"]),
			regimen: expectArray(extractEntry(jCpy.regimen, 'regimen', false, path), true, [...path, ".regimen"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, RegimenItem.fromJSON)),
			posology: expectString(extractEntry(jCpy.posology, 'posology', false, path), true, [...path, ".posology"]),
			agreements: expectMap(
				extractEntry(jCpy.agreements, 'agreements', false, path),
				true,
				[...path, ".agreements"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectObject(v0, false, ignoreUnknownKeys, p0, ParagraphAgreement.fromJSON)
			),
			medicationSchemeIdOnSafe: expectString(extractEntry(jCpy.medicationSchemeIdOnSafe, 'medicationSchemeIdOnSafe', false, path), true, [...path, ".medicationSchemeIdOnSafe"]),
			medicationSchemeSafeVersion: expectNumber(extractEntry(jCpy.medicationSchemeSafeVersion, 'medicationSchemeSafeVersion', false, path), true, true, [...path, ".medicationSchemeSafeVersion"]),
			medicationSchemeTimeStampOnSafe: expectNumber(extractEntry(jCpy.medicationSchemeTimeStampOnSafe, 'medicationSchemeTimeStampOnSafe', false, path), true, true, [...path, ".medicationSchemeTimeStampOnSafe"]),
			medicationSchemeDocumentId: expectString(extractEntry(jCpy.medicationSchemeDocumentId, 'medicationSchemeDocumentId', false, path), true, [...path, ".medicationSchemeDocumentId"]),
			safeIdName: expectString(extractEntry(jCpy.safeIdName, 'safeIdName', false, path), true, [...path, ".safeIdName"]),
			idOnSafes: expectString(extractEntry(jCpy.idOnSafes, 'idOnSafes', false, path), true, [...path, ".idOnSafes"]),
			timestampOnSafe: expectNumber(extractEntry(jCpy.timestampOnSafe, 'timestampOnSafe', false, path), true, true, [...path, ".timestampOnSafe"]),
			changeValidated: expectBoolean(extractEntry(jCpy.changeValidated, 'changeValidated', false, path), true, [...path, ".changeValidated"]),
			newSafeMedication: expectBoolean(extractEntry(jCpy.newSafeMedication, 'newSafeMedication', false, path), true, [...path, ".newSafeMedication"]),
			medicationUse: expectString(extractEntry(jCpy.medicationUse, 'medicationUse', false, path), true, [...path, ".medicationUse"]),
			beginCondition: expectString(extractEntry(jCpy.beginCondition, 'beginCondition', false, path), true, [...path, ".beginCondition"]),
			endCondition: expectString(extractEntry(jCpy.endCondition, 'endCondition', false, path), true, [...path, ".endCondition"]),
			origin: expectString(extractEntry(jCpy.origin, 'origin', false, path), true, [...path, ".origin"]),
			medicationChanged: expectBoolean(extractEntry(jCpy.medicationChanged, 'medicationChanged', false, path), true, [...path, ".medicationChanged"]),
			posologyChanged: expectBoolean(extractEntry(jCpy.posologyChanged, 'posologyChanged', false, path), true, [...path, ".posologyChanged"]),
			suspension: expectArray(extractEntry(jCpy.suspension, 'suspension', false, path), true, [...path, ".suspension"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Suspension.fromJSON)),
			prescriptionRID: expectString(extractEntry(jCpy.prescriptionRID, 'prescriptionRID', false, path), true, [...path, ".prescriptionRID"]),
			status: expectNumber(extractEntry(jCpy.status, 'status', false, path), true, true, [...path, ".status"]),
			stockLocation: expectObject(extractEntry(jCpy.stockLocation, 'stockLocation', false, path), true, ignoreUnknownKeys, [...path, ".stockLocation"], DecryptedAddress.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Medication at path ${path.join("")}: ${unused}`)}
		return res
	}

}

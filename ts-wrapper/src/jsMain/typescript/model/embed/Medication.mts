// auto-generated file
import {expectArray, expectBoolean, expectNumber, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {DecryptedAddress} from './Address.mjs';
import {Duration} from './Duration.mjs';
import {Medicinalproduct} from './Medicinalproduct.mjs';
import {RegimenItem} from './RegimenItem.mjs';
import {Renewal} from './Renewal.mjs';
import {Substanceproduct} from './Substanceproduct.mjs';


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
		if ('stockLocation' in partial) this.stockLocation = partial.stockLocation;
	}

	toJSON(): object {
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
		if (this.stockLocation != undefined) res['stockLocation'] = this.stockLocation.toJSON()
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Medication']): Medication {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Medication({
			compoundPrescription: expectString(extractEntry(jCpy, 'compoundPrescription', false, path), true, [...path, ".compoundPrescription"]),
			substanceProduct: expectObject(extractEntry(jCpy, 'substanceProduct', false, path), true, ignoreUnknownKeys, [...path, ".substanceProduct"], Substanceproduct.fromJSON),
			medicinalProduct: expectObject(extractEntry(jCpy, 'medicinalProduct', false, path), true, ignoreUnknownKeys, [...path, ".medicinalProduct"], Medicinalproduct.fromJSON),
			numberOfPackages: expectNumber(extractEntry(jCpy, 'numberOfPackages', false, path), true, true, [...path, ".numberOfPackages"]),
			batch: expectString(extractEntry(jCpy, 'batch', false, path), true, [...path, ".batch"]),
			expirationDate: expectNumber(extractEntry(jCpy, 'expirationDate', false, path), true, true, [...path, ".expirationDate"]),
			instructionForPatient: expectString(extractEntry(jCpy, 'instructionForPatient', false, path), true, [...path, ".instructionForPatient"]),
			instructionForReimbursement: expectString(extractEntry(jCpy, 'instructionForReimbursement', false, path), true, [...path, ".instructionForReimbursement"]),
			commentForDelivery: expectString(extractEntry(jCpy, 'commentForDelivery', false, path), true, [...path, ".commentForDelivery"]),
			drugRoute: expectString(extractEntry(jCpy, 'drugRoute', false, path), true, [...path, ".drugRoute"]),
			temporality: expectString(extractEntry(jCpy, 'temporality', false, path), true, [...path, ".temporality"]),
			frequency: expectObject(extractEntry(jCpy, 'frequency', false, path), true, ignoreUnknownKeys, [...path, ".frequency"], CodeStub.fromJSON),
			reimbursementReason: expectObject(extractEntry(jCpy, 'reimbursementReason', false, path), true, ignoreUnknownKeys, [...path, ".reimbursementReason"], CodeStub.fromJSON),
			substitutionAllowed: expectBoolean(extractEntry(jCpy, 'substitutionAllowed', false, path), true, [...path, ".substitutionAllowed"]),
			beginMoment: expectNumber(extractEntry(jCpy, 'beginMoment', false, path), true, true, [...path, ".beginMoment"]),
			endMoment: expectNumber(extractEntry(jCpy, 'endMoment', false, path), true, true, [...path, ".endMoment"]),
			deliveryMoment: expectNumber(extractEntry(jCpy, 'deliveryMoment', false, path), true, true, [...path, ".deliveryMoment"]),
			endExecutionMoment: expectNumber(extractEntry(jCpy, 'endExecutionMoment', false, path), true, true, [...path, ".endExecutionMoment"]),
			duration: expectObject(extractEntry(jCpy, 'duration', false, path), true, ignoreUnknownKeys, [...path, ".duration"], Duration.fromJSON),
			renewal: expectObject(extractEntry(jCpy, 'renewal', false, path), true, ignoreUnknownKeys, [...path, ".renewal"], Renewal.fromJSON),
			knownUsage: expectBoolean(extractEntry(jCpy, 'knownUsage', false, path), true, [...path, ".knownUsage"]),
			regimen: expectArray(extractEntry(jCpy, 'regimen', false, path), true, [...path, ".regimen"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, RegimenItem.fromJSON)),
			posology: expectString(extractEntry(jCpy, 'posology', false, path), true, [...path, ".posology"]),
			stockLocation: expectObject(extractEntry(jCpy, 'stockLocation', false, path), true, ignoreUnknownKeys, [...path, ".stockLocation"], DecryptedAddress.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Medication at path ${path.join("")}: ${unused}`)}
		return res
	}

}

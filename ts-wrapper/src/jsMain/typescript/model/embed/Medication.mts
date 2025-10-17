// auto-generated file
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

}

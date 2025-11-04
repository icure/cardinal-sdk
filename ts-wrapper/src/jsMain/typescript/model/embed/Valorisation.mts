// auto-generated file
import {expectArray, expectMap, expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';


export interface Valorisation extends Encryptable {

	startOfValidity: number | undefined;

	endOfValidity: number | undefined;

	predicate: string | undefined;

	reference: Array<number> | undefined;

	totalAmount: number | undefined;

	reimbursement: number | undefined;

	patientIntervention: number | undefined;

	doctorSupplement: number | undefined;

	vat: number | undefined;

	label: { [ key: string ]: string } | undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedValorisation {

	startOfValidity: number | undefined = undefined;

	endOfValidity: number | undefined = undefined;

	predicate: string | undefined = undefined;

	reference: Array<number> | undefined = undefined;

	totalAmount: number | undefined = undefined;

	reimbursement: number | undefined = undefined;

	patientIntervention: number | undefined = undefined;

	doctorSupplement: number | undefined = undefined;

	vat: number | undefined = undefined;

	label: { [ key: string ]: string } | undefined = {};

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedValorisation>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('startOfValidity' in partial) this.startOfValidity = partial.startOfValidity;
		if ('endOfValidity' in partial) this.endOfValidity = partial.endOfValidity;
		if ('predicate' in partial) this.predicate = partial.predicate;
		if ('reference' in partial) this.reference = partial.reference;
		if ('totalAmount' in partial) this.totalAmount = partial.totalAmount;
		if ('reimbursement' in partial) this.reimbursement = partial.reimbursement;
		if ('patientIntervention' in partial) this.patientIntervention = partial.patientIntervention;
		if ('doctorSupplement' in partial) this.doctorSupplement = partial.doctorSupplement;
		if ('vat' in partial) this.vat = partial.vat;
		if ('label' in partial) this.label = partial.label;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.startOfValidity != undefined) res['startOfValidity'] = this.startOfValidity
		if (this.endOfValidity != undefined) res['endOfValidity'] = this.endOfValidity
		if (this.predicate != undefined) res['predicate'] = this.predicate
		if (this.reference != undefined) res['reference'] = this.reference.map((x0) => x0 )
		if (this.totalAmount != undefined) res['totalAmount'] = this.totalAmount
		if (this.reimbursement != undefined) res['reimbursement'] = this.reimbursement
		if (this.patientIntervention != undefined) res['patientIntervention'] = this.patientIntervention
		if (this.doctorSupplement != undefined) res['doctorSupplement'] = this.doctorSupplement
		if (this.vat != undefined) res['vat'] = this.vat
		if (this.label != undefined) res['label'] = Object.fromEntries(Object.entries(this.label).map(([k0, v0]) => [k0, v0]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['DecryptedValorisation']): DecryptedValorisation {
		return new DecryptedValorisation({
			startOfValidity: expectNumber(json.startOfValidity, true, true, [...path, ".startOfValidity"]),
			endOfValidity: expectNumber(json.endOfValidity, true, true, [...path, ".endOfValidity"]),
			predicate: expectString(json.predicate, true, [...path, ".predicate"]),
			reference: expectArray(json.reference, true, [...path, ".reference"], (x0, p0) => expectNumber(x0, false, true, p0)),
			totalAmount: expectNumber(json.totalAmount, true, false, [...path, ".totalAmount"]),
			reimbursement: expectNumber(json.reimbursement, true, false, [...path, ".reimbursement"]),
			patientIntervention: expectNumber(json.patientIntervention, true, false, [...path, ".patientIntervention"]),
			doctorSupplement: expectNumber(json.doctorSupplement, true, false, [...path, ".doctorSupplement"]),
			vat: expectNumber(json.vat, true, false, [...path, ".vat"]),
			label: expectMap(
				json.label,
				true,
				[...path, ".label"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}

export class EncryptedValorisation {

	startOfValidity: number | undefined = undefined;

	endOfValidity: number | undefined = undefined;

	predicate: string | undefined = undefined;

	reference: Array<number> | undefined = undefined;

	totalAmount: number | undefined = undefined;

	reimbursement: number | undefined = undefined;

	patientIntervention: number | undefined = undefined;

	doctorSupplement: number | undefined = undefined;

	vat: number | undefined = undefined;

	label: { [ key: string ]: string } | undefined = {};

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedValorisation>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('startOfValidity' in partial) this.startOfValidity = partial.startOfValidity;
		if ('endOfValidity' in partial) this.endOfValidity = partial.endOfValidity;
		if ('predicate' in partial) this.predicate = partial.predicate;
		if ('reference' in partial) this.reference = partial.reference;
		if ('totalAmount' in partial) this.totalAmount = partial.totalAmount;
		if ('reimbursement' in partial) this.reimbursement = partial.reimbursement;
		if ('patientIntervention' in partial) this.patientIntervention = partial.patientIntervention;
		if ('doctorSupplement' in partial) this.doctorSupplement = partial.doctorSupplement;
		if ('vat' in partial) this.vat = partial.vat;
		if ('label' in partial) this.label = partial.label;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.startOfValidity != undefined) res['startOfValidity'] = this.startOfValidity
		if (this.endOfValidity != undefined) res['endOfValidity'] = this.endOfValidity
		if (this.predicate != undefined) res['predicate'] = this.predicate
		if (this.reference != undefined) res['reference'] = this.reference.map((x0) => x0 )
		if (this.totalAmount != undefined) res['totalAmount'] = this.totalAmount
		if (this.reimbursement != undefined) res['reimbursement'] = this.reimbursement
		if (this.patientIntervention != undefined) res['patientIntervention'] = this.patientIntervention
		if (this.doctorSupplement != undefined) res['doctorSupplement'] = this.doctorSupplement
		if (this.vat != undefined) res['vat'] = this.vat
		if (this.label != undefined) res['label'] = Object.fromEntries(Object.entries(this.label).map(([k0, v0]) => [k0, v0]))
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['EncryptedValorisation']): EncryptedValorisation {
		return new EncryptedValorisation({
			startOfValidity: expectNumber(json.startOfValidity, true, true, [...path, ".startOfValidity"]),
			endOfValidity: expectNumber(json.endOfValidity, true, true, [...path, ".endOfValidity"]),
			predicate: expectString(json.predicate, true, [...path, ".predicate"]),
			reference: expectArray(json.reference, true, [...path, ".reference"], (x0, p0) => expectNumber(x0, false, true, p0)),
			totalAmount: expectNumber(json.totalAmount, true, false, [...path, ".totalAmount"]),
			reimbursement: expectNumber(json.reimbursement, true, false, [...path, ".reimbursement"]),
			patientIntervention: expectNumber(json.patientIntervention, true, false, [...path, ".patientIntervention"]),
			doctorSupplement: expectNumber(json.doctorSupplement, true, false, [...path, ".doctorSupplement"]),
			vat: expectNumber(json.vat, true, false, [...path, ".vat"]),
			label: expectMap(
				json.label,
				true,
				[...path, ".label"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}

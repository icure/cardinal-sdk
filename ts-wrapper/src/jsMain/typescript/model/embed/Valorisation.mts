// auto-generated file
import {expectArray, expectMap, expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
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
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedValorisation']): DecryptedValorisation {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedValorisation`)
		const res = new DecryptedValorisation({
			startOfValidity: expectNumber(extractEntry(jCpy, 'startOfValidity', false, path), true, true, [...path, ".startOfValidity"]),
			endOfValidity: expectNumber(extractEntry(jCpy, 'endOfValidity', false, path), true, true, [...path, ".endOfValidity"]),
			predicate: expectString(extractEntry(jCpy, 'predicate', false, path), true, [...path, ".predicate"]),
			reference: expectArray(extractEntry(jCpy, 'reference', false, path), true, [...path, ".reference"], (x0, p0) => expectNumber(x0, false, true, p0)),
			totalAmount: expectNumber(extractEntry(jCpy, 'totalAmount', false, path), true, false, [...path, ".totalAmount"]),
			reimbursement: expectNumber(extractEntry(jCpy, 'reimbursement', false, path), true, false, [...path, ".reimbursement"]),
			patientIntervention: expectNumber(extractEntry(jCpy, 'patientIntervention', false, path), true, false, [...path, ".patientIntervention"]),
			doctorSupplement: expectNumber(extractEntry(jCpy, 'doctorSupplement', false, path), true, false, [...path, ".doctorSupplement"]),
			vat: expectNumber(extractEntry(jCpy, 'vat', false, path), true, false, [...path, ".vat"]),
			label: expectMap(
				extractEntry(jCpy, 'label', false, path),
				true,
				[...path, ".label"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedValorisation at path ${path.join("")}: ${unused}`)}
		return res
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
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedValorisation']): EncryptedValorisation {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedValorisation`)
		const res = new EncryptedValorisation({
			startOfValidity: expectNumber(extractEntry(jCpy, 'startOfValidity', false, path), true, true, [...path, ".startOfValidity"]),
			endOfValidity: expectNumber(extractEntry(jCpy, 'endOfValidity', false, path), true, true, [...path, ".endOfValidity"]),
			predicate: expectString(extractEntry(jCpy, 'predicate', false, path), true, [...path, ".predicate"]),
			reference: expectArray(extractEntry(jCpy, 'reference', false, path), true, [...path, ".reference"], (x0, p0) => expectNumber(x0, false, true, p0)),
			totalAmount: expectNumber(extractEntry(jCpy, 'totalAmount', false, path), true, false, [...path, ".totalAmount"]),
			reimbursement: expectNumber(extractEntry(jCpy, 'reimbursement', false, path), true, false, [...path, ".reimbursement"]),
			patientIntervention: expectNumber(extractEntry(jCpy, 'patientIntervention', false, path), true, false, [...path, ".patientIntervention"]),
			doctorSupplement: expectNumber(extractEntry(jCpy, 'doctorSupplement', false, path), true, false, [...path, ".doctorSupplement"]),
			vat: expectNumber(extractEntry(jCpy, 'vat', false, path), true, false, [...path, ".vat"]),
			label: expectMap(
				extractEntry(jCpy, 'label', false, path),
				true,
				[...path, ".label"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedValorisation at path ${path.join("")}: ${unused}`)}
		return res
	}

}

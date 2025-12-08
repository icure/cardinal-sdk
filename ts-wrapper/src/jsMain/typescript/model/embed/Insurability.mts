// auto-generated file
import {expectBoolean, expectMap, expectNumber, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';


export interface Insurability extends Encryptable {

	parameters: { [ key: string ]: string };

	hospitalisation: boolean | undefined;

	ambulatory: boolean | undefined;

	dental: boolean | undefined;

	identificationNumber: string | undefined;

	insuranceId: string | undefined;

	startDate: number | undefined;

	endDate: number | undefined;

	titularyId: string | undefined;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

export class DecryptedInsurability {

	parameters: { [ key: string ]: string } = {};

	hospitalisation: boolean | undefined = undefined;

	ambulatory: boolean | undefined = undefined;

	dental: boolean | undefined = undefined;

	identificationNumber: string | undefined = undefined;

	insuranceId: string | undefined = undefined;

	startDate: number | undefined = undefined;

	endDate: number | undefined = undefined;

	titularyId: string | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedInsurability>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('parameters' in partial && partial.parameters !== undefined) this.parameters = partial.parameters;
		if ('hospitalisation' in partial) this.hospitalisation = partial.hospitalisation;
		if ('ambulatory' in partial) this.ambulatory = partial.ambulatory;
		if ('dental' in partial) this.dental = partial.dental;
		if ('identificationNumber' in partial) this.identificationNumber = partial.identificationNumber;
		if ('insuranceId' in partial) this.insuranceId = partial.insuranceId;
		if ('startDate' in partial) this.startDate = partial.startDate;
		if ('endDate' in partial) this.endDate = partial.endDate;
		if ('titularyId' in partial) this.titularyId = partial.titularyId;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['parameters'] = Object.fromEntries(Object.entries(this.parameters).map(([k0, v0]) => [k0, v0]))
		if (this.hospitalisation != undefined) res['hospitalisation'] = this.hospitalisation
		if (this.ambulatory != undefined) res['ambulatory'] = this.ambulatory
		if (this.dental != undefined) res['dental'] = this.dental
		if (this.identificationNumber != undefined) res['identificationNumber'] = this.identificationNumber
		if (this.insuranceId != undefined) res['insuranceId'] = this.insuranceId
		if (this.startDate != undefined) res['startDate'] = this.startDate
		if (this.endDate != undefined) res['endDate'] = this.endDate
		if (this.titularyId != undefined) res['titularyId'] = this.titularyId
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedInsurability']): DecryptedInsurability {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedInsurability`)
		const res = new DecryptedInsurability({
			parameters: expectMap(
				extractEntry(jCpy, 'parameters', false, path),
				false,
				[...path, ".parameters"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			hospitalisation: expectBoolean(extractEntry(jCpy, 'hospitalisation', false, path), true, [...path, ".hospitalisation"]),
			ambulatory: expectBoolean(extractEntry(jCpy, 'ambulatory', false, path), true, [...path, ".ambulatory"]),
			dental: expectBoolean(extractEntry(jCpy, 'dental', false, path), true, [...path, ".dental"]),
			identificationNumber: expectString(extractEntry(jCpy, 'identificationNumber', false, path), true, [...path, ".identificationNumber"]),
			insuranceId: expectString(extractEntry(jCpy, 'insuranceId', false, path), true, [...path, ".insuranceId"]),
			startDate: expectNumber(extractEntry(jCpy, 'startDate', false, path), true, true, [...path, ".startDate"]),
			endDate: expectNumber(extractEntry(jCpy, 'endDate', false, path), true, true, [...path, ".endDate"]),
			titularyId: expectString(extractEntry(jCpy, 'titularyId', false, path), true, [...path, ".titularyId"]),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedInsurability at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedInsurability {

	parameters: { [ key: string ]: string } = {};

	hospitalisation: boolean | undefined = undefined;

	ambulatory: boolean | undefined = undefined;

	dental: boolean | undefined = undefined;

	identificationNumber: string | undefined = undefined;

	insuranceId: string | undefined = undefined;

	startDate: number | undefined = undefined;

	endDate: number | undefined = undefined;

	titularyId: string | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedInsurability>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('parameters' in partial && partial.parameters !== undefined) this.parameters = partial.parameters;
		if ('hospitalisation' in partial) this.hospitalisation = partial.hospitalisation;
		if ('ambulatory' in partial) this.ambulatory = partial.ambulatory;
		if ('dental' in partial) this.dental = partial.dental;
		if ('identificationNumber' in partial) this.identificationNumber = partial.identificationNumber;
		if ('insuranceId' in partial) this.insuranceId = partial.insuranceId;
		if ('startDate' in partial) this.startDate = partial.startDate;
		if ('endDate' in partial) this.endDate = partial.endDate;
		if ('titularyId' in partial) this.titularyId = partial.titularyId;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['parameters'] = Object.fromEntries(Object.entries(this.parameters).map(([k0, v0]) => [k0, v0]))
		if (this.hospitalisation != undefined) res['hospitalisation'] = this.hospitalisation
		if (this.ambulatory != undefined) res['ambulatory'] = this.ambulatory
		if (this.dental != undefined) res['dental'] = this.dental
		if (this.identificationNumber != undefined) res['identificationNumber'] = this.identificationNumber
		if (this.insuranceId != undefined) res['insuranceId'] = this.insuranceId
		if (this.startDate != undefined) res['startDate'] = this.startDate
		if (this.endDate != undefined) res['endDate'] = this.endDate
		if (this.titularyId != undefined) res['titularyId'] = this.titularyId
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedInsurability']): EncryptedInsurability {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedInsurability`)
		const res = new EncryptedInsurability({
			parameters: expectMap(
				extractEntry(jCpy, 'parameters', false, path),
				false,
				[...path, ".parameters"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			hospitalisation: expectBoolean(extractEntry(jCpy, 'hospitalisation', false, path), true, [...path, ".hospitalisation"]),
			ambulatory: expectBoolean(extractEntry(jCpy, 'ambulatory', false, path), true, [...path, ".ambulatory"]),
			dental: expectBoolean(extractEntry(jCpy, 'dental', false, path), true, [...path, ".dental"]),
			identificationNumber: expectString(extractEntry(jCpy, 'identificationNumber', false, path), true, [...path, ".identificationNumber"]),
			insuranceId: expectString(extractEntry(jCpy, 'insuranceId', false, path), true, [...path, ".insuranceId"]),
			startDate: expectNumber(extractEntry(jCpy, 'startDate', false, path), true, true, [...path, ".startDate"]),
			endDate: expectNumber(extractEntry(jCpy, 'endDate', false, path), true, true, [...path, ".endDate"]),
			titularyId: expectString(extractEntry(jCpy, 'titularyId', false, path), true, [...path, ".titularyId"]),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedInsurability at path ${path.join("")}: ${unused}`)}
		return res
	}

}

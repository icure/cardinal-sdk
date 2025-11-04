// auto-generated file
import {expectBoolean, expectMap, expectNumber, expectString} from '../../internal/JsonDecodeUtils.mjs';
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

	toJSON(): any {
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
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['DecryptedInsurability']): DecryptedInsurability {
		return new DecryptedInsurability({
			parameters: expectMap(
				json.parameters,
				false,
				[...path, ".parameters"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			hospitalisation: expectBoolean(json.hospitalisation, true, [...path, ".hospitalisation"]),
			ambulatory: expectBoolean(json.ambulatory, true, [...path, ".ambulatory"]),
			dental: expectBoolean(json.dental, true, [...path, ".dental"]),
			identificationNumber: expectString(json.identificationNumber, true, [...path, ".identificationNumber"]),
			insuranceId: expectString(json.insuranceId, true, [...path, ".insuranceId"]),
			startDate: expectNumber(json.startDate, true, true, [...path, ".startDate"]),
			endDate: expectNumber(json.endDate, true, true, [...path, ".endDate"]),
			titularyId: expectString(json.titularyId, true, [...path, ".titularyId"]),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
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

	toJSON(): any {
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
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['EncryptedInsurability']): EncryptedInsurability {
		return new EncryptedInsurability({
			parameters: expectMap(
				json.parameters,
				false,
				[...path, ".parameters"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			hospitalisation: expectBoolean(json.hospitalisation, true, [...path, ".hospitalisation"]),
			ambulatory: expectBoolean(json.ambulatory, true, [...path, ".ambulatory"]),
			dental: expectBoolean(json.dental, true, [...path, ".dental"]),
			identificationNumber: expectString(json.identificationNumber, true, [...path, ".identificationNumber"]),
			insuranceId: expectString(json.insuranceId, true, [...path, ".insuranceId"]),
			startDate: expectNumber(json.startDate, true, true, [...path, ".startDate"]),
			endDate: expectNumber(json.endDate, true, true, [...path, ".endDate"]),
			titularyId: expectString(json.titularyId, true, [...path, ".titularyId"]),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}

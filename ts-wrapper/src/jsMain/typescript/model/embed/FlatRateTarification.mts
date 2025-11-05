// auto-generated file
import {expectArray, expectMap, expectObject, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';
import {FlatRateType} from './FlatRateType.mjs';
import {DecryptedValorisation, EncryptedValorisation, Valorisation} from './Valorisation.mjs';


export interface FlatRateTarification extends Encryptable {

	code: string | undefined;

	flatRateType: FlatRateType | undefined;

	label: { [ key: string ]: string } | undefined;

	valorisations: Array<Valorisation>;

	readonly isEncrypted: boolean;

}

export class DecryptedFlatRateTarification {

	code: string | undefined = undefined;

	flatRateType: FlatRateType | undefined = undefined;

	label: { [ key: string ]: string } | undefined = undefined;

	valorisations: Array<DecryptedValorisation> = [];

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedFlatRateTarification>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('code' in partial) this.code = partial.code;
		if ('flatRateType' in partial) this.flatRateType = partial.flatRateType;
		if ('label' in partial) this.label = partial.label;
		if ('valorisations' in partial && partial.valorisations !== undefined) this.valorisations = partial.valorisations;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.code != undefined) res['code'] = this.code
		if (this.flatRateType != undefined) res['flatRateType'] = this.flatRateType
		if (this.label != undefined) res['label'] = Object.fromEntries(Object.entries(this.label).map(([k0, v0]) => [k0, v0]))
		res['valorisations'] = this.valorisations.map((x0) => x0.toJSON() )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedFlatRateTarification']): DecryptedFlatRateTarification {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false`)
		const res = new DecryptedFlatRateTarification({
			code: expectString(extractEntry(jCpy, 'code', false, path), true, [...path, ".code"]),
			flatRateType: expectStringEnum(extractEntry(jCpy, 'flatRateType', false, path), true, [...path, ".flatRateType"], FlatRateType, 'FlatRateType'),
			label: expectMap(
				extractEntry(jCpy, 'label', false, path),
				true,
				[...path, ".label"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			valorisations: expectArray(extractEntry(jCpy, 'valorisations', false, path), false, [...path, ".valorisations"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedValorisation.fromJSON)),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), false, [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedFlatRateTarification at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedFlatRateTarification {

	code: string | undefined = undefined;

	flatRateType: FlatRateType | undefined = undefined;

	label: { [ key: string ]: string } | undefined = undefined;

	valorisations: Array<EncryptedValorisation> = [];

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedFlatRateTarification>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('code' in partial) this.code = partial.code;
		if ('flatRateType' in partial) this.flatRateType = partial.flatRateType;
		if ('label' in partial) this.label = partial.label;
		if ('valorisations' in partial && partial.valorisations !== undefined) this.valorisations = partial.valorisations;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.code != undefined) res['code'] = this.code
		if (this.flatRateType != undefined) res['flatRateType'] = this.flatRateType
		if (this.label != undefined) res['label'] = Object.fromEntries(Object.entries(this.label).map(([k0, v0]) => [k0, v0]))
		res['valorisations'] = this.valorisations.map((x0) => x0.toJSON() )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedFlatRateTarification']): EncryptedFlatRateTarification {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true`)
		const res = new EncryptedFlatRateTarification({
			code: expectString(extractEntry(jCpy, 'code', false, path), true, [...path, ".code"]),
			flatRateType: expectStringEnum(extractEntry(jCpy, 'flatRateType', false, path), true, [...path, ".flatRateType"], FlatRateType, 'FlatRateType'),
			label: expectMap(
				extractEntry(jCpy, 'label', false, path),
				true,
				[...path, ".label"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			valorisations: expectArray(extractEntry(jCpy, 'valorisations', false, path), false, [...path, ".valorisations"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedValorisation.fromJSON)),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), false, [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedFlatRateTarification at path ${path.join("")}: ${unused}`)}
		return res
	}

}

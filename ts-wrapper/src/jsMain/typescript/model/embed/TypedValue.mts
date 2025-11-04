// auto-generated file
import {expectBoolean, expectNumber, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {Encryptable} from './Encryptable.mjs';
import {TypedValuesType} from './TypedValuesType.mjs';


export interface TypedValue extends Encryptable {

	type: TypedValuesType | undefined;

	booleanValue: boolean | undefined;

	integerValue: number | undefined;

	doubleValue: number | undefined;

	stringValue: string | undefined;

	dateValue: number | undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedTypedValue {

	type: TypedValuesType | undefined = undefined;

	booleanValue: boolean | undefined = undefined;

	integerValue: number | undefined = undefined;

	doubleValue: number | undefined = undefined;

	stringValue: string | undefined = undefined;

	dateValue: number | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedTypedValue>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('type' in partial) this.type = partial.type;
		if ('booleanValue' in partial) this.booleanValue = partial.booleanValue;
		if ('integerValue' in partial) this.integerValue = partial.integerValue;
		if ('doubleValue' in partial) this.doubleValue = partial.doubleValue;
		if ('stringValue' in partial) this.stringValue = partial.stringValue;
		if ('dateValue' in partial) this.dateValue = partial.dateValue;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.type != undefined) res['type'] = this.type
		if (this.booleanValue != undefined) res['booleanValue'] = this.booleanValue
		if (this.integerValue != undefined) res['integerValue'] = this.integerValue
		if (this.doubleValue != undefined) res['doubleValue'] = this.doubleValue
		if (this.stringValue != undefined) res['stringValue'] = this.stringValue
		if (this.dateValue != undefined) res['dateValue'] = this.dateValue
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedTypedValue']): DecryptedTypedValue {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new DecryptedTypedValue({
			type: expectStringEnum(extractEntry(jCpy.type, 'type', false, path), true, [...path, ".type"], TypedValuesType, 'TypedValuesType'),
			booleanValue: expectBoolean(extractEntry(jCpy.booleanValue, 'booleanValue', false, path), true, [...path, ".booleanValue"]),
			integerValue: expectNumber(extractEntry(jCpy.integerValue, 'integerValue', false, path), true, true, [...path, ".integerValue"]),
			doubleValue: expectNumber(extractEntry(jCpy.doubleValue, 'doubleValue', false, path), true, false, [...path, ".doubleValue"]),
			stringValue: expectString(extractEntry(jCpy.stringValue, 'stringValue', false, path), true, [...path, ".stringValue"]),
			dateValue: expectNumber(extractEntry(jCpy.dateValue, 'dateValue', false, path), true, true, [...path, ".dateValue"]),
			encryptedSelf: expectString(extractEntry(jCpy.encryptedSelf, 'encryptedSelf', false, path), false, [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedTypedValue at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedTypedValue {

	type: TypedValuesType | undefined = undefined;

	booleanValue: boolean | undefined = undefined;

	integerValue: number | undefined = undefined;

	doubleValue: number | undefined = undefined;

	stringValue: string | undefined = undefined;

	dateValue: number | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedTypedValue>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('type' in partial) this.type = partial.type;
		if ('booleanValue' in partial) this.booleanValue = partial.booleanValue;
		if ('integerValue' in partial) this.integerValue = partial.integerValue;
		if ('doubleValue' in partial) this.doubleValue = partial.doubleValue;
		if ('stringValue' in partial) this.stringValue = partial.stringValue;
		if ('dateValue' in partial) this.dateValue = partial.dateValue;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.type != undefined) res['type'] = this.type
		if (this.booleanValue != undefined) res['booleanValue'] = this.booleanValue
		if (this.integerValue != undefined) res['integerValue'] = this.integerValue
		if (this.doubleValue != undefined) res['doubleValue'] = this.doubleValue
		if (this.stringValue != undefined) res['stringValue'] = this.stringValue
		if (this.dateValue != undefined) res['dateValue'] = this.dateValue
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedTypedValue']): EncryptedTypedValue {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new EncryptedTypedValue({
			type: expectStringEnum(extractEntry(jCpy.type, 'type', false, path), true, [...path, ".type"], TypedValuesType, 'TypedValuesType'),
			booleanValue: expectBoolean(extractEntry(jCpy.booleanValue, 'booleanValue', false, path), true, [...path, ".booleanValue"]),
			integerValue: expectNumber(extractEntry(jCpy.integerValue, 'integerValue', false, path), true, true, [...path, ".integerValue"]),
			doubleValue: expectNumber(extractEntry(jCpy.doubleValue, 'doubleValue', false, path), true, false, [...path, ".doubleValue"]),
			stringValue: expectString(extractEntry(jCpy.stringValue, 'stringValue', false, path), true, [...path, ".stringValue"]),
			dateValue: expectNumber(extractEntry(jCpy.dateValue, 'dateValue', false, path), true, true, [...path, ".dateValue"]),
			encryptedSelf: expectString(extractEntry(jCpy.encryptedSelf, 'encryptedSelf', false, path), false, [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedTypedValue at path ${path.join("")}: ${unused}`)}
		return res
	}

}

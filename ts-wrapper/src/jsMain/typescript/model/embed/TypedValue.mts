// auto-generated file
import {expectBoolean, expectNumber, expectString, expectStringEnum} from '../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, path: Array<string> = ['DecryptedTypedValue']): DecryptedTypedValue {
		return new DecryptedTypedValue({
			type: expectStringEnum(json.type, true, [...path, ".type"], TypedValuesType, 'TypedValuesType'),
			booleanValue: expectBoolean(json.booleanValue, true, [...path, ".booleanValue"]),
			integerValue: expectNumber(json.integerValue, true, true, [...path, ".integerValue"]),
			doubleValue: expectNumber(json.doubleValue, true, false, [...path, ".doubleValue"]),
			stringValue: expectString(json.stringValue, true, [...path, ".stringValue"]),
			dateValue: expectNumber(json.dateValue, true, true, [...path, ".dateValue"]),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
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

	static fromJSON(json: any, path: Array<string> = ['EncryptedTypedValue']): EncryptedTypedValue {
		return new EncryptedTypedValue({
			type: expectStringEnum(json.type, true, [...path, ".type"], TypedValuesType, 'TypedValuesType'),
			booleanValue: expectBoolean(json.booleanValue, true, [...path, ".booleanValue"]),
			integerValue: expectNumber(json.integerValue, true, true, [...path, ".integerValue"]),
			doubleValue: expectNumber(json.doubleValue, true, false, [...path, ".doubleValue"]),
			stringValue: expectString(json.stringValue, true, [...path, ".stringValue"]),
			dateValue: expectNumber(json.dateValue, true, true, [...path, ".dateValue"]),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}

// auto-generated file
import {expectNumber, expectString} from '../internal/JsonDecodeUtils.mjs';
import {PropertyTypeStub} from './PropertyTypeStub.mjs';
import {Encryptable} from './embed/Encryptable.mjs';
import {DecryptedTypedValue, EncryptedTypedValue, TypedValue} from './embed/TypedValue.mjs';
import {Base64String} from './specializations/Base64String.mjs';


export interface PropertyStub extends Encryptable {

	id: string | undefined;

	type: PropertyTypeStub | undefined;

	typedValue: TypedValue | undefined;

	deletionDate: number | undefined;

	readonly isEncrypted: boolean;

}

export class DecryptedPropertyStub {

	id: string | undefined = undefined;

	type: PropertyTypeStub | undefined = undefined;

	typedValue: DecryptedTypedValue | undefined = undefined;

	deletionDate: number | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedPropertyStub>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('id' in partial) this.id = partial.id;
		if ('type' in partial) this.type = partial.type;
		if ('typedValue' in partial) this.typedValue = partial.typedValue;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.id != undefined) res['id'] = this.id
		if (this.type != undefined) res['type'] = this.type.toJSON()
		if (this.typedValue != undefined) res['typedValue'] = this.typedValue.toJSON()
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['DecryptedPropertyStub']): DecryptedPropertyStub {
		return new DecryptedPropertyStub({
			id: expectString(json.id, true, [...path, ".id"]),
			type: PropertyTypeStub.fromJSON(json.type, [...path, ".type"]),
			typedValue: DecryptedTypedValue.fromJSON(json.typedValue, [...path, ".typedValue"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}

export class EncryptedPropertyStub {

	id: string | undefined = undefined;

	type: PropertyTypeStub | undefined = undefined;

	typedValue: EncryptedTypedValue | undefined = undefined;

	deletionDate: number | undefined = undefined;

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedPropertyStub>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('id' in partial) this.id = partial.id;
		if ('type' in partial) this.type = partial.type;
		if ('typedValue' in partial) this.typedValue = partial.typedValue;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.id != undefined) res['id'] = this.id
		if (this.type != undefined) res['type'] = this.type.toJSON()
		if (this.typedValue != undefined) res['typedValue'] = this.typedValue.toJSON()
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		return res
	}

	static fromJSON(json: any,
			path: Array<string> = ['EncryptedPropertyStub']): EncryptedPropertyStub {
		return new EncryptedPropertyStub({
			id: expectString(json.id, true, [...path, ".id"]),
			type: PropertyTypeStub.fromJSON(json.type, [...path, ".type"]),
			typedValue: EncryptedTypedValue.fromJSON(json.typedValue, [...path, ".typedValue"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}

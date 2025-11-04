// auto-generated file
import {expectNumber, expectObject, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedPropertyStub']): DecryptedPropertyStub {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new DecryptedPropertyStub({
			id: expectString(extractEntry(jCpy.id, 'id', false, path), true, [...path, ".id"]),
			type: expectObject(extractEntry(jCpy.type, 'type', false, path), true, ignoreUnknownKeys, [...path, ".type"], PropertyTypeStub.fromJSON),
			typedValue: expectObject(extractEntry(jCpy.typedValue, 'typedValue', false, path), true, ignoreUnknownKeys, [...path, ".typedValue"], DecryptedTypedValue.fromJSON),
			deletionDate: expectNumber(extractEntry(jCpy.deletionDate, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			encryptedSelf: expectString(extractEntry(jCpy.encryptedSelf, 'encryptedSelf', false, path), false, [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedPropertyStub at path ${path.join("")}: ${unused}`)}
		return res
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

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedPropertyStub']): EncryptedPropertyStub {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new EncryptedPropertyStub({
			id: expectString(extractEntry(jCpy.id, 'id', false, path), true, [...path, ".id"]),
			type: expectObject(extractEntry(jCpy.type, 'type', false, path), true, ignoreUnknownKeys, [...path, ".type"], PropertyTypeStub.fromJSON),
			typedValue: expectObject(extractEntry(jCpy.typedValue, 'typedValue', false, path), true, ignoreUnknownKeys, [...path, ".typedValue"], EncryptedTypedValue.fromJSON),
			deletionDate: expectNumber(extractEntry(jCpy.deletionDate, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			encryptedSelf: expectString(extractEntry(jCpy.encryptedSelf, 'encryptedSelf', false, path), false, [...path, ".encryptedSelf"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedPropertyStub at path ${path.join("")}: ${unused}`)}
		return res
	}

}

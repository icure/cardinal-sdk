// auto-generated file
import {expectArray, expectObject, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {CodeStub} from '../base/CodeStub.mjs';
import {HasCodes} from '../base/HasCodes.mjs';
import {HasTags} from '../base/HasTags.mjs';
import {Identifier} from '../base/Identifier.mjs';
import {Base64String} from '../specializations/Base64String.mjs';
import {AddressType} from './AddressType.mjs';
import {Annotation} from './Annotation.mjs';
import {Encryptable} from './Encryptable.mjs';
import {DecryptedTelecom, EncryptedTelecom, Telecom} from './Telecom.mjs';


export interface Address extends Encryptable, HasTags, HasCodes {

	identifier: Array<Identifier>;

	addressType: AddressType | undefined;

	descr: string | undefined;

	street: string | undefined;

	houseNumber: string | undefined;

	postboxNumber: string | undefined;

	postalCode: string | undefined;

	city: string | undefined;

	state: string | undefined;

	country: string | undefined;

	note: string | undefined;

	notes: Array<Annotation>;

	telecoms: Array<Telecom>;

	readonly isEncrypted: boolean;

	toJSON(): object;

}

export class DecryptedAddress {

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	identifier: Array<Identifier> = [];

	addressType: AddressType | undefined = undefined;

	descr: string | undefined = undefined;

	street: string | undefined = undefined;

	houseNumber: string | undefined = undefined;

	postboxNumber: string | undefined = undefined;

	postalCode: string | undefined = undefined;

	city: string | undefined = undefined;

	state: string | undefined = undefined;

	country: string | undefined = undefined;

	note: string | undefined = undefined;

	notes: Array<Annotation> = [];

	telecoms: Array<DecryptedTelecom> = [];

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: false = false;

	constructor(partial: Partial<DecryptedAddress>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== false) throw new Error('partial.isEncrypted must be undefined or false');
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
		if ('addressType' in partial) this.addressType = partial.addressType;
		if ('descr' in partial) this.descr = partial.descr;
		if ('street' in partial) this.street = partial.street;
		if ('houseNumber' in partial) this.houseNumber = partial.houseNumber;
		if ('postboxNumber' in partial) this.postboxNumber = partial.postboxNumber;
		if ('postalCode' in partial) this.postalCode = partial.postalCode;
		if ('city' in partial) this.city = partial.city;
		if ('state' in partial) this.state = partial.state;
		if ('country' in partial) this.country = partial.country;
		if ('note' in partial) this.note = partial.note;
		if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
		if ('telecoms' in partial && partial.telecoms !== undefined) this.telecoms = partial.telecoms;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		res['identifier'] = this.identifier.map((x0) => x0.toJSON() )
		if (this.addressType != undefined) res['addressType'] = this.addressType
		if (this.descr != undefined) res['descr'] = this.descr
		if (this.street != undefined) res['street'] = this.street
		if (this.houseNumber != undefined) res['houseNumber'] = this.houseNumber
		if (this.postboxNumber != undefined) res['postboxNumber'] = this.postboxNumber
		if (this.postalCode != undefined) res['postalCode'] = this.postalCode
		if (this.city != undefined) res['city'] = this.city
		if (this.state != undefined) res['state'] = this.state
		if (this.country != undefined) res['country'] = this.country
		if (this.note != undefined) res['note'] = this.note
		res['notes'] = this.notes.map((x0) => x0.toJSON() )
		res['telecoms'] = this.telecoms.map((x0) => x0.toJSON() )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = false
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['DecryptedAddress']): DecryptedAddress {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== false) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be false. The provided json doesn't represent a DecryptedAddress`)
		const res = new DecryptedAddress({
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			identifier: expectArray(extractEntry(jCpy, 'identifier', false, path), false, [...path, ".identifier"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Identifier.fromJSON)),
			addressType: expectStringEnum(extractEntry(jCpy, 'addressType', false, path), true, [...path, ".addressType"], AddressType, 'AddressType'),
			descr: expectString(extractEntry(jCpy, 'descr', false, path), true, [...path, ".descr"]),
			street: expectString(extractEntry(jCpy, 'street', false, path), true, [...path, ".street"]),
			houseNumber: expectString(extractEntry(jCpy, 'houseNumber', false, path), true, [...path, ".houseNumber"]),
			postboxNumber: expectString(extractEntry(jCpy, 'postboxNumber', false, path), true, [...path, ".postboxNumber"]),
			postalCode: expectString(extractEntry(jCpy, 'postalCode', false, path), true, [...path, ".postalCode"]),
			city: expectString(extractEntry(jCpy, 'city', false, path), true, [...path, ".city"]),
			state: expectString(extractEntry(jCpy, 'state', false, path), true, [...path, ".state"]),
			country: expectString(extractEntry(jCpy, 'country', false, path), true, [...path, ".country"]),
			note: expectString(extractEntry(jCpy, 'note', false, path), true, [...path, ".note"]),
			notes: expectArray(extractEntry(jCpy, 'notes', false, path), false, [...path, ".notes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Annotation.fromJSON)),
			telecoms: expectArray(extractEntry(jCpy, 'telecoms', false, path), false, [...path, ".telecoms"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, DecryptedTelecom.fromJSON)),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object DecryptedAddress at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export class EncryptedAddress {

	tags: Array<CodeStub> = [];

	codes: Array<CodeStub> = [];

	identifier: Array<Identifier> = [];

	addressType: AddressType | undefined = undefined;

	descr: string | undefined = undefined;

	street: string | undefined = undefined;

	houseNumber: string | undefined = undefined;

	postboxNumber: string | undefined = undefined;

	postalCode: string | undefined = undefined;

	city: string | undefined = undefined;

	state: string | undefined = undefined;

	country: string | undefined = undefined;

	note: string | undefined = undefined;

	notes: Array<Annotation> = [];

	telecoms: Array<EncryptedTelecom> = [];

	encryptedSelf: Base64String | undefined = undefined;

	readonly isEncrypted: true = true;

	constructor(partial: Partial<EncryptedAddress>) {
		if (partial.isEncrypted !== undefined && partial.isEncrypted !== true) throw new Error('partial.isEncrypted must be undefined or true');
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
		if ('addressType' in partial) this.addressType = partial.addressType;
		if ('descr' in partial) this.descr = partial.descr;
		if ('street' in partial) this.street = partial.street;
		if ('houseNumber' in partial) this.houseNumber = partial.houseNumber;
		if ('postboxNumber' in partial) this.postboxNumber = partial.postboxNumber;
		if ('postalCode' in partial) this.postalCode = partial.postalCode;
		if ('city' in partial) this.city = partial.city;
		if ('state' in partial) this.state = partial.state;
		if ('country' in partial) this.country = partial.country;
		if ('note' in partial) this.note = partial.note;
		if ('notes' in partial && partial.notes !== undefined) this.notes = partial.notes;
		if ('telecoms' in partial && partial.telecoms !== undefined) this.telecoms = partial.telecoms;
		if ('encryptedSelf' in partial) this.encryptedSelf = partial.encryptedSelf;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		res['identifier'] = this.identifier.map((x0) => x0.toJSON() )
		if (this.addressType != undefined) res['addressType'] = this.addressType
		if (this.descr != undefined) res['descr'] = this.descr
		if (this.street != undefined) res['street'] = this.street
		if (this.houseNumber != undefined) res['houseNumber'] = this.houseNumber
		if (this.postboxNumber != undefined) res['postboxNumber'] = this.postboxNumber
		if (this.postalCode != undefined) res['postalCode'] = this.postalCode
		if (this.city != undefined) res['city'] = this.city
		if (this.state != undefined) res['state'] = this.state
		if (this.country != undefined) res['country'] = this.country
		if (this.note != undefined) res['note'] = this.note
		res['notes'] = this.notes.map((x0) => x0.toJSON() )
		res['telecoms'] = this.telecoms.map((x0) => x0.toJSON() )
		if (this.encryptedSelf != undefined) res['encryptedSelf'] = this.encryptedSelf
		res['isEncrypted'] = true
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EncryptedAddress']): EncryptedAddress {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, "isEncrypted", true, path) !== true) throw new Error(`Unexpected value for ${path.join("")} isEncrypted marker, should be true. The provided json doesn't represent a EncryptedAddress`)
		const res = new EncryptedAddress({
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			identifier: expectArray(extractEntry(jCpy, 'identifier', false, path), false, [...path, ".identifier"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Identifier.fromJSON)),
			addressType: expectStringEnum(extractEntry(jCpy, 'addressType', false, path), true, [...path, ".addressType"], AddressType, 'AddressType'),
			descr: expectString(extractEntry(jCpy, 'descr', false, path), true, [...path, ".descr"]),
			street: expectString(extractEntry(jCpy, 'street', false, path), true, [...path, ".street"]),
			houseNumber: expectString(extractEntry(jCpy, 'houseNumber', false, path), true, [...path, ".houseNumber"]),
			postboxNumber: expectString(extractEntry(jCpy, 'postboxNumber', false, path), true, [...path, ".postboxNumber"]),
			postalCode: expectString(extractEntry(jCpy, 'postalCode', false, path), true, [...path, ".postalCode"]),
			city: expectString(extractEntry(jCpy, 'city', false, path), true, [...path, ".city"]),
			state: expectString(extractEntry(jCpy, 'state', false, path), true, [...path, ".state"]),
			country: expectString(extractEntry(jCpy, 'country', false, path), true, [...path, ".country"]),
			note: expectString(extractEntry(jCpy, 'note', false, path), true, [...path, ".note"]),
			notes: expectArray(extractEntry(jCpy, 'notes', false, path), false, [...path, ".notes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Annotation.fromJSON)),
			telecoms: expectArray(extractEntry(jCpy, 'telecoms', false, path), false, [...path, ".telecoms"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, EncryptedTelecom.fromJSON)),
			encryptedSelf: expectString(extractEntry(jCpy, 'encryptedSelf', false, path), true, [...path, ".encryptedSelf"]) as Base64String,
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EncryptedAddress at path ${path.join("")}: ${unused}`)}
		return res
	}

}

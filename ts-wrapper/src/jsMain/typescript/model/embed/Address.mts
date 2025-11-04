// auto-generated file
import {expectArray, expectString, expectStringEnum} from '../../internal/JsonDecodeUtils.mjs';
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

	toJSON(): any {
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
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['DecryptedAddress']): DecryptedAddress {
		return new DecryptedAddress({
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			identifier: expectArray(json.identifier, false, [...path, ".identifier"], (x0, p0) => Identifier.fromJSON(x0, p0)),
			addressType: expectStringEnum(json.addressType, true, [...path, ".addressType"], AddressType, 'AddressType'),
			descr: expectString(json.descr, true, [...path, ".descr"]),
			street: expectString(json.street, true, [...path, ".street"]),
			houseNumber: expectString(json.houseNumber, true, [...path, ".houseNumber"]),
			postboxNumber: expectString(json.postboxNumber, true, [...path, ".postboxNumber"]),
			postalCode: expectString(json.postalCode, true, [...path, ".postalCode"]),
			city: expectString(json.city, true, [...path, ".city"]),
			state: expectString(json.state, true, [...path, ".state"]),
			country: expectString(json.country, true, [...path, ".country"]),
			note: expectString(json.note, true, [...path, ".note"]),
			notes: expectArray(json.notes, false, [...path, ".notes"], (x0, p0) => Annotation.fromJSON(x0, p0)),
			telecoms: expectArray(json.telecoms, false, [...path, ".telecoms"], (x0, p0) => DecryptedTelecom.fromJSON(x0, p0)),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
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

	toJSON(): any {
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
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['EncryptedAddress']): EncryptedAddress {
		return new EncryptedAddress({
			tags: expectArray(json.tags, false, [...path, ".tags"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			codes: expectArray(json.codes, false, [...path, ".codes"], (x0, p0) => CodeStub.fromJSON(x0, p0)),
			identifier: expectArray(json.identifier, false, [...path, ".identifier"], (x0, p0) => Identifier.fromJSON(x0, p0)),
			addressType: expectStringEnum(json.addressType, true, [...path, ".addressType"], AddressType, 'AddressType'),
			descr: expectString(json.descr, true, [...path, ".descr"]),
			street: expectString(json.street, true, [...path, ".street"]),
			houseNumber: expectString(json.houseNumber, true, [...path, ".houseNumber"]),
			postboxNumber: expectString(json.postboxNumber, true, [...path, ".postboxNumber"]),
			postalCode: expectString(json.postalCode, true, [...path, ".postalCode"]),
			city: expectString(json.city, true, [...path, ".city"]),
			state: expectString(json.state, true, [...path, ".state"]),
			country: expectString(json.country, true, [...path, ".country"]),
			note: expectString(json.note, true, [...path, ".note"]),
			notes: expectArray(json.notes, false, [...path, ".notes"], (x0, p0) => Annotation.fromJSON(x0, p0)),
			telecoms: expectArray(json.telecoms, false, [...path, ".telecoms"], (x0, p0) => EncryptedTelecom.fromJSON(x0, p0)),
			encryptedSelf: expectString(json.encryptedSelf, false, [...path, ".encryptedSelf"]),
		})
	}

}

// auto-generated file
import {expectArray, expectMap, expectNumber, expectObject, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {CodeStub} from './base/CodeStub.mjs';
import {HasCodes} from './base/HasCodes.mjs';
import {HasIdentifier} from './base/HasIdentifier.mjs';
import {HasTags} from './base/HasTags.mjs';
import {Identifier} from './base/Identifier.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DecryptedAddress} from './embed/Address.mjs';


/**
 *
 *
 *   Represents an insurance entity. An insurance can be a mutual fund, a private insurance company,
 *   or any other type of insurance organization that covers healthcare costs.
 */
export class Insurance implements StoredDocument, HasTags, HasCodes, HasIdentifier {

	/**
	 *
	 *  The unique identifier of the insurance.
	 */
	id: string;

	/**
	 *
	 *  The revision of the insurance in the database, used for conflict management / optimistic
	 *  locking.
	 */
	rev: string | undefined = undefined;

	/**
	 *
	 *  Hard delete (unix epoch in ms) timestamp of the object.
	 */
	deletionDate: number | undefined = undefined;

	/**
	 *
	 *  The name of the insurance in different languages.
	 */
	name: { [ key: string ]: string } = {};

	/**
	 *
	 *  The identifiers of the insurance.
	 */
	identifier: Array<Identifier> = [];

	/**
	 *
	 *  Tags that qualify the insurance as being member of a certain class.
	 */
	tags: Array<CodeStub> = [];

	/**
	 *
	 *  Codes that identify or qualify this particular insurance.
	 */
	codes: Array<CodeStub> = [];

	/**
	 *
	 *  The insurance code.
	 */
	code: string | undefined = undefined;

	/**
	 *
	 *  The agreement number for the insurance.
	 */
	agreementNumber: string | undefined = undefined;

	/**
	 *
	 *  The id of the parent insurance entity.
	 */
	parent: string | undefined = undefined;

	/**
	 *
	 *  The address of the insurance company.
	 */
	address: DecryptedAddress;

	constructor(partial: Partial<Insurance> & Pick<Insurance, "address">) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('name' in partial && partial.name !== undefined) this.name = partial.name;
		if ('identifier' in partial && partial.identifier !== undefined) this.identifier = partial.identifier;
		if ('tags' in partial && partial.tags !== undefined) this.tags = partial.tags;
		if ('codes' in partial && partial.codes !== undefined) this.codes = partial.codes;
		if ('code' in partial) this.code = partial.code;
		if ('agreementNumber' in partial) this.agreementNumber = partial.agreementNumber;
		if ('parent' in partial) this.parent = partial.parent;
		this.address = partial.address;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		res['name'] = Object.fromEntries(Object.entries(this.name).map(([k0, v0]) => [k0, v0]))
		res['identifier'] = this.identifier.map((x0) => x0.toJSON() )
		res['tags'] = this.tags.map((x0) => x0.toJSON() )
		res['codes'] = this.codes.map((x0) => x0.toJSON() )
		if (this.code != undefined) res['code'] = this.code
		if (this.agreementNumber != undefined) res['agreementNumber'] = this.agreementNumber
		if (this.parent != undefined) res['parent'] = this.parent
		res['address'] = this.address.toJSON()
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Insurance']): Insurance {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Insurance({
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			rev: expectString(extractEntry(jCpy, 'rev', false, path), true, [...path, ".rev"]),
			deletionDate: expectNumber(extractEntry(jCpy, 'deletionDate', false, path), true, true, [...path, ".deletionDate"]),
			name: expectMap(
				extractEntry(jCpy, 'name', false, path),
				false,
				[...path, ".name"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectString(v0, false, p0)
			),
			identifier: expectArray(extractEntry(jCpy, 'identifier', false, path), false, [...path, ".identifier"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, Identifier.fromJSON)),
			tags: expectArray(extractEntry(jCpy, 'tags', false, path), false, [...path, ".tags"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			codes: expectArray(extractEntry(jCpy, 'codes', false, path), false, [...path, ".codes"], (x0, p0) => expectObject(x0, false, ignoreUnknownKeys, p0, CodeStub.fromJSON)),
			code: expectString(extractEntry(jCpy, 'code', false, path), true, [...path, ".code"]),
			agreementNumber: expectString(extractEntry(jCpy, 'agreementNumber', false, path), true, [...path, ".agreementNumber"]),
			parent: expectString(extractEntry(jCpy, 'parent', false, path), true, [...path, ".parent"]),
			address: expectObject(extractEntry(jCpy, 'address', true, path), false, ignoreUnknownKeys, [...path, ".address"], DecryptedAddress.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Insurance at path ${path.join("")}: ${unused}`)}
		return res
	}

}

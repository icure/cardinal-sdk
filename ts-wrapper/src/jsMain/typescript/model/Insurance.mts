// auto-generated file
import {expectBoolean, expectMap, expectNumber, expectObject, expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DecryptedAddress} from './embed/Address.mjs';


/**
 *
 *  Represents an insurance entity. An insurance can be a mutual fund, a private insurance company,
 *  or any other type of insurance organization that covers healthcare costs.
 *  /
 */
export class Insurance implements StoredDocument {

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
	 *  Whether this is a private insurance.
	 */
	privateInsurance: boolean = false;

	/**
	 *
	 *  Whether this insurance covers hospitalisation.
	 */
	hospitalisationInsurance: boolean = false;

	/**
	 *
	 *  Whether this insurance covers ambulatory care.
	 */
	ambulatoryInsurance: boolean = false;

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
		if ('privateInsurance' in partial && partial.privateInsurance !== undefined) this.privateInsurance = partial.privateInsurance;
		if ('hospitalisationInsurance' in partial && partial.hospitalisationInsurance !== undefined) this.hospitalisationInsurance = partial.hospitalisationInsurance;
		if ('ambulatoryInsurance' in partial && partial.ambulatoryInsurance !== undefined) this.ambulatoryInsurance = partial.ambulatoryInsurance;
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
		res['privateInsurance'] = this.privateInsurance
		res['hospitalisationInsurance'] = this.hospitalisationInsurance
		res['ambulatoryInsurance'] = this.ambulatoryInsurance
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
			privateInsurance: expectBoolean(extractEntry(jCpy, 'privateInsurance', false, path), false, [...path, ".privateInsurance"]),
			hospitalisationInsurance: expectBoolean(extractEntry(jCpy, 'hospitalisationInsurance', false, path), false, [...path, ".hospitalisationInsurance"]),
			ambulatoryInsurance: expectBoolean(extractEntry(jCpy, 'ambulatoryInsurance', false, path), false, [...path, ".ambulatoryInsurance"]),
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

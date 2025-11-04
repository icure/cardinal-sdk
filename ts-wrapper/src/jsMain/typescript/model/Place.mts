// auto-generated file
import {expectNumber, expectString, requireEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';
import {Named} from './base/Named.mjs';
import {StoredDocument} from './base/StoredDocument.mjs';
import {DecryptedAddress} from './embed/Address.mjs';


export class Place implements StoredDocument, Named {

	id: string;

	rev: string | undefined = undefined;

	deletionDate: number | undefined = undefined;

	name: string | undefined = undefined;

	address: DecryptedAddress | undefined = undefined;

	constructor(partial: Partial<Place>) {
		this.id = partial.id ?? randomUuid();
		if ('rev' in partial) this.rev = partial.rev;
		if ('deletionDate' in partial) this.deletionDate = partial.deletionDate;
		if ('name' in partial) this.name = partial.name;
		if ('address' in partial) this.address = partial.address;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['id'] = this.id
		if (this.rev != undefined) res['rev'] = this.rev
		if (this.deletionDate != undefined) res['deletionDate'] = this.deletionDate
		if (this.name != undefined) res['name'] = this.name
		if (this.address != undefined) res['address'] = this.address.toJSON()
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['Place']): Place {
		return new Place({
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			rev: expectString(json.rev, true, [...path, ".rev"]),
			deletionDate: expectNumber(json.deletionDate, true, true, [...path, ".deletionDate"]),
			name: expectString(json.name, true, [...path, ".name"]),
			address: DecryptedAddress.fromJSON(json.address, [...path, ".address"]),
		})
	}

}

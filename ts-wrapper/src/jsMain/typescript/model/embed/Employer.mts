// auto-generated file
import {expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {Named} from '../base/Named.mjs';
import {DecryptedAddress} from './Address.mjs';


export class Employer implements Named {

	name: string | undefined = undefined;

	addresse: DecryptedAddress | undefined = undefined;

	constructor(partial: Partial<Employer>) {
		if ('name' in partial) this.name = partial.name;
		if ('addresse' in partial) this.addresse = partial.addresse;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.name != undefined) res['name'] = this.name
		if (this.addresse != undefined) res['addresse'] = this.addresse.toJSON()
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Employer']): Employer {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Employer({
			name: expectString(extractEntry(jCpy.name, 'name', false, path), true, [...path, ".name"]),
			addresse: expectObject(extractEntry(jCpy.addresse, 'addresse', false, path), true, ignoreUnknownKeys, [...path, ".addresse"], DecryptedAddress.fromJSON),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Employer at path ${path.join("")}: ${unused}`)}
		return res
	}

}

// auto-generated file
import {expectString} from '../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, path: Array<string> = ['Employer']): Employer {
		return new Employer({
			name: expectString(json.name, true, [...path, ".name"]),
			addresse: DecryptedAddress.fromJSON(json.addresse, [...path, ".addresse"]),
		})
	}

}

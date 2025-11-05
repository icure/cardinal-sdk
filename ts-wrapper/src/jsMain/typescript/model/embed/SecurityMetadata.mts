// auto-generated file
import {expectMap, expectObject, expectString, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {SecureDelegation} from './SecureDelegation.mjs';


export class SecurityMetadata {

	secureDelegations: { [ key: string ]: SecureDelegation };

	constructor(partial: Partial<SecurityMetadata> & Pick<SecurityMetadata, "secureDelegations">) {
		this.secureDelegations = partial.secureDelegations;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['secureDelegations'] = Object.fromEntries(Object.entries(this.secureDelegations).map(([k0, v0]) => [k0, v0.toJSON()]))
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['SecurityMetadata']): SecurityMetadata {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new SecurityMetadata({
			secureDelegations: expectMap(
				extractEntry(jCpy, 'secureDelegations', true, path),
				false,
				[...path, ".secureDelegations"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => expectObject(v0, false, ignoreUnknownKeys, p0, SecureDelegation.fromJSON)
			),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object SecurityMetadata at path ${path.join("")}: ${unused}`)}
		return res
	}

}

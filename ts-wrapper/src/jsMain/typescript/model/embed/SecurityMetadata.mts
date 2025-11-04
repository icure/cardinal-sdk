// auto-generated file
import {expectMap, expectString, requireEntry} from '../../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, path: Array<string> = ['SecurityMetadata']): SecurityMetadata {
		return new SecurityMetadata({
			secureDelegations: expectMap(
				requireEntry(json.secureDelegations, 'secureDelegations', path),
				false,
				[...path, ".secureDelegations"],
				(k0, p0) => expectString(k0, false, p0),
				(v0, p0) => SecureDelegation.fromJSON(v0, p0)
			),
		})
	}

}

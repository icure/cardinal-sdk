// auto-generated file
import {expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';


export class PublicKey {

	hcPartyId: string | undefined = undefined;

	hexString: string | undefined = undefined;

	constructor(partial: Partial<PublicKey>) {
		if ('hcPartyId' in partial) this.hcPartyId = partial.hcPartyId;
		if ('hexString' in partial) this.hexString = partial.hexString;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.hcPartyId != undefined) res['hcPartyId'] = this.hcPartyId
		if (this.hexString != undefined) res['hexString'] = this.hexString
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['PublicKey']): PublicKey {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new PublicKey({
			hcPartyId: expectString(extractEntry(jCpy, 'hcPartyId', false, path), true, [...path, ".hcPartyId"]),
			hexString: expectString(extractEntry(jCpy, 'hexString', false, path), true, [...path, ".hexString"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object PublicKey at path ${path.join("")}: ${unused}`)}
		return res
	}

}

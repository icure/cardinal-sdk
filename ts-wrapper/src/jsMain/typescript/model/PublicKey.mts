// auto-generated file
import {expectString} from '../internal/JsonDecodeUtils.mjs';


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

	static fromJSON(json: any, path: Array<string> = ['PublicKey']): PublicKey {
		return new PublicKey({
			hcPartyId: expectString(json.hcPartyId, true, [...path, ".hcPartyId"]),
			hexString: expectString(json.hexString, true, [...path, ".hexString"]),
		})
	}

}

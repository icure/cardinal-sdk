// auto-generated file
import {expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {PartnershipStatus} from './PartnershipStatus.mjs';
import {PartnershipType} from './PartnershipType.mjs';


export class Partnership {

	type: PartnershipType | undefined = undefined;

	status: PartnershipStatus | undefined = undefined;

	partnerId: string | undefined = undefined;

	constructor(partial: Partial<Partnership>) {
		if ('type' in partial) this.type = partial.type;
		if ('status' in partial) this.status = partial.status;
		if ('partnerId' in partial) this.partnerId = partial.partnerId;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		if (this.type != undefined) res['type'] = this.type
		if (this.status != undefined) res['status'] = this.status
		if (this.partnerId != undefined) res['partnerId'] = this.partnerId
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['Partnership']): Partnership {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new Partnership({
			type: expectStringEnum(extractEntry(jCpy, 'type', false, path), true, [...path, ".type"], PartnershipType, 'PartnershipType'),
			status: expectStringEnum(extractEntry(jCpy, 'status', false, path), true, [...path, ".status"], PartnershipStatus, 'PartnershipStatus'),
			partnerId: expectString(extractEntry(jCpy, 'partnerId', false, path), true, [...path, ".partnerId"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object Partnership at path ${path.join("")}: ${unused}`)}
		return res
	}

}

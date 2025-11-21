// auto-generated file
import {expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {ParticipantType} from '../base/ParticipantType.mjs';


export class ContactParticipant {

	type: ParticipantType;

	hcpId: string;

	constructor(partial: Partial<ContactParticipant> & Pick<ContactParticipant, "type" | "hcpId">) {
		this.type = partial.type;
		this.hcpId = partial.hcpId;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['type'] = this.type
		res['hcpId'] = this.hcpId
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['ContactParticipant']): ContactParticipant {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new ContactParticipant({
			type: expectStringEnum(extractEntry(jCpy, 'type', true, path), false, [...path, ".type"], ParticipantType, 'ParticipantType'),
			hcpId: expectString(extractEntry(jCpy, 'hcpId', true, path), false, [...path, ".hcpId"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object ContactParticipant at path ${path.join("")}: ${unused}`)}
		return res
	}

}

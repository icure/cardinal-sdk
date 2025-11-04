// auto-generated file
import {expectArray, expectString, expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {DocumentLocation} from './DocumentLocation.mjs';


export class MessageAttachment {

	type: DocumentLocation | undefined = undefined;

	ids: Array<string> = [];

	constructor(partial: Partial<MessageAttachment>) {
		if ('type' in partial) this.type = partial.type;
		if ('ids' in partial && partial.ids !== undefined) this.ids = partial.ids;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		if (this.type != undefined) res['type'] = this.type
		res['ids'] = this.ids.map((x0) => x0 )
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['MessageAttachment']): MessageAttachment {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new MessageAttachment({
			type: expectStringEnum(extractEntry(jCpy.type, 'type', false, path), true, [...path, ".type"], DocumentLocation, 'DocumentLocation'),
			ids: expectArray(extractEntry(jCpy.ids, 'ids', false, path), false, [...path, ".ids"], (x0, p0) => expectString(x0, false, p0)),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object MessageAttachment at path ${path.join("")}: ${unused}`)}
		return res
	}

}

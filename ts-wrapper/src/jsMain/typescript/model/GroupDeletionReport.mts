// auto-generated file
import {expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';


export class GroupDeletionReport {

	type: string;

	id: string;

	server: string;

	constructor(partial: Partial<GroupDeletionReport> & Pick<GroupDeletionReport, "type" | "server">) {
		this.type = partial.type;
		this.id = partial.id ?? randomUuid();
		this.server = partial.server;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['type'] = this.type
		res['id'] = this.id
		res['server'] = this.server
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['GroupDeletionReport']): GroupDeletionReport {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new GroupDeletionReport({
			type: expectString(extractEntry(jCpy, 'type', true, path), false, [...path, ".type"]),
			id: expectString(extractEntry(jCpy, 'id', true, path), false, [...path, ".id"]),
			server: expectString(extractEntry(jCpy, 'server', true, path), false, [...path, ".server"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object GroupDeletionReport at path ${path.join("")}: ${unused}`)}
		return res
	}

}

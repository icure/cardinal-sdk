// auto-generated file
import {expectString, requireEntry} from '../internal/JsonDecodeUtils.mjs';
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

	static fromJSON(json: any, path: Array<string> = ['GroupDeletionReport']): GroupDeletionReport {
		return new GroupDeletionReport({
			type: expectString(requireEntry(json.type, 'type', path), false, [...path, ".type"]),
			id: expectString(requireEntry(json.id, 'id', path), false, [...path, ".id"]),
			server: expectString(requireEntry(json.server, 'server', path), false, [...path, ".server"]),
		})
	}

}

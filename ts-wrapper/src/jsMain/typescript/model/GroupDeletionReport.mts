// auto-generated file
import {expectString, expectStringEnum, extractEntry} from '../internal/JsonDecodeUtils.mjs';
import {randomUuid} from '../utils/Id.mjs';


/**
 *
 *
 *   DTO representing one item handled by a group hard deletion.
 */
export class GroupDeletionReport {

	/**
	 *
	 *  The type of the deleted resource.
	 */
	type: string;

	/**
	 *
	 *  The unique identifier of the deleted resource.
	 */
	id: string;

	/**
	 *
	 *  The server on which the resource was deleted.
	 */
	server: string;

	/**
	 *
	 *  What happened to the resource.
	 */
	status: GroupDeletionReport.Status = GroupDeletionReport.Status.Deleted;

	/**
	 *
	 *  Details on a [Status.FAILED] resource.
	 */
	message: string | undefined = undefined;

	constructor(partial: Partial<GroupDeletionReport> & Pick<GroupDeletionReport, "type" | "server">) {
		this.type = partial.type;
		this.id = partial.id ?? randomUuid();
		this.server = partial.server;
		if ('status' in partial && partial.status !== undefined) this.status = partial.status;
		if ('message' in partial) this.message = partial.message;
	}

	toJSON(): object {
		const res: { [k: string]: any } = {}
		res['type'] = this.type
		res['id'] = this.id
		res['server'] = this.server
		res['status'] = this.status
		if (this.message != undefined) res['message'] = this.message
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
			status: expectStringEnum(extractEntry(jCpy, 'status', false, path), false, [...path, ".status"], GroupDeletionReport.Status, 'GroupDeletionReport.Status'),
			message: expectString(extractEntry(jCpy, 'message', false, path), true, [...path, ".message"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object GroupDeletionReport at path ${path.join("")}: ${unused}`)}
		return res
	}

}

export namespace GroupDeletionReport {

	export enum Status {
		Deleted = "Deleted",
		Absent = "Absent",
		Failed = "Failed"
	}

}

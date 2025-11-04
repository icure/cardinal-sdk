// auto-generated file
import {expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';


export class EntityReferenceInGroup {

	entityId: string;

	groupId: string | undefined = undefined;

	constructor(partial: Partial<EntityReferenceInGroup> & Pick<EntityReferenceInGroup, "entityId">) {
		this.entityId = partial.entityId;
		if ('groupId' in partial) this.groupId = partial.groupId;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['entityId'] = this.entityId
		if (this.groupId != undefined) res['groupId'] = this.groupId
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['EntityReferenceInGroup']): EntityReferenceInGroup {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		const res = new EntityReferenceInGroup({
			entityId: expectString(extractEntry(jCpy.entityId, 'entityId', true, path), false, [...path, ".entityId"]),
			groupId: expectString(extractEntry(jCpy.groupId, 'groupId', false, path), true, [...path, ".groupId"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EntityReferenceInGroup at path ${path.join("")}: ${unused}`)}
		return res
	}

}

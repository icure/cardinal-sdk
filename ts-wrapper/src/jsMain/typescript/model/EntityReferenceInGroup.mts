// auto-generated file
import {expectString, requireEntry} from '../internal/JsonDecodeUtils.mjs';


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

	static fromJSON(json: any,
			path: Array<string> = ['EntityReferenceInGroup']): EntityReferenceInGroup {
		return new EntityReferenceInGroup({
			entityId: expectString(requireEntry(json.entityId, 'entityId', path), false, [...path, ".entityId"]),
			groupId: expectString(json.groupId, true, [...path, ".groupId"]),
		})
	}

}

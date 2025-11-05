// auto-generated file
import {expectStringEnum, extractEntry} from '../../internal/JsonDecodeUtils.mjs';
import {PermissionType} from './PermissionType.mjs';


export class AlwaysPermissionItem {

	type: PermissionType;

	readonly $ktClass: 'com.icure.cardinal.sdk.model.security.AlwaysPermissionItem' = 'com.icure.cardinal.sdk.model.security.AlwaysPermissionItem';

	constructor(partial: Partial<AlwaysPermissionItem> & Pick<AlwaysPermissionItem, "type">) {
		this.type = partial.type;
	}

	toJSON(): any {
		const res: { [k: string]: any } = {}
		res['type'] = this.type
		res['$ktClass'] = 'com.icure.cardinal.sdk.model.security.AlwaysPermissionItem'
		return res
	}

	static fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['AlwaysPermissionItem']): AlwaysPermissionItem {
		if (typeof json != 'object') throw new Error(`Expected json object at path ${path.join("")}`)
		const jCpy = { ...json }
		if (extractEntry(jCpy, '\$ktClass', true, path) !== 'com.icure.cardinal.sdk.model.security.AlwaysPermissionItem') throw new Error(`Unexpected value f+or ${path.join("")} class marker, should be "com.icure.cardinal.sdk.model.security.AlwaysPermissionItem"`)
		const res = new AlwaysPermissionItem({
			type: expectStringEnum(extractEntry(jCpy, 'type', true, path), false, [...path, ".type"], PermissionType, 'PermissionType'),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object AlwaysPermissionItem at path ${path.join("")}: ${unused}`)}
		return res
	}

}

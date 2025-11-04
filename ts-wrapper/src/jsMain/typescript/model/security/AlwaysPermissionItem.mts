// auto-generated file
import {expectStringEnum, requireEntry} from '../../internal/JsonDecodeUtils.mjs';
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
		return res
	}

	static fromJSON(json: any, path: Array<string> = ['AlwaysPermissionItem']): AlwaysPermissionItem {
		return new AlwaysPermissionItem({
			type: expectStringEnum(requireEntry(json.type, 'type', path), false, [...path, ".type"], PermissionType, 'PermissionType'),
		})
	}

}

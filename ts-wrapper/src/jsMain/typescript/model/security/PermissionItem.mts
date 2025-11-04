// auto-generated file
import {AlwaysPermissionItem} from './AlwaysPermissionItem.mjs';


export type PermissionItem = AlwaysPermissionItem;

export namespace PermissionItem {

	export function fromJSON(json: any, path: Array<string> = ['PermissionItem']): PermissionItem {
		switch ((json as PermissionItem).$ktClass) {
			case 'com.icure.cardinal.sdk.model.security.AlwaysPermissionItem': return AlwaysPermissionItem.fromJSON(json)
			default: throw new Error('Unexpected discriminator for PermissionItem: ' + json.$ktClass)
		}
	}

}

// auto-generated file
import {AlwaysPermissionItem} from './AlwaysPermissionItem.mjs';


/**
 *
 *  Sealed interface representing a single permission entry that pairs a permission type with a
 *  predicate.
 *  The predicate defines the condition under which the permission applies.
 *  /
 */
export type PermissionItem = AlwaysPermissionItem;

export namespace PermissionItem {

	export function fromJSON(json: any, ignoreUnknownKeys: boolean = false,
			path: Array<string> = ['PermissionItem']): PermissionItem {
		switch ((json as PermissionItem).$ktClass) {
			case 'com.icure.cardinal.sdk.model.security.AlwaysPermissionItem': return AlwaysPermissionItem.fromJSON(json, ignoreUnknownKeys)
			default: throw new Error('Unexpected discriminator for PermissionItem: ' + json.$ktClass)
		}
	}

}

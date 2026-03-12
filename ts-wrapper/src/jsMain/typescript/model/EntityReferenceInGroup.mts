// auto-generated file
import {expectString, extractEntry} from '../internal/JsonDecodeUtils.mjs';


/**
 *
 *  A reference to an entity in a group.
 *
 *  The entity group id can be null, which means the entity is in the same group as the user currently logged in to the
 *  SDK.
 *
 *  When providing input to any SDK method you can use references with the group of the logged user or null
 *  interchangeably.
 *
 *  However, some SDK methods that return [EntityReferenceInGroup] consistently fill the [groupId] of the logged user
 *  while others consistently leave it null.
 *  The general rule is that the methods from `inGroup` apis always fill all [groupId] values, even when the group
 *  matches the current user's group. Methods that always act on the logged user's group instead always leave null
 *  [groupId] when it would match the logged user's group.
 *
 *  Note that `equals` methods can't take in consideration the group of the current user, therefore
 *  `EntityReferenceInGroup(x, userGroup) != EntityReferenceInGroup(x, null)`, even though the SDK for a user in
 *  userGroup treats them the same.
 *
 *  @param entityId the id of the entity
 *  @param groupId the id of the entity's group. If null it should be interpreted as the same group of the logged user.
 */
export class EntityReferenceInGroup {

	entityId: string;

	groupId: string | undefined = undefined;

	constructor(partial: Partial<EntityReferenceInGroup> & Pick<EntityReferenceInGroup, "entityId">) {
		this.entityId = partial.entityId;
		if ('groupId' in partial) this.groupId = partial.groupId;
	}

	toJSON(): object {
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
			entityId: expectString(extractEntry(jCpy, 'entityId', true, path), false, [...path, ".entityId"]),
			groupId: expectString(extractEntry(jCpy, 'groupId', false, path), true, [...path, ".groupId"]),
		})
		if (!ignoreUnknownKeys) {
			const unused = Object.keys(jCpy)
			if (unused.length > 0) throw new Error(`Unexpected key(s) for json object EntityReferenceInGroup at path ${path.join("")}: ${unused}`)}
		return res
	}

}

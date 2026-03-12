// auto-generated file

/**
 *
 *  Wraps an entity and associates it with the group it exists in.
 *
 *  In-group api methods take in input and return group scoped entities.
 *
 *  To prevent mistakes, you shouldn't instantiate this class yourself, instead you should always get the GroupScoped
 *  entity from the `inGroup` methods of the apis. Using GroupScoped entities with the wrong groupId, or created by
 *  instances of the SDK working on a different base group, can cause errors and other unexpected behavior.
 */
export class GroupScoped<E> {

	entity: E;

	groupId: string;

	constructor(partial: Partial<GroupScoped<E>> & Pick<GroupScoped<E>, "entity" | "groupId">) {
		this.entity = partial.entity;
		this.groupId = partial.groupId;
	}

}

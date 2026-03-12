// auto-generated file
import {EntityReferenceInGroup} from '../../model/EntityReferenceInGroup.mjs';
import {AccessLevel} from '../../model/embed/AccessLevel.mjs';
import {ArrayWithUniqueKeys} from '../../utils/ArrayWithUniqueKeys.mjs';


/**
 *
 *  Details on data owners with access to an entity
 */
export class EntityAccessInformation {

	/**
	 *
	 *  The data owners with access to the entity, and the access level they have to the entity.
	 *
	 *  When not using intergroup sharing the [EntityReferenceInGroup.groupId] will always be null.
	 *
	 *  When using intergroup sharing the [EntityReferenceInGroup.groupId] is always represented in relation to the group
	 *  of the SDK used to get this information: if the SDK is working by default on `groupU` and you extract the access
	 *  information from an entity coming from `groupE` accessible to `dataOwnerA` in `groupU` and `dataOwnerB` in
	 *  `groupB` the keys will be `EntityReferenceInGroup(dataOwnerA, null)` and
	 *  `EntityReferenceInGroup(dataOwnerB, groupE)`.
	 */
	permissionsByDataOwnerId: ArrayWithUniqueKeys<{ delegate: EntityReferenceInGroup, accessLevel: AccessLevel }, 'delegate'>;

	/**
	 *
	 *  True if the entity has been shared with anonymous data owners which couldn't be identified using the information
	 *  available to the instance of SDK used.
	 */
	hasUnknownAnonymousDataOwners: boolean;

	constructor(partial: Partial<EntityAccessInformation> & Pick<EntityAccessInformation, "permissionsByDataOwnerId" | "hasUnknownAnonymousDataOwners">) {
		this.permissionsByDataOwnerId = partial.permissionsByDataOwnerId;
		this.hasUnknownAnonymousDataOwners = partial.hasUnknownAnonymousDataOwners;
	}

}

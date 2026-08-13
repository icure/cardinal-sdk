// auto-generated file
import {CryptoActorStubWithType} from '../model/CryptoActorStubWithType.mjs';
import {DataOwnerType} from '../model/DataOwnerType.mjs';
import {DataOwnerWithType} from '../model/DataOwnerWithType.mjs';
import {EntityReferenceInGroup} from '../model/EntityReferenceInGroup.mjs';
import {DataOwnerHierarchyInfo} from '../model/base/DataOwnerHierarchyInfo.mjs';


export interface DataOwnerApi {

	/**
	 *
	 *  Get the current data owner in full, regardless of its type. This method returns the full entity, including also
	 *  information that is outside the scope of the [com.icure.sdk.model.base.CryptoActor] interface.
	 *  Fails if the current user is not a data owner.
	 *  @return the data owner associated to the current user.
	 */
	getCurrentDataOwner(): Promise<DataOwnerWithType>;

	/**
	 *
	 *  Get a stub of the current data owner. The stub contains only the information from the CryptoActor interface +
	 *  id and rev.
	 *  Fails if the current user is not a data owner.
	 *  @return the crypto actor stub of the data owner associated to the current user.
	 */
	getCurrentDataOwnerStub(): Promise<CryptoActorStubWithType>;

	/**
	 *
	 *  If the logged user is a data owner get the current data owner id. This information is cached without expiration,
	 *  and will only be updated in case of forced refresh.
	 *  Fails if the current user is not a data owner.
	 *  @return the current data owner id
	 */
	getCurrentDataOwnerId(): Promise<string>;

	getCurrentDataOwnerReference(): Promise<EntityReferenceInGroup>;

	/**
	 *
	 *  If the logged user is a data owner get its data owner groups hierarchy (all types).
	 *  @return the current user's data owner hierarchy tree, starting from the user itself
	 */
	getCurrentDataOwnerHierarchyIds(): Promise<DataOwnerHierarchyInfo>;

	/**
	 *
	 *  Get a data owner regardless of its actual type. The logged user must have the permission to access the data
	 *  owner. For example, if [ownerId] turns out to be associated to a patient, and it is not shared with the current
	 *  user this method will fail.
	 *  If are interested only in the [com.icure.sdk.model.base.CryptoActor] information of the data owner and its
	 *  [com.icure.sdk.model.DataOwnerType] you should use the [getCryptoActorStub] method instead.
	 *  @param ownerId the id of a data owner (patient, hcp or device)
	 *  @return the full data owner associated to the provided id.
	 */
	getDataOwner(ownerId: string): Promise<DataOwnerWithType>;

	/**
	 *
	 *  Bulk variant of [getDataOwner].
	 *  @param ids the ids of data owners (patients, hcps or devices)
	 *  @return the full data owners associated to the provided ids.
	 */
	getDataOwners(ids: Array<string>): Promise<Array<DataOwnerWithType>>;

	/**
	 *
	 *  Bulk variant of [getDataOwner], for use when the type of all requested data owners is already known (for
	 *  example because they are all part of the same data owner hierarchy, which can only contain data owners of a
	 *  single type). More efficient than [getDataOwners] since it fetches the entities directly through the
	 *  type-specific bulk endpoint instead of the polymorphic one.
	 *  @param ids the ids of data owners, all of type [type].
	 *  @param type the type shared by all the requested data owners.
	 *  @return the full data owners associated to the provided ids.
	 */
	getDataOwnersWithKnownType(ids: Array<string>,
			type: DataOwnerType): Promise<Array<DataOwnerWithType>>;

	/**
	 *
	 *  Get a data owner regardless of its actual type. Does not require any special permission.
	 *  @param ownerId the id of a data owner (patient, hcp or device)
	 *  @return the full data owner associated to the provided id.
	 */
	getCryptoActorStub(ownerId: string): Promise<CryptoActorStubWithType>;

	getCryptoActorStubs(ids: Array<string>): Promise<Array<CryptoActorStubWithType>>;

	/**
	 *
	 *  Get a data owner regardless of its actual type. Does not require any special permission.
	 *  @param ownerId the id of a data owner (patient, hcp or device)
	 *  @return the full data owner associated to the provided id.
	 */
	getCryptoActorStubInGroup(entityReferenceInGroup: EntityReferenceInGroup): Promise<CryptoActorStubWithType>;

	/**
	 *
	 *  Get the hierarchy for the current data owner considering only parent-type links.
	 *  If [from] is not null only give the hierarchy rooted at the provided parent id.
	 *  @param from the id of a member of the current data owner hierarchy.
	 *  @return an array starting at the topmost parent and ending at the provided parent id.
	 *  @throws IllegalArgumentException If the provided id is not part of the parent hierarchy, or if the current user
	 *  is not a data owner
	 */
	getCurrentDataOwnerParentHierarchy(from: string | undefined): Promise<DataOwnerHierarchyInfo>;

	/**
	 *
	 *  Modifies the crypto actor information of a data owner. The information that can be modified depend on the
	 *  permissions of the current user, by default only information that refer to the current user can be changed.
	 *  @param cryptoActorStubWithTypeDto the stub with updated information
	 *  @return the updated stub, with updated revision
	 */
	modifyDataOwnerStub(cryptoActorStubWithTypeDto: CryptoActorStubWithType): Promise<CryptoActorStubWithType>;

	/**
	 *
	 *  If the logged user is a data owner get the type of the current data owner. This information is cached.
	 *  @return the type of the current data owner
	 */
	getCurrentDataOwnerType(): Promise<DataOwnerType>;

	/**
	 *
	 *  Clears the cache of current data owner id and parent hierarchy ids. The hierarchy of a data owner should not
	 *  normally change over time, so this method should be rarely needed. The cache will be repopulated lazily.
	 */
	clearCurrentDataOwnerHierarchyCache(): void;

}

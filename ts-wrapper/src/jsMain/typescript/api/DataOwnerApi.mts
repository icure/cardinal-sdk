// auto-generated file
import {RsaEncryptionAlgorithm} from '../cardinal-sdk-ts.mjs';
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
	 *  This method result is cached
	 *  @return the current user's data owner hierarchy tree, starting from the user itself
	 */
	getCurrentDataOwnerHierarchyInfo(): Promise<DataOwnerHierarchyInfo>;

	/**
	 *
	 *  Get the hierarchy information for a data owner.
	 *  If [dataOwnerId] is the current data owener this method is equivalent to [getCurrentDataOwnerHierarchyInfo],
	 *  except it does not use cached information.
	 */
	getDataOwnerHierarchyInfo(dataOwnerId: string): Promise<DataOwnerHierarchyInfo>;

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

	/**
	 *
	 *  Get all data owners that are part of a simple-type group
	 */
	getSimpleGroupDelegateMembersIds(dataOwnerGroup: CryptoActorStubWithType,
			groupId: string | undefined): Promise<Array<string>>;

	/**
	 *
	 *  Get all public keys of data owners
	 */
	getDataOwnersPublicKeys(dataOwnerType: DataOwnerType, dataOwners: Array<string>,
			groupId: string | undefined): Promise<{ [ key: string ]: { [ key: string ]: RsaEncryptionAlgorithm } }>;

	/**
	 *
	 *  Add data owners to a data owner group.
	 *  The data owners must all be of the same type (as indicated by [dataOwnerType]).
	 *  The data owner group (indicated by [dataOwnerGroupId]) must exist, or this method will fail; if any of the data
	 *  owners in [newMembersIds] does not exist, or they can't be updated (for example, if there are too many concurrent
	 *  changes to that data owner) or can't be added to the group (because of restrictions on group link type), they
	 *  will be ignored.
	 *
	 *  The result contains the ids of all the data owners that were successfully added, or that were already members of
	 *  the group.
	 *
	 *  There is no guarantee on order of returned elements.
	 *
	 *  Only the links that a data owner declares directly are considered: a data owner that is already a member of
	 *  [dataOwnerGroupId] transitively, through another group it is linked to, has no link of its own to it and is
	 *  therefore linked to it directly, exactly like any other new member.
	 *
	 *  Soft-deleted data owners are not ignored: they are updated and returned like any other member. A soft-deleted
	 *  data owner can be undeleted at any moment, and it should then have the group membership it was given in the
	 *  meantime.
	 *
	 *  # Interruption and retry
	 *
	 *  This method is idempotent: adding a data owner that is already a member is a no-op that still reports the data
	 *  owner as added. If a call terminates early some of the members may have been added and the result gives no
	 *  indication of which: calling the method again with the same input picks up exactly the work that is left, and
	 *  repeating it eventually adds every member that can be added.
	 */
	addDataOwnersToGroup(dataOwnerType: DataOwnerType, dataOwnerGroupId: string,
			newMembersIds: Array<string>): Promise<Array<string>>;

	/**
	 *
	 *  Remove data owners from a data owner group.
	 *  The data owners must all be of the same type (as indicated by [dataOwnerType]).
	 *  The data owner group (indicated by [dataOwnerGroupId]) must exist, or this method will fail; if any of the data
	 *  owners in [membersToRemoveIds] does not exist, or they can't be updated (for example if there are too many
	 *  concurrent changes to that data owner), they will be ignored.
	 *  The result contains the ids of all the data owners that were successfully removed, or that were already not
	 *  members of the group.
	 *
	 *  Before returning this method will check if there is exchange data that should be invalidated for encryption as a
	 *  result of the removal of [membersToRemoveIds] from [dataOwnerGroupId]:
	 *  1. Invalidation is performed only if [dataOwnerGroupId] represents a simple-type group. If [dataOwnerGroupId]
	 *     represents a parent-type group then no invalidation will be performed (invalidation must be performed at the
	 *     level of the group keypair, not at the level of the exchange data).
	 *  2. The exchange data considered for invalidation is all exchange data where [dataOwnerGroupId] is one of the
	 *     members. If the data owner group itself has links to other groups, then also exchange data where one of those
	 *     groups is a member will be considered, transitively (following only simple-type links, the only kind a
	 *     simple-type group may declare).
	 *  3. Of the removed members, only the ones this removal actually cut off from the group whose exchange data is
	 *     being considered are taken into account, and that is decided for each of the groups of step 2 separately. A
	 *     data owner that is still a member of that group once the links it declared itself are gone — because it
	 *     belongs to another group that is itself a member of it — keeps its access to that exchange data
	 *     legitimately, so nothing of it is invalidated on its behalf: that would only force the exchange data of
	 *     everyone else to be recreated for nothing. This covers a member that declared several paths to a group and
	 *     lost only one, a member that was only ever linked to it transitively and therefore had nothing to lose, and
	 *     a member that lost [dataOwnerGroupId] but belongs to one of the groups above it in its own right. If no
	 *     member is left for any of the groups of step 2, no exchange data is invalidated at all.
	 *  4. If any of the members cut off from one of the groups of step 2 is itself a simple-type data owner-group then
	 *     all the exchange data of that group is invalidated; otherwise only its exchange data where there is at least
	 *     a piece for a recipient that is one of the members cut off from it
	 *
	 *  Only the links a data owner declares itself are considered and removed: a data owner that is a member of
	 *  [dataOwnerGroupId] transitively, through another group it is linked to, has no link of its own to remove, so it
	 *  is treated — and reported — as removed while it keeps that transitive membership. A transitive membership can
	 *  only be changed where the link that creates it is declared: by removing the data owner from the intermediate
	 *  group, or by removing the intermediate group from [dataOwnerGroupId]. Such a data owner is reported as removed,
	 *  but the invalidation above does not treat it as one (step 3): it is still a member, so the exchange data it can
	 *  decrypt is left usable for encryption.
	 *
	 *  Soft-deleted data owners are not ignored: they are updated and returned like any other member, and their
	 *  exchange data pieces are considered for invalidation. A soft-deleted data owner can be undeleted at any moment,
	 *  so leaving it in a group it was removed from, or leaving the exchange data it can decrypt usable for
	 *  encryption, would be unsafe.
	 *
	 *  # Interruption and retry
	 *
	 *  This method is idempotent: removing a data owner that is not a member is a no-op that still reports the data
	 *  owner as removed, and invalidating exchange data that is already invalidated is a no-op as well.
	 *
	 *  The members are updated first and the exchange data is invalidated after, so a call that terminates early —
	 *  the caller cancels it, some members could not be updated, or the invalidation itself fails, which is reported
	 *  as an error after the members have already been removed — can leave members removed while the exchange data
	 *  they can still decrypt is usable for encryption. Calling the method again with the same input picks up exactly
	 *  the work that is left, and repeating it eventually removes every member that can be removed and invalidates
	 *  everything that has to be invalidated; a caller that gets an error, or that does not receive every id it asked
	 *  for, should retry until it does.
	 *
	 *  The retry must use the same input, and not only the members missing from the result: a member that an
	 *  interrupted call already removed is no longer a member of the group, so it still counts as cut off for the
	 *  invalidation (which is why it is part of the result), and dropping it from the input would drop the exchange
	 *  data that has a piece for it from the invalidation, leaving that exchange data usable for encryption.
	 *
	 *  Note that any new exchange data created between two calls to this method will be considered for invalidation. If
	 *  the new exchange data does not have entries for any of the removed recipients then it will be untouched, unless
	 *  one of the removed recipients is a simple-type group, in which case also the new exchange data will be
	 *  invalidated.
	 */
	removeDataOwnersFromGroup(dataOwnerType: DataOwnerType, dataOwnerGroupId: string,
			membersToRemoveIds: Array<string>): Promise<Array<string>>;

}

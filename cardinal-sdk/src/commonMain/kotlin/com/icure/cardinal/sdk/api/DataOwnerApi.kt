package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.CryptoActorStubWithType
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.DataOwnerWithType
import com.icure.cardinal.sdk.model.base.DataOwnerHierarchyInfo


interface DataOwnerApi {
	/**
	 * Get the current data owner in full, regardless of its type. This method returns the full entity, including also
	 * information that is outside the scope of the [com.icure.sdk.model.base.CryptoActor] interface.
	 * Fails if the current user is not a data owner.
	 * @return the data owner associated to the current user.
	 */
	suspend fun getCurrentDataOwner(): DataOwnerWithType

	/**
	 * Get a stub of the current data owner. The stub contains only the information from the CryptoActor interface +
	 * id and rev.
	 * Fails if the current user is not a data owner.
	 * @return the crypto actor stub of the data owner associated to the current user.
	 */
	suspend fun getCurrentDataOwnerStub(): CryptoActorStubWithType

	/**
	 * If the logged user is a data owner get the current data owner id. This information is cached without expiration,
	 * and will only be updated in case of forced refresh.
	 * Fails if the current user is not a data owner.
	 * @return the current data owner id
	 */
	suspend fun getCurrentDataOwnerId(): String
	suspend fun getCurrentDataOwnerReference(): EntityReferenceInGroup

	/**
	 * If the logged user is a data owner get its data owner groups hierarchy (all types).
	 * @return the current user's data owner hierarchy tree, starting from the user itself
	 */
	suspend fun getCurrentDataOwnerHierarchyIds(): DataOwnerHierarchyInfo
//	suspend fun getCurrentDataOwnerHierarchyIdsReference(): List<EntityReferenceInGroup>

	/**
	 * Get a data owner regardless of its actual type. The logged user must have the permission to access the data
	 * owner. For example, if [ownerId] turns out to be associated to a patient, and it is not shared with the current
	 * user this method will fail.
	 * If are interested only in the [com.icure.sdk.model.base.CryptoActor] information of the data owner and its
	 * [com.icure.sdk.model.DataOwnerType] you should use the [getCryptoActorStub] method instead.
	 * @param ownerId the id of a data owner (patient, hcp or device)
	 * @return the full data owner associated to the provided id.
	 */
	suspend fun getDataOwner(ownerId: String): DataOwnerWithType

	/**
	 * Bulk variant of [getDataOwner].
	 * @param ids the ids of data owners (patients, hcps or devices)
	 * @return the full data owners associated to the provided ids.
	 */
	suspend fun getDataOwners(ids: Set<String>): List<DataOwnerWithType>

	/**
	 * Bulk variant of [getDataOwner], for use when the type of all requested data owners is already known (for
	 * example because they are all part of the same data owner hierarchy, which can only contain data owners of a
	 * single type). More efficient than [getDataOwners] since it fetches the entities directly through the
	 * type-specific bulk endpoint instead of the polymorphic one.
	 * @param ids the ids of data owners, all of type [type].
	 * @param type the type shared by all the requested data owners.
	 * @return the full data owners associated to the provided ids.
	 */
	suspend fun getDataOwnersWithKnownType(ids: Set<String>, type: DataOwnerType): List<DataOwnerWithType>

	/**
	 * Get a data owner regardless of its actual type. Does not require any special permission.
	 * @param ownerId the id of a data owner (patient, hcp or device)
	 * @return the full data owner associated to the provided id.
	 */
	suspend fun getCryptoActorStub(ownerId: String): CryptoActorStubWithType

	suspend fun getCryptoActorStubs(ids: Set<String>): List<CryptoActorStubWithType>

	/**
	 * Get a data owner regardless of its actual type. Does not require any special permission.
	 * @param ownerId the id of a data owner (patient, hcp or device)
	 * @return the full data owner associated to the provided id.
	 */
	suspend fun getCryptoActorStubInGroup(entityReferenceInGroup: EntityReferenceInGroup): CryptoActorStubWithType

	/**
	 * Get the hierarchy for the current data owner considering only parent-type links.
	 * If [from] is not null only give the hierarchy rooted at the provided parent id.
	 * @param from the id of a member of the current data owner hierarchy.
	 * @return an array starting at the topmost parent and ending at the provided parent id.
	 * @throws IllegalArgumentException If the provided id is not part of the parent hierarchy, or if the current user
	 * is not a data owner
	 */
	suspend fun getCurrentDataOwnerParentHierarchy(from: String?): DataOwnerHierarchyInfo

//	/**
//	 * If the logged user is a data owner get the current data owner and all of his parents. The returned list starts
//	 * from the topmost ancestor of the current data owner and ends with the current data owner.
//	 * Fails if the current user is not a data owner.
//	 * @return a list containing the current data owner hierarchy, ending with the current data owner.
//	 */
//	suspend fun getCurrentDataOwnerHierarchy(): List<DataOwnerWithType>

	/**
	 * Modifies the crypto actor information of a data owner. The information that can be modified depend on the
	 * permissions of the current user, by default only information that refer to the current user can be changed.
	 * @param cryptoActorStubWithTypeDto the stub with updated information
	 * @return the updated stub, with updated revision
	 */
	suspend fun modifyDataOwnerStub(cryptoActorStubWithTypeDto: CryptoActorStubWithType): CryptoActorStubWithType

	/**
	 * If the logged user is a data owner get the type of the current data owner. This information is cached.
	 * @return the type of the current data owner
	 */
	suspend fun getCurrentDataOwnerType(): DataOwnerType

	/**
	 * Clears the cache of current data owner id and parent hierarchy ids. The hierarchy of a data owner should not
	 * normally change over time, so this method should be rarely needed. The cache will be repopulated lazily.
	 */
	fun clearCurrentDataOwnerHierarchyCache()
}


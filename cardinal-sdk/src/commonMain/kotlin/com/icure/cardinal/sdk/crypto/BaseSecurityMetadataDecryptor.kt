package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.entities.DecryptedMetadataDetails
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.crypto.entities.SecureDelegationMembersDetails
import com.icure.cardinal.sdk.crypto.entities.SecurityMetadataType
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.utils.InternalIcureApi

@InternalIcureApi
interface BaseSecurityMetadataDecryptor {
	/**
	 * Decrypt security metadata of the entities by using only legacy delegations.
	 * Minimal cost as all data is cached.
	 */
	suspend fun <T : Any> decryptLegacyDelegations(
		entitiesGroupId: String?,
		entities: Collection<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, Set<T>>

	/**
	 * Decrypt security metadata of the entities by using only secure delegations for which the exchange data is
	 * already cached.
	 * Minimal cost as all data is cached.
	 */
	suspend fun <T : Any> decryptSecureDelegationsUsingCache(
		entitiesGroupId: String?,
		entities: Collection<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, Set<T>>

	/**
	 * Decrypt security metadata of the entities by using only secure delegations accessible to any data owner in
	 * [dataOwnersHierarchySubset] for which the exchange data id is already known.
	 * Medium cost as it requires one call to the backend (for retrieving the exchange data).
	 */
	suspend fun <T : Any> decryptSecureDelegationsUsingKnownExchangeData(
		entitiesGroupId: String?,
		entities: Collection<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, Set<T>>

	/**
	 * Decrypt security metadata of the entities by using only secure delegations accessible to any data owner in
	 * [dataOwnersHierarchySubset] for which the exchange data id is not readily known.
	 * High cost as it requires two call to the backend (first for retrieving the exchange data id, second for
	 * retrieving the exchange data).
	 */
	suspend fun <T : Any> decryptSecureDelegationsUsingExchangeDataMap(
		entitiesGroupId: String?,
		entities: Collection<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, Set<T>>

	/**
	 * Decrypt security metadata using all legacy and secure delegations, retrieving also exchange data from the
	 * backend if needed.
	 * If you actually want to decrypt all security metadata in an entity this method is slightly more efficient than
	 * using the incremental decryption methods, as it ensures at most 2 calls to the backend are done (instead of
	 * usually 0/1 at most 3 of incremental decryption)
	 */
	suspend fun <T : Any> decryptAll(
		entitiesGroupId: String?,
		entities: List<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, List<DecryptedMetadataDetails<T>>>

	suspend fun <T : Any> decryptAllLegacyDelegations(
		entitiesGroupId: String?,
		entities: List<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, List<DecryptedMetadataDetails<T>>>

	suspend fun <T : Any> decryptAllSecureDelegations(
		entitiesGroupId: String?,
		entities: List<HasEncryptionMetadata>,
		entitiesType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>,
		metadataType: SecurityMetadataType<T>
	): Map<String, List<DecryptedMetadataDetails<T>>>

	/**
	 * Get information for members of secure delegations in the entity. Also provides information for delegations with
	 * anonymous delegate and/or delegator if one of the delegation members is the current data owner (or a parent) AND
	 * can still access the exchange data used for that secure delegation.
	 * Doesn't use external de-anonymization information.
	 */
	suspend fun getSecureDelegationMemberDetails(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
	): Map<SecureDelegationKeyString, SecureDelegationMembersDetails>

	/**
	 * Get the maximum access level that any data owner in [dataOwnersHierarchySubset] has to [typedEntity], according
	 * to the encryption metadata.
	 * - If at least a data owner in [dataOwnersHierarchySubset] has write access the method returns [AccessLevel.Write]
	 * - If at least a data owner in [dataOwnersHierarchySubset] has read access the method returns and no data owner
	 * has write access the method returns [AccessLevel.Read]
	 * - If a data owner has no access to the entity the method returns `null`.
	 * @param typedEntity an entity
	 * @param dataOwnersHierarchySubset only exchange data that is accessible to data owners in this array will be considered when calculating the
	 * access level. This array should contain only data owners from the current data owner hierarchy.
	 * @return the access level to the entity or `null` if none of the data owners has full access to the entity.
	 */
	suspend fun getEntityAccessLevel(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>
	): AccessLevel?

	/**
	 * Same as [getEntitySecureDelegationsAccessLevel] but using only legacy delegations
	 */
	suspend fun getEntityLegacyDelegationAccessLevel(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>
	): AccessLevel?

	/**
	 * Same as [getEntitySecureDelegationsAccessLevel] but using only secure delegations
	 */
	suspend fun getEntitySecureDelegationsAccessLevel(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		dataOwnersHierarchySubset: Set<String>
	): AccessLevel?

	/**
	 * Verifies if there is at least one (encrypted) value of the given [metadataType] in the metadata supported by this decryptor, even if it can't
	 * be decrypted by the current data owner.
	 */
	fun hasAnyValueOfType(entity: HasEncryptionMetadata, metadataType: SecurityMetadataType<*>): Boolean
}
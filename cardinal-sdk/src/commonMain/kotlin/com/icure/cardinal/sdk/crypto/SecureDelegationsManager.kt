package com.icure.cardinal.sdk.crypto

import com.icure.cardinal.sdk.crypto.entities.DelegateOptions
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.crypto.entities.EntityWithEncryptionMetadataTypeName
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.requests.EntityShareOrMetadataUpdateRequest
import com.icure.cardinal.sdk.model.requests.RequestedPermission
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.utils.InternalIcureApi

@InternalIcureApi
interface SecureDelegationsManager {
	/**
	 * Note: this method does not save the updated entity.
	 * @param entity an entity, must already have secret foreign keys initialized.
	 * @param entityType the type of the entity
	 * @param secretIds the initial secret ids to include and share with the auto-delegations
	 * @param owningEntityIds the initial owning entity ids to include and share with the auto-delegations
	 * @param encryptionKeys the initial encryption keys to include and share with the auto-delegations
	 * @param autoDelegations the data owners which will initially have access to the entity in addition to the current data owner and the access level
	 * they will have on the entity.
	 * @return the entity with the security metadata initialized for the provided parameters.
	 */
	suspend fun <T : HasEncryptionMetadata> entityWithInitializedEncryptedMetadata(
		entityGroupId: String?,
		entity: T,
		entityType: EntityWithEncryptionMetadataTypeName,
		secretIds: Set<String>,
		owningEntityIds: Set<String>,
		owningEntitySecretIds: Set<String>,
		encryptionKeys: Set<HexString>,
		autoDelegations: Map<EntityReferenceInGroup, DelegateOptions>,
		alternateRootDataOwnerReference: EntityReferenceInGroup? = null
	): T

	/**
	 * Make a request for sharing an entity with a delegate or to update existing shared metadata by adding additional secretIds, encryptionKeys or
	 * owningEntityIds if there is already some metadata shared between the current data owner and the delegate. In case there is already a delegation
	 * for the delegate, and it already contains all the provided metadata, this method returns undefined, since there is no need to make any request to
	 * share the provided data.
	 * @param entity the entity to share
	 * @param delegate the id of the delegate
	 * @param shareSecretIds the secret ids to share
	 * @param shareEncryptionKeys the encryption keys to share
	 * @param shareOwningEntityIds the owning entity ids to share
	 * @param newDelegationPermissions the permissions to grant to the delegate in case a new delegation needs to be created. If this method creates an
	 * update request instead of a share request, this parameter is ignored.
	 * @return the request to share the entity, or the request to update the shared metadata for the entity, or undefined if there is no need to update
	 * the entity to allow the delegate to access the provided data.
	 */
	suspend fun makeShareOrUpdateRequestParams(
		entityGroupId: String?,
		entity: HasEncryptionMetadata,
		entityType: EntityWithEncryptionMetadataTypeName,
		delegate: EntityReferenceInGroup,
		shareSecretIds: Set<String>,
		shareEncryptionKeys: Set<HexString>,
		shareOwningEntityIds: Set<String>,
		newDelegationPermissions: RequestedPermission
	): EntityShareOrMetadataUpdateRequest?

	/**
	 * Clears any cached data owner information.
	 * Should be needed only if a data owner changes type or adds new keys.
	 */
	suspend fun clearCachedDataOwnersInfo()
}

package com.icure.cardinal.sdk.model.requests

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.collections.Map

/**
 *
 *  Parameters for the update of shared metadata. Currently only changes to secret ids, encryption
 * keys and owning entity
 *  ids are allowed. In the future we are going to allow also changes to the permissions of users
 * with access to the
 *  shared metadata.
 */
@Serializable
public data class EntitySharedMetadataUpdateRequest(
	/**
	 *
	 *  Access control hash of the metadata to update.
	 */
	public val metadataAccessControlHash: SecureDelegationKeyString,
	/**
	 *
	 *  Updates for secret ids: the key is an encrypted secret id and the value is if an entry with
	 * that encrypted secret
	 *  id should be created or deleted.
	 */
	@param:DefaultValue("emptyMap()")
	public val secretIds: Map<Base64String, EntryUpdateType> = emptyMap(),
	/**
	 *
	 *  Updates for encryption keys: a key in the map is an encrypted encryption key and the value is
	 * if an entry with
	 *  that encrypted encryption key should be created or deleted.
	 */
	@param:DefaultValue("emptyMap()")
	public val encryptionKeys: Map<Base64String, EntryUpdateType> = emptyMap(),
	/**
	 *
	 *  Updates for owning entity ids: the key is the encrypted id of an owning entity and the value is
	 * if an entry with
	 *  that encrypted owning entity id should be created or deleted.
	 */
	@param:DefaultValue("emptyMap()")
	public val owningEntityIds: Map<Base64String, EntryUpdateType> = emptyMap(),
)

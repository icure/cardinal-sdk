package com.icure.cardinal.sdk.model.requests

import com.icure.cardinal.sdk.model.specializations.AccessControlKeyHexString
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV2String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

/**
 *
 *  Holds parameters necessary to share an entity.
 */
@Serializable
public data class EntityShareRequest(
	/**
	 *
	 *  Id of the data owner which is sharing the entity (delegator), if it should be explicitly
	 * indicated or null if the
	 *  delegator requires anonymous delegations. If not null this must match the logged data owner id.
	 */
	public val explicitDelegator: String? = null,
	/**
	 *
	 *  Id of the data owner which will gain access to the entity (delegate), if it should be
	 * explicitly indicated or
	 *  null if the delegate requires anonymous delegations.
	 */
	public val explicitDelegate: String? = null,
	/**
	 *
	 *  Values generated using the access control secret of the exchange data used for the encryption
	 * of the ids and keys
	 *  to share. Once hashed they are used as secure delegation keys.
	 */
	public val accessControlKeys: Set<AccessControlKeyHexString>,
	/**
	 *
	 *  Encrypted secret ids to share with the delegate.
	 */
	@param:DefaultValue("emptySet()")
	public val secretIds: Set<Base64String> = emptySet(),
	/**
	 *
	 *  Encrypted encryption keys to share with the delegate.
	 */
	@param:DefaultValue("emptySet()")
	public val encryptionKeys: Set<Base64String> = emptySet(),
	/**
	 *
	 *  Encrypted owning entity ids to share with the delegate.
	 */
	@param:DefaultValue("emptySet()")
	public val owningEntityIds: Set<Base64String> = emptySet(),
	/**
	 *
	 *  Id of the exchange data used for the encryption of the ids and keys to share. Must be null at
	 * least one of
	 *  delegator or delegate is not explicit.
	 */
	public val exchangeDataId: String? = null,
	/**
	 *
	 *  Must be non-empty if exactly one of delegator or delegate is explicit and the other is not,
	 * empty in all other
	 *  cases.
	 */
	@param:DefaultValue("emptyMap()")
	public val encryptedExchangeDataId: Map<KeypairFingerprintV2String, Base64String> = emptyMap(),
	/**
	 *
	 *  Permissions for the delegate.
	 */
	public val requestedPermissions: RequestedPermission,
)

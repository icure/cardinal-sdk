// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

/**
 * Represents a delegation which allows a data owner to access the encrypted data of an entity and
 * specifies
 * the access control level. Created by a delegator data owner and usable by a delegate data owner,
 * using
 * exchange data for encryption and access control.
 * /
 */
@Serializable
data class SecureDelegation(
	/**
	 * Optionally the id of the delegator data owner. May be null to prevent data leakages.
	 */
	public val delegator: String? = null,
	/**
	 * Optionally the id of the delegate data owner. May be null to prevent data leakages.
	 */
	public val `delegate`: String? = null,
	/**
	 * Encrypted secret ids of the entity holding this delegation.
	 */
	@param:DefaultValue("emptySet()")
	public val secretIds: Set<Base64String> = emptySet(),
	/**
	 * Encrypted AES keys used for the encryption of the entity's data.
	 */
	@param:DefaultValue("emptySet()")
	public val encryptionKeys: Set<Base64String> = emptySet(),
	/**
	 * Encrypted ids of the owning entity (e.g., patient id for a contact).
	 */
	@param:DefaultValue("emptySet()")
	public val owningEntityIds: Set<Base64String> = emptySet(),
	/**
	 * Keys of parent delegations in the security metadata.
	 */
	@param:DefaultValue("emptySet()")
	public val parentDelegations: Set<SecureDelegationKeyString> = emptySet(),
	/**
	 * The id of the exchange data used for encryption, if both delegator and delegate are explicit.
	 */
	public val exchangeDataId: String? = null,
	/**
	 * The access level permissions for users with access to this delegation.
	 */
	public val permissions: AccessLevel,
) {
	// region SecureDelegation-SecureDelegation

	// endregion
}

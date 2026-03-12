// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import kotlinx.serialization.Serializable
import kotlin.collections.Map
import com.icure.cardinal.sdk.model.specializations.Sha256HexString
import com.icure.cardinal.sdk.utils.DefaultValue

/**
 * Holds the security metadata for user-based access control and encryption of entities.
 * Maps access control key hashes to their corresponding secure delegations.
 * /
 */
@Serializable
data class SecurityMetadata(
	/**
	 * A map from hex-encoded SHA-256 hash of an access control key to its corresponding secure
	 * delegation.
	 */
	public val secureDelegations: Map<SecureDelegationKeyString, SecureDelegation>,
) {
	// region SecurityMetadata-SecurityMetadata

	// endregion
}

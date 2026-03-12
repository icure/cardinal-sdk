package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
import kotlinx.serialization.Serializable
import kotlin.collections.Map

/**
 * Holds the security metadata for user-based access control and encryption of entities.
 * Maps access control key hashes to their corresponding secure delegations.
 * /
 */
@Serializable
public data class SecurityMetadata(
	/**
	 * A map from hex-encoded SHA-256 hash of an access control key to its corresponding secure
	 * delegation.
	 */
	public val secureDelegations: Map<SecureDelegationKeyString, SecureDelegation>,
)

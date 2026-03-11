package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

/**
 *
 *  Interface for entities that hold encryption metadata used for end-to-end encryption and access
 * control.
 *  This includes delegation keys, encrypted foreign keys, and security metadata.
 */
public interface HasEncryptionMetadata : Versionable<String> {
	public val secretForeignKeys: Set<String>

	public val cryptedForeignKeys: Map<String, Set<Delegation>>

	public val delegations: Map<String, Set<Delegation>>

	public val encryptionKeys: Map<String, Set<Delegation>>

	public val securityMetadata: SecurityMetadata?
}

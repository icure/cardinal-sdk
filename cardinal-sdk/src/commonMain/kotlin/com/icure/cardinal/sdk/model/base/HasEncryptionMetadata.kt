package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

public interface HasEncryptionMetadata : Versionable<String> {
	public val secretForeignKeys: Set<String>

	public val cryptedForeignKeys: Map<String, Set<Delegation>>

	public val delegations: Map<String, Set<Delegation>>

	public val encryptionKeys: Map<String, Set<Delegation>>

	public val securityMetadata: SecurityMetadata?
}

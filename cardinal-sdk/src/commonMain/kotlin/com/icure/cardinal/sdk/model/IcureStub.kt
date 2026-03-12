package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.Versionable
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

/**
 * A lightweight stub representation of an iCure document, containing only the core metadata fields
 * such as identifiers, timestamps, tags, codes, and encryption metadata. Used when the full entity
 * payload is not needed.
 * /
 */
@Serializable
public data class IcureStub(
	/**
	 * The unique identifier of the entity.
	 */
	override val id: String,
	/**
	 * The revision identifier for optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The timestamp in epoch milliseconds when the entity was created.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp in epoch milliseconds when the entity was last modified.
	 */
	override val modified: Long? = null,
	/**
	 * The identifier of the user who created this entity.
	 */
	override val author: String? = null,
	/**
	 * The identifier of the data owner responsible for this entity.
	 */
	override val responsible: String? = null,
	/**
	 * The set of tags associated with this entity.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * The set of codes associated with this entity.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * The soft-delete timestamp in epoch milliseconds.
	 */
	override val endOfLife: Long? = null,
	/**
	 * The set of secret foreign keys used for encryption.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The map of encrypted foreign keys, keyed by data owner identifier.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The map of access delegations, keyed by data owner identifier.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The map of encryption keys, keyed by data owner identifier.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The security metadata containing secure delegation information.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : ICureDocument<String>, Versionable<String>, HasEncryptionMetadata, HasEndOfLife

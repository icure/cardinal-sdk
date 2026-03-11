package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

public sealed interface SecureDelegationKeyMap : StoredDocument, HasEncryptionMetadata, Encryptable {
	override val id: String

	override val rev: String?

	/**
	 *
	 *  The secure delegation key this map refers to.
	 */
	public val delegationKey: String

	/**
	 *
	 *  The delegator of the secure delegation key this map refers to, if the delegator is anonymous in
	 * the delegation,
	 *  and if not encrypted.
	 *  On the server side this value should always be encrypted.
	 */
	public val delegator: String?

	/**
	 *
	 *  The delegate of the secure delegation key this map refers to, if the delegate is anonymous in
	 * the delegation,
	 *  and if not encrypted.
	 *  On the server side this value should always be encrypted.
	 */
	public val `delegate`: String?

	override val secretForeignKeys: Set<String>

	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	override val delegations: Map<String, Set<Delegation>>

	override val encryptionKeys: Map<String, Set<Delegation>>

	override val encryptedSelf: Base64String?

	override val securityMetadata: SecurityMetadata?

	override val deletionDate: Long?
}

@Serializable
public data class DecryptedSecureDelegationKeyMap(
	override val id: String,
	override val rev: String? = null,
	/**
	 *
	 *  The secure delegation key this map refers to.
	 */
	override val delegationKey: String,
	/**
	 *
	 *  The delegator of the secure delegation key this map refers to, if the delegator is anonymous in
	 * the delegation,
	 *  and if not encrypted.
	 *  On the server side this value should always be encrypted.
	 */
	override val delegator: String? = null,
	/**
	 *
	 *  The delegate of the secure delegation key this map refers to, if the delegate is anonymous in
	 * the delegation,
	 *  and if not encrypted.
	 *  On the server side this value should always be encrypted.
	 */
	override val `delegate`: String? = null,
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
	override val deletionDate: Long? = null,
) : SecureDelegationKeyMap

@Serializable
public data class EncryptedSecureDelegationKeyMap(
	override val id: String,
	override val rev: String? = null,
	/**
	 *
	 *  The secure delegation key this map refers to.
	 */
	override val delegationKey: String,
	/**
	 *
	 *  The delegator of the secure delegation key this map refers to, if the delegator is anonymous in
	 * the delegation,
	 *  and if not encrypted.
	 *  On the server side this value should always be encrypted.
	 */
	override val delegator: String? = null,
	/**
	 *
	 *  The delegate of the secure delegation key this map refers to, if the delegate is anonymous in
	 * the delegation,
	 *  and if not encrypted.
	 *  On the server side this value should always be encrypted.
	 */
	override val `delegate`: String? = null,
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
	override val deletionDate: Long? = null,
) : SecureDelegationKeyMap

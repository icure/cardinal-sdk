// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.CustomisableRoot
import com.icure.cardinal.sdk.model.base.Extendable
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DataAttachment
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import com.icure.cardinal.sdk.model.embed.DeletedAttachment
import kotlin.collections.copy

sealed interface CustomEntityBase :
	HasEncryptionMetadata,
	StoredDocument,
	ICureDocument<String>,
	CustomisableRoot,
	Extendable,
	Encryptable {
	override val id: String

	override val rev: String?

	override val deletionDate: Long?

	override val secretForeignKeys: Set<String>

	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	override val delegations: Map<String, Set<Delegation>>

	override val encryptionKeys: Map<String, Set<Delegation>>

	override val securityMetadata: SecurityMetadata?

	override val created: Long?

	override val modified: Long?

	override val author: String?

	override val responsible: String?

	public val endOfLife: Long?

	override val tags: Set<CodeStub>

	override val codes: Set<CodeStub>

	override val customisedModelVersion: Int?

	override val extensions: JsonObject?

	public val dataAttachments: Map<String, DataAttachment>

	/**
	 *
	 *  Always empty: deleted attachments are never tracked for custom entities.
	 */
	public val deletedAttachments: List<Nothing>

	override val encryptedSelf: Nothing?
	// region CustomEntityBase-CustomEntityBase

	// endregion
}

@Serializable
data class DecryptedCustomEntityBase(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val securityMetadata: SecurityMetadata? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val endOfLife: Long? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val customisedModelVersion: Int? = null,
	override val extensions: JsonObject? = null,
	@param:DefaultValue("emptyMap()")
	override val dataAttachments: Map<String, DataAttachment> = emptyMap(),
	/**
	 *
	 *  Always empty: deleted attachments are never tracked for custom entities.
	 */
	@param:DefaultValue("emptyList()")
	override val deletedAttachments: List<Nothing> = emptyList(),
	override val encryptedSelf: Nothing? = null,
) : CustomEntityBase {
	// region CustomEntityBase-DecryptedCustomEntityBase

	override fun copyWithSecurityMetadata(
		securityMetadata: SecurityMetadata,
		secretForeignKeys: Set<String>,
	): CustomEntityBase =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

@Serializable
data class EncryptedCustomEntityBase(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val securityMetadata: SecurityMetadata? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val endOfLife: Long? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val customisedModelVersion: Int? = null,
	override val extensions: JsonObject? = null,
	@param:DefaultValue("emptyMap()")
	override val dataAttachments: Map<String, DataAttachment> = emptyMap(),
	/**
	 *
	 *  Always empty: deleted attachments are never tracked for custom entities.
	 */
	@param:DefaultValue("emptyList()")
	override val deletedAttachments: List<Nothing> = emptyList(),
	override val encryptedSelf: Nothing? = null,
) : CustomEntityBase {
	// region CustomEntityBase-EncryptedCustomEntityBase

	override fun copyWithSecurityMetadata(
		securityMetadata: SecurityMetadata,
		secretForeignKeys: Set<String>,
	): CustomEntityBase =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

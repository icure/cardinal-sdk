package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.embed.TaskStatus
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface MaintenanceTask :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable,
	HasEndOfLife {
	override val id: String

	override val rev: String?

	public val identifier: List<Identifier>

	override val created: Long?

	override val modified: Long?

	override val author: String?

	override val responsible: String?

	override val tags: Set<CodeStub>

	override val codes: Set<CodeStub>

	override val endOfLife: Long?

	override val deletionDate: Long?

	public val taskType: String?

	public val properties: Set<PropertyStub>

	public val status: TaskStatus

	override val secretForeignKeys: Set<String>

	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	override val delegations: Map<String, Set<Delegation>>

	override val encryptionKeys: Map<String, Set<Delegation>>

	override val encryptedSelf: Base64String?

	override val securityMetadata: SecurityMetadata?
	// region MaintenanceTask-MaintenanceTask
	companion object {
		const val KRAKEN_QUALIFIED_NAME = "org.taktik.icure.entities.MaintenanceTask"
	}
	// endregion
}

@Serializable
data class DecryptedMaintenanceTask(
	override val id: String,
	override val rev: String? = null,
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val taskType: String? = null,
	@param:DefaultValue("emptySet()")
	override val properties: Set<DecryptedPropertyStub> = emptySet(),
	@param:DefaultValue("com.icure.cardinal.sdk.model.embed.TaskStatus.Pending")
	override val status: TaskStatus = TaskStatus.Pending,
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
) : MaintenanceTask {
	// region MaintenanceTask-DecryptedMaintenanceTask
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedMaintenanceTask =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

@Serializable
data class EncryptedMaintenanceTask(
	override val id: String,
	override val rev: String? = null,
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val taskType: String? = null,
	@param:DefaultValue("emptySet()")
	override val properties: Set<EncryptedPropertyStub> = emptySet(),
	@param:DefaultValue("com.icure.cardinal.sdk.model.embed.TaskStatus.Pending")
	override val status: TaskStatus = TaskStatus.Pending,
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
) : MaintenanceTask {
	// region MaintenanceTask-EncryptedMaintenanceTask
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedMaintenanceTask =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

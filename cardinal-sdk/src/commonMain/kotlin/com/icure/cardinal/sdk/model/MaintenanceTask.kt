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

/**
 * Represents a maintenance task in the iCure system. Maintenance tasks are used to track background
 * operations
 * such as key exchange requests, data migrations, or other administrative operations that require
 * asynchronous processing.
 * /
 */
public sealed interface MaintenanceTask :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable,
	HasEndOfLife {
	/**
	 * The unique identifier of the maintenance task.
	 */
	override val id: String

	/**
	 * The revision of the maintenance task in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String?

	/**
	 * The identifiers of the maintenance task.
	 */
	public val identifier: List<Identifier>

	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long?

	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long?

	/**
	 * The id of the User that created this maintenance task.
	 */
	override val author: String?

	/**
	 * The id of the HealthcareParty that is responsible for this maintenance task.
	 */
	override val responsible: String?

	/**
	 * Tags that qualify the maintenance task as being member of a certain class.
	 */
	override val tags: Set<CodeStub>

	/**
	 * Codes that identify or qualify this particular maintenance task.
	 */
	override val codes: Set<CodeStub>

	/**
	 * Soft delete (unix epoch in ms) timestamp of the object.
	 */
	override val endOfLife: Long?

	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long?

	/**
	 * The type of the maintenance task.
	 */
	public val taskType: String?

	/**
	 * Extra properties for the maintenance task.
	 */
	public val properties: Set<PropertyStub>

	/**
	 * The current status of the maintenance task (pending, ongoing, cancelled, completed).
	 */
	public val status: TaskStatus

	/**
	 * The secret patient key, encrypted in the patient's own AES key.
	 */
	override val secretForeignKeys: Set<String>

	/**
	 * The patient id encrypted in the delegates' AES keys.
	 */
	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	/**
	 * The delegations giving access to connected healthcare information.
	 */
	override val delegations: Map<String, Set<Delegation>>

	/**
	 * The keys used to encrypt this entity when stored encrypted.
	 */
	override val encryptionKeys: Map<String, Set<Delegation>>

	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String?

	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata?
}

/**
 * Represents a maintenance task in the iCure system. Maintenance tasks are used to track background
 * operations
 * such as key exchange requests, data migrations, or other administrative operations that require
 * asynchronous processing.
 * /
 */
@Serializable
public data class DecryptedMaintenanceTask(
	/**
	 * The unique identifier of the maintenance task.
	 */
	override val id: String,
	/**
	 * The revision of the maintenance task in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String? = null,
	/**
	 * The identifiers of the maintenance task.
	 */
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that created this maintenance task.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this maintenance task.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the maintenance task as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular maintenance task.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Soft delete (unix epoch in ms) timestamp of the object.
	 */
	override val endOfLife: Long? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The type of the maintenance task.
	 */
	override val taskType: String? = null,
	/**
	 * Extra properties for the maintenance task.
	 */
	@param:DefaultValue("emptySet()")
	override val properties: Set<DecryptedPropertyStub> = emptySet(),
	/**
	 * The current status of the maintenance task (pending, ongoing, cancelled, completed).
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.model.embed.TaskStatus.Pending")
	override val status: TaskStatus = TaskStatus.Pending,
	/**
	 * The secret patient key, encrypted in the patient's own AES key.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The patient id encrypted in the delegates' AES keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The keys used to encrypt this entity when stored encrypted.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : MaintenanceTask

/**
 * Represents a maintenance task in the iCure system. Maintenance tasks are used to track background
 * operations
 * such as key exchange requests, data migrations, or other administrative operations that require
 * asynchronous processing.
 * /
 */
@Serializable
public data class EncryptedMaintenanceTask(
	/**
	 * The unique identifier of the maintenance task.
	 */
	override val id: String,
	/**
	 * The revision of the maintenance task in the database, used for conflict management / optimistic
	 * locking.
	 */
	override val rev: String? = null,
	/**
	 * The identifiers of the maintenance task.
	 */
	@param:DefaultValue("emptyList()")
	override val identifier: List<Identifier> = emptyList(),
	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that created this maintenance task.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this maintenance task.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the maintenance task as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular maintenance task.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Soft delete (unix epoch in ms) timestamp of the object.
	 */
	override val endOfLife: Long? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The type of the maintenance task.
	 */
	override val taskType: String? = null,
	/**
	 * Extra properties for the maintenance task.
	 */
	@param:DefaultValue("emptySet()")
	override val properties: Set<EncryptedPropertyStub> = emptySet(),
	/**
	 * The current status of the maintenance task (pending, ongoing, cancelled, completed).
	 */
	@param:DefaultValue("com.icure.cardinal.sdk.model.embed.TaskStatus.Pending")
	override val status: TaskStatus = TaskStatus.Pending,
	/**
	 * The secret patient key, encrypted in the patient's own AES key.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The patient id encrypted in the delegates' AES keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The keys used to encrypt this entity when stored encrypted.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : MaintenanceTask

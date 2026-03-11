package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.ICureDocument
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

/**
 * Represents application-level settings stored as key-value pairs. Settings can be stored in
 * plaintext or encrypted form.
 * /
 */
public sealed interface ApplicationSettings :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable,
	HasEndOfLife {
	/**
	 * The Id of the application settings.
	 */
	override val id: String

	/**
	 * The revision of the application settings in the database, used for conflict management /
	 * optimistic locking.
	 */
	override val rev: String?

	/**
	 * The timestamp (unix epoch in ms) of creation of this entity.
	 */
	override val created: Long?

	/**
	 * The timestamp (unix epoch in ms) of the latest modification of this entity.
	 */
	override val modified: Long?

	/**
	 * The id of the User that created this entity.
	 */
	override val author: String?

	/**
	 * The id of the data owner that is responsible for this entity.
	 */
	override val responsible: String?

	/**
	 * Tags that qualify this entity as being member of a certain class.
	 */
	override val tags: Set<CodeStub>

	/**
	 * Codes that identify or qualify this entity.
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
	 * A map of plaintext application settings as key-value pairs.
	 */
	public val settings: Map<String, String>

	/**
	 * A map of encrypted application settings as key-value pairs.
	 */
	public val encryptedSettings: Map<String, String>

	/**
	 * The secret foreign keys, used for secure linking.
	 */
	override val secretForeignKeys: Set<String>

	/**
	 * The encrypted foreign keys.
	 */
	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	/**
	 * The delegations giving access to connected healthcare information.
	 */
	override val delegations: Map<String, Set<Delegation>>

	/**
	 * The encryption keys used to encrypt secured properties, encrypted for separate Crypto Actors.
	 */
	override val encryptionKeys: Map<String, Set<Delegation>>

	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata?

	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String?
}

/**
 * Represents application-level settings stored as key-value pairs. Settings can be stored in
 * plaintext or encrypted form.
 * /
 */
@Serializable
public data class DecryptedApplicationSettings(
	/**
	 * The Id of the application settings.
	 */
	override val id: String,
	/**
	 * The revision of the application settings in the database, used for conflict management /
	 * optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation of this entity.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification of this entity.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that created this entity.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this entity.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify this entity as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this entity.
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
	 * A map of plaintext application settings as key-value pairs.
	 */
	@param:DefaultValue("emptyMap()")
	override val settings: Map<String, String> = emptyMap(),
	/**
	 * A map of encrypted application settings as key-value pairs.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptedSettings: Map<String, String> = emptyMap(),
	/**
	 * The secret foreign keys, used for secure linking.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The encrypted foreign keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The encryption keys used to encrypt secured properties, encrypted for separate Crypto Actors.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata? = null,
	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String? = null,
) : ApplicationSettings

/**
 * Represents application-level settings stored as key-value pairs. Settings can be stored in
 * plaintext or encrypted form.
 * /
 */
@Serializable
public data class EncryptedApplicationSettings(
	/**
	 * The Id of the application settings.
	 */
	override val id: String,
	/**
	 * The revision of the application settings in the database, used for conflict management /
	 * optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation of this entity.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification of this entity.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the User that created this entity.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this entity.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify this entity as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this entity.
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
	 * A map of plaintext application settings as key-value pairs.
	 */
	@param:DefaultValue("emptyMap()")
	override val settings: Map<String, String> = emptyMap(),
	/**
	 * A map of encrypted application settings as key-value pairs.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptedSettings: Map<String, String> = emptyMap(),
	/**
	 * The secret foreign keys, used for secure linking.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The encrypted foreign keys.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The encryption keys used to encrypt secured properties, encrypted for separate Crypto Actors.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata? = null,
	/**
	 * The base64-encoded encrypted fields of this entity.
	 */
	override val encryptedSelf: Base64String? = null,
) : ApplicationSettings

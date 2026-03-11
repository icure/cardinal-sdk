package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.serialization.InstantSerializer
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set
import kotlin.time.Instant

/**
 * Represents an access log entry that records access to medical data or resources within the
 * system.
 * /
 */
public sealed interface AccessLog :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable {
	/**
	 * The Id of the access log. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String

	/**
	 * The revision of the access log in the database, used for conflict management / optimistic
	 * locking.
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
	 * The id of the User that created this access log.
	 */
	override val author: String?

	/**
	 * The id of the data owner that is responsible for this access log.
	 */
	override val responsible: String?

	/**
	 * Tags that qualify the access log as being member of a certain class.
	 */
	override val tags: Set<CodeStub>

	/**
	 * Codes that identify or qualify this particular access log.
	 */
	override val codes: Set<CodeStub>

	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long?

	/**
	 * Id of the object that is being requested.
	 */
	public val objectId: String?

	/**
	 * The type of access.
	 */
	public val accessType: String?

	/**
	 * Id of the user making the requests.
	 */
	public val user: String?

	/**
	 * Further details about the access.
	 */
	public val detail: String?

	/**
	 * The date of logging, filled instantaneously.
	 */
	public val date: Instant?

	/**
	 * The secret foreign keys of the access log, used for secure linking to patients.
	 */
	override val secretForeignKeys: Set<String>

	/**
	 * The encrypted foreign keys, mapping owner data owner id to encrypted patient ids.
	 */
	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	/**
	 * The delegations giving access to all connected healthcare information.
	 */
	override val delegations: Map<String, Set<Delegation>>

	/**
	 * The encryption keys used to encrypt the secured properties, encrypted for separate Crypto
	 * Actors.
	 */
	override val encryptionKeys: Map<String, Set<Delegation>>

	/**
	 * The base64-encoded encrypted fields of this access log.
	 */
	override val encryptedSelf: Base64String?

	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata?
}

/**
 * Represents an access log entry that records access to medical data or resources within the
 * system.
 * /
 */
@Serializable
public data class DecryptedAccessLog(
	/**
	 * The Id of the access log. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the access log in the database, used for conflict management / optimistic
	 * locking.
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
	 * The id of the User that created this access log.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this access log.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the access log as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular access log.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * Id of the object that is being requested.
	 */
	override val objectId: String? = null,
	/**
	 * The type of access.
	 */
	override val accessType: String? = null,
	/**
	 * Id of the user making the requests.
	 */
	override val user: String? = null,
	/**
	 * Further details about the access.
	 */
	override val detail: String? = null,
	/**
	 * The date of logging, filled instantaneously.
	 */
	@Serializable(with = InstantSerializer::class)
	override val date: Instant? = null,
	/**
	 * The secret foreign keys of the access log, used for secure linking to patients.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The encrypted foreign keys, mapping owner data owner id to encrypted patient ids.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to all connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The encryption keys used to encrypt the secured properties, encrypted for separate Crypto
	 * Actors.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The base64-encoded encrypted fields of this access log.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : AccessLog

/**
 * Represents an access log entry that records access to medical data or resources within the
 * system.
 * /
 */
@Serializable
public data class EncryptedAccessLog(
	/**
	 * The Id of the access log. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the access log in the database, used for conflict management / optimistic
	 * locking.
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
	 * The id of the User that created this access log.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this access log.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the access log as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular access log.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * Id of the object that is being requested.
	 */
	override val objectId: String? = null,
	/**
	 * The type of access.
	 */
	override val accessType: String? = null,
	/**
	 * Id of the user making the requests.
	 */
	override val user: String? = null,
	/**
	 * Further details about the access.
	 */
	override val detail: String? = null,
	/**
	 * The date of logging, filled instantaneously.
	 */
	@Serializable(with = InstantSerializer::class)
	override val date: Instant? = null,
	/**
	 * The secret foreign keys of the access log, used for secure linking to patients.
	 */
	@param:DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	/**
	 * The encrypted foreign keys, mapping owner data owner id to encrypted patient ids.
	 */
	@param:DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The delegations giving access to all connected healthcare information.
	 */
	@param:DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The encryption keys used to encrypt the secured properties, encrypted for separate Crypto
	 * Actors.
	 */
	@param:DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	/**
	 * The base64-encoded encrypted fields of this access log.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : AccessLog

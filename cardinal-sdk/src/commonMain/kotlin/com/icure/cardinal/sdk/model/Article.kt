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
 * Represents an article entity used to store named, classified content items.
 * /
 */
public sealed interface Article :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable,
	HasEndOfLife {
	/**
	 * The Id of the article. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String

	/**
	 * The revision of the article in the database, used for conflict management / optimistic locking.
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
	 * The id of the User that created this article.
	 */
	override val author: String?

	/**
	 * The id of the data owner that is responsible for this article.
	 */
	override val responsible: String?

	/**
	 * Tags that qualify the article as being member of a certain class.
	 */
	override val tags: Set<CodeStub>

	/**
	 * Codes that identify or qualify this particular article.
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
	 * The name of the article.
	 */
	public val name: String?

	/**
	 * The classification category of the article.
	 */
	public val classification: String?

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
	 * The base64-encoded encrypted fields of this article.
	 */
	override val encryptedSelf: Base64String?

	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata?
}

/**
 * Represents an article entity used to store named, classified content items.
 * /
 */
@Serializable
public data class DecryptedArticle(
	/**
	 * The Id of the article. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the article in the database, used for conflict management / optimistic locking.
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
	 * The id of the User that created this article.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this article.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the article as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular article.
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
	 * The name of the article.
	 */
	override val name: String? = null,
	/**
	 * The classification category of the article.
	 */
	override val classification: String? = null,
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
	 * The base64-encoded encrypted fields of this article.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : Article

/**
 * Represents an article entity used to store named, classified content items.
 * /
 */
@Serializable
public data class EncryptedArticle(
	/**
	 * The Id of the article. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the article in the database, used for conflict management / optimistic locking.
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
	 * The id of the User that created this article.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this article.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the article as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular article.
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
	 * The name of the article.
	 */
	override val name: String? = null,
	/**
	 * The classification category of the article.
	 */
	override val classification: String? = null,
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
	 * The base64-encoded encrypted fields of this article.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : Article

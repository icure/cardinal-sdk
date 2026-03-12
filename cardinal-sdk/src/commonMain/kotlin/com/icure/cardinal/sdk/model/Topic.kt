// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
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
 * Represents a topic for secure messaging between healthcare parties. A topic groups messages in a
 * conversation
 * and can be linked to health elements and services for medical context.
 * /
 */

sealed interface Topic :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable {
	/**
	 * The unique identifier of the topic.
	 */
	override val id: String

	/**
	 * The revision of the topic in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String?

	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long?

	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long?

	/**
	 * The id of the health element linked to this topic.
	 */
	public val healthElementId: String?

	/**
	 * The id of the contact linked to this topic.
	 */
	public val contactId: String?

	/**
	 * A description of the topic.
	 */
	public val description: String?

	/**
	 * Codes that identify or qualify this particular topic.
	 */
	override val codes: Set<CodeStub>

	/**
	 * Tags that qualify the topic as being member of a certain class.
	 */
	override val tags: Set<CodeStub>

	/**
	 * The id of the User that created this topic.
	 */
	override val author: String?

	/**
	 * The id of the HealthcareParty that is responsible for this topic.
	 */
	override val responsible: String?

	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long?

	/**
	 * Map of active participants with their roles (participant, admin, or owner).
	 */
	public val activeParticipants: Map<String, TopicRole>

	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata?

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
	 * Set of ids of health elements linked to this topic.
	 */
	public val linkedHealthElements: Set<String>

	/**
	 * Set of ids of services linked to this topic.
	 */
	public val linkedServices: Set<String>
	// region Topic-Topic
	companion object {
		const val KRAKEN_QUALIFIED_NAME = "org.taktik.icure.entities.Topic"
	}
	// endregion
}

/**
 * Represents a topic for secure messaging between healthcare parties. A topic groups messages in a
 * conversation
 * and can be linked to health elements and services for medical context.
 * /
 */
@Serializable
data class DecryptedTopic(
	/**
	 * The unique identifier of the topic.
	 */
	override val id: String,
	/**
	 * The revision of the topic in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the health element linked to this topic.
	 */
	override val healthElementId: String? = null,
	/**
	 * The id of the contact linked to this topic.
	 */
	override val contactId: String? = null,
	/**
	 * A description of the topic.
	 */
	override val description: String? = null,
	/**
	 * Codes that identify or qualify this particular topic.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Tags that qualify the topic as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * The id of the User that created this topic.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this topic.
	 */
	override val responsible: String? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * Map of active participants with their roles (participant, admin, or owner).
	 */
	@param:DefaultValue("emptyMap()")
	override val activeParticipants: Map<String, TopicRole> = emptyMap(),
	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata? = null,
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
	 * Set of ids of health elements linked to this topic.
	 */
	@param:DefaultValue("emptySet()")
	override val linkedHealthElements: Set<String> = emptySet(),
	/**
	 * Set of ids of services linked to this topic.
	 */
	@param:DefaultValue("emptySet()")
	override val linkedServices: Set<String> = emptySet(),
) : Topic {
	// region Topic-DecryptedTopic
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedTopic =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

/**
 * Represents a topic for secure messaging between healthcare parties. A topic groups messages in a
 * conversation
 * and can be linked to health elements and services for medical context.
 * /
 */
@Serializable
data class EncryptedTopic(
	/**
	 * The unique identifier of the topic.
	 */
	override val id: String,
	/**
	 * The revision of the topic in the database, used for conflict management / optimistic locking.
	 */
	override val rev: String? = null,
	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long? = null,
	/**
	 * The id of the health element linked to this topic.
	 */
	override val healthElementId: String? = null,
	/**
	 * The id of the contact linked to this topic.
	 */
	override val contactId: String? = null,
	/**
	 * A description of the topic.
	 */
	override val description: String? = null,
	/**
	 * Codes that identify or qualify this particular topic.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Tags that qualify the topic as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * The id of the User that created this topic.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this topic.
	 */
	override val responsible: String? = null,
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * Map of active participants with their roles (participant, admin, or owner).
	 */
	@param:DefaultValue("emptyMap()")
	override val activeParticipants: Map<String, TopicRole> = emptyMap(),
	/**
	 * The security metadata of the entity.
	 */
	override val securityMetadata: SecurityMetadata? = null,
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
	 * Set of ids of health elements linked to this topic.
	 */
	@param:DefaultValue("emptySet()")
	override val linkedHealthElements: Set<String> = emptySet(),
	/**
	 * Set of ids of services linked to this topic.
	 */
	@param:DefaultValue("emptySet()")
	override val linkedServices: Set<String> = emptySet(),
) : Topic {
	// region Topic-EncryptedTopic
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedTopic =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.MessageReadStatus
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

/**
 * Represents a message exchanged between healthcare parties. Messages can be used for internal
 * communication,
 * eHealth box messages, eFact batches, and other types of healthcare-related communications.
 * /
 */
public sealed interface Message :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable {
	/**
	 * The ID of the message. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String

	/**
	 * The revision of the message in the database, used for conflict management / optimistic locking.
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
	 * The id of the User that created this message.
	 */
	override val author: String?

	/**
	 * The id of the HealthcareParty that is responsible for this message.
	 */
	override val responsible: String?

	/**
	 * Tags that qualify the message as being member of a certain class.
	 */
	override val tags: Set<CodeStub>

	/**
	 * Codes that identify or qualify this particular message.
	 */
	override val codes: Set<CodeStub>

	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long?

	/**
	 * Address of the sender of the message.
	 */
	public val fromAddress: String?

	/**
	 * ID of the healthcare party sending the message.
	 */
	public val fromHealthcarePartyId: String?

	/**
	 * List of IDs of healthcare parties to whom the message is addressed.
	 */
	public val recipients: Set<String>

	/**
	 * The addresses of the recipients of the message.
	 */
	public val toAddresses: Set<String>

	/**
	 * The timestamp (unix epoch in ms) when the message was received.
	 */
	public val received: Long?

	/**
	 * The timestamp (unix epoch in ms) when the message was sent.
	 */
	public val sent: Long?

	/**
	 * Additional metadata for the message.
	 */
	public val metas: Map<String, String>

	/**
	 * Status showing whether the message is read or not and the time of reading.
	 */
	public val readStatus: Map<String, MessageReadStatus>

	/**
	 * Transport-level identifier for the message, format depends on the transport type.
	 */
	public val transportGuid: String?

	/**
	 * An additional remark on the message.
	 */
	public val remark: String?

	/**
	 * The guid of the conversation this message belongs to.
	 */
	public val conversationGuid: String?

	/**
	 * Subject for the message.
	 */
	public val subject: String?

	/**
	 * Set of IDs for invoices in the message.
	 */
	public val invoiceIds: Set<String>

	/**
	 * ID of a parent in a message conversation.
	 */
	public val parentId: String?

	/**
	 * Extra properties for the message.
	 */
	public val properties: Set<PropertyStub>

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
 * Represents a message exchanged between healthcare parties. Messages can be used for internal
 * communication,
 * eHealth box messages, eFact batches, and other types of healthcare-related communications.
 * /
 */
@Serializable
public data class DecryptedMessage(
	/**
	 * The ID of the message. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the message in the database, used for conflict management / optimistic locking.
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
	 * The id of the User that created this message.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this message.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the message as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular message.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * Address of the sender of the message.
	 */
	override val fromAddress: String? = null,
	/**
	 * ID of the healthcare party sending the message.
	 */
	override val fromHealthcarePartyId: String? = null,
	/**
	 * List of IDs of healthcare parties to whom the message is addressed.
	 */
	@param:DefaultValue("emptySet()")
	override val recipients: Set<String> = emptySet(),
	/**
	 * The addresses of the recipients of the message.
	 */
	@param:DefaultValue("emptySet()")
	override val toAddresses: Set<String> = emptySet(),
	/**
	 * The timestamp (unix epoch in ms) when the message was received.
	 */
	override val received: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) when the message was sent.
	 */
	override val sent: Long? = null,
	/**
	 * Additional metadata for the message.
	 */
	@param:DefaultValue("emptyMap()")
	override val metas: Map<String, String> = emptyMap(),
	/**
	 * Status showing whether the message is read or not and the time of reading.
	 */
	@param:DefaultValue("emptyMap()")
	override val readStatus: Map<String, MessageReadStatus> = emptyMap(),
	/**
	 * Transport-level identifier for the message, format depends on the transport type.
	 */
	override val transportGuid: String? = null,
	/**
	 * An additional remark on the message.
	 */
	override val remark: String? = null,
	/**
	 * The guid of the conversation this message belongs to.
	 */
	override val conversationGuid: String? = null,
	/**
	 * Subject for the message.
	 */
	override val subject: String? = null,
	/**
	 * Set of IDs for invoices in the message.
	 */
	@param:DefaultValue("emptySet()")
	override val invoiceIds: Set<String> = emptySet(),
	/**
	 * ID of a parent in a message conversation.
	 */
	override val parentId: String? = null,
	/**
	 * Extra properties for the message.
	 */
	@param:DefaultValue("emptySet()")
	override val properties: Set<DecryptedPropertyStub> = emptySet(),
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
) : Message

/**
 * Represents a message exchanged between healthcare parties. Messages can be used for internal
 * communication,
 * eHealth box messages, eFact batches, and other types of healthcare-related communications.
 * /
 */
@Serializable
public data class EncryptedMessage(
	/**
	 * The ID of the message. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the message in the database, used for conflict management / optimistic locking.
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
	 * The id of the User that created this message.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this message.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the message as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular message.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * Address of the sender of the message.
	 */
	override val fromAddress: String? = null,
	/**
	 * ID of the healthcare party sending the message.
	 */
	override val fromHealthcarePartyId: String? = null,
	/**
	 * List of IDs of healthcare parties to whom the message is addressed.
	 */
	@param:DefaultValue("emptySet()")
	override val recipients: Set<String> = emptySet(),
	/**
	 * The addresses of the recipients of the message.
	 */
	@param:DefaultValue("emptySet()")
	override val toAddresses: Set<String> = emptySet(),
	/**
	 * The timestamp (unix epoch in ms) when the message was received.
	 */
	override val received: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) when the message was sent.
	 */
	override val sent: Long? = null,
	/**
	 * Additional metadata for the message.
	 */
	@param:DefaultValue("emptyMap()")
	override val metas: Map<String, String> = emptyMap(),
	/**
	 * Status showing whether the message is read or not and the time of reading.
	 */
	@param:DefaultValue("emptyMap()")
	override val readStatus: Map<String, MessageReadStatus> = emptyMap(),
	/**
	 * Transport-level identifier for the message, format depends on the transport type.
	 */
	override val transportGuid: String? = null,
	/**
	 * An additional remark on the message.
	 */
	override val remark: String? = null,
	/**
	 * The guid of the conversation this message belongs to.
	 */
	override val conversationGuid: String? = null,
	/**
	 * Subject for the message.
	 */
	override val subject: String? = null,
	/**
	 * Set of IDs for invoices in the message.
	 */
	@param:DefaultValue("emptySet()")
	override val invoiceIds: Set<String> = emptySet(),
	/**
	 * ID of a parent in a message conversation.
	 */
	override val parentId: String? = null,
	/**
	 * Extra properties for the message.
	 */
	@param:DefaultValue("emptySet()")
	override val properties: Set<EncryptedPropertyStub> = emptySet(),
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
) : Message

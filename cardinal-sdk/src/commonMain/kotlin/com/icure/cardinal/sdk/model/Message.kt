// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.CustomisableRoot
import com.icure.cardinal.sdk.model.base.Extendable
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.HasMedicalLocation
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.MessageAttachment
import com.icure.cardinal.sdk.model.embed.MessageReadStatus
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlin.Deprecated
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

/**
 * Represents a message exchanged between healthcare parties. Messages can be used for internal communication,
 * eHealth box messages, eFact batches, and other types of healthcare-related communications.
 * /
 */

sealed interface Message :
	StoredDocument,
	ICureDocument<String>,
	HasMedicalLocation,
	HasEncryptionMetadata,
	Encryptable,
	CustomisableRoot,
	Extendable {
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
	 * The id of the medical location where this message was created.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val medicalLocationId: String?

	/**
	 * Tags that qualify the message as being member of a certain class.
	 */
	override val tags: Set<CodeStub>

	/**
	 * Codes that identify or qualify this particular message.
	 */
	override val codes: Set<CodeStub>

	/**
	 * Soft delete (unix epoch in ms) timestamp of the object.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val endOfLife: Long?

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
	 * The id of the form linked to this message.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val formId: String?

	/**
	 * Status of the message as a bitfield.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val status: Int?

	/**
	 * The type of user who is the recipient of this message.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val recipientsType: String?

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
	 * List of message attachments.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val messageAttachments: List<MessageAttachment>

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
	 * External reference for the message.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val externalRef: String?

	/**
	 * Set of unassigned result references.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val unassignedResults: Set<String>

	/**
	 * Map of assigned results (ContactId to reference).
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val assignedResults: Map<String, String>

	/**
	 * Map of sender references.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	public val senderReferences: Map<String, String>

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

	override val extensions: JsonObject?

	override val customisedModelVersion: Int?
	// region Message-Message
	companion object{
		const val KRAKEN_QUALIFIED_NAME = "org.taktik.icure.entities.Message"
	}
	// endregion
}

/**
 * Represents a message exchanged between healthcare parties. Messages can be used for internal communication,
 * eHealth box messages, eFact batches, and other types of healthcare-related communications.
 * /
 */
@Serializable
data class DecryptedMessage(
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
	 * The id of the medical location where this message was created.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val medicalLocationId: String? = null,
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
	 * Soft delete (unix epoch in ms) timestamp of the object.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val endOfLife: Long? = null,
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
	 * The id of the form linked to this message.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val formId: String? = null,
	/**
	 * Status of the message as a bitfield.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val status: Int? = null,
	/**
	 * The type of user who is the recipient of this message.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val recipientsType: String? = null,
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
	 * List of message attachments.
	 */
	@param:DefaultValue("emptyList()")
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val messageAttachments: List<MessageAttachment> = emptyList(),
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
	 * External reference for the message.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val externalRef: String? = null,
	/**
	 * Set of unassigned result references.
	 */
	@param:DefaultValue("emptySet()")
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val unassignedResults: Set<String> = emptySet(),
	/**
	 * Map of assigned results (ContactId to reference).
	 */
	@param:DefaultValue("emptyMap()")
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val assignedResults: Map<String, String> = emptyMap(),
	/**
	 * Map of sender references.
	 */
	@param:DefaultValue("emptyMap()")
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val senderReferences: Map<String, String> = emptyMap(),
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
	override val extensions: JsonObject? = null,
	override val customisedModelVersion: Int? = null,
) : Message {
	// region Message-DecryptedMessage
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedMessage =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

/**
 * Represents a message exchanged between healthcare parties. Messages can be used for internal communication,
 * eHealth box messages, eFact batches, and other types of healthcare-related communications.
 * /
 */
@Serializable
data class EncryptedMessage(
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
	 * The id of the medical location where this message was created.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val medicalLocationId: String? = null,
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
	 * Soft delete (unix epoch in ms) timestamp of the object.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val endOfLife: Long? = null,
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
	 * The id of the form linked to this message.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val formId: String? = null,
	/**
	 * Status of the message as a bitfield.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val status: Int? = null,
	/**
	 * The type of user who is the recipient of this message.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val recipientsType: String? = null,
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
	 * List of message attachments.
	 */
	@param:DefaultValue("emptyList()")
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val messageAttachments: List<MessageAttachment> = emptyList(),
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
	 * External reference for the message.
	 */
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val externalRef: String? = null,
	/**
	 * Set of unassigned result references.
	 */
	@param:DefaultValue("emptySet()")
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val unassignedResults: Set<String> = emptySet(),
	/**
	 * Map of assigned results (ContactId to reference).
	 */
	@param:DefaultValue("emptyMap()")
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val assignedResults: Map<String, String> = emptyMap(),
	/**
	 * Map of sender references.
	 */
	@param:DefaultValue("emptyMap()")
	@Deprecated("This field is deprecated for the use with Cardinal SDK")
	override val senderReferences: Map<String, String> = emptyMap(),
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
	override val extensions: JsonObject? = null,
	override val customisedModelVersion: Int? = null,
) : Message {
	// region Message-EncryptedMessage
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedMessage =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

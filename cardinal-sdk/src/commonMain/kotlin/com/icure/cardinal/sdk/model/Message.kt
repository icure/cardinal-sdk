package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
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
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

public sealed interface Message :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable {
	override val id: String

	override val rev: String?

	override val created: Long?

	override val modified: Long?

	override val author: String?

	override val responsible: String?

	override val medicalLocationId: String?

	override val tags: Set<CodeStub>

	override val codes: Set<CodeStub>

	override val endOfLife: Long?

	override val deletionDate: Long?

	public val fromAddress: String?

	public val fromHealthcarePartyId: String?

	public val formId: String?

	public val status: Int?

	public val recipientsType: String?

	public val recipients: Set<String>

	public val toAddresses: Set<String>

	public val received: Long?

	public val sent: Long?

	public val metas: Map<String, String>

	public val readStatus: Map<String, MessageReadStatus>

	public val messageAttachments: List<MessageAttachment>

	public val transportGuid: String?

	public val remark: String?

	public val conversationGuid: String?

	public val subject: String?

	public val invoiceIds: Set<String>

	public val parentId: String?

	public val externalRef: String?

	public val unassignedResults: Set<String>

	public val assignedResults: Map<String, String>

	public val senderReferences: Map<String, String>

	override val secretForeignKeys: Set<String>

	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	override val delegations: Map<String, Set<Delegation>>

	override val encryptionKeys: Map<String, Set<Delegation>>

	override val encryptedSelf: Base64String?

	override val securityMetadata: SecurityMetadata?
}

@Serializable
public data class DecryptedMessage(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val fromAddress: String? = null,
	override val fromHealthcarePartyId: String? = null,
	override val formId: String? = null,
	override val status: Int? = null,
	override val recipientsType: String? = null,
	@DefaultValue("emptySet()")
	override val recipients: Set<String> = emptySet(),
	@DefaultValue("emptySet()")
	override val toAddresses: Set<String> = emptySet(),
	override val received: Long? = null,
	override val sent: Long? = null,
	@DefaultValue("emptyMap()")
	override val metas: Map<String, String> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val readStatus: Map<String, MessageReadStatus> = emptyMap(),
	@DefaultValue("emptyList()")
	override val messageAttachments: List<MessageAttachment> = emptyList(),
	override val transportGuid: String? = null,
	override val remark: String? = null,
	override val conversationGuid: String? = null,
	override val subject: String? = null,
	@DefaultValue("emptySet()")
	override val invoiceIds: Set<String> = emptySet(),
	override val parentId: String? = null,
	override val externalRef: String? = null,
	@DefaultValue("emptySet()")
	override val unassignedResults: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val assignedResults: Map<String, String> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val senderReferences: Map<String, String> = emptyMap(),
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Message

@Serializable
public data class EncryptedMessage(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val fromAddress: String? = null,
	override val fromHealthcarePartyId: String? = null,
	override val formId: String? = null,
	override val status: Int? = null,
	override val recipientsType: String? = null,
	@DefaultValue("emptySet()")
	override val recipients: Set<String> = emptySet(),
	@DefaultValue("emptySet()")
	override val toAddresses: Set<String> = emptySet(),
	override val received: Long? = null,
	override val sent: Long? = null,
	@DefaultValue("emptyMap()")
	override val metas: Map<String, String> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val readStatus: Map<String, MessageReadStatus> = emptyMap(),
	@DefaultValue("emptyList()")
	override val messageAttachments: List<MessageAttachment> = emptyList(),
	override val transportGuid: String? = null,
	override val remark: String? = null,
	override val conversationGuid: String? = null,
	override val subject: String? = null,
	@DefaultValue("emptySet()")
	override val invoiceIds: Set<String> = emptySet(),
	override val parentId: String? = null,
	override val externalRef: String? = null,
	@DefaultValue("emptySet()")
	override val unassignedResults: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val assignedResults: Map<String, String> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val senderReferences: Map<String, String> = emptyMap(),
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
) : Message

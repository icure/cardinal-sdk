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
import com.icure.cardinal.sdk.model.embed.MessageAttachment
import kotlin.Int
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface Message :
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

	override val tags: Set<CodeStub>

	override val codes: Set<CodeStub>

	override val deletionDate: Long?

	public val fromAddress: String?

	public val fromHealthcarePartyId: String?

	public val recipients: Set<String>

	public val toAddresses: Set<String>

	public val received: Long?

	public val sent: Long?

	public val metas: Map<String, String>

	public val readStatus: Map<String, MessageReadStatus>

	public val transportGuid: String?

	public val remark: String?

	public val conversationGuid: String?

	public val subject: String?

	public val invoiceIds: Set<String>

	public val parentId: String?

	override val secretForeignKeys: Set<String>

	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	override val delegations: Map<String, Set<Delegation>>

	override val encryptionKeys: Map<String, Set<Delegation>>

	override val encryptedSelf: Base64String?

	override val securityMetadata: SecurityMetadata?
	// region Message-Message
	companion object{
		const val KRAKEN_QUALIFIED_NAME = "org.taktik.icure.entities.Message"
	}
	// endregion
}

@Serializable
data class DecryptedMessage(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val deletionDate: Long? = null,
	override val fromAddress: String? = null,
	override val fromHealthcarePartyId: String? = null,
	@param:DefaultValue("emptySet()")
	override val recipients: Set<String> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val toAddresses: Set<String> = emptySet(),
	override val received: Long? = null,
	override val sent: Long? = null,
	@param:DefaultValue("emptyMap()")
	override val metas: Map<String, String> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val readStatus: Map<String, MessageReadStatus> = emptyMap(),
	override val transportGuid: String? = null,
	override val remark: String? = null,
	override val conversationGuid: String? = null,
	override val subject: String? = null,
	@param:DefaultValue("emptySet()")
	override val invoiceIds: Set<String> = emptySet(),
	override val parentId: String? = null,
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
) : Message {
	// region Message-DecryptedMessage
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedMessage =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

@Serializable
data class EncryptedMessage(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val deletionDate: Long? = null,
	override val fromAddress: String? = null,
	override val fromHealthcarePartyId: String? = null,
	@param:DefaultValue("emptySet()")
	override val recipients: Set<String> = emptySet(),
	@param:DefaultValue("emptySet()")
	override val toAddresses: Set<String> = emptySet(),
	override val received: Long? = null,
	override val sent: Long? = null,
	@param:DefaultValue("emptyMap()")
	override val metas: Map<String, String> = emptyMap(),
	@param:DefaultValue("emptyMap()")
	override val readStatus: Map<String, MessageReadStatus> = emptyMap(),
	override val transportGuid: String? = null,
	override val remark: String? = null,
	override val conversationGuid: String? = null,
	override val subject: String? = null,
	@param:DefaultValue("emptySet()")
	override val invoiceIds: Set<String> = emptySet(),
	override val parentId: String? = null,
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
) : Message {
	// region Message-EncryptedMessage
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedMessage =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

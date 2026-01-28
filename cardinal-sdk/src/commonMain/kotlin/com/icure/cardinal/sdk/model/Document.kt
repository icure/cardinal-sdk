package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DataAttachment
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.DeletedAttachment
import com.icure.cardinal.sdk.model.embed.DocumentStatus
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import com.icure.cardinal.sdk.model.embed.DocumentLocation
import com.icure.cardinal.sdk.model.embed.DocumentType
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import kotlin.ByteArray

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface Document :
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

	public val documentStatus: DocumentStatus?

	public val externalUri: String?

	public val name: String?

	public val version: String?

	public val size: Long?

	public val hash: String?

	public val openingContactId: String?

	public val attachmentId: String?

	public val objectStoreReference: String?

	public val mainUti: String?

	public val otherUtis: Set<String>

	public val secondaryAttachments: Map<String, DataAttachment>

	public val deletedAttachments: List<DeletedAttachment>

	override val secretForeignKeys: Set<String>

	override val cryptedForeignKeys: Map<String, Set<Delegation>>

	override val delegations: Map<String, Set<Delegation>>

	override val encryptionKeys: Map<String, Set<Delegation>>

	override val encryptedSelf: Base64String?

	override val securityMetadata: SecurityMetadata?
	// region Document-Document

	// endregion
}

@Serializable
data class DecryptedDocument(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val deletionDate: Long? = null,
	override val documentStatus: DocumentStatus? = null,
	override val externalUri: String? = null,
	override val name: String? = null,
	override val version: String? = null,
	override val size: Long? = null,
	override val hash: String? = null,
	override val openingContactId: String? = null,
	override val attachmentId: String? = null,
	override val objectStoreReference: String? = null,
	override val mainUti: String? = null,
	@DefaultValue("emptySet()")
	override val otherUtis: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val secondaryAttachments: Map<String, DataAttachment> = emptyMap(),
	@DefaultValue("emptyList()")
	override val deletedAttachments: List<DeletedAttachment> = emptyList(),
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
) : Document {
	// region Document-DecryptedDocument
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedDocument =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

@Serializable
data class EncryptedDocument(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val deletionDate: Long? = null,
	override val documentStatus: DocumentStatus? = null,
	override val externalUri: String? = null,
	override val name: String? = null,
	override val version: String? = null,
	override val size: Long? = null,
	override val hash: String? = null,
	override val openingContactId: String? = null,
	override val attachmentId: String? = null,
	override val objectStoreReference: String? = null,
	override val mainUti: String? = null,
	@DefaultValue("emptySet()")
	override val otherUtis: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val secondaryAttachments: Map<String, DataAttachment> = emptyMap(),
	@DefaultValue("emptyList()")
	override val deletedAttachments: List<DeletedAttachment> = emptyList(),
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
) : Document {
	// region Document-EncryptedDocument
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedDocument =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

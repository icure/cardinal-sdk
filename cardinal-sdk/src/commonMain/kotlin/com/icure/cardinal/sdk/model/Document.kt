package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DataAttachment
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.DeletedAttachment
import com.icure.cardinal.sdk.model.embed.DocumentLocation
import com.icure.cardinal.sdk.model.embed.DocumentStatus
import com.icure.cardinal.sdk.model.embed.DocumentType
import com.icure.cardinal.sdk.model.embed.Encryptable
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.specializations.Base64String
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v2.dto.base.CodeStubDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.DataAttachmentDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.DelegationDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.DeletedAttachmentDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.DocumentLocationDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.DocumentStatusDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.DocumentTypeDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.SecurityMetadataDto
import org.taktik.icure.services.`external`.rest.v2.dto.specializations.Base64StringDto
import kotlin.ByteArray
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

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

	override val medicalLocationId: String?

	override val tags: Set<CodeStubDto>

	override val codes: Set<CodeStubDto>

	override val endOfLife: Long?

	override val deletionDate: Long?

	public val documentLocation: DocumentLocationDto?

	public val documentType: DocumentTypeDto?

	public val documentStatus: DocumentStatusDto?

	public val externalUri: String?

	public val name: String?

	public val version: String?

	public val storedICureDocumentId: String?

	public val externalUuid: String?

	public val size: Long?

	public val hash: String?

	public val openingContactId: String?

	public val attachmentId: String?

	public val objectStoreReference: String?

	public val mainUti: String?

	public val otherUtis: Set<String>

	public val secondaryAttachments: Map<String, DataAttachmentDto>

	public val deletedAttachments: List<DeletedAttachmentDto>

	public val encryptedAttachment: ByteArray?

	public val decryptedAttachment: ByteArray?

	override val secretForeignKeys: Set<String>

	override val cryptedForeignKeys: Map<String, Set<DelegationDto>>

	override val delegations: Map<String, Set<DelegationDto>>

	override val encryptionKeys: Map<String, Set<DelegationDto>>

	override val encryptedSelf: Base64StringDto?

	override val securityMetadata: SecurityMetadataDto?
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
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val documentLocation: DocumentLocation? = null,
	override val documentType: DocumentType? = null,
	override val documentStatus: DocumentStatus? = null,
	override val externalUri: String? = null,
	override val name: String? = null,
	override val version: String? = null,
	override val storedICureDocumentId: String? = null,
	override val externalUuid: String? = null,
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
	@Serializable(with = ByteArraySerializer::class)
	override val encryptedAttachment: ByteArray? = null,
	@Serializable(with = ByteArraySerializer::class)
	override val decryptedAttachment: ByteArray? = null,
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
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val documentLocation: DocumentLocation? = null,
	override val documentType: DocumentType? = null,
	override val documentStatus: DocumentStatus? = null,
	override val externalUri: String? = null,
	override val name: String? = null,
	override val version: String? = null,
	override val storedICureDocumentId: String? = null,
	override val externalUuid: String? = null,
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
	@Serializable(with = ByteArraySerializer::class)
	override val encryptedAttachment: ByteArray? = null,
	@Serializable(with = ByteArraySerializer::class)
	override val decryptedAttachment: ByteArray? = null,
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

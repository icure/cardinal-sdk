package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEncryptionMetadata
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DataAttachment
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.DeletedAttachment
import com.icure.cardinal.sdk.model.embed.DocumentStatus
import com.icure.cardinal.sdk.model.embed.DocumentType
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

/**
 * Represents a document entity stored in CouchDB. Documents can have main and secondary data
 * attachments,
 * and support various storage backends (CouchDB attachments, object storage).
 * /
 */
public sealed interface Document :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable {
	/**
	 * The Id of the document. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String

	/**
	 * The revision of the document in the database, used for conflict management / optimistic locking.
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
	 * The id of the User that created this document.
	 */
	override val author: String?

	/**
	 * The id of the data owner that is responsible for this document.
	 */
	override val responsible: String?

	/**
	 * Tags that qualify the document as being member of a certain class.
	 */
	override val tags: Set<CodeStub>

	/**
	 * Codes that identify or qualify this particular document.
	 */
	override val codes: Set<CodeStub>

	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long?

	/**
	 * The type of document (e.g., admission, clinical path, document report, invoice).
	 */
	public val documentType: DocumentType?

	/**
	 * The status of the document development (e.g., Draft, finalized, reviewed, signed).
	 */
	public val documentStatus: DocumentStatus?

	/**
	 * When the document is stored externally, the URI of the document in that repository.
	 */
	public val externalUri: String?

	/**
	 * The name of the document.
	 */
	public val name: String?

	/**
	 * The document version.
	 */
	public val version: String?

	/**
	 * The size of the document file.
	 */
	public val size: Long?

	/**
	 * The hashed version of the document.
	 */
	public val hash: String?

	/**
	 * The id of the contact during which the document was created.
	 */
	public val openingContactId: String?

	/**
	 * The id of the main attachment stored as a CouchDB attachment.
	 */
	public val attachmentId: String?

	/**
	 * The id of the main attachment in the object storage service.
	 */
	public val objectStoreReference: String?

	/**
	 * The main Uniform Type Identifier of the main attachment.
	 */
	public val mainUti: String?

	/**
	 * Extra Uniform Type Identifiers for the main attachment.
	 */
	public val otherUtis: Set<String>

	/**
	 * Secondary attachments for this document.
	 */
	public val secondaryAttachments: Map<String, DataAttachment>

	/**
	 * Information on past attachments for this document.
	 */
	public val deletedAttachments: List<DeletedAttachment>

	/**
	 * The secret foreign keys, used for secure linking to patients.
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
	 * The base64-encoded encrypted fields of this document.
	 */
	override val encryptedSelf: Base64String?

	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata?
}

/**
 * Represents a document entity stored in CouchDB. Documents can have main and secondary data
 * attachments,
 * and support various storage backends (CouchDB attachments, object storage).
 * /
 */
@Serializable
public data class DecryptedDocument(
	/**
	 * The Id of the document. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the document in the database, used for conflict management / optimistic locking.
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
	 * The id of the User that created this document.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this document.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the document as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular document.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The type of document (e.g., admission, clinical path, document report, invoice).
	 */
	override val documentType: DocumentType? = null,
	/**
	 * The status of the document development (e.g., Draft, finalized, reviewed, signed).
	 */
	override val documentStatus: DocumentStatus? = null,
	/**
	 * When the document is stored externally, the URI of the document in that repository.
	 */
	override val externalUri: String? = null,
	/**
	 * The name of the document.
	 */
	override val name: String? = null,
	/**
	 * The document version.
	 */
	override val version: String? = null,
	/**
	 * The size of the document file.
	 */
	override val size: Long? = null,
	/**
	 * The hashed version of the document.
	 */
	override val hash: String? = null,
	/**
	 * The id of the contact during which the document was created.
	 */
	override val openingContactId: String? = null,
	/**
	 * The id of the main attachment stored as a CouchDB attachment.
	 */
	override val attachmentId: String? = null,
	/**
	 * The id of the main attachment in the object storage service.
	 */
	override val objectStoreReference: String? = null,
	/**
	 * The main Uniform Type Identifier of the main attachment.
	 */
	override val mainUti: String? = null,
	/**
	 * Extra Uniform Type Identifiers for the main attachment.
	 */
	@param:DefaultValue("emptySet()")
	override val otherUtis: Set<String> = emptySet(),
	/**
	 * Secondary attachments for this document.
	 */
	@param:DefaultValue("emptyMap()")
	override val secondaryAttachments: Map<String, DataAttachment> = emptyMap(),
	/**
	 * Information on past attachments for this document.
	 */
	@param:DefaultValue("emptyList()")
	override val deletedAttachments: List<DeletedAttachment> = emptyList(),
	/**
	 * The secret foreign keys, used for secure linking to patients.
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
	 * The base64-encoded encrypted fields of this document.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : Document

/**
 * Represents a document entity stored in CouchDB. Documents can have main and secondary data
 * attachments,
 * and support various storage backends (CouchDB attachments, object storage).
 * /
 */
@Serializable
public data class EncryptedDocument(
	/**
	 * The Id of the document. We encourage using either a v4 UUID or a HL7 Id.
	 */
	override val id: String,
	/**
	 * The revision of the document in the database, used for conflict management / optimistic locking.
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
	 * The id of the User that created this document.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this document.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the document as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular document.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * Hard delete (unix epoch in ms) timestamp of the object.
	 */
	override val deletionDate: Long? = null,
	/**
	 * The type of document (e.g., admission, clinical path, document report, invoice).
	 */
	override val documentType: DocumentType? = null,
	/**
	 * The status of the document development (e.g., Draft, finalized, reviewed, signed).
	 */
	override val documentStatus: DocumentStatus? = null,
	/**
	 * When the document is stored externally, the URI of the document in that repository.
	 */
	override val externalUri: String? = null,
	/**
	 * The name of the document.
	 */
	override val name: String? = null,
	/**
	 * The document version.
	 */
	override val version: String? = null,
	/**
	 * The size of the document file.
	 */
	override val size: Long? = null,
	/**
	 * The hashed version of the document.
	 */
	override val hash: String? = null,
	/**
	 * The id of the contact during which the document was created.
	 */
	override val openingContactId: String? = null,
	/**
	 * The id of the main attachment stored as a CouchDB attachment.
	 */
	override val attachmentId: String? = null,
	/**
	 * The id of the main attachment in the object storage service.
	 */
	override val objectStoreReference: String? = null,
	/**
	 * The main Uniform Type Identifier of the main attachment.
	 */
	override val mainUti: String? = null,
	/**
	 * Extra Uniform Type Identifiers for the main attachment.
	 */
	@param:DefaultValue("emptySet()")
	override val otherUtis: Set<String> = emptySet(),
	/**
	 * Secondary attachments for this document.
	 */
	@param:DefaultValue("emptyMap()")
	override val secondaryAttachments: Map<String, DataAttachment> = emptyMap(),
	/**
	 * Information on past attachments for this document.
	 */
	@param:DefaultValue("emptyList()")
	override val deletedAttachments: List<DeletedAttachment> = emptyList(),
	/**
	 * The secret foreign keys, used for secure linking to patients.
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
	 * The base64-encoded encrypted fields of this document.
	 */
	override val encryptedSelf: Base64String? = null,
	/**
	 * The security metadata of this entity, for access control.
	 */
	override val securityMetadata: SecurityMetadata? = null,
) : Document

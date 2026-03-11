package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.ReportVersion
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.DocumentGroup
import com.icure.cardinal.sdk.model.embed.DocumentType
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.ByteArray
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

/**
 * Represents a template for generating documents. Document templates define the structure, type,
 * and content
 * that can be used to produce actual documents.
 * /
 */
@Serializable
public data class DocumentTemplate(
	/**
	 * The Id of the document template.
	 */
	override val id: String,
	/**
	 * The revision of the document template in the database, used for conflict management / optimistic
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
	 * The id of the User that created this document template.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this document template.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the document template as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular document template.
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
	 * The binary content of the template attachment.
	 */
	@Serializable(with = ByteArraySerializer::class)
	public val attachment: ByteArray? = null,
	/**
	 * The type of document (e.g., admission, clinical path, document report, invoice).
	 */
	public val documentType: DocumentType? = null,
	/**
	 * The main Uniform Type Identifier of the template attachment.
	 */
	public val mainUti: String? = null,
	/**
	 * The name of the document template.
	 */
	public val name: String? = null,
	/**
	 * Extra Uniform Type Identifiers for the template attachment.
	 */
	@param:DefaultValue("emptySet()")
	public val otherUtis: Set<String> = emptySet(),
	/**
	 * The id of the CouchDB attachment for the template.
	 */
	public val attachmentId: String? = null,
	/**
	 * The version of the report template.
	 */
	public val version: ReportVersion? = null,
	/**
	 * The owner of the document template.
	 */
	public val owner: String? = null,
	/**
	 * A globally unique identifier for the template.
	 */
	public val guid: String? = null,
	/**
	 * The document group this template belongs to.
	 */
	public val group: DocumentGroup? = null,
	/**
	 * A description of the document template.
	 */
	public val descr: String? = null,
	/**
	 * Whether this template is disabled.
	 */
	public val disabled: String? = null,
	/**
	 * The medical specialty associated with this template.
	 */
	public val specialty: CodeStub? = null,
) : StoredDocument, ICureDocument<String>, HasEndOfLife

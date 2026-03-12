package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.KeywordSubword
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

/**
 * Represents a keyword used for indexing and searching medical data. A keyword can contain
 * sub-words to enable more flexible search matching.
 * /
 */
@Serializable
public data class Keyword(
	/**
	 * The unique identifier of the keyword.
	 */
	override val id: String,
	/**
	 * The revision of the keyword in the database, used for conflict management / optimistic locking.
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
	 * The id of the User that created this keyword.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this keyword.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the keyword as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular keyword.
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
	 * The keyword value.
	 */
	public val `value`: String? = null,
	/**
	 * The set of sub-words associated with this keyword.
	 */
	@param:DefaultValue("emptySet()")
	public val subWords: Set<KeywordSubword> = emptySet(),
	/**
	 * The id of the user who owns this keyword.
	 */
	public val userId: String? = null,
) : StoredDocument, ICureDocument<String>, HasEndOfLife

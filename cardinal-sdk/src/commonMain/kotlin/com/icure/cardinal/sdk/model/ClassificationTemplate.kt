package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

/**
 * Represents a template for classifications, defining a reusable structure that classifications can
 * be based on.
 * /
 */
@Serializable
public data class ClassificationTemplate(
	/**
	 * The Id of the classification template.
	 */
	override val id: String,
	/**
	 * The revision of the classification template in the database, used for conflict management /
	 * optimistic locking.
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
	 * The id of the User that created this classification template.
	 */
	override val author: String? = null,
	/**
	 * The id of the data owner that is responsible for this classification template.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the classification template as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular classification template.
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
	 * The id of the parent classification template, for nesting.
	 */
	public val parentId: String? = null,
	/**
	 * A human-readable label for this classification template.
	 */
	public val label: String,
) : StoredDocument, ICureDocument<String>, HasEndOfLife

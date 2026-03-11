package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.StoredDocument
import com.icure.cardinal.sdk.model.embed.PlanOfActionTemplate
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

/**
 * Represents a template for creating healthcare elements. Health element templates provide a
 * predefined structure
 * for commonly used healthcare elements, including plans of action and default status values.
 * /
 */
@Serializable
public data class HealthElementTemplate(
	/**
	 * The unique identifier of the health element template.
	 */
	override val id: String,
	/**
	 * The revision of the template in the database, used for conflict management / optimistic locking.
	 *
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
	 * The id of the User that created this template.
	 */
	override val author: String? = null,
	/**
	 * The id of the HealthcareParty that is responsible for this template.
	 */
	override val responsible: String? = null,
	/**
	 * Tags that qualify the template as being member of a certain class.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * Codes that identify or qualify this particular template.
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
	 * Description of the health element template.
	 */
	public val descr: String? = null,
	/**
	 * A text note associated with the template.
	 */
	public val note: String? = null,
	/**
	 * Bit field: bit 0 = active/inactive, bit 1 = relevant/irrelevant, bit 2 = present/absent.
	 */
	@param:DefaultValue("0")
	public val status: Int = 0,
	/**
	 * Whether the health element template is relevant.
	 */
	@param:DefaultValue("true")
	public val relevant: Boolean = true,
	/**
	 * List of plan of action templates associated with this health element template.
	 */
	@param:DefaultValue("emptyList()")
	public val plansOfAction: List<PlanOfActionTemplate> = emptyList(),
) : StoredDocument, ICureDocument<String>, HasEndOfLife

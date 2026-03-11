// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.base.HasEndOfLife
import com.icure.cardinal.sdk.model.base.ICureDocument
import com.icure.cardinal.sdk.model.base.Named
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set

/**
 * Represents a template for a plan of action, defining a reusable structure of forms and metadata
 * that can be applied to healthcare elements.
 * /
 */
@Serializable
data class PlanOfActionTemplate(
	/**
	 * The unique identifier of this plan of action template.
	 */
	override val id: String,
	/**
	 * The timestamp (unix epoch in ms) of creation.
	 */
	override val created: Long? = null,
	/**
	 * The timestamp (unix epoch in ms) of the latest modification.
	 */
	override val modified: Long? = null,
	/**
	 * The identifier of the author.
	 */
	override val author: String? = null,
	/**
	 * The identifier of the responsible entity.
	 */
	override val responsible: String? = null,
	/**
	 * The set of tags associated with this template.
	 */
	@param:DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	/**
	 * The set of codes associated with this template.
	 */
	@param:DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	/**
	 * The soft-delete timestamp.
	 */
	override val endOfLife: Long? = null,
	/**
	 * The name of this plan of action template.
	 */
	override val name: String? = null,
	/**
	 * A description of the template.
	 */
	public val descr: String? = null,
	/**
	 * A note associated with the template.
	 */
	public val note: String? = null,
	/**
	 * Whether this template is relevant.
	 */
	@param:DefaultValue("true")
	public val relevant: Boolean = true,
	/**
	 * A bitmask status (bit 0: active/inactive, bit 1: relevant/irrelevant, bit 2: present/absent).
	 */
	@param:DefaultValue("0")
	public val status: Int = 0,
	/**
	 * The list of form skeletons that compose this template.
	 */
	@param:DefaultValue("emptyList()")
	public val forms: List<FormSkeleton> = emptyList(),
) : ICureDocument<String>, Named, HasEndOfLife {
	// region PlanOfActionTemplate-PlanOfActionTemplate

	// endregion
}

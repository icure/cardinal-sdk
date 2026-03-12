package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Represents a section within a form template layout, containing a set of structure elements
 * (fields and groups).
 * /
 */
@Serializable
public data class Section(
	/**
	 * The name or identifier of this section.
	 */
	public val section: String,
	/**
	 * The list of structure elements in this section.
	 */
	public val fields: List<StructureElement>,
	/**
	 * A description of this section.
	 */
	public val description: String? = null,
	/**
	 * Keywords associated with this section for search purposes.
	 */
	public val keywords: List<String>? = null,
)

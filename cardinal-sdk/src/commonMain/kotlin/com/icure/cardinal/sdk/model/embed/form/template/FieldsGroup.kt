package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Represents a group of structure elements within a form template section, used to organize fields
 * logically.
 * /
 */
@Serializable
public data class FieldsGroup(
	/**
	 * The name or identifier of this group.
	 */
	public val group: String,
	/**
	 * The list of structure elements (fields or nested groups) in this group.
	 */
	public val fields: List<StructureElement>? = null,
) : StructureElement

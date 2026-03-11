// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
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
data class FieldsGroup(
	/**
	 * The name or identifier of this group.
	 */
	public val group: String,
	/**
	 * The list of structure elements (fields or nested groups) in this group.
	 */
	public val fields: List<StructureElement>? = null,
) : StructureElement {
	// region FieldsGroup-FieldsGroup

	// endregion
}

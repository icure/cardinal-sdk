package com.icure.cardinal.sdk.model.embed.form.template

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

/**
 * Represents the layout of a form template, defining the form name, its actions, sections, and
 * metadata.
 * /
 */
@Serializable
public data class FormTemplateLayout(
	/**
	 * The name or identifier of the form.
	 */
	public val form: String,
	/**
	 * The list of actions available in this form template.
	 */
	@param:DefaultValue("emptyList()")
	public val actions: List<Action> = emptyList(),
	/**
	 * The list of sections composing this form template.
	 */
	@param:DefaultValue("emptyList()")
	public val sections: List<Section> = emptyList(),
	/**
	 * A description of the form template.
	 */
	public val description: String? = null,
	/**
	 * Keywords associated with the form template for search purposes.
	 */
	public val keywords: List<String>? = null,
)

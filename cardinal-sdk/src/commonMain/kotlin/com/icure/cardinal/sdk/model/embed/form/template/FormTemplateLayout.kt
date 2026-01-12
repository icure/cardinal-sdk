package com.icure.cardinal.sdk.model.embed.form.template

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@Serializable
public data class FormTemplateLayout(
	public val form: String,
	@DefaultValue("emptyList()")
	public val actions: List<Action> = emptyList(),
	@DefaultValue("emptyList()")
	public val sections: List<Section> = emptyList(),
	public val description: String? = null,
	public val keywords: List<String>? = null,
)

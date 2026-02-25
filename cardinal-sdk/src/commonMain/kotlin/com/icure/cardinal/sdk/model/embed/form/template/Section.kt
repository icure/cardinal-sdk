package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@Serializable
public data class Section(
	public val section: String,
	public val fields: List<StructureElement>,
	public val description: String? = null,
	public val keywords: List<String>? = null,
)

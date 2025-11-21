package com.icure.cardinal.sdk.model.embed.form.template

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@Serializable
public data class FieldsGroup(
	public val group: String,
	public val fields: List<StructureElement>? = null,
) : StructureElement

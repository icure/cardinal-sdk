package com.icure.cardinal.sdk.model.filter.formtemplate

import com.icure.cardinal.sdk.model.FormTemplate
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@SerialName("FormTemplateBySpecialtyFilter")
@Serializable
public data class FormTemplateBySpecialtyFilter(
	public val specialtyCode: String,
	override val desc: String? = null,
) : AbstractFilter<FormTemplate>

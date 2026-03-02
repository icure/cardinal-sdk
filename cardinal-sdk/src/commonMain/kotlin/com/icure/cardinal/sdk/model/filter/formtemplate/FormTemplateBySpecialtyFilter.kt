package com.icure.cardinal.sdk.model.filter.formtemplate

import com.icure.cardinal.sdk.model.FormTemplate
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("FormTemplateBySpecialtyFilter")
@Serializable
data class FormTemplateBySpecialtyFilter(
	public val specialtyCode: String,
	override val desc: String? = null,
) : AbstractFilter<FormTemplate> {
	// region FormTemplateBySpecialtyFilter-FormTemplateBySpecialtyFilter

	// endregion
}

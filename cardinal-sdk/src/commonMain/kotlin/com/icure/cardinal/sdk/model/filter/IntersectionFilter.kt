package com.icure.cardinal.sdk.model.filter

import com.icure.cardinal.sdk.model.base.Identifiable
import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("IntersectionFilter")
@Serializable
data class IntersectionFilter<O : Identifiable<String>>(
	override val desc: String? = null,
	@DefaultValue("emptyList()")
	override val filters: List<AbstractFilter<O>> = emptyList(),
	internal val dtoSerialName: String,
) : AbstractFilter<O>, Filter.IntersectionFilter<O> {
	// region IntersectionFilter-IntersectionFilter

	// endregion
}

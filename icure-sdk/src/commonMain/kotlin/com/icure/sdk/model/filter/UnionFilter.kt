package com.icure.sdk.model.filter

import com.icure.sdk.model.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("UnionFilter")
@Serializable
data class UnionFilter<O : Identifiable<String>>(
	override val desc: String? = null,
	override val filters: List<AbstractFilter<O>> = emptyList(),
) : AbstractFilter<O>, Filter.UnionFilter<O> {
	// region UnionFilter-UnionFilter

	// endregion
}

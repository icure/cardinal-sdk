package com.icure.cardinal.sdk.model.filter

import com.icure.cardinal.sdk.model.base.Identifiable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import com.icure.cardinal.sdk.utils.DefaultValue

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("UnionFilter")
@Serializable
data class UnionFilter<O : Identifiable<String>>(
	desc: String? = null,
	filters: List<AbstractFilter<O>> = emptyList(),
) : AbstractFilter<O>, Filter.UnionFilter<O> {
	// region UnionFilter-UnionFilter

	// endregion
}

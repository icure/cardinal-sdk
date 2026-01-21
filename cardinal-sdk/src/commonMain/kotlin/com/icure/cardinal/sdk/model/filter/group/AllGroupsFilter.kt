package com.icure.cardinal.sdk.model.filter.group

import com.icure.cardinal.sdk.model.Group
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("AllGroupsFilter")
@Serializable
data class AllGroupsFilter(
	desc: String? = null,
) : AbstractFilter<Group> {
	// region AllGroupsFilter-AllGroupsFilter

	// endregion
}

package com.icure.cardinal.sdk.model.filter.user

import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("UserByIdsFilter")
@Serializable
data class UserByIdsFilter(
	ids: Set<String>,
	desc: String? = null,
) : AbstractFilter<User>, Filter.IdsFilter<String, User> {
	// region UserByIdsFilter-UserByIdsFilter

	// endregion
}

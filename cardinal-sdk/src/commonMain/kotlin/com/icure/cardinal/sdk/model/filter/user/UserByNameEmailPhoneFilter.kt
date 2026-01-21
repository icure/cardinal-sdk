package com.icure.cardinal.sdk.model.filter.user

import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("UserByNameEmailPhoneFilter")
@Serializable
data class UserByNameEmailPhoneFilter(
	searchString: String,
	desc: String? = null,
) : AbstractFilter<User> {
	// region UserByNameEmailPhoneFilter-UserByNameEmailPhoneFilter

	// endregion
}

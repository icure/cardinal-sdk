// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.user

import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * A filter that matches all users without any additional criteria.
 * /
 */
@SerialName("AllUsersFilter")
@Serializable
data class AllUsersFilter(
	/**
	 * Optional human-readable description of this filter instance.
	 */
	override val desc: String? = null,
) : AbstractFilter<User>, Filter.AllFilter<User> {
	// region AllUsersFilter-AllUsersFilter

	// endregion
}

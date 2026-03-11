// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.filter.user

import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

/**
 * A filter that matches users by a free-text search string applied against name, email, and phone
 * fields.
 * /
 */
@SerialName("UserByNameEmailPhoneFilter")
@Serializable
data class UserByNameEmailPhoneFilter(
	/**
	 * The search string to match against user name, email address, or phone number.
	 */
	public val searchString: String,
	/**
	 * Optional human-readable description of this filter instance.
	 */
	override val desc: String? = null,
) : AbstractFilter<User> {
	// region UserByNameEmailPhoneFilter-UserByNameEmailPhoneFilter

	// endregion
}

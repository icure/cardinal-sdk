// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * DTO returned upon successful registration of a data owner, containing the credentials needed for
 * initial login.
 * /
 */
@Serializable
data class DataOwnerRegistrationSuccess(
	/**
	 * The login identifier of the newly registered user.
	 */
	public val userLogin: String,
	/**
	 * The unique identifier of the newly created user.
	 */
	public val userId: String,
	/**
	 * The authentication token for the newly registered user.
	 */
	public val token: String,
) {
	// region DataOwnerRegistrationSuccess-DataOwnerRegistrationSuccess

	// endregion
}

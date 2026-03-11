// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * DTO containing the credentials for user authentication.
 * /
 */
@Serializable
data class LoginCredentials(
	/**
	 * The username or login identifier.
	 */
	public val username: String? = null,
	/**
	 * The password for authentication.
	 */
	public val password: String? = null,
) {
	// region LoginCredentials-LoginCredentials

	// endregion
}

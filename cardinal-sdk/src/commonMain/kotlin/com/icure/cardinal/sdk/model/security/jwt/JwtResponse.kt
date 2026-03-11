// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.security.jwt

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

/**
 *
 *  Response returned by JWT-based authentication endpoints, containing the issued tokens upon
 * successful login.
 */
@Serializable
data class JwtResponse(
	/**
	 * The short-lived JWT access token, or null if authentication was not successful.
	 */
	public val token: String? = null,
	/**
	 * The longer-lived refresh token used to obtain new access tokens, or null if not issued.
	 */
	public val refreshToken: String? = null,
	/**
	 * Whether the authentication attempt succeeded.
	 */
	@param:DefaultValue("false")
	public val successful: Boolean = false,
) {
	// region JwtResponse-JwtResponse

	// endregion
}

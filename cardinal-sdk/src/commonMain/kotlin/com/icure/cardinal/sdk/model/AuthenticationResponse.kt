// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

/**
 *
 *  Response object returned after an authentication attempt.
 */
@Serializable
class AuthenticationResponse(
	/**
	 * The unique identifier of the healthcare party associated with the authenticated user.
	 */
	public val healthcarePartyId: String? = null,
	/**
	 * The reason for authentication failure, if applicable.
	 */
	public val reason: String? = null,
	/**
	 * Whether the authentication attempt was successful.
	 */
	@param:DefaultValue("false")
	public val successful: Boolean = false,
	/**
	 * The username of the authenticated user.
	 */
	public val username: String? = null,
) {
	// region AuthenticationResponse-AuthenticationResponse

	// endregion
}

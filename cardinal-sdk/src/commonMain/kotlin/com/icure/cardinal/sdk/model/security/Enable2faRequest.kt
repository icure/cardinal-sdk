// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

/**
 *
 *  Request payload for enabling two-factor authentication (2FA) for a user account.
 */
@Serializable
data class Enable2faRequest(
	/**
	 * The shared TOTP secret used to generate one-time passwords.
	 */
	public val secret: String,
	/**
	 * The number of digits in each generated one-time password.
	 */
	public val otpLength: Int,
) {
	// region Enable2faRequest-Enable2faRequest

	// endregion
}

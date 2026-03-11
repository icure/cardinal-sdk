package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

/**
 *
 *  Request payload for enabling two-factor authentication (2FA) for a user account.
 */
@Serializable
public data class Enable2faRequest(
	/**
	 * The shared TOTP secret used to generate one-time passwords.
	 */
	public val secret: String,
	/**
	 * The number of digits in each generated one-time password.
	 */
	public val otpLength: Int,
)

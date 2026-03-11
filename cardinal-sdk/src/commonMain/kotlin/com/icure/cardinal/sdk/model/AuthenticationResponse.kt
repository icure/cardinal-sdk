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
public class AuthenticationResponse(
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
)

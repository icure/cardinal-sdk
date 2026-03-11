package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  DTO wrapping a JSON Web Token (JWT) string.
 */
@Serializable
public data class JwtPayload(
	/**
	 * The encoded JWT string.
	 */
	public val jwt: String,
)

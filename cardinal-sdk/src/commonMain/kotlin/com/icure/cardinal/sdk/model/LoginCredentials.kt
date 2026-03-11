package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * DTO containing the credentials for user authentication.
 * /
 */
@Serializable
public data class LoginCredentials(
	/**
	 * The username or login identifier.
	 */
	public val username: String? = null,
	/**
	 * The password for authentication.
	 */
	public val password: String? = null,
)

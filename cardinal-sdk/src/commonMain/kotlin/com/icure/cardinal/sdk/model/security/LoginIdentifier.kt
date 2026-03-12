package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * A structured identifier used to match a user during login, composed of an assigner system and a
 * value within that system.
 * /
 */
@Serializable
public data class LoginIdentifier(
	/**
	 * The system or authority that issued or manages this identifier.
	 */
	public val assigner: String,
	/**
	 * The identifier value within the assigner's namespace.
	 */
	public val `value`: String,
)

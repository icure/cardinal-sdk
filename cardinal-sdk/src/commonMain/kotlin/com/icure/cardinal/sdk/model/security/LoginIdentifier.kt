// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.String

/**
 * A structured identifier used to match a user during login, composed of an assigner system and a
 * value within that system.
 * /
 */
@Serializable
data class LoginIdentifier(
	/**
	 * The system or authority that issued or manages this identifier.
	 */
	public val assigner: String,
	/**
	 * The identifier value within the assigner's namespace.
	 */
	public val `value`: String,
) {
	// region LoginIdentifier-LoginIdentifier

	// endregion
}

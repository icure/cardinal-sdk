// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

/**
 *
 *  DTO wrapping a JSON Web Token (JWT) string.
 */
@Serializable
data class JwtPayload(
	/**
	 * The encoded JWT string.
	 */
	public val jwt: String,
) {
	// region JwtPayload-JwtPayload

	// endregion
}

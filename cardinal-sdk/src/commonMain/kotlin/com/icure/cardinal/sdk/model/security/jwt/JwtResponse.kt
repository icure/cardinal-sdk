package com.icure.cardinal.sdk.model.security.jwt

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class JwtResponse(
	public val token: String? = null,
	public val refreshToken: String? = null,
	@param:DefaultValue("false")
	public val successful: Boolean = false,
) {
	// region JwtResponse-JwtResponse

	// endregion
}

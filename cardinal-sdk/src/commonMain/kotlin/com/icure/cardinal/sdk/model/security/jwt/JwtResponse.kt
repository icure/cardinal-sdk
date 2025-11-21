package com.icure.cardinal.sdk.model.security.jwt

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

@Serializable
public data class JwtResponse(
	public val token: String? = null,
	public val refreshToken: String? = null,
	@DefaultValue("false")
	public val successful: Boolean = false,
)

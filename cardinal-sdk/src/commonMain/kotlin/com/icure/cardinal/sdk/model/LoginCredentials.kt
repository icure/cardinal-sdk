package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class LoginCredentials(
	public val username: String? = null,
	public val password: String? = null,
)

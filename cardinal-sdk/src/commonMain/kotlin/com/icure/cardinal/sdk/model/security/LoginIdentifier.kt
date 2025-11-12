package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class LoginIdentifier(
	public val assigner: String,
	public val `value`: String,
)

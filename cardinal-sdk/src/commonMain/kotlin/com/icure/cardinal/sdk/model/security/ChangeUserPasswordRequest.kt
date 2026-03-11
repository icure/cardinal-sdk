package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class ChangeUserPasswordRequest(
	public val newPassword: String,
)

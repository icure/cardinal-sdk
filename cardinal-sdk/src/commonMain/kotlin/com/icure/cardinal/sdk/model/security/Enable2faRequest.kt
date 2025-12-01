package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.String

@Serializable
public data class Enable2faRequest(
	public val secret: String,
	public val otpLength: Int,
)

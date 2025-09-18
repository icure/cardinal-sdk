package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class RegistrationSuccess(
	public val groupId: String,
	public val userId: String,
	public val token: String,
)

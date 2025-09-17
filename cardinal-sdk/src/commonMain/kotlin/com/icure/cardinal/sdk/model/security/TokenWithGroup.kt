package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class TokenWithGroup(
	public val token: String,
	public val groupId: String,
	public val groupName: String? = null,
)

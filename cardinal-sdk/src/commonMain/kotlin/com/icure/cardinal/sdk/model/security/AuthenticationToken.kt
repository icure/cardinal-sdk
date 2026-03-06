package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

@Serializable
public data class AuthenticationToken(
	public val token: String? = null,
	public val creationTime: Long,
	public val validity: Long,
	public val deletionDate: Long? = null,
)

package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

@Serializable
public data class OperationToken(
	public val tokenHash: String,
	public val creationTime: Long,
	public val validity: Long,
	public val operation: Operation,
	public val description: String? = null,
)

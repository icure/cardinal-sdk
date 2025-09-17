package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class IdWithRev(
	public val id: String,
	public val rev: String? = null,
)

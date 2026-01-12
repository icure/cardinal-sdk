package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

@Serializable
public data class Suspension(
	public val beginMoment: Long? = null,
	public val endMoment: Long? = null,
	public val suspensionReason: String? = null,
	public val lifecycle: String? = null,
)

package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Int

@Serializable
public data class ValueWithPrecision(
	public val `value`: Int,
	public val precision: Int,
)

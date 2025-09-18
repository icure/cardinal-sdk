package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Int

@Serializable
public data class Renewal(
	public val decimal: Int? = null,
	public val duration: Duration? = null,
)

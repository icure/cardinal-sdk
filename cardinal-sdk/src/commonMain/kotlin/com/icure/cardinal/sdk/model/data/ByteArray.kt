package com.icure.cardinal.sdk.model.`data`

import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import kotlinx.serialization.Serializable

@Serializable
public data class ByteArray(
	@Serializable(with = ByteArraySerializer::class)
	public val `data`: kotlin.ByteArray,
)

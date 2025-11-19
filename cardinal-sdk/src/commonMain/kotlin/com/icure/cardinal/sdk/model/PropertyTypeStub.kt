package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.model.embed.TypedValuesType
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class PropertyTypeStub(
	public val identifier: String? = null,
	public val type: TypedValuesType? = null,
)

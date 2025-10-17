package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

@Serializable
public data class Country(
	public val code: String? = null,
	public val name: Map<String, String>? = null,
)

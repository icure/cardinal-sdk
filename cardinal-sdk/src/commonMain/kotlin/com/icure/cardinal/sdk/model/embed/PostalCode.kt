package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

@Serializable
public data class PostalCode(
	public val code: String? = null,
	@DefaultValue("emptyMap()")
	public val label: Map<String, String> = emptyMap(),
)

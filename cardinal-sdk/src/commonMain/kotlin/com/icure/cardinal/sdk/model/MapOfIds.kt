package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

@Serializable
public data class MapOfIds(
	@DefaultValue("emptyMap()")
	public val mapOfIds: Map<String, List<String>> = emptyMap(),
)

package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@Serializable
public data class ListOfIds(
	@DefaultValue("emptyList()")
	public val ids: List<String> = emptyList(),
)

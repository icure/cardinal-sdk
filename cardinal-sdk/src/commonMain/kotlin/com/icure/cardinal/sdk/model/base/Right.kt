package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

@Serializable
public data class Right(
	@DefaultValue("emptySet()")
	public val names: Set<String> = emptySet(),
	@DefaultValue("emptySet()")
	public val roles: Set<String> = emptySet(),
)

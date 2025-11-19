package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable

@Serializable
public data class Security(
	@DefaultValue("Right()")
	public val admins: Right = Right(),
	@DefaultValue("Right()")
	public val members: Right = Right(),
)

package com.icure.cardinal.sdk.model.base

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable

@Serializable
public data class Security(
	@param:DefaultValue("Right()")
	public val admins: Right = Right(),
	@param:DefaultValue("Right()")
	public val members: Right = Right(),
)

package com.icure.cardinal.sdk.model.base

import kotlinx.serialization.Serializable

@Serializable
public data class Security(
	public val admins: Right,
	public val members: Right,
)

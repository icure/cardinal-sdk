package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String

@Serializable
public data class Right(
	public val userId: String? = null,
	@DefaultValue("false")
	public val read: Boolean = false,
	@DefaultValue("false")
	public val write: Boolean = false,
	@DefaultValue("false")
	public val administration: Boolean = false,
)

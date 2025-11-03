package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable
import kotlin.Double

@Serializable
public data class Duration(
	public val `value`: Double? = null,
	public val unit: CodeStub? = null,
)

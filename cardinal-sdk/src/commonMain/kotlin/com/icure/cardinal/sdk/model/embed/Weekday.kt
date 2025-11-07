package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable
import kotlin.Int

@Serializable
public data class Weekday(
	public val weekday: CodeStub? = null,
	public val weekNumber: Int? = null,
)

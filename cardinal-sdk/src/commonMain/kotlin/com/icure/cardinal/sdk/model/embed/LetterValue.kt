package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Double
import kotlin.String

@Serializable
public data class LetterValue(
	public val letter: String? = null,
	public val index: String? = null,
	public val coefficient: Double? = null,
	public val `value`: Double? = null,
)

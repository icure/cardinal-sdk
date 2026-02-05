package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@Serializable
public data class KeywordSubword(
	public val `value`: String? = null,
	public val subWords: List<KeywordSubword>? = null,
)

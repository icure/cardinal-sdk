package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class RevisionInfo(
	public val rev: String? = null,
	public val status: String? = null,
)

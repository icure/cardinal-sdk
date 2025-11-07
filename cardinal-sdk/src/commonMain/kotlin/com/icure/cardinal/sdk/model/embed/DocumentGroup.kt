package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class DocumentGroup(
	public val guid: String? = null,
	public val name: String? = null,
)

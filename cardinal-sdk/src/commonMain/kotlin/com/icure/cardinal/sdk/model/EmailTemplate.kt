package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class EmailTemplate(
	public val subject: String? = null,
	public val body: String? = null,
)

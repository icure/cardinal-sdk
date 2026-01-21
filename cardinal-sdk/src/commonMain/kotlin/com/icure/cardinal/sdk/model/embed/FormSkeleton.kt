package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class FormSkeleton(
	public val descr: String? = null,
	public val formTemplateId: String? = null,
)

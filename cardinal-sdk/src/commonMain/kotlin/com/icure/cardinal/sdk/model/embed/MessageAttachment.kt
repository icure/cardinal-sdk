package com.icure.cardinal.sdk.model.embed

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

@Serializable
public data class MessageAttachment(
	public val type: DocumentLocation? = null,
	@DefaultValue("emptyList()")
	public val ids: List<String> = emptyList(),
)
